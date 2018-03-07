package com.facebook.groupcommerce.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: mPosition */
public class GroupCommerceCategoryDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10989a;

    static {
        GlobalAutoGenDeserializerCache.a(GroupCommerceCategory.class, new GroupCommerceCategoryDeserializer());
        m17633e();
    }

    public GroupCommerceCategoryDeserializer() {
        a(GroupCommerceCategory.class);
    }

    private static synchronized Map<String, FbJsonField> m17633e() {
        Map<String, FbJsonField> map;
        synchronized (GroupCommerceCategoryDeserializer.class) {
            if (f10989a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(GroupCommerceCategory.class.getDeclaredField("name")));
                    builder.b("category_id", FbJsonField.jsonField(GroupCommerceCategory.class.getDeclaredField("categoryID")));
                    f10989a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10989a;
        }
        return map;
    }

    public final FbJsonField m17634a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m17633e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m17633e().keySet());
    }
}
