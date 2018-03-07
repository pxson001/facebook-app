package com.facebook.mqttlite;

/* compiled from: time_to_load_bootstrap_keywords */
class MqttService$10 implements Runnable {
    final /* synthetic */ String f3005a;
    final /* synthetic */ byte[] f3006b;
    final /* synthetic */ MqttService f3007c;

    MqttService$10(MqttService mqttService, String str, byte[] bArr) {
        this.f3007c = mqttService;
        this.f3005a = str;
        this.f3006b = bArr;
    }

    public void run() {
        try {
            this.f3007c.c.a(this.f3005a, this.f3006b, (long) this.f3007c.q.b());
        } catch (Exception e) {
        }
    }
}
