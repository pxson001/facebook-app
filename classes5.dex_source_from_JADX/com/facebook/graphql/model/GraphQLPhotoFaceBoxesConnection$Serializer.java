package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPhotoFaceBoxesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WINDOWS_10_STORE */
public final class GraphQLPhotoFaceBoxesConnection$Serializer extends JsonSerializer<GraphQLPhotoFaceBoxesConnection> {
    public final void m20727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotoFaceBoxesConnection graphQLPhotoFaceBoxesConnection = (GraphQLPhotoFaceBoxesConnection) obj;
        GraphQLPhotoFaceBoxesConnectionDeserializer.m5613a(graphQLPhotoFaceBoxesConnection.w_(), graphQLPhotoFaceBoxesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotoFaceBoxesConnection.class, new GraphQLPhotoFaceBoxesConnection$Serializer());
        FbSerializerProvider.a(GraphQLPhotoFaceBoxesConnection.class, new GraphQLPhotoFaceBoxesConnection$Serializer());
    }
}
