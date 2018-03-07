package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: narrowPortraitImage */
public class GraphQLResearchPollMultipleChoiceQuestionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollMultipleChoiceQuestion.class, new GraphQLResearchPollMultipleChoiceQuestionDeserializer());
    }

    public GraphQLResearchPollMultipleChoiceQuestionDeserializer() {
        a(GraphQLResearchPollMultipleChoiceQuestion.class);
    }

    public Object m21418a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21420a(jsonParser);
    }
}
