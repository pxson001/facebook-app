package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TIMELINE_FRIENDS_COLLECTION */
public class ProductItemAttachmentDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14020a;

    static {
        GlobalAutoGenDeserializerCache.a(ProductItemAttachment.class, new ProductItemAttachmentDeserializer());
        m23399e();
    }

    public ProductItemAttachmentDeserializer() {
        a(ProductItemAttachment.class);
    }

    private static synchronized Map<String, FbJsonField> m23399e() {
        Map<String, FbJsonField> map;
        synchronized (ProductItemAttachmentDeserializer.class) {
            if (f14020a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("title", FbJsonField.jsonField(ProductItemAttachment.class.getDeclaredField("title")));
                    builder.b("pickup_delivery_info", FbJsonField.jsonField(ProductItemAttachment.class.getDeclaredField("pickupDeliveryInfo")));
                    builder.b("description", FbJsonField.jsonField(ProductItemAttachment.class.getDeclaredField("description")));
                    builder.b("price", FbJsonField.jsonField(ProductItemAttachment.class.getDeclaredField("price")));
                    builder.b("currency", FbJsonField.jsonField(ProductItemAttachment.class.getDeclaredField("currencyCode")));
                    builder.b("category_id", FbJsonField.jsonField(ProductItemAttachment.class.getDeclaredField("categoryID")));
                    f14020a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14020a;
        }
        return map;
    }

    public final FbJsonField m23400a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23399e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23399e().keySet());
    }
}
