package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_HOME_PINNED_TOPICS */
public class GraphQLResearchPollFeedUnitSerializer extends JsonSerializer<GraphQLResearchPollFeedUnit> {
    public final void m21402a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLResearchPollFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLResearchPollFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLResearchPollFeedUnit.z() != null) {
            jsonGenerator.a("ad_impression");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLResearchPollFeedUnit.z(), true);
        }
        if (graphQLResearchPollFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLResearchPollFeedUnit.g());
        }
        if (graphQLResearchPollFeedUnit.A() != null) {
            jsonGenerator.a("checkbox_question_prompt", graphQLResearchPollFeedUnit.A());
        }
        if (graphQLResearchPollFeedUnit.B() != null) {
            jsonGenerator.a("confirmation_text", graphQLResearchPollFeedUnit.B());
        }
        if (graphQLResearchPollFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLResearchPollFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLResearchPollFeedUnit.T_());
        if (graphQLResearchPollFeedUnit.y() != null) {
            jsonGenerator.a("hideable_token", graphQLResearchPollFeedUnit.y());
        }
        if (graphQLResearchPollFeedUnit.D() != null) {
            jsonGenerator.a("id", graphQLResearchPollFeedUnit.D());
        }
        if (graphQLResearchPollFeedUnit.E() != null) {
            jsonGenerator.a("initial_card_prompt", graphQLResearchPollFeedUnit.E());
        }
        if (graphQLResearchPollFeedUnit.C() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLResearchPollFeedUnit.C(), true);
        }
        if (graphQLResearchPollFeedUnit.F() != null) {
            jsonGenerator.a("privacy_disclaimer", graphQLResearchPollFeedUnit.F());
        }
        if (graphQLResearchPollFeedUnit.G() != null) {
            jsonGenerator.a("radio_question_prompt", graphQLResearchPollFeedUnit.G());
        }
        if (graphQLResearchPollFeedUnit.H() != null) {
            jsonGenerator.a("research_poll");
            GraphQLResearchPollSurvey__JsonHelper.m21490a(jsonGenerator, graphQLResearchPollFeedUnit.H(), true);
        }
        if (graphQLResearchPollFeedUnit.I() != null) {
            jsonGenerator.a("see_results_prompt", graphQLResearchPollFeedUnit.I());
        }
        if (graphQLResearchPollFeedUnit.J() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLResearchPollFeedUnit.J());
        }
        jsonGenerator.a("should_auto_open", graphQLResearchPollFeedUnit.K());
        jsonGenerator.a("should_auto_submit", graphQLResearchPollFeedUnit.L());
        if (graphQLResearchPollFeedUnit.M() != null) {
            jsonGenerator.a("sponsored_label", graphQLResearchPollFeedUnit.M());
        }
        if (graphQLResearchPollFeedUnit.N() != null) {
            jsonGenerator.a("submit_answer_prompt", graphQLResearchPollFeedUnit.N());
        }
        if (graphQLResearchPollFeedUnit.O() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLResearchPollFeedUnit.O(), true);
        }
        if (graphQLResearchPollFeedUnit.P() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLResearchPollFeedUnit.P(), true);
        }
        if (graphQLResearchPollFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLResearchPollFeedUnit.k());
        }
        if (graphQLResearchPollFeedUnit.Q() != null) {
            jsonGenerator.a("url", graphQLResearchPollFeedUnit.Q());
        }
        if (graphQLResearchPollFeedUnit.R() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLResearchPollFeedUnit.R());
        }
        if (graphQLResearchPollFeedUnit.S() != null) {
            jsonGenerator.a("local_story_visibility", graphQLResearchPollFeedUnit.S());
        }
        jsonGenerator.a("local_story_visible_height", graphQLResearchPollFeedUnit.T());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollFeedUnit.class, new GraphQLResearchPollFeedUnitSerializer());
    }
}
