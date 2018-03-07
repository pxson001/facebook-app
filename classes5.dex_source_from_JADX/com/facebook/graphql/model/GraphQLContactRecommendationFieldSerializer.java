package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isEnabled */
public class GraphQLContactRecommendationFieldSerializer extends JsonSerializer<GraphQLContactRecommendationField> {
    public final void m6879a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLContactRecommendationField__JsonHelper.m6881a(jsonGenerator, (GraphQLContactRecommendationField) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLContactRecommendationField.class, new GraphQLContactRecommendationFieldSerializer());
    }
}
