package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFriendsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_photo_menus */
public final class GraphQLFriendsConnection$Serializer extends JsonSerializer<GraphQLFriendsConnection> {
    public final void m7605a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsConnection graphQLFriendsConnection = (GraphQLFriendsConnection) obj;
        GraphQLFriendsConnectionDeserializer.m4947a(graphQLFriendsConnection.w_(), graphQLFriendsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsConnection.class, new GraphQLFriendsConnection$Serializer());
        FbSerializerProvider.a(GraphQLFriendsConnection.class, new GraphQLFriendsConnection$Serializer());
    }
}
