package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.TimeZone;

/* compiled from: can_viewer_maybe */
public class TimeZoneSerializer extends StdScalarSerializer<TimeZone> {
    public static final TimeZoneSerializer f6222a = new TimeZoneSerializer();

    public final /* bridge */ /* synthetic */ void m11735a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        m11734a((TimeZone) obj, jsonGenerator);
    }

    public final void m11736a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        obj = (TimeZone) obj;
        typeSerializer.mo705a(obj, jsonGenerator, TimeZone.class);
        m11734a(obj, jsonGenerator);
        typeSerializer.mo710d(obj, jsonGenerator);
    }

    public TimeZoneSerializer() {
        super(TimeZone.class);
    }

    private static void m11734a(TimeZone timeZone, JsonGenerator jsonGenerator) {
        jsonGenerator.b(timeZone.getID());
    }
}
