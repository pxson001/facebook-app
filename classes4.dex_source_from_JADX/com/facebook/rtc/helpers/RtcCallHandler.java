package com.facebook.rtc.helpers;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.BitmaskEnumUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.mqtt.capabilities.MqttCapability;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.presence.Availability;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.ThreadPresenceManager;
import com.facebook.presence.ThreadPresenceManager.ThreadPresenceCapability;
import com.facebook.push.mqtt.capability.MqttVoipCapability;
import com.facebook.push.mqtt.capability.MqttVoipCapabilityImpl;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.activities.RtcCallPermissionActivity;
import com.facebook.rtc.activities.RtcZeroRatingActivity;
import com.facebook.rtc.campon.RtcCampOnManager;
import com.facebook.rtc.campon.RtcCampOnManager.8;
import com.facebook.rtc.campon.RtcCampOnManager.9;
import com.facebook.rtc.fbwebrtc.WebrtcAppSignalingHandler;
import com.facebook.rtc.fbwebrtc.WebrtcConfigHandler;
import com.facebook.rtc.fbwebrtc.WebrtcSignalingSender;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.LocalVideoState;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.prefs.VoipPrefKeys;
import com.facebook.rtc.services.BackgroundVideoCallService;
import com.facebook.rtcpresence.RtcAbortedCallReasonIds;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.rtcpresence.RtcPresenceState;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ultralight.Inject;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.webrtc.ConferenceCall;
import com.facebook.webrtc.ConferenceCall.Listener;
import com.facebook.webrtc.IWebrtcConfigInterface;
import com.facebook.webrtc.IWebrtcSignalingMessageInterface;
import com.facebook.webrtc.IWebrtcUiInterface;
import com.facebook.webrtc.IWebrtcUiInterface.EndCallReason;
import com.facebook.webrtc.WebrtcManager;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.webrtc.videoengine.VideoCaptureAndroid;

@Singleton
/* compiled from: session_id=? AND _id > ? */
public class RtcCallHandler {
    private static final ImmutableList<String> f2488E = ImmutableList.of("PresenceNotLoaded", "NotCallable");
    private static volatile RtcCallHandler f2489G;
    private static final Class<RtcCallHandler> f2490b = RtcCallHandler.class;
    public final RtcSignalingHandler f2491A;
    private final Provider<WebrtcSignalingSender> f2492B;
    private final Provider<WebrtcConfigHandler> f2493C;
    public AlertDialog f2494D;
    public long f2495F;
    @Inject
    @ForUiThread
    Lazy<ScheduledExecutorService> f2496a;
    private final Lazy<WebrtcAppSignalingHandler> f2497c;
    public final Provider<WebrtcUiHandler> f2498d;
    public final WebrtcManager f2499e;
    private final Provider<RtcCampOnManager> f2500f;
    private final WebrtcLoggingHandler f2501g;
    private final Provider<Boolean> f2502h;
    private final ExecutorService f2503i;
    private final TelephonyManager f2504j;
    private final FbZeroFeatureVisibilityHelper f2505k;
    private final MqttVoipCapabilityImpl f2506l;
    public final Context f2507m;
    public final SecureContextHelper f2508n;
    public final WebrtcLoggingHandler f2509o;
    private final ChannelConnectivityTracker f2510p;
    private final DeviceConditionHelper f2511q;
    private final Provider<Boolean> f2512r;
    private final Provider<Boolean> f2513s;
    private final RtcPresenceHandler f2514t;
    private final MonotonicClock f2515u;
    private final DefaultPresenceManager f2516v;
    private final ThreadPresenceManager f2517w;
    private final ViewerContext f2518x;
    public final QeAccessor f2519y;
    private final FbSharedPreferences f2520z;

    /* compiled from: session_id=? AND _id > ? */
    public class C01231 {
        final /* synthetic */ RtcCallHandler f2574a;

        C01231(RtcCallHandler rtcCallHandler) {
            this.f2574a = rtcCallHandler;
        }

        public final void m2858a() {
            ((WebrtcUiHandler) this.f2574a.f2498d.get()).T();
        }
    }

