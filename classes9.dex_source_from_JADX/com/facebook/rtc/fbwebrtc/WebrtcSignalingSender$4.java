package com.facebook.rtc.fbwebrtc;

import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.push.mqtt.service.MqttPushServiceClient.MqttPublishListener;

/* compiled from: audio service is not available */
class WebrtcSignalingSender$4 implements MqttPublishListener {
    final /* synthetic */ FbTraceEventAnnotations f19413a;
    final /* synthetic */ FbTraceNode f19414b;
    final /* synthetic */ long f19415c;
    final /* synthetic */ long f19416d;
    final /* synthetic */ WebrtcSignalingSender f19417e;

    WebrtcSignalingSender$4(WebrtcSignalingSender webrtcSignalingSender, FbTraceEventAnnotations fbTraceEventAnnotations, FbTraceNode fbTraceNode, long j, long j2) {
        this.f19417e = webrtcSignalingSender;
        this.f19413a = fbTraceEventAnnotations;
        this.f19414b = fbTraceNode;
        this.f19415c = j;
        this.f19416d = j2;
    }

    public final void m19383a() {
        this.f19413a.put("success", "true");
        this.f19417e.e.a(this.f19414b, FbTraceEvent.RESPONSE_RECEIVE, this.f19413a);
    }

    public final void m19384b() {
        if (this.f19417e.g != null) {
            WebrtcSignalingSender.b(this.f19417e);
            this.f19417e.g.a(null, this.f19415c, this.f19416d, "Mqtt send failure", -3, "MQTT");
        }
        this.f19413a.put("success", "false");
        this.f19413a.put("error_code", "mqtt_client_failure_3");
        this.f19417e.e.a(this.f19414b, FbTraceEvent.RESPONSE_RECEIVE, this.f19413a);
    }
}
