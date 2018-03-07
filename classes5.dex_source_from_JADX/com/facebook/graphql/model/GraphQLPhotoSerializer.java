package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WILDLIFE_SANCTUARY */
public class GraphQLPhotoSerializer extends JsonSerializer<GraphQLPhoto> {
    public final void m20732a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, (GraphQLPhoto) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhoto.class, new GraphQLPhotoSerializer());
    }
}
