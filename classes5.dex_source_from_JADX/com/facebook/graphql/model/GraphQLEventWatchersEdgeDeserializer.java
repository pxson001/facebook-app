package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parameters */
public class GraphQLEventWatchersEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventWatchersEdge.class, new GraphQLEventWatchersEdgeDeserializer());
    }

    public GraphQLEventWatchersEdgeDeserializer() {
        a(GraphQLEventWatchersEdge.class);
    }

    public Object m7340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventWatchersEdge__JsonHelper.m7342a(jsonParser);
    }
}
