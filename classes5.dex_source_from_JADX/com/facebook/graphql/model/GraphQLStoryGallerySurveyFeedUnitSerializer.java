package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to resolve service class  */
public class GraphQLStoryGallerySurveyFeedUnitSerializer extends JsonSerializer<GraphQLStoryGallerySurveyFeedUnit> {
    public final void m21869a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit = (GraphQLStoryGallerySurveyFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLStoryGallerySurveyFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLStoryGallerySurveyFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLStoryGallerySurveyFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLStoryGallerySurveyFeedUnit.g());
        }
        if (graphQLStoryGallerySurveyFeedUnit.k() != null) {
            jsonGenerator.a("cancellation");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryGallerySurveyFeedUnit.k(), true);
        }
        if (graphQLStoryGallerySurveyFeedUnit.l() != null) {
            jsonGenerator.a("confirmation");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryGallerySurveyFeedUnit.l(), true);
        }
        if (graphQLStoryGallerySurveyFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLStoryGallerySurveyFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLStoryGallerySurveyFeedUnit.T_());
        if (graphQLStoryGallerySurveyFeedUnit.m() != null) {
            jsonGenerator.a("footer");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryGallerySurveyFeedUnit.m(), true);
        }
        if (graphQLStoryGallerySurveyFeedUnit.n() != null) {
            jsonGenerator.a("id", graphQLStoryGallerySurveyFeedUnit.n());
        }
        if (graphQLStoryGallerySurveyFeedUnit.r() != null) {
            jsonGenerator.a("message_summary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryGallerySurveyFeedUnit.r(), true);
        }
        if (graphQLStoryGallerySurveyFeedUnit.s() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLStoryGallerySurveyFeedUnit.s());
        }
        if (graphQLStoryGallerySurveyFeedUnit.t() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryGallerySurveyFeedUnit.t(), true);
        }
        if (graphQLStoryGallerySurveyFeedUnit.u() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryGallerySurveyFeedUnit.u(), true);
        }
        if (graphQLStoryGallerySurveyFeedUnit.v() != null) {
            jsonGenerator.a("tracking", graphQLStoryGallerySurveyFeedUnit.v());
        }
        if (graphQLStoryGallerySurveyFeedUnit.w() != null) {
            jsonGenerator.a("url", graphQLStoryGallerySurveyFeedUnit.w());
        }
        if (graphQLStoryGallerySurveyFeedUnit.x() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLStoryGallerySurveyFeedUnit.x());
        }
        if (graphQLStoryGallerySurveyFeedUnit.y() != null) {
            jsonGenerator.a("local_story_visibility", graphQLStoryGallerySurveyFeedUnit.y());
        }
        jsonGenerator.a("local_story_visible_height", graphQLStoryGallerySurveyFeedUnit.z());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLStoryGallerySurveyFeedUnit.class, new GraphQLStoryGallerySurveyFeedUnitSerializer());
    }
}
