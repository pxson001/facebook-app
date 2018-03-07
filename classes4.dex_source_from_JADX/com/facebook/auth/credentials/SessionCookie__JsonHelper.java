package com.facebook.auth.credentials;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: first_notification_stories */
public final class SessionCookie__JsonHelper {
    public static SessionCookie m12038a(JsonParser jsonParser) {
        SessionCookie sessionCookie = new SessionCookie();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            int i2;
            if ("name".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    str = jsonParser.o();
                }
                sessionCookie.mName = str;
                i2 = 1;
            } else if ("value".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    str = jsonParser.o();
                }
                sessionCookie.mValue = str;
                i2 = 1;
            } else if ("expires".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    str = jsonParser.o();
                }
                sessionCookie.mExpires = str;
                i2 = 1;
            } else if ("domain".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    str = jsonParser.o();
                }
                sessionCookie.mDomain = str;
                i2 = 1;
            } else if ("secure".equals(i)) {
                sessionCookie.mSecure = jsonParser.H();
                i2 = 1;
            } else if ("path".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    str = jsonParser.o();
                }
                sessionCookie.mPath = str;
                i2 = 1;
            }
            jsonParser.f();
        }
        return sessionCookie;
    }
}
