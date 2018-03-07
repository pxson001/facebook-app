package com.facebook.analytics.analyticsmodule;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.facebook.analytics.CpuAnalytics;
import com.facebook.analytics.CpuTimeGetter;
import com.facebook.analytics.CpuUsageData;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.ILegacyPeriodicEventReporter;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.analytics.util.AnalyticsConnectionUtils;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.battery.BatteryUsageManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.hardware.BatteryStateManager;
import com.facebook.common.hardware.BatteryUsageInfo;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.util.TriState;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.debug.log.LogAnalyticsData;
import com.facebook.debug.log.LogAnalyticsManager;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_from_insta */
public class BatteryStatusPeriodicReporter implements ILegacyPeriodicEventReporter {
    private static final Class<?> f4008a = BatteryStatusPeriodicReporter.class;
    private static volatile BatteryStatusPeriodicReporter f4009r;
    public final FbSharedPreferences f4010b;
    public final AppStateManager f4011c;
    public final BatteryDrainAnalyzer f4012d;
    private final BatteryUsageManager f4013e;
    private final AnalyticsConnectionUtils f4014f;
    private final SystemBatteryStateManager f4015g;
    public final Provider<TriState> f4016h;
    public long f4017i = 0;
    private final FbWakeLockManager f4018j;
    private final BaseFbBroadcastManager f4019k;
    public final CpuAnalytics f4020l;
    private final ActionReceiver f4021m;
    private final ActionReceiver f4022n;
    private final LogAnalyticsManager f4023o;
    private final GatekeeperStoreImpl f4024p;
    private Map<String, Double> f4025q;

    /* compiled from: send_from_insta */
    class C03601 implements ActionReceiver {
        final /* synthetic */ BatteryStatusPeriodicReporter f4006a;

