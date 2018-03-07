package com.facebook.rtc.fbwebrtc;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Vibrator;
import android.support.v4.app.NotificationManagerCompat;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.android.VibratorMethodAutoProvider;
import com.facebook.common.audio.AudioHardwareInfo;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.hardware.BatteryStateManager.BatteryChangeListener;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecurePendingIntent;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster;
import com.facebook.messaging.chatheads.prefs.ChatHeadsPrefKeys;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.presence.ThreadPresenceManager;
import com.facebook.presence.ThreadPresenceManager.ThreadPresenceCapability;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.ContactFetcherMethodAutoProvider;
import com.facebook.rtc.RtcThreadDataHandlerMethodAutoProvider;
import com.facebook.rtc.VoipNotificationPreferencesMethodAutoProvider;
import com.facebook.rtc.WebrtcCallStatusObserverMethodAutoProvider;
import com.facebook.rtc.WebrtcQRMessageHandlerMethodAutoProvider;
import com.facebook.rtc.activities.RtcZeroRatingActivity;
import com.facebook.rtc.activities.WebrtcIncallActivity;
import com.facebook.rtc.audio.RtcAudioHandler;
import com.facebook.rtc.audio.RtcAudioHandler.Tone;
import com.facebook.rtc.audio.RtcAudioHandlerProvider;
import com.facebook.rtc.campon.RtcCallCamper;
import com.facebook.rtc.campon.RtcCampOnManager;
import com.facebook.rtc.campon.RtcCampOnManager.C22813;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtc.helpers.RtcCallStartParams;
import com.facebook.rtc.interfaces.ContactFetcher;
import com.facebook.rtc.interfaces.DefaultRtcUiCallback;
import com.facebook.rtc.interfaces.IRtcUiCallback;
import com.facebook.rtc.interfaces.RtcThreadDataHandler;
import com.facebook.rtc.interfaces.VoipNotificationPreferences;
import com.facebook.rtc.interfaces.WebrtcCallStatusObserver;
import com.facebook.rtc.interfaces.WebrtcQRMessageHandler;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.models.RtcConferenceParticipantInfo;
import com.facebook.rtc.models.RtcConferenceParticipantInfo.ParticipantCallState;
import com.facebook.rtc.prefs.InternalVoipPrefKeys;
import com.facebook.rtc.prefs.VoipPrefKeys;
import com.facebook.rtc.services.BackgroundVideoCallService;
import com.facebook.rtc.services.BackgroundVideoCallService.RtcCallBinder;
import com.facebook.rtc.videoengine.MediaCodecVideoUtils;
import com.facebook.rtc.voicemail.api.CustomVoicemailInitializer;
import com.facebook.rtcpresence.RtcAbortedCallReasonIds;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.UserKey;
import com.facebook.webrtc.ConferenceCall;
import com.facebook.webrtc.ConferenceCall.Listener;
import com.facebook.webrtc.IWebrtcUiInterface;
import com.facebook.webrtc.IWebrtcUiInterface.AudioOutputRoute;
import com.facebook.webrtc.IWebrtcUiInterface.EndCallReason;
import com.facebook.webrtc.WebrtcManager;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.webrtc.videoengine.VideoCaptureAndroid;
import org.webrtc.videoengine.VideoCaptureDeviceInfoAndroid;

@UserScoped
/* compiled from: auto_focus */
public class WebrtcUiHandler implements Listener, IWebrtcUiInterface {
    private static int bh = 1;
    private static final long[] f19540c = new long[]{0, 800, 1838};
    private static final Object cg = new Object();
    private static final long[] f19541d = new long[]{0, 200};
    private final MonotonicClock f19542A;
    private final DefaultAndroidThreadUtil f19543B;
    private final BaseFbBroadcastManager f19544C;
    private final BaseFbBroadcastManager f19545D;
    private final FacebookOnlyIntentActionFactory f19546E;
    public final Handler f19547F;
    private final FbAppType f19548G;
    private final ContactFetcher f19549H;
    private final Vibrator f19550I;
    private final Provider<Boolean> f19551J;
    private final Provider<Boolean> f19552K;
    private final FbAlarmManagerImpl f19553L;
    private final FbObjectMapper f19554M;
    public final RtcAudioHandler f19555N;
    private final FbZeroFeatureVisibilityHelper f19556O;
    public final SystemBatteryStateManager f19557P;
    private final GatekeeperStoreImpl f19558Q;
    private final List<IRtcUiCallback> f19559R = new ArrayList();
    public ImmutableList<IRtcUiCallback> f19560S = ImmutableList.of();
    private final RtcThreadDataHandler f19561T;
    public final Toaster f19562U;
    public WebrtcManager f19563V;
    private PhoneStateListener f19564W;
    private BatteryChangeListener f19565X;
    private IBinder f19566Y;
    private DeathRecipient f19567Z;
    @Inject
    ChatHeadsBroadcaster f19568a;
    private boolean aA;
    public boolean aB;
    private long aC;
    private String aD;
    public boolean aE;
    private int aF;
    public boolean aG;
    public boolean aH;
    private long aI;
    private long aJ;
    public long aK;
    public long aL;
    public long aM;
    public long aN;
    private int aO;
    public boolean aP;
    public boolean aQ;
    private boolean aR;
    private boolean aS;
    public boolean aT;
    private boolean aU;
    public Method aV = null;
    public boolean aW = false;
    private ServiceConnection aX;
    private boolean aY;
    private boolean aZ;
    private SelfRegistrableReceiverImpl aa;
    private SelfRegistrableReceiverImpl ab;
    public boolean ac;
    public long ad;
    public ConferenceCall ae;
    private Map<String, RtcConferenceParticipantInfo> af;
    public RtcConferenceParticipantInfo ag;
    public boolean ah;
    public long ai;
    public ThreadKey aj;
    public int ak;
    private boolean al;
    public boolean am;
    public boolean an;
    public boolean ao;
    public LocalVideoState ap;
    public boolean aq;
    public int ar;
    public int as;
    private int at;
    private int au;
    public String av;
    public long aw;
    private boolean ax;
    private int ay;
    private int az;
    @Inject
    WebrtcLoggingHandler f19569b;
    private int bA;
    private long bB;
    private long bC;
    private long bD;
    private long bE;
    private long bF;
    private View bG;
    private boolean bH;
    private C23025 bI;
    private String bJ;
    private TriState bK = TriState.UNSET;
    public boolean bL;
    private ScheduledFuture bM;
    public ScheduledFuture bN;
    public boolean bO;
    private TriState bP = TriState.UNSET;
    public boolean bQ = false;
    public boolean bR = false;
    public boolean bS = false;
    public Corner bT = Corner.TOP_LEFT;
    public ConnectionStatus bU = ConnectionStatus.NONE;
    public ConnectionQuality bV = ConnectionQuality.DISCONNECTED;
    private final QuickExperimentController bW;
    private final RtcPresenceHandler bX;
    private VideoDimensions bY;
    private VideoDimensions bZ;
    public boolean ba;
    public boolean bb = false;
    public boolean bc;
    public boolean bd;
    public boolean be;
    public boolean bf;
    private AudioOutput bg;
    public VoipNotificationPreferences bi;
    public EndCallReason bj;
    private String bk;
    private String bl;
    public boolean bm;
    public BackgroundVideoCallService bn;
    public boolean bo = false;
    public boolean bp;
    private boolean bq;
    public boolean br;
    public TriState bs = TriState.UNSET;
    private boolean bt;
    public boolean bu;
    private boolean bv = false;
    public boolean bw = false;
    private boolean bx = false;
    private boolean by = false;
    private final QeAccessor bz;
    private ThreadPresenceManager ca;
    private final CustomVoicemailInitializer cb;
    public final RtcCampOnManager cc;
    public final RuntimePermissionsUtil cd;
    private final List<NameChangedListener> ce = Lists.a();
    public final Runnable cf = new Runnable(this) {
        final /* synthetic */ WebrtcUiHandler f19505a;

        {
            this.f19505a = r1;
        }

        public void run() {
            HandlerDetour.a(this.f19505a.f19547F, this.f19505a.cf);
            WebrtcUiHandler.bJ(this.f19505a);
            if (this.f19505a.aH()) {
                WebrtcUiHandler webrtcUiHandler = this.f19505a;
                if (webrtcUiHandler.bn != null) {
                    BackgroundVideoCallService backgroundVideoCallService = webrtcUiHandler.bn;
                    String O = webrtcUiHandler.m19438O();
                    if (backgroundVideoCallService.f20008w != null) {
                        backgroundVideoCallService.f20008w.m19845a(O);
                    }
                }
            } else {
                WebrtcUiHandler.bK(this.f19505a);
            }
            HandlerDetour.b(this.f19505a.f19547F, this.f19505a.cf, 500, 1668166066);
        }
    };
    private final ActivityManager f19570e;
    public String[] f19571f;
    public final Context f19572g;
    private final ViewerContext f19573h;
    public final SecureContextHelper f19574i;
    private final WebrtcCallStatusObserver f19575j;
    public final MqttPushServiceWrapper f19576k;
    public final WebrtcLoggingHandler f19577l;
    private final WebrtcConfigHandler f19578m;
    public final WebrtcBluetoothManager f19579n;
    public final WebrtcAudioMode f19580o;
    private final FbSharedPreferences f19581p;
    public final IncallWakeLocks f19582q;
    public final WebrtcMqttClientActiveCallback f19583r;
    public final AudioManager f19584s;
    private final AudioHardwareInfo f19585t;
    private final TelephonyManager f19586u;
    public final Executor f19587v;
    private final ExecutorService f19588w;
    public final ScheduledExecutorService f19589x;
    private final WebrtcQRMessageHandler f19590y;
    private final Clock f19591z;

    /* compiled from: auto_focus */
    public interface NameChangedListener {
        void mo804a();
    }

    /* compiled from: auto_focus */
    public class C22981 {
        public final /* synthetic */ WebrtcUiHandler f19439a;

        C22981(WebrtcUiHandler webrtcUiHandler) {
            this.f19439a = webrtcUiHandler;
        }
    }

    /* compiled from: auto_focus */
    class C22992 implements BatteryChangeListener {
        final /* synthetic */ WebrtcUiHandler f19467a;

        C22992(WebrtcUiHandler webrtcUiHandler) {
            this.f19467a = webrtcUiHandler;
        }

        public final void m19390a(Intent intent) {
            WebrtcUiHandler webrtcUiHandler = this.f19467a;
            boolean a = webrtcUiHandler.f19557P.a(5);
            if (webrtcUiHandler.ak != 3 && a) {
                webrtcUiHandler.aW = true;
            }
            if (!webrtcUiHandler.aW && a) {
                ExecutorDetour.a(webrtcUiHandler.f19587v, new Runnable(webrtcUiHandler) {
                    final /* synthetic */ WebrtcUiHandler f19506a;

                    {
                        this.f19506a = r1;
                    }

                    public void run() {
                        this.f19506a.f19555N.m19281a(Tone.LOW_BATTERY);
                    }
                }, 1484861081);
                webrtcUiHandler.aW = true;
            }
        }
    }

    /* compiled from: auto_focus */
    class C23003 implements Runnable {
        final /* synthetic */ WebrtcUiHandler f19487a;

        C23003(WebrtcUiHandler webrtcUiHandler) {
            this.f19487a = webrtcUiHandler;
        }

        public void run() {
            this.f19487a.m19458a(EndCallReason.CallEndNoAnswerTimeout);
            this.f19487a.m19483r();
        }
    }

