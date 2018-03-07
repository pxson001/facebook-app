package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb_friends_tl */
public class GraphQLEventDeclinesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventDeclinesConnection.class, new GraphQLEventDeclinesConnectionDeserializer());
    }

    public GraphQLEventDeclinesConnectionDeserializer() {
        a(GraphQLEventDeclinesConnection.class);
    }

    public Object m7167a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventDeclinesConnection__JsonHelper.m7169a(jsonParser);
    }
}
