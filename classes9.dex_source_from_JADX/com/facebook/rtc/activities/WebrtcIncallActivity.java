package com.facebook.rtc.activities;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings.System;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.appstate.ManualUserInteractionTrackingActivity;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.IntendedAudience;
import com.facebook.config.application.Product;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.badges.BadgesExperimentController;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.RtcRedirectHandlerMethodAutoProvider;
import com.facebook.rtc.RtcThreadDataHandlerMethodAutoProvider;
import com.facebook.rtc.VoipMessageCreatorMethodAutoProvider;
import com.facebook.rtc.VoipNotificationPreferencesMethodAutoProvider;
import com.facebook.rtc.WebrtcCallStatusObserverMethodAutoProvider;
import com.facebook.rtc.dialogs.RtcBluetoothSelectorDialog;
import com.facebook.rtc.dialogs.RtcBluetoothSelectorDialog.UpdateButtonsCallback;
import com.facebook.rtc.dialogs.RtcBluetoothSelectorDialogProvider;
import com.facebook.rtc.fbwebrtc.VideoParticipantsAdapter;
import com.facebook.rtc.fbwebrtc.VideoParticipantsAdapterProvider;
import com.facebook.rtc.fbwebrtc.WebrtcPrefKeys;
import com.facebook.rtc.fbwebrtc.WebrtcSurveyHandler;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.AudioOutput;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.LocalVideoState;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.NameChangedListener;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.fbwebrtc.adapters.VoipConferenceRosterListAdapter;
import com.facebook.rtc.fbwebrtc.adapters.VoipConferenceRosterListAdapterProvider;
import com.facebook.rtc.fragments.WebrtcCommentDialogFragment;
import com.facebook.rtc.fragments.WebrtcDialogFragment;
import com.facebook.rtc.fragments.WebrtcDialogFragment.WebrtcSurveyListener;
import com.facebook.rtc.fragments.WebrtcRatingDialogFragment;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.rtc.helpers.RtcCallStartParams;
import com.facebook.rtc.interfaces.DefaultRtcUiCallback;
import com.facebook.rtc.interfaces.RtcRedirectHandler;
import com.facebook.rtc.interfaces.RtcThreadDataHandler;
import com.facebook.rtc.interfaces.VoipMessageCreator;
import com.facebook.rtc.interfaces.VoipNotificationPreferences;
import com.facebook.rtc.interfaces.VoipVoiceClipComposer;
import com.facebook.rtc.interfaces.WebrtcCallStatusObserver;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.prefs.InternalVoipPrefKeys;
import com.facebook.rtc.views.RtcActionBar;
import com.facebook.rtc.views.RtcActionBar.ActionBarType;
import com.facebook.rtc.views.RtcActionBar.Listener;
import com.facebook.rtc.views.RtcLevelTileView;
import com.facebook.rtc.views.RtcSnakeView;
import com.facebook.rtc.views.VoipConnectionBanner;
import com.facebook.rtc.views.VoipConnectionBanner.Theme;
import com.facebook.rtc.views.VoipDragSelfView;
import com.facebook.rtc.views.VoipDragSelfView.MarginChangedCallback;
import com.facebook.rtc.views.VoipVideoView;
import com.facebook.rtc.views.VoipVideoView.C23895;
import com.facebook.rtc.views.WebrtcIncallView;
import com.facebook.rtc.views.WebrtcIncomingCallView;
import com.facebook.rtc.views.WebrtcNoAnswerView;
import com.facebook.rtc.views.WebrtcRedialView;
import com.facebook.rtc.views.WebrtcRosterIncallView;
import com.facebook.rtc.views.WebrtcVideoRequestView;
import com.facebook.rtc.voicemail.VoicemailHandler;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.webrtc.IWebrtcUiInterface.EndCallReason;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.tiles.ThreadTileView;
import com.facebook.widget.tiles.TileBadge;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.webrtc.videoengine.VideoCaptureAndroid;

/* compiled from: autosave */
public class WebrtcIncallActivity extends FbFragmentActivity implements ManualUserInteractionTrackingActivity, WebrtcSurveyListener, MarginChangedCallback {
    private static final String[] f19170V = new String[]{"android.permission.RECORD_AUDIO"};
    private static final String[] f19171W = new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"};
    public static final Class<?> ah = WebrtcIncallActivity.class;
    @Inject
    public VoipMessageCreator f19172A;
    @Inject
    public RtcRedirectHandler f19173B;
    @Inject
    @IsWorkBuild
    public Boolean f19174C;
    @Inject
    public Lazy<AppStateManager> f19175D;
    @Inject
    Lazy<DeviceConditionHelper> f19176E;
    @Inject
    @ForUiThread
    Lazy<ScheduledExecutorService> f19177F;
    @Inject
    public Lazy<VoipVoiceClipComposer> f19178G;
    @Inject
    public QeAccessor f19179H;
    @Inject
    ActivityRuntimePermissionsManagerProvider f19180I;
    @Inject
    VideoParticipantsAdapterProvider f19181J;
    @Inject
    AbstractFbErrorReporter f19182K;
    @Inject
    RtcBluetoothSelectorDialogProvider f19183L;
    @Inject
    RtcThreadDataHandler f19184M;
    @Inject
    WebrtcCallStatusObserver f19185N;
    @Inject
    Clock f19186O;
    @Inject
    VoipNotificationPreferences f19187P;
    @Inject
    VoipConferenceRosterListAdapterProvider f19188Q;
    @Inject
    FbZeroFeatureVisibilityHelper f19189R;
    @Inject
    public SecureContextHelper f19190S;
    @Inject
    public Toaster f19191T;
    @Inject
    GatekeeperStoreImpl f19192U;
    private boolean f19193X;
    public boolean f19194Y;
    private boolean f19195Z;
    private LinearLayout aA;
    public VoipDragSelfView aB;
    public RtcActionBar aC;
    public C22604 aD;
    private ThreadTileView aE;
    private View aF;
    private UserTileView aG;
    public RtcLevelTileView aH;
    public TextView aI;
    private TextView aJ;
    private VoipConnectionBanner aK;
    private View aL;
    private View aM;
    public ListView aN;
    public FrameLayout aO;
    public VoipVideoView aP;
    public RecyclerView aQ;
    public int aR = 0;
    public int aS;
    private long aT;
    public boolean aU;
    private boolean aV;
    public long aW;
    private boolean aX;
    private boolean aY = false;
    public boolean aZ;
    public boolean aa;
    private ContentObserver ab;
    public boolean ac;
    public boolean ad;
    private NameChangedListener ae;
    public boolean af;
    private WebrtcViewState ag;
    public long ai;
    public boolean aj;
    public VideoParticipantsAdapter ak;
    public RtcBluetoothSelectorDialog al;
    public VoipConferenceRosterListAdapter am;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<WebrtcUiHandler> an = UltralightRuntime.b;
    public Future<?> ao;
    public Future<?> ap = null;
    public AlertDialog aq;
    private DefaultRtcUiCallback ar;
    private WebrtcIncomingCallView as;
    public WebrtcIncallView at;
    private WebrtcRosterIncallView au;
    private WebrtcRedialView av;
    private WebrtcNoAnswerView aw;
    private WebrtcVideoRequestView ax;
    private View ay;
    public RtcSnakeView az;
    public int ba;
    public int bb;
    public boolean bc;
    private ActivityRuntimePermissionsManager bd;
    @Inject
    public AudioManager f19196p;
    @Inject
    BadgesExperimentController f19197q;
    @Inject
    public FbAppType f19198r;
    @Inject
    public FbSharedPreferences f19199s;
    @Inject
    public PowerManager f19200t;
    @Inject
    FbWakeLockManager f19201u;
    @Inject
    public RtcCallHandler f19202v;
    @Inject
    public WebrtcLoggingHandler f19203w;
    @Inject
    public WebrtcSurveyHandler f19204x;
    @Inject
    WindowManager f19205y;
    @Inject
    public VoicemailHandler f19206z;

