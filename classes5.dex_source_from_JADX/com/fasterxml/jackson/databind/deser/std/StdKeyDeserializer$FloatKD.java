package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$FloatKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;

    StdKeyDeserializer$FloatKD() {
        super(Float.class);
    }

    public final Object m11298b(String str, DeserializationContext deserializationContext) {
        return Float.valueOf((float) NumberInput.c(str));
    }
}
