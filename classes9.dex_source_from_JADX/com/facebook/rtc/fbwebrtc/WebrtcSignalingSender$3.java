package com.facebook.rtc.fbwebrtc;

import com.facebook.debug.log.BLog;
import com.facebook.push.mqtt.service.MqttPushServiceClient.MqttPublishListener;

/* compiled from: audio service is not available */
class WebrtcSignalingSender$3 implements MqttPublishListener {
    final /* synthetic */ WebrtcSignalingSender f19412a;

    WebrtcSignalingSender$3(WebrtcSignalingSender webrtcSignalingSender) {
        this.f19412a = webrtcSignalingSender;
    }

    public final void m19381a() {
    }

    public final void m19382b() {
        BLog.b(WebrtcSignalingSender.a, "Failed to subscribe presence change");
    }
}
