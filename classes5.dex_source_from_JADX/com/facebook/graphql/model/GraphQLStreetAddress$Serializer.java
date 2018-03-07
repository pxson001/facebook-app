package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStreetAddressDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USER_CANCEL */
public final class GraphQLStreetAddress$Serializer extends JsonSerializer<GraphQLStreetAddress> {
    public final void m21933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStreetAddress graphQLStreetAddress = (GraphQLStreetAddress) obj;
        GraphQLStreetAddressDeserializer.m5996a(graphQLStreetAddress.w_(), graphQLStreetAddress.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLStreetAddress.class, new GraphQLStreetAddress$Serializer());
        FbSerializerProvider.a(GraphQLStreetAddress.class, new GraphQLStreetAddress$Serializer());
    }
}
