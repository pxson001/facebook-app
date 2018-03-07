package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.util.Date;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$DateKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;

    protected StdKeyDeserializer$DateKD() {
        super(Date.class);
    }

    public final Object m11294b(String str, DeserializationContext deserializationContext) {
        return deserializationContext.b(str);
    }
}
