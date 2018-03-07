package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WATER_PARK */
public class GraphQLPlaceRecommendationPostInfoSerializer extends JsonSerializer<GraphQLPlaceRecommendationPostInfo> {
    public final void m20892a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceRecommendationPostInfo__JsonHelper.m20894a(jsonGenerator, (GraphQLPlaceRecommendationPostInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceRecommendationPostInfo.class, new GraphQLPlaceRecommendationPostInfoSerializer());
    }
}
