package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventInviteesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: inheritableThreadLocals */
public final class GraphQLEventInviteesConnection$Serializer extends JsonSerializer<GraphQLEventInviteesConnection> {
    public final void m7203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventInviteesConnection graphQLEventInviteesConnection = (GraphQLEventInviteesConnection) obj;
        GraphQLEventInviteesConnectionDeserializer.m4805a(graphQLEventInviteesConnection.w_(), graphQLEventInviteesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventInviteesConnection.class, new GraphQLEventInviteesConnection$Serializer());
        FbSerializerProvider.a(GraphQLEventInviteesConnection.class, new GraphQLEventInviteesConnection$Serializer());
    }
}
