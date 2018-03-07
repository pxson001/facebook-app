package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSouvenirMediaConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UriSerializer.serialize */
public final class GraphQLSouvenirMediaConnection$Serializer extends JsonSerializer<GraphQLSouvenirMediaConnection> {
    public final void m21703a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSouvenirMediaConnection graphQLSouvenirMediaConnection = (GraphQLSouvenirMediaConnection) obj;
        GraphQLSouvenirMediaConnectionDeserializer.m5908a(graphQLSouvenirMediaConnection.w_(), graphQLSouvenirMediaConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSouvenirMediaConnection.class, new GraphQLSouvenirMediaConnection$Serializer());
        FbSerializerProvider.a(GraphQLSouvenirMediaConnection.class, new GraphQLSouvenirMediaConnection$Serializer());
    }
}
