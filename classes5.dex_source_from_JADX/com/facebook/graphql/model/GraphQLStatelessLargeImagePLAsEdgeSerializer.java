package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unexpected end of document */
public class GraphQLStatelessLargeImagePLAsEdgeSerializer extends JsonSerializer<GraphQLStatelessLargeImagePLAsEdge> {
    public final void m21829a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStatelessLargeImagePLAsEdge__JsonHelper.m21831a(jsonGenerator, (GraphQLStatelessLargeImagePLAsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStatelessLargeImagePLAsEdge.class, new GraphQLStatelessLargeImagePLAsEdgeSerializer());
    }
}
