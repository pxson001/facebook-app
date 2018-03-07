package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$ShortKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;

    StdKeyDeserializer$ShortKD() {
        super(Integer.class);
    }

    public final Object m11301b(String str, DeserializationContext deserializationContext) {
        int a = StdKeyDeserializer.a(str);
        if (a >= -32768 && a <= 32767) {
            return Short.valueOf((short) a);
        }
        throw deserializationContext.a(this._keyClass, str, "overflow, value can not be represented as 16-bit value");
    }
}
