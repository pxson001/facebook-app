package com.facebook.nearby.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: unlike_page_success */
public class TypeaheadPlaceWithLayoutDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f409a;

    static {
        GlobalAutoGenDeserializerCache.a(TypeaheadPlaceWithLayout.class, new TypeaheadPlaceWithLayoutDeserializer());
        m515e();
    }

    public TypeaheadPlaceWithLayoutDeserializer() {
        a(TypeaheadPlaceWithLayout.class);
    }

    private static synchronized Map<String, FbJsonField> m515e() {
        Map<String, FbJsonField> map;
        synchronized (TypeaheadPlaceWithLayoutDeserializer.class) {
            if (f409a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("typeahead_place", FbJsonField.jsonField(TypeaheadPlaceWithLayout.class.getDeclaredField("typeaheadPlace")));
                    builder.b("layout", FbJsonField.jsonField(TypeaheadPlaceWithLayout.class.getDeclaredField("layout")));
                    f409a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f409a;
        }
        return map;
    }

    public final FbJsonField m516a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m515e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m515e().keySet());
    }
}
