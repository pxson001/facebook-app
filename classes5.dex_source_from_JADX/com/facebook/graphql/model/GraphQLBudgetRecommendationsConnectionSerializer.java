package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_in_experiment */
public class GraphQLBudgetRecommendationsConnectionSerializer extends JsonSerializer<GraphQLBudgetRecommendationsConnection> {
    public final void m6687a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBudgetRecommendationsConnection__JsonHelper.m6689a(jsonGenerator, (GraphQLBudgetRecommendationsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLBudgetRecommendationsConnection.class, new GraphQLBudgetRecommendationsConnectionSerializer());
    }
}
