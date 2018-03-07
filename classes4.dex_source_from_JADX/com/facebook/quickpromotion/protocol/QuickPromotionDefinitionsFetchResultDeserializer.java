package com.facebook.quickpromotion.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: request_info */
public class QuickPromotionDefinitionsFetchResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3442a;

    static {
        GlobalAutoGenDeserializerCache.a(QuickPromotionDefinitionsFetchResult.class, new QuickPromotionDefinitionsFetchResultDeserializer());
        m3663e();
    }

    public QuickPromotionDefinitionsFetchResultDeserializer() {
        a(QuickPromotionDefinitionsFetchResult.class);
    }

    private static synchronized Map<String, FbJsonField> m3663e() {
        Map<String, FbJsonField> map;
        synchronized (QuickPromotionDefinitionsFetchResultDeserializer.class) {
            if (f3442a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("promotions", FbJsonField.jsonField(QuickPromotionDefinitionsFetchResult.class.getDeclaredField("mQuickPromotionDefinitions"), QuickPromotionDefinition.class));
                    f3442a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3442a;
        }
        return map;
    }

    public final FbJsonField m3664a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m3663e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m3663e().keySet());
    }
}
