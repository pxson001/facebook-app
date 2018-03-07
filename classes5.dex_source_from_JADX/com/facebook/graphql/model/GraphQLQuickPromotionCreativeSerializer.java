package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_PAGE_SERVICES */
public class GraphQLQuickPromotionCreativeSerializer extends JsonSerializer<GraphQLQuickPromotionCreative> {
    public final void m21229a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotionCreative__JsonHelper.m21231a(jsonGenerator, (GraphQLQuickPromotionCreative) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotionCreative.class, new GraphQLQuickPromotionCreativeSerializer());
    }
}