    /* compiled from: auto_focus */
    public /* synthetic */ class AnonymousClass50 {
        public static final /* synthetic */ int[] f19529b = new int[EndCallReason.values().length];

        static {
            try {
                f19529b[EndCallReason.CallEndHangupCall.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19529b[EndCallReason.CallEndNoAnswerTimeout.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19529b[EndCallReason.CallEndIgnoreCall.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19529b[EndCallReason.CallEndInAnotherCall.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19529b[EndCallReason.CallEndOtherNotCapable.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19529b[EndCallReason.CallEndSignalingMessageFailed.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f19529b[EndCallReason.CallEndUnsupportedVersion.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f19529b[EndCallReason.CallEndOtherCarrierBlocked.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f19529b[EndCallReason.CallEndCarrierBlocked.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f19529b[EndCallReason.CallEndNoPermission.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f19529b[EndCallReason.CallEndCallerNotVisible.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f19529b[EndCallReason.CallEndConnectionDropped.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f19529b[EndCallReason.CallEndClientError.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f19529b[EndCallReason.CallEndClientInterrupted.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f19529b[EndCallReason.CallEndWebRTCError.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f19529b[EndCallReason.CallEndNoUIError.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f19529b[EndCallReason.CallEndAcceptAfterHangUp.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            f19528a = new int[AudioOutput.values().length];
            try {
                f19528a[AudioOutput.BLUETOOTH.ordinal()] = 1;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f19528a[AudioOutput.EARPIECE.ordinal()] = 2;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f19528a[AudioOutput.SPEAKERPHONE.ordinal()] = 3;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f19528a[AudioOutput.HEADSET.ordinal()] = 4;
            } catch (NoSuchFieldError e21) {
            }
        }
    }

    /* compiled from: auto_focus */
    public class C23025 {
        final /* synthetic */ WebrtcUiHandler f19530a;

        C23025(WebrtcUiHandler webrtcUiHandler) {
            this.f19530a = webrtcUiHandler;
        }
    }

    /* compiled from: auto_focus */
    public class C23056 {
        public final /* synthetic */ WebrtcUiHandler f19533a;

        /* compiled from: auto_focus */
        public class C23031 implements Runnable {
            final /* synthetic */ C23056 f19531a;

            public C23031(C23056 c23056) {
                this.f19531a = c23056;
            }

            public void run() {
                if (this.f19531a.f19533a.m19437M() && !this.f19531a.f19533a.be && this.f19531a.f19533a.f19579n.b()) {
                    WebrtcUiHandler.bb(this.f19531a.f19533a);
                    WebrtcUiHandler.bn(this.f19531a.f19533a);
                }
            }
        }

        /* compiled from: auto_focus */
        class C23042 implements Runnable {
            final /* synthetic */ C23056 f19532a;

            C23042(C23056 c23056) {
                this.f19532a = c23056;
            }

            public void run() {
                if (this.f19532a.f19533a.be && this.f19532a.f19533a.aD() && this.f19532a.f19533a.f19579n.b()) {
                    this.f19532a.f19533a.f19577l.a("bluetooth_end", true);
                    this.f19532a.f19533a.m19458a(EndCallReason.CallEndHangupCall);
                }
            }
        }

        C23056(WebrtcUiHandler webrtcUiHandler) {
            this.f19533a = webrtcUiHandler;
        }

        public final void m19391b(int i) {
            if (this.f19533a.be && i == 10 && this.f19533a.aD()) {
                this.f19533a.f19589x.schedule(new C23042(this), 1000, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* compiled from: auto_focus */
    class C23067 implements ActionReceiver {
        final /* synthetic */ WebrtcUiHandler f19534a;

        C23067(WebrtcUiHandler webrtcUiHandler) {
            this.f19534a = webrtcUiHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1751484379);
            if (this.f19534a.aH()) {
                WebrtcUiHandler webrtcUiHandler = this.f19534a;
                if (webrtcUiHandler.bn != null) {
                    webrtcUiHandler.bn.m19700r();
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 684541274, a);
        }
    }

    /* compiled from: auto_focus */
    class C23078 implements ActionReceiver {
        final /* synthetic */ WebrtcUiHandler f19535a;

        C23078(WebrtcUiHandler webrtcUiHandler) {
            this.f19535a = webrtcUiHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 957357925);
            if (this.f19535a.m19437M()) {
                this.f19535a.f19582q.m19357f();
                this.f19535a.f19582q.m19356e();
                this.f19535a.f19577l.d();
                LogUtils.e(-1591939049, a);
                return;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 309199794, a);
        }
    }

    /* compiled from: auto_focus */
    class C23089 implements ActionReceiver {
        final /* synthetic */ WebrtcUiHandler f19536a;

        C23089(WebrtcUiHandler webrtcUiHandler) {
            this.f19536a = webrtcUiHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2067781900);
            if (this.f19536a.m19478k() && this.f19536a.aB && !this.f19536a.bO) {
                this.f19536a.m19458a(EndCallReason.CallEndHangupCall);
                this.f19536a.m19483r();
            }
            if (this.f19536a.ap == LocalVideoState.STARTED) {
                this.f19536a.m19454a(LocalVideoState.PAUSED);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 716211816, a);
        }
    }

    /* compiled from: auto_focus */
    public enum AudioOutput {
        EARPIECE,
        SPEAKERPHONE,
        BLUETOOTH,
        HEADSET
    }

    /* compiled from: auto_focus */
    public enum ConnectionQuality {
        DISCONNECTED,
        POOR,
        FAIR,
        GOOD
    }

    /* compiled from: auto_focus */
    public enum ConnectionStatus {
        NONE,
        NORMAL,
        WEAK_CONNECTION,
        RECONNECTING,
        RECONNECTED,
        WEAK_VIDEO_CONNECTION
    }

    /* compiled from: auto_focus */
    public enum Corner {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT
    }

    /* compiled from: auto_focus */
    public enum LocalVideoState {
        STARTED,
        STOPPED,
        PAUSED
    }

    /* compiled from: auto_focus */
    public class VideoDimensions {
        public int f19537a;
        public int f19538b;
        public int f19539c;

        public VideoDimensions(int i, int i2, int i3) {
            this.f19537a = i;
            this.f19538b = i2;
            this.f19539c = i3;
        }

        public VideoDimensions() {
            this.f19537a = -1;
            this.f19538b = -1;
            this.f19539c = -1;
        }
    }

    private static WebrtcUiHandler m19415b(InjectorLike injectorLike) {
        WebrtcUiHandler webrtcUiHandler = new WebrtcUiHandler(FbAlarmManagerImpl.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), AudioHardwareInfo.m6298a(injectorLike), AudioManagerMethodAutoProvider.a(injectorLike), WebrtcBluetoothManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), WebrtcConfigHandler.a(injectorLike), ContactFetcherMethodAutoProvider.m19085a(injectorLike), (Context) injectorLike.getInstance(Context.class), ViewerContextMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) CrossFbAppBroadcastManager.a(injectorLike), CustomVoicemailInitializer.m19937a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), FbObjectMapperMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), IncallWakeLocks.m19349a(injectorLike), FacebookOnlyIntentActionFactory.a(injectorLike), IdBasedProvider.a(injectorLike, 4299), IdBasedProvider.a(injectorLike, 4300), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), WebrtcLoggingHandler.a(injectorLike), WebrtcQRMessageHandlerMethodAutoProvider.m19092a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), MqttPushServiceWrapper.a(injectorLike), WebrtcMqttClientActiveCallback.a(injectorLike), WebrtcCallStatusObserverMethodAutoProvider.m19091a(injectorLike), (QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), (RtcAudioHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RtcAudioHandlerProvider.class), RtcPresenceHandler.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TelephonyManagerMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), VibratorMethodAutoProvider.a(injectorLike), VoipNotificationPreferencesMethodAutoProvider.m19090a(injectorLike), WebrtcAudioMode.a(injectorLike), RtcCampOnManager.m19310a(injectorLike), RuntimePermissionsUtil.a(injectorLike), FbZeroFeatureVisibilityHelper.a(injectorLike), ThreadPresenceManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ActivityManagerMethodAutoProvider.a(injectorLike), RtcThreadDataHandlerMethodAutoProvider.m19088a(injectorLike), SystemBatteryStateManager.a(injectorLike), Toaster.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
        webrtcUiHandler.m19398a(ChatHeadsBroadcaster.a(injectorLike), WebrtcLoggingHandler.a(injectorLike));
        return webrtcUiHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.rtc.fbwebrtc.WebrtcUiHandler m19394a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = cg;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m19415b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = cg;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = cg;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.WebrtcUiHandler.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.WebrtcUiHandler");
    }

    public final void m19450a(int i, int i2) {
        this.at = i;
        this.au = i2;
        int size = this.f19560S.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i3)).mo783b(i, i2);
        }
    }

    @Inject
    public WebrtcUiHandler(FbAlarmManager fbAlarmManager, AndroidThreadUtil androidThreadUtil, AudioHardwareInfo audioHardwareInfo, AudioManager audioManager, WebrtcBluetoothManager webrtcBluetoothManager, Clock clock, WebrtcConfigHandler webrtcConfigHandler, ContactFetcher contactFetcher, Context context, ViewerContext viewerContext, FbBroadcastManager fbBroadcastManager, CustomVoicemailInitializer customVoicemailInitializer, ExecutorService executorService, FbAppType fbAppType, FbObjectMapper fbObjectMapper, FbSharedPreferences fbSharedPreferences, Handler handler, IncallWakeLocks incallWakeLocks, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, Provider<Boolean> provider, Provider<Boolean> provider2, FbBroadcastManager fbBroadcastManager2, WebrtcLoggingHandler webrtcLoggingHandler, WebrtcQRMessageHandler webrtcQRMessageHandler, MonotonicClock monotonicClock, MqttPushServiceWrapper mqttPushServiceWrapper, WebrtcMqttClientActiveCallback webrtcMqttClientActiveCallback, WebrtcCallStatusObserver webrtcCallStatusObserver, QuickExperimentController quickExperimentController, RtcAudioHandlerProvider rtcAudioHandlerProvider, RtcPresenceHandler rtcPresenceHandler, SecureContextHelper secureContextHelper, TelephonyManager telephonyManager, Executor executor, ScheduledExecutorService scheduledExecutorService, Vibrator vibrator, VoipNotificationPreferences voipNotificationPreferences, WebrtcAudioMode webrtcAudioMode, RtcCampOnManager rtcCampOnManager, RuntimePermissionsUtil runtimePermissionsUtil, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, ThreadPresenceManager threadPresenceManager, QeAccessor qeAccessor, ActivityManager activityManager, RtcThreadDataHandler rtcThreadDataHandler, SystemBatteryStateManager systemBatteryStateManager, Toaster toaster, GatekeeperStore gatekeeperStore) {
        this.f19553L = fbAlarmManager;
        this.f19543B = androidThreadUtil;
        this.f19585t = audioHardwareInfo;
        this.ca = threadPresenceManager;
        this.f19584s = audioManager;
        this.f19579n = webrtcBluetoothManager;
        this.f19591z = clock;
        this.f19578m = webrtcConfigHandler;
        this.f19549H = contactFetcher;
        this.f19572g = context;
        this.f19573h = viewerContext;
        this.f19544C = fbBroadcastManager;
        this.cb = customVoicemailInitializer;
        this.f19588w = executorService;
        this.f19548G = fbAppType;
        this.f19554M = fbObjectMapper;
        this.f19581p = fbSharedPreferences;
        this.f19547F = handler;
        this.f19582q = incallWakeLocks;
        this.f19546E = facebookOnlyIntentActionFactory;
        this.f19551J = provider;
        this.f19552K = provider2;
        this.f19545D = fbBroadcastManager2;
        this.f19577l = webrtcLoggingHandler;
        this.f19590y = webrtcQRMessageHandler;
        this.f19542A = monotonicClock;
        this.f19576k = mqttPushServiceWrapper;
        this.f19583r = webrtcMqttClientActiveCallback;
        this.f19575j = webrtcCallStatusObserver;
        this.bW = quickExperimentController;
        this.f19555N = rtcAudioHandlerProvider.m19287a(new C22981(this));
        this.bX = rtcPresenceHandler;
        this.f19574i = secureContextHelper;
        this.f19586u = telephonyManager;
        this.f19587v = executor;
        this.f19589x = scheduledExecutorService;
        this.f19550I = vibrator;
        this.bi = voipNotificationPreferences;
        this.f19580o = webrtcAudioMode;
        this.f19556O = zeroFeatureVisibilityHelper;
        this.f19557P = systemBatteryStateManager;
        this.ak = 0;
        this.al = false;
        this.bd = false;
        this.be = false;
        this.ap = LocalVideoState.STOPPED;
        this.ao = false;
        this.f19583r.a(m19437M());
        this.cd = runtimePermissionsUtil;
        this.cc = rtcCampOnManager;
        this.bz = qeAccessor;
        this.f19570e = activityManager;
        this.f19571f = new String[]{this.f19572g.getString(2131232078), this.f19572g.getString(2131232079), this.f19572g.getString(2131232080)};
        this.f19561T = rtcThreadDataHandler;
        this.f19562U = toaster;
        this.f19565X = new C22992(this);
        this.f19558Q = gatekeeperStore;
        this.bH = this.bz.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.cs, false);
        this.bQ = this.bz.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.cu, false);
        this.bQ |= this.bz.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.aH, false);
        if (m19480l()) {
            this.ca.a(ThreadPresenceCapability.THREAD_PRESENCE_CAPABILITY_INSTANT_MVP.getValue());
        } else {
            this.ca.a(0);
        }
        VideoCaptureAndroid.m21576a(this);
    }

    private void m19398a(ChatHeadsBroadcaster chatHeadsBroadcaster, WebrtcLoggingHandler webrtcLoggingHandler) {
        this.f19568a = chatHeadsBroadcaster;
        this.f19569b = webrtcLoggingHandler;
    }

    public void setWebrtcManager(WebrtcManager webrtcManager) {
        this.f19563V = webrtcManager;
    }

    public final void m19466b(RtcCallStartParams rtcCallStartParams) {
        if (this.bM != null) {
            this.bM.cancel(true);
            this.bM = null;
        }
        if (rtcCallStartParams.f19786j) {
            this.bM = this.f19589x.schedule(new C23003(this), 15, TimeUnit.SECONDS);
        }
        m19407a(rtcCallStartParams, null);
        this.bP = TriState.UNSET;
        if (!aF() || !rtcCallStartParams.f19786j) {
            aV();
        }
    }

    public final void m19457a(ConferenceCall conferenceCall, RtcCallStartParams rtcCallStartParams, String[] strArr) {
        m19407a(rtcCallStartParams, conferenceCall);
        m19418b(strArr);
        this.aK = aE();
        this.aL = 0;
        aV();
    }

    public final boolean m19470e() {
        return this.ae != null;
    }

    public final boolean m19473g() {
        return this.ae != null && (this.ae.a() || this.ba);
    }

    public final boolean m19475h() {
        return m19470e() && this.bz.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.v, false);
    }

    private Intent m19393a(String str) {
        Intent intent = new Intent(this.f19572g, WebrtcIncallActivity.class);
        intent.setAction(str);
        intent.addFlags(268435456);
        if (!this.bz.a(Liveness.Cached, ExperimentsForRtcModule.da, false)) {
            intent.addFlags(8388608);
        }
        return intent;
    }

    private void aV() {
        this.aK = aE();
        this.aL = 0;
        this.f19574i.a(m19393a("com.facebook.rtc.fbwebrtc.intent.action.SHOW_UI"), this.f19572g);
    }

    public void initializeCall(long j, long j2, boolean z) {
        final boolean z2 = z;
        final long j3 = j;
        final long j4 = j2;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19527d;

            public void run() {
                if (z2) {
                    this.f19527d.ad = j3;
                    return;
                }
                this.f19527d.m19396a(j3, j4, null);
            }
        }, 1788201366);
    }

    private void aW() {
        this.ak = 0;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = false;
        this.ad = 0;
        this.ai = 0;
        this.aj = null;
        this.bs = TriState.UNSET;
        this.bt = false;
        this.bK = TriState.UNSET;
        this.bL = false;
        this.aB = false;
        this.aC = 0;
        this.aD = null;
        this.aE = false;
        this.aG = false;
        this.aP = false;
        this.bJ = null;
        this.aI = 0;
        this.aJ = 0;
        this.aK = 0;
        this.aL = 0;
        this.aM = 0;
        this.aN = 0;
        this.bj = null;
        this.bl = "";
        this.bk = "";
        this.bI = null;
        this.aQ = false;
        this.aR = false;
        this.aO = 0;
        this.aT = false;
        this.bU = ConnectionStatus.NONE;
        this.bV = ConnectionQuality.DISCONNECTED;
        this.am = false;
        this.an = false;
        this.ap = LocalVideoState.STOPPED;
        this.ao = false;
        this.aq = false;
        this.ar = 0;
        this.as = 0;
        this.at = 0;
        this.au = 0;
        this.bY = br();
        this.bZ = new VideoDimensions();
        this.av = null;
        this.aw = 0;
        this.f19577l.D = -1;
        this.ax = false;
        this.ay = -1;
        this.az = -1;
        this.aA = false;
        this.aW = false;
        this.bb = false;
        this.bc = false;
        this.bp = false;
        this.bq = false;
        this.br = false;
        this.bu = false;
        this.bG = null;
        this.aY = false;
        this.bA = 0;
        this.bB = 0;
        this.bC = 0;
        this.bD = 0;
        this.bE = 0;
        this.f19577l.a(-1, 0, 0);
        m19424m(false);
        this.be = false;
        this.bO = false;
        this.aZ = false;
        af();
        this.ba = false;
        this.bv = false;
        this.bw = false;
        this.bR = false;
        this.by = false;
        this.bx = false;
        this.bS = false;
        this.f19571f = new String[]{this.f19572g.getString(2131232078), this.f19572g.getString(2131232079), this.f19572g.getString(2131232080)};
    }

    private void aX() {
        if (this.ai != 0) {
            this.bI = new C23025(this);
        }
    }

    private void aY() {
        Object obj;
        if (this.f19580o.b.checkCallingOrSelfPermission("android.permission.BLUETOOTH") != -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && VERSION.SDK_INT > 16) {
            WebrtcBluetoothManager webrtcBluetoothManager = this.f19579n;
            C23056 c23056 = new C23056(this);
            webrtcBluetoothManager.a();
            webrtcBluetoothManager.e = BluetoothAdapter.getDefaultAdapter();
            if (webrtcBluetoothManager.e == null || !webrtcBluetoothManager.e.isEnabled()) {
                webrtcBluetoothManager.e = null;
            } else {
                webrtcBluetoothManager.e.getProfileProxy(webrtcBluetoothManager.b, new WebrtcBluetoothManager$1(webrtcBluetoothManager), 1);
                webrtcBluetoothManager.d = new WebrtcBluetoothManager$BluetoothReceiver(webrtcBluetoothManager);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                webrtcBluetoothManager.b.registerReceiver(webrtcBluetoothManager.d, intentFilter);
            }
            webrtcBluetoothManager.g = c23056;
        }
    }

    private void m19423l(boolean z) {
        if (this.f19563V != null) {
            this.f19563V.b(!z);
        }
        this.f19555N.f19241j = z;
    }

    private void m19424m(boolean z) {
        m19423l(z);
        m19469e(z);
    }

    public final void m19460a(boolean z) {
        if (this.f19563V != null) {
            this.f19563V.b(true);
        }
        m19469e(z);
        aK();
    }

    private void aZ() {
        boolean z = false;
        this.am = this.f19578m.shouldEnableVideo();
        if (m19473g() || ab()) {
            if (this.am && this.f19558Q.a(1105, false)) {
                z = true;
            }
            this.am = z;
        }
    }

    private void m19407a(RtcCallStartParams rtcCallStartParams, ConferenceCall conferenceCall) {
        aW();
        this.ad = 0;
        this.ai = rtcCallStartParams.f19777a;
        this.bs = TriState.valueOf(rtcCallStartParams.f19782f);
        this.bt = rtcCallStartParams.f19782f;
        this.bK = TriState.valueOf(rtcCallStartParams.f19786j);
        this.aB = true;
        if (rtcCallStartParams.f19789m > 0) {
            this.aC = this.f19591z.a() - rtcCallStartParams.f19789m;
            if (this.aC < 0 || this.aC > 345600000) {
                this.aC = 0;
            }
        } else {
            this.aC = 0;
        }
        this.ae = conferenceCall;
        this.aD = rtcCallStartParams.f19780d;
        this.bJ = rtcCallStartParams.f19785i;
        Object obj = rtcCallStartParams.f19784h;
        if (!StringUtil.a(obj)) {
            this.aj = ThreadKey.a(Long.parseLong(obj));
        }
        aZ();
        ba();
        if (rtcCallStartParams.f19786j) {
            m19423l(true);
        }
    }

    private void m19396a(long j, long j2, ConferenceCall conferenceCall) {
        aW();
        this.ad = j;
        this.ai = j2;
        this.aB = false;
        this.aD = null;
        this.ae = conferenceCall;
        aZ();
        ba();
    }

    private void ba() {
        boolean z = true;
        RtcCampOnManager rtcCampOnManager = this.cc;
        long j = this.ai;
        RtcCallCamper rtcCallCamper = (RtcCallCamper) rtcCampOnManager.f19299t.get(Long.valueOf(j));
        if (rtcCallCamper != null) {
            rtcCampOnManager.f19288i.a(new C22813(rtcCampOnManager, j, rtcCallCamper));
        }
        RtcCallCamper rtcCallCamper2 = (RtcCallCamper) rtcCampOnManager.f19300u.get(Long.valueOf(j));
        if (rtcCallCamper2 != null) {
            rtcCallCamper2.mo814i();
            rtcCampOnManager.f19300u.remove(Long.valueOf(j));
        }
        NotificationManagerCompat a = NotificationManagerCompat.a(this.f19572g);
        a.a(Long.toString(this.ai), 10010);
        a.a("10027", 10027);
        a.a(Long.toString(this.ai), 10025);
        this.aH = false;
        m19422g(1);
        this.bP = TriState.UNSET;
        this.f19583r.a = m19437M();
        this.bj = EndCallReason.CallEndIgnoreCall;
        aX();
        if (au()) {
            bp();
        }
        this.aI = this.f19591z.a();
        this.aJ = aE();
        this.bE = this.aJ;
        this.aF = this.f19584s.getMode();
        bq();
        aY();
        AudioHardwareInfo audioHardwareInfo = this.f19585t;
        boolean z2 = false;
        if (!audioHardwareInfo.f5967c && (!audioHardwareInfo.f5965a || audioHardwareInfo.f5966b)) {
            z2 = true;
        }
        this.bf = z2;
        boolean z3 = ((Boolean) this.f19551J.get()).booleanValue() || !this.bf;
        this.bo = z3;
        this.bd = this.bo;
        this.bc = this.f19584s.isWiredHeadsetOn();
        this.f19584s.setSpeakerphoneOn(this.bd);
        this.f19584s.setMicrophoneMute(this.al);
        bn(this);
        bg();
        if (au()) {
            aK();
        }
        if (this.aB || !this.f19556O.a(ZeroFeatureKey.VOIP_INCOMING_CALL_INTERSTITIAL) || this.bz.a(Liveness.Cached, ExperimentsForRtcModule.cZ, false)) {
            bd();
        }
        this.cb.m19938a(this.ai);
        bB();
        if (m19473g()) {
            if (this.bz.a(ExperimentsForRtcModule.az, 0) <= 0) {
                z = false;
            }
            this.by = z;
            return;
        }
        if (this.bz.a(ExperimentsForRtcModule.ac, 0) <= 0) {
            z = false;
        }
        this.bx = z;
    }

    public static void bb(WebrtcUiHandler webrtcUiHandler) {
        if (webrtcUiHandler.f19563V != null) {
            webrtcUiHandler.f19563V.c(true);
        }
        webrtcUiHandler.be = webrtcUiHandler.f19579n.a(true);
        webrtcUiHandler.f19577l.logCallAction(webrtcUiHandler.ad, webrtcUiHandler.ai, "bluetooth", "on");
    }

    public static void bc(WebrtcUiHandler webrtcUiHandler) {
        if (webrtcUiHandler.f19563V != null) {
            webrtcUiHandler.f19563V.c(false);
        }
        webrtcUiHandler.be = webrtcUiHandler.f19579n.a(false);
        webrtcUiHandler.f19577l.logCallAction(webrtcUiHandler.ad, webrtcUiHandler.ai, "bluetooth", "off");
    }

    private void bd() {
        if (!m19478k()) {
            boolean z = m19441R() || this.aB || VERSION.SDK_INT < 21;
            if (z) {
                Intent intent = new Intent(this.f19572g, WebrtcIncallNotificationService.class);
                if (m19473g()) {
                    intent.putExtra("CONTACT_NAME", ak());
                } else {
                    intent.putExtra("CONTACT_NAME", this.bl);
                }
                this.f19572g.startService(intent);
                this.aS = true;
            }
        }
    }

    private void be() {
        if (this.aS) {
            this.f19572g.stopService(new Intent(this.f19572g, WebrtcIncallNotificationService.class));
            this.aS = false;
        }
    }

    public final boolean m19478k() {
        BLog.a("WebrtcUiHandler", "isInstantVideo %b", new Object[]{Boolean.valueOf(this.bK.asBoolean(false))});
        return this.bK.asBoolean(false);
    }

    private boolean bf() {
        return m19480l();
    }

    public final boolean m19480l() {
        if (aF()) {
            return this.bz.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.aF, false);
        }
        return false;
    }

    public final void m19481n() {
        this.bL = true;
    }

    public final void m19468b(boolean z) {
        m19481n();
        if (this.bn != null && z) {
            m19460a(false);
            aO();
        }
    }

    private void bg() {
        bm();
        this.ab = this.f19545D.a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C23078(this)).a("com.facebook.rtc.fbwebrtc.RTC_VIDEO_CHAT_HEAD_SHRINK_BY_USER_INTERACTION", new C23067(this)).a();
        this.ab.b();
        this.aa = this.f19544C.a().a("android.intent.action.HEADSET_PLUG", new ActionReceiver(this) {
            final /* synthetic */ WebrtcUiHandler f19429a;

            {
                this.f19429a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                boolean z = false;
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1618092054);
                if (this.f19429a.m19437M()) {
                    AudioOutputRoute c;
                    WebrtcUiHandler webrtcUiHandler = this.f19429a;
                    if (intent.getIntExtra("state", 0) > 0) {
                        z = true;
                    }
                    webrtcUiHandler.bc = z;
                    if (this.f19429a.bc) {
                        this.f19429a.bb = this.f19429a.bd;
                    } else {
                        if (this.f19429a.ar()) {
                            this.f19429a.m19453a(AudioOutput.BLUETOOTH);
                        } else if (this.f19429a.bb || this.f19429a.bo) {
                            this.f19429a.m19453a(AudioOutput.SPEAKERPHONE);
                        }
                        WebrtcUiHandler.bK(this.f19429a);
                        c = this.f19429a.f19580o.c();
                        if (c == AudioOutputRoute.AudioOutputRouteEarpiece && this.f19429a.bc) {
                            c = AudioOutputRoute.AudioOutputRouteHeadset;
                        }
                        if (this.f19429a.f19563V != null) {
                            this.f19429a.f19563V.a(c);
                        }
                        LogUtils.e(-1788925172, a);
                        return;
                    }
                    this.f19429a.m19453a(AudioOutput.EARPIECE);
                    WebrtcUiHandler.bK(this.f19429a);
                    c = this.f19429a.f19580o.c();
                    c = AudioOutputRoute.AudioOutputRouteHeadset;
                    if (this.f19429a.f19563V != null) {
                        this.f19429a.f19563V.a(c);
                    }
                    LogUtils.e(-1788925172, a);
                    return;
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 77660162, a);
            }
        }).a("android.intent.action.SCREEN_ON", new ActionReceiver(this) {
            final /* synthetic */ WebrtcUiHandler f19428a;

            {
                this.f19428a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1566964407);
                if (this.f19428a.ap == LocalVideoState.PAUSED && !this.f19428a.ao) {
                    this.f19428a.m19454a(LocalVideoState.STARTED);
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -768845362, a);
            }
        }).a("android.intent.action.SCREEN_OFF", new C23089(this)).a();
        this.aa.b();
        bk();
    }

