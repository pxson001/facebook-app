package com.facebook.auth.credentials;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: taggable_activity_suggestions */
public class SessionCookieSerializer extends JsonSerializer<SessionCookie> {
    public final void m3171a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SessionCookie sessionCookie = (SessionCookie) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (sessionCookie.mName != null) {
            jsonGenerator.a("name", sessionCookie.mName);
        }
        if (sessionCookie.mValue != null) {
            jsonGenerator.a("value", sessionCookie.mValue);
        }
        if (sessionCookie.mExpires != null) {
            jsonGenerator.a("expires", sessionCookie.mExpires);
        }
        if (sessionCookie.mDomain != null) {
            jsonGenerator.a("domain", sessionCookie.mDomain);
        }
        jsonGenerator.a("secure", sessionCookie.mSecure);
        if (sessionCookie.mPath != null) {
            jsonGenerator.a("path", sessionCookie.mPath);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(SessionCookie.class, new SessionCookieSerializer());
    }
}
