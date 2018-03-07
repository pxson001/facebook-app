package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: can_viewer_report */
public final class TypeWrappedSerializer extends JsonSerializer<Object> {
    protected final TypeSerializer f6184a;
    protected final JsonSerializer<Object> f6185b;

    public TypeWrappedSerializer(TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        this.f6184a = typeSerializer;
        this.f6185b = jsonSerializer;
    }

    public final void m11630a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        this.f6185b.a(obj, jsonGenerator, serializerProvider, this.f6184a);
    }

    public final void m11631a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        this.f6185b.a(obj, jsonGenerator, serializerProvider, typeSerializer);
    }

    public final Class<Object> m11629a() {
        return Object.class;
    }
}
