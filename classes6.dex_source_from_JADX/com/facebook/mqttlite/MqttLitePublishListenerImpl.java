package com.facebook.mqttlite;

import com.facebook.debug.log.BLog;
import com.facebook.rti.mqtt.protocol.MqttPublishListener;
import com.google.common.base.Preconditions;

/* compiled from: time_to_prefetch_bootstrap */
class MqttLitePublishListenerImpl implements MqttPublishListener {
    private static final Class<?> f3003a = MqttLitePublishListenerImpl.class;
    private final com.facebook.push.mqtt.ipc.MqttPublishListener f3004b;

    MqttLitePublishListenerImpl(com.facebook.push.mqtt.ipc.MqttPublishListener mqttPublishListener) {
        this.f3004b = (com.facebook.push.mqtt.ipc.MqttPublishListener) Preconditions.checkNotNull(mqttPublishListener);
    }

    public final void m4021a() {
        try {
            this.f3004b.mo298a();
        } catch (Throwable e) {
            BLog.a(f3003a, e, "Failed to deliver onSuccess", new Object[0]);
        }
    }

    public final void m4022b() {
        try {
            this.f3004b.mo299b();
        } catch (Throwable e) {
            BLog.a(f3003a, e, "Failed to deliver onFailure", new Object[0]);
        }
    }
}
