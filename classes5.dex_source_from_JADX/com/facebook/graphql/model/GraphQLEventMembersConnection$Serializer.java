package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventMembersConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: in_progress */
public final class GraphQLEventMembersConnection$Serializer extends JsonSerializer<GraphQLEventMembersConnection> {
    public final void m7242a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventMembersConnection graphQLEventMembersConnection = (GraphQLEventMembersConnection) obj;
        GraphQLEventMembersConnectionDeserializer.m4819a(graphQLEventMembersConnection.w_(), graphQLEventMembersConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventMembersConnection.class, new GraphQLEventMembersConnection$Serializer());
        FbSerializerProvider.a(GraphQLEventMembersConnection.class, new GraphQLEventMembersConnection$Serializer());
    }
}
