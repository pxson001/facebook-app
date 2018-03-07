package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: going */
public class GraphQLGoodwillThrowbackFeedUnitSerializer extends JsonSerializer<GraphQLGoodwillThrowbackFeedUnit> {
    public final void m7992a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackFeedUnit graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7974j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillThrowbackFeedUnit.m7974j().e());
            jsonGenerator.g();
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7975k() != null) {
            jsonGenerator.a("accent_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7975k(), true);
        }
        jsonGenerator.a("action_links");
        if (graphQLGoodwillThrowbackFeedUnit.m7976l() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLGoodwillThrowbackFeedUnit.m7976l()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("actions");
        if (graphQLGoodwillThrowbackFeedUnit.m7977m() != null) {
            jsonGenerator.d();
            for (GraphQLOpenGraphAction graphQLOpenGraphAction : graphQLGoodwillThrowbackFeedUnit.m7977m()) {
                if (graphQLOpenGraphAction != null) {
                    GraphQLOpenGraphAction__JsonHelper.m9396a(jsonGenerator, graphQLOpenGraphAction, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("actors");
        if (graphQLGoodwillThrowbackFeedUnit.m7978n() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLGoodwillThrowbackFeedUnit.m7978n()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7979o() != null) {
            jsonGenerator.a("all_substories");
            GraphQLSubstoriesConnection__JsonHelper.m22008a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7979o(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7980p() != null) {
            jsonGenerator.a("anniversary_campaign");
            GraphQLGoodwillAnniversaryCampaign__JsonHelper.m7795a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7980p(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7981q() != null) {
            jsonGenerator.a("application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7981q(), true);
        }
        jsonGenerator.a("attached_action_links");
        if (graphQLGoodwillThrowbackFeedUnit.m7982r() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink2 : graphQLGoodwillThrowbackFeedUnit.m7982r()) {
                if (graphQLStoryActionLink2 != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7983s() != null) {
            jsonGenerator.a("attached_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7983s(), true);
        }
        jsonGenerator.a("attachments");
        if (graphQLGoodwillThrowbackFeedUnit.m7984t() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLGoodwillThrowbackFeedUnit.m7984t()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7985u() != null) {
            jsonGenerator.a("cache_id", graphQLGoodwillThrowbackFeedUnit.m7985u());
        }
        jsonGenerator.a("can_viewer_append_photos", graphQLGoodwillThrowbackFeedUnit.m7986v());
        jsonGenerator.a("can_viewer_delete", graphQLGoodwillThrowbackFeedUnit.m7987w());
        jsonGenerator.a("can_viewer_edit", graphQLGoodwillThrowbackFeedUnit.m7988x());
        jsonGenerator.a("can_viewer_edit_post_media", graphQLGoodwillThrowbackFeedUnit.m7989y());
        jsonGenerator.a("can_viewer_edit_post_privacy", graphQLGoodwillThrowbackFeedUnit.m7990z());
        jsonGenerator.a("can_viewer_edit_tag", graphQLGoodwillThrowbackFeedUnit.m7944A());
        if (graphQLGoodwillThrowbackFeedUnit.m7945B() != null) {
            jsonGenerator.a("color_palette");
            GraphQLGoodwillThrowbackPermalinkColorPalette__JsonHelper.m8069a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7945B(), true);
        }
        jsonGenerator.a("creation_time", graphQLGoodwillThrowbackFeedUnit.m7946C());
        if (graphQLGoodwillThrowbackFeedUnit.m7947D() != null) {
            jsonGenerator.a("debug_info", graphQLGoodwillThrowbackFeedUnit.m7947D());
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7948E() != null) {
            jsonGenerator.a("display_explanation");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7948E(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7949F() != null) {
            jsonGenerator.a("edit_history");
            GraphQLEditHistoryConnection__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7949F(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7950G() != null) {
            jsonGenerator.a("explicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7950G(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7951H() != null) {
            jsonGenerator.a("feed_topic_content");
            GraphQLFeedTopicContent__JsonHelper.m7466a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7951H(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7952I() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7952I(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7953J() != null) {
            jsonGenerator.a("friend_description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7953J(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7954K() != null) {
            jsonGenerator.a("friend_list");
            GraphQLGoodwillThrowbackFriendListConnection__JsonHelper.m8002a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7954K(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7955L() != null) {
            jsonGenerator.a("friendversary_campaign");
            GraphQLGoodwillFriendversaryCampaign__JsonHelper.m7882a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7955L(), true);
        }
        jsonGenerator.a("has_comprehensive_title", graphQLGoodwillThrowbackFeedUnit.m7956M());
        if (graphQLGoodwillThrowbackFeedUnit.m7957N() != null) {
            jsonGenerator.a("hideable_token", graphQLGoodwillThrowbackFeedUnit.m7957N());
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7958O() != null) {
            jsonGenerator.a("id", graphQLGoodwillThrowbackFeedUnit.m7958O());
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7959P() != null) {
            jsonGenerator.a("implicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7959P(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7960Q() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7960Q(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7961R() != null) {
            jsonGenerator.a("legacy_api_story_id", graphQLGoodwillThrowbackFeedUnit.m7961R());
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7962S() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7962S(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7963T() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7963T(), true);
        }
        jsonGenerator.a("photo_attachments");
        if (graphQLGoodwillThrowbackFeedUnit.m7964U() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLGoodwillThrowbackFeedUnit.m7964U()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("photo_stories");
        if (graphQLGoodwillThrowbackFeedUnit.m7965V() != null) {
            jsonGenerator.d();
            for (GraphQLStory graphQLStory : graphQLGoodwillThrowbackFeedUnit.m7965V()) {
                if (graphQLStory != null) {
                    GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStory, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7966W() != null) {
            jsonGenerator.a("place_recommendation_info");
            GraphQLPlaceRecommendationPostInfo__JsonHelper.m20894a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7966W(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7967X() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7967X(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7968Y() != null) {
            jsonGenerator.a("referenced_sticker");
            GraphQLSticker__JsonHelper.m21837a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7968Y(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.m7969Z() != null) {
            jsonGenerator.a("save_info");
            GraphQLStorySaveInfo__JsonHelper.m21886a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.m7969Z(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.aa() != null) {
            jsonGenerator.a("section_header");
            GraphQLGoodwillThrowbackSection__JsonHelper.m8117a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.aa(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.ab() != null) {
            jsonGenerator.a("shareable");
            GraphQLEntity__JsonHelper.m7103a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.ab(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.ac() != null) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.ac(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.ad() != null) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeader__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.ad(), true);
        }
        jsonGenerator.a("substories_grouping_reasons");
        if (graphQLGoodwillThrowbackFeedUnit.ae() != null) {
            jsonGenerator.d();
            for (GraphQLSubstoriesGroupingReason graphQLSubstoriesGroupingReason : graphQLGoodwillThrowbackFeedUnit.ae()) {
                if (graphQLSubstoriesGroupingReason != null) {
                    jsonGenerator.b(graphQLSubstoriesGroupingReason.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("substory_count", graphQLGoodwillThrowbackFeedUnit.af());
        if (graphQLGoodwillThrowbackFeedUnit.ag() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.ag(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.ah() != null) {
            jsonGenerator.a("suffix");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.ah(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.ai() != null) {
            jsonGenerator.a("supplemental_social_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.ai(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.aj() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.aj(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.ak() != null) {
            jsonGenerator.a("to");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.ak(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.al() != null) {
            jsonGenerator.a("topics_context");
            GraphQLStoryTopicsContext__JsonHelper.m21921a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.al(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.am() != null) {
            jsonGenerator.a("tracking", graphQLGoodwillThrowbackFeedUnit.am());
        }
        if (graphQLGoodwillThrowbackFeedUnit.an() != null) {
            jsonGenerator.a("translatability_for_viewer");
            GraphQLPostTranslatability__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.an(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.ao() != null) {
            jsonGenerator.a("url", graphQLGoodwillThrowbackFeedUnit.ao());
        }
        if (graphQLGoodwillThrowbackFeedUnit.ap() != null) {
            jsonGenerator.a("via");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.ap(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.aq() != null) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnection__JsonHelper.m22501a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.aq(), true);
        }
        if (graphQLGoodwillThrowbackFeedUnit.ar() != null) {
            jsonGenerator.a("render_style", graphQLGoodwillThrowbackFeedUnit.ar());
        }
        jsonGenerator.a("viewer_edit_post_feature_capabilities");
        if (graphQLGoodwillThrowbackFeedUnit.as() != null) {
            jsonGenerator.d();
            for (GraphQLEditPostFeatureCapability graphQLEditPostFeatureCapability : graphQLGoodwillThrowbackFeedUnit.as()) {
                if (graphQLEditPostFeatureCapability != null) {
                    jsonGenerator.b(graphQLEditPostFeatureCapability.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillThrowbackFeedUnit.at() != null) {
            jsonGenerator.a("message_markdown_html");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFeedUnit.at(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackFeedUnit.class, new GraphQLGoodwillThrowbackFeedUnitSerializer());
    }
}
