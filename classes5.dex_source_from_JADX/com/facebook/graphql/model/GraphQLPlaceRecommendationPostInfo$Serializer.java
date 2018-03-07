package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPlaceRecommendationPostInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEAKLYENGAGED_BY_YOUR_FRIENDS */
public final class GraphQLPlaceRecommendationPostInfo$Serializer extends JsonSerializer<GraphQLPlaceRecommendationPostInfo> {
    public final void m20890a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceRecommendationPostInfo graphQLPlaceRecommendationPostInfo = (GraphQLPlaceRecommendationPostInfo) obj;
        GraphQLPlaceRecommendationPostInfoDeserializer.m5662a(graphQLPlaceRecommendationPostInfo.w_(), graphQLPlaceRecommendationPostInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceRecommendationPostInfo.class, new GraphQLPlaceRecommendationPostInfo$Serializer());
        FbSerializerProvider.a(GraphQLPlaceRecommendationPostInfo.class, new GraphQLPlaceRecommendationPostInfo$Serializer());
    }
}
