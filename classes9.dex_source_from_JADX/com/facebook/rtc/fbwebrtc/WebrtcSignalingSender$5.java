package com.facebook.rtc.fbwebrtc;

import com.facebook.push.mqtt.service.MqttPushServiceClient.MqttPublishListener;
import com.facebook.webrtc.WebrtcManager;

/* compiled from: audio service is not available */
class WebrtcSignalingSender$5 implements MqttPublishListener {
    final /* synthetic */ String f19418a;
    final /* synthetic */ String f19419b;
    final /* synthetic */ WebrtcSignalingSender f19420c;

    WebrtcSignalingSender$5(WebrtcSignalingSender webrtcSignalingSender, String str, String str2) {
        this.f19420c = webrtcSignalingSender;
        this.f19418a = str;
        this.f19419b = str2;
    }

    public final void m19385a() {
        if (this.f19420c.g != null) {
            WebrtcManager webrtcManager = this.f19420c.g;
            String str = this.f19418a;
            String str2 = this.f19419b;
            if (webrtcManager.a()) {
                webrtcManager.w.onMultiwayMessageSendSuccess(str, str2);
            }
        }
    }

    public final void m19386b() {
        if (this.f19420c.g != null) {
            this.f19420c.g.a(this.f19418a, this.f19419b, -3, "MQTT", "Mqtt send failure");
        }
    }
}
