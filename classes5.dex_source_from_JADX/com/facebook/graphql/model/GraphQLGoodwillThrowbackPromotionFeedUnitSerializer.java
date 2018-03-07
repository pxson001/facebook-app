package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getRadioDataUptime */
public class GraphQLGoodwillThrowbackPromotionFeedUnitSerializer extends JsonSerializer<GraphQLGoodwillThrowbackPromotionFeedUnit> {
    public final void m8101a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillThrowbackPromotionFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.l() != null) {
            jsonGenerator.a("accent_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.l(), true);
        }
        jsonGenerator.a("action_links");
        if (graphQLGoodwillThrowbackPromotionFeedUnit.m() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLGoodwillThrowbackPromotionFeedUnit.m()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("additional_accent_images");
        if (graphQLGoodwillThrowbackPromotionFeedUnit.n() != null) {
            jsonGenerator.d();
            for (GraphQLImage graphQLImage : graphQLGoodwillThrowbackPromotionFeedUnit.n()) {
                if (graphQLImage != null) {
                    GraphQLImage__JsonHelper.a(jsonGenerator, graphQLImage, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLGoodwillThrowbackPromotionFeedUnit.g());
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.u() != null) {
            jsonGenerator.a("call_to_action");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.u(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.v() != null) {
            jsonGenerator.a("campaigns");
            GraphQLGoodwillThrowbackPromotedCampaignsConnection__JsonHelper.m8078a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.v(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.w() != null) {
            jsonGenerator.a("color_palette");
            GraphQLGoodwillThrowbackPromotionColorPalette__JsonHelper.m8097a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.w(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.x() != null) {
            jsonGenerator.a("content_summary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.x(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLGoodwillThrowbackPromotionFeedUnit.S_());
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.z() != null) {
            jsonGenerator.a("favicon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.z(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLGoodwillThrowbackPromotionFeedUnit.T_());
        if (graphQLGoodwillThrowbackPromotionFeedUnit.A() != null) {
            jsonGenerator.a("full_width_accent_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.A(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.y() != null) {
            jsonGenerator.a("hideable_token", graphQLGoodwillThrowbackPromotionFeedUnit.y());
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.B() != null) {
            jsonGenerator.a("id", graphQLGoodwillThrowbackPromotionFeedUnit.B());
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.C() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.C(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.D() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.D(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.E() != null) {
            jsonGenerator.a("promoted_stories");
            GraphQLGoodwillThrowbackPromotedStoriesConnection__JsonHelper.m8087a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.E(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.F() != null) {
            jsonGenerator.a("render_style", graphQLGoodwillThrowbackPromotionFeedUnit.F());
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.G() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLGoodwillThrowbackPromotionFeedUnit.G());
        }
        jsonGenerator.a("throwbackPromotionActionLinks");
        if (graphQLGoodwillThrowbackPromotionFeedUnit.H() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink2 : graphQLGoodwillThrowbackPromotionFeedUnit.H()) {
                if (graphQLStoryActionLink2 != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.I() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.I(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.J() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackPromotionFeedUnit.J(), true);
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLGoodwillThrowbackPromotionFeedUnit.k());
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.K() != null) {
            jsonGenerator.a("url", graphQLGoodwillThrowbackPromotionFeedUnit.K());
        }
        jsonGenerator.a("years_ago", graphQLGoodwillThrowbackPromotionFeedUnit.L());
        if (graphQLGoodwillThrowbackPromotionFeedUnit.M() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLGoodwillThrowbackPromotionFeedUnit.M());
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.N() != null) {
            jsonGenerator.a("local_story_visibility", graphQLGoodwillThrowbackPromotionFeedUnit.N());
        }
        jsonGenerator.a("local_story_visible_height", graphQLGoodwillThrowbackPromotionFeedUnit.O());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotionFeedUnit.class, new GraphQLGoodwillThrowbackPromotionFeedUnitSerializer());
    }
}
