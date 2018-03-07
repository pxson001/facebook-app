package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: exceeds  */
public class GraphQLNegativeFeedbackActionsConnectionSerializer extends JsonSerializer<GraphQLNegativeFeedbackActionsConnection> {
    public final void m9242a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, (GraphQLNegativeFeedbackActionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNegativeFeedbackActionsConnection.class, new GraphQLNegativeFeedbackActionsConnectionSerializer());
    }
}
