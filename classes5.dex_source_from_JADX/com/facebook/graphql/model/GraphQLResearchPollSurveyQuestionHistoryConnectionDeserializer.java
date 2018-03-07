package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: music_type */
public class GraphQLResearchPollSurveyQuestionHistoryConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollSurveyQuestionHistoryConnection.class, new GraphQLResearchPollSurveyQuestionHistoryConnectionDeserializer());
    }

    public GraphQLResearchPollSurveyQuestionHistoryConnectionDeserializer() {
        a(GraphQLResearchPollSurveyQuestionHistoryConnection.class);
    }

    public Object m21484a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLResearchPollSurveyQuestionHistoryConnection__JsonHelper.m21486a(jsonParser);
    }
}
