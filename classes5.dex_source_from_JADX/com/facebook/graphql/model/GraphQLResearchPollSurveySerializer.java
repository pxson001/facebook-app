package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_CHANNEL_FEED_UNIT_PRUNE_NON_LIVE */
public class GraphQLResearchPollSurveySerializer extends JsonSerializer<GraphQLResearchPollSurvey> {
    public final void m21488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollSurvey__JsonHelper.m21490a(jsonGenerator, (GraphQLResearchPollSurvey) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollSurvey.class, new GraphQLResearchPollSurveySerializer());
    }
}
