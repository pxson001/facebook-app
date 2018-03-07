package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_groups_dash */
public class GraphQLSurveyFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m22030a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = new GraphQLSurveyFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLSurveyFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLSurveyFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "cache_id", graphQLSurveyFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "debug_info", graphQLSurveyFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLSurveyFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "fetchTimeMs", graphQLSurveyFeedUnit.a_, 2, false);
                } else if ("hideable_token".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "hideable_token", graphQLSurveyFeedUnit.a_, 3, false);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "short_term_cache_key", graphQLSurveyFeedUnit.a_, 4, false);
                } else if ("sponsored_data".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "sponsored_data"));
                    }
                    graphQLSurveyFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "sponsored_data", graphQLSurveyFeedUnit.a_, 5, true);
                } else if ("surveyActor".equals(i)) {
                    GraphQLActor graphQLActor;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLActor = null;
                    } else {
                        graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "surveyActor"));
                    }
                    graphQLSurveyFeedUnit.k = graphQLActor;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "surveyActor", graphQLSurveyFeedUnit.a_, 6, true);
                } else if ("surveyContent".equals(i)) {
                    GraphQLStructuredSurvey graphQLStructuredSurvey;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLStructuredSurvey = null;
                    } else {
                        graphQLStructuredSurvey = GraphQLStructuredSurvey__JsonHelper.m21998a(FieldAccessQueryTracker.a(jsonParser, "surveyContent"));
                    }
                    graphQLSurveyFeedUnit.l = graphQLStructuredSurvey;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "surveyContent", graphQLSurveyFeedUnit.a_, 7, true);
                } else if ("surveyHideableToken".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "surveyHideableToken", graphQLSurveyFeedUnit.a_, 8, false);
                } else if ("surveyResponse".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "surveyResponse", graphQLSurveyFeedUnit.a_, 9, false);
                } else if ("surveySponsoredData".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "surveySponsoredData"));
                    }
                    graphQLSurveyFeedUnit.o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "surveySponsoredData", graphQLSurveyFeedUnit.a_, 10, true);
                } else if ("surveyTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "surveyTitle"));
                    }
                    graphQLSurveyFeedUnit.p = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "surveyTitle", graphQLSurveyFeedUnit.a_, 11, true);
                } else if ("surveyTracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.q = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "surveyTracking", graphQLSurveyFeedUnit.a_, 12, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLSurveyFeedUnit.r = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "title", graphQLSurveyFeedUnit.a_, 13, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.s = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "tracking", graphQLSurveyFeedUnit.a_, 14, false);
                } else if ("local_last_negative_feedback_action_type".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.t = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "local_last_negative_feedback_action_type", graphQLSurveyFeedUnit.a_, 15, false);
                } else if ("local_story_visibility".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSurveyFeedUnit.u = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "local_story_visibility", graphQLSurveyFeedUnit.a_, 16, false);
                } else if ("local_story_visible_height".equals(i)) {
                    int i2;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        i2 = 0;
                    } else {
                        i2 = jsonParser.E();
                    }
                    graphQLSurveyFeedUnit.v = i2;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSurveyFeedUnit, "local_story_visible_height", graphQLSurveyFeedUnit.a_, 17, false);
                }
                jsonParser.f();
            }
        }
        return graphQLSurveyFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSurveyFeedUnit.class, new GraphQLSurveyFeedUnitDeserializer());
    }

    public GraphQLSurveyFeedUnitDeserializer() {
        a(GraphQLSurveyFeedUnit.class);
    }
}