    private static IBinder bh() {
        try {
            return (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"media.audio_flinger"});
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (InvocationTargetException e4) {
        }
        return null;
    }

    public static void bj(WebrtcUiHandler webrtcUiHandler) {
        BLog.a("WebrtcUiHandler", "media server is dead");
        webrtcUiHandler.f19577l.a("Audio service is dead");
        webrtcUiHandler.bl();
        if (!webrtcUiHandler.m19437M()) {
        }
    }

    private void bk() {
        bl();
        this.f19566Y = bh();
        if (this.f19566Y != null) {
            this.f19567Z = new DeathRecipient(this) {
                final /* synthetic */ WebrtcUiHandler f19431a;

                {
                    this.f19431a = r1;
                }

                public void binderDied() {
                    WebrtcUiHandler webrtcUiHandler = this.f19431a;
                    ExecutorDetour.a(webrtcUiHandler.f19587v, new Runnable(webrtcUiHandler) {
                        final /* synthetic */ WebrtcUiHandler f19430a;

                        {
                            this.f19430a = r1;
                        }

                        public void run() {
                            WebrtcUiHandler.bj(this.f19430a);
                        }
                    }, 103313988);
                }
            };
            try {
                this.f19566Y.linkToDeath(this.f19567Z, 0);
            } catch (Throwable e) {
                BLog.a("WebrtcUiHandler", "audio service is not available", e);
                this.f19566Y = null;
                this.f19567Z = null;
            }
        }
    }

    private void bl() {
        if (this.f19566Y != null) {
            try {
                this.f19566Y.unlinkToDeath(this.f19567Z, 0);
            } catch (Throwable e) {
                BLog.a("WebrtcUiHandler", "failed to unlinkToDeath", e);
            }
            this.f19566Y = null;
            this.f19567Z = null;
        }
    }

    private void bm() {
        if (this.ab != null) {
            this.ab.c();
            this.ab = null;
        }
        if (this.aa != null) {
            this.aa.c();
            this.aa = null;
        }
        bl();
    }

