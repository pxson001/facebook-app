package com.facebook.mqttlite;

import com.facebook.proxygen.ByteEventLogger;
import com.facebook.rti.mqtt.protocol.MqttClient.1;

/* compiled from: time_since_launch_ms */
public class WhistleByteLogger implements ByteEventLogger {
    public volatile 1 f3038a;

    public void onBytesReceived(String str, long j) {
        if (this.f3038a != null) {
            int i = (int) j;
            this.f3038a.b(i);
            this.f3038a.b(str, i);
        }
    }

    public void onBytesSent(String str, long j) {
        if (this.f3038a != null) {
            int i = (int) j;
            this.f3038a.a(i);
            this.f3038a.a(str, i);
        }
    }
}
