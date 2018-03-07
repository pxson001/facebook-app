package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: people_you_may_know */
public class GraphQLEmotionalAnalysisDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEmotionalAnalysis.class, new GraphQLEmotionalAnalysisDeserializer());
    }

    public GraphQLEmotionalAnalysisDeserializer() {
        a(GraphQLEmotionalAnalysis.class);
    }

    public Object m7003a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEmotionalAnalysis__JsonHelper.m7035a(jsonParser);
    }
}
