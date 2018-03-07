package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_likely_to_advertise */
public class GraphQLBudgetRecommendationDataSerializer extends JsonSerializer<GraphQLBudgetRecommendationData> {
    public final void m6675a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBudgetRecommendationData__JsonHelper.m6677a(jsonGenerator, (GraphQLBudgetRecommendationData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLBudgetRecommendationData.class, new GraphQLBudgetRecommendationDataSerializer());
    }
}
