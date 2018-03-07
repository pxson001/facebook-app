package com.facebook.mqttlite;

import com.facebook.proxygen.AnalyticsLogger;
import com.facebook.rti.mqtt.common.analytics.MqttAnalyticsLogger;
import java.util.Map;

/* compiled from: time_to_delta_load_bootstrap */
public class WhistleAnalyticsLogger implements AnalyticsLogger {
    private final MqttAnalyticsLogger f3037a;

    public WhistleAnalyticsLogger(MqttAnalyticsLogger mqttAnalyticsLogger) {
        this.f3037a = mqttAnalyticsLogger;
    }

    public void reportEvent(Map<String, String> map, String str, String str2) {
        this.f3037a.a(str, map);
    }
}
