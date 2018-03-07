package com.facebook.mqttlite;

import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.push.mqtt.external.PublishedPayloadDescriptor;
import com.facebook.rti.mqtt.common.analytics.RTStatsLatency;
import com.facebook.rti.mqtt.common.analytics.RTStatsLatency.Metric;

/* compiled from: global_feature */
class MqttService$7 implements Runnable {
    final /* synthetic */ PublishedPayloadDescriptor f11659a;
    final /* synthetic */ MqttService f11660b;

    MqttService$7(MqttService mqttService, PublishedPayloadDescriptor publishedPayloadDescriptor) {
        this.f11660b = mqttService;
        this.f11659a = publishedPayloadDescriptor;
    }

    public void run() {
        try {
            long d = this.f11659a.m12193d();
            String b = this.f11659a.m12191b();
            byte[] c = this.f11659a.m12192c();
            if (d > 0) {
                ((RTStatsLatency) this.f11660b.h.a(RTStatsLatency.class)).a(Metric.StackReceivingLatencyMs, this.f11660b.A.now() - d);
                this.f11660b.g.a(b, this.f11660b.A.now() - d);
            }
            for (MqttPushHandler mqttPushHandler : this.f11660b.w) {
                long now = this.f11660b.A.now();
                mqttPushHandler.onMessage(b, c);
                long now2 = this.f11660b.A.now();
                if (now != now2) {
                    this.f11660b.v.a.a(mqttPushHandler.getClass().getSimpleName(), now2 - now);
                }
            }
        } finally {
            this.f11660b.v.a.d();
        }
    }
}
