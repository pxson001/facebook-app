package com.facebook.katana.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: update-background-location */
public class FacebookSessionInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f939a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookSessionInfo.class, new FacebookSessionInfoDeserializer());
        m989e();
    }

    public FacebookSessionInfoDeserializer() {
        a(FacebookSessionInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m989e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookSessionInfoDeserializer.class) {
            if (f939a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("username", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("username")));
                    builder.b("session_key", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("sessionKey")));
                    builder.b("secret", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("sessionSecret")));
                    builder.b("access_token", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("oAuthToken")));
                    builder.b("uid", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("userId")));
                    builder.b("machine_id", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("machineID")));
                    builder.b("error_data", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("errorData")));
                    builder.b("filter", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("mFilterKey")));
                    builder.b("profile", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredField("mMyself")));
                    builder.b("session_cookies", FbJsonField.jsonField(FacebookSessionInfo.class.getDeclaredMethod("setSessionCookies", new Class[]{TokenBuffer.class})));
                    f939a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f939a;
        }
        return map;
    }

    public final FbJsonField m990a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m989e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m989e().keySet());
    }
}
