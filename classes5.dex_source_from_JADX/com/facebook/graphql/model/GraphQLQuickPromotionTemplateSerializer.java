package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_MENU */
public class GraphQLQuickPromotionTemplateSerializer extends JsonSerializer<GraphQLQuickPromotionTemplate> {
    public final void m21263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotionTemplate__JsonHelper.m21265a(jsonGenerator, (GraphQLQuickPromotionTemplate) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotionTemplate.class, new GraphQLQuickPromotionTemplateSerializer());
    }
}
