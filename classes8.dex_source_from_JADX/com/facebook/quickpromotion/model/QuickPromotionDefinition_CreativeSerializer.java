package com.facebook.quickpromotion.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reaction_core_component_image_sizes */
public class QuickPromotionDefinition_CreativeSerializer extends JsonSerializer<Creative> {
    public final void m4633a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Creative creative = (Creative) obj;
        if (creative == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4632b(creative, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(Creative.class, new QuickPromotionDefinition_CreativeSerializer());
    }

    private static void m4632b(Creative creative, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "title", creative.title);
        AutoGenJsonHelper.a(jsonGenerator, "content", creative.content);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "image", creative.imageParams);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "animated_image", creative.animatedImageParams);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "primary_action", creative.primaryAction);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "secondary_action", creative.secondaryAction);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "dismiss_action", creative.dismissAction);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "social_context", creative.socialContext);
        AutoGenJsonHelper.a(jsonGenerator, "footer", creative.footer);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "template", creative.template);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "template_parameters", creative.templateParameters);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "branding_image", creative.brandingImageParams);
    }
}
