package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USER_CREATE_DIALOG */
public class GraphQLStreamingImageSerializer extends JsonSerializer<GraphQLStreamingImage> {
    public final void m21928a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, (GraphQLStreamingImage) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStreamingImage.class, new GraphQLStreamingImageSerializer());
    }
}
