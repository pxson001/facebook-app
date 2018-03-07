package com.facebook.user.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: comment */
public class UserKeyDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5523a;

    static {
        GlobalAutoGenDeserializerCache.a(UserKey.class, new UserKeyDeserializer());
        m10365e();
    }

    public UserKeyDeserializer() {
        a(UserKey.class);
    }

    private static synchronized Map<String, FbJsonField> m10365e() {
        Map<String, FbJsonField> map;
        synchronized (UserKeyDeserializer.class) {
            if (f5523a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonField(UserKey.class.getDeclaredField("type")));
                    builder.b("id", FbJsonField.jsonField(UserKey.class.getDeclaredField("id")));
                    f5523a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5523a;
        }
        return map;
    }

    public final FbJsonField m10366a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10365e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10365e().keySet());
    }
}
