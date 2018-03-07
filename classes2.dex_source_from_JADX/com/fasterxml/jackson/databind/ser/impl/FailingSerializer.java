package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/* compiled from: status_text */
public final class FailingSerializer extends StdSerializer<Object> {
    final String f4136a;

    public FailingSerializer(String str) {
        super(Object.class);
        this.f4136a = str;
    }

    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        throw new JsonGenerationException(this.f4136a);
    }
}