    public final void m19482q() {
        this.f19589x.schedule(new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19432a;

            {
                this.f19432a = r1;
            }

            public void run() {
                this.f19432a.m19409a(EndCallReason.CallEndHangupCall, 0, false, "");
            }
        }, 1500, TimeUnit.MILLISECONDS);
    }

    public final void m19483r() {
        m19409a(EndCallReason.CallEndHangupCall, 0, false, "");
    }

    public final boolean m19484u() {
        return this.f19584s.isMicrophoneMute() || this.al;
    }

    public static void bn(WebrtcUiHandler webrtcUiHandler) {
        if (webrtcUiHandler.be) {
            webrtcUiHandler.bg = AudioOutput.BLUETOOTH;
        } else if (webrtcUiHandler.bd) {
            webrtcUiHandler.bg = AudioOutput.SPEAKERPHONE;
        } else if (webrtcUiHandler.bc) {
            webrtcUiHandler.bg = AudioOutput.HEADSET;
        } else {
            webrtcUiHandler.bg = AudioOutput.EARPIECE;
        }
        if (webrtcUiHandler.f19563V != null) {
            webrtcUiHandler.f19563V.a(webrtcUiHandler.f19580o.c());
        }
    }

    public final boolean m19485w() {
        return this.bg == AudioOutput.BLUETOOTH;
    }

    public final boolean m19486x() {
        return this.bg == AudioOutput.SPEAKERPHONE;
    }

    private void m19408a(ConferenceCall conferenceCall, long[] jArr, String[] strArr, String[] strArr2, int[] iArr, boolean[] zArr) {
        if (!this.am || !m19470e()) {
            return;
        }
        int i;
        if (!conferenceCall.a()) {
            boolean z;
            Object obj;
            int size;
            boolean z2 = this.aq;
            int i2 = 0;
            while (i2 < jArr.length) {
                if (iArr[i2] == 1 && (this.aw == 0 || this.aw == jArr[i2])) {
                    if (this.aw == 0) {
                        this.aw = jArr[i2];
                        this.an = true;
                        this.av = strArr2[i2];
                    }
                    z = zArr[i2];
                    obj = 1;
                    if (obj == null) {
                    }
                    if (z) {
                        this.aq = false;
                        m19464b(null);
                        if (this.bs.asBoolean(false)) {
                            size = this.f19560S.size();
                            for (i = 0; i < size; i++) {
                                ((DefaultRtcUiCallback) this.f19560S.get(i)).mo796l();
                            }
                            return;
                        } else if (z2 && this.bq) {
                            m19428q(this, false);
                            return;
                        } else if (z2 || this.bq) {
                            BLog.a("WebrtcUiHandler", "Unexpected state transition: isPreviousOn: %b, mRequestingVideo: %b", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(this.bq)});
                            return;
                        } else {
                            m19427p(this, false);
                            return;
                        }
                    }
                    this.aq = true;
                    this.bO = true;
                    if (this.bG != null) {
                        this.f19563V.a(this.aw, this.bG);
                    }
                    if (this.bs.asBoolean(false)) {
                        size = this.f19560S.size();
                        for (i = 0; i < size; i++) {
                            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo795k();
                        }
                    } else if (this.bq) {
                        m19427p(this, true);
                    } else {
                        m19428q(this, true);
                    }
                }
                i2++;
            }
            obj = null;
            z = false;
            if (obj == null) {
                if (z) {
                    this.aq = false;
                    m19464b(null);
                    if (this.bs.asBoolean(false)) {
                        size = this.f19560S.size();
                        for (i = 0; i < size; i++) {
                            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo796l();
                        }
                        return;
                    }
                    if (z2) {
                    }
                    if (z2) {
                    }
                    BLog.a("WebrtcUiHandler", "Unexpected state transition: isPreviousOn: %b, mRequestingVideo: %b", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(this.bq)});
                    return;
                }
                this.aq = true;
                this.bO = true;
                if (this.bG != null) {
                    this.f19563V.a(this.aw, this.bG);
                }
                if (this.bs.asBoolean(false)) {
                    size = this.f19560S.size();
                    for (i = 0; i < size; i++) {
                        ((DefaultRtcUiCallback) this.f19560S.get(i)).mo795k();
                    }
                } else if (this.bq) {
                    m19427p(this, true);
                } else {
                    m19428q(this, true);
                }
            }
        } else if (this.af != null) {
            boolean z3 = false;
            for (i = 0; i < jArr.length; i++) {
                RtcConferenceParticipantInfo rtcConferenceParticipantInfo = (RtcConferenceParticipantInfo) this.af.get(strArr[i]);
                if (rtcConferenceParticipantInfo != null) {
                    if (iArr[i] == 1) {
                        z3 = zArr[i];
                        if (z3 && !rtcConferenceParticipantInfo.f19840h) {
                            rtcConferenceParticipantInfo.f19837e = this.f19591z.a();
                        }
                        if (!z3) {
                            rtcConferenceParticipantInfo.f19837e = 0;
                        }
                        rtcConferenceParticipantInfo.f19839g = jArr[i];
                        rtcConferenceParticipantInfo.f19838f = strArr2[i];
                        rtcConferenceParticipantInfo.f19840h = z3;
                        z3 = true;
                    } else if (iArr[i] == 0) {
                        rtcConferenceParticipantInfo.f19841i = zArr[i];
                    }
                }
            }
            int size2 = this.f19560S.size();
            for (i = 0; i < size2; i++) {
                ((DefaultRtcUiCallback) this.f19560S.get(i)).mo788d(z3);
            }
        }
    }

    public final boolean m19431B() {
        return this.am && this.ay >= 0 && this.az >= 0 && this.ay != this.az;
    }

    public final boolean m19433D() {
        return this.am && this.ap == LocalVideoState.STARTED;
    }

    final void m19474h(boolean z) {
        Boolean.valueOf(this.am);
        Boolean.valueOf(z);
        if (this.am) {
            this.an = z;
            int size = this.f19560S.size();
            for (int i = 0; i < size; i++) {
                ((DefaultRtcUiCallback) this.f19560S.get(i)).mo794j();
            }
            bT();
        }
    }

    public final boolean m19487z() {
        return this.am && this.an;
    }

    public final void m19432C() {
        if (m19431B()) {
            this.aA = !this.aA;
            if (az() || m19433D()) {
                m19454a(LocalVideoState.STARTED);
            }
        }
    }

    public final boolean m19434F() {
        return this.ap == LocalVideoState.PAUSED;
    }

    public final boolean m19435G() {
        return m19487z() && this.aq;
    }

    public final float m19448a(float f) {
        if (this.at <= 0 || this.au <= 0) {
            return f;
        }
        return ((float) Math.max(this.at, this.au)) / ((float) Math.min(this.at, this.au));
    }

    public final void m19469e(boolean z) {
        boolean z2 = true;
        if (this.al) {
            this.bD += aE() - this.bF;
        }
        if (z) {
            this.bF = aE();
        }
        this.al = z;
        if (!z && this.f19584s.isMicrophoneMute()) {
            this.f19584s.setMicrophoneMute(false);
        } else if (z && !this.f19584s.isMicrophoneMute()) {
            this.f19584s.setMicrophoneMute(true);
        }
        if (m19470e()) {
            ConferenceCall conferenceCall = this.ae;
            if (this.al) {
                z2 = false;
            }
            conferenceCall.configureAudio(z2);
        } else if (this.f19563V != null) {
            WebrtcManager webrtcManager = this.f19563V;
            if (this.al) {
                z2 = false;
            }
            if (webrtcManager.a()) {
                webrtcManager.w.setAudioOn(z2);
            }
        }
    }

    public final void m19453a(AudioOutput audioOutput) {
        m19416b(3);
        switch (audioOutput) {
            case BLUETOOTH:
                if (this.f19579n.b() && !this.f19579n.h) {
                    bb(this);
                    break;
                }
            case EARPIECE:
                if (this.bc || !this.bo) {
                    bo();
                    this.f19584s.setSpeakerphoneOn(false);
                    this.bd = false;
                    break;
                }
                return;
            case SPEAKERPHONE:
                bo();
                this.f19584s.setSpeakerphoneOn(true);
                this.bd = true;
                break;
            case HEADSET:
                bo();
                this.f19584s.setSpeakerphoneOn(false);
                this.bd = false;
                break;
        }
        bn(this);
    }

    private void bo() {
        if (this.f19579n.h) {
            bc(this);
        }
    }

    private int bp() {
        if (!this.ax) {
            VideoCaptureDeviceInfoAndroid.m21596c();
            this.ay = VideoCaptureDeviceInfoAndroid.f21167c;
            this.az = VideoCaptureDeviceInfoAndroid.f21168d;
            if (this.ay < 0) {
                this.ay = this.az;
            }
            if (this.az < 0) {
                this.az = this.ay;
            }
            this.ax = true;
        }
        return this.aA ? this.az : this.ay;
    }

    public final String m19436L() {
        return VideoCaptureDeviceInfoAndroid.m21595b(bp());
    }

    public final void m19471f(boolean z) {
        int i = this.bZ.f19537a;
        int i2 = this.bZ.f19538b;
        if (z) {
            this.bZ.f19537a = this.bz.a(ExperimentsForRtcModule.ar, -1);
            this.bZ.f19538b = this.bz.a(ExperimentsForRtcModule.aq, -1);
        } else {
            this.bZ.f19537a = -1;
            this.bZ.f19538b = -1;
        }
        if (i != this.bZ.f19537a && i2 != this.bZ.f19538b) {
            bq();
        }
    }

    private void bq() {
        if (this.f19563V != null) {
            this.f19563V.a(this.bY.f19537a, this.bY.f19538b, this.bY.f19539c, this.bZ.f19537a, this.bZ.f19538b, this.bZ.f19539c);
        }
    }

    public final void m19454a(LocalVideoState localVideoState) {
        boolean z = true;
        if (this.ap != localVideoState || localVideoState == LocalVideoState.STARTED) {
            boolean z2;
            VideoCaptureDeviceInfoAndroid.f21170f = ((Boolean) this.f19552K.get()).booleanValue();
            int bp = bp();
            Integer.valueOf(bp);
            Boolean.valueOf(this.ap == LocalVideoState.STARTED);
            if (localVideoState == LocalVideoState.STARTED) {
                z2 = true;
            } else {
                z2 = false;
            }
            Boolean.valueOf(z2);
            if (localVideoState != LocalVideoState.STARTED || bp >= 0) {
                LocalVideoState localVideoState2 = this.ap;
                this.ap = localVideoState;
                this.f19577l.a(bp, this.bY.f19537a, this.bY.f19538b);
                if (m19470e()) {
                    this.ae.setCameraId(m19436L());
                    if (localVideoState2 != localVideoState) {
                        ConferenceCall conferenceCall = this.ae;
                        if (localVideoState != LocalVideoState.STARTED) {
                            z = false;
                        }
                        conferenceCall.configureVideo(z);
                    }
                } else if ((as() || localVideoState == LocalVideoState.STARTED) && this.f19563V != null) {
                    WebrtcManager webrtcManager = this.f19563V;
                    String L = m19436L();
                    if (webrtcManager.a()) {
                        webrtcManager.w.setCameraId(L);
                    }
                    if (localVideoState2 != localVideoState) {
                        WebrtcManager webrtcManager2 = this.f19563V;
                        if (localVideoState != LocalVideoState.STARTED) {
                            z = false;
                        }
                        if (webrtcManager2.a()) {
                            webrtcManager2.w.setVideoOn(z);
                        }
                    }
                }
                bT();
                return;
            }
            BLog.b("WebrtcUiHandler", "failed to find capable camera to turn on video");
        }
    }

    private int m19392a(PrefKey prefKey, int i) {
        Object a = this.f19581p.a(prefKey, null);
        return StringUtil.a(a) ? i : Integer.parseInt(a);
    }

    private VideoDimensions br() {
        int a = m19392a(InternalVoipPrefKeys.R, 0);
        int a2 = m19392a(InternalVoipPrefKeys.S, 0);
        if (a <= 0 || a2 <= 0) {
            a = 640;
            a2 = 384;
        }
        return new VideoDimensions(a, a2, -1);
    }

    public final boolean m19437M() {
        return this.ak != 0 || this.ac;
    }

    public final boolean aD() {
        return this.ak != 0;
    }

    public final boolean aL() {
        return this.ak == 2;
    }

    private long bs() {
        if (m19440Q()) {
            return aE() - this.aM;
        }
        return 0;
    }

    public final void m19463b(Context context) {
        this.f19562U.a(new ToastBuilder(context.getResources().getString(2131231984, new Object[]{aj()})));
    }

    public final String m19438O() {
        if (bs() / 1000 < 3600) {
            return this.f19572g.getString(2131232018, new Object[]{Long.valueOf(r0 / 60), Long.valueOf(r0 % 60)});
        }
        return this.f19572g.getString(2131232019, new Object[]{Long.valueOf(r0 / 3600), Long.valueOf((r0 % 3600) / 60), Long.valueOf(r0 % 60)});
    }

    public final boolean m19439P() {
        return this.aB;
    }

    public final boolean m19440Q() {
        return this.ak == 3 && m19442S();
    }

    public final boolean m19441R() {
        return this.ak == 3;
    }

    public final boolean m19442S() {
        return this.aM > 0;
    }

    public final void m19456a(DefaultRtcUiCallback defaultRtcUiCallback) {
        this.f19543B.a();
        synchronized (this.f19559R) {
            this.f19559R.add(defaultRtcUiCallback);
            Collections.sort(this.f19559R, new Comparator<IRtcUiCallback>(this) {
                final /* synthetic */ WebrtcUiHandler f19433a;

                {
                    this.f19433a = r1;
                }

                public int compare(Object obj, Object obj2) {
                    return ((DefaultRtcUiCallback) obj).mo802r() - ((DefaultRtcUiCallback) obj2).mo802r();
                }
            });
            this.f19560S = ImmutableList.copyOf(this.f19559R);
        }
    }

    public final void m19467b(DefaultRtcUiCallback defaultRtcUiCallback) {
        this.f19543B.a();
        synchronized (this.f19559R) {
            this.f19559R.remove(defaultRtcUiCallback);
            this.f19560S = ImmutableList.copyOf(this.f19559R);
        }
    }

    public final void m19443T() {
        if (!m19437M()) {
            synchronized (this) {
                if (m19437M()) {
                    return;
                }
                this.f19583r.a(true);
                this.f19582q.m19356e();
                this.f19582q.m19354c();
                this.ac = true;
                this.f19589x.schedule(new Runnable(this) {
                    final /* synthetic */ WebrtcUiHandler f19434a;

                    {
                        this.f19434a = r1;
                    }

                    public void run() {
                        boolean z = this.f19434a.ak != 0;
                        this.f19434a.f19583r.a = z;
                        if (!z) {
                            WebrtcUiHandler.bu(this.f19434a);
                        }
                        this.f19434a.ac = false;
                    }
                }, 4000, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void bt() {
        this.f19582q.m19356e();
        this.f19582q.m19354c();
    }

    public static void bu(WebrtcUiHandler webrtcUiHandler) {
        webrtcUiHandler.f19582q.m19357f();
        webrtcUiHandler.f19582q.m19353b();
        webrtcUiHandler.f19582q.m19355d();
    }

    public final void m19444U() {
        this.f19582q.m19352a();
    }

    public final boolean m19445W() {
        return this.f19582q.f19359b.isScreenOn();
    }

    private void bv() {
        int ringerMode = this.f19584s.getRingerMode();
        int i = (m19413a(this.ai, this.f19578m.getUserId()) || m19478k()) ? 1 : 0;
        if (ringerMode != 1 && (ringerMode != 2 || i == 0)) {
            return;
        }
        if (m19478k()) {
            this.f19550I.vibrate(f19541d, -1);
        } else {
            this.f19550I.vibrate(f19540c, 0);
        }
    }

    public static void bw(WebrtcUiHandler webrtcUiHandler) {
        webrtcUiHandler.f19550I.cancel();
    }

    public final void m19446X() {
        this.f19555N.m19286f();
        bw(this);
    }

    private void m19416b(int i) {
        try {
            this.f19584s.setMode(i);
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bx() {
        /*
        r10 = this;
        r2 = 0;
        r0 = r10.be;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = r10.f19580o;
        r9 = 11;
        r6 = 3;
        r3 = -1;
        r5 = 2;
        r4 = r0.a();
        if (r4 != 0) goto L_0x0074;
    L_0x0013:
        r0 = r3;
        if (r0 < 0) goto L_0x0032;
    L_0x0016:
        r10.m19416b(r0);
        r1 = r10.f19584s;
        r1 = r1.getMode();
        if (r1 == r0) goto L_0x002c;
    L_0x0021:
        r0 = r10.f19577l;
        r1 = r10.f19580o;
        r1 = r1.a();
        r0.a(r1);
    L_0x002c:
        r0 = r10.f19577l;
        r0.a();
        goto L_0x0005;
    L_0x0032:
        r0 = r10.f19584s;
        r0 = r0.isSpeakerphoneOn();
        r1 = r10.bd;
        if (r0 == r1) goto L_0x0041;
    L_0x003c:
        r0 = r10.bd;
        java.lang.Boolean.valueOf(r0);
    L_0x0041:
        r0 = r10.f19584s;
        r1 = r10.bd;
        r0.setSpeakerphoneOn(r1);
        bn(r10);
        r0 = r10.bd;
        if (r0 == 0) goto L_0x005e;
    L_0x004f:
        r0 = r10.f19563V;
        if (r0 == 0) goto L_0x005e;
    L_0x0053:
        r0 = r10.f19563V;
        r1 = r10.f19580o;
        r1 = r1.c();
        r0.a(r1);
    L_0x005e:
        r0 = r10.f19584s;
        r0 = r0.isMicrophoneMute();
        if (r0 == 0) goto L_0x0069;
    L_0x0066:
        java.lang.Boolean.valueOf(r2);
    L_0x0069:
        r0 = r10.f19584s;
        r0.setMicrophoneMute(r2);
        r0 = r10.f19577l;
        r0.a();
        goto L_0x0005;
    L_0x0074:
        r4 = r0.e;
        r7 = com.facebook.rtc.prefs.InternalVoipPrefKeys.b;
        r8 = "-1";
        r4 = r4.a(r7, r8);
        r4 = java.lang.Integer.parseInt(r4);
        r7 = -2;
        if (r4 != r7) goto L_0x00a9;
    L_0x0085:
        r4 = r0.e;
        r7 = com.facebook.rtc.prefs.InternalVoipPrefKeys.d;
        r3 = r4.a(r7, r3);
        r4 = android.os.Build.VERSION.SDK_INT;
        if (r4 < r9) goto L_0x00a7;
    L_0x0091:
        r4 = r6;
    L_0x0092:
        if (r3 < 0) goto L_0x0096;
    L_0x0094:
        if (r3 <= r4) goto L_0x0013;
    L_0x0096:
        r3 = r0.f;
        r3 = r3.get();
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x00ae;
    L_0x00a4:
        r3 = 0;
        goto L_0x0013;
    L_0x00a7:
        r4 = r5;
        goto L_0x0092;
    L_0x00a9:
        if (r4 < 0) goto L_0x0096;
    L_0x00ab:
        r3 = r4;
        goto L_0x0013;
    L_0x00ae:
        r3 = r0.g;
        r3 = r3.get();
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x00bf;
    L_0x00bc:
        r3 = r5;
        goto L_0x0013;
    L_0x00bf:
        r3 = android.os.Build.VERSION.SDK_INT;
        if (r3 >= r9) goto L_0x00c6;
    L_0x00c3:
        r3 = r5;
        goto L_0x0013;
    L_0x00c6:
        r3 = r6;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.WebrtcUiHandler.bx():void");
    }

    private void m19395a(long j) {
        boolean z = true;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("event_name", "call_record");
        objectNode.a("msg_id", StringFormatUtil.formatStrLocaleSafe("%d:%d", Long.valueOf(this.f19591z.a()), Long.valueOf(j)));
        objectNode.a("call_id", j);
        objectNode.a("to", Long.toString(this.ai));
        objectNode.a("call_start_time", this.aI);
        String str = "call_duration";
        long j2 = 0;
        if (!(this.aN == 0 || this.aM == 0)) {
            j2 = this.aN - this.aM;
        }
        objectNode.a(str, j2 / 1000);
        if (m19442S()) {
            objectNode.a("call_type", 2);
        } else {
            objectNode.a("call_type", 3);
        }
        if (as()) {
            objectNode.a("event_type", 2);
        } else {
            objectNode.a("event_type", 1);
        }
        if (!(m19442S() || aq() == EndCallReason.CallEndIgnoreCall)) {
            z = false;
        }
        objectNode.a("call_acknowledged", z);
        final ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
        objectNode2.a("payload", objectNode.toString());
        ExecutorDetour.a(this.f19588w, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19436b;

            public void run() {
                this.f19436b.f19576k.a("/send_chat_event", objectNode2, MqttQOSLevel.FIRE_AND_FORGET, null);
            }
        }, -597348744);
    }

    public void webRTCControlRPC_StartOutgoingCall(long j, boolean z) {
        this.f19577l.a("rpc_server", 0);
        Intent intent = new Intent(this.f19546E.a("RTC_START_CALL_ACTION"));
        intent.putExtra("CONTACT_ID", j);
        intent.putExtra("trigger", "rpc_server");
        intent.putExtra("IS_VIDEO_CALL", z);
        this.f19572g.sendBroadcast(intent);
    }

    public void webRTCControlRPC_AcceptIncomingCall(long j) {
        int size = this.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo775a();
        }
    }

    public void forceStarRating() {
        this.aU = true;
        int size = this.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo782b();
        }
    }

    public void webRTCControlRPC_EnableVideo() {
        this.bs = TriState.YES;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19437a;

            {
                this.f19437a = r1;
            }

            public void run() {
                int size = this.f19437a.f19560S.size();
                for (int i = 0; i < size; i++) {
                    ((DefaultRtcUiCallback) this.f19437a.f19560S.get(i)).mo785c();
                }
            }
        }, -346013868);
    }

    public void webRTCControlRPC_DisableVideo() {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19438a;

            {
                this.f19438a = r1;
            }

            public void run() {
                int size = this.f19438a.f19560S.size();
                for (int i = 0; i < size; i++) {
                    ((DefaultRtcUiCallback) this.f19438a.f19560S.get(i)).mo787d();
                }
            }
        }, 721493876);
    }

    public void webRTCControlRPC_ToggleSpeakerPhone() {
        int size = this.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo789e();
        }
    }

    public void webRTCControlRPC_VolumeUp() {
        int size = this.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo790f();
        }
    }

    public void webRTCControlRPC_VolumeDown() {
        int size = this.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo791g();
        }
    }

    public void handleError(int i) {
        BLog.a("WebrtcUiHandler", "Handle error=%d", new Object[]{Integer.valueOf(i)});
        m19446X();
    }

    public void switchToContactingUI() {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19440a;

            {
                this.f19440a = r1;
            }

            public void run() {
                WebrtcUiHandler.by(this.f19440a);
            }
        }, 2086872447);
    }

    public static void by(WebrtcUiHandler webrtcUiHandler) {
        webrtcUiHandler.aZ = true;
        if (webrtcUiHandler.m19473g()) {
            webrtcUiHandler.f19555N.m19281a(Tone.RINGBACK);
        } else {
            webrtcUiHandler.f19555N.m19284c();
        }
        webrtcUiHandler.bU();
    }

    public void switchToRingingUI() {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19441a;

            {
                this.f19441a = r1;
            }

            public void run() {
                WebrtcUiHandler.bz(this.f19441a);
            }
        }, 226903072);
    }

    public static void bz(WebrtcUiHandler webrtcUiHandler) {
        webrtcUiHandler.bt();
        webrtcUiHandler.aZ = false;
        if (!webrtcUiHandler.m19478k()) {
            webrtcUiHandler.aT = true;
            webrtcUiHandler.f19555N.m19283b();
            webrtcUiHandler.f19555N.m19281a(Tone.RINGBACK);
            webrtcUiHandler.aE = true;
            webrtcUiHandler.bU();
        }
    }

    public void switchToIncomingCallUI(long j, long j2, boolean z, boolean z2, String str) {
        final long j3 = j;
        final long j4 = j2;
        final boolean z3 = z;
        final boolean z4 = z2;
        final String str2 = str;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19447f;

            public void run() {
                this.f19447f.m19397a(j3, j4, z3, str2);
            }
        }, 276800498);
    }

    private void m19397a(long j, long j2, boolean z, String str) {
        boolean z2;
        boolean z3 = true;
        this.bt = z;
        this.bK = TriState.valueOf("instantvideo.dev".compareTo(str) == 0);
        if (z || this.bK.asBoolean(false)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.bs = TriState.valueOf(z2);
        this.ai = j2;
        if (this.ad != j) {
            BLog.a("WebrtcUiHandler", "Can't start call since original call is ended already");
            return;
        }
        if (this.bK.asBoolean(false)) {
            if (bf()) {
                this.f19563V.a(m19436L(), false, false, false);
            } else {
                m19458a(EndCallReason.CallEndNoUIError);
                return;
            }
        }
        if (!this.f19556O.a(ZeroFeatureKey.VOIP_INCOMING_CALL_INTERSTITIAL)) {
            z3 = false;
        } else if (this.bz.a(Liveness.Cached, ExperimentsForRtcModule.cZ, false)) {
            z3 = false;
        }
        if (z3) {
            m19425n(z);
        } else {
            m19461a(z, false);
        }
    }

    public void onIncomingCall(ConferenceCall conferenceCall, String str, String[] strArr, int i) {
        final ConferenceCall conferenceCall2 = conferenceCall;
        final String str2 = str;
        final String[] strArr2 = strArr;
        final int i2 = i;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19452e;

            public void run() {
                WebrtcUiHandler.m19401a(this.f19452e, conferenceCall2, str2, strArr2, i2);
            }
        }, 393093367);
    }

    private static boolean m19419c(int i) {
        return i == 2 || i == 1;
    }

    public static void m19401a(WebrtcUiHandler webrtcUiHandler, ConferenceCall conferenceCall, String str, String[] strArr, int i) {
        long parseLong;
        boolean z = true;
        try {
            parseLong = Long.parseLong(str);
        } catch (Throwable e) {
            BLog.a("WebrtcUiHandler", "Error getting conference caller id", e);
            parseLong = 0;
        }
        webrtcUiHandler.m19396a(0, parseLong, conferenceCall);
        if (m19419c(i)) {
            boolean z2;
            webrtcUiHandler.ai = Long.parseLong(str);
            if (i == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            webrtcUiHandler.bs = TriState.valueOf(z2);
            if (i != 1) {
                z = false;
            }
            webrtcUiHandler.bt = z;
        } else {
            Object aa = webrtcUiHandler.aa();
            if (StringUtil.a(aa)) {
                BLog.b("WebrtcUiHandler", "Unable to get group thread id for conference call");
            } else {
                webrtcUiHandler.aj = ThreadKey.a(Long.parseLong(aa));
                if (webrtcUiHandler.am) {
                    webrtcUiHandler.bs = TriState.valueOf(i == 3);
                    if (i != 3) {
                        z = false;
                    }
                    webrtcUiHandler.bt = z;
                }
                String[] a = RtcCallHandler.a(webrtcUiHandler.f19561T.m19562d(), webrtcUiHandler.f19573h.a());
                if (a == null) {
                    BLog.a("WebrtcUiHandler", "Cannot get participants from ThreadSummary, falling back to participants list");
                    webrtcUiHandler.m19418b(strArr);
                } else {
                    webrtcUiHandler.m19418b(a);
                }
            }
        }
        webrtcUiHandler.m19461a(false, false);
    }

    private void m19425n(boolean z) {
        Intent intent = new Intent(this.f19572g, RtcZeroRatingActivity.class);
        intent.setAction("ACTION_INCOMING_CALL");
        intent.putExtra("EXTRA_DIRECT_VIDEO", z);
        intent.setFlags(268435456);
        this.f19574i.a(intent, this.f19572g);
    }

    public final void m19472g(boolean z) {
        int ringerMode = this.f19584s.getRingerMode();
        if (m19478k()) {
            this.f19555N.m19281a(Tone.INCOMING_INSTANT_VIDEO);
        } else if (ringerMode == 2) {
            this.f19555N.m19282b(z);
        }
        bv();
    }

    public final void m19461a(boolean z, boolean z2) {
        if (z2) {
            bd();
        }
        if (this.ak == 0) {
            BLog.a("WebrtcUiHandler", "Can't start call since it is ended already");
        } else if (this.f19586u == null || this.f19586u.getCallState() == 0) {
            UserKey b = UserKey.b(String.valueOf(this.ai));
            if (m19478k() && bf() && !m19473g() && this.ca.d(b)) {
                be();
                m19424m(true);
                if (this.bm) {
                    m19479k(true);
                }
                if (!z2) {
                    m19472g(z);
                    return;
                }
                return;
            }
            m19422g(2);
            this.f19583r.a = m19437M();
            bt();
            if (!z2) {
                m19472g(z);
            }
            this.aK = aE();
            this.aL = 0;
            Intent a = m19393a("com.facebook.rtc.fbwebrtc.intent.action.INCOMING_CALL");
            a.putExtra("FORCE_STAR_RATING", this.aU);
            this.f19574i.a(a, this.f19572g);
        } else {
            m19458a(EndCallReason.CallEndInAnotherCall);
        }
    }

    private synchronized void bA() {
        if (this.bm) {
            ServiceConnectionDetour.a(this.f19572g, this.aX, 86981637);
            this.bm = false;
            this.bn = null;
        }
    }

    private synchronized void bB() {
        if (aF() && !this.bm) {
            if (this.aX == null) {
                this.aX = new ServiceConnection(this) {
                    final /* synthetic */ WebrtcUiHandler f19453a;

                    {
                        this.f19453a = r1;
                    }

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        RtcCallBinder rtcCallBinder = (RtcCallBinder) iBinder;
                        this.f19453a.bn = rtcCallBinder.f19956a;
                        this.f19453a.bm = true;
                        if (this.f19453a.m19478k()) {
                            if (this.f19453a.aB) {
                                this.f19453a.m19454a(LocalVideoState.STARTED);
                            }
                            this.f19453a.m19479k(true);
                        }
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        this.f19453a.bn = null;
                        this.f19453a.bm = false;
                    }
                };
            }
            ServiceConnectionDetour.a(this.f19572g, new Intent(this.f19572g, BackgroundVideoCallService.class), this.aX, 1, 117189425);
        }
    }

    private boolean m19413a(long j, long j2) {
        boolean a = this.f19581p.a(VoipPrefKeys.m19618a(Long.valueOf(j)));
        if (this.f19581p.a((PrefKey) ((PrefKey) VoipPrefKeys.f19929p.a(Uri.encode(ThreadKey.a(Long.valueOf(j).longValue(), j2).toString()))).a("/thread_custom_notifications_enabled"), false) && a) {
            return this.f19581p.a(VoipPrefKeys.m19618a(Long.valueOf(j)), true);
        }
        return this.f19581p.a(VoipPrefKeys.f19916c, true);
    }

    public void switchToStreamingUI(final boolean z, final String str) {
        this.bz.a(Liveness.Cached, ExperimentsForRtcModule.bY);
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19456c;

            public void run() {
                this.f19456c.m19426o(z);
            }
        }, -2050125547);
    }

    private void m19426o(boolean z) {
        this.aZ = false;
        if (this.bM != null) {
            this.bM.cancel(true);
            this.bM = null;
        }
        if (!m19470e()) {
            bC();
        }
        this.aE = false;
        this.f19583r.a = m19437M();
        bD();
        this.f19557P.a(this.f19565X);
        if (!m19478k()) {
            if (this.bs.isSet() && as() != z) {
                this.bu = true;
            }
            this.bs = TriState.valueOf(z);
            this.bt = z;
            if (this.aB) {
                bw(this);
            } else {
                m19446X();
                bx();
                if (!au()) {
                    m19444U();
                }
                this.f19555N.m19284c();
            }
            int size = this.f19560S.size();
            for (int i = 0; i < size; i++) {
                ((DefaultRtcUiCallback) this.f19560S.get(i)).mo779a(z);
            }
        } else if (this.aB) {
            m19460a(false);
        }
    }

    private void bD() {
        if (this.f19586u != null) {
            this.f19564W = new PhoneStateListener(this) {
                final /* synthetic */ WebrtcUiHandler f19457a;

                {
                    this.f19457a = r1;
                }

                public void onCallStateChanged(int i, String str) {
                    long j = this.f19457a.f19577l.u;
                    if (i == 1) {
                        this.f19457a.aQ = true;
                        this.f19457a.f19577l.logCallAction(j, this.f19457a.ai, "pstn_call", "received");
                    } else if (i != 0) {
                        this.f19457a.f19577l.logCallAction(j, this.f19457a.ai, "pstn_call", "accepted");
                        this.f19457a.m19458a(EndCallReason.CallEndClientInterrupted);
                    } else if (this.f19457a.aQ) {
                        this.f19457a.f19577l.logCallAction(j, this.f19457a.ai, "pstn_call", "declined");
                        this.f19457a.aQ = false;
                    }
                    super.onCallStateChanged(i, str);
                }

                public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                    int intValue;
                    if (!(signalStrength == null || this.f19457a.aV == null)) {
                        try {
                            intValue = ((Integer) this.f19457a.aV.invoke(signalStrength, null)).intValue();
                        } catch (Exception e) {
                        }
                        this.f19457a.f19577l.b(intValue);
                    }
                    intValue = -1;
                    this.f19457a.f19577l.b(intValue);
                }
            };
            this.aV = null;
            try {
                this.aV = SignalStrength.class.getMethod("getLevel", null);
                this.aV.setAccessible(true);
            } catch (Exception e) {
            }
            this.f19586u.listen(this.f19564W, 288);
        }
    }

    public void updateRemoteVideoSupport(final boolean z, final long j) {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19460c;

            public void run() {
                this.f19460c.m19474h(z);
            }
        }, -1601885880);
    }

    public void localMediaStateChanged(boolean z, boolean z2, boolean z3) {
    }

    public void remoteMediaStateChanged(boolean z, boolean z2, boolean z3) {
        this.bS = z3;
        int size = this.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo820t();
        }
    }

    public void addRemoteVideoTrack(String str, String str2, long j) {
        final String str3 = str;
        final String str4 = str2;
        final long j2 = j;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19464d;

            public void run() {
                WebrtcUiHandler webrtcUiHandler = this.f19464d;
                String str = str4;
                long j = j2;
                if (webrtcUiHandler.ap()) {
                    webrtcUiHandler.bs = TriState.YES;
                }
                if (!webrtcUiHandler.m19470e() && webrtcUiHandler.am) {
                    webrtcUiHandler.aq = true;
                    webrtcUiHandler.bO = true;
                    webrtcUiHandler.an = true;
                    webrtcUiHandler.av = str;
                    webrtcUiHandler.aw = j;
                    int size = webrtcUiHandler.f19560S.size();
                    for (int i = 0; i < size; i++) {
                        ((DefaultRtcUiCallback) webrtcUiHandler.f19560S.get(i)).mo795k();
                    }
                }
            }
        }, 1139553137);
    }

    public void onEscalationRequest(final boolean z) {
        Boolean.valueOf(z);
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19466b;

            public void run() {
                WebrtcUiHandler.m19427p(this.f19466b, z);
            }
        }, -990131395);
    }

    public static void m19427p(WebrtcUiHandler webrtcUiHandler, boolean z) {
        if (webrtcUiHandler.m19470e()) {
            webrtcUiHandler.bv = true;
        }
        if (!z && webrtcUiHandler.br) {
            webrtcUiHandler.br = false;
        }
        if (z && !webrtcUiHandler.as()) {
            webrtcUiHandler.f19555N.m19281a(Tone.VIDEO_ON);
        }
        webrtcUiHandler.bp = z;
        if (webrtcUiHandler.bz.a(Liveness.Cached, ExperimentsForRtcModule.d, false)) {
            webrtcUiHandler.m19430t(false);
        }
        if (webrtcUiHandler.bz.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.e, false)) {
            if (z) {
                webrtcUiHandler.bv();
            } else {
                bw(webrtcUiHandler);
            }
        }
        int size = webrtcUiHandler.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) webrtcUiHandler.f19560S.get(i)).mo784b(z);
        }
    }

    public final void m19476i(boolean z) {
        Boolean.valueOf(z);
        this.bp = false;
        this.br = z;
        if (m19470e()) {
            this.ae.configureVideo(z);
            onEscalationSuccess();
        } else if (this.f19563V != null) {
            WebrtcManager webrtcManager = this.f19563V;
            String L = m19436L();
            if (webrtcManager.a()) {
                webrtcManager.w.sendEscalationResponse(z, L);
            }
        }
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19468a;

            {
                this.f19468a = r1;
            }

            public void run() {
                WebrtcUiHandler.bw(this.f19468a);
            }
        }, -448915599);
    }

    public final void m19477j(boolean z) {
        Boolean.valueOf(z);
        if (m19470e()) {
            this.bv = true;
            this.ae.configureVideo(z);
            this.bq = z;
            if (z && this.bO) {
                onEscalationResponse(true);
            } else if (z) {
                this.bN = this.f19589x.schedule(new Runnable(this) {
                    final /* synthetic */ WebrtcUiHandler f19469a;

                    {
                        this.f19469a = r1;
                    }

                    public void run() {
                        this.f19469a.onEscalationTimeout();
                    }
                }, 25, TimeUnit.SECONDS);
            }
        } else if (this.f19563V != null) {
            WebrtcManager webrtcManager = this.f19563V;
            String L = m19436L();
            if (webrtcManager.a()) {
                webrtcManager.w.sendEscalationRequest(z, L);
            }
        }
    }

    public void onEscalationResponse(final boolean z) {
        Boolean.valueOf(z);
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19471b;

            public void run() {
                WebrtcUiHandler.m19428q(this.f19471b, z);
            }
        }, -644727375);
    }

    public static void m19428q(WebrtcUiHandler webrtcUiHandler, boolean z) {
        boolean z2 = true;
        int i = 0;
        if (webrtcUiHandler.m19470e()) {
            if (webrtcUiHandler.bN != null) {
                webrtcUiHandler.bN.cancel(true);
                webrtcUiHandler.bN = null;
            }
            if (z) {
                webrtcUiHandler.bw = true;
            }
        }
        if (!(webrtcUiHandler.as() || z)) {
            z2 = false;
        }
        webrtcUiHandler.bs = TriState.valueOf(z2);
        webrtcUiHandler.bq = false;
        int size = webrtcUiHandler.f19560S.size();
        while (i < size) {
            ((DefaultRtcUiCallback) webrtcUiHandler.f19560S.get(i)).mo786c(z);
            i++;
        }
        if (z && webrtcUiHandler.f19563V != null && !webrtcUiHandler.m19470e()) {
            WebrtcManager webrtcManager = webrtcUiHandler.f19563V;
            if (webrtcManager.a()) {
                webrtcManager.w.sendEscalationSuccess();
            }
        }
    }

    public void onEscalationSuccess() {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19472a;

            {
                this.f19472a = r1;
            }

            public void run() {
                WebrtcUiHandler webrtcUiHandler = this.f19472a;
                if (webrtcUiHandler.br) {
                    webrtcUiHandler.bs = TriState.YES;
                    if (webrtcUiHandler.m19470e()) {
                        webrtcUiHandler.bw = true;
                    }
                }
                if (webrtcUiHandler.m19470e() && webrtcUiHandler.bN != null) {
                    webrtcUiHandler.bN.cancel(true);
                    webrtcUiHandler.bN = null;
                }
                int size = webrtcUiHandler.f19560S.size();
                for (int i = 0; i < size; i++) {
                    ((DefaultRtcUiCallback) webrtcUiHandler.f19560S.get(i)).mo797m();
                }
            }
        }, 1759402500);
    }

    public void onEscalationTimeout() {
        this.br = false;
        this.bp = false;
        this.bq = false;
        if (m19470e()) {
            if (this.bN != null) {
                this.bN.cancel(true);
                this.bN = null;
            }
            m19477j(false);
        }
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19473a;

            {
                this.f19473a = r1;
            }

            public void run() {
                int size = this.f19473a.f19560S.size();
                for (int i = 0; i < size; i++) {
                    ((DefaultRtcUiCallback) this.f19473a.f19560S.get(i)).mo798n();
                }
            }
        }, 916180140);
    }

    public final void m19462a(byte[] bArr) {
        if (this.f19563V != null) {
            WebrtcManager webrtcManager = this.f19563V;
            if (webrtcManager.a()) {
                webrtcManager.w.sendSnakeGameCommand(bArr);
            }
        }
    }

    public void onRemoteVideoSizeChanged(final int i, final int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        if (i > 0 && i2 > 0) {
            ExecutorDetour.a(this.f19587v, new Runnable(this) {
                final /* synthetic */ WebrtcUiHandler f19476c;

                public void run() {
                    this.f19476c.ar = i;
                    this.f19476c.as = i2;
                    WebrtcUiHandler webrtcUiHandler = this.f19476c;
                    int i = i;
                    int i2 = i2;
                    int size = webrtcUiHandler.f19560S.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((DefaultRtcUiCallback) webrtcUiHandler.f19560S.get(i3)).mo777a(i, i2);
                    }
                }
            }, 1235505095);
        }
    }

    public void onActiveAudioLevels(String[] strArr, int[] iArr) {
        int i = 0;
        if (!this.by) {
            return;
        }
        if (strArr == null || iArr == null || strArr.length != iArr.length) {
            BLog.c("WebrtcUiHandler", "Malformed data for group audio level update");
            return;
        }
        final Map hashMap = new HashMap();
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            hashMap.put(strArr[i], Integer.valueOf(iArr[i2]));
            i++;
            i2 = i3;
        }
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19478b;

            public void run() {
                int size = this.f19478b.f19560S.size();
                for (int i = 0; i < size; i++) {
                    ((DefaultRtcUiCallback) this.f19478b.f19560S.get(i)).mo778a(hashMap);
                }
            }
        }, -387951364);
    }

    public void onAudioLevel(int i, final int i2) {
        if (this.bx) {
            ExecutorDetour.a(this.f19587v, new Runnable(this) {
                final /* synthetic */ WebrtcUiHandler f19480b;

                public void run() {
                    int size = this.f19480b.f19560S.size();
                    for (int i = 0; i < size; i++) {
                        ((DefaultRtcUiCallback) this.f19480b.f19560S.get(i)).mo776a(i2);
                    }
                }
            }, -1643533220);
        }
    }

    public void onSnakeGameUpdate(final byte[] bArr) {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19482b;

            public void run() {
                int size = this.f19482b.f19560S.size();
                for (int i = 0; i < size; i++) {
                    ((DefaultRtcUiCallback) this.f19482b.f19560S.get(i)).mo780a(bArr);
                }
            }
        }, -149836596);
    }

    public final void m19452a(View view) {
        Object obj = 1;
        Object obj2 = null;
        Preconditions.checkNotNull(view);
        if (this.aw != 0) {
            synchronized (this) {
                if (view.equals(this.bG)) {
                    obj = null;
                } else {
                    if (this.bG == null) {
                        obj2 = 1;
                    }
                    this.bG = view;
                }
            }
            if (obj != null && this.f19563V != null) {
                if (obj2 == null) {
                    this.f19563V.a(this.aw, null);
                }
                this.f19563V.a(this.aw, view);
            }
        }
    }

    public final void m19464b(View view) {
        Object obj = null;
        synchronized (this) {
            if (this.bG != null && (view == null || this.bG.equals(view))) {
                this.bG = null;
                obj = 1;
            }
        }
        if (obj != null && this.f19563V != null) {
            this.f19563V.a(this.aw, null);
        }
    }

    public void removeRemoteVideoTrack(String str, String str2, long j) {
        final String str3 = str;
        final String str4 = str2;
        final long j2 = j;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19486d;

            public void run() {
                WebrtcUiHandler webrtcUiHandler = this.f19486d;
                if (!webrtcUiHandler.m19473g() && webrtcUiHandler.aq) {
                    if (!(!webrtcUiHandler.m19478k() || webrtcUiHandler.aB || webrtcUiHandler.bL)) {
                        webrtcUiHandler.m19458a(EndCallReason.CallEndHangupCall);
                        webrtcUiHandler.m19483r();
                    }
                    webrtcUiHandler.aq = false;
                    webrtcUiHandler.av = null;
                    webrtcUiHandler.aw = 0;
                    webrtcUiHandler.m19464b(null);
                    int size = webrtcUiHandler.f19560S.size();
                    for (int i = 0; i < size; i++) {
                        ((DefaultRtcUiCallback) webrtcUiHandler.f19560S.get(i)).mo796l();
                    }
                }
            }
        }, -863312571);
    }

    public void showConnectionDetails(boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4) {
        final boolean z5 = z;
        final boolean z6 = z2;
        final boolean z7 = z3;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z8 = z4;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19495h;

            public void run() {
                this.f19495h.m19411a(z5, z6, z7, i4, z8);
            }
        }, -1512977896);
    }

    private void m19411a(boolean z, boolean z2, boolean z3, int i, boolean z4) {
        if (z && this.aM == 0 && !m19470e()) {
            this.aM = aE();
            if (this.aB) {
                this.f19555N.m19286f();
                bx();
            }
            bT();
        }
        this.bV = ConnectionQuality.values()[i];
        if (this.aG != z) {
            if (!(m19470e() && this.aB && aB())) {
                if (!z) {
                    this.f19555N.m19281a(Tone.DISCONNECT);
                } else if (this.aB || this.f19555N.m19283b()) {
                    if (this.aT) {
                        this.aT = false;
                    } else {
                        this.f19555N.m19281a(Tone.CONNECT);
                    }
                }
            }
            if (!z) {
                this.bU = ConnectionStatus.RECONNECTING;
            } else if (this.bU == ConnectionStatus.NONE) {
                this.bU = ConnectionStatus.NORMAL;
            } else {
                this.bU = ConnectionStatus.RECONNECTED;
            }
        } else if (this.aG) {
            if (z2) {
                this.bU = ConnectionStatus.WEAK_CONNECTION;
            } else if (z3) {
                this.bU = ConnectionStatus.WEAK_VIDEO_CONNECTION;
            } else {
                this.bU = ConnectionStatus.NORMAL;
            }
        }
        this.aG = z;
        if (this.bR != z4) {
            this.bR = z4;
            for (NameChangedListener a : this.ce) {
                a.mo804a();
            }
        }
        int size = this.f19560S.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i2)).mo792h();
        }
    }

    @Nullable
    public final String m19447Z() {
        if (this.ae != null) {
            return this.ae.conferenceName();
        }
        return null;
    }

    @Nullable
    public final String aa() {
        if (this.ae == null) {
            return null;
        }
        String conferenceName = this.ae.conferenceName();
        String str = null;
        if (!StringUtil.a(conferenceName) && conferenceName.startsWith("GROUP:")) {
            CharSequence replace = conferenceName.replace("GROUP:", "");
            if (!StringUtil.a(replace)) {
                CharSequence charSequence = replace;
            }
        }
        return str;
    }

    public final boolean ab() {
        return !StringUtil.a(aa());
    }

    public void hideCallUI(int i, long j, boolean z, String str) {
        if (!(this.aB || m19442S())) {
            this.f19568a.a();
        }
        m19421f(i);
        final long j2 = j;
        final boolean z2 = z;
        final String str2 = str;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19499d;

            public void run() {
                this.f19499d.m19409a(this.f19499d.bj, j2, z2, str2);
            }
        }, -701134822);
    }

    private void m19409a(EndCallReason endCallReason, long j, boolean z, String str) {
        long j2;
        long j3;
        int i;
        boolean z2;
        String str2;
        Long.valueOf(j);
        Integer.valueOf(endCallReason.ordinal());
        this.f19577l.b();
        bN();
        m19479k(false);
        if (this.al) {
            this.bD += aE() - this.bF;
        }
        if (this.bm) {
            long i2 = this.bn.m19693i();
            long m = this.bn.m19696m();
            int j4 = this.bn.m19694j();
            this.bB = (aE() - this.bE) - i2;
            boolean q = this.bn.m19699q();
            bA();
            j2 = m;
            j3 = i2;
            i = j4;
            z2 = q;
        } else {
            j2 = 0;
            j3 = 0;
            i = 0;
            z2 = false;
        }
        if (j != 0) {
            this.f19577l.a(this.f19584s.getMode());
        }
        VideoCaptureAndroid.m21574a(null);
        this.aU = false;
        if (m19470e() && endCallReason == EndCallReason.CallEndNoPermission) {
            this.f19562U.b(new ToastBuilder(2131231992));
        }
        if (!(z || this.ai == 0 || (endCallReason != EndCallReason.CallEndNoPermission && endCallReason != EndCallReason.CallEndOtherNotCapable))) {
            String string;
            if (endCallReason == EndCallReason.CallEndNoPermission) {
                string = this.f19572g.getString(2131232174, new Object[]{aj()});
                str2 = RtcAbortedCallReasonIds.a;
            } else {
                string = this.f19572g.getString(2131232173);
                str2 = RtcAbortedCallReasonIds.b;
            }
            this.bX.a(UserKey.b(String.valueOf(this.ai)), false, string, str2);
        }
        if (this.ak != 0) {
            long j5;
            Object obj;
            Iterator it;
            Entry entry;
            int size;
            Object obj2;
            int i3;
            DefaultRtcUiCallback defaultRtcUiCallback;
            if (this.aw != 0) {
                m19464b(null);
                this.av = null;
                this.aw = 0;
            }
            be();
            this.f19555N.m19280a();
            m19446X();
            bm();
            bu(this);
            if (this.f19564W != null) {
                this.f19586u.listen(this.f19564W, 0);
                this.f19564W = null;
            }
            this.f19557P.b(this.f19565X);
            this.aV = null;
            this.bd = false;
            m19424m(false);
            this.aq = false;
            this.an = false;
            this.f19583r.a(m19437M());
            this.bj = endCallReason;
            this.aN = aE();
            this.bU = ConnectionStatus.NONE;
            this.bV = ConnectionQuality.DISCONNECTED;
            this.bu = false;
            bM();
            if (j != 0) {
                if (endCallReason == EndCallReason.CallEndConnectionDropped) {
                    this.f19555N.m19281a(Tone.DROPPED_CALL);
                } else if (!m19414a(endCallReason, z)) {
                    this.f19555N.m19281a(Tone.END_CALL);
                }
            }
            if (j != 0) {
                if (bH()) {
                    m19395a(j);
                }
                if (!this.aB) {
                    m19417b(endCallReason);
                }
            }
            if (this.aE) {
                j5 = 60000;
            } else {
                j5 = 30000;
            }
            if (!(z || this.ai == 0 || j == 0 || !m19439P() || "caller_camp_presence".equals(this.aD) || "caller_camp_mqtt".equals(this.aD) || "caller_camp_rtc".equals(this.aD))) {
                if (endCallReason == EndCallReason.CallEndOtherNotCapable && !StringUtil.a(str)) {
                    if (str.indexOf("MQTTSendOfferTimeOut") > 0) {
                        obj = 1;
                        this.aE = false;
                        m19422g(0);
                        if (!StringUtil.a(str)) {
                            this.f19577l.b(j, str);
                            this.f19577l.b("chat_head_count", (long) i);
                            this.f19577l.b("chat_head_duration", j2);
                            this.f19577l.b("chat_head_duration_overall", j3);
                            this.f19577l.a("dragged_chat_head", z2);
                            this.f19577l.a("incall_count", String.valueOf(this.bA));
                            this.f19577l.b("incall_duration", this.bB);
                            this.f19577l.b("off_incall_duration", this.bC);
                            this.f19577l.b("mute_duration", this.bD);
                            if (m19470e() && !m19473g()) {
                                str2 = "voip";
                                if (!this.bv && !this.bw) {
                                    str2 = "escalation_declined";
                                } else if (!this.bw) {
                                    str2 = "escalated";
                                } else if (this.bt) {
                                    str2 = "direct_video";
                                }
                                this.f19577l.a("call_type", str2);
                            }
                            if (obj != null) {
                                this.f19577l.b("caller_camp", 1);
                            }
                            it = bG().entrySet().iterator();
                            while (it.hasNext()) {
                                entry = (Entry) it.next();
                                this.f19577l.a("cb_" + ((String) entry.getKey()), (String) entry.getValue());
                            }
                        }
                        if (this.aB && this.aC > 0) {
                            this.f19577l.a("notif_delay", Long.toString(this.aC));
                        }
                        this.bE = 0;
                        if (this.aK > 0) {
                            if (this.aL <= 0) {
                                this.f19577l.a("ui_switch", Long.toString(this.aL - this.aK));
                            } else {
                                this.f19577l.a("ui_switch", "-1");
                            }
                        }
                        if (this.f19558Q.a(1098) == TriState.YES) {
                            this.f19577l.a("hw_vcap", String.valueOf(MediaCodecVideoUtils.m19717a()));
                        }
                        if (this.f19560S.isEmpty()) {
                            size = this.f19560S.size();
                            obj2 = null;
                            for (i3 = 0; i3 < size; i3++) {
                                defaultRtcUiCallback = (DefaultRtcUiCallback) this.f19560S.get(i3);
                                endCallReason.ordinal();
                                obj2 = (defaultRtcUiCallback.mo781a(j, z, m19470e(), obj2 != null) || obj2 != null) ? 1 : null;
                            }
                        } else {
                            this.f19577l.h();
                            af();
                        }
                        this.ae = null;
                        this.cc.m19329b();
                        if (obj == null) {
                            this.cc.m19327a(this.ai, this.bk, this.bl, this.bt, j5);
                        }
                    }
                }
                int i4;
                if (aE() - this.aJ >= 10000 && endCallReason == EndCallReason.CallEndHangupCall && this.aZ && this.aJ > 0) {
                    i4 = 1;
                    this.aE = false;
                    m19422g(0);
                    if (StringUtil.a(str)) {
                        this.f19577l.b(j, str);
                        this.f19577l.b("chat_head_count", (long) i);
                        this.f19577l.b("chat_head_duration", j2);
                        this.f19577l.b("chat_head_duration_overall", j3);
                        this.f19577l.a("dragged_chat_head", z2);
                        this.f19577l.a("incall_count", String.valueOf(this.bA));
                        this.f19577l.b("incall_duration", this.bB);
                        this.f19577l.b("off_incall_duration", this.bC);
                        this.f19577l.b("mute_duration", this.bD);
                        str2 = "voip";
                        if (!this.bv) {
                        }
                        if (!this.bw) {
                            str2 = "escalated";
                        } else if (this.bt) {
                            str2 = "direct_video";
                        }
                        this.f19577l.a("call_type", str2);
                        if (obj != null) {
                            this.f19577l.b("caller_camp", 1);
                        }
                        it = bG().entrySet().iterator();
                        while (it.hasNext()) {
                            entry = (Entry) it.next();
                            this.f19577l.a("cb_" + ((String) entry.getKey()), (String) entry.getValue());
                        }
                    }
                    this.f19577l.a("notif_delay", Long.toString(this.aC));
                    this.bE = 0;
                    if (this.aK > 0) {
                        if (this.aL <= 0) {
                            this.f19577l.a("ui_switch", Long.toString(this.aL - this.aK));
                        } else {
                            this.f19577l.a("ui_switch", "-1");
                        }
                    }
                    if (this.f19558Q.a(1098) == TriState.YES) {
                        this.f19577l.a("hw_vcap", String.valueOf(MediaCodecVideoUtils.m19717a()));
                    }
                    if (this.f19560S.isEmpty()) {
                        size = this.f19560S.size();
                        obj2 = null;
                        for (i3 = 0; i3 < size; i3++) {
                            defaultRtcUiCallback = (DefaultRtcUiCallback) this.f19560S.get(i3);
                            endCallReason.ordinal();
                            if (obj2 != null) {
                            }
                            if (!defaultRtcUiCallback.mo781a(j, z, m19470e(), obj2 != null)) {
                            }
                        }
                    } else {
                        this.f19577l.h();
                        af();
                    }
                    this.ae = null;
                    this.cc.m19329b();
                    if (obj == null) {
                        this.cc.m19327a(this.ai, this.bk, this.bl, this.bt, j5);
                    }
                } else if (aE() - this.aJ >= 10000 && endCallReason == EndCallReason.CallEndHangupCall && this.aE && this.aJ > 0) {
                    i4 = 1;
                    this.aE = false;
                    m19422g(0);
                    if (StringUtil.a(str)) {
                        this.f19577l.b(j, str);
                        this.f19577l.b("chat_head_count", (long) i);
                        this.f19577l.b("chat_head_duration", j2);
                        this.f19577l.b("chat_head_duration_overall", j3);
                        this.f19577l.a("dragged_chat_head", z2);
                        this.f19577l.a("incall_count", String.valueOf(this.bA));
                        this.f19577l.b("incall_duration", this.bB);
                        this.f19577l.b("off_incall_duration", this.bC);
                        this.f19577l.b("mute_duration", this.bD);
                        str2 = "voip";
                        if (!this.bv) {
                        }
                        if (!this.bw) {
                            str2 = "escalated";
                        } else if (this.bt) {
                            str2 = "direct_video";
                        }
                        this.f19577l.a("call_type", str2);
                        if (obj != null) {
                            this.f19577l.b("caller_camp", 1);
                        }
                        it = bG().entrySet().iterator();
                        while (it.hasNext()) {
                            entry = (Entry) it.next();
                            this.f19577l.a("cb_" + ((String) entry.getKey()), (String) entry.getValue());
                        }
                    }
                    this.f19577l.a("notif_delay", Long.toString(this.aC));
                    this.bE = 0;
                    if (this.aK > 0) {
                        if (this.aL <= 0) {
                            this.f19577l.a("ui_switch", "-1");
                        } else {
                            this.f19577l.a("ui_switch", Long.toString(this.aL - this.aK));
                        }
                    }
                    if (this.f19558Q.a(1098) == TriState.YES) {
                        this.f19577l.a("hw_vcap", String.valueOf(MediaCodecVideoUtils.m19717a()));
                    }
                    if (this.f19560S.isEmpty()) {
                        this.f19577l.h();
                        af();
                    } else {
                        size = this.f19560S.size();
                        obj2 = null;
                        for (i3 = 0; i3 < size; i3++) {
                            defaultRtcUiCallback = (DefaultRtcUiCallback) this.f19560S.get(i3);
                            endCallReason.ordinal();
                            if (obj2 != null) {
                            }
                            if (defaultRtcUiCallback.mo781a(j, z, m19470e(), obj2 != null)) {
                            }
                        }
                    }
                    this.ae = null;
                    this.cc.m19329b();
                    if (obj == null) {
                        this.cc.m19327a(this.ai, this.bk, this.bl, this.bt, j5);
                    }
                }
            }
            obj = null;
            this.aE = false;
            m19422g(0);
            if (StringUtil.a(str)) {
                this.f19577l.b(j, str);
                this.f19577l.b("chat_head_count", (long) i);
                this.f19577l.b("chat_head_duration", j2);
                this.f19577l.b("chat_head_duration_overall", j3);
                this.f19577l.a("dragged_chat_head", z2);
                this.f19577l.a("incall_count", String.valueOf(this.bA));
                this.f19577l.b("incall_duration", this.bB);
                this.f19577l.b("off_incall_duration", this.bC);
                this.f19577l.b("mute_duration", this.bD);
                str2 = "voip";
                if (!this.bv) {
                }
                if (!this.bw) {
                    str2 = "escalated";
                } else if (this.bt) {
                    str2 = "direct_video";
                }
                this.f19577l.a("call_type", str2);
                if (obj != null) {
                    this.f19577l.b("caller_camp", 1);
                }
                it = bG().entrySet().iterator();
                while (it.hasNext()) {
                    entry = (Entry) it.next();
                    this.f19577l.a("cb_" + ((String) entry.getKey()), (String) entry.getValue());
                }
            }
            this.f19577l.a("notif_delay", Long.toString(this.aC));
            this.bE = 0;
            if (this.aK > 0) {
                if (this.aL <= 0) {
                    this.f19577l.a("ui_switch", "-1");
                } else {
                    this.f19577l.a("ui_switch", Long.toString(this.aL - this.aK));
                }
            }
            if (this.f19558Q.a(1098) == TriState.YES) {
                this.f19577l.a("hw_vcap", String.valueOf(MediaCodecVideoUtils.m19717a()));
            }
            if (this.f19560S.isEmpty()) {
                this.f19577l.h();
                af();
            } else {
                size = this.f19560S.size();
                obj2 = null;
                for (i3 = 0; i3 < size; i3++) {
                    defaultRtcUiCallback = (DefaultRtcUiCallback) this.f19560S.get(i3);
                    endCallReason.ordinal();
                    if (obj2 != null) {
                    }
                    if (defaultRtcUiCallback.mo781a(j, z, m19470e(), obj2 != null)) {
                    }
                }
            }
            this.ae = null;
            this.cc.m19329b();
            if (obj == null) {
                this.cc.m19327a(this.ai, this.bk, this.bl, this.bt, j5);
            }
        }
    }

    private ImmutableMap<String, String> bG() {
        if (StringUtil.a(this.bJ)) {
            return ImmutableBiMap.a();
        }
        try {
            return (ImmutableMap) this.f19554M.a(this.f19554M.a(this.bJ), ImmutableMap.class);
        } catch (Exception e) {
            return ImmutableBiMap.a();
        }
    }

    private boolean bH() {
        boolean z;
        boolean z2 = ((double) (this.f19591z.a() - this.aI)) < 5000.0d;
        if (this.bj == EndCallReason.CallEndNoPermission) {
            z = true;
        } else {
            z = false;
        }
        boolean z3;
        if (this.bj == EndCallReason.CallEndHangupCall) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z) {
            return this.bz.a(Liveness.Live, ExposureLogging.Off, ExperimentsForRtcModule.bR, false);
        }
        if (!this.aB || m19478k() || m19470e()) {
            return false;
        }
        if (this.aE || m19441R() || !r4 || !z2) {
            return true;
        }
        return false;
    }

    private boolean m19414a(EndCallReason endCallReason, boolean z) {
        if (this.f19548G.j != Product.MESSENGER || !this.bz.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.dc, false)) {
            return false;
        }
        boolean S = m19442S();
        boolean z2 = this.aB;
        boolean g = m19473g();
        switch (AnonymousClass50.f19529b[endCallReason.ordinal()]) {
            case 1:
                if (!z || S || !z2 || g) {
                    return false;
                }
                return true;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                if (!z2 || g) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public final void ac() {
        this.aH = true;
        m19422g(3);
    }

    public final void ad() {
        this.aH = false;
        m19422g(0);
    }

    public final void af() {
        this.f19579n.a();
        this.f19584s.setSpeakerphoneOn(false);
        this.f19584s.setMicrophoneMute(false);
        m19416b(this.aF);
    }

    public final void m19449a() {
        hideCallUI(EndCallReason.CallEndHangupCall.ordinal(), 0, false, "");
        this.ad = 0;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = false;
        this.ai = 0;
        this.aj = null;
        this.aB = false;
        this.aE = false;
        this.aG = false;
        this.aI = 0;
        this.aM = 0;
        this.aN = 0;
        this.bj = EndCallReason.CallEndIgnoreCall;
        this.bl = null;
        this.bk = null;
        this.aR = false;
    }

    public void updateStatesAndCallDuration() {
    }

    public void onIncomingMissedCall(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19502c;

            public void run() {
                WebrtcUiHandler webrtcUiHandler = this.f19502c;
                long j = j3;
                long j2 = j4;
                if (webrtcUiHandler.bi.m19563a()) {
                    webrtcUiHandler.cc.m19326a(j);
                }
            }
        }, -850295937);
    }

    public void onPingAckMessageReceived(long j, long j2) {
    }

    public void onDataReceived(final String str) {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19504b;

            public void run() {
                WebrtcUiHandler webrtcUiHandler = this.f19504b;
                String str = str;
                int size = webrtcUiHandler.f19560S.size();
                for (int i = 0; i < size; i++) {
                    webrtcUiHandler.f19560S.get(i);
                }
            }
        }, -1618479714);
    }

    public static void bJ(WebrtcUiHandler webrtcUiHandler) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.rtc.fbwebrtc.CALL_STATUS_AND_DURATION_UPDATE");
        webrtcUiHandler.f19545D.a(intent);
    }

    public static void bK(WebrtcUiHandler webrtcUiHandler) {
        if (webrtcUiHandler.m19440Q()) {
            int size = webrtcUiHandler.f19560S.size();
            for (int i = 0; i < size; i++) {
                ((DefaultRtcUiCallback) webrtcUiHandler.f19560S.get(i)).mo793i();
            }
        }
    }

    private void bC() {
        HandlerDetour.a(this.f19547F, this.cf, -1113885659);
        this.f19555N.f19238g.m19262a();
        m19422g(3);
    }

    private void bM() {
        HandlerDetour.a(this.f19547F, this.cf);
        bJ(this);
    }

    public final void ag() {
        this.aP = true;
    }

    @Nullable
    public final String ai() {
        if (StringUtil.a(this.bl)) {
            return this.bk;
        }
        return this.bl;
    }

    @Nullable
    public final String aj() {
        if (StringUtil.a(this.bk)) {
            return this.bl;
        }
        return this.bk;
    }

    @Nullable
    public final String ak() {
        String al = al();
        if (StringUtil.a(al)) {
            return this.f19572g.getString(2131232182);
        }
        return al;
    }

    @Nullable
    public final String al() {
        if (this.ae == null || this.aj == null) {
            return null;
        }
        return this.f19561T.m19560b();
    }

    public final void m19455a(NameChangedListener nameChangedListener) {
        if (nameChangedListener != null) {
            this.ce.add(nameChangedListener);
        }
    }

    public final void m19465b(NameChangedListener nameChangedListener) {
        if (nameChangedListener != null) {
            this.ce.remove(nameChangedListener);
        }
    }

    private void bN() {
        this.ce.clear();
    }

    private void m19417b(EndCallReason endCallReason) {
        if (!this.aP && endCallReason != EndCallReason.CallEndOtherInstanceHandled && !m19478k() && this.bi.m19563a()) {
            if (m19473g()) {
                if (endCallReason == EndCallReason.CallEndIncomingTimeout) {
                    this.f19591z.a();
                }
            } else if (!StringUtil.a(this.bl)) {
            } else {
                if (this.bl == null) {
                    this.aR = true;
                } else {
                    this.f19591z.a();
                }
            }
        }
    }

    public final boolean am() {
        int i = this.aO;
        this.aO = i + 1;
        return i < 5;
    }

    public final void m19451a(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                m19420e(30);
                break;
            case 1:
                m19420e(60);
                break;
            case 2:
                m19420e(480);
                break;
        }
        dialogInterface.dismiss();
    }

    private void m19420e(int i) {
        Intent intent = new Intent(this.f19546E.a("WEBRTC_REMINDER_NOTIFICATION_ACTION"));
        intent.putExtra("peer_id", this.ai);
        intent.putExtra("contact_name", this.bl);
        Context context = this.f19572g;
        int i2 = bh;
        bh = i2 + 1;
        PendingIntent b = SecurePendingIntent.b(context, i2, intent, 1073741824);
        FbAlarmManagerImpl fbAlarmManagerImpl = this.f19553L;
        long a = this.f19591z.a() + (60000 * ((long) i));
        if (VERSION.SDK_INT < 19) {
            fbAlarmManagerImpl.a.set(0, a, b);
        } else {
            fbAlarmManagerImpl.a.setExact(0, a, b);
        }
        this.f19577l.a("call_reminder", String.valueOf(i));
        if (!this.bi.m19563a()) {
            this.f19562U.a(new ToastBuilder(2131232082));
        }
    }

    public final boolean ap() {
        return this.f19578m.shouldEnableAutomatedTestSupport();
    }

    private void m19421f(int i) {
        EndCallReason[] values = EndCallReason.values();
        if (i < 0 || i >= values.length) {
            BLog.a("WebrtcUiHandler", "Invalid webrtc EndCallReason: %d", new Object[]{Integer.valueOf(i)});
            this.bj = EndCallReason.CallEndWebRTCError;
            return;
        }
        this.bj = values[i];
    }

    private void m19422g(int i) {
        this.ak = i;
        if (i != 0) {
            Object obj = (m19441R() || this.aB || VERSION.SDK_INT < 21) ? 1 : null;
            if (!(obj == null || this.aS)) {
                bd();
            }
        } else {
            be();
        }
        if (!m19478k()) {
            bJ(this);
        }
    }

    public final void m19458a(EndCallReason endCallReason) {
        if (m19470e()) {
            ConferenceCall conferenceCall = this.ae;
            int i = 1;
            switch (AnonymousClass50.f19529b[endCallReason.ordinal()]) {
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 0;
                    break;
                case 13:
                    i = 3;
                    break;
            }
            conferenceCall.leave(i);
        } else if (this.f19563V != null) {
            WebrtcManager webrtcManager = this.f19563V;
            long j = this.ad;
            if (webrtcManager.a()) {
                webrtcManager.w.endCall(j, endCallReason.ordinal());
            }
        }
    }

    public final EndCallReason aq() {
        return this.bj;
    }

    public final boolean ar() {
        return this.f19579n.b() && VERSION.SDK_INT > 16;
    }

    public final boolean as() {
        if (this.bs != null) {
            return this.bs.asBoolean(false);
        }
        return false;
    }

    public final boolean au() {
        return this.bs.asBoolean(false);
    }

    public final boolean aw() {
        return as() || this.br || az();
    }

    public final boolean az() {
        return au() && aB();
    }

    public final boolean aA() {
        return (aC() && this.aB && this.aE) || this.ak == 2;
    }

    public final boolean aB() {
        Object obj = (aC() && this.aB && !this.aE) ? 1 : null;
        return obj != null || aA();
    }

    public final boolean aC() {
        if (this.ak == 1) {
            return true;
        }
        return false;
    }

    public final boolean m19479k(boolean z) {
        boolean z2 = true;
        if (z != this.aY) {
            if (this.bm) {
                if (z) {
                    z2 = this.bn.m19697n();
                } else {
                    this.bn.m19698o();
                    this.bA++;
                }
                if (z2) {
                    this.aY = z;
                }
            } else if (z) {
                this.bB += aE() - this.bE;
            } else if (this.bE > 0) {
                this.bC += aE() - this.bE;
            }
        }
        return z2;
    }

    public final long aE() {
        return this.f19542A.now();
    }

    public final boolean aF() {
        boolean z = false;
        if (this.bP.isSet()) {
            return this.bP.asBoolean(true);
        }
        if (VERSION.SDK_INT >= 17 && this.f19548G.j == Product.MESSENGER && this.bH && this.cd.a() && this.f19581p.a(ChatHeadsPrefKeys.d, true)) {
            if (this.cd.a(new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"})) {
                z = true;
            }
        }
        this.bP = TriState.valueOf(z);
        return z;
    }

    private void m19429s(boolean z) {
        if (!aD()) {
            return;
        }
        if (this.bn == null || !this.bn.f19981T) {
            m19430t(z);
        } else {
            this.bn.m19685a(z);
        }
    }

    public final void aG() {
        m19429s(false);
    }

    public final boolean aH() {
        return this.aY && aF();
    }

    public final boolean aI() {
        return this.aA;
    }

    public final boolean aJ() {
        int i = VideoCaptureDeviceInfoAndroid.f21167c;
        if (i < 0 || this.aA || VideoCaptureDeviceInfoAndroid.m21593a(i).orientation != 90) {
            return false;
        }
        return true;
    }

    private void m19430t(boolean z) {
        Intent a = m19393a("com.facebook.rtc.fbwebrtc.intent.action.SHOW_UI");
        a.putExtra("AUTO_ACCEPT", z);
        this.f19574i.a(a, this.f19572g);
    }

    public final void aK() {
        if (!(m19486x() || m19485w() || this.bc)) {
            m19453a(AudioOutput.SPEAKERPHONE);
        }
        this.bb = true;
    }

    public final void aM() {
        if (m19470e()) {
            m19410a(m19436L(), true);
        } else if (this.f19563V != null) {
            this.f19563V.a(m19436L(), true, true, true);
        }
    }

    public final void aN() {
        if (m19470e()) {
            m19410a("", false);
        } else if (this.f19563V != null) {
            this.f19563V.a("", false, true, true);
        }
    }

    private void m19410a(String str, boolean z) {
        if (this.ae != null) {
            this.ae.setCameraId(str);
            this.ae.configureVideo(z);
            this.ae.join();
        }
    }

    private void bS() {
        aZ();
        bU();
    }

    public final void aO() {
        if (this.bn != null && this.ap != LocalVideoState.STARTED) {
            this.bn.m19702t();
        }
    }

    public void OnUserStateUpdate(final ConferenceCall conferenceCall, final String[] strArr, final int[] iArr) {
        Preconditions.checkArgument(strArr.length == iArr.length);
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19510d;

            public void run() {
                this.f19510d.m19412a(strArr, iArr);
            }
        }, -1053230321);
    }

    private void m19412a(String[] strArr, int[] iArr) {
        Object obj = null;
        if (strArr == null) {
            BLog.b("WebrtcUiHandler", "Empty new users for user state update.");
        } else if (iArr == null) {
            BLog.b("WebrtcUiHandler", "Empty new states for user state update.");
        } else if (strArr.length != iArr.length) {
            BLog.b("WebrtcUiHandler", "Mismatch length between new users and new sates for user state update.");
        } else {
            int i;
            if (this.af == null) {
                this.af = new HashMap();
            }
            int size = this.af.size();
            int i2 = 0;
            Object obj2 = null;
            int i3 = 0;
            while (i2 < strArr.length) {
                Object obj3 = strArr[i2];
                if (this.f19573h.a().contentEquals(obj3)) {
                    obj3 = obj2;
                    i = i3;
                } else {
                    int i4;
                    Object obj4;
                    Object obj5;
                    ParticipantCallState participantCallState = this.af.containsKey(obj3) ? ((RtcConferenceParticipantInfo) this.af.get(obj3)).f19833a : ParticipantCallState.UNKNOWN;
                    ParticipantCallState participantCallState2 = ParticipantCallState.values()[iArr[i2]];
                    if (participantCallState2 == ParticipantCallState.CONNECTED) {
                        i4 = i3 + 1;
                    } else {
                        i4 = i3;
                    }
                    if (obj2 == null) {
                        obj2 = (participantCallState == ParticipantCallState.CONNECTED || participantCallState2 != ParticipantCallState.CONNECTED) ? null : 1;
                        obj4 = obj2;
                    } else {
                        obj4 = obj2;
                    }
                    if (obj == null) {
                        Object obj6 = (participantCallState != ParticipantCallState.CONNECTED || participantCallState2 == ParticipantCallState.CONNECTED) ? null : 1;
                        obj5 = obj6;
                    } else {
                        obj5 = obj;
                    }
                    if (this.af.containsKey(obj3)) {
                        ((RtcConferenceParticipantInfo) this.af.get(obj3)).f19833a = participantCallState2;
                        obj = obj5;
                        obj3 = obj4;
                        i = i4;
                    } else {
                        this.af.put(obj3, new RtcConferenceParticipantInfo(obj3, participantCallState2, aE(), 0));
                        obj = obj5;
                        obj3 = obj4;
                        i = i4;
                    }
                }
                i2++;
                obj2 = obj3;
                i3 = i;
            }
            if (m19473g() && this.ag != null && (!this.af.containsKey(this.ag.f19834b) || this.ag.f19833a == ParticipantCallState.DISCONNECTED)) {
                m19459a("", "", false, true);
            }
            if (size <= 1 && this.af.size() >= 2) {
                this.ba = true;
                bS();
            }
            if (m19473g()) {
                i = this.f19560S.size();
                for (int i5 = 0; i5 < i; i5++) {
                    ((DefaultRtcUiCallback) this.f19560S.get(i5)).mo800p();
                }
            } else if (this.af.size() == 1 && ((RtcConferenceParticipantInfo) Iterables.a(this.af.values(), 0)).f19833a == ParticipantCallState.RINGING) {
                bz(this);
            }
            if (aB() && i3 > 0) {
                this.aM = aE();
                this.f19555N.m19285d();
                this.f19555N.m19286f();
                bx();
                bC();
                m19426o(this.ae.isVideoEnabled());
                bT();
            }
            if (!m19473g()) {
                return;
            }
            if (obj2 != null) {
                this.f19555N.m19281a(Tone.CONFERENCE_JOIN);
            } else if (obj != null) {
                this.f19555N.m19281a(Tone.CONFERENCE_LEAVE);
            }
        }
    }

    public final boolean aQ() {
        String packageName = this.f19572g.getPackageName();
        List<RunningAppProcessInfo> runningAppProcesses = this.f19570e.getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (Arrays.asList(runningAppProcessInfo.pkgList).contains(packageName)) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    public void onCallJoined(final ConferenceCall conferenceCall, final String[] strArr) {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19513c;

            public void run() {
                if (strArr != null && strArr.length != 0) {
                    int[] iArr = new int[strArr.length];
                    Arrays.fill(iArr, ParticipantCallState.CONNECTED.ordinal());
                    this.f19513c.m19412a(strArr, iArr);
                }
            }
        }, -2104951029);
    }

    public void onMediaConnectionUpdate(ConferenceCall conferenceCall, boolean z) {
    }

    public void onMediaStatusUpdate(ConferenceCall conferenceCall, long[] jArr, String[] strArr, String[] strArr2, int[] iArr, boolean[] zArr) {
        final ConferenceCall conferenceCall2 = conferenceCall;
        final long[] jArr2 = jArr;
        final String[] strArr3 = strArr;
        final String[] strArr4 = strArr2;
        final int[] iArr2 = iArr;
        final boolean[] zArr2 = zArr;
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19520g;

            public void run() {
                this.f19520g.m19408a(conferenceCall2, jArr2, strArr3, strArr4, iArr2, zArr2);
            }
        }, -338650299);
    }

    public void onDominantSpeakerUpdate(ConferenceCall conferenceCall, final String str, final String str2) {
        ExecutorDetour.a(this.f19587v, new Runnable(this) {
            final /* synthetic */ WebrtcUiHandler f19523c;

            public void run() {
                if (this.f19523c.m19473g() && !this.f19523c.ah) {
                    this.f19523c.m19459a(str, str2, false, false);
                }
            }
        }, -85366408);
    }

    final void m19459a(String str, String str2, boolean z, boolean z2) {
        int i = 0;
        if (this.ae != null && this.af != null) {
            this.ah = z;
            ConferenceCall conferenceCall;
            if (this.ag == null || !this.ag.f19834b.contentEquals(str)) {
                if (!(this.aw == 0 || this.bG == null)) {
                    this.f19563V.a(this.aw, null);
                }
                boolean z3 = this.aq;
                if (!z && StringUtil.a(str)) {
                    for (RtcConferenceParticipantInfo rtcConferenceParticipantInfo : this.af.values()) {
                        if (rtcConferenceParticipantInfo.f19840h) {
                            str = rtcConferenceParticipantInfo.f19834b;
                            str2 = rtcConferenceParticipantInfo.f19838f;
                            break;
                        } else if (StringUtil.a(str)) {
                            str = rtcConferenceParticipantInfo.f19834b;
                            str2 = rtcConferenceParticipantInfo.f19838f;
                        }
                    }
                }
                RtcConferenceParticipantInfo rtcConferenceParticipantInfo2 = (RtcConferenceParticipantInfo) this.af.get(str);
                int size;
                if (rtcConferenceParticipantInfo2 == null || !rtcConferenceParticipantInfo2.f19840h) {
                    this.aq = false;
                    this.av = null;
                    this.aw = 0;
                    this.ag = null;
                    this.ah = false;
                    if (z3) {
                        size = this.f19560S.size();
                        while (i < size) {
                            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo796l();
                            i++;
                        }
                        return;
                    }
                    return;
                }
                this.ag = rtcConferenceParticipantInfo2;
                this.ah = z;
                rtcConferenceParticipantInfo2.f19838f = str2;
                this.aq = true;
                this.bs = TriState.YES;
                this.av = rtcConferenceParticipantInfo2.f19838f;
                this.aw = rtcConferenceParticipantInfo2.f19839g;
                if (z2) {
                    conferenceCall = this.ae;
                    if (!z) {
                        str2 = "";
                    }
                    conferenceCall.subscribeSingleRemoteVideoStream(str, str2, this.ag.f19839g);
                }
                int size2 = this.f19560S.size();
                for (size = 0; size < size2; size++) {
                    ((DefaultRtcUiCallback) this.f19560S.get(size)).mo803s();
                }
                if (this.bG != null) {
                    this.f19563V.a(this.aw, this.bG);
                    return;
                }
                size = this.f19560S.size();
                while (i < size) {
                    ((DefaultRtcUiCallback) this.f19560S.get(i)).mo795k();
                    i++;
                }
            } else if (z2) {
                conferenceCall = this.ae;
                if (!z) {
                    str2 = "";
                }
                conferenceCall.subscribeSingleRemoteVideoStream(str, str2, this.ag.f19839g);
            }
        }
    }

    public void onDataMessage(ConferenceCall conferenceCall, String str, String str2, byte[] bArr) {
    }

    public void onCallEnded(ConferenceCall conferenceCall, int i, String str) {
    }

    private void m19418b(String[] strArr) {
        this.af = new HashMap();
        int i = 0;
        while (i < strArr.length) {
            long aE = aE();
            if (!(StringUtil.a(strArr[i]) || strArr[i].contentEquals(this.f19573h.mUserId))) {
                RtcConferenceParticipantInfo rtcConferenceParticipantInfo = new RtcConferenceParticipantInfo(strArr[i], ParticipantCallState.UNKNOWN, aE, 0);
                this.af.put(rtcConferenceParticipantInfo.f19834b, rtcConferenceParticipantInfo);
            }
            i++;
        }
    }

    @Nullable
    public final ImmutableList<RtcConferenceParticipantInfo> aS() {
        return ImmutableList.copyOf(new ArrayList(this.af.values()));
    }

    private void bT() {
        int size = this.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo801q();
        }
    }

    private void bU() {
        int size = this.f19560S.size();
        for (int i = 0; i < size; i++) {
            ((DefaultRtcUiCallback) this.f19560S.get(i)).mo799o();
        }
    }
}
