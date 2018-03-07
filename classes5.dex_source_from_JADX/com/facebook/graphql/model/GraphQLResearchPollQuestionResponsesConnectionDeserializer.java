package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mwf */
public class GraphQLResearchPollQuestionResponsesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollQuestionResponsesConnection.class, new GraphQLResearchPollQuestionResponsesConnectionDeserializer());
    }

    public GraphQLResearchPollQuestionResponsesConnectionDeserializer() {
        a(GraphQLResearchPollQuestionResponsesConnection.class);
    }

    public Object m21451a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLResearchPollQuestionResponsesConnection__JsonHelper.m21453a(jsonParser);
    }
}
