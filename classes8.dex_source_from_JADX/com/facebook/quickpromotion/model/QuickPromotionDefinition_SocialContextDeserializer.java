package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.SocialContext;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: reaction_client_capabilities */
public class QuickPromotionDefinition_SocialContextDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4756a;

    static {
        GlobalAutoGenDeserializerCache.a(SocialContext.class, new QuickPromotionDefinition_SocialContextDeserializer());
        m4643e();
    }

    public QuickPromotionDefinition_SocialContextDeserializer() {
        a(SocialContext.class);
    }

    private static synchronized Map<String, FbJsonField> m4643e() {
        Map<String, FbJsonField> map;
        synchronized (QuickPromotionDefinition_SocialContextDeserializer.class) {
            if (f4756a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("text", FbJsonField.jsonField(SocialContext.class.getDeclaredField("text")));
                    builder.b("friend_ids", FbJsonField.jsonField(SocialContext.class.getDeclaredField("friendIds"), String.class));
                    f4756a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4756a;
        }
        return map;
    }

    public final FbJsonField m4644a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4643e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4643e().keySet());
    }
}
