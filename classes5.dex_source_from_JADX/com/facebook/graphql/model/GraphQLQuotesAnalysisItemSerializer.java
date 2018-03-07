package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_GROUP_EVENTS */
public class GraphQLQuotesAnalysisItemSerializer extends JsonSerializer<GraphQLQuotesAnalysisItem> {
    public final void m21280a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuotesAnalysisItem__JsonHelper.m21282a(jsonGenerator, (GraphQLQuotesAnalysisItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuotesAnalysisItem.class, new GraphQLQuotesAnalysisItemSerializer());
    }
}
