package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_ios_finch_edit */
public class GraphQLStructuredSurveyResponseOptionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurveyResponseOption.class, new GraphQLStructuredSurveyResponseOptionDeserializer());
    }

    public GraphQLStructuredSurveyResponseOptionDeserializer() {
        a(GraphQLStructuredSurveyResponseOption.class);
    }

    public Object m21992a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStructuredSurveyResponseOption__JsonHelper.m21994a(jsonParser);
    }
}
