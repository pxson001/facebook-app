package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: gms_unknown */
public final class GraphQLGoodwillThrowbackFeedUnit__JsonHelper {
    public static boolean m7993a(GraphQLGoodwillThrowbackFeedUnit graphQLGoodwillThrowbackFeedUnit, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLGoodwillThrowbackFeedUnit.f3966d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "__type__", graphQLGoodwillThrowbackFeedUnit.a_, 0, false);
            return true;
        } else if ("accent_image".equals(str)) {
            GraphQLImage a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "accent_image"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3967e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "accent_image", graphQLGoodwillThrowbackFeedUnit.B_(), 1, true);
            return true;
        } else if ("action_links".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_links"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.f3968f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "action_links", graphQLGoodwillThrowbackFeedUnit.B_(), 2, true);
            return true;
        } else if ("actions".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLOpenGraphAction a3 = GraphQLOpenGraphAction__JsonHelper.m9395a(FieldAccessQueryTracker.a(jsonParser, "actions"));
                    if (a3 != null) {
                        r1.add(a3);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.f3969g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "actions", graphQLGoodwillThrowbackFeedUnit.B_(), 3, true);
            return true;
        } else if ("actors".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLActor a4 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "actors"));
                    if (a4 != null) {
                        r1.add(a4);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.f3970h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "actors", graphQLGoodwillThrowbackFeedUnit.B_(), 4, true);
            return true;
        } else if ("all_substories".equals(str)) {
            GraphQLSubstoriesConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLSubstoriesConnection__JsonHelper.m22007a(FieldAccessQueryTracker.a(jsonParser, "all_substories"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3971i = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "all_substories", graphQLGoodwillThrowbackFeedUnit.B_(), 5, true);
            return true;
        } else if ("anniversary_campaign".equals(str)) {
            GraphQLGoodwillAnniversaryCampaign a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLGoodwillAnniversaryCampaign__JsonHelper.m7794a(FieldAccessQueryTracker.a(jsonParser, "anniversary_campaign"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3972j = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "anniversary_campaign", graphQLGoodwillThrowbackFeedUnit.B_(), 6, true);
            return true;
        } else if ("application".equals(str)) {
            GraphQLApplication a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "application"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3973k = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "application", graphQLGoodwillThrowbackFeedUnit.B_(), 7, true);
            return true;
        } else if ("attached_action_links".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "attached_action_links"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.f3974l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "attached_action_links", graphQLGoodwillThrowbackFeedUnit.B_(), 8, true);
            return true;
        } else if ("attached_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "attached_story"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3975m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "attached_story", graphQLGoodwillThrowbackFeedUnit.B_(), 9, true);
            return true;
        } else if ("attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "attachments"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.f3976n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "attachments", graphQLGoodwillThrowbackFeedUnit.B_(), 10, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFeedUnit.f3977o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "cache_id", graphQLGoodwillThrowbackFeedUnit.B_(), 11, false);
            return true;
        } else if ("can_viewer_append_photos".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3978p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "can_viewer_append_photos", graphQLGoodwillThrowbackFeedUnit.B_(), 12, false);
            return true;
        } else if ("can_viewer_delete".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3979q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "can_viewer_delete", graphQLGoodwillThrowbackFeedUnit.B_(), 13, false);
            return true;
        } else if ("can_viewer_edit".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3980r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "can_viewer_edit", graphQLGoodwillThrowbackFeedUnit.B_(), 14, false);
            return true;
        } else if ("can_viewer_edit_post_media".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3981s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "can_viewer_edit_post_media", graphQLGoodwillThrowbackFeedUnit.B_(), 15, false);
            return true;
        } else if ("can_viewer_edit_post_privacy".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3982t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "can_viewer_edit_post_privacy", graphQLGoodwillThrowbackFeedUnit.B_(), 16, false);
            return true;
        } else if ("can_viewer_edit_tag".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3983u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "can_viewer_edit_tag", graphQLGoodwillThrowbackFeedUnit.B_(), 17, false);
            return true;
        } else if ("color_palette".equals(str)) {
            GraphQLGoodwillThrowbackPermalinkColorPalette a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLGoodwillThrowbackPermalinkColorPalette__JsonHelper.m8068a(FieldAccessQueryTracker.a(jsonParser, "color_palette"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3984v = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "color_palette", graphQLGoodwillThrowbackFeedUnit.B_(), 18, true);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3985w = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "creation_time", graphQLGoodwillThrowbackFeedUnit.B_(), 19, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFeedUnit.f3986x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "debug_info", graphQLGoodwillThrowbackFeedUnit.B_(), 20, false);
            return true;
        } else if ("display_explanation".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "display_explanation"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3987y = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "display_explanation", graphQLGoodwillThrowbackFeedUnit.B_(), 21, true);
            return true;
        } else if ("edit_history".equals(str)) {
            GraphQLEditHistoryConnection a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLEditHistoryConnection__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "edit_history"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3988z = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "edit_history", graphQLGoodwillThrowbackFeedUnit.B_(), 22, true);
            return true;
        } else if ("explicit_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "explicit_place"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3940A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "explicit_place", graphQLGoodwillThrowbackFeedUnit.B_(), 23, true);
            return true;
        } else if ("feed_topic_content".equals(str)) {
            GraphQLFeedTopicContent a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLFeedTopicContent__JsonHelper.m7465a(FieldAccessQueryTracker.a(jsonParser, "feed_topic_content"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3941B = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "feed_topic_content", graphQLGoodwillThrowbackFeedUnit.B_(), 24, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3942C = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "feedback", graphQLGoodwillThrowbackFeedUnit.B_(), 25, true);
            return true;
        } else if ("friend_description".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "friend_description"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3943D = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "friend_description", graphQLGoodwillThrowbackFeedUnit.B_(), 26, true);
            return true;
        } else if ("friend_list".equals(str)) {
            GraphQLGoodwillThrowbackFriendListConnection a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLGoodwillThrowbackFriendListConnection__JsonHelper.m8001a(FieldAccessQueryTracker.a(jsonParser, "friend_list"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3944E = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "friend_list", graphQLGoodwillThrowbackFeedUnit.B_(), 27, true);
            return true;
        } else if ("friendversary_campaign".equals(str)) {
            GraphQLGoodwillFriendversaryCampaign a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLGoodwillFriendversaryCampaign__JsonHelper.m7881a(FieldAccessQueryTracker.a(jsonParser, "friendversary_campaign"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3945F = a13;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "friendversary_campaign", graphQLGoodwillThrowbackFeedUnit.B_(), 28, true);
            return true;
        } else if ("has_comprehensive_title".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3946G = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "has_comprehensive_title", graphQLGoodwillThrowbackFeedUnit.B_(), 29, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFeedUnit.f3947H = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "hideable_token", graphQLGoodwillThrowbackFeedUnit.B_(), 30, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFeedUnit.f3948I = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "id", graphQLGoodwillThrowbackFeedUnit.B_(), 31, false);
            return true;
        } else if ("implicit_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "implicit_place"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3949J = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "implicit_place", graphQLGoodwillThrowbackFeedUnit.B_(), 32, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3950K = a14;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "inline_activities", graphQLGoodwillThrowbackFeedUnit.B_(), 33, true);
            return true;
        } else if ("legacy_api_story_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFeedUnit.f3951L = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "legacy_api_story_id", graphQLGoodwillThrowbackFeedUnit.B_(), 34, false);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3952M = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "message", graphQLGoodwillThrowbackFeedUnit.B_(), 35, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a15;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a15 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3953N = a15;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "negative_feedback_actions", graphQLGoodwillThrowbackFeedUnit.B_(), 36, true);
            return true;
        } else if ("photo_attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "photo_attachments"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.f3954O = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "photo_attachments", graphQLGoodwillThrowbackFeedUnit.B_(), 37, true);
            return true;
        } else if ("photo_stories".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStory a16 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "photo_stories"));
                    if (a16 != null) {
                        r1.add(a16);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.f3955P = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "photo_stories", graphQLGoodwillThrowbackFeedUnit.B_(), 38, true);
            return true;
        } else if ("place_recommendation_info".equals(str)) {
            GraphQLPlaceRecommendationPostInfo a17;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a17 = GraphQLPlaceRecommendationPostInfo__JsonHelper.m20893a(FieldAccessQueryTracker.a(jsonParser, "place_recommendation_info"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3956Q = a17;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "place_recommendation_info", graphQLGoodwillThrowbackFeedUnit.B_(), 39, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a18;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a18 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3957R = a18;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "privacy_scope", graphQLGoodwillThrowbackFeedUnit.B_(), 41, true);
            return true;
        } else if ("referenced_sticker".equals(str)) {
            GraphQLSticker a19;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a19 = GraphQLSticker__JsonHelper.m21836a(FieldAccessQueryTracker.a(jsonParser, "referenced_sticker"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3958S = a19;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "referenced_sticker", graphQLGoodwillThrowbackFeedUnit.B_(), 42, true);
            return true;
        } else if ("save_info".equals(str)) {
            GraphQLStorySaveInfo a20;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a20 = GraphQLStorySaveInfo__JsonHelper.m21885a(FieldAccessQueryTracker.a(jsonParser, "save_info"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3959T = a20;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "save_info", graphQLGoodwillThrowbackFeedUnit.B_(), 43, true);
            return true;
        } else if ("section_header".equals(str)) {
            GraphQLGoodwillThrowbackSection a21;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a21 = GraphQLGoodwillThrowbackSection__JsonHelper.m8116a(FieldAccessQueryTracker.a(jsonParser, "section_header"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3960U = a21;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "section_header", graphQLGoodwillThrowbackFeedUnit.B_(), 44, true);
            return true;
        } else if ("shareable".equals(str)) {
            GraphQLEntity a22;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a22 = GraphQLEntity__JsonHelper.m7102a(FieldAccessQueryTracker.a(jsonParser, "shareable"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3961V = a22;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "shareable", graphQLGoodwillThrowbackFeedUnit.B_(), 45, true);
            return true;
        } else if ("sponsored_data".equals(str)) {
            GraphQLSponsoredData a23;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a23 = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "sponsored_data"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3962W = a23;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "sponsored_data", graphQLGoodwillThrowbackFeedUnit.B_(), 46, true);
            return true;
        } else if ("story_header".equals(str)) {
            GraphQLStoryHeader a24;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a24 = GraphQLStoryHeader__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "story_header"));
            }
            graphQLGoodwillThrowbackFeedUnit.f3963X = a24;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "story_header", graphQLGoodwillThrowbackFeedUnit.B_(), 47, true);
            return true;
        } else if ("substories_grouping_reasons".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLSubstoriesGroupingReason fromString = GraphQLSubstoriesGroupingReason.fromString(jsonParser.o());
                    if (fromString != null) {
                        r1.add(fromString);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.f3964Y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "substories_grouping_reasons", graphQLGoodwillThrowbackFeedUnit.B_(), 48, false);
            return true;
        } else if ("substory_count".equals(str)) {
            graphQLGoodwillThrowbackFeedUnit.f3965Z = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "substory_count", graphQLGoodwillThrowbackFeedUnit.B_(), 49, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle"));
            }
            graphQLGoodwillThrowbackFeedUnit.aa = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "subtitle", graphQLGoodwillThrowbackFeedUnit.B_(), 50, true);
            return true;
        } else if ("suffix".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suffix"));
            }
            graphQLGoodwillThrowbackFeedUnit.ab = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "suffix", graphQLGoodwillThrowbackFeedUnit.B_(), 51, true);
            return true;
        } else if ("supplemental_social_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "supplemental_social_story"));
            }
            graphQLGoodwillThrowbackFeedUnit.ac = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "supplemental_social_story", graphQLGoodwillThrowbackFeedUnit.B_(), 52, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLGoodwillThrowbackFeedUnit.ad = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "title", graphQLGoodwillThrowbackFeedUnit.B_(), 53, true);
            return true;
        } else if ("to".equals(str)) {
            GraphQLProfile a25;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a25 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "to"));
            }
            graphQLGoodwillThrowbackFeedUnit.ae = a25;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "to", graphQLGoodwillThrowbackFeedUnit.B_(), 54, true);
            return true;
        } else if ("topics_context".equals(str)) {
            GraphQLStoryTopicsContext a26;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a26 = GraphQLStoryTopicsContext__JsonHelper.m21920a(FieldAccessQueryTracker.a(jsonParser, "topics_context"));
            }
            graphQLGoodwillThrowbackFeedUnit.af = a26;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "topics_context", graphQLGoodwillThrowbackFeedUnit.B_(), 55, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFeedUnit.ag = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "tracking", graphQLGoodwillThrowbackFeedUnit.B_(), 56, false);
            return true;
        } else if ("translatability_for_viewer".equals(str)) {
            GraphQLPostTranslatability a27;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a27 = GraphQLPostTranslatability__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "translatability_for_viewer"));
            }
            graphQLGoodwillThrowbackFeedUnit.ah = a27;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "translatability_for_viewer", graphQLGoodwillThrowbackFeedUnit.B_(), 57, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFeedUnit.ai = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "url", graphQLGoodwillThrowbackFeedUnit.B_(), 59, false);
            return true;
        } else if ("via".equals(str)) {
            GraphQLActor a28;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a28 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "via"));
            }
            graphQLGoodwillThrowbackFeedUnit.aj = a28;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "via", graphQLGoodwillThrowbackFeedUnit.B_(), 60, true);
            return true;
        } else if ("with_tags".equals(str)) {
            GraphQLWithTagsConnection a29;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a29 = GraphQLWithTagsConnection__JsonHelper.m22500a(FieldAccessQueryTracker.a(jsonParser, "with_tags"));
            }
            graphQLGoodwillThrowbackFeedUnit.ak = a29;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "with_tags", graphQLGoodwillThrowbackFeedUnit.B_(), 61, true);
            return true;
        } else if ("render_style".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillThrowbackFeedUnit.al = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "render_style", graphQLGoodwillThrowbackFeedUnit.B_(), 62, false);
            return true;
        } else if ("viewer_edit_post_feature_capabilities".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEditPostFeatureCapability fromString2 = GraphQLEditPostFeatureCapability.fromString(jsonParser.o());
                    if (fromString2 != null) {
                        r1.add(fromString2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackFeedUnit.am = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "viewer_edit_post_feature_capabilities", graphQLGoodwillThrowbackFeedUnit.B_(), 63, false);
            return true;
        } else if (!"message_markdown_html".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message_markdown_html"));
            }
            graphQLGoodwillThrowbackFeedUnit.an = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackFeedUnit, "message_markdown_html", graphQLGoodwillThrowbackFeedUnit.B_(), 64, true);
            return true;
        }
    }
}