    /* compiled from: autosave */
    public /* synthetic */ class AnonymousClass26 {
        public static final /* synthetic */ int[] f19151a = new int[EndCallReason.values().length];

        static {
            f19152b = new int[WebrtcViewState.values().length];
            try {
                f19152b[WebrtcViewState.INCOMING_CALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19152b[WebrtcViewState.INCALL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19152b[WebrtcViewState.INCALL_GROUP_ESCALATED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19152b[WebrtcViewState.NO_ANSWER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19152b[WebrtcViewState.REDIAL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19152b[WebrtcViewState.VIDEO_REQUEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f19151a[EndCallReason.CallEndNoAnswerTimeout.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f19151a[EndCallReason.CallEndIgnoreCall.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f19151a[EndCallReason.CallEndClientInterrupted.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f19151a[EndCallReason.CallEndHangupCall.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f19151a[EndCallReason.CallEndAcceptAfterHangUp.ordinal()] = 5;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f19151a[EndCallReason.CallEndNoPermission.ordinal()] = 6;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f19151a[EndCallReason.CallEndIncomingTimeout.ordinal()] = 7;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f19151a[EndCallReason.CallEndOtherNotCapable.ordinal()] = 8;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f19151a[EndCallReason.CallEndOtherCarrierBlocked.ordinal()] = 9;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f19151a[EndCallReason.CallEndSignalingMessageFailed.ordinal()] = 10;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f19151a[EndCallReason.CallEndWebRTCError.ordinal()] = 11;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f19151a[EndCallReason.CallEndClientError.ordinal()] = 12;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f19151a[EndCallReason.CallEndNoUIError.ordinal()] = 13;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f19151a[EndCallReason.CallEndUnsupportedVersion.ordinal()] = 14;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f19151a[EndCallReason.CallEndCallerNotVisible.ordinal()] = 15;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f19151a[EndCallReason.CallEndConnectionDropped.ordinal()] = 16;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f19151a[EndCallReason.CallEndInAnotherCall.ordinal()] = 17;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f19151a[EndCallReason.CallEndCarrierBlocked.ordinal()] = 18;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f19151a[EndCallReason.CallEndOtherInstanceHandled.ordinal()] = 19;
            } catch (NoSuchFieldError e25) {
            }
        }
    }

    /* compiled from: autosave */
    class C22582 implements Listener {
        final /* synthetic */ WebrtcIncallActivity f19153a;

        C22582(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19153a = webrtcIncallActivity;
        }

        public final void mo771a() {
            if (this.f19153a.f19198r.j != Product.MESSENGER) {
                this.f19153a.finish();
            } else if (((WebrtcUiHandler) this.f19153a.an.get()).m19473g() && ((WebrtcUiHandler) this.f19153a.an.get()).ab()) {
                r0 = this.f19153a.f19173B;
                ((WebrtcUiHandler) this.f19153a.an.get()).aa();
            } else {
                r0 = this.f19153a.f19173B;
                String.valueOf(this.f19153a.ai);
            }
        }

        public final void mo772b() {
        }

        public final void mo773c() {
        }
    }

    /* compiled from: autosave */
    class C22593 implements UpdateButtonsCallback {
        final /* synthetic */ WebrtcIncallActivity f19154a;

        C22593(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19154a = webrtcIncallActivity;
        }

        public final void mo774a() {
            WebrtcIncallActivity.m19245t(this.f19154a);
        }
    }

    /* compiled from: autosave */
    public class C22604 {
        public final /* synthetic */ WebrtcIncallActivity f19155a;

        C22604(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19155a = webrtcIncallActivity;
        }

        public final void m19130e() {
            if (this.f19155a.f19198r.j != Product.MESSENGER) {
                this.f19155a.finish();
            } else if (((WebrtcUiHandler) this.f19155a.an.get()).m19473g() && ((WebrtcUiHandler) this.f19155a.an.get()).ab()) {
                r0 = this.f19155a.f19173B;
                ((WebrtcUiHandler) this.f19155a.an.get()).aa();
            } else {
                r0 = this.f19155a.f19173B;
                String.valueOf(this.f19155a.ai);
            }
        }
    }

    /* compiled from: autosave */
    class C22675 extends DefaultRtcUiCallback {
        final /* synthetic */ WebrtcIncallActivity f19164a;

        /* compiled from: autosave */
        class C22611 implements Runnable {
            final /* synthetic */ C22675 f19156a;

            C22611(C22675 c22675) {
                this.f19156a = c22675;
            }

            public void run() {
                WebrtcIncallActivity.m19249x(this.f19156a.f19164a);
            }
        }

        /* compiled from: autosave */
        class C22622 implements Runnable {
            final /* synthetic */ C22675 f19157a;

            C22622(C22675 c22675) {
                this.f19157a = c22675;
            }

            public void run() {
                WebrtcIncallActivity.m19203D(this.f19157a.f19164a);
            }
        }

        /* compiled from: autosave */
        class C22633 implements Runnable {
            final /* synthetic */ C22675 f19158a;

            C22633(C22675 c22675) {
                this.f19158a = c22675;
            }

            public void run() {
                this.f19158a.f19164a.f19196p.adjustStreamVolume(0, 1, 5);
            }
        }

        /* compiled from: autosave */
        class C22644 implements Runnable {
            final /* synthetic */ C22675 f19159a;

            C22644(C22675 c22675) {
                this.f19159a = c22675;
            }

            public void run() {
                this.f19159a.f19164a.f19196p.adjustStreamVolume(0, -1, 5);
            }
        }

        /* compiled from: autosave */
        class C22655 implements Runnable {
            final /* synthetic */ C22675 f19160a;

            C22655(C22675 c22675) {
                this.f19160a = c22675;
            }

            public void run() {
                int a = this.f19160a.f19164a.aP.m19917a(this.f19160a.f19164a.kO_());
                if (a > 0) {
                    this.f19160a.f19164a.aP.m19921b(a);
                }
                this.f19160a.f19164a.ap = null;
            }
        }

        C22675(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19164a = webrtcIncallActivity;
        }

        public final void mo775a() {
            this.f19164a.runOnUiThread(new C22611(this));
        }

        public final void mo782b() {
            this.f19164a.aU = true;
        }

        public final void mo785c() {
            WebrtcIncallActivity.m19236e(this.f19164a, true);
        }

        public final void mo787d() {
            WebrtcIncallActivity.m19236e(this.f19164a, false);
        }

        public final void mo789e() {
            this.f19164a.runOnUiThread(new C22622(this));
        }

        public final void mo790f() {
            this.f19164a.runOnUiThread(new C22633(this));
        }

        public final void mo791g() {
            this.f19164a.runOnUiThread(new C22644(this));
        }

        public final void mo779a(boolean z) {
            this.f19164a.setVolumeControlStream(0);
            if (((WebrtcUiHandler) this.f19164a.an.get()).bu) {
                ((WebrtcUiHandler) this.f19164a.an.get()).m19463b(this.f19164a);
            }
            WebrtcIncallActivity.m19228b(this.f19164a, this.f19164a.getString(2131232004));
            if (this.f19164a.at != null) {
                this.f19164a.at.f20335f.setVisibility(4);
            }
            if (!z) {
                WebrtcIncallActivity.m19241p(this.f19164a);
            } else if (!((WebrtcUiHandler) this.f19164a.an.get()).aH()) {
                WebrtcIncallActivity.m19236e(this.f19164a, true);
                WebrtcIncallActivity.am(this.f19164a);
                if (this.f19164a.aP != null) {
                    this.f19164a.aP.m19920a(this.f19164a.getString(2131231979, new Object[]{((WebrtcUiHandler) this.f19164a.an.get()).aj()}), false);
                    if (this.f19164a.f19198r.j == Product.MESSENGER && ((WebrtcUiHandler) this.f19164a.an.get()).aF() && ((WebrtcUiHandler) this.f19164a.an.get()).as() && ((WebrtcUiHandler) this.f19164a.an.get()).m19437M() && this.f19164a.ap == null) {
                        this.f19164a.ap = ((ScheduledExecutorService) this.f19164a.f19177F.get()).schedule(new C22655(this), 8000, TimeUnit.MILLISECONDS);
                    } else {
                        this.f19164a.aP.m19929p();
                    }
                    if (((WebrtcUiHandler) this.f19164a.an.get()).m19473g()) {
                        WebrtcIncallActivity webrtcIncallActivity = this.f19164a;
                        VideoParticipantsAdapterProvider videoParticipantsAdapterProvider = this.f19164a.f19181J;
                        VideoParticipantsAdapter videoParticipantsAdapter = new VideoParticipantsAdapter(((WebrtcUiHandler) this.f19164a.an.get()).aS());
                        videoParticipantsAdapter.f19378d = IdBasedLazy.a(videoParticipantsAdapterProvider, 10375);
                        webrtcIncallActivity.ak = videoParticipantsAdapter;
                        this.f19164a.aQ.setVisibility(0);
                        this.f19164a.aQ.setAdapter(this.f19164a.ak);
                    }
                }
            }
            WebrtcIncallActivity.aa(this.f19164a);
        }

        public final void mo792h() {
            WebrtcIncallActivity.m19217Y(this.f19164a);
        }

        public final boolean mo781a(long j, boolean z, boolean z2, boolean z3) {
            String string;
            this.f19164a.aW = j;
            this.f19164a.ac = ((WebrtcUiHandler) this.f19164a.an.get()).as();
            this.f19164a.aC.m19745a(null);
            WebrtcIncallActivity webrtcIncallActivity = this.f19164a;
            switch (AnonymousClass26.f19151a[((WebrtcUiHandler) this.f19164a.an.get()).bj.ordinal()]) {
                case 1:
                case 2:
                    if (!((WebrtcUiHandler) webrtcIncallActivity.an.get()).aB) {
                        string = webrtcIncallActivity.getString(2131232009);
                        break;
                    }
                    string = webrtcIncallActivity.getString(2131232013);
                    break;
                case 3:
                    string = webrtcIncallActivity.getString(2131232010);
                    break;
                case 4:
                case 5:
                    string = webrtcIncallActivity.getString(2131232009);
                    break;
                case 6:
                    string = webrtcIncallActivity.getString(2131232174, new Object[]{((WebrtcUiHandler) webrtcIncallActivity.an.get()).aj()});
                    break;
                case 7:
                case 8:
                case 9:
                    if (!((WebrtcUiHandler) webrtcIncallActivity.an.get()).aB) {
                        string = webrtcIncallActivity.getString(2131232009);
                        break;
                    }
                    string = webrtcIncallActivity.getString(2131232012);
                    break;
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    string = webrtcIncallActivity.getString(2131232011);
                    break;
                case 16:
                    string = webrtcIncallActivity.getString(2131232015);
                    break;
                case 17:
                    string = webrtcIncallActivity.getString(2131232014, new Object[]{((WebrtcUiHandler) webrtcIncallActivity.an.get()).ai()});
                    break;
                case 18:
                    string = webrtcIncallActivity.getString(2131232016);
                    break;
                case 19:
                    string = "";
                    break;
                default:
                    string = webrtcIncallActivity.getString(2131232009);
                    break;
            }
            String str = string;
            WebrtcIncallActivity.m19222a(this.f19164a, str, true);
            WebrtcIncallActivity.m19228b(this.f19164a, str);
            if (!WebrtcIncallActivity.m19230b(this.f19164a, WebrtcViewState.INCOMING_CALL) || this.f19164a.af) {
                WebrtcIncallActivity.m19236e(this.f19164a, false);
            }
            if (((WebrtcUiHandler) this.f19164a.an.get()).m19473g()) {
                WebrtcIncallActivity.m19202C(this.f19164a);
                if (!(this.f19164a.ad && WebrtcIncallActivity.m19225a(this.f19164a, ((WebrtcUiHandler) this.f19164a.an.get()).bj, z2))) {
                    this.f19164a.f19203w.h();
                }
            } else if (j == 0 || ((WebrtcUiHandler) this.f19164a.an.get()).ap()) {
                this.f19164a.finish();
            } else if (WebrtcIncallActivity.m19231b(this.f19164a, ((WebrtcUiHandler) this.f19164a.an.get()).bj)) {
                r3 = WebrtcIncallActivity.ah;
                r3 = ((WebrtcUiHandler) this.f19164a.an.get()).bj;
                WebrtcIncallActivity.m19227b(this.f19164a, j);
                this.f19164a.f19203w.h();
            } else if (WebrtcIncallActivity.m19232b(this.f19164a, ((WebrtcUiHandler) this.f19164a.an.get()).bj, z)) {
                r3 = WebrtcIncallActivity.ah;
                r3 = ((WebrtcUiHandler) this.f19164a.an.get()).bj;
                WebrtcIncallActivity.m19244s(this.f19164a);
                WebrtcIncallActivity.m19211R(this.f19164a);
            } else if (((WebrtcUiHandler) this.f19164a.an.get()).m19442S()) {
                WebrtcIncallActivity.m19244s(this.f19164a);
                WebrtcIncallActivity.m19202C(this.f19164a);
                if (!(this.f19164a.ad && WebrtcIncallActivity.m19225a(this.f19164a, ((WebrtcUiHandler) this.f19164a.an.get()).bj, z2))) {
                    this.f19164a.f19203w.h();
                }
            } else {
                this.f19164a.f19203w.h();
                WebrtcIncallActivity.m19202C(this.f19164a);
            }
            if (!((WebrtcUiHandler) this.f19164a.an.get()).m19445W()) {
                WebrtcIncallActivity.m19210Q(this.f19164a);
            }
            WebrtcIncallActivity.av(this.f19164a);
            WebrtcCallStatusObserver webrtcCallStatusObserver = this.f19164a.f19185N;
            return true;
        }

        public final void mo793i() {
            if (!(WebrtcIncallActivity.m19230b(this.f19164a, WebrtcViewState.VIDEO_REQUEST) || this.f19164a.bc || this.f19164a.af)) {
                WebrtcIncallActivity.m19228b(this.f19164a, ((WebrtcUiHandler) this.f19164a.an.get()).m19438O());
            }
            if (((WebrtcUiHandler) this.f19164a.an.get()).m19473g()) {
                this.f19164a.aC.m19745a(((WebrtcUiHandler) this.f19164a.an.get()).m19438O());
            }
            WebrtcIncallActivity webrtcIncallActivity = this.f19164a;
            int i = webrtcIncallActivity.aR + 1;
            webrtcIncallActivity.aR = i;
            if (i % 3 <= 0) {
                if (!(((WebrtcUiHandler) this.f19164a.an.get()).m19485w() || ((WebrtcUiHandler) this.f19164a.an.get()).m19486x() == this.f19164a.f19196p.isSpeakerphoneOn())) {
                    WebrtcIncallActivity.m19203D(this.f19164a);
                    if (((WebrtcUiHandler) this.f19164a.an.get()).am()) {
                        this.f19164a.f19203w.a("Speaker state inconsistent: turning " + (((WebrtcUiHandler) this.f19164a.an.get()).m19486x() ? "on" : "off"));
                    }
                }
                if (((WebrtcUiHandler) this.f19164a.an.get()).f19584s.isMicrophoneMute()) {
                    mo801q();
                    if (((WebrtcUiHandler) this.f19164a.an.get()).am()) {
                        String str;
                        WebrtcLoggingHandler webrtcLoggingHandler = this.f19164a.f19203w;
                        StringBuilder stringBuilder = new StringBuilder("Mute state inconsistent: turning ");
                        if (((WebrtcUiHandler) this.f19164a.an.get()).m19484u()) {
                            str = "on";
                        } else {
                            str = "off";
                        }
                        webrtcLoggingHandler.a(stringBuilder.append(str).toString());
                    }
                }
            }
        }

        public final void mo794j() {
            mo801q();
        }

        public final void mo795k() {
            if (((WebrtcUiHandler) this.f19164a.an.get()).ak == 3 && !((WebrtcUiHandler) this.f19164a.an.get()).aH()) {
                if (this.f19164a.ad) {
                    WebrtcIncallActivity.am(this.f19164a);
                } else if (((WebrtcUiHandler) this.f19164a.an.get()).aF()) {
                    WebrtcIncallActivity.am(this.f19164a);
                    ((WebrtcUiHandler) this.f19164a.an.get()).m19479k(true);
                }
            }
        }

        public final void mo783b(final int i, final int i2) {
            this.f19164a.runOnUiThread(new Runnable(this) {
                final /* synthetic */ C22675 f19163c;

                public void run() {
                    this.f19163c.f19164a.ba = i;
                    this.f19163c.f19164a.bb = i2;
                    if (this.f19163c.f19164a.aB != null && this.f19163c.f19164a.ba != 0 && this.f19163c.f19164a.bb != 0) {
                        this.f19163c.f19164a.aB.setTextureAspectRatio(((float) this.f19163c.f19164a.ba) / ((float) this.f19163c.f19164a.bb));
                    }
                }
            });
        }

        public final void mo796l() {
            if (this.f19164a.ad && ((WebrtcUiHandler) this.f19164a.an.get()).ak == 3) {
                WebrtcIncallActivity.an(this.f19164a);
            }
        }

        public final void mo784b(boolean z) {
            if (!z) {
                WebrtcIncallActivity.m19236e(this.f19164a, false);
                WebrtcIncallActivity.m19244s(this.f19164a);
            } else if (((WebrtcUiHandler) this.f19164a.an.get()).as()) {
                WebrtcIncallActivity.m19206J(this.f19164a);
                ((WebrtcUiHandler) this.f19164a.an.get()).m19476i(true);
            } else {
                WebrtcIncallActivity.ak(this.f19164a);
            }
        }

        public final void mo786c(boolean z) {
            this.f19164a.bc = false;
            if (!this.f19164a.ad) {
                return;
            }
            if (z) {
                WebrtcIncallActivity.am(this.f19164a);
            } else {
                WebrtcIncallActivity.m19236e(this.f19164a, false);
            }
        }

        public final void mo797m() {
            if (this.f19164a.bc && this.f19164a.ad) {
                ((WebrtcUiHandler) this.f19164a.an.get()).bs = TriState.YES;
                WebrtcIncallActivity.am(this.f19164a);
            }
        }

        public final void mo798n() {
            if (!this.f19164a.ad) {
                return;
            }
            if (this.f19164a.bc) {
                this.f19164a.bc = false;
                WebrtcIncallActivity.m19236e(this.f19164a, false);
            } else if (WebrtcIncallActivity.m19230b(this.f19164a, WebrtcViewState.VIDEO_REQUEST)) {
                WebrtcIncallActivity.m19244s(this.f19164a);
            }
        }

        public final void mo777a(int i, int i2) {
            if (this.f19164a.ad && this.f19164a.aP != null && ((WebrtcUiHandler) this.f19164a.an.get()).m19435G()) {
                this.f19164a.aP.m19926h();
            }
        }

        public final void mo799o() {
            WebrtcIncallActivity.aG(this.f19164a);
        }

        public final void mo800p() {
            if (this.f19164a.am == null) {
                this.f19164a.am = this.f19164a.f19188Q.m19503a(((WebrtcUiHandler) this.f19164a.an.get()).aS(), this.f19164a.kO_());
                this.f19164a.am.m19501a();
                this.f19164a.aN.setAdapter(this.f19164a.am);
            } else {
                this.f19164a.am.m19502a(((WebrtcUiHandler) this.f19164a.an.get()).aS());
            }
            if (((WebrtcUiHandler) this.f19164a.an.get()).m19473g() && ((WebrtcUiHandler) this.f19164a.an.get()).as() && this.f19164a.ak != null) {
                this.f19164a.ak.m19361a(((WebrtcUiHandler) this.f19164a.an.get()).aS());
            }
        }

        public final void mo778a(Map<String, Integer> map) {
            if (this.f19164a.am != null) {
                BaseAdapter baseAdapter = this.f19164a.am;
                if (map != null) {
                    Object obj;
                    for (Entry entry : map.entrySet()) {
                        if (baseAdapter.f19619d.containsKey(entry.getKey())) {
                            if (baseAdapter.f19619d.get(entry.getKey()) != entry.getValue()) {
                            }
                        }
                        obj = 1;
                    }
                    for (String containsKey : baseAdapter.f19619d.keySet()) {
                        if (!map.containsKey(containsKey)) {
                            int i = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        AdapterDetour.a(baseAdapter, -70098888);
                        baseAdapter.f19619d = map;
                    }
                }
            }
        }

        public final void mo776a(int i) {
            if (this.f19164a.aH != null) {
                this.f19164a.aH.m19799a(i);
            }
        }

        public final int mo802r() {
            return 1;
        }

        public final void mo801q() {
            WebrtcIncallActivity.m19245t(this.f19164a);
        }

        public final void mo803s() {
            if (this.f19164a.ak != null) {
                VideoParticipantsAdapter videoParticipantsAdapter = this.f19164a.ak;
                videoParticipantsAdapter.f19376b = ((WebrtcUiHandler) this.f19164a.an.get()).ag;
                videoParticipantsAdapter.notifyDataSetChanged();
            }
        }

        public final void mo788d(boolean z) {
            if (z && this.f19164a.ak != null) {
                this.f19164a.ak.m19361a(((WebrtcUiHandler) this.f19164a.an.get()).aS());
            }
            if (this.f19164a.am != null) {
                AdapterDetour.a(this.f19164a.am, -1507714063);
            }
        }

        public final void mo780a(byte[] bArr) {
            if (this.f19164a.az != null) {
                this.f19164a.az.m19829a(bArr);
            }
        }
    }

    /* compiled from: autosave */
    class C22686 implements NameChangedListener {
        final /* synthetic */ WebrtcIncallActivity f19165a;

        C22686(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19165a = webrtcIncallActivity;
        }

        public final void mo804a() {
            this.f19165a.aI.setText(((WebrtcUiHandler) this.f19165a.an.get()).ai());
            if (((WebrtcUiHandler) this.f19165a.an.get()).m19473g() && ((WebrtcUiHandler) this.f19165a.an.get()).aL()) {
                WebrtcIncallActivity.m19240n(this.f19165a);
            }
        }
    }

    /* compiled from: autosave */
    class C22697 implements Runnable {
        final /* synthetic */ WebrtcIncallActivity f19166a;

        C22697(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19166a = webrtcIncallActivity;
        }

        public void run() {
            if (this.f19166a.f19202v.b()) {
                WebrtcIncallActivity.m19239m(this.f19166a);
            }
        }
    }

    /* compiled from: autosave */
    class C22708 implements RuntimePermissionsListener {
        final /* synthetic */ WebrtcIncallActivity f19167a;

        C22708(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19167a = webrtcIncallActivity;
        }

        public final void m19192a() {
            WebrtcIncallActivity.m19247v(this.f19167a);
        }

        public final void m19193a(String[] strArr, String[] strArr2) {
            this.f19167a.f19203w.a("device_permission_denied", true);
            WebrtcIncallActivity.m19250y(this.f19167a);
        }

        public final void m19194b() {
            WebrtcIncallActivity.m19250y(this.f19167a);
        }
    }

    /* compiled from: autosave */
    class C22719 implements OnClickListener {
        final /* synthetic */ WebrtcIncallActivity f19168a;

        C22719(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19168a = webrtcIncallActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((WebrtcUiHandler) this.f19168a.an.get()).m19451a(dialogInterface, i);
            WebrtcIncallActivity.m19250y(this.f19168a);
            WebrtcIncallActivity.m19213U(this.f19168a);
        }
    }

    /* compiled from: autosave */
    class SetSurfaceTextureListener implements SurfaceTextureListener {
        final /* synthetic */ WebrtcIncallActivity f19169a;

        public SetSurfaceTextureListener(WebrtcIncallActivity webrtcIncallActivity) {
            this.f19169a = webrtcIncallActivity;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            WebrtcIncallActivity.m19207K(this.f19169a);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            WebrtcIncallActivity.m19207K(this.f19169a);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (VideoCaptureAndroid.m21569a() != null && VideoCaptureAndroid.m21569a().equals(surfaceTexture)) {
                VideoCaptureAndroid.m21574a(null);
            }
            return false;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: autosave */
    public enum WebrtcViewState {
        INCALL,
        INCALL_GROUP_ESCALATED,
        INCOMING_CALL,
        NO_ANSWER,
        REDIAL,
        VIDEO_REQUEST
    }

    public static void m19223a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((WebrtcIncallActivity) obj).m19218a(AudioManagerMethodAutoProvider.a(fbInjector), BadgesExperimentController.m8364a(fbInjector), (FbAppType) fbInjector.getInstance(FbAppType.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), PowerManagerMethodAutoProvider.a(fbInjector), FbWakeLockManager.a(fbInjector), RtcCallHandler.a(fbInjector), WebrtcLoggingHandler.a(fbInjector), WebrtcSurveyHandler.m19387a(fbInjector), WindowManagerMethodAutoProvider.a(fbInjector), VoicemailHandler.a(fbInjector), VoipMessageCreatorMethodAutoProvider.m19089a(fbInjector), RtcRedirectHandlerMethodAutoProvider.m19087a(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 476), IdBasedSingletonScopeProvider.b(fbInjector, 1050), IdBasedSingletonScopeProvider.b(fbInjector, 3863), IdBasedLazy.a(fbInjector, 10385), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (VideoParticipantsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(VideoParticipantsAdapterProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (RtcBluetoothSelectorDialogProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(RtcBluetoothSelectorDialogProvider.class), RtcThreadDataHandlerMethodAutoProvider.m19088a(fbInjector), WebrtcCallStatusObserverMethodAutoProvider.m19091a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), VoipNotificationPreferencesMethodAutoProvider.m19090a(fbInjector), (VoipConferenceRosterListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(VoipConferenceRosterListAdapterProvider.class), FbZeroFeatureVisibilityHelper.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), Toaster.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 10375));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.f19203w.a("zero_rating_accepted", true);
            m19249x(this);
            return;
        }
        this.f19203w.a("zero_rating_declined", true);
    }

    public final void m19258b(Bundle bundle) {
        Class cls = WebrtcIncallActivity.class;
        m19223a((Object) this, (Context) this);
        long aE = ((WebrtcUiHandler) this.an.get()).aE();
        this.f19202v.e();
        getWindow().setType(2006);
        getWindow().addFlags(2621568);
        if (VERSION.SDK_INT >= 9) {
            Display defaultDisplay = this.f19205y.getDefaultDisplay();
            Point point = new Point();
            if (VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
            if (SizeUtil.b(getResources(), (float) Math.min(point.x, point.y)) >= 470) {
                ay(this);
                this.aZ = true;
            }
        }
        this.ab = new ContentObserver(this, new Handler()) {
            final /* synthetic */ WebrtcIncallActivity f19144a;

            public void onChange(boolean z) {
                if (WebrtcIncallActivity.ax(this.f19144a) && (this.f19144a.aZ || this.f19144a.af)) {
                    WebrtcIncallActivity.ay(this.f19144a);
                } else {
                    WebrtcIncallActivity.az(this.f19144a);
                }
            }
        };
        getContentResolver().registerContentObserver(System.getUriFor("accelerometer_rotation"), true, this.ab);
        this.f19202v.g();
        setContentView(2130907755);
        this.aO = (FrameLayout) a(2131568467);
        this.aL = a(2131568473);
        this.aM = a(2131568471);
        this.aN = (ListView) a(2131568472);
        this.aA = (LinearLayout) a(2131568468);
        this.aF = a(2131568475);
        this.aG = (UserTileView) a(2131568476);
        this.aH = (RtcLevelTileView) a(2131568462);
        this.aE = (ThreadTileView) a(2131568474);
        this.aI = (TextView) a(2131568464);
        this.aJ = (TextView) a(2131568477);
        this.aK = (VoipConnectionBanner) a(2131568470);
        this.az = (RtcSnakeView) a(2131568478);
        this.aB = (VoipDragSelfView) a(2131568479);
        this.aB.m19890a((MarginChangedCallback) this);
        this.aQ = (RecyclerView) a(2131568480);
        RecyclerView recyclerView = this.aQ;
        getApplicationContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(0, false));
        this.aC = (RtcActionBar) a(2131568469);
        this.aC.f20099u = new C22582(this);
        this.al = this.f19183L.m19341a(Boolean.TRUE, new C22593(this));
        this.aD = new C22604(this);
        this.ar = new C22675(this);
        ((WebrtcUiHandler) this.an.get()).m19456a(this.ar);
        m19226b(getIntent());
        this.f19203w.a("ui_init", Long.toString(((WebrtcUiHandler) this.an.get()).aE() - aE));
        if (!((WebrtcUiHandler) this.an.get()).aB && "com.facebook.rtc.fbwebrtc.intent.action.INCOMING_CALL".equals(getIntent().getAction()) && this.f19198r.i == IntendedAudience.DEVELOPMENT && this.f19199s.a(InternalVoipPrefKeys.P, false)) {
            m19249x(this);
        }
        this.bd = this.f19180I.a(this);
    }

    private void m19218a(AudioManager audioManager, BadgesExperimentController badgesExperimentController, FbAppType fbAppType, FbSharedPreferences fbSharedPreferences, PowerManager powerManager, FbWakeLockManager fbWakeLockManager, RtcCallHandler rtcCallHandler, WebrtcLoggingHandler webrtcLoggingHandler, WebrtcSurveyHandler webrtcSurveyHandler, WindowManager windowManager, VoicemailHandler voicemailHandler, VoipMessageCreator voipMessageCreator, RtcRedirectHandler rtcRedirectHandler, Boolean bool, Lazy<AppStateManager> lazy, Lazy<DeviceConditionHelper> lazy2, Lazy<ScheduledExecutorService> lazy3, Lazy<VoipVoiceClipComposer> lazy4, QeAccessor qeAccessor, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, VideoParticipantsAdapterProvider videoParticipantsAdapterProvider, FbErrorReporter fbErrorReporter, RtcBluetoothSelectorDialogProvider rtcBluetoothSelectorDialogProvider, RtcThreadDataHandler rtcThreadDataHandler, WebrtcCallStatusObserver webrtcCallStatusObserver, Clock clock, VoipNotificationPreferences voipNotificationPreferences, VoipConferenceRosterListAdapterProvider voipConferenceRosterListAdapterProvider, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, SecureContextHelper secureContextHelper, Toaster toaster, GatekeeperStore gatekeeperStore, Lazy<WebrtcUiHandler> lazy5) {
        this.f19196p = audioManager;
        this.f19197q = badgesExperimentController;
        this.f19198r = fbAppType;
        this.f19199s = fbSharedPreferences;
        this.f19200t = powerManager;
        this.f19201u = fbWakeLockManager;
        this.f19202v = rtcCallHandler;
        this.f19203w = webrtcLoggingHandler;
        this.f19204x = webrtcSurveyHandler;
        this.f19205y = windowManager;
        this.f19206z = voicemailHandler;
        this.f19172A = voipMessageCreator;
        this.f19173B = rtcRedirectHandler;
        this.f19174C = bool;
        this.f19175D = lazy;
        this.f19176E = lazy2;
        this.f19177F = lazy3;
        this.f19178G = lazy4;
        this.f19179H = qeAccessor;
        this.f19180I = activityRuntimePermissionsManagerProvider;
        this.f19181J = videoParticipantsAdapterProvider;
        this.f19182K = fbErrorReporter;
        this.f19183L = rtcBluetoothSelectorDialogProvider;
        this.f19184M = rtcThreadDataHandler;
        this.f19185N = webrtcCallStatusObserver;
        this.f19186O = clock;
        this.f19187P = voipNotificationPreferences;
        this.f19188Q = voipConferenceRosterListAdapterProvider;
        this.f19189R = zeroFeatureVisibilityHelper;
        this.f19190S = secureContextHelper;
        this.f19191T = toaster;
        this.f19192U = gatekeeperStore;
        this.an = lazy5;
    }

    public static void m19229b(WebrtcIncallActivity webrtcIncallActivity, boolean z) {
        RtcCallHandler rtcCallHandler = webrtcIncallActivity.f19202v;
        rtcCallHandler.F = ((WebrtcUiHandler) rtcCallHandler.d.get()).aE() + ((long) rtcCallHandler.a(ExposureLogging.Off));
        if (webrtcIncallActivity.aP != null) {
            webrtcIncallActivity.aP.m19923d();
        }
        if (webrtcIncallActivity.f19179H.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.b, false) && webrtcIncallActivity.f19202v.a(((WebrtcUiHandler) webrtcIncallActivity.an.get()).as(), ExposureLogging.Off)) {
            if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).aE() - ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aK <= ((long) webrtcIncallActivity.f19202v.a(ExposureLogging.Off))) {
                Toast.makeText(webrtcIncallActivity.getApplicationContext(), 2131232094, 0).show();
            }
        }
        if (!ab(webrtcIncallActivity) && !z) {
            return;
        }
        if (webrtcIncallActivity.f19206z.m) {
            webrtcIncallActivity.f19206z.e();
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).ad();
            webrtcIncallActivity.finish();
            return;
        }
        if (m19230b(webrtcIncallActivity, WebrtcViewState.NO_ANSWER)) {
            webrtcIncallActivity.finish();
        } else if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).aD()) {
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19458a(EndCallReason.CallEndHangupCall);
            m19228b(webrtcIncallActivity, webrtcIncallActivity.getString(2131232009));
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19482q();
            m19202C(webrtcIncallActivity);
        } else {
            m19202C(webrtcIncallActivity);
        }
    }

    private void m19234c(boolean z) {
        if (z) {
            this.aL.setVisibility(8);
            this.aM.setVisibility(0);
            if (this.am == null) {
                this.am = this.f19188Q.m19503a(((WebrtcUiHandler) this.an.get()).aS(), kO_());
                this.am.m19501a();
            }
            this.aN.setAdapter(this.am);
            if (m19238l()) {
                this.aK.setTheme(Theme.CONFERENCE);
                return;
            }
            return;
        }
        this.aM.setVisibility(8);
        this.aL.setVisibility(0);
        if (m19238l()) {
            this.aK.setTheme(Theme.VOICE);
        }
    }

    private boolean m19238l() {
        return this.f19179H.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.bX, true);
    }

    private void m19226b(Intent intent) {
        Object obj;
        this.aj = false;
        String action = intent.getAction();
        if (!"com.facebook.rtc.fbwebrtc.intent.action.SHOW_UI".equals(action) && !"com.facebook.rtc.fbwebrtc.intent.action.INCOMING_CALL".equals(action)) {
            obj = null;
        } else if (((WebrtcUiHandler) this.an.get()).aD()) {
            obj = 1;
        } else {
            BLog.a(ah, "Call is already finished.");
            obj = null;
        }
        if (obj == null) {
            finish();
            return;
        }
        m19234c(false);
        WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) this.an.get();
        if (webrtcUiHandler.aL <= 0) {
            webrtcUiHandler.aL = webrtcUiHandler.aE();
        }
        this.ai = ((WebrtcUiHandler) this.an.get()).ai;
        this.ae = new C22686(this);
        ((WebrtcUiHandler) this.an.get()).m19455a(this.ae);
        m19215W();
        this.aU = intent.getBooleanExtra("FORCE_STAR_RATING", false);
        this.aV = intent.getBooleanExtra("AUTO_ACCEPT", false);
        this.aX = intent.getBooleanExtra("END_CALL", false);
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        sendBroadcast(intent2);
        this.aS = -1;
        if (((WebrtcUiHandler) this.an.get()).ak == 0 || 2 == ((WebrtcUiHandler) this.an.get()).ak) {
            this.f19203w.i();
        }
        boolean g = ((WebrtcUiHandler) this.an.get()).m19473g();
        if (g) {
            this.aC.setType(ActionBarType.CONFERENCE);
        }
        if (((WebrtcUiHandler) this.an.get()).aC()) {
            if (((WebrtcUiHandler) this.an.get()).aB && g) {
                m19234c(true);
            } else {
                m19234c(false);
                this.aI.setText(((WebrtcUiHandler) this.an.get()).ai());
            }
            setVolumeControlStream(0);
            if (this.f19202v.a(((WebrtcUiHandler) this.an.get()).as(), ExposureLogging.Off)) {
                m19228b(this, getString(2131232002));
                ((ScheduledExecutorService) this.f19177F.get()).schedule(new C22697(this), (long) this.f19202v.a(ExposureLogging.Off), TimeUnit.MILLISECONDS);
            } else {
                m19239m(this);
            }
        } else if (((WebrtcUiHandler) this.an.get()).aL()) {
            this.aI.setText(((WebrtcUiHandler) this.an.get()).ai());
            setVolumeControlStream(2);
            if (g && !StringUtil.a(((WebrtcUiHandler) this.an.get()).aj())) {
                m19240n(this);
            } else if (!g) {
                int i;
                if (((WebrtcUiHandler) this.an.get()).as()) {
                    if (this.f19174C.booleanValue()) {
                        i = 2131232110;
                    } else {
                        i = 2131232109;
                    }
                } else if (this.f19174C.booleanValue()) {
                    i = 2131232000;
                } else {
                    i = 2131231989;
                }
                m19228b(this, getString(i));
            }
            m19216X();
        } else if (((WebrtcUiHandler) this.an.get()).m19441R()) {
            if (!g) {
                this.aI.setText(((WebrtcUiHandler) this.an.get()).ai());
            }
            if (((WebrtcUiHandler) this.an.get()).aH) {
                m19228b(this, getString(2131232092));
            }
        }
        m19245t(this);
    }

    public static void m19239m(WebrtcIncallActivity webrtcIncallActivity) {
        if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).aA()) {
            m19228b(webrtcIncallActivity, webrtcIncallActivity.getString(2131232003));
            m19222a(webrtcIncallActivity, webrtcIncallActivity.getString(2131232003), true);
        } else {
            m19228b(webrtcIncallActivity, webrtcIncallActivity.getString(2131232001));
            m19222a(webrtcIncallActivity, webrtcIncallActivity.getString(2131232001), true);
        }
        webrtcIncallActivity.m19216X();
    }

    public static void m19240n(WebrtcIncallActivity webrtcIncallActivity) {
        Object[] objArr;
        int i;
        WebrtcIncallActivity webrtcIncallActivity2;
        Object[] objArr2;
        CharSequence al = ((WebrtcUiHandler) webrtcIncallActivity.an.get()).al();
        if (!StringUtil.a(al)) {
            objArr = new Object[1];
            i = 2131231990;
            webrtcIncallActivity2 = webrtcIncallActivity;
            objArr2 = objArr;
        } else if (webrtcIncallActivity.f19184M != null) {
            RtcThreadDataHandler rtcThreadDataHandler = webrtcIncallActivity.f19184M;
            ThreadKey threadKey = ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aj;
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aj();
            al = rtcThreadDataHandler.m19561c();
            objArr = new Object[1];
            if (al != null) {
                i = 2131231991;
                webrtcIncallActivity2 = webrtcIncallActivity;
                objArr2 = objArr;
            } else {
                al = "";
                i = 2131231991;
                webrtcIncallActivity2 = webrtcIncallActivity;
                objArr2 = objArr;
            }
        } else {
            return;
        }
        objArr[0] = al;
        m19228b(webrtcIncallActivity2, webrtcIncallActivity.getString(i, objArr2));
    }

    public final void m19255a(Intent intent) {
        super.a(intent);
        this.aX = intent.getBooleanExtra("END_CALL", false);
        if ("com.facebook.rtc.fbwebrtc.intent.action.INCOMING_CALL".equals(intent.getAction())) {
            m19237f(true);
            if (!ac()) {
                this.f19203w.h();
            }
            if (this.aq != null) {
                this.aq.dismiss();
                this.aq = null;
            }
            this.f19206z.f();
            m19214V();
            m19226b(intent);
            m19241p(this);
            if (this.as != null) {
                this.as.f20340d.m19796a();
                return;
            }
            return;
        }
        this.aV = intent.getBooleanExtra("AUTO_ACCEPT", false);
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (this.f19204x != null && this.f19204x.m19389b()) {
            finish();
        }
    }

    public void finish() {
        if (!(this.f19203w == null || ((WebrtcUiHandler) this.an.get()).aH)) {
            this.f19203w.h();
        }
        m19214V();
        if (this.ap != null) {
            this.ap.cancel(false);
            this.ap = null;
        }
        if (this.aP != null) {
            this.aP.m19928k();
        }
        super.finish();
        if (this.an.get() != null && ((WebrtcUiHandler) this.an.get()).as() && ((WebrtcUiHandler) this.an.get()).aF()) {
            overridePendingTransition(0, 0);
        }
    }

    public void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 398175533);
        super.onStart();
        this.ad = true;
        if (!this.f19202v.a(((WebrtcUiHandler) this.an.get()).as(), ExposureLogging.Off)) {
            aa(this);
        }
        if (((WebrtcUiHandler) this.an.get()).aD()) {
            View findViewById = findViewById(16908290);
            this.aB.m19893b(findViewById.getWidth(), findViewById.getHeight());
            if (this.aV) {
                this.aV = false;
                m19248w(this);
            }
            LogUtils.c(-1010555732, a);
            return;
        }
        if (!(this.ao != null || m19230b(this, WebrtcViewState.REDIAL) || this.f19206z.m)) {
            finish();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1485666894, a);
    }

