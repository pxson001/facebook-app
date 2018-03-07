package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: eventUrl */
public class GraphQLOpenGraphMetadataSerializer extends JsonSerializer<GraphQLOpenGraphMetadata> {
    public final void m9401a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOpenGraphMetadata__JsonHelper.m9403a(jsonGenerator, (GraphQLOpenGraphMetadata) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLOpenGraphMetadata.class, new GraphQLOpenGraphMetadataSerializer());
    }
}
