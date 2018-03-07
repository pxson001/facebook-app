package com.facebook.rtc.fbwebrtc;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Environment;
import android.telephony.TelephonyManager;
import com.facebook.abtest.qe.bootstrap.framework.BaseQuickExperiment;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.auth.credentials.UserTokenCredentials;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.async.AsyncTaskVersionHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.hardware.TelephonyManagerUtils;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.util.BitmaskEnumUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.capabilities.MqttCapability;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.presence.ThreadPresenceManager.ThreadPresenceCapability;
import com.facebook.push.mqtt.capability.MqttVoipCapability;
import com.facebook.push.mqtt.capability.MqttVoipCapabilityImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.abtest.WebrtcNativeExperiment.Config;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.fbwebrtc.abtests.Rtc48KhzExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcAggregationExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcAndroidVp8HWDecodeExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcAudioIndicatorExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcAudioManagerForDeviceExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcBitrateLoggingExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcBwePausingExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcDataChannelExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcFastProbeExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcFloatingPointIsacExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcGroupAudioIndicatorExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcInitialBitrateExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcIpv6Experiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcJniExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcLoggingConfig$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcMultiwayIsacExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcNetEq4TuneExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcNetworkCharacterizationExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcOpenSLRealizeFailExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcOpispxExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcQuickerExperimentHelper;
import com.facebook.rtc.fbwebrtc.abtests.RtcSendNoSilenceExperiment.Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcSilenceRestartExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcSpeexArtifactsExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcSpeexWbTablesExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcSwAutomaticGainControlExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcSwEchoCancellationExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcSwNoiseSuppressionExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcVideoH264AndroidExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcVideoKeyFrameIntervalExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcVideoParamsExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcVideoStarveControlParamsExperiment$Helper;
import com.facebook.rtc.fbwebrtc.abtests.RtcVideoTimeoutExperiment$Helper;
import com.facebook.rtc.fbwebrtc.xconfig.VoipConfig;
import com.facebook.rtc.prefs.InternalVoipPrefKeys;
import com.facebook.webrtc.IWebrtcConfigInterface;
import com.facebook.webrtc.TurnAllocatorCallback;
import com.facebook.webrtc.WebrtcEngine;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: serialized_draft */
public class WebrtcConfigHandler implements IWebrtcConfigInterface {
    public static final Class<?> f2603a = WebrtcConfigHandler.class;
    public static final CallerContext ab = CallerContext.a(WebrtcConfigHandler.class);
    public static final ImmutableMap<String, PrefKey> ae = ImmutableBiMap.b("voip_bwe_logging", InternalVoipPrefKeys.f11375h);
    private static volatile WebrtcConfigHandler af;
    private final RtcQuickerExperimentHelper f2604A;
    private final RtcQuickerExperimentHelper f2605B;
    private final RtcQuickerExperimentHelper f2606C;
    private final RtcQuickerExperimentHelper f2607D;
    private final RtcQuickerExperimentHelper f2608E;
    private final RtcQuickerExperimentHelper f2609F;
    private final RtcQuickerExperimentHelper f2610G;
    private final RtcQuickerExperimentHelper f2611H;
    private final RtcQuickerExperimentHelper f2612I;
    private final RtcQuickerExperimentHelper f2613J;
    private final RtcQuickerExperimentHelper f2614K;
    private final RtcQuickerExperimentHelper f2615L;
    private final RtcQuickerExperimentHelper f2616M;
    private final RtcQuickerExperimentHelper f2617N;
    private final RtcQuickerExperimentHelper f2618O;
    private final RtcQuickerExperimentHelper f2619P;
    private final RtcQuickerExperimentHelper f2620Q;
    private final RtcQuickerExperimentHelper f2621R;
    private final RtcQuickerExperimentHelper f2622S;
    private final RtcQuickerExperimentHelper f2623T;
    private final RtcQuickerExperimentHelper f2624U;
    private volatile WebrtcEngine f2625V;
    private Random f2626W;
    private MqttVoipCapabilityImpl f2627X;
    private FbAppType f2628Y;
    private UniqueIdForDeviceHolderImpl f2629Z;
    private final Map<String, Integer> aa;
    private String ac = "";
    private String ad = "";
    private final Context f2630b;
    private final Provider<UserTokenCredentials> f2631c;
    public final FbSharedPreferences f2632d;
    private final GatekeeperStoreImpl f2633e;
    private final Provider<Boolean> f2634f;
    private final Provider<Boolean> f2635g;
    private final TelephonyManager f2636h;
    private final WebrtcConfigManager f2637i;
    private final WebrtcAudioMode f2638j;
    private final QuickExperimentController f2639k;
    private final RtcQuickerExperimentHelper f2640l;
    private final RtcQuickerExperimentHelper f2641m;
    private final DeviceConditionHelper f2642n;
    public final AbstractSingleMethodRunner f2643o;
    public final WebrtcTurnAllocationMethod f2644p;
    private final QeAccessor f2645q;
    private final RtcQuickerExperimentHelper f2646r;
    private final RtcQuickerExperimentHelper f2647s;
    private final RtcQuickerExperimentHelper f2648t;
    private final RtcQuickerExperimentHelper f2649u;
    private final RtcQuickerExperimentHelper f2650v;
    private final RtcQuickerExperimentHelper f2651w;
    private final RtcQuickerExperimentHelper f2652x;
    private final RtcQuickerExperimentHelper f2653y;
    private final RtcQuickerExperimentHelper f2654z;

