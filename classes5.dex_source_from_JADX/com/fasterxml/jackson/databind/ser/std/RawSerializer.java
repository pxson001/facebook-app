package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

@JacksonStdImpl
/* compiled from: can_viewer_promote */
public class RawSerializer<T> extends StdSerializer<T> {
    public RawSerializer(Class<?> cls) {
        super(cls, (byte) 0);
    }

    public final void m11689a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d(t.toString());
    }

    public final void m11690a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.mo704a(t, jsonGenerator);
        a(t, jsonGenerator, serializerProvider);
        typeSerializer.mo710d(t, jsonGenerator);
    }
}
