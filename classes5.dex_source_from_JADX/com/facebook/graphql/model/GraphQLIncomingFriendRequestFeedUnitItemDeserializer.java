package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ordinal */
public class GraphQLIncomingFriendRequestFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLIncomingFriendRequestFeedUnitItem.class, new GraphQLIncomingFriendRequestFeedUnitItemDeserializer());
    }

    public GraphQLIncomingFriendRequestFeedUnitItemDeserializer() {
        a(GraphQLIncomingFriendRequestFeedUnitItem.class);
    }

    public Object m8668a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLIncomingFriendRequestFeedUnitItem__JsonHelper.m8670a(jsonParser);
    }
}
