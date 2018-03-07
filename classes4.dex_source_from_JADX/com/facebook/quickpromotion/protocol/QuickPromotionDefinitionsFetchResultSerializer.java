package com.facebook.quickpromotion.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: recipient_name */
public class QuickPromotionDefinitionsFetchResultSerializer extends JsonSerializer<QuickPromotionDefinitionsFetchResult> {
    public final void m3956a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        QuickPromotionDefinitionsFetchResult quickPromotionDefinitionsFetchResult = (QuickPromotionDefinitionsFetchResult) obj;
        if (quickPromotionDefinitionsFetchResult == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3955b(quickPromotionDefinitionsFetchResult, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(QuickPromotionDefinitionsFetchResult.class, new QuickPromotionDefinitionsFetchResultSerializer());
    }

    private static void m3955b(QuickPromotionDefinitionsFetchResult quickPromotionDefinitionsFetchResult, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10226a(jsonGenerator, serializerProvider, "promotions", quickPromotionDefinitionsFetchResult.mQuickPromotionDefinitions);
    }
}
