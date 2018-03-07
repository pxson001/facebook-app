package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: new_rotation */
public class GraphQLPhrasesAnalysisItemsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhrasesAnalysisItemsEdge.class, new GraphQLPhrasesAnalysisItemsEdgeDeserializer());
    }

    public GraphQLPhrasesAnalysisItemsEdgeDeserializer() {
        a(GraphQLPhrasesAnalysisItemsEdge.class);
    }

    public Object m20823a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhrasesAnalysisItemsEdge__JsonHelper.m20825a(jsonParser);
    }
}
