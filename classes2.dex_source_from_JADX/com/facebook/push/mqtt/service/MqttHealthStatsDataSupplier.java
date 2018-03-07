package com.facebook.push.mqtt.service;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: tracking_string */
public class MqttHealthStatsDataSupplier implements FbCustomReportDataSupplier {
    private final Lazy<MqttPushServiceClientManager> f2274a;

    @Inject
    public MqttHealthStatsDataSupplier(Lazy<MqttPushServiceClientManager> lazy) {
        this.f2274a = lazy;
    }

    public final String mo633a(Throwable th) {
        if (th != null) {
            return null;
        }
        MqttPushServiceClient a = ((MqttPushServiceClientManagerImpl) this.f2274a.get()).m22140a();
        String d;
        try {
            d = a.d();
            return d;
        } catch (Throwable th2) {
            d = th2.toString();
            return d;
        } finally {
            a.f();
        }
    }

    public final String mo632a() {
        return "mqtt_health_stats";
    }
}
