package com.facebook.messaging.payment.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: image/tiff */
public class CommerceOrderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13197a;

    static {
        GlobalAutoGenDeserializerCache.a(CommerceOrder.class, new CommerceOrderDeserializer());
        m13477e();
    }

    public CommerceOrderDeserializer() {
        a(CommerceOrder.class);
    }

    private static synchronized Map<String, FbJsonField> m13477e() {
        Map<String, FbJsonField> map;
        synchronized (CommerceOrderDeserializer.class) {
            if (f13197a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(CommerceOrder.class.getDeclaredField("mId")));
                    builder.b("name", FbJsonField.jsonField(CommerceOrder.class.getDeclaredField("mName")));
                    builder.b("description", FbJsonField.jsonField(CommerceOrder.class.getDeclaredField("mDescription")));
                    builder.b("seller_info", FbJsonField.jsonField(CommerceOrder.class.getDeclaredField("mSellerInfo")));
                    builder.b("image_url", FbJsonField.jsonField(CommerceOrder.class.getDeclaredField("mImageUrl")));
                    f13197a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13197a;
        }
        return map;
    }

    public final FbJsonField m13478a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13477e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13477e().keySet());
    }
}
