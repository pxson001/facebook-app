package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNWATCHED */
public class GraphQLSurveyFeedUnitSerializer extends JsonSerializer<GraphQLSurveyFeedUnit> {
    public final void m22031a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = (GraphQLSurveyFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLSurveyFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLSurveyFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLSurveyFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLSurveyFeedUnit.g());
        }
        if (graphQLSurveyFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLSurveyFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLSurveyFeedUnit.T_());
        if (graphQLSurveyFeedUnit.y() != null) {
            jsonGenerator.a("hideable_token", graphQLSurveyFeedUnit.y());
        }
        if (graphQLSurveyFeedUnit.m() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLSurveyFeedUnit.m());
        }
        if (graphQLSurveyFeedUnit.n() != null) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLSurveyFeedUnit.n(), true);
        }
        if (graphQLSurveyFeedUnit.r() != null) {
            jsonGenerator.a("surveyActor");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLSurveyFeedUnit.r(), true);
        }
        if (graphQLSurveyFeedUnit.s() != null) {
            jsonGenerator.a("surveyContent");
            GraphQLStructuredSurvey__JsonHelper.m21999a(jsonGenerator, graphQLSurveyFeedUnit.s(), true);
        }
        if (graphQLSurveyFeedUnit.t() != null) {
            jsonGenerator.a("surveyHideableToken", graphQLSurveyFeedUnit.t());
        }
        if (graphQLSurveyFeedUnit.v() != null) {
            jsonGenerator.a("surveyResponse", graphQLSurveyFeedUnit.v());
        }
        if (graphQLSurveyFeedUnit.w() != null) {
            jsonGenerator.a("surveySponsoredData");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLSurveyFeedUnit.w(), true);
        }
        if (graphQLSurveyFeedUnit.x() != null) {
            jsonGenerator.a("surveyTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSurveyFeedUnit.x(), true);
        }
        if (graphQLSurveyFeedUnit.z() != null) {
            jsonGenerator.a("surveyTracking", graphQLSurveyFeedUnit.z());
        }
        if (graphQLSurveyFeedUnit.A() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSurveyFeedUnit.A(), true);
        }
        if (graphQLSurveyFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLSurveyFeedUnit.k());
        }
        if (graphQLSurveyFeedUnit.B() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLSurveyFeedUnit.B());
        }
        if (graphQLSurveyFeedUnit.C() != null) {
            jsonGenerator.a("local_story_visibility", graphQLSurveyFeedUnit.C());
        }
        jsonGenerator.a("local_story_visible_height", graphQLSurveyFeedUnit.D());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLSurveyFeedUnit.class, new GraphQLSurveyFeedUnitSerializer());
    }
}
