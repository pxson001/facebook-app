package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: permanently_closed_status */
public class GraphQLDebugFeedEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLDebugFeedEdge.class, new GraphQLDebugFeedEdgeDeserializer());
    }

    public GraphQLDebugFeedEdgeDeserializer() {
        a(GraphQLDebugFeedEdge.class);
    }

    public Object m6938a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLDebugFeedEdge__JsonHelper.m6940a(jsonParser);
    }
}
