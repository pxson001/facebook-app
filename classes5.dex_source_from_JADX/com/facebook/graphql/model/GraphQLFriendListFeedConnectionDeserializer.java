package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_set_id */
public class GraphQLFriendListFeedConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendListFeedConnection.class, new GraphQLFriendListFeedConnectionDeserializer());
    }

    public GraphQLFriendListFeedConnectionDeserializer() {
        a(GraphQLFriendListFeedConnection.class);
    }

    public Object m7547a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendListFeedConnection__JsonHelper.m7549a(jsonParser);
    }
}
