package com.facebook.analytics.util;

import android.net.NetworkInfo;
import android.os.Process;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.C0087xd695ba9d;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.device.FbTrafficStats;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: release_info */
public class AnalyticsConnectionUtils {
    private static volatile AnalyticsConnectionUtils f7645E;
    private static final PrefKey f7646a;
    private static final PrefKey f7647b;
    private static final PrefKey f7648c = ((PrefKey) f7646a.m2011a("total_mqtt_bytes_received_background"));
    private static final PrefKey f7649d = ((PrefKey) f7646a.m2011a("total_mqtt_bytes_sent_foreground"));
    private static final PrefKey f7650e = ((PrefKey) f7646a.m2011a("total_mqtt_bytes_sent_background"));
    private static final PrefKey f7651f = ((PrefKey) f7646a.m2011a("total_bytes_received_foreground"));
    private static final PrefKey f7652g = ((PrefKey) f7646a.m2011a("total_bytes_received_background"));
    private static final PrefKey f7653h = ((PrefKey) f7646a.m2011a("total_bytes_sent_foreground"));
    private static final PrefKey f7654i = ((PrefKey) f7646a.m2011a("total_bytes_sent_background"));
    private static final PrefKey f7655j = ((PrefKey) f7646a.m2011a("last_data_usage_fetch_time_ms"));
    private long f7656A;
    private long f7657B;
    private long f7658C;
    private long f7659D;
    private final FbNetworkManager f7660k;
    private final Lazy<DataUsageCounters> f7661l;
    private final Lazy<FbTrafficStats> f7662m;
    private final FbSharedPreferences f7663n;
    private final MonotonicClock f7664o;
    private long f7665p;
    private long f7666q;
    private long f7667r;
    private long f7668s;
    private long f7669t;
    private long f7670u;
    private long f7671v;
    private long f7672w;
    private long f7673x;
    private long f7674y;
    private long f7675z;

    /* compiled from: release_info */
    class C03231 implements Runnable {
        final /* synthetic */ AnalyticsConnectionUtils f7676a;

        C03231(AnalyticsConnectionUtils analyticsConnectionUtils) {
            this.f7676a = analyticsConnectionUtils;
        }

        public void run() {
            TracerDetour.a("AnalyticsConnectionUtils#readCurrentTrafficStats", 785690806);
            try {
                AnalyticsConnectionUtils.m12212a(this.f7676a);
            } finally {
                TracerDetour.a(685980304);
            }
        }
    }

