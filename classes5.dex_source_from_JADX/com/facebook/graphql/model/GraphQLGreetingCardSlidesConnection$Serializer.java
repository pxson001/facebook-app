package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGreetingCardSlidesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_who_visited */
public final class GraphQLGreetingCardSlidesConnection$Serializer extends JsonSerializer<GraphQLGreetingCardSlidesConnection> {
    public final void m8354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardSlidesConnection graphQLGreetingCardSlidesConnection = (GraphQLGreetingCardSlidesConnection) obj;
        GraphQLGreetingCardSlidesConnectionDeserializer.m5135a(graphQLGreetingCardSlidesConnection.w_(), graphQLGreetingCardSlidesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardSlidesConnection.class, new GraphQLGreetingCardSlidesConnection$Serializer());
        FbSerializerProvider.a(GraphQLGreetingCardSlidesConnection.class, new GraphQLGreetingCardSlidesConnection$Serializer());
    }
}
