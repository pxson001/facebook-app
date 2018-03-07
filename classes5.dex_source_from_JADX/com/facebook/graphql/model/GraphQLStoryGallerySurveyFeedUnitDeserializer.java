package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_see_all */
public class GraphQLStoryGallerySurveyFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m21868a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit = new GraphQLStoryGallerySurveyFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLStoryGallerySurveyFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLStoryGallerySurveyFeedUnit__JsonHelper.m21870a(graphQLStoryGallerySurveyFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLStoryGallerySurveyFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryGallerySurveyFeedUnit.class, new GraphQLStoryGallerySurveyFeedUnitDeserializer());
    }

    public GraphQLStoryGallerySurveyFeedUnitDeserializer() {
        a(GraphQLStoryGallerySurveyFeedUnit.class);
    }
}
