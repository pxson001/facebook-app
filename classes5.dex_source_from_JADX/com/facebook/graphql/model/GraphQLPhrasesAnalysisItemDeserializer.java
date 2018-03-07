package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: next_page */
public class GraphQLPhrasesAnalysisItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhrasesAnalysisItem.class, new GraphQLPhrasesAnalysisItemDeserializer());
    }

    public GraphQLPhrasesAnalysisItemDeserializer() {
        a(GraphQLPhrasesAnalysisItem.class);
    }

    public Object m20805a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhrasesAnalysisItem__JsonHelper.m20807a(jsonParser);
    }
}
