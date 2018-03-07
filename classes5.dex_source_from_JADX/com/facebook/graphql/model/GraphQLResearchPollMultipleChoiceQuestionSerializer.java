package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_HOME_HAIRLINE */
public class GraphQLResearchPollMultipleChoiceQuestionSerializer extends JsonSerializer<GraphQLResearchPollMultipleChoiceQuestion> {
    public final void m21419a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21421a(jsonGenerator, (GraphQLResearchPollMultipleChoiceQuestion) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollMultipleChoiceQuestion.class, new GraphQLResearchPollMultipleChoiceQuestionSerializer());
    }
}
