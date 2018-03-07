package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: passive */
public class GraphQLEventMaybesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventMaybesEdge.class, new GraphQLEventMaybesEdgeDeserializer());
    }

    public GraphQLEventMaybesEdgeDeserializer() {
        a(GraphQLEventMaybesEdge.class);
    }

    public Object m7235a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventMaybesEdge__JsonHelper.m7237a(jsonParser);
    }
}
