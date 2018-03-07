package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: invite_friends_to_like */
public class GraphQLEmotionalAnalysisItemsConnectionSerializer extends JsonSerializer<GraphQLEmotionalAnalysisItemsConnection> {
    public final void m7022a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEmotionalAnalysisItemsConnection__JsonHelper.m7024a(jsonGenerator, (GraphQLEmotionalAnalysisItemsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEmotionalAnalysisItemsConnection.class, new GraphQLEmotionalAnalysisItemsConnectionSerializer());
    }
}
