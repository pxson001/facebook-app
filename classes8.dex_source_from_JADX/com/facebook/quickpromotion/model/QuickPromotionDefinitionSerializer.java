package com.facebook.quickpromotion.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reaction_fetch */
public class QuickPromotionDefinitionSerializer extends JsonSerializer<QuickPromotionDefinition> {
    public final void m4618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        QuickPromotionDefinition quickPromotionDefinition = (QuickPromotionDefinition) obj;
        if (quickPromotionDefinition == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4617b(quickPromotionDefinition, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(QuickPromotionDefinition.class, new QuickPromotionDefinitionSerializer());
    }

    private static void m4617b(QuickPromotionDefinition quickPromotionDefinition, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "promotion_id", quickPromotionDefinition.promotionId);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "triggers", quickPromotionDefinition.a());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "creatives", quickPromotionDefinition.creatives);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "contextual_filters", quickPromotionDefinition.d());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "boolean_filter_root", quickPromotionDefinition.booleanFilter);
        AutoGenJsonHelper.a(jsonGenerator, "title", quickPromotionDefinition.title);
        AutoGenJsonHelper.a(jsonGenerator, "content", quickPromotionDefinition.content);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "image", quickPromotionDefinition.imageParams);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "animated_image", quickPromotionDefinition.animatedImageParams);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "primary_action", quickPromotionDefinition.primaryAction);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "secondary_action", quickPromotionDefinition.secondaryAction);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "dismiss_action", quickPromotionDefinition.dismissAction);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "social_context", quickPromotionDefinition.socialContext);
        AutoGenJsonHelper.a(jsonGenerator, "footer", quickPromotionDefinition.footer);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "template", quickPromotionDefinition.e());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "template_parameters", quickPromotionDefinition.templateParameters);
        AutoGenJsonHelper.a(jsonGenerator, "priority", Long.valueOf(quickPromotionDefinition.priority));
        AutoGenJsonHelper.a(jsonGenerator, "max_impressions", Integer.valueOf(quickPromotionDefinition.maxImpressions));
        AutoGenJsonHelper.a(jsonGenerator, "viewer_impressions", Integer.valueOf(quickPromotionDefinition.viewerImpressions));
        AutoGenJsonHelper.a(jsonGenerator, "start_time", Long.valueOf(quickPromotionDefinition.startTime));
        AutoGenJsonHelper.a(jsonGenerator, "end_time", Long.valueOf(quickPromotionDefinition.endTime));
        AutoGenJsonHelper.a(jsonGenerator, "client_ttl_seconds", Long.valueOf(quickPromotionDefinition.clientTtlSeconds));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "instance_log_data", quickPromotionDefinition.instanceLogData);
        AutoGenJsonHelper.a(jsonGenerator, "is_exposure_holdout", Boolean.valueOf(quickPromotionDefinition.isExposureHoldout));
        AutoGenJsonHelper.a(jsonGenerator, "log_eligibility_waterfall", Boolean.valueOf(quickPromotionDefinition.logEligibilityWaterfall));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "branding_image", quickPromotionDefinition.brandingImageParams);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "custom_renderer_type", quickPromotionDefinition.customRenderType);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "attributes", quickPromotionDefinition.getAttributesList());
    }
}
