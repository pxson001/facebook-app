package com.facebook.graphql.query;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: edof */
public class JsonPathValueDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4793a;

    static {
        GlobalAutoGenDeserializerCache.a(JsonPathValue.class, new JsonPathValueDeserializer());
        m9595e();
    }

    public JsonPathValueDeserializer() {
        a(JsonPathValue.class);
    }

    private static synchronized Map<String, FbJsonField> m9595e() {
        Map<String, FbJsonField> map;
        synchronized (JsonPathValueDeserializer.class) {
            if (f4793a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("value", FbJsonField.jsonField(JsonPathValue.class.getDeclaredField("mValue")));
                    f4793a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4793a;
        }
        return map;
    }

    public final FbJsonField m9596a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m9595e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m9595e().keySet());
    }
}
