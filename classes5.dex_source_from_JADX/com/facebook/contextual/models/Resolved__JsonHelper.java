package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.instagram.common.json.JsonFactoryHolder;

/* compiled from: acting_team_short_name */
public final class Resolved__JsonHelper {
    public static Resolved m19736a(String str) {
        JsonParser a = JsonFactoryHolder.f7685a.a(str);
        a.c();
        Resolved resolved = new Resolved();
        if (a.g() != JsonToken.START_OBJECT) {
            a.f();
            resolved = null;
        } else {
            while (a.c() != JsonToken.END_OBJECT) {
                String i = a.i();
                a.c();
                String str2 = null;
                int i2;
                if ("cctype".equals(i)) {
                    if (a.g() != JsonToken.VALUE_NULL) {
                        str2 = a.o();
                    }
                    resolved.f11629a = str2;
                    i2 = 1;
                } else if ("version".equals(i)) {
                    resolved.f11630b = Integer.valueOf(a.E());
                    i2 = 1;
                } else if ("output".equals(i)) {
                    if (a.g() != JsonToken.VALUE_NULL) {
                        str2 = a.o();
                    }
                    resolved.f11631c = str2;
                    i2 = 1;
                } else if ("value".equals(i)) {
                    if (a.g() != JsonToken.VALUE_NULL) {
                        str2 = a.o();
                    }
                    resolved.f11632d = str2;
                    i2 = 1;
                }
                a.f();
            }
        }
        return resolved;
    }
}