    public static com.facebook.rtc.fbwebrtc.WebrtcConfigHandler m2887a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = af;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.fbwebrtc.WebrtcConfigHandler.class;
        monitor-enter(r1);
        r0 = af;	 Catch:{ all -> 0x003a }
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
        r0 = m2890b(r0);	 Catch:{ all -> 0x0035 }
        af = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = af;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.WebrtcConfigHandler.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.WebrtcConfigHandler");
    }

    private static WebrtcConfigHandler m2890b(InjectorLike injectorLike) {
        return new WebrtcConfigHandler((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 334), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), TelephonyManagerMethodAutoProvider.a(injectorLike), RtcInitialBitrateExperiment$Helper.m2896a(injectorLike), RtcVideoTimeoutExperiment$Helper.m2906a(injectorLike), DeviceConditionHelper.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4314), IdBasedProvider.a(injectorLike, 4302), WebrtcConfigManager.m2912a(injectorLike), WebrtcAudioMode.m2914a(injectorLike), MqttVoipCapabilityImpl.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), UniqueIdForDeviceHolderMethodAutoProvider.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), WebrtcTurnAllocationMethod.m2923a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Rtc48KhzExperiment$Helper.m2926a(injectorLike), RtcAggregationExperiment$Helper.m2932a(injectorLike), RtcAndroidVp8HWDecodeExperiment$Helper.m2938a(injectorLike), RtcAudioManagerForDeviceExperiment$Helper.m2944a(injectorLike), RtcBitrateLoggingExperiment$Helper.m2950a(injectorLike), RtcBwePausingExperiment$Helper.m2956a(injectorLike), RtcDataChannelExperiment$Helper.m2962a(injectorLike), RtcFloatingPointIsacExperiment$Helper.m2968a(injectorLike), RtcFastProbeExperiment$Helper.m2974a(injectorLike), RtcIpv6Experiment$Helper.m2980a(injectorLike), RtcJniExperiment$Helper.m2986a(injectorLike), RtcLoggingConfig$Helper.m2992a(injectorLike), RtcMultiwayIsacExperiment$Helper.m2998a(injectorLike), RtcNetEq4TuneExperiment$Helper.m3004a(injectorLike), RtcNetworkCharacterizationExperiment$Helper.m3010a(injectorLike), RtcOpenSLRealizeFailExperiment$Helper.m3016a(injectorLike), RtcOpispxExperiment$Helper.m3022a(injectorLike), Helper.a(injectorLike), RtcSilenceRestartExperiment$Helper.m3028a(injectorLike), RtcSpeexArtifactsExperiment$Helper.m3034a(injectorLike), RtcSpeexWbTablesExperiment$Helper.m3040a(injectorLike), RtcSwAutomaticGainControlExperiment$Helper.m3046a(injectorLike), RtcSwEchoCancellationExperiment$Helper.m3052a(injectorLike), RtcSwNoiseSuppressionExperiment$Helper.m3058a(injectorLike), RtcVideoParamsExperiment$Helper.m3064a(injectorLike), RtcVideoKeyFrameIntervalExperiment$Helper.m3070a(injectorLike), RtcVideoStarveControlParamsExperiment$Helper.m3076a(injectorLike), RtcGroupAudioIndicatorExperiment$Helper.m3082a(injectorLike), RtcAudioIndicatorExperiment$Helper.m3088a(injectorLike), RtcVideoH264AndroidExperiment$Helper.m3094a(injectorLike));
    }

    @Inject
    public WebrtcConfigHandler(Context context, Provider<UserTokenCredentials> provider, FbSharedPreferences fbSharedPreferences, GatekeeperStore gatekeeperStore, QuickExperimentController quickExperimentController, TelephonyManager telephonyManager, RtcInitialBitrateExperiment$Helper rtcInitialBitrateExperiment$Helper, RtcVideoTimeoutExperiment$Helper rtcVideoTimeoutExperiment$Helper, DeviceConditionHelper deviceConditionHelper, Random random, Provider<Boolean> provider2, Provider<Boolean> provider3, WebrtcConfigManager webrtcConfigManager, WebrtcAudioMode webrtcAudioMode, MqttVoipCapability mqttVoipCapability, FbAppType fbAppType, UniqueIdForDeviceHolder uniqueIdForDeviceHolder, SingleMethodRunner singleMethodRunner, WebrtcTurnAllocationMethod webrtcTurnAllocationMethod, QeAccessor qeAccessor, Rtc48KhzExperiment$Helper rtc48KhzExperiment$Helper, RtcAggregationExperiment$Helper rtcAggregationExperiment$Helper, RtcAndroidVp8HWDecodeExperiment$Helper rtcAndroidVp8HWDecodeExperiment$Helper, RtcAudioManagerForDeviceExperiment$Helper rtcAudioManagerForDeviceExperiment$Helper, RtcBitrateLoggingExperiment$Helper rtcBitrateLoggingExperiment$Helper, RtcBwePausingExperiment$Helper rtcBwePausingExperiment$Helper, RtcDataChannelExperiment$Helper rtcDataChannelExperiment$Helper, RtcFloatingPointIsacExperiment$Helper rtcFloatingPointIsacExperiment$Helper, RtcFastProbeExperiment$Helper rtcFastProbeExperiment$Helper, RtcIpv6Experiment$Helper rtcIpv6Experiment$Helper, RtcJniExperiment$Helper rtcJniExperiment$Helper, RtcLoggingConfig$Helper rtcLoggingConfig$Helper, RtcMultiwayIsacExperiment$Helper rtcMultiwayIsacExperiment$Helper, RtcNetEq4TuneExperiment$Helper rtcNetEq4TuneExperiment$Helper, RtcNetworkCharacterizationExperiment$Helper rtcNetworkCharacterizationExperiment$Helper, RtcOpenSLRealizeFailExperiment$Helper rtcOpenSLRealizeFailExperiment$Helper, RtcOpispxExperiment$Helper rtcOpispxExperiment$Helper, Helper helper, RtcSilenceRestartExperiment$Helper rtcSilenceRestartExperiment$Helper, RtcSpeexArtifactsExperiment$Helper rtcSpeexArtifactsExperiment$Helper, RtcSpeexWbTablesExperiment$Helper rtcSpeexWbTablesExperiment$Helper, RtcSwAutomaticGainControlExperiment$Helper rtcSwAutomaticGainControlExperiment$Helper, RtcSwEchoCancellationExperiment$Helper rtcSwEchoCancellationExperiment$Helper, RtcSwNoiseSuppressionExperiment$Helper rtcSwNoiseSuppressionExperiment$Helper, RtcVideoParamsExperiment$Helper rtcVideoParamsExperiment$Helper, RtcVideoKeyFrameIntervalExperiment$Helper rtcVideoKeyFrameIntervalExperiment$Helper, RtcVideoStarveControlParamsExperiment$Helper rtcVideoStarveControlParamsExperiment$Helper, RtcGroupAudioIndicatorExperiment$Helper rtcGroupAudioIndicatorExperiment$Helper, RtcAudioIndicatorExperiment$Helper rtcAudioIndicatorExperiment$Helper, RtcVideoH264AndroidExperiment$Helper rtcVideoH264AndroidExperiment$Helper) {
        this.f2630b = context;
        this.f2631c = provider;
        this.f2632d = fbSharedPreferences;
        this.f2633e = gatekeeperStore;
        this.f2639k = quickExperimentController;
        this.f2636h = telephonyManager;
        this.f2640l = rtcInitialBitrateExperiment$Helper;
        this.f2641m = rtcVideoTimeoutExperiment$Helper;
        this.f2642n = deviceConditionHelper;
        this.f2626W = random;
        this.f2634f = provider2;
        this.f2635g = provider3;
        this.f2637i = webrtcConfigManager;
        this.f2638j = webrtcAudioMode;
        this.f2627X = mqttVoipCapability;
        this.f2628Y = fbAppType;
        this.f2645q = qeAccessor;
        this.f2629Z = uniqueIdForDeviceHolder;
        this.f2643o = singleMethodRunner;
        this.f2644p = webrtcTurnAllocationMethod;
        this.aa = m2894d();
        this.f2646r = rtc48KhzExperiment$Helper;
        this.f2647s = rtcAggregationExperiment$Helper;
        this.f2648t = rtcAndroidVp8HWDecodeExperiment$Helper;
        this.f2649u = rtcAudioManagerForDeviceExperiment$Helper;
        this.f2650v = rtcBitrateLoggingExperiment$Helper;
        this.f2651w = rtcBwePausingExperiment$Helper;
        this.f2652x = rtcDataChannelExperiment$Helper;
        this.f2653y = rtcFastProbeExperiment$Helper;
        this.f2654z = rtcFloatingPointIsacExperiment$Helper;
        this.f2604A = rtcIpv6Experiment$Helper;
        this.f2605B = rtcJniExperiment$Helper;
        this.f2606C = rtcLoggingConfig$Helper;
        this.f2607D = rtcMultiwayIsacExperiment$Helper;
        this.f2608E = rtcNetEq4TuneExperiment$Helper;
        this.f2609F = rtcNetworkCharacterizationExperiment$Helper;
        this.f2610G = rtcOpenSLRealizeFailExperiment$Helper;
        this.f2611H = rtcOpispxExperiment$Helper;
        this.f2612I = helper;
        this.f2613J = rtcSilenceRestartExperiment$Helper;
        this.f2614K = rtcSpeexArtifactsExperiment$Helper;
        this.f2615L = rtcSpeexWbTablesExperiment$Helper;
        this.f2616M = rtcSwAutomaticGainControlExperiment$Helper;
        this.f2617N = rtcSwEchoCancellationExperiment$Helper;
        this.f2618O = rtcSwNoiseSuppressionExperiment$Helper;
        this.f2619P = rtcVideoParamsExperiment$Helper;
        this.f2620Q = rtcVideoKeyFrameIntervalExperiment$Helper;
        this.f2621R = rtcVideoStarveControlParamsExperiment$Helper;
        this.f2622S = rtcGroupAudioIndicatorExperiment$Helper;
        this.f2623T = rtcAudioIndicatorExperiment$Helper;
        this.f2624U = rtcVideoH264AndroidExperiment$Helper;
    }

    public void allocateTurnServer(String str, String str2, TurnAllocatorCallback turnAllocatorCallback) {
        String str3;
        UserTokenCredentials userTokenCredentials = (UserTokenCredentials) this.f2631c.get();
        if (userTokenCredentials == null) {
            str3 = "";
        } else {
            str3 = userTokenCredentials.b;
        }
        AsyncTaskVersionHelper.m4682a(new 1(this, str3, str, str2, new ApiMethodRunnerParams(), turnAllocatorCallback), new Void[0]);
    }

    public void setWebrtcEngine(WebrtcEngine webrtcEngine) {
        this.f2625V = webrtcEngine;
    }

    public boolean getBooleanParam(String str, boolean z) {
        PrefKey prefKey = (PrefKey) ae.get(str);
        if (prefKey == null) {
            return z;
        }
        TriState b = this.f2632d.b(prefKey);
        if (b == TriState.YES) {
            return true;
        }
        if (b == TriState.NO) {
            return false;
        }
        return z;
    }

    public int getIntParam(String str, int i) {
        String str2;
        PrefKey prefKey = (PrefKey) ae.get(str);
        if (prefKey == null) {
            str2 = null;
        } else {
            str2 = this.f2632d.a(prefKey, null);
        }
        String str3 = str2;
        if (StringUtil.a(str3)) {
            return i;
        }
        return Integer.parseInt(str3);
    }

    private Config m2892c(String str) {
        BaseQuickExperiment baseQuickExperiment = null;
        if (baseQuickExperiment == null) {
            return null;
        }
        return (Config) this.f2639k.a(baseQuickExperiment);
    }

    private boolean m2891b(String str) {
        RtcQuickerExperimentHelper d = m2893d(str);
        if (d == null) {
            return false;
        }
        d.mo257b();
        return true;
    }

    public void logExperimentObservation(String str) {
        if (!m2891b(str)) {
            BaseQuickExperiment baseQuickExperiment = null;
            if (baseQuickExperiment != null) {
                this.f2639k.b(baseQuickExperiment);
            }
        }
    }

    private RtcQuickerExperimentHelper m2893d(String str) {
        if (this.f2604A.mo255a().equals(str)) {
            return this.f2604A;
        }
        if (this.f2606C.mo255a().equals(str)) {
            return this.f2606C;
        }
        if (this.f2605B.mo255a().equals(str)) {
            return this.f2605B;
        }
        if (this.f2640l.mo255a().equals(str)) {
            return this.f2640l;
        }
        if (this.f2641m.mo255a().equals(str)) {
            return this.f2641m;
        }
        if (this.f2607D.mo255a().equals(str)) {
            return this.f2607D;
        }
        if (this.f2608E.mo255a().equals(str)) {
            return this.f2608E;
        }
        if (this.f2610G.mo255a().equals(str)) {
            return this.f2610G;
        }
        if (this.f2611H.mo255a().equals(str)) {
            return this.f2611H;
        }
        if (this.f2612I.mo255a().equals(str)) {
            return this.f2612I;
        }
        if (this.f2613J.mo255a().equals(str)) {
            return this.f2613J;
        }
        if (this.f2614K.mo255a().equals(str)) {
            return this.f2614K;
        }
        if (this.f2619P.mo255a().equals(str)) {
            return this.f2619P;
        }
        if (this.f2620Q.mo255a().equals(str)) {
            return this.f2620Q;
        }
        if (this.f2621R.mo255a().equals(str)) {
            return this.f2621R;
        }
        if (this.f2616M.mo255a().equals(str)) {
            return this.f2616M;
        }
        if (this.f2617N.mo255a().equals(str)) {
            return this.f2617N;
        }
        if (this.f2618O.mo255a().equals(str)) {
            return this.f2618O;
        }
        if (this.f2647s.mo255a().equals(str)) {
            return this.f2647s;
        }
        if (this.f2648t.mo255a().equals(str)) {
            return this.f2648t;
        }
        if (this.f2649u.mo255a().equals(str)) {
            return this.f2649u;
        }
        if (this.f2650v.mo255a().equals(str)) {
            return this.f2650v;
        }
        if (this.f2651w.mo255a().equals(str)) {
            return this.f2651w;
        }
        if (this.f2652x.mo255a().equals(str)) {
            return this.f2652x;
        }
        if (this.f2646r.mo255a().equals(str)) {
            return this.f2646r;
        }
        if (this.f2653y.mo255a().equals(str)) {
            return this.f2653y;
        }
        if (this.f2654z.mo255a().equals(str)) {
            return this.f2654z;
        }
        if (this.f2609F.mo255a().equals(str)) {
            return this.f2609F;
        }
        if (this.f2622S.mo255a().equals(str)) {
            return this.f2622S;
        }
        if (this.f2623T.mo255a().equals(str)) {
            return this.f2623T;
        }
        if (this.f2624U.mo255a().equals(str)) {
            return this.f2624U;
        }
        if (this.f2615L.mo255a().equals(str)) {
            return this.f2615L;
        }
        return null;
    }

    private Integer m2888a(String str, String str2, int i) {
        RtcQuickerExperimentHelper d = m2893d(str);
        if (d != null) {
            return d.mo254a(str2, i);
        }
        return Integer.valueOf(i);
    }

    private String m2889a(String str, String str2, String str3) {
        RtcQuickerExperimentHelper d = m2893d(str);
        if (d != null) {
            return d.mo256a(str2, str3);
        }
        return str3;
    }

    public boolean getBooleanExperimentParam(String str, String str2, boolean z) {
        Config c = m2892c(str);
        if (c == null) {
            return z;
        }
        return c.a.a(str2, z);
    }

    public int getIntExperimentParam(String str, String str2, int i) {
        Integer a = m2888a(str, str2, i);
        if (a != null) {
            return a.intValue();
        }
        Config c = m2892c(str);
        if (c != null) {
            return c.a.a(str2, i);
        }
        return i;
    }

    public String getStringExperimentParam(String str, String str2, String str3) {
        String a = m2889a(str, str2, str3);
        if (a != null) {
            return a;
        }
        Config c = m2892c(str);
        if (c != null) {
            return c.a.a(str2, str3);
        }
        return str3;
    }

    private static Map<String, Integer> m2894d() {
        Map<String, Integer> hashMap = new HashMap();
        hashMap.put("rtc_enable_frame_enhancement", Integer.valueOf(1092));
        hashMap.put("rtc_force_enable_software_aec", Integer.valueOf(1095));
        hashMap.put("rtc_force_enable_software_agc", Integer.valueOf(1096));
        hashMap.put("rtc_force_disable_software_aec", Integer.valueOf(1093));
        hashMap.put("rtc_force_disable_software_agc", Integer.valueOf(1094));
        hashMap.put("rtc_push_log", Integer.valueOf(1100));
        hashMap.put("rtc_video_conference", Integer.valueOf(1105));
        hashMap.put("voip_use_jni_audio_callee_android", Integer.valueOf(1178));
        hashMap.put("voip_use_jni_audio_caller_android", Integer.valueOf(1179));
        hashMap.put("voip_webrtc_receive_lafns", Integer.valueOf(1180));
        hashMap.put("rtc_offerack_engine_send", Integer.valueOf(1099));
        hashMap.put("rtc_pushkit_no_delay", Integer.valueOf(1101));
        hashMap.put("rtc_android_video_h264_hw", Integer.valueOf(1083));
        hashMap.put("rtc_snake_engine_gk", Integer.valueOf(1102));
        return hashMap;
    }

    public boolean getGateKeeper(String str, boolean z) {
        if (this.aa.containsKey(str)) {
            return this.f2633e.a(((Integer) this.aa.get(str)).intValue(), z);
        }
        throw new IllegalArgumentException("Unknown gatekeeper: " + str);
    }

    public long getUserId() {
        UserTokenCredentials userTokenCredentials = (UserTokenCredentials) this.f2631c.get();
        if (userTokenCredentials == null) {
            return 0;
        }
        return Long.parseLong(userTokenCredentials.a);
    }

    public String getRadioTechnology() {
        String str;
        WebrtcConfigManager webrtcConfigManager = this.f2637i;
        NetworkInfo c = webrtcConfigManager.f2715a.c();
        if (c == null || !c.isConnectedOrConnecting()) {
            str = null;
        } else if (c.getType() == 1) {
            str = "WIFI";
        } else {
            str = TelephonyManagerUtils.a(webrtcConfigManager.f2717c.getNetworkType());
        }
        String str2 = str;
        if (StringUtil.a(str2)) {
            return "";
        }
        return str2;
    }

    public String getConnectivityStatus() {
        String str;
        NetworkInfo c = this.f2637i.f2715a.c();
        if (c == null || !c.isConnectedOrConnecting()) {
            str = "none";
        } else if (c.getType() == 0) {
            str = "cell";
        } else if (c.getType() == 1 || !"mobile2".equals(c.getTypeName())) {
            str = c.getTypeName();
        } else {
            str = "cell";
        }
        return str;
    }

    public int getMinVersion() {
        return this.f2637i.f2716b.a(VoipConfig.f1877d, 0);
    }

    public int getCapability() {
        Set noneOf = EnumSet.noneOf(MqttCapability.class);
        if (((Boolean) this.f2634f.get()).booleanValue()) {
            noneOf.add(MqttCapability.VOIP);
            noneOf.add(MqttCapability.VOIP_WEB);
        }
        return (int) BitmaskEnumUtil.a(noneOf);
    }

    public int getThreadPresenceCapability() {
        if (this.f2645q.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.aF, false)) {
            return ThreadPresenceCapability.THREAD_PRESENCE_CAPABILITY_INSTANT_MVP.getValue();
        }
        return 0;
    }

    public int getAckTimeout() {
        return 10000;
    }

    public int getNumberOfRetriesOnError() {
        return 0;
    }

    public int getRecordSamplesPerSec() {
        return 16000;
    }

    public String getRecordFileDir() {
        return this.f2632d.a(InternalVoipPrefKeys.f11361N, Environment.getExternalStorageDirectory().getPath());
    }

    public boolean shouldEnableStarveSmoothing() {
        return this.f2632d.a(InternalVoipPrefKeys.f11353F, false);
    }

    public boolean shouldRecordRemoteVideo() {
        return this.f2632d.a(InternalVoipPrefKeys.f11354G, false);
    }

    public boolean shouldRecordRemoteRawVideo() {
        return this.f2632d.a(InternalVoipPrefKeys.f11355H, false);
    }

    public boolean shouldRecordSelfVideo() {
        return this.f2632d.a(InternalVoipPrefKeys.f11356I, false);
    }

    public boolean shouldRecordSelfRawVideo() {
        return this.f2632d.a(InternalVoipPrefKeys.f11357J, false);
    }

    public boolean shouldLoadSelfRawVideo() {
        return this.f2632d.a(InternalVoipPrefKeys.f11358K, false);
    }

    public boolean shouldLoopVideoPlayback() {
        return this.f2632d.a(InternalVoipPrefKeys.f11359L, false);
    }

    public boolean shouldPreprocessVideoFrames() {
        return this.f2632d.a(InternalVoipPrefKeys.f11360M, false);
    }

    public boolean shouldPlaySampleInputFile() {
        return this.f2632d.a(InternalVoipPrefKeys.f11362O, false);
    }

    public int getUploadLogLevel() {
        int parseInt = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11372e, "0"));
        if (parseInt > WebRTCLogUploadLevel.None.ordinal()) {
            return parseInt;
        }
        parseInt = WebRTCLogUploadLevel.None.ordinal();
        int intValue = this.f2606C.mo254a("basic_log_permyriad", 50).intValue();
        int intValue2 = this.f2606C.mo254a("debug_pct", 0).intValue();
        if (this.f2626W.nextInt(10000) >= intValue) {
            return parseInt;
        }
        parseInt = WebRTCLogUploadLevel.Basic.ordinal();
        if (this.f2626W.nextInt(100) < intValue2) {
            return WebRTCLogUploadLevel.Debug.ordinal();
        }
        return parseInt;
    }

    public int getVoipCodecOverrideMode() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11373f, "0"));
    }

    public int getVoipCodecOverrideRate() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11374g, "-1"));
    }

    public int getIspxInitialCodec() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11377j, "-1"));
    }

    public int getOpispxInitialCodec() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11378k, "-1"));
    }

    public boolean getIspxCodecSwitchEnabled() {
        return this.f2632d.a(InternalVoipPrefKeys.f11379l, true);
    }

    public int getVoipIspxFecOverrideMode() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11380m, "-1"));
    }

    public int getVoipIspxImplementationOverride() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11381n, "-1"));
    }

    public boolean shouldEnableVideo() {
        return ((Boolean) this.f2635g.get()).booleanValue();
    }

    public boolean isInAnotherCall() {
        return (this.f2636h == null || this.f2636h.getCallState() == 0) ? false : true;
    }

    public int getAudioOutputRoute() {
        return this.f2638j.m2917c().ordinal();
    }

    public int[] getAudioOptionOverrides() {
        int[] iArr = new int[WebRTCAudioOptionName.NumTypes.ordinal()];
        iArr[WebRTCAudioOptionName.EC.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11376i, "0"));
        iArr[WebRTCAudioOptionName.AGC.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11390w, "0"));
        iArr[WebRTCAudioOptionName.HighPassFilter.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11392y, "0"));
        iArr[WebRTCAudioOptionName.CNG.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11393z, "0"));
        iArr[WebRTCAudioOptionName.ExperimentalAGC.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11348A, "0"));
        iArr[WebRTCAudioOptionName.ECMode.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11349B, "0"));
        iArr[WebRTCAudioOptionName.AGCMode.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11350C, "0"));
        iArr[WebRTCAudioOptionName.NS.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11391x, "0"));
        iArr[WebRTCAudioOptionName.NSMode.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11351D, "0"));
        iArr[WebRTCAudioOptionName.LAFNSMode.ordinal()] = Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11352E, "0"));
        return iArr;
    }

    public boolean shouldEnableAutomatedTestSupport() {
        return this.f2632d.a(InternalVoipPrefKeys.f11364Q, false);
    }

    public void webRTCControlRPC_UpdateTestAudioMode(int i) {
        if (i >= 0) {
            String a = this.f2632d.a(InternalVoipPrefKeys.f11369b, "-1");
            Editor edit = this.f2632d.edit();
            if (!a.equals("-2")) {
                edit.a(InternalVoipPrefKeys.f11370c, a);
            }
            edit.a(InternalVoipPrefKeys.f11369b, "-2");
            edit.a(InternalVoipPrefKeys.f11371d, i);
            edit.commit();
            return;
        }
        this.f2632d.edit().a(InternalVoipPrefKeys.f11369b, this.f2632d.a(InternalVoipPrefKeys.f11370c, "-1")).a(InternalVoipPrefKeys.f11370c).a(InternalVoipPrefKeys.f11371d).commit();
    }

    public int getSpeexFramesPerPacketIspx() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11382o, "-1"));
    }

    public int getIsacFramesPerPacketIspx() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11383p, "-1"));
    }

    public int getIspxMaxAggregationBweOffsetIsac() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11384q, "-1"));
    }

    public int getIspxAggregationStabilizationMsIsac() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11385r, "-1"));
    }

    public int getIsacInitialBitrate() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11386s, "-1"));
    }

    public int getSpeexInitialBitrate() {
        return Integer.parseInt(this.f2632d.a(InternalVoipPrefKeys.f11387t, "-1"));
    }

    public String getAppDataFolder() {
        return this.f2630b.getFilesDir().getPath();
    }

    public String getAppTempFolder() {
        return this.f2630b.getCacheDir().getPath();
    }

    public String getDeviceId() {
        return this.f2629Z.a();
    }

    public long getAppId() {
        return Long.parseLong(this.f2628Y.c());
    }

    public String getSslPrivateKey() {
        m2895f();
        return this.ac;
    }

    public String getSslCertificate() {
        m2895f();
        return this.ad;
    }

    private synchronized void m2895f() {
        if (StringUtil.a(this.ac) || StringUtil.a(this.ad)) {
            if (this.f2632d.a(InternalVoipPrefKeys.f11388u) && this.f2632d.a(InternalVoipPrefKeys.f11389v)) {
                String a = this.f2632d.a(InternalVoipPrefKeys.f11388u, "");
                String a2 = this.f2632d.a(InternalVoipPrefKeys.f11389v, "");
                if (Strings.isNullOrEmpty(a) || Strings.isNullOrEmpty(a2)) {
                    BLog.b(f2603a, "Failed to read either the private key or the certificate. Reconstructing.");
                } else {
                    this.ac = a;
                    this.ad = a2;
                }
            }
            String[] strArr = (String[]) Iterables.a(Splitter.on(':').trimResults().omitEmptyStrings().split(this.f2625V.makeKeyPairAndCertificate()), String.class);
            if (strArr.length != 2) {
                BLog.b(f2603a, "Failed to create and parse key pair and certificate. Defaulting to no-DTLS.");
            } else {
                this.ac = strArr[0];
                this.ad = strArr[1];
                if (!(Strings.isNullOrEmpty(this.ac) || Strings.isNullOrEmpty(this.ad))) {
                    this.f2632d.edit().a(InternalVoipPrefKeys.f11388u, this.ac).a(InternalVoipPrefKeys.f11389v, this.ad).commit();
                }
            }
        }
    }
}
