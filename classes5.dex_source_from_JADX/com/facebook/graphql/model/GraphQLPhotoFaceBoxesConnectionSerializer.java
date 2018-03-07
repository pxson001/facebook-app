package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WINDOWS */
public class GraphQLPhotoFaceBoxesConnectionSerializer extends JsonSerializer<GraphQLPhotoFaceBoxesConnection> {
    public final void m20729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotoFaceBoxesConnection__JsonHelper.m20731a(jsonGenerator, (GraphQLPhotoFaceBoxesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotoFaceBoxesConnection.class, new GraphQLPhotoFaceBoxesConnectionSerializer());
    }
}
