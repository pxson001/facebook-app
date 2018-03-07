package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: front_view_image */
public class GraphQLGreetingCardPromotionFeedUnitSerializer extends JsonSerializer<GraphQLGreetingCardPromotionFeedUnit> {
    public final void m8328a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardPromotionFeedUnit graphQLGreetingCardPromotionFeedUnit = (GraphQLGreetingCardPromotionFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGreetingCardPromotionFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGreetingCardPromotionFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGreetingCardPromotionFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLGreetingCardPromotionFeedUnit.g());
        }
        if (graphQLGreetingCardPromotionFeedUnit.k() != null) {
            jsonGenerator.a("caption");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGreetingCardPromotionFeedUnit.k(), true);
        }
        if (graphQLGreetingCardPromotionFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLGreetingCardPromotionFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLGreetingCardPromotionFeedUnit.T_());
        if (graphQLGreetingCardPromotionFeedUnit.y() != null) {
            jsonGenerator.a("hideable_token", graphQLGreetingCardPromotionFeedUnit.y());
        }
        if (graphQLGreetingCardPromotionFeedUnit.C() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLGreetingCardPromotionFeedUnit.C(), true);
        }
        if (graphQLGreetingCardPromotionFeedUnit.l() != null) {
            jsonGenerator.a("prefilled_greeting_card");
            GraphQLGreetingCard__JsonHelper.m8377a(jsonGenerator, graphQLGreetingCardPromotionFeedUnit.l(), true);
        }
        if (graphQLGreetingCardPromotionFeedUnit.m() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLGreetingCardPromotionFeedUnit.m(), true);
        }
        if (graphQLGreetingCardPromotionFeedUnit.n() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLGreetingCardPromotionFeedUnit.n());
        }
        if (graphQLGreetingCardPromotionFeedUnit.u() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGreetingCardPromotionFeedUnit.u(), true);
        }
        if (graphQLGreetingCardPromotionFeedUnit.v() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGreetingCardPromotionFeedUnit.v(), true);
        }
        if (graphQLGreetingCardPromotionFeedUnit.w() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLGreetingCardPromotionFeedUnit.w());
        }
        if (graphQLGreetingCardPromotionFeedUnit.x() != null) {
            jsonGenerator.a("local_story_visibility", graphQLGreetingCardPromotionFeedUnit.x());
        }
        jsonGenerator.a("local_story_visible_height", graphQLGreetingCardPromotionFeedUnit.z());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardPromotionFeedUnit.class, new GraphQLGreetingCardPromotionFeedUnitSerializer());
    }
}
