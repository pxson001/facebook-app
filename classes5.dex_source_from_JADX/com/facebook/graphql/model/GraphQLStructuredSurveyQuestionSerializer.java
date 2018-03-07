package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: URL %s returned %d without a valid redirect */
public class GraphQLStructuredSurveyQuestionSerializer extends JsonSerializer<GraphQLStructuredSurveyQuestion> {
    public final void m21971a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStructuredSurveyQuestion__JsonHelper.m21973a(jsonGenerator, (GraphQLStructuredSurveyQuestion) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStructuredSurveyQuestion.class, new GraphQLStructuredSurveyQuestionSerializer());
    }
}
