package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_jewel */
public class GraphQLStructuredSurveyConfiguredQuestionDeserializer extends FbJsonDeserializer {
    public Object m21954a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLStructuredSurveyConfiguredQuestion graphQLStructuredSurveyConfiguredQuestion = new GraphQLStructuredSurveyConfiguredQuestion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLStructuredSurveyConfiguredQuestion = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLStructuredSurveyConfiguredQuestion__JsonHelper.m21956a(graphQLStructuredSurveyConfiguredQuestion, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLStructuredSurveyConfiguredQuestion;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurveyConfiguredQuestion.class, new GraphQLStructuredSurveyConfiguredQuestionDeserializer());
    }

    public GraphQLStructuredSurveyConfiguredQuestionDeserializer() {
        a(GraphQLStructuredSurveyConfiguredQuestion.class);
    }
}
