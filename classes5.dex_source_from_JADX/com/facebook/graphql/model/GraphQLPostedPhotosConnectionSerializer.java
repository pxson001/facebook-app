package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ViewerConfigurationQuery */
public class GraphQLPostedPhotosConnectionSerializer extends JsonSerializer<GraphQLPostedPhotosConnection> {
    public final void m20973a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPostedPhotosConnection__JsonHelper.m20975a(jsonGenerator, (GraphQLPostedPhotosConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPostedPhotosConnection.class, new GraphQLPostedPhotosConnectionSerializer());
    }
}
