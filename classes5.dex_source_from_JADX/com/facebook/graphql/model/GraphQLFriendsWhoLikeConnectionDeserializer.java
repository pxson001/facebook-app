package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_photos_social_context */
public class GraphQLFriendsWhoLikeConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsWhoLikeConnection.class, new GraphQLFriendsWhoLikeConnectionDeserializer());
    }

    public GraphQLFriendsWhoLikeConnectionDeserializer() {
        a(GraphQLFriendsWhoLikeConnection.class);
    }

    public Object m7639a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendsWhoLikeConnection__JsonHelper.m7641a(jsonParser);
    }
}
