package com.facebook.video.settings;

import android.net.NetworkInfo;
import android.os.PowerManager;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.common.hardware.BatteryStateManager;
import com.facebook.common.hardware.BatteryStateManager$ChargeState;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.exoserviceclient.ExoServiceClient;
import com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_indexed */
public class VideoAutoPlaySettingsChecker {
    private static final String f19134e = VideoAutoPlaySettingsChecker.class.getName();
    private static volatile VideoAutoPlaySettingsChecker f19135v;
    public FbSharedPreferences f19136a;
    public AutoPlaySettingValue f19137b;
    protected long f19138c;
    public VideoAutoplaySettingsServerMigrationHelper f19139d;
    public ZeroDialogController f19140f;
    private OnSharedPreferenceChangeListener f19141g;
    public FbNetworkManager f19142h;
    public FbDataConnectionManager f19143i;
    public DeviceConditionHelper f19144j;
    public NetworkInfo f19145k = this.f19142h.m3827b();
    private final QeAccessor f19146l;
    public Provider<Boolean> f19147m;
    public AutoPlaySettingValue f19148n;
    public final SystemBatteryStateManager f19149o;
    public final PowerManager f19150p;
    private final MonotonicClock f19151q;
    public Video360PlayerConfig f19152r;
    private APSettingCheckerParams f19153s;
    public ExoServiceClient f19154t;
    public DataSensitivitySettingsPrefUtil f19155u;

    /* compiled from: is_indexed */
    public class APSettingCheckerParams {
        public final ConnectionQuality f19173a;
        public final long f19174b;

        public APSettingCheckerParams(ConnectionQuality connectionQuality, long j) {
            this.f19173a = connectionQuality;
            this.f19174b = j;
        }
    }

    /* compiled from: is_indexed */
    class C07601 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ VideoAutoPlaySettingsChecker f19176a;

        C07601(VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker) {
            this.f19176a = videoAutoPlaySettingsChecker;
        }

