package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Calendar;

/* compiled from: can_viewer_message */
public class StdKeySerializers$CalendarKeySerializer extends StdSerializer<Calendar> {
    protected static final JsonSerializer<?> f6220a = new StdKeySerializers$CalendarKeySerializer();

    public final void m11732a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        serializerProvider.a(((Calendar) obj).getTimeInMillis(), jsonGenerator);
    }

    public StdKeySerializers$CalendarKeySerializer() {
        super(Calendar.class);
    }
}
