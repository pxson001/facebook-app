package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: invalid shadow size */
public class GraphQLEmotionalAnalysisItemsEdgeSerializer extends JsonSerializer<GraphQLEmotionalAnalysisItemsEdge> {
    public final void m7031a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEmotionalAnalysisItemsEdge__JsonHelper.m7033a(jsonGenerator, (GraphQLEmotionalAnalysisItemsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEmotionalAnalysisItemsEdge.class, new GraphQLEmotionalAnalysisItemsEdgeSerializer());
    }
}
