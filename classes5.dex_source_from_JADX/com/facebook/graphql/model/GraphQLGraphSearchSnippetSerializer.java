package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: full_pano_height_pixels */
public class GraphQLGraphSearchSnippetSerializer extends JsonSerializer<GraphQLGraphSearchSnippet> {
    public final void m8319a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchSnippet__JsonHelper.m8321a(jsonGenerator, (GraphQLGraphSearchSnippet) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchSnippet.class, new GraphQLGraphSearchSnippetSerializer());
    }
}
