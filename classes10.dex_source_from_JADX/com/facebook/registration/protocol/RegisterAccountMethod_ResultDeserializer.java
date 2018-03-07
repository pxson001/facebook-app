package com.facebook.registration.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.registration.protocol.RegisterAccountMethod.Result;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: joinable_share_action */
public class RegisterAccountMethod_ResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8923a;

    static {
        GlobalAutoGenDeserializerCache.a(Result.class, new RegisterAccountMethod_ResultDeserializer());
        m8904e();
    }

    public RegisterAccountMethod_ResultDeserializer() {
        a(Result.class);
    }

    private static synchronized Map<String, FbJsonField> m8904e() {
        Map<String, FbJsonField> map;
        synchronized (RegisterAccountMethod_ResultDeserializer.class) {
            if (f8923a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("account_type", FbJsonField.jsonField(Result.class.getDeclaredField("accountType")));
                    builder.b("new_user_id", FbJsonField.jsonField(Result.class.getDeclaredField("userId")));
                    builder.b("completion_url", FbJsonField.jsonField(Result.class.getDeclaredField("completionUrl")));
                    builder.b("session_info", FbJsonField.jsonField(Result.class.getDeclaredField("sessionInfo")));
                    f8923a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8923a;
        }
        return map;
    }

    public final FbJsonField m8905a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8904e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8904e().keySet());
    }
}
