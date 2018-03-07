package com.facebook.analytics.powermetrics;

import com.facebook.analytics.CpuTimeGetter;
import com.facebook.analytics.CpuUsageData;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.init.INeedInit;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.location.LocationStats;
import com.facebook.location.LocationStats.LocationTime;
import com.facebook.rti.shared.mqttstats.MqttTrafficStats;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: messenger_been_sms_default_app */
public class PowerMetricsController implements INeedInit {
    private static final Class<?> f8051c = PowerMetricsController.class;
    CpuUsageData f8052a;
    public float f8053b;
    public final GatekeeperStoreImpl f8054d;
    public final LocalStatsLoggerImpl f8055e;
    public final SystemBatteryStateManager f8056f;
    private final FbWakeLockManager f8057g;
    public boolean f8058h = false;
    private Map<String, WakeLock> f8059i;
    private long f8060j;

    public static PowerMetricsController m8343b(InjectorLike injectorLike) {
        return new PowerMetricsController(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), SystemBatteryStateManager.a(injectorLike), FbWakeLockManager.a(injectorLike));
    }

    protected final void m8345c() {
        MqttTrafficStats mqttTrafficStats = MqttTrafficStats.a;
        this.f8055e.a(7208965, mqttTrafficStats.c.getAndSet(0));
        this.f8055e.a(7208966, mqttTrafficStats.b.getAndSet(0));
        this.f8055e.a(7208967, mqttTrafficStats.d.getAndSet(0));
        this.f8055e.a(7208968, mqttTrafficStats.e.getAndSet(0));
    }

    @Inject
    public PowerMetricsController(GatekeeperStoreImpl gatekeeperStoreImpl, LocalStatsLoggerImpl localStatsLoggerImpl, SystemBatteryStateManager systemBatteryStateManager, FbWakeLockManager fbWakeLockManager) {
        this.f8054d = gatekeeperStoreImpl;
        this.f8055e = localStatsLoggerImpl;
        this.f8056f = systemBatteryStateManager;
        this.f8057g = fbWakeLockManager;
        this.f8052a = new CpuUsageData(0.0d, 0.0d, 0.0d, 0.0d);
        this.f8060j = 0;
    }

    public void init() {
        if (this.f8054d.a(1058, false)) {
            this.f8055e.a(new 1(this));
            this.f8058h = false;
            this.f8053b = this.f8056f.a();
            this.f8056f.a(new 2(this));
        }
    }

    protected final void m8344a() {
        CpuUsageData a = CpuTimeGetter.a();
        if (a != null) {
            double a2 = a.m8348a() - this.f8052a.m8348a();
            double b = a.m8349b() - this.f8052a.m8349b();
            double d = a.m8351d() - this.f8052a.m8351d();
            double e = a.m8352e() - this.f8052a.m8352e();
            this.f8055e.a(7208961, (long) a2);
            this.f8055e.a(7208962, (long) b);
            this.f8055e.a(7208963, (long) (a2 + b));
            this.f8052a = a;
            this.f8055e.a(7208986, (long) d);
            this.f8055e.a(7208987, (long) e);
            this.f8055e.a(7208988, (long) (d + e));
            this.f8052a = a;
        }
    }

    protected final void m8346d() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        Map a = this.f8057g.a();
        long j = 0;
        long j2 = 0;
        for (WakeLock wakeLock : a.values()) {
            long i;
            long j3;
            WakeLock a2 = m8341a(wakeLock.a());
            if (a2 != null) {
                i = wakeLock.i() - a2.i();
                j3 = (long) (wakeLock.j() - a2.j());
            } else {
                i = wakeLock.i();
                j3 = (long) wakeLock.j();
            }
            if (i > 0) {
                arrayNode.a(m8342a(wakeLock, i, j3));
            }
            j2 += i;
            j += j3;
        }
        this.f8055e.a(7208979, j);
        this.f8055e.a(7208978, j2);
        this.f8055e.a(7208980, arrayNode.toString());
        this.f8059i = a;
        long c = this.f8057g.c();
        this.f8055e.a(7208981, c - this.f8060j);
        this.f8060j = c;
    }

    private static ObjectNode m8342a(WakeLock wakeLock, long j, long j2) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("tag", wakeLock.d);
        objectNode.a("held_time_ms", j);
        objectNode.a("count", j2);
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

    private WakeLock m8341a(String str) {
        if (this.f8059i == null) {
            return null;
        }
        return (WakeLock) this.f8059i.get(str);
    }

    protected final void m8347e() {
        LocationStats locationStats = LocationStats.f9930a;
        if (locationStats == null) {
            BLog.b(f8051c, "The single instance of LocationStats is null");
            return;
        }
        Map b = locationStats.m10317b();
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        for (Entry entry : b.entrySet()) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("context", (String) entry.getKey());
            objectNode.a("coarse", ((LocationTime) entry.getValue()).m10318a());
            objectNode.a("medium", ((LocationTime) entry.getValue()).m10320b());
            objectNode.a("fine", ((LocationTime) entry.getValue()).m10322c());
            arrayNode.a(objectNode);
            j3 += ((LocationTime) entry.getValue()).m10318a();
            j2 += ((LocationTime) entry.getValue()).m10320b();
            j = ((LocationTime) entry.getValue()).m10322c() + j;
        }
        this.f8055e.a(7208983, j3);
        this.f8055e.a(7208984, j2);
        this.f8055e.a(7208985, j);
        this.f8055e.a(7208982, arrayNode.toString());
    }
}
