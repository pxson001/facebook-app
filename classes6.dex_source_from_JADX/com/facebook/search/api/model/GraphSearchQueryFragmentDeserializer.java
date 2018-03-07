package com.facebook.search.api.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: extra_op_may_auto_retry */
public class GraphSearchQueryFragmentDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15534a;

    static {
        GlobalAutoGenDeserializerCache.a(GraphSearchQueryFragment.class, new GraphSearchQueryFragmentDeserializer());
        m23166e();
    }

    public GraphSearchQueryFragmentDeserializer() {
        a(GraphSearchQueryFragment.class);
    }

    private static synchronized Map<String, FbJsonField> m23166e() {
        Map<String, FbJsonField> map;
        synchronized (GraphSearchQueryFragmentDeserializer.class) {
            if (f15534a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("text", FbJsonField.jsonField(GraphSearchQueryFragment.class.getDeclaredField("text")));
                    builder.b("is_matched", FbJsonField.jsonField(GraphSearchQueryFragment.class.getDeclaredField("isMatched")));
                    f15534a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15534a;
        }
        return map;
    }

    public final FbJsonField m23167a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23166e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23166e().keySet());
    }
}
