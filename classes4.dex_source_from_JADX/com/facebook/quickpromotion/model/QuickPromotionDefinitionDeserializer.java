package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Attribute;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: request_count */
public class QuickPromotionDefinitionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3445a;

    static {
        GlobalAutoGenDeserializerCache.a(QuickPromotionDefinition.class, new QuickPromotionDefinitionDeserializer());
        m3675e();
    }

    public QuickPromotionDefinitionDeserializer() {
        a(QuickPromotionDefinition.class);
    }

    private static synchronized Map<String, FbJsonField> m3675e() {
        Map<String, FbJsonField> map;
        synchronized (QuickPromotionDefinitionDeserializer.class) {
            if (f3445a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("promotion_id", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("promotionId")));
                    builder.b("triggers", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("triggers"), InterstitialTrigger.class));
                    builder.b("creatives", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("creatives"), Creative.class));
                    builder.b("contextual_filters", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("filters"), ContextualFilter.class));
                    builder.b("boolean_filter_root", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("booleanFilter")));
                    builder.b("title", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("title")));
                    builder.b("content", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("content")));
                    builder.b("image", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("imageParams")));
                    builder.b("animated_image", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("animatedImageParams")));
                    builder.b("primary_action", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("primaryAction")));
                    builder.b("secondary_action", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("secondaryAction")));
                    builder.b("dismiss_action", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("dismissAction")));
                    builder.b("social_context", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("socialContext")));
                    builder.b("footer", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("footer")));
                    builder.b("template", FbJsonField.jsonFieldWithCreator(QuickPromotionDefinition.class.getDeclaredField("template")));
                    builder.b("template_parameters", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("templateParameters")));
                    builder.b("priority", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("priority")));
                    builder.b("max_impressions", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("maxImpressions")));
                    builder.b("viewer_impressions", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("viewerImpressions")));
                    builder.b("start_time", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("startTime")));
                    builder.b("end_time", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("endTime")));
                    builder.b("client_ttl_seconds", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("clientTtlSeconds")));
                    builder.b("instance_log_data", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("instanceLogData")));
                    builder.b("is_exposure_holdout", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("isExposureHoldout")));
                    builder.b("log_eligibility_waterfall", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("logEligibilityWaterfall")));
                    builder.b("branding_image", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredField("brandingImageParams")));
                    builder.b("custom_renderer_type", FbJsonField.jsonFieldWithCreator(QuickPromotionDefinition.class.getDeclaredField("customRenderType")));
                    builder.b("attributes", FbJsonField.jsonField(QuickPromotionDefinition.class.getDeclaredMethod("readAttributes", new Class[]{List.class}), Attribute.class));
                    f3445a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3445a;
        }
        return map;
    }

    public final FbJsonField m3676a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m3675e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m3675e().keySet());
    }
}
