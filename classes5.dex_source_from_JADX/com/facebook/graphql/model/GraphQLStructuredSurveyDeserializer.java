package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_ios_post_checkin */
public class GraphQLStructuredSurveyDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurvey.class, new GraphQLStructuredSurveyDeserializer());
    }

    public GraphQLStructuredSurveyDeserializer() {
        a(GraphQLStructuredSurvey.class);
    }

    public Object m21957a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStructuredSurvey__JsonHelper.m21998a(jsonParser);
    }
}
