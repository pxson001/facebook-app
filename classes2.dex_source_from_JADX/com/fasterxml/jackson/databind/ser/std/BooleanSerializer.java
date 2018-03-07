package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: standard_success_pings */
public final class BooleanSerializer extends NonTypedScalarSerializerBase<Boolean> {
    final boolean f4170a;

    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1119a(((Boolean) obj).booleanValue());
    }

    public BooleanSerializer(boolean z) {
        super(Boolean.class);
        this.f4170a = z;
    }
}
