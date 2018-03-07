package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGreetingCardTemplateDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_who_like */
public final class GraphQLGreetingCardTemplate$Serializer extends JsonSerializer<GraphQLGreetingCardTemplate> {
    public final void m8360a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardTemplate graphQLGreetingCardTemplate = (GraphQLGreetingCardTemplate) obj;
        GraphQLGreetingCardTemplateDeserializer.m5138a(graphQLGreetingCardTemplate.w_(), graphQLGreetingCardTemplate.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardTemplate.class, new GraphQLGreetingCardTemplate$Serializer());
        FbSerializerProvider.a(GraphQLGreetingCardTemplate.class, new GraphQLGreetingCardTemplate$Serializer());
    }
}
