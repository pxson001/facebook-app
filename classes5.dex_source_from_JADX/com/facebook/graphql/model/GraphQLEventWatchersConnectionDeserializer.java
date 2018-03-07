package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parentBundle */
public class GraphQLEventWatchersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventWatchersConnection.class, new GraphQLEventWatchersConnectionDeserializer());
    }

    public GraphQLEventWatchersConnectionDeserializer() {
        a(GraphQLEventWatchersConnection.class);
    }

    public Object m7330a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventWatchersConnection__JsonHelper.m7332a(jsonParser);
    }
}
