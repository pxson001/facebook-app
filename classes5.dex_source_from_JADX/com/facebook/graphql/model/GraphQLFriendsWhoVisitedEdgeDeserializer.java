package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_photos_hscrollable_albums */
public class GraphQLFriendsWhoVisitedEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsWhoVisitedEdge.class, new GraphQLFriendsWhoVisitedEdgeDeserializer());
    }

    public GraphQLFriendsWhoVisitedEdgeDeserializer() {
        a(GraphQLFriendsWhoVisitedEdge.class);
    }

    public Object m7654a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendsWhoVisitedEdge__JsonHelper.m7656a(jsonParser);
    }
}
