package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_ios_place_creation */
public class GraphQLStructuredSurveyQuestionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurveyQuestion.class, new GraphQLStructuredSurveyQuestionDeserializer());
    }

    public GraphQLStructuredSurveyQuestionDeserializer() {
        a(GraphQLStructuredSurveyQuestion.class);
    }

    public Object m21970a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStructuredSurveyQuestion__JsonHelper.m21972a(jsonParser);
    }
}
