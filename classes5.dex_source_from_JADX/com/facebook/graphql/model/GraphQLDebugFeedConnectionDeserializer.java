package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: persist_id */
public class GraphQLDebugFeedConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLDebugFeedConnection.class, new GraphQLDebugFeedConnectionDeserializer());
    }

    public GraphQLDebugFeedConnectionDeserializer() {
        a(GraphQLDebugFeedConnection.class);
    }

    public Object m6932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLDebugFeedConnection__JsonHelper.m6934a(jsonParser);
    }
}
