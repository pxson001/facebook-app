package com.facebook.pages.app.data.model;

import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: tap_featured_service_item */
public class FacebookProfileDeserializer extends com.facebook.ipc.model.FacebookProfileDeserializer {
    private static Map<String, FbJsonField> f1131a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookProfile.class, new FacebookProfileDeserializer());
        m1528e();
    }

    public FacebookProfileDeserializer() {
        a(FacebookProfile.class);
    }

    private static synchronized Map<String, FbJsonField> m1528e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookProfileDeserializer.class) {
            if (f1131a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("byLine", FbJsonField.jsonField(FacebookProfile.class.getDeclaredField("mByline")));
                    f1131a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1131a;
        }
        return map;
    }

    public final FbJsonField m1529a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1528e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        Set<String> b = Sets.b(m1528e().keySet());
        Collection jsonFields = com.facebook.ipc.model.FacebookProfileDeserializer.getJsonFields();
        if (jsonFields != null) {
            b.addAll(jsonFields);
        }
        return b;
    }
}
