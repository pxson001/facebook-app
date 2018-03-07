package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: status_clicked_cold */
public class NullSerializer extends StdSerializer<Object> {
    public static final NullSerializer f4138a = new NullSerializer();

    private NullSerializer() {
        super(Object.class);
    }

    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1137h();
    }
}
