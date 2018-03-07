package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTEX_INLINE */
public class GraphQLSearchSuggestionsEdgeSerializer extends JsonSerializer<GraphQLSearchSuggestionsEdge> {
    public final void m21625a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSearchSuggestionsEdge__JsonHelper.m21627a(jsonGenerator, (GraphQLSearchSuggestionsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSearchSuggestionsEdge.class, new GraphQLSearchSuggestionsEdgeSerializer());
    }
}
