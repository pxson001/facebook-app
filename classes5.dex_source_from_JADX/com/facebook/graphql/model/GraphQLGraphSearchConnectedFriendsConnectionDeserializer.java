package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_aymt_megaphone */
public class GraphQLGraphSearchConnectedFriendsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchConnectedFriendsConnection.class, new GraphQLGraphSearchConnectedFriendsConnectionDeserializer());
    }

    public GraphQLGraphSearchConnectedFriendsConnectionDeserializer() {
        a(GraphQLGraphSearchConnectedFriendsConnection.class);
    }

    public Object m8144a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchConnectedFriendsConnection__JsonHelper.m8146a(jsonParser);
    }
}
