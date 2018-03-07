package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_FUNDRAISER */
public class GraphQLQuotesAnalysisItemsConnectionSerializer extends JsonSerializer<GraphQLQuotesAnalysisItemsConnection> {
    public final void m21289a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuotesAnalysisItemsConnection__JsonHelper.m21291a(jsonGenerator, (GraphQLQuotesAnalysisItemsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuotesAnalysisItemsConnection.class, new GraphQLQuotesAnalysisItemsConnectionSerializer());
    }
}
