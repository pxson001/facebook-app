package com.facebook.search.api.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: extra_overlay_source_media_id */
public class GraphSearchJsonResponseDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15533a;

    static {
        GlobalAutoGenDeserializerCache.a(GraphSearchJsonResponse.class, new GraphSearchJsonResponseDeserializer());
        m23164e();
    }

    public GraphSearchJsonResponseDeserializer() {
        a(GraphSearchJsonResponse.class);
    }

    private static synchronized Map<String, FbJsonField> m23164e() {
        Map<String, FbJsonField> map;
        synchronized (GraphSearchJsonResponseDeserializer.class) {
            if (f15533a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("response", FbJsonField.jsonField(GraphSearchJsonResponse.class.getDeclaredField("response")));
                    builder.b("num_topresults_to_show", FbJsonField.jsonField(GraphSearchJsonResponse.class.getDeclaredField("numTopResultsToShow")));
                    f15533a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15533a;
        }
        return map;
    }

    public final FbJsonField m23165a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23164e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23164e().keySet());
    }
}
