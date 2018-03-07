package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMediaSetMediaConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: family_request */
public final class GraphQLMediaSetMediaConnection$Serializer extends JsonSerializer<GraphQLMediaSetMediaConnection> {
    public final void m9070a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaSetMediaConnection graphQLMediaSetMediaConnection = (GraphQLMediaSetMediaConnection) obj;
        GraphQLMediaSetMediaConnectionDeserializer.m5360a(graphQLMediaSetMediaConnection.w_(), graphQLMediaSetMediaConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaSetMediaConnection.class, new GraphQLMediaSetMediaConnection$Serializer());
        FbSerializerProvider.a(GraphQLMediaSetMediaConnection.class, new GraphQLMediaSetMediaConnection$Serializer());
    }
}
