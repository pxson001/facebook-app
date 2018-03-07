package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_scheduled_deletion_time */
public class GraphQLFriendLocationFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendLocationFeedUnitItem.class, new GraphQLFriendLocationFeedUnitItemDeserializer());
    }

    public GraphQLFriendLocationFeedUnitItemDeserializer() {
        a(GraphQLFriendLocationFeedUnitItem.class);
    }

    public Object m7578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendLocationFeedUnitItem__JsonHelper.m7580a(jsonParser);
    }
}
