package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMutualFriendsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: facebookSignInOptions */
public final class GraphQLMutualFriendsConnection$Serializer extends JsonSerializer<GraphQLMutualFriendsConnection> {
    public final void m9143a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMutualFriendsConnection graphQLMutualFriendsConnection = (GraphQLMutualFriendsConnection) obj;
        GraphQLMutualFriendsConnectionDeserializer.m5382a(graphQLMutualFriendsConnection.w_(), graphQLMutualFriendsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMutualFriendsConnection.class, new GraphQLMutualFriendsConnection$Serializer());
        FbSerializerProvider.a(GraphQLMutualFriendsConnection.class, new GraphQLMutualFriendsConnection$Serializer());
    }
}
