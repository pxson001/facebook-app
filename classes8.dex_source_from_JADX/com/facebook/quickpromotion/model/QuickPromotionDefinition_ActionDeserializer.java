package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: reaction_facepile_profile_pic_size */
public class QuickPromotionDefinition_ActionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4751a;

    static {
        GlobalAutoGenDeserializerCache.a(Action.class, new QuickPromotionDefinition_ActionDeserializer());
        m4619e();
    }

    public QuickPromotionDefinition_ActionDeserializer() {
        a(Action.class);
    }

    private static synchronized Map<String, FbJsonField> m4619e() {
        Map<String, FbJsonField> map;
        synchronized (QuickPromotionDefinition_ActionDeserializer.class) {
            if (f4751a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("style", FbJsonField.jsonFieldWithCreator(Action.class.getDeclaredField("style")));
                    builder.b("title", FbJsonField.jsonField(Action.class.getDeclaredField("title")));
                    builder.b("url", FbJsonField.jsonField(Action.class.getDeclaredField("url")));
                    builder.b("limit", FbJsonField.jsonField(Action.class.getDeclaredField("limit")));
                    builder.b("dismiss_promotion", FbJsonField.jsonField(Action.class.getDeclaredField("dismissPromotion")));
                    f4751a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4751a;
        }
        return map;
    }

    public final FbJsonField m4620a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4619e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4619e().keySet());
    }
}
