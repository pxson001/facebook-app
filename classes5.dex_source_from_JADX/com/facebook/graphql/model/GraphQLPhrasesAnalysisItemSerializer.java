package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WHITELISTED_BY_VIEWER */
public class GraphQLPhrasesAnalysisItemSerializer extends JsonSerializer<GraphQLPhrasesAnalysisItem> {
    public final void m20806a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhrasesAnalysisItem__JsonHelper.m20808a(jsonGenerator, (GraphQLPhrasesAnalysisItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhrasesAnalysisItem.class, new GraphQLPhrasesAnalysisItemSerializer());
    }
}
