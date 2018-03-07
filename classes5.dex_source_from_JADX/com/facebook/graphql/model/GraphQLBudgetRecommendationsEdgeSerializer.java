package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_group_mall_ad */
public class GraphQLBudgetRecommendationsEdgeSerializer extends JsonSerializer<GraphQLBudgetRecommendationsEdge> {
    public final void m6698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBudgetRecommendationsEdge__JsonHelper.m6700a(jsonGenerator, (GraphQLBudgetRecommendationsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLBudgetRecommendationsEdge.class, new GraphQLBudgetRecommendationsEdgeSerializer());
    }
}
