package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_GAMES */
public class GraphQLResearchPollQuestionRespondersConnectionSerializer extends JsonSerializer<GraphQLResearchPollQuestionRespondersConnection> {
    public final void m21443a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollQuestionRespondersConnection__JsonHelper.m21445a(jsonGenerator, (GraphQLResearchPollQuestionRespondersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollQuestionRespondersConnection.class, new GraphQLResearchPollQuestionRespondersConnectionSerializer());
    }
}
