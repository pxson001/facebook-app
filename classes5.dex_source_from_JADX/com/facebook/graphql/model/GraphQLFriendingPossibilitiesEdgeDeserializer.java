package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_rating */
public class GraphQLFriendingPossibilitiesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendingPossibilitiesEdge.class, new GraphQLFriendingPossibilitiesEdgeDeserializer());
    }

    public GraphQLFriendingPossibilitiesEdgeDeserializer() {
        a(GraphQLFriendingPossibilitiesEdge.class);
    }

    public Object m7599a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendingPossibilitiesEdge__JsonHelper.m7601a(jsonParser);
    }
}
