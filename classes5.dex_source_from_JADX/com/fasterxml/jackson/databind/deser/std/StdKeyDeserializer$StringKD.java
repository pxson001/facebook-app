package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$StringKD extends StdKeyDeserializer {
    private static final StdKeyDeserializer$StringKD f6099a = new StdKeyDeserializer$StringKD(String.class);
    private static final StdKeyDeserializer$StringKD f6100b = new StdKeyDeserializer$StringKD(Object.class);
    private static final long serialVersionUID = 1;

    private StdKeyDeserializer$StringKD(Class<?> cls) {
        super(cls);
    }

    public static StdKeyDeserializer$StringKD m11304a(Class<?> cls) {
        if (cls == String.class) {
            return f6099a;
        }
        if (cls == Object.class) {
            return f6100b;
        }
        return new StdKeyDeserializer$StringKD(cls);
    }

    public final Object m11305b(String str, DeserializationContext deserializationContext) {
        return str;
    }
}
