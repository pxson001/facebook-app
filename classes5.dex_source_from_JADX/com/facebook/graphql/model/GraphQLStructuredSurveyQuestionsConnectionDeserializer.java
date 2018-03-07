package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_ios_finch_profile */
public class GraphQLStructuredSurveyQuestionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurveyQuestionsConnection.class, new GraphQLStructuredSurveyQuestionsConnectionDeserializer());
    }

    public GraphQLStructuredSurveyQuestionsConnectionDeserializer() {
        a(GraphQLStructuredSurveyQuestionsConnection.class);
    }

    public Object m21980a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStructuredSurveyQuestionsConnection__JsonHelper.m21982a(jsonParser);
    }
}
