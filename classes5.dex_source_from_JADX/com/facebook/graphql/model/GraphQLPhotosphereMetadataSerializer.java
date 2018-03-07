package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WIDGET */
public class GraphQLPhotosphereMetadataSerializer extends JsonSerializer<GraphQLPhotosphereMetadata> {
    public final void m20783a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotosphereMetadata__JsonHelper.m20785a(jsonGenerator, (GraphQLPhotosphereMetadata) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotosphereMetadata.class, new GraphQLPhotosphereMetadataSerializer());
    }
}
