package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: musicians */
public class GraphQLResearchPollSurveyDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollSurvey.class, new GraphQLResearchPollSurveyDeserializer());
    }

    public GraphQLResearchPollSurveyDeserializer() {
        a(GraphQLResearchPollSurvey.class);
    }

    public Object m21478a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLResearchPollSurvey__JsonHelper.m21489a(jsonParser);
    }
}
