package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/* compiled from: status_clicked_hot */
public class UnknownSerializer extends StdSerializer<Object> {
    public UnknownSerializer() {
        super(Object.class);
    }

    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (serializerProvider.m7316a(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            m7353b(obj);
        }
        jsonGenerator.mo1134f();
        jsonGenerator.mo1136g();
    }

    public final void mo1074a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        if (serializerProvider.m7316a(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            m7353b(obj);
        }
        typeSerializer.b(obj, jsonGenerator);
        typeSerializer.e(obj, jsonGenerator);
    }

    private static void m7353b(Object obj) {
        throw new JsonMappingException("No serializer found for class " + obj.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) )");
    }
}
