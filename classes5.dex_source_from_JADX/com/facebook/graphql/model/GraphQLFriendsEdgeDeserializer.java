package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_profile */
public class GraphQLFriendsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsEdge.class, new GraphQLFriendsEdgeDeserializer());
    }

    public GraphQLFriendsEdgeDeserializer() {
        a(GraphQLFriendsEdge.class);
    }

    public Object m7617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendsEdge__JsonHelper.m7619a(jsonParser);
    }
}
