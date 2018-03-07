package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFriendsWhoLikeConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_ad_conversion_pixel_domain */
public final class GraphQLFriendsWhoLikeConnection$Serializer extends JsonSerializer<GraphQLFriendsWhoLikeConnection> {
    public final void m7638a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsWhoLikeConnection graphQLFriendsWhoLikeConnection = (GraphQLFriendsWhoLikeConnection) obj;
        GraphQLFriendsWhoLikeConnectionDeserializer.m4961a(graphQLFriendsWhoLikeConnection.w_(), graphQLFriendsWhoLikeConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsWhoLikeConnection.class, new GraphQLFriendsWhoLikeConnection$Serializer());
        FbSerializerProvider.a(GraphQLFriendsWhoLikeConnection.class, new GraphQLFriendsWhoLikeConnection$Serializer());
    }
}
