package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hd_playable_uri */
public class GraphQLFocusedPhotoSerializer extends JsonSerializer<GraphQLFocusedPhoto> {
    public final void m7525a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, (GraphQLFocusedPhoto) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFocusedPhoto.class, new GraphQLFocusedPhotoSerializer());
    }
}
