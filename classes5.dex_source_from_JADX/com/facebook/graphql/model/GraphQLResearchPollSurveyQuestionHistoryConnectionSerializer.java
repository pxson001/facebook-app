package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_CHANNEL_FOLLOW */
public class GraphQLResearchPollSurveyQuestionHistoryConnectionSerializer extends JsonSerializer<GraphQLResearchPollSurveyQuestionHistoryConnection> {
    public final void m21485a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollSurveyQuestionHistoryConnection__JsonHelper.m21487a(jsonGenerator, (GraphQLResearchPollSurveyQuestionHistoryConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollSurveyQuestionHistoryConnection.class, new GraphQLResearchPollSurveyQuestionHistoryConnectionSerializer());
    }
}
