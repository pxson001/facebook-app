package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$ByteKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;

    StdKeyDeserializer$ByteKD() {
        super(Byte.class);
    }

    public final Object m11291b(String str, DeserializationContext deserializationContext) {
        int a = StdKeyDeserializer.a(str);
        if (a >= -128 && a <= 255) {
            return Byte.valueOf((byte) a);
        }
        throw deserializationContext.a(this._keyClass, str, "overflow, value can not be represented as 8-bit value");
    }
}
