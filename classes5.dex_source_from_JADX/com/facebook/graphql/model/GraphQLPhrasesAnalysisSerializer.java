package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEDDING_PLANNING */
public class GraphQLPhrasesAnalysisSerializer extends JsonSerializer<GraphQLPhrasesAnalysis> {
    public final void m20827a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhrasesAnalysis__JsonHelper.m20829a(jsonGenerator, (GraphQLPhrasesAnalysis) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhrasesAnalysis.class, new GraphQLPhrasesAnalysisSerializer());
    }
}
