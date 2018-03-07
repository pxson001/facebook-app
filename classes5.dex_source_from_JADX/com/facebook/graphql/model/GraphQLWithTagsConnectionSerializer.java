package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Target host must not be null. */
public class GraphQLWithTagsConnectionSerializer extends JsonSerializer<GraphQLWithTagsConnection> {
    public final void m22499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLWithTagsConnection__JsonHelper.m22501a(jsonGenerator, (GraphQLWithTagsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLWithTagsConnection.class, new GraphQLWithTagsConnectionSerializer());
    }
}
