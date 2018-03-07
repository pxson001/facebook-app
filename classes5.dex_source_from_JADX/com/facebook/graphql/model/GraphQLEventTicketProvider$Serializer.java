package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventTicketProviderDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: image_unblock_for_dialtone */
public final class GraphQLEventTicketProvider$Serializer extends JsonSerializer<GraphQLEventTicketProvider> {
    public final void m7294a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventTicketProvider graphQLEventTicketProvider = (GraphQLEventTicketProvider) obj;
        GraphQLEventTicketProviderDeserializer.m4832a(graphQLEventTicketProvider.w_(), graphQLEventTicketProvider.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventTicketProvider.class, new GraphQLEventTicketProvider$Serializer());
        FbSerializerProvider.a(GraphQLEventTicketProvider.class, new GraphQLEventTicketProvider$Serializer());
    }
}
