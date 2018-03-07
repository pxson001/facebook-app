package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.util.Calendar;
import java.util.Date;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$CalendarKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;

    protected StdKeyDeserializer$CalendarKD() {
        super(Calendar.class);
    }

    public final Object m11292b(String str, DeserializationContext deserializationContext) {
        Date b = deserializationContext.b(str);
        return b == null ? null : deserializationContext.a(b);
    }
}
