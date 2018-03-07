package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: start index */
public abstract class StdScalarSerializer<T> extends StdSerializer<T> {
    protected StdScalarSerializer(Class<T> cls) {
        super((Class) cls);
    }

    protected StdScalarSerializer(Class<?> cls, byte b) {
        super((Class) cls);
    }

    public void mo1074a(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.a(t, jsonGenerator);
        mo1072a(t, jsonGenerator, serializerProvider);
        typeSerializer.d(t, jsonGenerator);
    }
}