    public void onStop() {
        boolean z = false;
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1867240552);
        super.onStop();
        this.ad = false;
        if (this.an.get() != null && ((((WebrtcUiHandler) this.an.get()).m19433D() || ((WebrtcUiHandler) this.an.get()).az()) && !((WebrtcUiHandler) this.an.get()).aH())) {
            m19236e(this, false);
            ((WebrtcUiHandler) this.an.get()).m19454a(LocalVideoState.PAUSED);
        }
        an(this);
        if (this.an.get() != null && ((WebrtcUiHandler) this.an.get()).m19445W()) {
            aw();
        }
        if (this.af) {
            aq();
        }
        finishActivity(1);
        if (this.an.get() != null) {
            boolean aL = ((WebrtcUiHandler) this.an.get()).aL();
            if (((WebrtcUiHandler) this.an.get()).aF()) {
                if (this.f19179H.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.ct, false) && !((WebrtcUiHandler) this.an.get()).as()) {
                    aL = false;
                }
                if (!((WebrtcUiHandler) this.an.get()).as()) {
                    z = aL;
                }
            } else {
                z = aL;
            }
        }
        if (z) {
            if (((WebrtcUiHandler) this.an.get()).m19473g()) {
                ThreadKey threadKey = ((WebrtcUiHandler) this.an.get()).aj;
                ((WebrtcUiHandler) this.an.get()).ai();
                this.f19186O.a();
            } else {
                ((WebrtcUiHandler) this.an.get()).ai();
                this.f19186O.a();
            }
        }
        LogUtils.c(1145787790, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1357650024);
        super.onDestroy();
        if (((WebrtcUiHandler) this.an.get()).ak == 0) {
            ((WebrtcUiHandler) this.an.get()).af();
            VoicemailHandler voicemailHandler = this.f19206z;
            voicemailHandler.f();
            voicemailHandler.r = null;
            voicemailHandler.s = null;
        }
        aw();
        getContentResolver().unregisterContentObserver(this.ab);
        if (this.an.get() != null) {
            if (!((WebrtcUiHandler) this.an.get()).aD() && this.f19200t.isScreenOn() && !((WebrtcUiHandler) this.an.get()).aB && this.f19198r.j == Product.MESSENGER && this.f19199s.a(WebrtcPrefKeys.f19403d, 0) == 3 && (this.aS == 0 || this.aS > 2)) {
                this.f19191T.a(new ToastBuilder(this.f19174C.booleanValue() ? 2131232058 : 2131232057));
                this.f19199s.edit().a(WebrtcPrefKeys.f19403d, 99).commit();
                this.f19203w.e();
            }
            ((WebrtcUiHandler) this.an.get()).m19465b(this.ae);
            if (this.aC != null) {
                this.aC.m19744a();
            }
            if (this.aP != null) {
                VoipVideoView voipVideoView = this.aP;
                voipVideoView.f20293C.m19744a();
                ((WebrtcUiHandler) voipVideoView.f20317n.get()).m19465b(voipVideoView.f20302L);
            }
            ((WebrtcUiHandler) this.an.get()).m19467b(this.ar);
        }
        ac();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 42793881, a);
    }

    public final boolean m19256a() {
        return this.aj;
    }

    public static void m19241p(WebrtcIncallActivity webrtcIncallActivity) {
        if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).ak == 2) {
            webrtcIncallActivity.m19242q();
        } else if (webrtcIncallActivity.an.get() != null && ((WebrtcUiHandler) webrtcIncallActivity.an.get()).bp) {
            ak(webrtcIncallActivity);
        } else if (webrtcIncallActivity.an.get() != null && (((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19435G() || ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19433D())) {
            am(webrtcIncallActivity);
        } else if (webrtcIncallActivity.an.get() == null || !((WebrtcUiHandler) webrtcIncallActivity.an.get()).az()) {
            webrtcIncallActivity.ao();
        } else {
            webrtcIncallActivity.al();
            m19236e(webrtcIncallActivity, true);
        }
    }

    private void m19242q() {
        m19220a(WebrtcViewState.INCOMING_CALL);
        aq();
        if (!((WebrtcUiHandler) this.an.get()).m19445W()) {
            m19210Q(this);
        }
        au();
    }

    private void m19235d(boolean z) {
        m19220a(z ? WebrtcViewState.INCALL_GROUP_ESCALATED : WebrtcViewState.INCALL);
        aq();
        av(this);
        m19245t(this);
        this.aI.setSingleLine(true);
        if (!((WebrtcUiHandler) this.an.get()).m19473g() || ((WebrtcUiHandler) this.an.get()).aL()) {
            m19234c(false);
        } else {
            m19234c(true);
        }
    }

    private void m19243r() {
        m19235d(true);
    }

    public static void m19244s(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.m19235d(false);
    }

    public static void m19245t(WebrtcIncallActivity webrtcIncallActivity) {
        if (webrtcIncallActivity.at != null) {
            webrtcIncallActivity.at.f20333d.m19730a();
        }
        if (webrtcIncallActivity.au != null) {
            webrtcIncallActivity.au.f20358b.m19730a();
        }
        if (webrtcIncallActivity.aP != null) {
            webrtcIncallActivity.aP.m19927j();
            webrtcIncallActivity.aP.f20293C.m19746b();
            webrtcIncallActivity.aP.f20293C.m19747c();
        }
        if (webrtcIncallActivity.aC != null) {
            webrtcIncallActivity.aC.m19746b();
        }
        if (webrtcIncallActivity.aB != null) {
            webrtcIncallActivity.aB.m19895d();
        }
    }

    private void m19246u() {
        String[] strArr;
        boolean as = ((WebrtcUiHandler) this.an.get()).as();
        ActivityRuntimePermissionsManager activityRuntimePermissionsManager = this.bd;
        if (as) {
            strArr = f19171W;
        } else {
            strArr = f19170V;
        }
        activityRuntimePermissionsManager.a(strArr, as ? aD() : getString(2131232161, new Object[]{getString(2131230720)}), getString(as ? 2131232165 : 2131232162, new Object[]{getString(2131230720)}), new C22708(this));
    }

    public static void m19247v(WebrtcIncallActivity webrtcIncallActivity) {
        if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).as()) {
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aM();
            am(webrtcIncallActivity);
            m19236e(webrtcIncallActivity, true);
        } else {
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aN();
        }
        int a = webrtcIncallActivity.f19199s.a(WebrtcPrefKeys.f19403d, 0);
        if (a < 3) {
            webrtcIncallActivity.f19199s.edit().a(WebrtcPrefKeys.f19403d, a + 1).commit();
        }
    }

    public static void m19248w(WebrtcIncallActivity webrtcIncallActivity) {
        if (webrtcIncallActivity.f19189R.a(ZeroFeatureKey.VOIP_INCOMING_CALL_INTERSTITIAL) && webrtcIncallActivity.f19179H.a(Liveness.Cached, ExperimentsForRtcModule.cZ, false)) {
            webrtcIncallActivity.f19203w.a("zero_rating_shown", true);
            Intent intent = new Intent(webrtcIncallActivity, RtcZeroRatingActivity.class);
            intent.setAction("ACTION_INCOMING_CALL");
            intent.putExtra("EXTRA_AFTER_INCOMING_CALL_SCREEN", true);
            webrtcIncallActivity.f19190S.a(intent, 1, webrtcIncallActivity);
            return;
        }
        m19249x(webrtcIncallActivity);
    }

    public static void m19249x(WebrtcIncallActivity webrtcIncallActivity) {
        ((WebrtcUiHandler) webrtcIncallActivity.an.get()).ag();
        if (!((WebrtcUiHandler) webrtcIncallActivity.an.get()).aD()) {
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            webrtcIncallActivity.m19246u();
        } else {
            m19247v(webrtcIncallActivity);
        }
    }

    public static void m19250y(WebrtcIncallActivity webrtcIncallActivity) {
        ((WebrtcUiHandler) webrtcIncallActivity.an.get()).ag();
        if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).aD()) {
            m19228b(webrtcIncallActivity, webrtcIncallActivity.getString(2131232009));
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19458a(EndCallReason.CallEndIgnoreCall);
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19482q();
            m19202C(webrtcIncallActivity);
            return;
        }
        m19202C(webrtcIncallActivity);
    }

    public static void m19201A(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.m19224a(new CharSequence[]{webrtcIncallActivity.getString(2131232075), webrtcIncallActivity.getString(2131232076), webrtcIncallActivity.getString(2131232077)}, new C22719(webrtcIncallActivity), null);
        webrtcIncallActivity.aq.show();
    }

    public static void m19221a(WebrtcIncallActivity webrtcIncallActivity, OnDismissListener onDismissListener) {
        webrtcIncallActivity.m19224a((CharSequence[]) ((WebrtcUiHandler) webrtcIncallActivity.an.get()).f19571f, new OnClickListener(webrtcIncallActivity) {
            final /* synthetic */ WebrtcIncallActivity f19127a;

            {
                this.f19127a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) this.f19127a.an.get();
                String str = webrtcUiHandler.f19571f[i];
                webrtcUiHandler.m19473g();
                webrtcUiHandler.f19577l.a("quick_response_message", str);
                dialogInterface.dismiss();
                WebrtcIncallActivity.m19250y(this.f19127a);
                WebrtcIncallActivity.m19213U(this.f19127a);
            }
        }, onDismissListener);
        webrtcIncallActivity.aq.show();
    }

    private void m19224a(CharSequence[] charSequenceArr, OnClickListener onClickListener, final OnDismissListener onDismissListener) {
        if (this.aq == null) {
            OnDismissListener anonymousClass11 = new OnDismissListener(this) {
                final /* synthetic */ WebrtcIncallActivity f19129b;

                public void onDismiss(DialogInterface dialogInterface) {
                    this.f19129b.aq = null;
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(dialogInterface);
                    }
                }
            };
            this.aq = new FbAlertDialogBuilder(this).a(charSequenceArr, onClickListener).a();
            this.aq.setOnDismissListener(anonymousClass11);
        }
    }

    public static void m19202C(WebrtcIncallActivity webrtcIncallActivity) {
        if (webrtcIncallActivity.ao == null) {
            webrtcIncallActivity.m19237f(false);
            webrtcIncallActivity.ao = ((ScheduledExecutorService) webrtcIncallActivity.f19177F.get()).schedule(new Runnable(webrtcIncallActivity) {
                final /* synthetic */ WebrtcIncallActivity f19130a;

                {
                    this.f19130a = r1;
                }

                public void run() {
                    this.f19130a.finish();
                }
            }, 2000, TimeUnit.MILLISECONDS);
        }
    }

    public static void m19203D(WebrtcIncallActivity webrtcIncallActivity) {
        boolean z = !((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19486x();
        Boolean.valueOf(z);
        ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19453a(z ? AudioOutput.SPEAKERPHONE : AudioOutput.EARPIECE);
        ((WebrtcUiHandler) webrtcIncallActivity.an.get()).bb = z;
        m19245t(webrtcIncallActivity);
    }

    public static void m19204H(WebrtcIncallActivity webrtcIncallActivity) {
        if (!((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19487z()) {
            return;
        }
        if (VERSION.SDK_INT < 23 || ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19433D()) {
            m19205I(webrtcIncallActivity);
            return;
        }
        webrtcIncallActivity.bd.a(f19171W, webrtcIncallActivity.aD(), webrtcIncallActivity.getString(2131232168, new Object[]{webrtcIncallActivity.getString(2131230720)}), new AbstractRuntimePermissionsListener(webrtcIncallActivity) {
            final /* synthetic */ WebrtcIncallActivity f19131a;

            {
                this.f19131a = r1;
            }

            public final void m19116a() {
                WebrtcIncallActivity.m19205I(this.f19131a);
            }
        });
    }

    public static void m19205I(WebrtcIncallActivity webrtcIncallActivity) {
        boolean z = true;
        boolean z2 = !((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19433D();
        if (z2) {
            if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19473g() && ((WebrtcUiHandler) webrtcIncallActivity.an.get()).am) {
                ((WebrtcUiHandler) webrtcIncallActivity.an.get()).bs = TriState.YES;
                ((WebrtcUiHandler) webrtcIncallActivity.an.get()).ao = false;
                m19236e(webrtcIncallActivity, true);
                am(webrtcIncallActivity);
            } else if (!((WebrtcUiHandler) webrtcIncallActivity.an.get()).as()) {
                ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19477j(true);
                webrtcIncallActivity.bc = true;
                m19228b(webrtcIncallActivity, webrtcIncallActivity.getResources().getString(2131232108));
            }
        } else if (webrtcIncallActivity.bc) {
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19477j(false);
            webrtcIncallActivity.bc = false;
        }
        WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) webrtcIncallActivity.an.get();
        if (z2) {
            z = false;
        }
        webrtcUiHandler.ao = z;
        m19236e(webrtcIncallActivity, z2);
    }

    public static void m19236e(WebrtcIncallActivity webrtcIncallActivity, boolean z) {
        Boolean.valueOf(z);
        if (z) {
            m19206J(webrtcIncallActivity);
            webrtcIncallActivity.aB.setVisibility(0);
            webrtcIncallActivity.aB.f20271o;
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aK();
            webrtcIncallActivity.al();
        } else {
            webrtcIncallActivity.aB.setVisibility(4);
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19454a(LocalVideoState.STOPPED);
            webrtcIncallActivity.ao();
        }
        av(webrtcIncallActivity);
        m19245t(webrtcIncallActivity);
    }

    @TargetApi(14)
    public static void m19206J(WebrtcIncallActivity webrtcIncallActivity) {
        if (!webrtcIncallActivity.aB.f20277v) {
            View findViewById = webrtcIncallActivity.findViewById(16908290);
            webrtcIncallActivity.aB.m19888a(findViewById.getWidth(), findViewById.getHeight());
            m19208L(webrtcIncallActivity);
        }
        m19207K(webrtcIncallActivity);
    }

    public static void m19207K(WebrtcIncallActivity webrtcIncallActivity) {
        if (!((WebrtcUiHandler) webrtcIncallActivity.an.get()).ao) {
            TextureView textureView = webrtcIncallActivity.aB.f20264h;
            if (textureView.isAvailable()) {
                VideoCaptureAndroid.m21574a(textureView.getSurfaceTexture());
                ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19454a(LocalVideoState.STARTED);
            }
            if (textureView.getSurfaceTextureListener() == null) {
                textureView.setSurfaceTextureListener(new SetSurfaceTextureListener(webrtcIncallActivity));
            }
        }
    }

    public static void m19208L(WebrtcIncallActivity webrtcIncallActivity) {
        if (!webrtcIncallActivity.af) {
            if (webrtcIncallActivity.aC.getHeight() > 0) {
                webrtcIncallActivity.aB.m19889a(0, 0, webrtcIncallActivity.aC.getHeight(), 0, true);
                return;
            }
            webrtcIncallActivity.aC.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(webrtcIncallActivity) {
                final /* synthetic */ WebrtcIncallActivity f19132a;

                {
                    this.f19132a = r1;
                }

                public void onGlobalLayout() {
                    CustomViewUtils.a(this.f19132a.aC, this);
                    WebrtcIncallActivity.m19208L(this.f19132a);
                }
            });
        }
    }

    private void m19237f(boolean z) {
        if (this.at != null) {
            this.at.f20333d.setButtonsEnabled(z);
        }
        if (this.au != null) {
            this.au.f20358b.setButtonsEnabled(z);
        }
        if (this.aP != null) {
            this.aP.f20325v.setButtonsEnabled(z);
        }
        if (this.as != null) {
            this.as.f20340d.setButtonsEnabled(z);
        }
    }

    public static void m19228b(WebrtcIncallActivity webrtcIncallActivity, String str) {
        webrtcIncallActivity.aJ.setText(str);
    }

    public static void m19222a(WebrtcIncallActivity webrtcIncallActivity, String str, boolean z) {
        if (webrtcIncallActivity.an.get() != null && ((WebrtcUiHandler) webrtcIncallActivity.an.get()).as() && webrtcIncallActivity.aP != null) {
            webrtcIncallActivity.aP.m19920a(str, z);
        }
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -367238361);
        super.onPause();
        this.f19193X = false;
        aq();
        if (this.bc) {
            ((WebrtcUiHandler) this.an.get()).m19477j(false);
            m19236e(this, false);
            this.bc = false;
        }
        if (((WebrtcUiHandler) this.an.get()).aD()) {
            this.f19179H.a(Liveness.Cached, ExperimentsForRtcModule.cs);
        }
        if (((WebrtcUiHandler) this.an.get()).aD() && ((WebrtcUiHandler) this.an.get()).aF() && ((WebrtcUiHandler) this.an.get()).m19479k(true)) {
            this.af = false;
        } else {
            if (((WebrtcUiHandler) this.an.get()).m19433D()) {
                ((WebrtcUiHandler) this.an.get()).m19454a(LocalVideoState.PAUSED);
            }
            VideoCaptureAndroid.m21574a(null);
        }
        LogUtils.c(-475602099, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1717798010);
        super.onResume();
        if (this.aX) {
            m19229b(this, true);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1908695284, a);
    }

    protected void onPostResume() {
        super.onPostResume();
        ((WebrtcUiHandler) this.an.get()).m19479k(false);
        if (this.f19194Y) {
            m19209P();
            this.f19194Y = false;
        }
        this.f19193X = true;
        if (((WebrtcUiHandler) this.an.get()).as() && (((((WebrtcUiHandler) this.an.get()).m19434F() && ((WebrtcUiHandler) this.an.get()).m19442S()) || ((WebrtcUiHandler) this.an.get()).m19433D()) && !((WebrtcUiHandler) this.an.get()).ao)) {
            m19236e(this, true);
        }
        m19241p(this);
    }

    public static boolean m19225a(WebrtcIncallActivity webrtcIncallActivity, EndCallReason endCallReason, boolean z) {
        if (endCallReason != EndCallReason.CallEndHangupCall || !((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19442S()) {
            return false;
        }
        webrtcIncallActivity.f19195Z = z;
        webrtcIncallActivity.aS = 0;
        if (webrtcIncallActivity.f19193X) {
            return webrtcIncallActivity.m19209P();
        }
        webrtcIncallActivity.f19194Y = true;
        return true;
    }

    private boolean m19209P() {
        Object obj;
        WebrtcSurveyHandler webrtcSurveyHandler = this.f19204x;
        boolean z = this.aU;
        boolean z2 = this.f19195Z;
        int a = webrtcSurveyHandler.f19423c.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.do, 100);
        if (z || webrtcSurveyHandler.f19422b.nextInt(100) < a) {
            WebrtcRatingDialogFragment webrtcRatingDialogFragment = new WebrtcRatingDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_conference", z2);
            webrtcRatingDialogFragment.g(bundle);
            Fragment fragment = webrtcRatingDialogFragment;
            FragmentManager kO_ = webrtcSurveyHandler.f19424d.kO_();
            kO_.a().a(fragment, "dialog").c();
            kO_.b();
            fragment.au();
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        this.f19203w.a("rating_shown", "1");
        m19233c(60000);
        return true;
    }

    public static void m19210Q(WebrtcIncallActivity webrtcIncallActivity) {
        WakeLock a = webrtcIncallActivity.f19201u.a(805306374, webrtcIncallActivity.getClass().getSimpleName());
        if (a != null) {
            a.c();
            a.d();
        }
    }

    public static void m19227b(WebrtcIncallActivity webrtcIncallActivity, long j) {
        webrtcIncallActivity.m19233c(30000);
        webrtcIncallActivity.m19237f(false);
        webrtcIncallActivity.aq();
        webrtcIncallActivity.m19220a(WebrtcViewState.REDIAL);
        webrtcIncallActivity.f19203w.logCallAction(j, webrtcIncallActivity.ai, "redial_offered", "");
    }

    public static void m19211R(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.m19233c(60000);
        if (webrtcIncallActivity.f19179H.a(ExperimentsForRtcModule.dc, false)) {
            webrtcIncallActivity.f19206z.r = new Object(webrtcIncallActivity) {
                final /* synthetic */ WebrtcIncallActivity f19137a;

                /* compiled from: autosave */
                class C22551 implements Runnable {
                    final /* synthetic */ AnonymousClass16 f19136a;

                    C22551(AnonymousClass16 anonymousClass16) {
                        this.f19136a = anonymousClass16;
                    }

                    public void run() {
                        this.f19136a.f19137a.f19206z.d();
                        ((WebrtcUiHandler) this.f19136a.f19137a.an.get()).ad();
                        this.f19136a.f19137a.finish();
                    }
                }

                {
                    this.f19137a = r1;
                }

                public final void m19118a() {
                    this.f19137a.ao = ((ScheduledExecutorService) this.f19137a.f19177F.get()).schedule(new C22551(this), 60000, TimeUnit.MILLISECONDS);
                    WebrtcIncallActivity.m19228b(this.f19137a, this.f19137a.getString(2131232092));
                }
            };
            webrtcIncallActivity.f19206z.s = new Object(webrtcIncallActivity) {
                public final /* synthetic */ WebrtcIncallActivity f19138a;

                {
                    this.f19138a = r1;
                }
            };
            if (webrtcIncallActivity.f19206z.c()) {
                ((WebrtcUiHandler) webrtcIncallActivity.an.get()).ac();
                webrtcIncallActivity.m19214V();
                return;
            }
            m19213U(webrtcIncallActivity);
            return;
        }
        webrtcIncallActivity.m19233c(60000);
        webrtcIncallActivity.m19220a(WebrtcViewState.NO_ANSWER);
        webrtcIncallActivity.aq();
        av(webrtcIncallActivity);
        m19245t(webrtcIncallActivity);
    }

    public static void m19212T(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.m19214V();
        WebrtcLoggingHandler webrtcLoggingHandler = webrtcIncallActivity.f19203w;
        webrtcLoggingHandler.t = "redial_button";
        webrtcLoggingHandler.v = webrtcLoggingHandler.w;
        if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).as()) {
            m19206J(webrtcIncallActivity);
        }
        webrtcIncallActivity.f19202v.a(RtcCallStartParams.m19551a(webrtcIncallActivity.ai, "redial_button", webrtcIncallActivity.ac, false));
        m19244s(webrtcIncallActivity);
        m19228b(webrtcIncallActivity, webrtcIncallActivity.getString(2131232001));
        webrtcIncallActivity.m19237f(true);
        m19245t(webrtcIncallActivity);
    }

    private void m19233c(long j) {
        m19214V();
        this.ao = ((ScheduledExecutorService) this.f19177F.get()).schedule(new Runnable(this) {
            final /* synthetic */ WebrtcIncallActivity f19139a;

            {
                this.f19139a = r1;
            }

            public void run() {
                this.f19139a.finish();
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public static void m19213U(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.m19214V();
        webrtcIncallActivity.finish();
    }

    private void m19214V() {
        if (this.ao != null) {
            this.ao.cancel(false);
            this.ao = null;
        }
    }

    private void m19215W() {
        if (((WebrtcUiHandler) this.an.get()).m19473g()) {
            this.aF.setVisibility(8);
            if (this.f19184M != null) {
                ThreadTileView threadTileView = this.aE;
                RtcThreadDataHandler rtcThreadDataHandler = this.f19184M;
                ThreadKey threadKey = ((WebrtcUiHandler) this.an.get()).aj;
                threadTileView.setThreadTileViewData(rtcThreadDataHandler.m19559a());
            }
            this.aE.setVisibility(0);
        } else {
            this.aE.setVisibility(8);
            this.aG.setParams(UserTileViewParams.a(new UserKey(Type.FACEBOOK, Long.toString(this.ai)), !this.f19197q.m8366a() ? TileBadge.MESSENGER : TileBadge.NONE));
            this.aF.setVisibility(0);
        }
        if (this.f19192U.a(1103, false)) {
            this.aG.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WebrtcIncallActivity f19141a;
                public int f19142b = 0;
                public Handler f19143c = null;

                /* compiled from: autosave */
                class C22561 implements Runnable {
                    final /* synthetic */ AnonymousClass19 f19140a;

                    C22561(AnonymousClass19 anonymousClass19) {
                        this.f19140a = anonymousClass19;
                    }

                    public void run() {
                        this.f19140a.f19142b = 0;
                        this.f19140a.f19143c = null;
                    }
                }

                {
                    this.f19141a = r2;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1412025348);
                    this.f19142b++;
                    if (this.f19142b >= 5) {
                        Class cls = WebrtcIncallActivity.ah;
                        Integer.valueOf(this.f19142b);
                        this.f19142b = 0;
                        this.f19141a.az.m19828a();
                    } else if (this.f19142b > 0 && this.f19143c == null) {
                        this.f19143c = new Handler();
                        HandlerDetour.b(this.f19143c, new C22561(this), 4000, -1091509709);
                    }
                    LogUtils.a(-297356133, a);
                }
            });
        }
    }

    private void m19216X() {
        if (this.at != null) {
            this.at.m19931b();
        }
    }

    public static boolean m19231b(WebrtcIncallActivity webrtcIncallActivity, EndCallReason endCallReason) {
        switch (AnonymousClass26.f19151a[endCallReason.ordinal()]) {
            case 3:
            case 16:
                NetworkInfo c = ((DeviceConditionHelper) webrtcIncallActivity.f19176E.get()).c();
                return c != null && c.isConnectedOrConnecting();
            default:
                return false;
        }
    }

    public static boolean m19232b(WebrtcIncallActivity webrtcIncallActivity, EndCallReason endCallReason, boolean z) {
        if (webrtcIncallActivity.f19198r.j == Product.PHONE) {
            return false;
        }
        boolean S = ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19442S();
        boolean z2 = ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aB;
        boolean g = ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19473g();
        switch (AnonymousClass26.f19151a[endCallReason.ordinal()]) {
            case 1:
            case 2:
            case 6:
            case 8:
            case 9:
            case 10:
            case 14:
            case 15:
            case 17:
            case 18:
                return z2 && !g;
            case 4:
                return z && !S && z2 && !g;
            default:
                return false;
        }
    }

    public static void m19217Y(WebrtcIncallActivity webrtcIncallActivity) {
        if (webrtcIncallActivity.m19238l() || ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19473g()) {
            webrtcIncallActivity.aK.m19860a();
            if (webrtcIncallActivity.aP != null) {
                VoipVideoView voipVideoView = webrtcIncallActivity.aP;
                voipVideoView.f20291A.m19860a();
                VoipVideoView.m19915w(voipVideoView);
            }
        }
        if (webrtcIncallActivity.f19179H.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.bY, true) && !((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19473g()) {
            webrtcIncallActivity.aC.m19748d();
            if (webrtcIncallActivity.aP != null) {
                webrtcIncallActivity.aP.f20293C.m19748d();
            }
        }
    }

    public static void aa(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.aT = ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aE() + 700;
    }

    public static boolean ab(WebrtcIncallActivity webrtcIncallActivity) {
        return ((WebrtcUiHandler) webrtcIncallActivity.an.get()).aE() > webrtcIncallActivity.aT;
    }

    public final void mo807a(int i, @Nullable String str, @Nullable String str2) {
        Integer.valueOf(i);
        if (i > 0) {
            this.f19203w.a(i, this.f19196p.isSpeakerphoneOn(), this.f19196p.isMicrophoneMute(), this.aW);
            this.aS = i;
            this.f19203w.a("rating5", Integer.toString(i));
            if (str != null) {
                this.f19203w.a("survey_choice", str);
            }
            if (str2 != null) {
                this.f19203w.a("survey_details", str2);
            }
        }
        this.f19203w.h();
        if (!this.aY) {
            finish();
        }
        this.aY = false;
    }

    public final void mo808a(long j) {
        m19233c(j);
        if (j == 120000) {
            this.f19203w.a("survey_shown", "1");
        }
    }

    public final void mo809b(int i) {
        this.f19204x.m19388a(i, this.ac);
    }

    public final void mo810d(int i) {
        this.f19204x.m19388a(i, false);
    }

    public final void mo806a(int i, String str) {
        WebrtcSurveyHandler webrtcSurveyHandler = this.f19204x;
        WebrtcCommentDialogFragment webrtcCommentDialogFragment = new WebrtcCommentDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("rating", i);
        bundle.putString("reason_key", str);
        webrtcCommentDialogFragment.g(bundle);
        Fragment fragment = webrtcCommentDialogFragment;
        FragmentManager kO_ = webrtcSurveyHandler.f19424d.kO_();
        kO_.a().a(fragment, "dialog").c();
        kO_.b();
    }

    public final void mo805a(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) this.aB.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.rightMargin = i3;
        layoutParams.bottomMargin = i4;
        this.aB.setLayoutParams(layoutParams);
    }

    private boolean ac() {
        if (this.f19204x == null || !this.f19204x.m19389b()) {
            return false;
        }
        this.aY = true;
        WebrtcDialogFragment webrtcDialogFragment = (WebrtcDialogFragment) this.f19204x.f19424d.kO_().a("dialog");
        if (webrtcDialogFragment == null) {
            return true;
        }
        webrtcDialogFragment.ar();
        webrtcDialogFragment.a();
        return true;
    }

    private void m19220a(WebrtcViewState webrtcViewState) {
        if (!m19230b(this, webrtcViewState)) {
            View view = null;
            switch (webrtcViewState) {
                case INCOMING_CALL:
                    ad();
                    view = this.as;
                    break;
                case INCALL:
                case INCALL_GROUP_ESCALATED:
                    if (!((WebrtcUiHandler) this.an.get()).m19473g()) {
                        ae();
                        view = this.at;
                        break;
                    }
                    af();
                    view = this.au;
                    break;
                case NO_ANSWER:
                    ag();
                    view = this.aw;
                    break;
                case REDIAL:
                    ah();
                    view = this.av;
                    break;
                case VIDEO_REQUEST:
                    aj();
                    view = this.ax;
                    break;
            }
            if (view == null) {
                this.f19182K.a("missingView", "Couldn't find a view for " + webrtcViewState);
                return;
            }
            if (!(this.ay == null || this.ay == view)) {
                this.ay.setVisibility(8);
            }
            view.setVisibility(0);
            if (webrtcViewState.equals(WebrtcViewState.REDIAL)) {
                this.aJ.setVisibility(8);
            } else {
                this.aJ.setVisibility(0);
            }
            this.ag = webrtcViewState;
            this.ay = view;
        }
    }

    private void ad() {
        if (this.as == null) {
            this.as = new WebrtcIncomingCallView(this);
            this.as.f20340d.f20146f = new Object(this) {
                public final /* synthetic */ WebrtcIncallActivity f19145a;

                {
                    this.f19145a = r1;
                }
            };
            m19219a(this.as);
            this.aA.addView(this.as);
        }
    }

    private void ae() {
        if (this.at == null) {
            this.at = new WebrtcIncallView(this);
            this.at.f20333d.f20070n = this.aD;
            m19219a(this.at);
            this.aA.addView(this.at);
        }
    }

    private void af() {
        if (this.au == null) {
            this.au = new WebrtcRosterIncallView(this);
            this.au.f20358b.f20070n = this.aD;
            m19219a(this.au);
            this.aA.addView(this.au);
        }
    }

    private void ag() {
        if (this.aw == null) {
            this.aw = new WebrtcNoAnswerView(this);
            this.aw.f20348d = new Object(this) {
                public final /* synthetic */ WebrtcIncallActivity f19146a;

                {
                    this.f19146a = r1;
                }
            };
            m19219a(this.aw);
            this.aA.addView(this.aw);
        }
    }

    private void ah() {
        if (this.av == null) {
            this.av = new WebrtcRedialView(this);
            this.av.f20354d = new Object(this) {
                public final /* synthetic */ WebrtcIncallActivity f19147a;

                {
                    this.f19147a = r1;
                }
            };
            m19219a(this.av);
            this.aA.addView(this.av);
        }
    }

    public static void ai(WebrtcIncallActivity webrtcIncallActivity) {
        if (VERSION.SDK_INT >= 23) {
            webrtcIncallActivity.bd.a(f19171W, webrtcIncallActivity.aD(), webrtcIncallActivity.getString(2131232167, new Object[]{webrtcIncallActivity.getString(2131230720)}), new RuntimePermissionsListener(webrtcIncallActivity) {
                final /* synthetic */ WebrtcIncallActivity f19148a;

                {
                    this.f19148a = r1;
                }

                public final void m19119a() {
                    this.f19148a.aa = true;
                    WebrtcIncallActivity.m19236e(this.f19148a, true);
                    ((WebrtcUiHandler) this.f19148a.an.get()).m19476i(true);
                    WebrtcIncallActivity.am(this.f19148a);
                }

                public final void m19120a(String[] strArr, String[] strArr2) {
                    this.f19148a.aa = true;
                    ((WebrtcUiHandler) this.f19148a.an.get()).m19476i(false);
                    WebrtcIncallActivity.m19244s(this.f19148a);
                }

                public final void m19121b() {
                    this.f19148a.aa = true;
                    ((WebrtcUiHandler) this.f19148a.an.get()).m19476i(false);
                    WebrtcIncallActivity.m19244s(this.f19148a);
                }
            });
            return;
        }
        webrtcIncallActivity.aa = true;
        m19236e(webrtcIncallActivity, true);
        ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19476i(true);
        am(webrtcIncallActivity);
    }

    private void aj() {
        if (this.ax == null) {
            this.ax = new WebrtcVideoRequestView(this);
            this.ax.f20364c = new Object(this) {
                public final /* synthetic */ WebrtcIncallActivity f19149a;

                {
                    this.f19149a = r1;
                }
            };
            m19219a(this.ax);
            this.aA.addView(this.ax);
        }
    }

    private void m19219a(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams;
            if (this.au == null || this.au.getVisibility() != 0) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2, 23.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static void ak(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.m19220a(WebrtcViewState.VIDEO_REQUEST);
        webrtcIncallActivity.aa = false;
        m19228b(webrtcIncallActivity, webrtcIncallActivity.getString(2131232105));
        webrtcIncallActivity.au();
    }

    public static boolean m19230b(WebrtcIncallActivity webrtcIncallActivity, WebrtcViewState webrtcViewState) {
        return webrtcViewState != null && webrtcViewState.equals(webrtcIncallActivity.ag);
    }

    private void al() {
        if (!this.af && ((WebrtcUiHandler) this.an.get()).aw() && !((WebrtcUiHandler) this.an.get()).aL()) {
            if (this.aP == null) {
                final int dimensionPixelSize = getResources().getDimensionPixelSize(2131427929);
                this.aP = new VoipVideoView(this);
                this.aP.m19922c();
                VoipVideoView voipVideoView = this.aP;
                C22604 c22604 = this.aD;
                voipVideoView.f20299I = c22604;
                voipVideoView.f20325v.f20070n = c22604;
                this.aP.f20324u = new Object(this) {
                    final /* synthetic */ WebrtcIncallActivity f19135b;

                    /* compiled from: autosave */
                    class C22541 implements AnimatorUpdateListener {
                        final /* synthetic */ AnonymousClass15 f19133a;

                        C22541(AnonymousClass15 anonymousClass15) {
                            this.f19133a = anonymousClass15;
                        }

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (this.f19133a.f19135b.aQ != null) {
                                LayoutParams layoutParams = (LayoutParams) this.f19133a.f19135b.aQ.getLayoutParams();
                                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                                this.f19133a.f19135b.aQ.setLayoutParams(layoutParams);
                            }
                        }
                    }

                    public final void m19117a(int i, int i2, int i3, int i4, boolean z) {
                        int height;
                        if (this.f19135b.aQ.getVisibility() == 0) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{((LayoutParams) this.f19135b.aQ.getLayoutParams()).bottomMargin, dimensionPixelSize + i4});
                            ofInt.setDuration(300);
                            ofInt.addUpdateListener(new C22541(this));
                            ofInt.start();
                            height = i4 + this.f19135b.aQ.getHeight();
                        } else {
                            height = i4;
                        }
                        if (this.f19135b.aB != null) {
                            this.f19135b.aB.m19889a(i, i2, i3, height, z);
                        }
                    }
                };
                this.aO.addView(this.aP);
                this.aP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            VoipVideoView voipVideoView2 = this.aP;
            voipVideoView2.f20325v.getViewTreeObserver().addOnGlobalLayoutListener(new C23895(voipVideoView2));
            if (voipVideoView2.f20304N) {
                voipVideoView2.f20321r.m21564a();
            } else {
                voipVideoView2.f20320q.m21554a();
            }
            this.aA.setVisibility(8);
            this.aO.setVisibility(0);
            voipVideoView2 = this.aP;
            if (!voipVideoView2.f20329z) {
                voipVideoView2.f20327x.setVisibility(8);
                if (voipVideoView2.f20304N) {
                    voipVideoView2.f20321r.setVisibility(0);
                    voipVideoView2.f20320q.setVisibility(8);
                } else {
                    voipVideoView2.f20320q.setVisibility(0);
                    voipVideoView2.f20321r.setVisibility(8);
                }
                voipVideoView2.f20329z = true;
                voipVideoView2.m19927j();
                VoipVideoView.m19909d(voipVideoView2, 5000);
                voipVideoView2.f20301K = ((WebrtcUiHandler) voipVideoView2.f20317n.get()).aH();
                voipVideoView2.m19924e();
            }
            RecyclerView recyclerView = this.aQ;
            int i = (((WebrtcUiHandler) this.an.get()).m19473g() && ((WebrtcUiHandler) this.an.get()).m19441R()) ? 0 : 8;
            recyclerView.setVisibility(i);
            au();
            this.aP.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ WebrtcIncallActivity f19150a;

                {
                    this.f19150a = r1;
                }

                public void onGlobalLayout() {
                    WebrtcIncallActivity.ay(this.f19150a);
                    CustomViewUtils.a(this.f19150a.aP, this);
                }
            });
            this.aP.m19927j();
            this.af = true;
            m19245t(this);
        }
    }

    public static void am(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.al();
        if (!(webrtcIncallActivity.an.get() == null || webrtcIncallActivity.aP == null)) {
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19452a(webrtcIncallActivity.aP.getPeerVideoView());
        }
        webrtcIncallActivity.ap();
    }

    public static void an(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.ao();
        if (!(webrtcIncallActivity.an.get() == null || webrtcIncallActivity.aP == null)) {
            ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19464b(webrtcIncallActivity.aP.getPeerVideoView());
        }
        webrtcIncallActivity.ap();
    }

    private void ao() {
        if (((WebrtcUiHandler) this.an.get()).aD()) {
            if (((WebrtcUiHandler) this.an.get()).aw()) {
                Object obj;
                WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) this.an.get();
                if (webrtcUiHandler.m19434F() || webrtcUiHandler.m19433D() || webrtcUiHandler.m19435G() || webrtcUiHandler.az()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    al();
                    return;
                }
            }
            this.aB.setVisibility(8);
            m19244s(this);
        }
    }

    private void ap() {
        if (this.aP != null) {
            this.aP.m19924e();
        }
    }

    private void aq() {
        if (this.af) {
            this.aO.setVisibility(8);
            this.aA.setVisibility(0);
            this.aQ.setVisibility(8);
            if (this.aP != null) {
                this.aP.m19925g();
            }
            this.af = false;
            m19208L(this);
            if (this.aZ) {
                ay(this);
            } else {
                az(this);
            }
            m19245t(this);
        }
    }

    private void as() {
        ((WebrtcUiHandler) this.an.get()).f19582q.m19353b();
    }

    public static void av(WebrtcIncallActivity webrtcIncallActivity) {
        Object obj;
        if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19433D() || webrtcIncallActivity.af || !m19230b(webrtcIncallActivity, WebrtcViewState.INCALL) || webrtcIncallActivity.f19204x.m19389b() || webrtcIncallActivity.f19194Y) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            webrtcIncallActivity.au();
            return;
        }
        ((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19444U();
        webrtcIncallActivity.getWindow().clearFlags(128);
    }

    private void au() {
        as();
        getWindow().addFlags(128);
    }

    private void aw() {
        as();
        getWindow().clearFlags(128);
    }

    public static boolean ax(WebrtcIncallActivity webrtcIncallActivity) {
        if (System.getInt(webrtcIncallActivity.getContentResolver(), "accelerometer_rotation", 0) != 0) {
            return true;
        }
        return false;
    }

    public static void ay(WebrtcIncallActivity webrtcIncallActivity) {
        if (ax(webrtcIncallActivity)) {
            webrtcIncallActivity.setRequestedOrientation(4);
        } else {
            webrtcIncallActivity.setRequestedOrientation(1);
        }
    }

    public static void az(WebrtcIncallActivity webrtcIncallActivity) {
        webrtcIncallActivity.setRequestedOrientation(1);
    }

    private String aD() {
        return getString(2131232164, new Object[]{getString(2131230720)});
    }

    public static void aG(WebrtcIncallActivity webrtcIncallActivity) {
        if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).ak == 3) {
            if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).m19473g()) {
                webrtcIncallActivity.m19243r();
            }
        } else if (!((WebrtcUiHandler) webrtcIncallActivity.an.get()).aC()) {
        } else {
            if (((WebrtcUiHandler) webrtcIncallActivity.an.get()).aA()) {
                m19228b(webrtcIncallActivity, webrtcIncallActivity.getString(2131232003));
                m19222a(webrtcIncallActivity, webrtcIncallActivity.getString(2131232003), true);
                return;
            }
            m19228b(webrtcIncallActivity, webrtcIncallActivity.getString(2131232001));
            m19222a(webrtcIncallActivity, webrtcIncallActivity.getString(2131232001), true);
        }
    }
}
