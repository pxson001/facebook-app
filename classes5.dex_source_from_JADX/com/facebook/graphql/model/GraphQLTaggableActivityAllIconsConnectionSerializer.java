package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSTYLED */
public class GraphQLTaggableActivityAllIconsConnectionSerializer extends JsonSerializer<GraphQLTaggableActivityAllIconsConnection> {
    public final void m22045a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivityAllIconsConnection__JsonHelper.m22047a(jsonGenerator, (GraphQLTaggableActivityAllIconsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivityAllIconsConnection.class, new GraphQLTaggableActivityAllIconsConnectionSerializer());
    }
}
