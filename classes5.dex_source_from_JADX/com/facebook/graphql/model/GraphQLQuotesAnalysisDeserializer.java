package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nearby_dash */
public class GraphQLQuotesAnalysisDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuotesAnalysis.class, new GraphQLQuotesAnalysisDeserializer());
    }

    public GraphQLQuotesAnalysisDeserializer() {
        a(GraphQLQuotesAnalysis.class);
    }

    public Object m21271a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuotesAnalysis__JsonHelper.m21302a(jsonParser);
    }
}