        C03601(BatteryStatusPeriodicReporter batteryStatusPeriodicReporter) {
            this.f4006a = batteryStatusPeriodicReporter;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -675954000);
            BatteryStatusPeriodicReporter.m3906c(this.f4006a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 700832955, a);
        }
    }

    /* compiled from: send_from_insta */
    class C03612 implements ActionReceiver {
        final /* synthetic */ BatteryStatusPeriodicReporter f4007a;

        C03612(BatteryStatusPeriodicReporter batteryStatusPeriodicReporter) {
            this.f4007a = batteryStatusPeriodicReporter;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1184872770);
            BatteryStatusPeriodicReporter batteryStatusPeriodicReporter = this.f4007a;
            CpuAnalytics cpuAnalytics = batteryStatusPeriodicReporter.f4020l;
            if (cpuAnalytics.f != TriState.YES) {
                CpuUsageData a2 = CpuTimeGetter.a();
                if (a2 != null) {
                    cpuAnalytics.d = a2.a;
                    cpuAnalytics.e = a2.b;
                }
            }
            cpuAnalytics.f = TriState.YES;
            batteryStatusPeriodicReporter.f4012d.m3898b();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 76287835, a);
        }
    }

    public static com.facebook.analytics.analyticsmodule.BatteryStatusPeriodicReporter m3900a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4009r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.analyticsmodule.BatteryStatusPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f4009r;	 Catch:{ all -> 0x003a }
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
        r0 = m3904b(r0);	 Catch:{ all -> 0x0035 }
        f4009r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4009r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.analyticsmodule.BatteryStatusPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.analyticsmodule.BatteryStatusPeriodicReporter");
    }

    private static BatteryStatusPeriodicReporter m3904b(InjectorLike injectorLike) {
        return new BatteryStatusPeriodicReporter((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AppStateManager.a(injectorLike), BatteryDrainAnalyzer.m3891a(injectorLike), BatteryUsageManager.a(injectorLike), AnalyticsConnectionUtils.a(injectorLike), SystemBatteryStateManager.a(injectorLike), IdBasedProvider.a(injectorLike, 631), FbWakeLockManager.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    private HoneyClientEvent m3901a(HoneyClientEvent honeyClientEvent, long j) {
        honeyClientEvent.e = j;
        if ((this.f4016h.get() == TriState.YES ? 1 : null) != null) {
            if (VERSION.SDK_INT >= 19) {
                honeyClientEvent.a("detailed_battery_v2", m3907f());
            } else {
                BatteryUsageInfo a = this.f4013e.a();
                if (a != null) {
                    honeyClientEvent.a("detailed_battery", a.a);
                }
            }
            this.f4014f.a(honeyClientEvent);
            honeyClientEvent.a("battery", (double) this.f4015g.a());
            honeyClientEvent.b("charge_state", this.f4015g.b().toString().toLowerCase(Locale.US));
            honeyClientEvent.b("battery_health", this.f4015g.c().toString().toLowerCase(Locale.US));
            m3905b(honeyClientEvent);
            honeyClientEvent.a("app_in_foreground", this.f4011c.l());
            m3903a(honeyClientEvent);
        }
        return honeyClientEvent;
    }

    @Inject
    public BatteryStatusPeriodicReporter(FbSharedPreferences fbSharedPreferences, AppStateManager appStateManager, BatteryDrainAnalyzer batteryDrainAnalyzer, BatteryUsageManager batteryUsageManager, AnalyticsConnectionUtils analyticsConnectionUtils, BatteryStateManager batteryStateManager, Provider<TriState> provider, FbWakeLockManager fbWakeLockManager, FbBroadcastManager fbBroadcastManager, GatekeeperStore gatekeeperStore) {
        this.f4010b = fbSharedPreferences;
        this.f4011c = appStateManager;
        this.f4012d = batteryDrainAnalyzer;
        this.f4013e = batteryUsageManager;
        this.f4014f = analyticsConnectionUtils;
        this.f4015g = batteryStateManager;
        this.f4016h = provider;
        this.f4019k = fbBroadcastManager;
        this.f4018j = fbWakeLockManager;
        this.f4023o = LogAnalyticsManager.b;
        this.f4024p = gatekeeperStore;
        this.f4020l = new CpuAnalytics();
        this.f4025q = new HashMap();
        this.f4021m = new C03601(this);
        this.f4022n = new C03612(this);
        this.f4019k.a().a(AppStateManager.b, this.f4021m).a().b();
        this.f4019k.a().a(AppStateManager.c, this.f4022n).a().b();
        if (this.f4011c.l()) {
            this.f4012d.m3897a();
        }
    }

    public static void m3906c(BatteryStatusPeriodicReporter batteryStatusPeriodicReporter) {
        CpuAnalytics cpuAnalytics = batteryStatusPeriodicReporter.f4020l;
        if (cpuAnalytics.f != TriState.NO) {
            CpuUsageData a = CpuTimeGetter.a();
            if (a != null) {
                cpuAnalytics.b += a.a - cpuAnalytics.d;
                cpuAnalytics.c = (a.b - cpuAnalytics.e) + cpuAnalytics.c;
            }
        }
        cpuAnalytics.f = TriState.NO;
        batteryStatusPeriodicReporter.f4012d.m3897a();
    }

    public final HoneyAnalyticsEvent m3909a(long j, String str) {
        return m3899a(j);
    }

    private HoneyAnalyticsEvent m3899a(long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("battery_status");
        m3901a(honeyClientEvent, j);
        honeyClientEvent.c = "device";
        return honeyClientEvent;
    }

    private void m3903a(HoneyClientEvent honeyClientEvent) {
        List<LogAnalyticsData> b = this.f4023o.b();
        if (b != null && this.f4024p.a(256, false)) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            for (LogAnalyticsData logAnalyticsData : b) {
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                objectNode.a("log_count", logAnalyticsData.c);
                objectNode.a("clienttime_ms", logAnalyticsData.f);
                if (logAnalyticsData.d != null) {
                    objectNode.a("message", logAnalyticsData.d);
                }
                if (logAnalyticsData.e != null) {
                    objectNode.a("throwable", logAnalyticsData.e);
                }
                arrayNode.a(objectNode);
            }
            honeyClientEvent.a("log_analytics", arrayNode);
        }
    }

    private synchronized ObjectNode m3907f() {
        ObjectNode objectNode;
        objectNode = new ObjectNode(JsonNodeFactory.a);
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
        for (WakeLock wakeLock : this.f4018j.a().values()) {
            if (wakeLock.j() > 0) {
                ObjectNode a = m3902a(wakeLock);
                if (wakeLock.e()) {
                    arrayNode2.a(a);
                } else {
                    arrayNode.a(a);
                }
            }
        }
        objectNode.c("held_wakelock_details", arrayNode2);
        objectNode.c("unheld_wakelock_details", arrayNode);
        objectNode.a("disposed_wakelock_held_ms", this.f4018j.c());
        objectNode.a("disposed_wakelock_count", this.f4018j.b());
        return objectNode;
    }

    private static ObjectNode m3902a(WakeLock wakeLock) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("tag", wakeLock.d);
        objectNode.a("held_time_ms", wakeLock.i());
        objectNode.a("count", Long.valueOf((long) wakeLock.j()));
        objectNode.a("flags", wakeLock.g);
        objectNode.a("is_ref_counted", wakeLock.f());
        if (!wakeLock.b().isEmpty()) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            for (Entry entry : wakeLock.b().entrySet()) {
                objectNode2.a((String) entry.getKey(), (Long) entry.getValue());
            }
            objectNode.c("extra", objectNode2);
        }
        return objectNode;
    }

    public final long m3908a() {
        if (this.f4017i == 0) {
            this.f4017i = this.f4010b.a(AnalyticsPrefKeys.f, this.f4011c.l() ? 300000 : 1800000);
        }
        return this.f4017i;
    }

    private void m3905b(HoneyClientEvent honeyClientEvent) {
        CpuAnalytics cpuAnalytics = this.f4020l;
        boolean l = this.f4011c.l();
        Map map = this.f4025q;
        Object obj = null;
        CpuUsageData a = CpuTimeGetter.a();
        if (a == null) {
            BLog.a(CpuAnalytics.a, "Failed to get cpu time data since it is unavailable");
        } else if (map == null) {
            BLog.a(CpuAnalytics.a, "Input cpu data map is null");
        } else {
            double d;
            double d2;
            if (l) {
                d = cpuAnalytics.b;
                d2 = cpuAnalytics.c;
            } else {
                d = cpuAnalytics.b + (a.a - cpuAnalytics.d);
                d2 = (a.b - cpuAnalytics.e) + cpuAnalytics.c;
            }
            map.put("TOTAL_USER_CPU_TIME", Double.valueOf(a.a));
            map.put("TOTAL_SYS_CPU_TIME", Double.valueOf(a.b));
            map.put("BG_USER_CPU_TIME", Double.valueOf(d));
            map.put("BG_SYS_CPU_TIME", Double.valueOf(d2));
            obj = 1;
        }
        if (obj != null) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            arrayNode.a((Double) this.f4025q.get("TOTAL_SYS_CPU_TIME"));
            arrayNode.a((Double) this.f4025q.get("TOTAL_USER_CPU_TIME"));
            objectNode.c("total_cpu_time_sec", arrayNode);
            arrayNode = new ArrayNode(JsonNodeFactory.a);
            arrayNode.a((Double) this.f4025q.get("BG_SYS_CPU_TIME"));
            arrayNode.a((Double) this.f4025q.get("BG_USER_CPU_TIME"));
            objectNode.c("total_cpu_bg_time_sec", arrayNode);
            honeyClientEvent.a("cpu_time", objectNode);
        }
    }
}
