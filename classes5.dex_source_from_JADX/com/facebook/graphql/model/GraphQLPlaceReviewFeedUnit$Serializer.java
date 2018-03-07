package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPlaceReviewFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WATERFALL */
public final class GraphQLPlaceReviewFeedUnit$Serializer extends JsonSerializer<GraphQLPlaceReviewFeedUnit> {
    public final void m20896a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) obj;
        GraphQLPlaceReviewFeedUnitDeserializer.m5665a(graphQLPlaceReviewFeedUnit.w_(), graphQLPlaceReviewFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceReviewFeedUnit.class, new GraphQLPlaceReviewFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPlaceReviewFeedUnit.class, new GraphQLPlaceReviewFeedUnit$Serializer());
    }
}
