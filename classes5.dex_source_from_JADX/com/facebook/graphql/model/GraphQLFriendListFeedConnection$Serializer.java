package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFriendListFeedConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hc_reminder_birthday */
public final class GraphQLFriendListFeedConnection$Serializer extends JsonSerializer<GraphQLFriendListFeedConnection> {
    public final void m7546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendListFeedConnection graphQLFriendListFeedConnection = (GraphQLFriendListFeedConnection) obj;
        GraphQLFriendListFeedConnectionDeserializer.m4930a(graphQLFriendListFeedConnection.w_(), graphQLFriendListFeedConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendListFeedConnection.class, new GraphQLFriendListFeedConnection$Serializer());
        FbSerializerProvider.a(GraphQLFriendListFeedConnection.class, new GraphQLFriendListFeedConnection$Serializer());
    }
}