    public static com.facebook.rtc.helpers.RtcCallHandler m2762a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2489G;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.helpers.RtcCallHandler.class;
        monitor-enter(r1);
        r0 = f2489G;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2772b(r0);	 Catch:{ all -> 0x0035 }
        f2489G = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2489G;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.helpers.RtcCallHandler.a(com.facebook.inject.InjectorLike):com.facebook.rtc.helpers.RtcCallHandler");
    }

    private static RtcCallHandler m2772b(InjectorLike injectorLike) {
        RtcCallHandler rtcCallHandler = new RtcCallHandler(IdBasedSingletonScopeProvider.b(injectorLike, 3302), IdBasedProvider.a(injectorLike, 10375), WebrtcManager.m9858a(injectorLike), IdBasedProvider.a(injectorLike, 10367), WebrtcLoggingHandler.m9451a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4314), IdBasedProvider.a(injectorLike, 4302), IdBasedProvider.a(injectorLike, 4312), TelephonyManagerMethodAutoProvider.a(injectorLike), FbZeroFeatureVisibilityHelper.a(injectorLike), MqttVoipCapabilityImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), WebrtcLoggingHandler.m9451a(injectorLike), ChannelConnectivityTracker.a(injectorLike), DeviceConditionHelper.a(injectorLike), RtcPresenceHandler.m2804a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), DefaultPresenceManager.m7724a(injectorLike), ThreadPresenceManager.m2838a(injectorLike), ViewerContextMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (RtcSignalingHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RtcSignalingHandlerProvider.class), IdBasedSingletonScopeProvider.a(injectorLike, 3308), IdBasedSingletonScopeProvider.a(injectorLike, 3305));
        rtcCallHandler.m2766a(IdBasedSingletonScopeProvider.b(injectorLike, 3863));
        return rtcCallHandler;
    }

    @Inject
    private RtcCallHandler(Lazy<WebrtcAppSignalingHandler> lazy, Provider<WebrtcUiHandler> provider, WebrtcManager webrtcManager, Provider<RtcCampOnManager> provider2, WebrtcLoggingHandler webrtcLoggingHandler, ExecutorService executorService, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, TelephonyManager telephonyManager, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, MqttVoipCapability mqttVoipCapability, Context context, SecureContextHelper secureContextHelper, WebrtcLoggingHandler webrtcLoggingHandler2, ChannelConnectivityTracker channelConnectivityTracker, DeviceConditionHelper deviceConditionHelper, RtcPresenceHandler rtcPresenceHandler, MonotonicClock monotonicClock, PresenceManager presenceManager, ThreadPresenceManager threadPresenceManager, ViewerContext viewerContext, QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences, RtcSignalingHandlerProvider rtcSignalingHandlerProvider, Provider<WebrtcSignalingSender> provider6, Provider<WebrtcConfigHandler> provider7) {
        this.f2497c = lazy;
        this.f2498d = provider;
        this.f2499e = webrtcManager;
        this.f2500f = provider2;
        this.f2501g = webrtcLoggingHandler;
        this.f2502h = provider3;
        this.f2503i = executorService;
        this.f2504j = telephonyManager;
        this.f2505k = zeroFeatureVisibilityHelper;
        this.f2506l = mqttVoipCapability;
        this.f2507m = context;
        this.f2508n = secureContextHelper;
        this.f2509o = webrtcLoggingHandler2;
        this.f2510p = channelConnectivityTracker;
        this.f2511q = deviceConditionHelper;
        this.f2512r = provider4;
        this.f2513s = provider5;
        this.f2514t = rtcPresenceHandler;
        this.f2515u = monotonicClock;
        this.f2516v = presenceManager;
        this.f2517w = threadPresenceManager;
        this.f2518x = viewerContext;
        this.f2519y = qeAccessor;
        this.f2520z = fbSharedPreferences;
        this.f2491A = rtcSignalingHandlerProvider.m2857a(provider3, new C01231(this));
        this.f2492B = provider6;
        this.f2493C = provider7;
    }

    public final StartCallOutcome m2781a(Context context, UserKey userKey, boolean z, String str, String str2, String str3, long j) {
        return m2761a(context, userKey, z, str, str2, str3, j, false);
    }

    public final StartCallOutcome m2780a(Context context, UserKey userKey, String str) {
        RtcPresenceState a = this.f2514t.m2811a(userKey);
        return m2781a(context, userKey, a.a, a.c, a.d, str, a.e());
    }

    public final StartCallOutcome m2795b(Context context, UserKey userKey, boolean z, String str, String str2, String str3, long j) {
        return m2761a(context, userKey, z, str, str2, str3, j, true);
    }

    public final StartCallOutcome m2794b(Context context, UserKey userKey, String str) {
        RtcPresenceState a = this.f2514t.m2811a(userKey);
        return m2795b(context, userKey, a.a, a.c, a.d, str, a.e());
    }

    private boolean m2774c(RtcCallStartParams rtcCallStartParams) {
        if (!m2777h()) {
            return false;
        }
        if (!rtcCallStartParams.a()) {
            return false;
        }
        m2801e();
        if (m2799c()) {
            if (((WebrtcUiHandler) this.f2498d.get()).aD() && ((WebrtcUiHandler) this.f2498d.get()).ai == rtcCallStartParams.a) {
                if (((WebrtcUiHandler) this.f2498d.get()).k() && rtcCallStartParams.j) {
                    if (((WebrtcUiHandler) this.f2498d.get()).G() && ((WebrtcUiHandler) this.f2498d.get()).D()) {
                        WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) this.f2498d.get();
                        if (webrtcUiHandler.bn != null && webrtcUiHandler.ap == LocalVideoState.STARTED) {
                            BackgroundVideoCallService backgroundVideoCallService = webrtcUiHandler.bn;
                            BackgroundVideoCallService.O(backgroundVideoCallService);
                            VideoCaptureAndroid.a(null);
                            ((WebrtcUiHandler) backgroundVideoCallService.t.get()).a(LocalVideoState.STOPPED);
                            BackgroundVideoCallService.T(backgroundVideoCallService);
                        }
                        return true;
                    }
                    if (!((WebrtcUiHandler) this.f2498d.get()).G()) {
                        ((WebrtcUiHandler) this.f2498d.get()).a(EndCallReason.CallEndHangupCall);
                        ((WebrtcUiHandler) this.f2498d.get()).r();
                    } else if (((WebrtcUiHandler) this.f2498d.get()).bL) {
                        ((WebrtcUiHandler) this.f2498d.get()).aO();
                    } else {
                        ((WebrtcUiHandler) this.f2498d.get()).b(true);
                    }
                    return true;
                } else if (((WebrtcUiHandler) this.f2498d.get()).k()) {
                    return true;
                } else {
                    ((WebrtcUiHandler) this.f2498d.get()).aG();
                    return true;
                }
            } else if (!(m2778i() && rtcCallStartParams.k)) {
                return false;
            }
        }
        m2775d(rtcCallStartParams);
        return true;
    }

    public final void m2787a(RtcCallStartParams rtcCallStartParams) {
        if (rtcCallStartParams.a()) {
            m2801e();
            m2767a(rtcCallStartParams, rtcCallStartParams.d);
        }
    }

    private void m2775d(RtcCallStartParams rtcCallStartParams) {
        ((WebrtcAppSignalingHandler) this.f2497c.get()).f2602a = rtcCallStartParams.l;
        if (VERSION.SDK_INT >= 23) {
            Object obj;
            WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) this.f2498d.get();
            if (webrtcUiHandler.cd.a(!rtcCallStartParams.f ? RtcCallPermissionActivity.t : RtcCallPermissionActivity.u)) {
                obj = null;
            } else {
                Intent intent = new Intent(webrtcUiHandler.g, RtcCallPermissionActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("StartParams", rtcCallStartParams);
                webrtcUiHandler.i.a(intent, webrtcUiHandler.g);
                obj = 1;
            }
            if (obj != null) {
                return;
            }
        }
        m2796b(rtcCallStartParams);
    }

    public final void m2796b(RtcCallStartParams rtcCallStartParams) {
        ExecutorDetour.a(this.f2503i, new 2(this, rtcCallStartParams), -1890822223);
        m2767a(rtcCallStartParams, m2776f(rtcCallStartParams));
    }

    private void m2767a(RtcCallStartParams rtcCallStartParams, String str) {
        if (this.f2505k.a(ZeroFeatureKey.VOIP_CALL_INTERSTITIAL)) {
            RtcCallStartParams a = RtcCallStartParams.a(rtcCallStartParams, str);
            Intent intent = new Intent(this.f2507m, RtcZeroRatingActivity.class);
            intent.setAction("ACTION_START_CALL");
            intent.putExtra("EXTRA_CALL_PARAMS", a);
            intent.setFlags(268435456);
            this.f2508n.a(intent, this.f2507m);
            return;
        }
        m2788a(RtcCallStartParams.a(rtcCallStartParams, str), false);
    }

    public final int m2779a(ExposureLogging exposureLogging) {
        return this.f2519y.a(Liveness.Cached, exposureLogging, ExperimentsForRtcModule.f2684a, 0);
    }

    public final boolean m2798b() {
        return ((WebrtcUiHandler) this.f2498d.get()).aE() > this.f2495F;
    }

    public final void m2788a(RtcCallStartParams rtcCallStartParams, boolean z) {
        String L = rtcCallStartParams.f ? ((WebrtcUiHandler) this.f2498d.get()).L() : "";
        if (rtcCallStartParams.j) {
            this.f2499e.m9864a(rtcCallStartParams.a, rtcCallStartParams.b, rtcCallStartParams.c, rtcCallStartParams.d, L, rtcCallStartParams.i);
        } else if (m2793a(rtcCallStartParams.f, ExposureLogging.On)) {
            ((ScheduledExecutorService) this.f2496a.get()).schedule(new 3(this, rtcCallStartParams, L), (long) m2779a(ExposureLogging.Off), TimeUnit.MILLISECONDS);
        } else {
            this.f2499e.m9866a(rtcCallStartParams.a, rtcCallStartParams.d, L, rtcCallStartParams.f, rtcCallStartParams.f, true, true, rtcCallStartParams.i);
        }
        ((WebrtcUiHandler) this.f2498d.get()).b(rtcCallStartParams);
        this.f2501g.m9475a(rtcCallStartParams.d, rtcCallStartParams.e);
        if (z) {
            this.f2501g.m9480a("zero_rating_shown", true);
            this.f2501g.m9480a("zero_rating_accepted", true);
        }
    }

    public final boolean m2793a(boolean z, ExposureLogging exposureLogging) {
        if (z) {
            if (this.f2519y.a(Liveness.Cached, exposureLogging, ExperimentsForRtcModule.f2686c, 0) > 0) {
                return true;
            }
            return false;
        } else if (m2779a(exposureLogging) <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.common.util.TriState m2771b(com.facebook.rtc.helpers.RtcCallStartParams r6, java.lang.String[] r7, java.lang.String[] r8, @javax.annotation.Nullable java.lang.String r9) {
        /*
        r5 = this;
        r0 = r5.m2777h();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r0 = com.facebook.common.util.TriState.UNSET;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = r6.a();
        if (r0 != 0) goto L_0x0012;
    L_0x000f:
        r0 = com.facebook.common.util.TriState.UNSET;
        goto L_0x0008;
    L_0x0012:
        r0 = r5.m2799c();
        if (r0 == 0) goto L_0x006b;
    L_0x0018:
        r0 = r5.f2498d;
        r0 = r0.get();
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;
        r0 = r0.aD();
        if (r0 == 0) goto L_0x0068;
    L_0x0026:
        r0 = r5.f2498d;
        r0 = r0.get();
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;
        r0 = r0.e();
        if (r0 == 0) goto L_0x0068;
    L_0x0034:
        r0 = r5.f2498d;
        r0 = r0.get();
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;
        r0 = r0.Z();
        r0 = com.facebook.common.util.StringUtil.a(r0);
        if (r0 != 0) goto L_0x0068;
    L_0x0046:
        r0 = r5.f2498d;
        r0 = r0.get();
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;
        r0 = r0.Z();
        r1 = r6.g;
        r0 = r0.contentEquals(r1);
        if (r0 == 0) goto L_0x0068;
    L_0x005a:
        r0 = r5.f2498d;
        r0 = r0.get();
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;
        r0.aG();
        r0 = com.facebook.common.util.TriState.YES;
        goto L_0x0008;
    L_0x0068:
        r0 = com.facebook.common.util.TriState.NO;
        goto L_0x0008;
    L_0x006b:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 23;
        if (r0 < r1) goto L_0x008b;
    L_0x0071:
        r0 = r5.f2498d;
        r0 = r0.get();
        r0 = (com.facebook.rtc.fbwebrtc.WebrtcUiHandler) r0;
        r3 = r0.cd;
        r2 = r6.f;
        if (r2 != 0) goto L_0x0092;
    L_0x007f:
        r2 = com.facebook.rtc.activities.RtcCallPermissionActivity.t;
    L_0x0081:
        r2 = r3.a(r2);
        if (r2 == 0) goto L_0x0095;
    L_0x0087:
        r2 = 0;
    L_0x0088:
        r0 = r2;
        if (r0 != 0) goto L_0x008e;
    L_0x008b:
        r5.m2789a(r6, r7, r8, r9);
    L_0x008e:
        r0 = com.facebook.common.util.TriState.YES;
        goto L_0x0008;
    L_0x0092:
        r2 = com.facebook.rtc.activities.RtcCallPermissionActivity.u;
        goto L_0x0081;
    L_0x0095:
        r2 = new android.content.Intent;
        r3 = r0.g;
        r4 = com.facebook.rtc.activities.RtcCallPermissionActivity.class;
        r2.<init>(r3, r4);
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r2.setFlags(r3);
        r3 = "StartParams";
        r2.putExtra(r3, r6);
        r3 = "ConferenceParticipants";
        r2.putExtra(r3, r7);
        r3 = "ConferenceParticipantsToRing";
        r2.putExtra(r3, r8);
        r3 = "ConferenceServerInfo";
        r2.putExtra(r3, r9);
        r3 = r0.i;
        r4 = r0.g;
        r3.a(r2, r4);
        r2 = 1;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.helpers.RtcCallHandler.b(com.facebook.rtc.helpers.RtcCallStartParams, java.lang.String[], java.lang.String[], java.lang.String):com.facebook.common.util.TriState");
    }

    public final void m2789a(RtcCallStartParams rtcCallStartParams, String[] strArr, @Nullable String[] strArr2, @Nullable String str) {
        if (strArr != null) {
            ConferenceCall createConferenceHandle;
            m2801e();
            WebrtcManager webrtcManager = this.f2499e;
            String str2 = rtcCallStartParams.g;
            String f = m2776f(rtcCallStartParams);
            if (webrtcManager.m9873a()) {
                createConferenceHandle = webrtcManager.f9506w.createConferenceHandle(str2, f);
            } else {
                createConferenceHandle = null;
            }
            ConferenceCall conferenceCall = createConferenceHandle;
            if (conferenceCall != null) {
                if (rtcCallStartParams.f) {
                    conferenceCall.setCameraId(((WebrtcUiHandler) this.f2498d.get()).L());
                    conferenceCall.configureVideo(true);
                }
                if (strArr2 != null && strArr2.length > 0) {
                    conferenceCall.call(strArr2);
                } else if (StringUtil.a(str)) {
                    conferenceCall.join();
                } else {
                    conferenceCall.join(str);
                }
                ((WebrtcUiHandler) this.f2498d.get()).a(conferenceCall, rtcCallStartParams, strArr);
                ((WebrtcUiHandler) this.f2498d.get()).switchToContactingUI();
            }
        }
    }

    private static String m2776f(RtcCallStartParams rtcCallStartParams) {
        String str = rtcCallStartParams.d;
        if (StringUtil.a(str)) {
            return "unknown";
        }
        return str;
    }

    public final void m2791a(JsonNode jsonNode) {
        if (m2777h()) {
            long c = JSONUtil.c(jsonNode.b("uid"));
            long c2 = JSONUtil.c(jsonNode.b("capabilities"));
            if (c == 0) {
                BLog.b(f2490b, "No valid uid in gcm payload");
            } else if (this.f2506l.a(c2)) {
                Long.valueOf(c);
                Long.valueOf(c2);
                RtcCampOnManager rtcCampOnManager = (RtcCampOnManager) this.f2500f.get();
                if (!(rtcCampOnManager.t.get(Long.valueOf(c)) == null && rtcCampOnManager.o.m9449a())) {
                    if (!rtcCampOnManager.o.m9449a()) {
                        rtcCampOnManager.o.init();
                    }
                    if (rtcCampOnManager.o.m9449a()) {
                        ExecutorDetour.a(rtcCampOnManager.j, new 9(rtcCampOnManager, c), 1966929074);
                    } else {
                        rtcCampOnManager.j.schedule(new 8(rtcCampOnManager, c), 5, TimeUnit.SECONDS);
                    }
                }
            }
        }
    }

    private boolean m2777h() {
        return ((Boolean) this.f2502h.get()).booleanValue();
    }

    public final boolean m2799c() {
        return m2800d() || m2778i();
    }

    public final boolean m2800d() {
        return ((WebrtcUiHandler) this.f2498d.get()).aD();
    }

    private boolean m2778i() {
        return (this.f2504j == null || this.f2504j.getCallState() == 0) ? false : true;
    }

    public final void m2801e() {
        this.f2499e.m9868a((IWebrtcUiInterface) this.f2498d.get(), (Listener) this.f2498d.get(), (WebrtcUiHandler) this.f2498d.get(), (IWebrtcConfigInterface) this.f2493C.get(), this.f2509o, (IWebrtcSignalingMessageInterface) this.f2492B.get());
    }

    public final void m2784a(Context context, String str) {
        m2765a(context, str, null);
    }

    private void m2765a(Context context, String str, String str2) {
        CharSequence string;
        CharSequence string2;
        if (str == null) {
            string = context.getString(2131232025);
        }
        if (str2 == null) {
            string2 = context.getString(2131232024);
        }
        this.f2494D = new FbAlertDialogBuilder(context).m14337a(string2).m14346b(string).mo963a(context.getString(2131230726), new 4(this)).mo964a();
        this.f2494D.setOnDismissListener(new 5(this));
        this.f2494D.show();
    }

    private void m2766a(Lazy<ScheduledExecutorService> lazy) {
        this.f2496a = lazy;
    }

    public final void m2782a(Context context, UserKey userKey, String str, String str2, String str3, boolean z, String str4) {
        m2783a(context, userKey, str, str2, str3, z, str4, null);
    }

    public final void m2783a(Context context, UserKey userKey, String str, String str2, String str3, boolean z, String str4, @Nullable OnClickListener onClickListener) {
        if (onClickListener == null) {
            6 6 = new 6(this, userKey, str4);
        }
        this.f2494D = new FbAlertDialogBuilder(context).m14337a((CharSequence) str).m14346b((CharSequence) str2).mo962a(z ? 2131232044 : 2131232045, new 7(this, context, userKey, null, null, str4)).mo966b((CharSequence) str3, onClickListener).mo964a();
        this.f2494D.setOnDismissListener(new 8(this));
        this.f2494D.show();
    }

    public final void m2790a(UserKey userKey, Context context, String str, boolean z) {
        String b = this.f2517w.m2852b(userKey);
        String c = this.f2517w.m2853c(userKey);
        int f = this.f2517w.m2856f(userKey);
        if (!((WebrtcUiHandler) this.f2498d.get()).l() || b == null || c == null || (ThreadPresenceCapability.THREAD_PRESENCE_CAPABILITY_INSTANT_MVP.getValue() & f) <= 0) {
            m2794b(context, userKey, str);
        } else {
            m2774c(RtcCallStartParams.a(Long.parseLong(userKey.b()), Long.parseLong(c), b, m2763a(userKey, null), z));
        }
    }

    private StartCallOutcome m2761a(Context context, UserKey userKey, boolean z, String str, String str2, String str3, long j, boolean z2) {
        if (userKey == null || userKey.a() != Type.FACEBOOK) {
            return StartCallOutcome.UNABLE_TO_CALL;
        }
        long parseLong = Long.parseLong(userKey.b());
        if (((Boolean) this.f2513s.get()).booleanValue()) {
            m2765a(context, context.getString(2131232027), context.getString(2131232111));
            this.f2509o.m9478a(userKey.b(), str3, z2, RtcAbortedCallReasonIds.l);
            return StartCallOutcome.UNABLE_TO_CALL;
        }
        NetworkInfo c = this.f2511q.c();
        if (c == null || !c.isConnectedOrConnecting()) {
            m2765a(context, context.getString(2131232026), context.getString(2131232114));
            this.f2509o.m9478a(userKey.b(), str3, z2, RtcAbortedCallReasonIds.f);
            return StartCallOutcome.UNABLE_TO_CALL;
        } else if (this.f2510p.f()) {
            if (!z) {
                boolean contains = f2488E.contains(str2);
                if (!contains && RtcAbortedCallReasonIds.a.equals(str2)) {
                    contains = this.f2519y.a(ExperimentsForRtcModule.bR, false);
                }
                if (!contains) {
                    m2765a(context, str, null);
                    this.f2509o.m9478a(userKey.b(), str3, z2, str2);
                    return StartCallOutcome.UNABLE_TO_CALL;
                }
            }
            boolean z3 = z2 && ((Boolean) this.f2512r.get()).booleanValue();
            String a = m2763a(userKey, str2);
            if (m2769a(userKey)) {
                String a2 = m2764a(Long.toString(parseLong));
                String[] strArr = new String[]{Long.toString(parseLong)};
                if (m2771b(RtcCallStartParams.a(parseLong, str3, j, z3, a, a2), strArr, strArr, null) != TriState.NO) {
                    return StartCallOutcome.CALL_STARTED;
                }
                m2784a(context, context.getString(2131232028));
                this.f2509o.m9478a(a2, str3, false, RtcAbortedCallReasonIds.i);
                return StartCallOutcome.UNABLE_TO_CALL;
            } else if (m2774c(RtcCallStartParams.a(parseLong, str3, j, z3, a))) {
                return StartCallOutcome.CALL_STARTED;
            } else {
                m2784a(context, context.getString(2131232028));
                this.f2509o.m9478a(userKey.b(), str3, z2, RtcAbortedCallReasonIds.i);
                return StartCallOutcome.UNABLE_TO_CALL;
            }
        } else {
            this.f2491A.m2865a();
            m2765a(context, context.getString(2131232026), context.getString(2131232114));
            this.f2509o.m9478a(userKey.b(), str3, z2, RtcAbortedCallReasonIds.g);
            return StartCallOutcome.UNABLE_TO_CALL;
        }
    }

    public final void m2786a(ThreadSummary threadSummary, @Nullable String str, boolean z, String str2, Context context) {
        String[] a = m2770a(threadSummary, this.f2518x.mUserId);
        if (a == null) {
            BLog.b(f2490b, "Cannot join multiway call due to null participants list");
            return;
        }
        String l = Long.toString(threadSummary.a.i());
        String b = m2773b(l);
        if (m2771b(RtcCallStartParams.a(b, l, z, str2), a, null, str) == TriState.NO) {
            m2784a(context, context.getString(2131232028));
            this.f2509o.m9478a(b, str2, false, RtcAbortedCallReasonIds.i);
        }
    }

    private boolean m2768a(ThreadSummary threadSummary) {
        return this.f2519y.a(ExperimentsForRtcModule.dd, 3) >= threadSummary.h.size();
    }

    @Nullable
    public static String[] m2770a(ThreadSummary threadSummary, String str) {
        if (threadSummary == null || threadSummary.h == null) {
            BLog.b(f2490b, "Cannot getMultiwayParticipantsFromThreadSummary due to null ThreadSummary");
            return null;
        }
        List arrayList = new ArrayList();
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (!(threadParticipant == null || threadParticipant.b() == null || threadParticipant.b().b() == null || threadParticipant.b().b().contentEquals(str))) {
                arrayList.add(threadParticipant.b().b());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void m2785a(ThreadSummary threadSummary, Context context, boolean z, String str) {
        String[] a = m2770a(threadSummary, this.f2518x.a());
        if (a == null) {
            BLog.b(f2490b, "Cannot show confirmation dialog for multiway due to null participants list");
        } else if (m2768a(threadSummary)) {
            m2792a(Long.toString(threadSummary.a.i()), a, a, z, str, context);
        } else {
            Builder fbAlertDialogBuilder = new FbAlertDialogBuilder(context);
            fbAlertDialogBuilder.m14329a(2131232095).m14343b(2131232096).mo962a(2131230729, new 10(this, threadSummary, a, z, str, context)).mo965b(2131230727, new 9(this));
            fbAlertDialogBuilder.mo964a().show();
        }
    }

    public final void m2792a(String str, String[] strArr, String[] strArr2, boolean z, String str2, Context context) {
        String b = m2773b(str);
        if (m2771b(RtcCallStartParams.a(b, str, z, str2), strArr, strArr2, null) == TriState.NO) {
            m2784a(context, context.getString(2131232028));
            this.f2509o.m9478a(b, str2, false, RtcAbortedCallReasonIds.i);
        }
    }

    @Nullable
    private String m2764a(String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PEER:");
        if (Long.parseLong(str) < Long.parseLong(this.f2518x.mUserId)) {
            stringBuilder.append(str);
            stringBuilder.append(":");
            stringBuilder.append(this.f2518x.mUserId);
        } else {
            stringBuilder.append(this.f2518x.mUserId);
            stringBuilder.append(":");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private String m2763a(UserKey userKey, String str) {
        Object obj;
        RtcPresenceState a = this.f2514t.m2811a(userKey);
        if (this.f2516v.m7763c(userKey).b == Availability.AVAILABLE) {
            obj = 1;
        } else {
            obj = null;
        }
        boolean e = this.f2517w.m2855e(userKey);
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        if (!(str == null || str.isEmpty())) {
            builder.b("disabled_reason_id", str);
        }
        builder.b("presence_cache_age", Long.toString(this.f2515u.now() - a.e));
        builder.b("active", obj != null ? "1" : "0");
        builder.b("copresent", e ? "1" : "0");
        builder.a(a.f);
        return JSONUtil.a(builder.b()).toString();
    }

    private boolean m2769a(UserKey userKey) {
        int parseInt = Integer.parseInt(this.f2520z.a(VoipPrefKeys.g, "-1"));
        if (parseInt == -1) {
            long e = this.f2516v.m7767e(userKey);
            MqttVoipCapabilityImpl mqttVoipCapabilityImpl = this.f2506l;
            if (((BitmaskEnumUtil.a(MqttCapability.ONE_ON_ONE_OVER_MULTIWAY) & e) != 0 ? 1 : null) == null) {
                return false;
            }
            return this.f2519y.a(ExperimentsForRtcModule.f2705u, false);
        } else if (parseInt == 1) {
            return true;
        } else {
            return false;
        }
    }

    public final void m2797b(JsonNode jsonNode) {
        this.f2491A.m2868a(jsonNode);
    }

    @Nullable
    private static String m2773b(String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GROUP:");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final int m2802f() {
        return this.f2519y.a(ExperimentsForRtcModule.de, 12);
    }

    public final void m2803g() {
        if (this.f2494D != null && this.f2494D.isShowing()) {
            this.f2494D.dismiss();
        }
        this.f2494D = null;
    }
}
