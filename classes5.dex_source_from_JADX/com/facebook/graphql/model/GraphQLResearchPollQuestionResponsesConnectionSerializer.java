package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_DOWNLOAD_BUTTON */
public class GraphQLResearchPollQuestionResponsesConnectionSerializer extends JsonSerializer<GraphQLResearchPollQuestionResponsesConnection> {
    public final void m21452a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollQuestionResponsesConnection__JsonHelper.m21454a(jsonGenerator, (GraphQLResearchPollQuestionResponsesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollQuestionResponsesConnection.class, new GraphQLResearchPollQuestionResponsesConnectionSerializer());
    }
}
