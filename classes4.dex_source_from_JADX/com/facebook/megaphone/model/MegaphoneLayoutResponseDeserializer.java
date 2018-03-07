package com.facebook.megaphone.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fbns */
public class MegaphoneLayoutResponseDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11972a;

    static {
        GlobalAutoGenDeserializerCache.a(MegaphoneLayoutResponse.class, new MegaphoneLayoutResponseDeserializer());
        m12627e();
    }

    public MegaphoneLayoutResponseDeserializer() {
        a(MegaphoneLayoutResponse.class);
    }

    private static synchronized Map<String, FbJsonField> m12627e() {
        Map<String, FbJsonField> map;
        synchronized (MegaphoneLayoutResponseDeserializer.class) {
            if (f11972a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("cache_id", FbJsonField.jsonField(MegaphoneLayoutResponse.class.getDeclaredField("cacheId")));
                    builder.b("data", FbJsonField.jsonField(MegaphoneLayoutResponse.class.getDeclaredField("layout")));
                    f11972a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11972a;
        }
        return map;
    }

    public final FbJsonField m12628a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12627e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12627e().keySet());
    }
}
