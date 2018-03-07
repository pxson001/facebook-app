package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: instant_articles_enabled */
public class GraphQLEntityWithImageSerializer extends JsonSerializer<GraphQLEntityWithImage> {
    public final void m7099a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntityWithImage__JsonHelper.m7101a(jsonGenerator, (GraphQLEntityWithImage) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEntityWithImage.class, new GraphQLEntityWithImageSerializer());
    }
}
