package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_COMMENT */
public class GraphQLQuotesAnalysisSerializer extends JsonSerializer<GraphQLQuotesAnalysis> {
    public final void m21301a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuotesAnalysis__JsonHelper.m21303a(jsonGenerator, (GraphQLQuotesAnalysis) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuotesAnalysis.class, new GraphQLQuotesAnalysisSerializer());
    }
}
