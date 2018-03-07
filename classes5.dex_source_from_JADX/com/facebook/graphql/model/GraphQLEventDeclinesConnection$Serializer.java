package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventDeclinesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: inline_actions */
public final class GraphQLEventDeclinesConnection$Serializer extends JsonSerializer<GraphQLEventDeclinesConnection> {
    public final void m7166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventDeclinesConnection graphQLEventDeclinesConnection = (GraphQLEventDeclinesConnection) obj;
        GraphQLEventDeclinesConnectionDeserializer.m4787a(graphQLEventDeclinesConnection.w_(), graphQLEventDeclinesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventDeclinesConnection.class, new GraphQLEventDeclinesConnection$Serializer());
        FbSerializerProvider.a(GraphQLEventDeclinesConnection.class, new GraphQLEventDeclinesConnection$Serializer());
    }
}
