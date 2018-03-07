package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPhotoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WINE_BAR */
public final class GraphQLPhoto$Serializer extends JsonSerializer<GraphQLPhoto> {
    public final void m20717a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhoto graphQLPhoto = (GraphQLPhoto) obj;
        GraphQLPhotoDeserializer.m5605b(graphQLPhoto.w_(), graphQLPhoto.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPhoto.class, new GraphQLPhoto$Serializer());
        FbSerializerProvider.a(GraphQLPhoto.class, new GraphQLPhoto$Serializer());
    }
}
