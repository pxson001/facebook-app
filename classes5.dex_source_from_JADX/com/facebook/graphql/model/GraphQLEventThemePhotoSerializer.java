package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: implicit_action */
public class GraphQLEventThemePhotoSerializer extends JsonSerializer<GraphQLEventThemePhoto> {
    public final void m7279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventThemePhoto__JsonHelper.m7281a(jsonGenerator, (GraphQLEventThemePhoto) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventThemePhoto.class, new GraphQLEventThemePhotoSerializer());
    }
}
