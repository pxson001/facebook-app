package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFriendingPossibilitiesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_viewer_viewed */
public final class GraphQLFriendingPossibilitiesConnection$Serializer extends JsonSerializer<GraphQLFriendingPossibilitiesConnection> {
    public final void m7584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendingPossibilitiesConnection graphQLFriendingPossibilitiesConnection = (GraphQLFriendingPossibilitiesConnection) obj;
        GraphQLFriendingPossibilitiesConnectionDeserializer.m4941a(graphQLFriendingPossibilitiesConnection.w_(), graphQLFriendingPossibilitiesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendingPossibilitiesConnection.class, new GraphQLFriendingPossibilitiesConnection$Serializer());
        FbSerializerProvider.a(GraphQLFriendingPossibilitiesConnection.class, new GraphQLFriendingPossibilitiesConnection$Serializer());
    }
}
