package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb_friends */
public class GraphQLEventDeclinesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventDeclinesEdge.class, new GraphQLEventDeclinesEdgeDeserializer());
    }

    public GraphQLEventDeclinesEdgeDeserializer() {
        a(GraphQLEventDeclinesEdge.class);
    }

    public Object m7181a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventDeclinesEdge__JsonHelper.m7183a(jsonParser);
    }
}
