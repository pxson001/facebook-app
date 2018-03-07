package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WELCOME_DASH */
public class GraphQLPhrasesAnalysisItemsEdgeSerializer extends JsonSerializer<GraphQLPhrasesAnalysisItemsEdge> {
    public final void m20824a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhrasesAnalysisItemsEdge__JsonHelper.m20826a(jsonGenerator, (GraphQLPhrasesAnalysisItemsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhrasesAnalysisItemsEdge.class, new GraphQLPhrasesAnalysisItemsEdgeSerializer());
    }
}
