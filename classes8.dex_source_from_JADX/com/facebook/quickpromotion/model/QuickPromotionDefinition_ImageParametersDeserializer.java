package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: reaction_context_items_row_limit */
public class QuickPromotionDefinition_ImageParametersDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4755a;

    static {
        GlobalAutoGenDeserializerCache.a(ImageParameters.class, new QuickPromotionDefinition_ImageParametersDeserializer());
        m4639e();
    }

    public QuickPromotionDefinition_ImageParametersDeserializer() {
        a(ImageParameters.class);
    }

    private static synchronized Map<String, FbJsonField> m4639e() {
        Map<String, FbJsonField> map;
        synchronized (QuickPromotionDefinition_ImageParametersDeserializer.class) {
            if (f4755a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("uri", FbJsonField.jsonField(ImageParameters.class.getDeclaredField("uri")));
                    builder.b("width", FbJsonField.jsonField(ImageParameters.class.getDeclaredField("width")));
                    builder.b("height", FbJsonField.jsonField(ImageParameters.class.getDeclaredField("height")));
                    builder.b("scale", FbJsonField.jsonField(ImageParameters.class.getDeclaredField("scale")));
                    builder.b("name", FbJsonField.jsonField(ImageParameters.class.getDeclaredField("name")));
                    f4755a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4755a;
        }
        return map;
    }

    public final FbJsonField m4640a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4639e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4639e().keySet());
    }
}
