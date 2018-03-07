package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: newsstand_suggestion */
public class GraphQLPhrasesAnalysisItemsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhrasesAnalysisItemsConnection.class, new GraphQLPhrasesAnalysisItemsConnectionDeserializer());
    }

    public GraphQLPhrasesAnalysisItemsConnectionDeserializer() {
        a(GraphQLPhrasesAnalysisItemsConnection.class);
    }

    public Object m20814a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhrasesAnalysisItemsConnection__JsonHelper.m20816a(jsonParser);
    }
}
