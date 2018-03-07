package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: phrase_length */
public class GraphQLBudgetRecommendationsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBudgetRecommendationsConnection.class, new GraphQLBudgetRecommendationsConnectionDeserializer());
    }

    public GraphQLBudgetRecommendationsConnectionDeserializer() {
        a(GraphQLBudgetRecommendationsConnection.class);
    }

    public Object m6686a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLBudgetRecommendationsConnection__JsonHelper.m6688a(jsonParser);
    }
}
