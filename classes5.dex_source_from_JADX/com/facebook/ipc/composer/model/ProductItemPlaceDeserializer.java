package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TIMELINE_ACTION_MENU_SUGGEST_EDITS */
public class ProductItemPlaceDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14033a;

    static {
        GlobalAutoGenDeserializerCache.a(ProductItemPlace.class, new ProductItemPlaceDeserializer());
        m23410e();
    }

    public ProductItemPlaceDeserializer() {
        a(ProductItemPlace.class);
    }

    private static synchronized Map<String, FbJsonField> m23410e() {
        Map<String, FbJsonField> map;
        synchronized (ProductItemPlaceDeserializer.class) {
            if (f14033a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(ProductItemPlace.class.getDeclaredField("name")));
                    builder.b("location_page_id", FbJsonField.jsonField(ProductItemPlace.class.getDeclaredField("locationPageID")));
                    builder.b("latitude", FbJsonField.jsonField(ProductItemPlace.class.getDeclaredField("latitude")));
                    builder.b("longitude", FbJsonField.jsonField(ProductItemPlace.class.getDeclaredField("longitude")));
                    f14033a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14033a;
        }
        return map;
    }

    public final FbJsonField m23411a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23410e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23410e().keySet());
    }
}
