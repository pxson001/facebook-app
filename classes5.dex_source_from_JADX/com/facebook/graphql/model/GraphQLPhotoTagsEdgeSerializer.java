package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WIKIPEDIA */
public class GraphQLPhotoTagsEdgeSerializer extends JsonSerializer<GraphQLPhotoTagsEdge> {
    public final void m20761a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotoTagsEdge__JsonHelper.m20763a(jsonGenerator, (GraphQLPhotoTagsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotoTagsEdge.class, new GraphQLPhotoTagsEdgeSerializer());
    }
}
