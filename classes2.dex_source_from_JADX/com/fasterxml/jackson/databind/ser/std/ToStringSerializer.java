package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

@JacksonStdImpl
/* compiled from: start an object */
public class ToStringSerializer extends StdSerializer<Object> {
    public static final ToStringSerializer f4164a = new ToStringSerializer();

    public ToStringSerializer() {
        super(Object.class);
    }

    public final boolean mo1102a(Object obj) {
        if (obj == null) {
            return true;
        }
        String obj2 = obj.toString();
        if (obj2 == null || obj2.length() == 0) {
            return true;
        }
        return false;
    }

    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1123b(obj.toString());
    }

    public final void mo1074a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.a(obj, jsonGenerator);
        mo1072a(obj, jsonGenerator, serializerProvider);
        typeSerializer.d(obj, jsonGenerator);
    }
}
