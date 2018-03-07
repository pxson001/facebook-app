package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$LongKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;

    StdKeyDeserializer$LongKD() {
        super(Long.class);
    }

    public final Object m11300b(String str, DeserializationContext deserializationContext) {
        return Long.valueOf(StdKeyDeserializer.b(str));
    }
}
