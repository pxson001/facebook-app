package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_HOME_FEED */
public class GraphQLResearchPollMultipleChoiceResponseSerializer extends JsonSerializer<GraphQLResearchPollMultipleChoiceResponse> {
    public final void m21433a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollMultipleChoiceResponse__JsonHelper.m21435a(jsonGenerator, (GraphQLResearchPollMultipleChoiceResponse) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollMultipleChoiceResponse.class, new GraphQLResearchPollMultipleChoiceResponseSerializer());
    }
}
