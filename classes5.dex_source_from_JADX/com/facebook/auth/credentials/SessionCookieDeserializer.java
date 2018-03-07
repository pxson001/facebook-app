package com.facebook.auth.credentials;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: taggaed_ids */
public class SessionCookieDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(SessionCookie.class, new SessionCookieDeserializer());
    }

    public SessionCookieDeserializer() {
        a(SessionCookie.class);
    }

    public Object m3170a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return SessionCookie__JsonHelper.a(jsonParser);
    }
}
