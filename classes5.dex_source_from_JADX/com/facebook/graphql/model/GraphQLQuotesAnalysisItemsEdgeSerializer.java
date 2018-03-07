package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_EVENTS */
public class GraphQLQuotesAnalysisItemsEdgeSerializer extends JsonSerializer<GraphQLQuotesAnalysisItemsEdge> {
    public final void m21298a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuotesAnalysisItemsEdge__JsonHelper.m21300a(jsonGenerator, (GraphQLQuotesAnalysisItemsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuotesAnalysisItemsEdge.class, new GraphQLQuotesAnalysisItemsEdgeSerializer());
    }
}
