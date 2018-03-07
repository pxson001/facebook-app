package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.instagram.common.json.JsonFactoryHolder;

/* compiled from: action_text */
public final class ContextualConfigIdentifier__JsonHelper {
    public static ContextualConfigIdentifier m19731a(String str) {
        JsonParser a = JsonFactoryHolder.f7685a.a(str);
        a.c();
        ContextualConfigIdentifier contextualConfigIdentifier = new ContextualConfigIdentifier();
        if (a.g() != JsonToken.START_OBJECT) {
            a.f();
            contextualConfigIdentifier = null;
        } else {
            while (a.c() != JsonToken.END_OBJECT) {
                String i = a.i();
                a.c();
                int i2;
                if ("cctype".equals(i)) {
                    contextualConfigIdentifier.f11610a = a.g() == JsonToken.VALUE_NULL ? null : a.o();
                    i2 = 1;
                } else if ("version".equals(i)) {
                    contextualConfigIdentifier.f11611b = Integer.valueOf(a.E());
                    i2 = 1;
                }
                a.f();
            }
        }
        return contextualConfigIdentifier;
    }
}
