package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: reaction_dialog_photos */
public class QuickPromotionDefinition_ContextualFilterDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4752a;

    static {
        GlobalAutoGenDeserializerCache.a(ContextualFilter.class, new QuickPromotionDefinition_ContextualFilterDeserializer());
        m4625e();
    }

    public QuickPromotionDefinition_ContextualFilterDeserializer() {
        a(ContextualFilter.class);
    }

    private static synchronized Map<String, FbJsonField> m4625e() {
        Map<String, FbJsonField> map;
        synchronized (QuickPromotionDefinition_ContextualFilterDeserializer.class) {
            if (f4752a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonFieldWithCreator(ContextualFilter.class.getDeclaredField("type")));
                    builder.b("passes_if_not_client_supported", FbJsonField.jsonField(ContextualFilter.class.getDeclaredField("passIfNotSupported")));
                    builder.b("value", FbJsonField.jsonField(ContextualFilter.class.getDeclaredField("value")));
                    builder.b("extra_data", FbJsonField.jsonField(ContextualFilter.class.getDeclaredField("extraData")));
                    f4752a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4752a;
        }
        return map;
    }

    public final FbJsonField m4626a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4625e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4625e().keySet());
    }
}
