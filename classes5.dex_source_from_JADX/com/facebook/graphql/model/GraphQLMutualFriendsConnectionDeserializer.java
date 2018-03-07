package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og_object_id */
public class GraphQLMutualFriendsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMutualFriendsConnection.class, new GraphQLMutualFriendsConnectionDeserializer());
    }

    public GraphQLMutualFriendsConnectionDeserializer() {
        a(GraphQLMutualFriendsConnection.class);
    }

    public Object m9144a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMutualFriendsConnection__JsonHelper.m9146a(jsonParser);
    }
}
