package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WAP */
public class GraphQLPlacesTileResultsEdgeSerializer extends JsonSerializer<GraphQLPlacesTileResultsEdge> {
    public final void m20941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlacesTileResultsEdge__JsonHelper.m20943a(jsonGenerator, (GraphQLPlacesTileResultsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlacesTileResultsEdge.class, new GraphQLPlacesTileResultsEdgeSerializer());
    }
}
