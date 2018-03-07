package com.facebook.user.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: comment_curation_menu_opened */
public class NameDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5515a;

    static {
        GlobalAutoGenDeserializerCache.a(Name.class, new NameDeserializer());
        m10359e();
    }

    public NameDeserializer() {
        a(Name.class);
    }

    private static synchronized Map<String, FbJsonField> m10359e() {
        Map<String, FbJsonField> map;
        synchronized (NameDeserializer.class) {
            if (f5515a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("firstName", FbJsonField.jsonField(Name.class.getDeclaredField("firstName")));
                    builder.b("lastName", FbJsonField.jsonField(Name.class.getDeclaredField("lastName")));
                    builder.b("displayName", FbJsonField.jsonField(Name.class.getDeclaredField("displayName")));
                    f5515a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5515a;
        }
        return map;
    }

    public final FbJsonField m10360a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10359e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10359e().keySet());
    }
}