    public static com.facebook.analytics.util.AnalyticsConnectionUtils m12210a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7645E;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.util.AnalyticsConnectionUtils.class;
        monitor-enter(r1);
        r0 = f7645E;	 Catch:{ all -> 0x003a }
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
        r0 = m12215b(r0);	 Catch:{ all -> 0x0035 }
        f7645E = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7645E;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.util.AnalyticsConnectionUtils.a(com.facebook.inject.InjectorLike):com.facebook.analytics.util.AnalyticsConnectionUtils");
    }

    private static AnalyticsConnectionUtils m12215b(InjectorLike injectorLike) {
        return new AnalyticsConnectionUtils(FbNetworkManager.m3811a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 129), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1053), C0087xd695ba9d.m2486a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("data_analytics");
        f7646a = prefKey;
        f7647b = (PrefKey) prefKey.m2011a("total_mqtt_bytes_received_foreground");
    }

    @Inject
    public AnalyticsConnectionUtils(FbNetworkManager fbNetworkManager, Lazy<DataUsageCounters> lazy, Lazy<FbTrafficStats> lazy2, ExecutorService executorService, FbSharedPreferences fbSharedPreferences, MonotonicClock monotonicClock) {
        this.f7660k = fbNetworkManager;
        this.f7661l = lazy;
        this.f7662m = lazy2;
        this.f7663n = fbSharedPreferences;
        this.f7664o = monotonicClock;
        ExecutorDetour.a(executorService, new C03231(this), -603329492);
    }

    public final void m12218a(HoneyClientEvent honeyClientEvent) {
        m12211a(honeyClientEvent, "", this.f7660k.m3833i());
    }

    public final void m12219a(HoneyClientEvent honeyClientEvent, NetworkInfo networkInfo) {
        m12211a(honeyClientEvent, "previous_", networkInfo);
    }

    private void m12211a(HoneyClientEvent honeyClientEvent, String str, NetworkInfo networkInfo) {
        if (networkInfo != null) {
            String typeName = networkInfo.getTypeName();
            String str2 = str + "connection";
            if (StringUtil.m3589a((CharSequence) typeName)) {
                typeName = "none";
            }
            honeyClientEvent.m5090b(str2, typeName);
            CharSequence subtypeName = networkInfo.getSubtypeName();
            if (StringUtil.m3589a(subtypeName) && networkInfo.getType() == 1 && this.f7660k.m3832h()) {
                subtypeName = "HOTSPOT";
            }
            if (!StringUtil.m3589a(subtypeName)) {
                honeyClientEvent.m5090b(str + "connection_subtype", subtypeName);
            }
        }
    }

    public final synchronized void m12220b(HoneyClientEvent honeyClientEvent) {
        m12216b();
        ((DataUsageCounters) this.f7661l.get()).mo2005a(honeyClientEvent);
        m12218a(honeyClientEvent);
    }

    public final synchronized void m12221c(HoneyClientEvent honeyClientEvent) {
        m12216b();
        m12217c();
        ((DataUsageCounters) this.f7661l.get()).mo2005a(honeyClientEvent);
        m12218a(honeyClientEvent);
    }

    public static void m12212a(AnalyticsConnectionUtils analyticsConnectionUtils) {
        FbTrafficStats fbTrafficStats = (FbTrafficStats) analyticsConnectionUtils.f7662m.get();
        if (fbTrafficStats.f5366a) {
            int myUid = Process.myUid();
            DataUsageBytes a = fbTrafficStats.m9239a(myUid, 0);
            DataUsageBytes b = fbTrafficStats.m9240b(myUid, 8888);
            DataUsageBytes c = fbTrafficStats.m9241c(myUid, 8888);
            DataUsageBytes b2 = fbTrafficStats.m9240b(myUid, 0);
            DataUsageBytes c2 = fbTrafficStats.m9241c(myUid, 0);
            analyticsConnectionUtils.f7665p = a.f5370b;
            analyticsConnectionUtils.f7666q = a.f5371c;
            analyticsConnectionUtils.f7672w = c.f5370b;
            analyticsConnectionUtils.f7671v = b.f5370b;
            analyticsConnectionUtils.f7674y = c.f5371c;
            analyticsConnectionUtils.f7673x = b.f5371c;
            analyticsConnectionUtils.f7656A = c2.f5370b;
            analyticsConnectionUtils.f7675z = b2.f5370b;
            analyticsConnectionUtils.f7658C = c2.f5371c;
            analyticsConnectionUtils.f7657B = b2.f5371c;
            analyticsConnectionUtils.f7667r = FbTrafficStats.m9232b();
            analyticsConnectionUtils.f7668s = FbTrafficStats.m9235c();
            analyticsConnectionUtils.f7669t = FbTrafficStats.m9236d();
            analyticsConnectionUtils.f7670u = FbTrafficStats.m9237e();
        }
    }

    private synchronized void m12216b() {
        long j = this.f7665p;
        long j2 = this.f7666q;
        long j3 = this.f7667r;
        long j4 = this.f7668s;
        long j5 = this.f7669t;
        long j6 = this.f7670u;
        m12212a(this);
        m12213a("total_bytes_received", this.f7665p, j);
        m12213a("total_bytes_sent", this.f7666q, j2);
        m12213a("total_device_bytes_received", this.f7667r, j3);
        m12213a("total_device_bytes_sent", this.f7668s, j4);
        m12213a("total_mobile_bytes_received", this.f7669t, j5);
        m12213a("total_mobile_bytes_sent", this.f7670u, j6);
        DataUsageCounters dataUsageCounters = (DataUsageCounters) this.f7661l.get();
        dataUsageCounters.m2592b("device_bytes_received_since_boot", this.f7667r);
        dataUsageCounters.m2592b("device_bytes_sent_since_boot", this.f7668s);
        dataUsageCounters.m2592b("mobile_device_bytes_received_since_boot", this.f7669t);
        dataUsageCounters.m2592b("mobile_device_bytes_sent_since_boot", this.f7670u);
        dataUsageCounters.m2592b("app_bytes_received_since_boot", this.f7665p);
        dataUsageCounters.m2592b("app_bytes_sent_since_boot", this.f7666q);
    }

    private void m12213a(String str, long j, long j2) {
        m12214a(str, j, j2, 1);
    }

    private void m12214a(String str, long j, long j2, long j3) {
        long j4;
        long j5 = (j - j2) / j3;
        if (j < 0 || j5 < 0 || j5 > 524288000) {
            j4 = -1;
        } else {
            j4 = j5;
        }
        ((DataUsageCounters) this.f7661l.get()).m2592b(str, j4);
    }

    private void m12217c() {
        long a = this.f7663n.mo277a(f7651f, 0);
        long a2 = this.f7663n.mo277a(f7652g, 0);
        long a3 = this.f7663n.mo277a(f7653h, 0);
        long a4 = this.f7663n.mo277a(f7654i, 0);
        long a5 = this.f7663n.mo277a(f7647b, 0);
        long a6 = this.f7663n.mo277a(f7648c, 0);
        long a7 = this.f7663n.mo277a(f7649d, 0);
        long a8 = this.f7663n.mo277a(f7650e, 0);
        long a9 = this.f7663n.mo277a(f7655j, 0);
        this.f7659D = this.f7664o.now();
        long j = (this.f7659D - a9) / 3600000;
        if (j == 0) {
            j = 1;
        }
        m12214a("total_mqtt_bytes_received_foreground", this.f7671v, a5, j);
        m12214a("total_mqtt_bytes_received_background", this.f7672w, a6, j);
        m12214a("total_mqtt_bytes_sent_foreground", this.f7673x, a7, j);
        m12214a("total_mqtt_bytes_sent_background", this.f7674y, a8, j);
        m12214a("total_bytes_received_foreground", this.f7675z, a, j);
        m12214a("total_bytes_received_background", this.f7656A, a2, j);
        m12214a("total_bytes_sent_foreground", this.f7657B, a3, j);
        m12214a("total_bytes_sent_background", this.f7658C, a4, j);
        this.f7663n.edit().mo1275a(f7651f, this.f7675z).mo1275a(f7652g, this.f7656A).mo1275a(f7653h, this.f7657B).mo1275a(f7654i, this.f7658C).mo1275a(f7647b, this.f7671v).mo1275a(f7648c, this.f7672w).mo1275a(f7649d, this.f7673x).mo1275a(f7650e, this.f7674y).mo1275a(f7655j, this.f7659D).commit();
    }
}
