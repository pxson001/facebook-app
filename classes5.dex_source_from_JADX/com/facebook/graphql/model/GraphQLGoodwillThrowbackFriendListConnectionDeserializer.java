package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_fbid */
public class GraphQLGoodwillThrowbackFriendListConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFriendListConnection.class, new GraphQLGoodwillThrowbackFriendListConnectionDeserializer());
    }

    public GraphQLGoodwillThrowbackFriendListConnectionDeserializer() {
        a(GraphQLGoodwillThrowbackFriendListConnection.class);
    }

    public Object m7999a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackFriendListConnection__JsonHelper.m8001a(jsonParser);
    }
}
