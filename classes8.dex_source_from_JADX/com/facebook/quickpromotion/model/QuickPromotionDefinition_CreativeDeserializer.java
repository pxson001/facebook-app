package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: reaction_critic_review_thumbnail_height */
public class QuickPromotionDefinition_CreativeDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4753a;

    static {
        GlobalAutoGenDeserializerCache.a(Creative.class, new QuickPromotionDefinition_CreativeDeserializer());
        m4630e();
    }

    public QuickPromotionDefinition_CreativeDeserializer() {
        a(Creative.class);
    }

    private static synchronized Map<String, FbJsonField> m4630e() {
        Map<String, FbJsonField> map;
        synchronized (QuickPromotionDefinition_CreativeDeserializer.class) {
            if (f4753a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("title", FbJsonField.jsonField(Creative.class.getDeclaredField("title")));
                    builder.b("content", FbJsonField.jsonField(Creative.class.getDeclaredField("content")));
                    builder.b("image", FbJsonField.jsonField(Creative.class.getDeclaredField("imageParams")));
                    builder.b("animated_image", FbJsonField.jsonField(Creative.class.getDeclaredField("animatedImageParams")));
                    builder.b("primary_action", FbJsonField.jsonField(Creative.class.getDeclaredField("primaryAction")));
                    builder.b("secondary_action", FbJsonField.jsonField(Creative.class.getDeclaredField("secondaryAction")));
                    builder.b("dismiss_action", FbJsonField.jsonField(Creative.class.getDeclaredField("dismissAction")));
                    builder.b("social_context", FbJsonField.jsonField(Creative.class.getDeclaredField("socialContext")));
                    builder.b("footer", FbJsonField.jsonField(Creative.class.getDeclaredField("footer")));
                    builder.b("template", FbJsonField.jsonFieldWithCreator(Creative.class.getDeclaredField("template")));
                    builder.b("template_parameters", FbJsonField.jsonField(Creative.class.getDeclaredField("templateParameters")));
                    builder.b("branding_image", FbJsonField.jsonField(Creative.class.getDeclaredField("brandingImageParams")));
                    f4753a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4753a;
        }
        return map;
    }

    public final FbJsonField m4631a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4630e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4630e().keySet());
    }
}
