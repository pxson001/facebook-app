package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGreetingCardPromotionFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fullLatestVersion */
public final class GraphQLGreetingCardPromotionFeedUnit$Serializer extends JsonSerializer<GraphQLGreetingCardPromotionFeedUnit> {
    public final void m8326a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardPromotionFeedUnit graphQLGreetingCardPromotionFeedUnit = (GraphQLGreetingCardPromotionFeedUnit) obj;
        GraphQLGreetingCardPromotionFeedUnitDeserializer.m5126a(graphQLGreetingCardPromotionFeedUnit.w_(), graphQLGreetingCardPromotionFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardPromotionFeedUnit.class, new GraphQLGreetingCardPromotionFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLGreetingCardPromotionFeedUnit.class, new GraphQLGreetingCardPromotionFeedUnit$Serializer());
    }
}
