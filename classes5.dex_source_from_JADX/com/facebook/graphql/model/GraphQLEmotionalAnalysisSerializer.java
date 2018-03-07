package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: internal_result */
public class GraphQLEmotionalAnalysisSerializer extends JsonSerializer<GraphQLEmotionalAnalysis> {
    public final void m7034a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEmotionalAnalysis__JsonHelper.m7036a(jsonGenerator, (GraphQLEmotionalAnalysis) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEmotionalAnalysis.class, new GraphQLEmotionalAnalysisSerializer());
    }
}
