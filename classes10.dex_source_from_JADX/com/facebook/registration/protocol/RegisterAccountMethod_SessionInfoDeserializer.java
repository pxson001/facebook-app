package com.facebook.registration.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.registration.protocol.RegisterAccountMethod.SessionInfo;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: joinable_pivot_on */
public class RegisterAccountMethod_SessionInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8924a;

    static {
        GlobalAutoGenDeserializerCache.a(SessionInfo.class, new RegisterAccountMethod_SessionInfoDeserializer());
        m8906e();
    }

    public RegisterAccountMethod_SessionInfoDeserializer() {
        a(SessionInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m8906e() {
        Map<String, FbJsonField> map;
        synchronized (RegisterAccountMethod_SessionInfoDeserializer.class) {
            if (f8924a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("session_key", FbJsonField.jsonField(SessionInfo.class.getDeclaredField("sessionKey")));
                    builder.b("uid", FbJsonField.jsonField(SessionInfo.class.getDeclaredField("uid")));
                    builder.b("secret", FbJsonField.jsonField(SessionInfo.class.getDeclaredField("secret")));
                    builder.b("access_token", FbJsonField.jsonField(SessionInfo.class.getDeclaredField("accessToken")));
                    builder.b("confirmed", FbJsonField.jsonField(SessionInfo.class.getDeclaredField("confirmed")));
                    f8924a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8924a;
        }
        return map;
    }

    public final FbJsonField m8907a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8906e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8906e().keySet());
    }
}
