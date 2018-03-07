package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_service */
public class GraphQLFriendListFeedEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendListFeedEdge.class, new GraphQLFriendListFeedEdgeDeserializer());
    }

    public GraphQLFriendListFeedEdgeDeserializer() {
        a(GraphQLFriendListFeedEdge.class);
    }

    public Object m7558a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendListFeedEdge__JsonHelper.m7560a(jsonParser);
    }
}
