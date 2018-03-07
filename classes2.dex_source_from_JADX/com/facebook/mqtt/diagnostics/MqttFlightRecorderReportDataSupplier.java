package com.facebook.mqtt.diagnostics;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.flightrecorder.FlightRecorderEvent;
import com.facebook.common.stringformat.StringFormatUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: translation */
public class MqttFlightRecorderReportDataSupplier implements FbCustomReportDataSupplier {
    private static final Comparator<FlightRecorderEvent> f2267b = new C01501();
    private final MqttFlightRecorder f2268a;

    /* compiled from: translation */
    final class C01501 implements Comparator<FlightRecorderEvent> {
        C01501() {
        }

        public final int compare(Object obj, Object obj2) {
            FlightRecorderEvent flightRecorderEvent = (FlightRecorderEvent) obj2;
            long startTime = ((FlightRecorderEvent) obj).getStartTime();
            long startTime2 = flightRecorderEvent.getStartTime();
            if (startTime < startTime2) {
                return -1;
            }
            return startTime == startTime2 ? 0 : 1;
        }
    }

    @Inject
    public MqttFlightRecorderReportDataSupplier(MqttFlightRecorder mqttFlightRecorder) {
        this.f2268a = mqttFlightRecorder;
    }

    public final String mo633a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        List<FlightRecorderEvent> a = this.f2268a.m4454a();
        Collections.sort(a, f2267b);
        for (FlightRecorderEvent flightRecorderEvent : a) {
            stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("[%s] %s%n", Long.valueOf(flightRecorderEvent.getStartTime()), flightRecorderEvent.mo2286a()));
        }
        return stringBuilder.toString();
    }

    public final String mo632a() {
        return "mqtt_client_log";
    }
}
