package com.facebook.quickpromotion.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.SocialContext;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reaction_attachments_closed */
public class QuickPromotionDefinition_SocialContextSerializer extends JsonSerializer<SocialContext> {
    public final void m4646a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SocialContext socialContext = (SocialContext) obj;
        if (socialContext == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4645b(socialContext, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SocialContext.class, new QuickPromotionDefinition_SocialContextSerializer());
    }

    private static void m4645b(SocialContext socialContext, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "text", socialContext.text);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "friend_ids", socialContext.friendIds);
    }
}
