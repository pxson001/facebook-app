package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WELL_WATER_DRILLING_SERVICE */
public class GraphQLPhrasesAnalysisItemsConnectionSerializer extends JsonSerializer<GraphQLPhrasesAnalysisItemsConnection> {
    public final void m20815a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhrasesAnalysisItemsConnection__JsonHelper.m20817a(jsonGenerator, (GraphQLPhrasesAnalysisItemsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhrasesAnalysisItemsConnection.class, new GraphQLPhrasesAnalysisItemsConnectionSerializer());
    }
}
