package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getRecentLogFiles */
public final class GraphQLGoodwillThrowbackPromotionFeedUnit$Serializer extends JsonSerializer<GraphQLGoodwillThrowbackPromotionFeedUnit> {
    public final void m8099a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer.m5067a(graphQLGoodwillThrowbackPromotionFeedUnit.w_(), graphQLGoodwillThrowbackPromotionFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotionFeedUnit.class, new GraphQLGoodwillThrowbackPromotionFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotionFeedUnit.class, new GraphQLGoodwillThrowbackPromotionFeedUnit$Serializer());
    }
}
