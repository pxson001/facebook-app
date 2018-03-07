package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WINDOW_SERVICE_REPAIR */
public class GraphQLPhotoEncodingSerializer extends JsonSerializer<GraphQLPhotoEncoding> {
    public final void m20722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotoEncoding__JsonHelper.m20724a(jsonGenerator, (GraphQLPhotoEncoding) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotoEncoding.class, new GraphQLPhotoEncodingSerializer());
    }
}
