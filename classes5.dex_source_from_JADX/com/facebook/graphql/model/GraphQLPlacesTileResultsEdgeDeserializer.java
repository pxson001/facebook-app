package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_pymk */
public class GraphQLPlacesTileResultsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlacesTileResultsEdge.class, new GraphQLPlacesTileResultsEdgeDeserializer());
    }

    public GraphQLPlacesTileResultsEdgeDeserializer() {
        a(GraphQLPlacesTileResultsEdge.class);
    }

    public Object m20940a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlacesTileResultsEdge__JsonHelper.m20942a(jsonParser);
    }
}
