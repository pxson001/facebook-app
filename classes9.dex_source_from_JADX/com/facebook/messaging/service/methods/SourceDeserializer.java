package com.facebook.messaging.service.methods;

import com.facebook.inject.InjectorLike;

/* compiled from: credentialId */
public class SourceDeserializer {
    public static SourceDeserializer m17062a(InjectorLike injectorLike) {
        return new SourceDeserializer();
    }

    public static String m17063a(String str) {
        if (str.equals("messenger")) {
            return str;
        }
        if (str.startsWith("source:")) {
            return str.substring(7);
        }
        return null;
    }
}
