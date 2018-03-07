package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_events_list_subscribe_button */
public class GraphQLGoodwillThrowbackFriendListEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFriendListEdge.class, new GraphQLGoodwillThrowbackFriendListEdgeDeserializer());
    }

    public GraphQLGoodwillThrowbackFriendListEdgeDeserializer() {
        a(GraphQLGoodwillThrowbackFriendListEdge.class);
    }

    public Object m8009a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackFriendListEdge__JsonHelper.m8011a(jsonParser);
    }
}
