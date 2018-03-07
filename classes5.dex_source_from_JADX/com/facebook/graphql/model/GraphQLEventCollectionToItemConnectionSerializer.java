package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: input_shutdown */
public class GraphQLEventCollectionToItemConnectionSerializer extends JsonSerializer<GraphQLEventCollectionToItemConnection> {
    public final void m7152a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventCollectionToItemConnection__JsonHelper.m7154a(jsonGenerator, (GraphQLEventCollectionToItemConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventCollectionToItemConnection.class, new GraphQLEventCollectionToItemConnectionSerializer());
    }
}
