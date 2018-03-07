package com.facebook.quickpromotion.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reaction_context_items_source_id */
public class QuickPromotionDefinition_FilterClauseSerializer extends JsonSerializer<QuickPromotionDefinition$FilterClause> {
    public final void m4637a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        QuickPromotionDefinition$FilterClause quickPromotionDefinition$FilterClause = (QuickPromotionDefinition$FilterClause) obj;
        if (quickPromotionDefinition$FilterClause == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4636b(quickPromotionDefinition$FilterClause, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(QuickPromotionDefinition$FilterClause.class, new QuickPromotionDefinition_FilterClauseSerializer());
    }

    private static void m4636b(QuickPromotionDefinition$FilterClause quickPromotionDefinition$FilterClause, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "type", quickPromotionDefinition$FilterClause.type);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "filters", quickPromotionDefinition$FilterClause.filters);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "clauses", quickPromotionDefinition$FilterClause.clauses);
    }
}
