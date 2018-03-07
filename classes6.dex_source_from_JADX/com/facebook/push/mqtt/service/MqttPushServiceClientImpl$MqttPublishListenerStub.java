package com.facebook.push.mqtt.service;

import com.facebook.push.mqtt.ipc.MqttPublishListener.Stub;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/* compiled from: sms_default_application */
class MqttPushServiceClientImpl$MqttPublishListenerStub extends Stub {
    final /* synthetic */ MqttPushServiceClientImpl f4300a;
    private final MqttPushServiceClient$MqttPublishListener f4301b;

    public MqttPushServiceClientImpl$MqttPublishListenerStub(MqttPushServiceClientImpl mqttPushServiceClientImpl, @Nonnull MqttPushServiceClient$MqttPublishListener mqttPushServiceClient$MqttPublishListener) {
        this.f4300a = mqttPushServiceClientImpl;
        this.f4301b = (MqttPushServiceClient$MqttPublishListener) Preconditions.checkNotNull(mqttPushServiceClient$MqttPublishListener);
    }

    public final void mo298a() {
        MqttPushServiceClientImpl.b(this.f4300a, this.f4301b);
        this.f4301b.m6399a();
    }

    public final void mo299b() {
        MqttPushServiceClientImpl.b(this.f4300a, this.f4301b);
        this.f4301b.m6400b();
    }
}
