package com.facebook.push.mqtt.service;

/* compiled from: slideshow_edit */
class MqttPushServiceManager$5 implements Runnable {
    final /* synthetic */ MqttPushServiceManager f4311a;

    MqttPushServiceManager$5(MqttPushServiceManager mqttPushServiceManager) {
        this.f4311a = mqttPushServiceManager;
    }

    public void run() {
        MqttPushServiceManager.a(this.f4311a, false);
    }
}
