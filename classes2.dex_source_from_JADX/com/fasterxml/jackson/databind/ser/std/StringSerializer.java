package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: startFinalizer */
public final class StringSerializer extends NonTypedScalarSerializerBase<String> {
    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1123b((String) obj);
    }

    public final boolean mo1102a(Object obj) {
        String str = (String) obj;
        return str == null || str.length() == 0;
    }

    public StringSerializer() {
        super(String.class);
    }
}
