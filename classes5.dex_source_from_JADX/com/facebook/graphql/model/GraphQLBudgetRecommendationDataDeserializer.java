package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: phrase_offset */
public class GraphQLBudgetRecommendationDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBudgetRecommendationData.class, new GraphQLBudgetRecommendationDataDeserializer());
    }

    public GraphQLBudgetRecommendationDataDeserializer() {
        a(GraphQLBudgetRecommendationData.class);
    }

    public Object m6674a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLBudgetRecommendationData__JsonHelper.m6676a(jsonParser);
    }
}
