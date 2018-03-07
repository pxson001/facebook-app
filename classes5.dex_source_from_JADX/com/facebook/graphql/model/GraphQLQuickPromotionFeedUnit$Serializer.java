package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLQuickPromotionFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_PAGE_NOTIFICATION_STORY */
public final class GraphQLQuickPromotionFeedUnit$Serializer extends JsonSerializer<GraphQLQuickPromotionFeedUnit> {
    public final void m21234a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) obj;
        GraphQLQuickPromotionFeedUnitDeserializer.m5754a(graphQLQuickPromotionFeedUnit.w_(), graphQLQuickPromotionFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotionFeedUnit.class, new GraphQLQuickPromotionFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLQuickPromotionFeedUnit.class, new GraphQLQuickPromotionFeedUnit$Serializer());
    }
}
