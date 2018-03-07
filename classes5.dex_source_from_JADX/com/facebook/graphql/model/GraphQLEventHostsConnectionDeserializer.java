package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb */
public class GraphQLEventHostsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventHostsConnection.class, new GraphQLEventHostsConnectionDeserializer());
    }

    public GraphQLEventHostsConnectionDeserializer() {
        a(GraphQLEventHostsConnection.class);
    }

    public Object m7189a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventHostsConnection__JsonHelper.m7191a(jsonParser);
    }
}
