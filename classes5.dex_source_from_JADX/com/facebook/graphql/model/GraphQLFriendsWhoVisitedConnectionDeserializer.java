package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_photos_of_friends_at_place_page_surface */
public class GraphQLFriendsWhoVisitedConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsWhoVisitedConnection.class, new GraphQLFriendsWhoVisitedConnectionDeserializer());
    }

    public GraphQLFriendsWhoVisitedConnectionDeserializer() {
        a(GraphQLFriendsWhoVisitedConnection.class);
    }

    public Object m7645a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendsWhoVisitedConnection__JsonHelper.m7647a(jsonParser);
    }
}
