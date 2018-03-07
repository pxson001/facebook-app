package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$DoubleKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;

    StdKeyDeserializer$DoubleKD() {
        super(Double.class);
    }

    public final Object m11296b(String str, DeserializationContext deserializationContext) {
        return Double.valueOf(NumberInput.c(str));
    }
}
