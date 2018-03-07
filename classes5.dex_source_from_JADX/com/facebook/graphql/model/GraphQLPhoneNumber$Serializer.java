package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPhoneNumberDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WITHIN_FEW_HOURS */
public final class GraphQLPhoneNumber$Serializer extends JsonSerializer<GraphQLPhoneNumber> {
    public final void m20710a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhoneNumber graphQLPhoneNumber = (GraphQLPhoneNumber) obj;
        GraphQLPhoneNumberDeserializer.m5600a(graphQLPhoneNumber.w_(), graphQLPhoneNumber.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLPhoneNumber.class, new GraphQLPhoneNumber$Serializer());
        FbSerializerProvider.a(GraphQLPhoneNumber.class, new GraphQLPhoneNumber$Serializer());
    }
}
