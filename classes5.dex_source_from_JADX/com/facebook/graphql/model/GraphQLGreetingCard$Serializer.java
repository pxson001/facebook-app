package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGreetingCardDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: full_address */
public final class GraphQLGreetingCard$Serializer extends JsonSerializer<GraphQLGreetingCard> {
    public final void m8323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCard graphQLGreetingCard = (GraphQLGreetingCard) obj;
        GraphQLGreetingCardDeserializer.m5123a(graphQLGreetingCard.w_(), graphQLGreetingCard.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCard.class, new GraphQLGreetingCard$Serializer());
        FbSerializerProvider.a(GraphQLGreetingCard.class, new GraphQLGreetingCard$Serializer());
    }
}
