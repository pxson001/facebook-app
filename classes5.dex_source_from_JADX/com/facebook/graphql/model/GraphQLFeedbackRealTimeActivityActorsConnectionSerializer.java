package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hide_responses */
public class GraphQLFeedbackRealTimeActivityActorsConnectionSerializer extends JsonSerializer<GraphQLFeedbackRealTimeActivityActorsConnection> {
    public final void m7498a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackRealTimeActivityActorsConnection__JsonHelper.m7500a(jsonGenerator, (GraphQLFeedbackRealTimeActivityActorsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackRealTimeActivityActorsConnection.class, new GraphQLFeedbackRealTimeActivityActorsConnectionSerializer());
    }
}
