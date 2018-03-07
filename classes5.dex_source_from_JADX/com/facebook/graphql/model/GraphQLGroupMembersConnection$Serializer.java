package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGroupMembersConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_description */
public final class GraphQLGroupMembersConnection$Serializer extends JsonSerializer<GraphQLGroupMembersConnection> {
    public final void m8455a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMembersConnection graphQLGroupMembersConnection = (GraphQLGroupMembersConnection) obj;
        GraphQLGroupMembersConnectionDeserializer.m5171a(graphQLGroupMembersConnection.w_(), graphQLGroupMembersConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMembersConnection.class, new GraphQLGroupMembersConnection$Serializer());
        FbSerializerProvider.a(GraphQLGroupMembersConnection.class, new GraphQLGroupMembersConnection$Serializer());
    }
}
