package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: phrase */
public class GraphQLBudgetRecommendationsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBudgetRecommendationsEdge.class, new GraphQLBudgetRecommendationsEdgeDeserializer());
    }

    public GraphQLBudgetRecommendationsEdgeDeserializer() {
        a(GraphQLBudgetRecommendationsEdge.class);
    }

    public Object m6697a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLBudgetRecommendationsEdge__JsonHelper.m6699a(jsonParser);
    }
}
