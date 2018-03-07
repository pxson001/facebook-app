package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEntityWithImageDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: instant_game_id */
public final class GraphQLEntityWithImage$Serializer extends JsonSerializer<GraphQLEntityWithImage> {
    public final void m7097a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntityWithImage graphQLEntityWithImage = (GraphQLEntityWithImage) obj;
        GraphQLEntityWithImageDeserializer.m4769a(graphQLEntityWithImage.w_(), graphQLEntityWithImage.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEntityWithImage.class, new GraphQLEntityWithImage$Serializer());
        FbSerializerProvider.a(GraphQLEntityWithImage.class, new GraphQLEntityWithImage$Serializer());
    }
}
