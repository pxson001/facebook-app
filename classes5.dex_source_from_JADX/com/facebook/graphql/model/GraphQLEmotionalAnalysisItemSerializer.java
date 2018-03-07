package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: invitee */
public class GraphQLEmotionalAnalysisItemSerializer extends JsonSerializer<GraphQLEmotionalAnalysisItem> {
    public final void m7013a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEmotionalAnalysisItem__JsonHelper.m7015a(jsonGenerator, (GraphQLEmotionalAnalysisItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEmotionalAnalysisItem.class, new GraphQLEmotionalAnalysisItemSerializer());
    }
}
