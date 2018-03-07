package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFocusedPhotoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hd_playable_url */
public final class GraphQLFocusedPhoto$Serializer extends JsonSerializer<GraphQLFocusedPhoto> {
    public final void m7523a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFocusedPhoto graphQLFocusedPhoto = (GraphQLFocusedPhoto) obj;
        GraphQLFocusedPhotoDeserializer.m4921a(graphQLFocusedPhoto.w_(), graphQLFocusedPhoto.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFocusedPhoto.class, new GraphQLFocusedPhoto$Serializer());
        FbSerializerProvider.a(GraphQLFocusedPhoto.class, new GraphQLFocusedPhoto$Serializer());
    }
}
