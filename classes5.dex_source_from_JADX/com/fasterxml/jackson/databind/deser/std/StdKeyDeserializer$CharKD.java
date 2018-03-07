package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$CharKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;

    StdKeyDeserializer$CharKD() {
        super(Character.class);
    }

    public final Object m11293b(String str, DeserializationContext deserializationContext) {
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw deserializationContext.a(this._keyClass, str, "can only convert 1-character Strings");
    }
}
