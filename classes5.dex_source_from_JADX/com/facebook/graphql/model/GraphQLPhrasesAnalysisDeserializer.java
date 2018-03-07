package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: next_question */
public class GraphQLPhrasesAnalysisDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhrasesAnalysis.class, new GraphQLPhrasesAnalysisDeserializer());
    }

    public GraphQLPhrasesAnalysisDeserializer() {
        a(GraphQLPhrasesAnalysis.class);
    }

    public Object m20788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhrasesAnalysis__JsonHelper.m20828a(jsonParser);
    }
}
