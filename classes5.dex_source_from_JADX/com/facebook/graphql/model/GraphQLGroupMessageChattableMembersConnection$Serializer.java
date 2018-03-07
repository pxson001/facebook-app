package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGroupMessageChattableMembersConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_center_friends */
public final class GraphQLGroupMessageChattableMembersConnection$Serializer extends JsonSerializer<GraphQLGroupMessageChattableMembersConnection> {
    public final void m8472a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMessageChattableMembersConnection graphQLGroupMessageChattableMembersConnection = (GraphQLGroupMessageChattableMembersConnection) obj;
        GraphQLGroupMessageChattableMembersConnectionDeserializer.m5178a(graphQLGroupMessageChattableMembersConnection.w_(), graphQLGroupMessageChattableMembersConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMessageChattableMembersConnection.class, new GraphQLGroupMessageChattableMembersConnection$Serializer());
        FbSerializerProvider.a(GraphQLGroupMessageChattableMembersConnection.class, new GraphQLGroupMessageChattableMembersConnection$Serializer());
    }
}
