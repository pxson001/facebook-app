package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: URI_HANDLER */
public class GraphQLStructuredSurveyQuestionsConnectionSerializer extends JsonSerializer<GraphQLStructuredSurveyQuestionsConnection> {
    public final void m21981a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStructuredSurveyQuestionsConnection__JsonHelper.m21983a(jsonGenerator, (GraphQLStructuredSurveyQuestionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStructuredSurveyQuestionsConnection.class, new GraphQLStructuredSurveyQuestionsConnectionSerializer());
    }
}
