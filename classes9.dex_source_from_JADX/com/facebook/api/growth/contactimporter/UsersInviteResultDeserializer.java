package com.facebook.api.growth.contactimporter;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: sendMomentumEvents */
public class UsersInviteResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4042a;

    static {
        GlobalAutoGenDeserializerCache.a(UsersInviteResult.class, new UsersInviteResultDeserializer());
        m3924e();
    }

    public UsersInviteResultDeserializer() {
        a(UsersInviteResult.class);
    }

    private static synchronized Map<String, FbJsonField> m3924e() {
        Map<String, FbJsonField> map;
        synchronized (UsersInviteResultDeserializer.class) {
            if (f4042a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("email", FbJsonField.jsonField(UsersInviteResult.class.getDeclaredField("email")));
                    builder.b("invite_status", FbJsonField.jsonField(UsersInviteResult.class.getDeclaredField("inviteStatus")));
                    builder.b("normalized_id", FbJsonField.jsonField(UsersInviteResult.class.getDeclaredField("normalizedId")));
                    builder.b("uid", FbJsonField.jsonField(UsersInviteResult.class.getDeclaredField("userId")));
                    f4042a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4042a;
        }
        return map;
    }

    public final FbJsonField m3925a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m3924e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m3924e().keySet());
    }
}