        public final void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker = this.f19176a;
            VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker2 = this.f19176a;
            videoAutoPlaySettingsChecker.f19137b = AutoPlaySettingValue.valueOf(VideoAutoPlayListPreferenceSettings.m26901a(videoAutoPlaySettingsChecker2.f19148n, videoAutoPlaySettingsChecker2.f19136a));
        }
    }

    /* compiled from: is_indexed */
    public /* synthetic */ class C07612 {
        public static final /* synthetic */ int[] f19188a = new int[BatteryStateManager$ChargeState.values().length];

        static {
            try {
                f19188a[BatteryStateManager$ChargeState.CHARGING_AC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19188a[BatteryStateManager$ChargeState.CHARGING_USB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19188a[BatteryStateManager$ChargeState.CHARGING_WIRELESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19188a[BatteryStateManager$ChargeState.FULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static com.facebook.video.settings.VideoAutoPlaySettingsChecker m26868a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19135v;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.settings.VideoAutoPlaySettingsChecker.class;
        monitor-enter(r1);
        r0 = f19135v;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m26869b(r0);	 Catch:{ all -> 0x0035 }
        f19135v = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19135v;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.settings.VideoAutoPlaySettingsChecker.a(com.facebook.inject.InjectorLike):com.facebook.video.settings.VideoAutoPlaySettingsChecker");
    }

    private static VideoAutoPlaySettingsChecker m26869b(InjectorLike injectorLike) {
        return new VideoAutoPlaySettingsChecker(FbSharedPreferencesImpl.m1826a(injectorLike), FbZeroDialogController.m8470a(injectorLike), FbNetworkManager.m3811a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), DeviceConditionHelper.m5526a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3959), C0759x3db8deda.m26896a(injectorLike), VideoAutoplaySettingsServerMigrationHelper.m26889a(injectorLike), SystemBatteryStateManager.m11461a(injectorLike), PowerManagerMethodAutoProvider.m5524a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), Video360PlayerConfig.m26760a(injectorLike), ExoServiceClientMethodAutoProvider.m14000a(injectorLike), VideoLivePlaybackConfig.m14002a(injectorLike), DataSensitivitySettingsPrefUtil.m8604a(injectorLike));
    }

    @Inject
    public VideoAutoPlaySettingsChecker(FbSharedPreferences fbSharedPreferences, ZeroDialogController zeroDialogController, FbNetworkManager fbNetworkManager, FbDataConnectionManager fbDataConnectionManager, DeviceConditionHelper deviceConditionHelper, QeAccessor qeAccessor, Provider<Boolean> provider, AutoPlaySettingValue autoPlaySettingValue, VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper, BatteryStateManager batteryStateManager, PowerManager powerManager, MonotonicClock monotonicClock, Video360PlayerConfig video360PlayerConfig, ExoServiceClient exoServiceClient, VideoLivePlaybackConfig videoLivePlaybackConfig, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil) {
        this.f19136a = fbSharedPreferences;
        this.f19140f = zeroDialogController;
        this.f19142h = fbNetworkManager;
        this.f19143i = fbDataConnectionManager;
        this.f19144j = deviceConditionHelper;
        this.f19146l = qeAccessor;
        this.f19147m = provider;
        this.f19148n = autoPlaySettingValue;
        this.f19139d = videoAutoplaySettingsServerMigrationHelper;
        this.f19149o = batteryStateManager;
        this.f19150p = powerManager;
        this.f19151q = monotonicClock;
        this.f19152r = video360PlayerConfig;
        this.f19153s = new APSettingCheckerParams(ConnectionQuality.MODERATE, videoLivePlaybackConfig.f9122Z);
        this.f19154t = exoServiceClient;
        this.f19155u = dataSensitivitySettingsPrefUtil;
        m26870d();
    }

    private void m26870d() {
        m26874b();
        this.f19141g = new C07601(this);
        this.f19136a.mo279a(VideoPrefs.f19183g, this.f19141g);
    }

    public final boolean m26871a() {
        return m26872a(null);
    }

    public final boolean m26872a(@Nullable Set<AutoPlayFailureReason> set) {
        return m26873a(set, this.f19153s);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m26873a(@javax.annotation.Nullable java.util.Set<com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason> r9, com.facebook.video.settings.VideoAutoPlaySettingsChecker.APSettingCheckerParams r10) {
        /*
        r8 = this;
        r0 = 0;
        r1 = r8.m26874b();
        r2 = com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue.OFF;
        if (r1 != r2) goto L_0x0011;
    L_0x0009:
        if (r9 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r1 = com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason.DISABLED_BY_AUTOPLAY_SETTING;
        r9.add(r1);
    L_0x0011:
        r4 = r8.f19140f;
        r5 = com.facebook.zero.sdk.common.ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL;
        r4 = r4.m8437a(r5);
        if (r4 != 0) goto L_0x0029;
    L_0x001b:
        r4 = r8.f19147m;
        r4 = r4.get();
        r4 = (java.lang.Boolean) r4;
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x0101;
    L_0x0029:
        r4 = 1;
    L_0x002a:
        r1 = r4;
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        if (r9 == 0) goto L_0x000b;
    L_0x002f:
        r1 = com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason.DISABLED_BY_ZERORATING;
        r9.add(r1);
    L_0x0034:
        r4 = r8.f19155u;
        r5 = 0;
        r4 = r4.m8609b(r5);
        r1 = r4;
        if (r1 == 0) goto L_0x0045;
    L_0x003e:
        if (r9 == 0) goto L_0x000b;
    L_0x0040:
        r1 = com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason.DISABLED_BY_DATA_SAVINGS_MODE;
        r9.add(r1);
    L_0x0045:
        r4 = r8.f19137b;
        r4 = r4.isWifiOnly();
        if (r4 == 0) goto L_0x0104;
    L_0x004d:
        r5 = r8.f19144j;
        r5 = r5.m5534b();
        if (r5 == 0) goto L_0x005d;
    L_0x0055:
        r5 = r8.f19142h;
        r5 = r5.m3832h();
        if (r5 == 0) goto L_0x0107;
    L_0x005d:
        r5 = 1;
    L_0x005e:
        r4 = r5;
        if (r4 == 0) goto L_0x0104;
    L_0x0061:
        r4 = 1;
    L_0x0062:
        r1 = r4;
        if (r1 == 0) goto L_0x006c;
    L_0x0065:
        if (r9 == 0) goto L_0x000b;
    L_0x0067:
        r1 = com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason.DISABLED_BY_METERED_NETWORK;
        r9.add(r1);
    L_0x006c:
        r4 = r8.f19145k;
        if (r4 == 0) goto L_0x010a;
    L_0x0070:
        r4 = r8.f19145k;
        r4 = r4.isRoaming();
        if (r4 == 0) goto L_0x010a;
    L_0x0078:
        r4 = 1;
    L_0x0079:
        r1 = r4;
        if (r1 != 0) goto L_0x00af;
    L_0x007c:
        r1 = r10.f19173a;
        r2 = r10.f19174b;
        r4 = 1;
        r5 = r8.f19143i;
        r5 = r5.m3801c();
        r5 = r5.compareTo(r1);
        if (r5 >= 0) goto L_0x00ac;
    L_0x008d:
        r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x010d;
    L_0x0096:
        r5 = r8.f19154t;
        r6 = r5.m14065c();
        r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r5 <= 0) goto L_0x010d;
    L_0x00a0:
        r5 = r8.f19143i;
        r5 = r5.m3801c();
        r5.toString();
        java.lang.Long.valueOf(r6);
    L_0x00ac:
        r1 = r4;
        if (r1 != 0) goto L_0x00b6;
    L_0x00af:
        if (r9 == 0) goto L_0x000b;
    L_0x00b1:
        r1 = com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason.DISABLED_BY_CONNECTION;
        r9.add(r1);
    L_0x00b6:
        r4 = r8.f19149o;
        r5 = 20;
        r4 = r4.m11467a(r5);
        r1 = r4;
        if (r1 == 0) goto L_0x00dd;
    L_0x00c1:
        r4 = r8.f19149o;
        r4 = r4.m11468b();
        r5 = com.facebook.video.settings.VideoAutoPlaySettingsChecker.C07612.f19188a;
        r4 = r4.ordinal();
        r4 = r5[r4];
        switch(r4) {
            case 1: goto L_0x010f;
            case 2: goto L_0x010f;
            case 3: goto L_0x010f;
            case 4: goto L_0x010f;
            default: goto L_0x00d2;
        };
    L_0x00d2:
        r4 = 0;
    L_0x00d3:
        r1 = r4;
        if (r1 != 0) goto L_0x00dd;
    L_0x00d6:
        if (r9 == 0) goto L_0x000b;
    L_0x00d8:
        r1 = com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason.DISABLED_BY_LOW_BATTERY;
        r9.add(r1);
    L_0x00dd:
        r4 = android.os.Build.VERSION.SDK_INT;
        r5 = 21;
        if (r4 < r5) goto L_0x0112;
    L_0x00e3:
        r4 = r8.f19150p;
        r4 = r4.isPowerSaveMode();
        if (r4 == 0) goto L_0x0112;
    L_0x00eb:
        r4 = 1;
    L_0x00ec:
        r1 = r4;
        if (r1 == 0) goto L_0x00f6;
    L_0x00ef:
        if (r9 == 0) goto L_0x000b;
    L_0x00f1:
        r0 = com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason.DISABLED_BY_POWER_SAVING;
        r9.add(r0);
    L_0x00f6:
        if (r9 == 0) goto L_0x00fe;
    L_0x00f8:
        r0 = r9.isEmpty();
        goto L_0x000b;
    L_0x00fe:
        r0 = 1;
        goto L_0x000b;
    L_0x0101:
        r4 = 0;
        goto L_0x002a;
    L_0x0104:
        r4 = 0;
        goto L_0x0062;
    L_0x0107:
        r5 = 0;
        goto L_0x005e;
    L_0x010a:
        r4 = 0;
        goto L_0x0079;
    L_0x010d:
        r4 = 0;
        goto L_0x00ac;
    L_0x010f:
        r4 = 1;
        goto L_0x00d3;
    L_0x0112:
        r4 = 0;
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.settings.VideoAutoPlaySettingsChecker.a(java.util.Set, com.facebook.video.settings.VideoAutoPlaySettingsChecker$APSettingCheckerParams):boolean");
    }

    public final AutoPlaySettingValue m26874b() {
        long now = this.f19151q.now();
        if (this.f19137b == null || now - this.f19138c > 86400000) {
            this.f19137b = this.f19139d.m26892a(this.f19148n, this.f19136a);
            this.f19138c = now;
        }
        return this.f19137b;
    }

    public final String m26875c() {
        return m26874b().toString().toLowerCase(Locale.ENGLISH);
    }
}
