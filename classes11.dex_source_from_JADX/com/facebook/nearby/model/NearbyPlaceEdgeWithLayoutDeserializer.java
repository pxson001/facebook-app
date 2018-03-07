package com.facebook.nearby.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: unused */
public class NearbyPlaceEdgeWithLayoutDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f380a;

    static {
        GlobalAutoGenDeserializerCache.a(NearbyPlaceEdgeWithLayout.class, new NearbyPlaceEdgeWithLayoutDeserializer());
        m489e();
    }

    public NearbyPlaceEdgeWithLayoutDeserializer() {
        a(NearbyPlaceEdgeWithLayout.class);
    }

    private static synchronized Map<String, FbJsonField> m489e() {
        Map<String, FbJsonField> map;
        synchronized (NearbyPlaceEdgeWithLayoutDeserializer.class) {
            if (f380a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("placeEdge", FbJsonField.jsonField(NearbyPlaceEdgeWithLayout.class.getDeclaredField("placeEdge")));
                    builder.b("layout", FbJsonField.jsonField(NearbyPlaceEdgeWithLayout.class.getDeclaredField("layout")));
                    f380a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f380a;
        }
        return map;
    }

    public final FbJsonField m490a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m489e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m489e().keySet());
    }
}
