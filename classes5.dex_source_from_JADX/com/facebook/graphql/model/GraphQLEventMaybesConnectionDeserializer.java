package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: payloads cannot be empty */
public class GraphQLEventMaybesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventMaybesConnection.class, new GraphQLEventMaybesConnectionDeserializer());
    }

    public GraphQLEventMaybesConnectionDeserializer() {
        a(GraphQLEventMaybesConnection.class);
    }

    public Object m7222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventMaybesConnection__JsonHelper.m7224a(jsonParser);
    }
}
