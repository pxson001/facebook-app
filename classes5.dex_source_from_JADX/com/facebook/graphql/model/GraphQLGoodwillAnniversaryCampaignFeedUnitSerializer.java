package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_configs */
public class GraphQLGoodwillAnniversaryCampaignFeedUnitSerializer extends JsonSerializer<GraphQLGoodwillAnniversaryCampaignFeedUnit> {
    public final void m7791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = (GraphQLGoodwillAnniversaryCampaignFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillAnniversaryCampaignFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.l() != null) {
            jsonGenerator.a("anniversary_campaign");
            GraphQLGoodwillAnniversaryCampaign__JsonHelper.m7795a(jsonGenerator, graphQLGoodwillAnniversaryCampaignFeedUnit.l(), true);
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLGoodwillAnniversaryCampaignFeedUnit.g());
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLGoodwillAnniversaryCampaignFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLGoodwillAnniversaryCampaignFeedUnit.T_());
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.y() != null) {
            jsonGenerator.a("hideable_token", graphQLGoodwillAnniversaryCampaignFeedUnit.y());
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.m() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLGoodwillAnniversaryCampaignFeedUnit.m(), true);
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.n() != null) {
            jsonGenerator.a("render_style", graphQLGoodwillAnniversaryCampaignFeedUnit.n());
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.r() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLGoodwillAnniversaryCampaignFeedUnit.r());
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLGoodwillAnniversaryCampaignFeedUnit.k());
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.s() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLGoodwillAnniversaryCampaignFeedUnit.s());
        }
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.t() != null) {
            jsonGenerator.a("local_story_visibility", graphQLGoodwillAnniversaryCampaignFeedUnit.t());
        }
        jsonGenerator.a("local_story_visible_height", graphQLGoodwillAnniversaryCampaignFeedUnit.u());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillAnniversaryCampaignFeedUnit.class, new GraphQLGoodwillAnniversaryCampaignFeedUnitSerializer());
    }
}
