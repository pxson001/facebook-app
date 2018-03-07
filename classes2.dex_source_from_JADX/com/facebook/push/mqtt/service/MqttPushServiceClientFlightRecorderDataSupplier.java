package com.facebook.push.mqtt.service;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.push.mqtt.service.response.MqttPushServiceClientFlightRecorderEvent;
import com.facebook.push.mqtt.service.response.SimpleMqttPushServiceClientFlightRecorderEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: tracking_codes */
public class MqttPushServiceClientFlightRecorderDataSupplier implements FbCustomReportDataSupplier {
    private static final Comparator<MqttPushServiceClientFlightRecorderEvent> f2275b = new C01511();
    private final MqttPushServiceClientFlightRecorder f2276a;

    /* compiled from: tracking_codes */
    final class C01511 implements Comparator<MqttPushServiceClientFlightRecorderEvent> {
        C01511() {
        }

        public final int compare(Object obj, Object obj2) {
            SimpleMqttPushServiceClientFlightRecorderEvent simpleMqttPushServiceClientFlightRecorderEvent = (SimpleMqttPushServiceClientFlightRecorderEvent) obj2;
            long startTime = ((SimpleMqttPushServiceClientFlightRecorderEvent) obj).getStartTime();
            long startTime2 = simpleMqttPushServiceClientFlightRecorderEvent.getStartTime();
            if (startTime < startTime2) {
                return -1;
            }
            return startTime == startTime2 ? 0 : 1;
        }
    }

    @Inject
    public MqttPushServiceClientFlightRecorderDataSupplier(MqttPushServiceClientFlightRecorder mqttPushServiceClientFlightRecorder) {
        this.f2276a = mqttPushServiceClientFlightRecorder;
    }

    public final String mo633a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        List<SimpleMqttPushServiceClientFlightRecorderEvent> a = this.f2276a.m4454a();
        Collections.sort(a, f2275b);
        for (SimpleMqttPushServiceClientFlightRecorderEvent simpleMqttPushServiceClientFlightRecorderEvent : a) {
            stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("[%s] %s%n", Long.valueOf(simpleMqttPushServiceClientFlightRecorderEvent.getStartTime()), simpleMqttPushServiceClientFlightRecorderEvent.mo2286a()));
        }
        return stringBuilder.toString();
    }

    public final String mo632a() {
        return "mqtt_ipc_client_log";
    }
}
