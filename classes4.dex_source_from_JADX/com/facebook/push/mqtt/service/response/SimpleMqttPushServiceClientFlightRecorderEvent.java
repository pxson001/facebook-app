package com.facebook.push.mqtt.service.response;

import com.facebook.common.flightrecorder.FlightRecorderEvent;
import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: has_contacts_fetch_run_at_least_once */
public class SimpleMqttPushServiceClientFlightRecorderEvent implements FlightRecorderEvent {
    private final long f10856a;
    private final String f10857b;
    private final Object[] f10858c;

    public SimpleMqttPushServiceClientFlightRecorderEvent(long j, String str, Object... objArr) {
        this.f10856a = j;
        this.f10857b = str;
        this.f10858c = objArr;
    }

    public long getStartTime() {
        return this.f10856a;
    }

    public final String m11301a() {
        return StringFormatUtil.a(this.f10857b, this.f10858c);
    }
}
