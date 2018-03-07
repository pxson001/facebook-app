package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLStoryTimestampStyle;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: USER_FAILS_PULSAR_GK */
public final class GraphQLStory__JsonHelper {
    public static GraphQLStory m21922a(JsonParser jsonParser) {
        GraphQLStory graphQLStory = new GraphQLStory();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21924a(graphQLStory, i, jsonParser);
            jsonParser.f();
        }
        return graphQLStory;
    }

    private static boolean m21924a(GraphQLStory graphQLStory, String str, JsonParser jsonParser) {
        long j = 0;
        GraphQLBackdatedTime graphQLBackdatedTime = null;
        if ("__type__".equals(str)) {
            graphQLStory.d = GraphQLObjectType.a(jsonParser);
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
            graphQLStory.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "action_links", graphQLStory.a_, 0, true);
            return true;
        } else if ("actions".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLOpenGraphAction a = GraphQLOpenGraphAction__JsonHelper.m9395a(FieldAccessQueryTracker.a(jsonParser, "actions"));
                    if (a != null) {
                        r1.add(a);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLStory.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "actions", graphQLStory.B_(), 1, true);
            return true;
        } else if ("actors".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "actors"));
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
            graphQLStory.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "actors", graphQLStory.B_(), 3, true);
            return true;
        } else if ("all_substories".equals(str)) {
            GraphQLSubstoriesConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLSubstoriesConnection__JsonHelper.m22007a(FieldAccessQueryTracker.a(jsonParser, "all_substories"));
            }
            graphQLStory.h = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "all_substories", graphQLStory.B_(), 4, true);
            return true;
        } else if ("android_urls".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (o != null) {
                        r1.add(o);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLStory.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "android_urls", graphQLStory.B_(), 5, false);
            return true;
        } else if ("app_icon".equals(str)) {
            GraphQLImage a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "app_icon"));
            }
            graphQLStory.j = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "app_icon", graphQLStory.B_(), 6, true);
            return true;
        } else if ("application".equals(str)) {
            GraphQLApplication a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "application"));
            }
            graphQLStory.k = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "application", graphQLStory.B_(), 7, true);
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
            graphQLStory.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "attached_action_links", graphQLStory.B_(), 8, true);
            return true;
        } else if ("attached_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = m21922a(FieldAccessQueryTracker.a(jsonParser, "attached_story"));
            }
            graphQLStory.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "attached_story", graphQLStory.B_(), 9, true);
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
            graphQLStory.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "attachments", graphQLStory.B_(), 10, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "cache_id", graphQLStory.B_(), 11, false);
            return true;
        } else if ("can_viewer_append_photos".equals(str)) {
            graphQLStory.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "can_viewer_append_photos", graphQLStory.B_(), 12, false);
            return true;
        } else if ("can_viewer_delete".equals(str)) {
            graphQLStory.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "can_viewer_delete", graphQLStory.B_(), 13, false);
            return true;
        } else if ("can_viewer_edit".equals(str)) {
            graphQLStory.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "can_viewer_edit", graphQLStory.B_(), 14, false);
            return true;
        } else if ("can_viewer_edit_post_media".equals(str)) {
            graphQLStory.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "can_viewer_edit_post_media", graphQLStory.B_(), 15, false);
            return true;
        } else if ("can_viewer_edit_post_privacy".equals(str)) {
            graphQLStory.t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "can_viewer_edit_post_privacy", graphQLStory.B_(), 16, false);
            return true;
        } else if ("can_viewer_edit_tag".equals(str)) {
            graphQLStory.u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "can_viewer_edit_tag", graphQLStory.B_(), 17, false);
            return true;
        } else if ("composerSessionId".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.v = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "composerSessionId", graphQLStory.B_(), 18, false);
            return true;
        } else if ("container_object_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = m21922a(FieldAccessQueryTracker.a(jsonParser, "container_object_story"));
            }
            graphQLStory.w = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "container_object_story", graphQLStory.B_(), 19, true);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLStory.x = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "creation_time", graphQLStory.B_(), 20, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "debug_info", graphQLStory.B_(), 21, false);
            return true;
        } else if ("display_explanation".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "display_explanation"));
            }
            graphQLStory.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "display_explanation", graphQLStory.B_(), 22, true);
            return true;
        } else if ("edit_history".equals(str)) {
            GraphQLEditHistoryConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLEditHistoryConnection__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "edit_history"));
            }
            graphQLStory.A = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "edit_history", graphQLStory.B_(), 23, true);
            return true;
        } else if ("explicit_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "explicit_place"));
            }
            graphQLStory.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "explicit_place", graphQLStory.B_(), 24, true);
            return true;
        } else if ("feed_topic_content".equals(str)) {
            GraphQLFeedTopicContent a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLFeedTopicContent__JsonHelper.m7465a(FieldAccessQueryTracker.a(jsonParser, "feed_topic_content"));
            }
            graphQLStory.C = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "feed_topic_content", graphQLStory.B_(), 25, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLStory.D = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "feedback", graphQLStory.B_(), 26, true);
            return true;
        } else if ("feedback_context".equals(str)) {
            GraphQLFeedbackContext a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLFeedbackContext__JsonHelper.m7479a(FieldAccessQueryTracker.a(jsonParser, "feedback_context"));
            }
            graphQLStory.E = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "feedback_context", graphQLStory.B_(), 27, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLStory.F = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "fetchTimeMs", graphQLStory.B_(), 28, false);
            return true;
        } else if ("followup_feed_units".equals(str)) {
            GraphQLFollowUpFeedUnitsConnection a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLFollowUpFeedUnitsConnection__JsonHelper.m7532a(FieldAccessQueryTracker.a(jsonParser, "followup_feed_units"));
            }
            graphQLStory.G = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "followup_feed_units", graphQLStory.B_(), 29, true);
            return true;
        } else if ("has_comprehensive_title".equals(str)) {
            graphQLStory.H = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "has_comprehensive_title", graphQLStory.B_(), 30, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.I = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "hideable_token", graphQLStory.B_(), 31, false);
            return true;
        } else if ("icon".equals(str)) {
            GraphQLIcon a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLIcon__JsonHelper.m8613a(FieldAccessQueryTracker.a(jsonParser, "icon"));
            }
            graphQLStory.J = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "icon", graphQLStory.B_(), 33, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.K = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "id", graphQLStory.B_(), 34, false);
            return true;
        } else if ("implicit_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "implicit_place"));
            }
            graphQLStory.L = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "implicit_place", graphQLStory.B_(), 35, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLStory.M = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "inline_activities", graphQLStory.B_(), 36, true);
            return true;
        } else if ("insights".equals(str)) {
            GraphQLStoryInsights a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLStoryInsights__JsonHelper.m21879a(FieldAccessQueryTracker.a(jsonParser, "insights"));
            }
            graphQLStory.N = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "insights", graphQLStory.B_(), 37, true);
            return true;
        } else if ("is_see_first_bumped".equals(str)) {
            graphQLStory.O = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "is_see_first_bumped", graphQLStory.B_(), 38, false);
            return true;
        } else if ("legacy_api_story_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.P = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "legacy_api_story_id", graphQLStory.B_(), 39, false);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLStory.Q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "message", graphQLStory.B_(), 40, true);
            return true;
        } else if ("multiShareAttachmentWithImageFields".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "multiShareAttachmentWithImageFields"));
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
            graphQLStory.R = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "multiShareAttachmentWithImageFields", graphQLStory.B_(), 41, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLStory.S = a13;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "negative_feedback_actions", graphQLStory.B_(), 42, true);
            return true;
        } else if ("place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "place"));
            }
            graphQLStory.T = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "place", graphQLStory.B_(), 43, true);
            return true;
        } else if ("place_recommendation_info".equals(str)) {
            GraphQLPlaceRecommendationPostInfo a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLPlaceRecommendationPostInfo__JsonHelper.m20893a(FieldAccessQueryTracker.a(jsonParser, "place_recommendation_info"));
            }
            graphQLStory.U = a14;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "place_recommendation_info", graphQLStory.B_(), 44, true);
            return true;
        } else if ("post_promotion_info".equals(str)) {
            GraphQLBoostedComponent a15;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a15 = GraphQLBoostedComponent__JsonHelper.m6663a(FieldAccessQueryTracker.a(jsonParser, "post_promotion_info"));
            }
            graphQLStory.V = a15;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "post_promotion_info", graphQLStory.B_(), 45, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a16;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a16 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLStory.W = a16;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "privacy_scope", graphQLStory.B_(), 47, true);
            return true;
        } else if ("promotion_info".equals(str)) {
            GraphQLPagePostPromotionInfo a17;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a17 = GraphQLPagePostPromotionInfo__JsonHelper.m9513a(FieldAccessQueryTracker.a(jsonParser, "promotion_info"));
            }
            graphQLStory.X = a17;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "promotion_info", graphQLStory.B_(), 48, true);
            return true;
        } else if ("redspace_story".equals(str)) {
            GraphQLRedSpaceStoryInfo a18;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a18 = GraphQLRedSpaceStoryInfo__JsonHelper.m21375a(FieldAccessQueryTracker.a(jsonParser, "redspace_story"));
            }
            graphQLStory.Y = a18;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "redspace_story", graphQLStory.B_(), 49, true);
            return true;
        } else if ("referenced_sticker".equals(str)) {
            GraphQLSticker a19;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a19 = GraphQLSticker__JsonHelper.m21836a(FieldAccessQueryTracker.a(jsonParser, "referenced_sticker"));
            }
            graphQLStory.Z = a19;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "referenced_sticker", graphQLStory.B_(), 50, true);
            return true;
        } else if ("save_info".equals(str)) {
            GraphQLStorySaveInfo a20;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a20 = GraphQLStorySaveInfo__JsonHelper.m21885a(FieldAccessQueryTracker.a(jsonParser, "save_info"));
            }
            graphQLStory.aa = a20;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "save_info", graphQLStory.B_(), 51, true);
            return true;
        } else if ("see_first_actors".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "see_first_actors"));
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
            graphQLStory.ab = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "see_first_actors", graphQLStory.B_(), 52, true);
            return true;
        } else if ("seen_state".equals(str)) {
            graphQLStory.ac = GraphQLStorySeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "seen_state", graphQLStory.B_(), 53, false);
            return true;
        } else if ("shareable".equals(str)) {
            GraphQLEntity a21;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a21 = GraphQLEntity__JsonHelper.m7102a(FieldAccessQueryTracker.a(jsonParser, "shareable"));
            }
            graphQLStory.ad = a21;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "shareable", graphQLStory.B_(), 54, true);
            return true;
        } else if ("shortSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "shortSummary"));
            }
            graphQLStory.ae = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "shortSummary", graphQLStory.B_(), 55, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.af = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "short_term_cache_key", graphQLStory.B_(), 56, false);
            return true;
        } else if ("sponsored_data".equals(str)) {
            GraphQLSponsoredData a22;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a22 = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "sponsored_data"));
            }
            graphQLStory.ag = a22;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "sponsored_data", graphQLStory.B_(), 57, true);
            return true;
        } else if ("storyAttachment".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "storyAttachment"));
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
            graphQLStory.ah = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "storyAttachment", graphQLStory.B_(), 58, true);
            return true;
        } else if ("story_header".equals(str)) {
            GraphQLStoryHeader a23;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a23 = GraphQLStoryHeader__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "story_header"));
            }
            graphQLStory.ai = a23;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "story_header", graphQLStory.B_(), 59, true);
            return true;
        } else if ("story_timestamp_style_list".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryTimestampStyle fromString = GraphQLStoryTimestampStyle.fromString(jsonParser.o());
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
            graphQLStory.aj = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "story_timestamp_style_list", graphQLStory.B_(), 60, false);
            return true;
        } else if ("substories_grouping_reasons".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLSubstoriesGroupingReason fromString2 = GraphQLSubstoriesGroupingReason.fromString(jsonParser.o());
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
            graphQLStory.ak = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "substories_grouping_reasons", graphQLStory.B_(), 61, false);
            return true;
        } else if ("substory_count".equals(str)) {
            graphQLStory.al = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "substory_count", graphQLStory.B_(), 62, false);
            return true;
        } else if ("suffix".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suffix"));
            }
            graphQLStory.am = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "suffix", graphQLStory.B_(), 63, true);
            return true;
        } else if ("summary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "summary"));
            }
            graphQLStory.an = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "summary", graphQLStory.B_(), 64, true);
            return true;
        } else if ("supplemental_social_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = m21922a(FieldAccessQueryTracker.a(jsonParser, "supplemental_social_story"));
            }
            graphQLStory.ao = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "supplemental_social_story", graphQLStory.B_(), 65, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLStory.ap = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "title", graphQLStory.B_(), 66, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLStory.aq = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "titleForSummary", graphQLStory.B_(), 67, true);
            return true;
        } else if ("to".equals(str)) {
            GraphQLProfile a24;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a24 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "to"));
            }
            graphQLStory.ar = a24;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "to", graphQLStory.B_(), 69, true);
            return true;
        } else if ("topics_context".equals(str)) {
            GraphQLStoryTopicsContext a25;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a25 = GraphQLStoryTopicsContext__JsonHelper.m21920a(FieldAccessQueryTracker.a(jsonParser, "topics_context"));
            }
            graphQLStory.as = a25;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "topics_context", graphQLStory.B_(), 70, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.at = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "tracking", graphQLStory.B_(), 71, false);
            return true;
        } else if ("translatability_for_viewer".equals(str)) {
            GraphQLPostTranslatability a26;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a26 = GraphQLPostTranslatability__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "translatability_for_viewer"));
            }
            graphQLStory.au = a26;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "translatability_for_viewer", graphQLStory.B_(), 72, true);
            return true;
        } else if ("translated_message_for_viewer".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "translated_message_for_viewer"));
            }
            graphQLStory.av = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "translated_message_for_viewer", graphQLStory.B_(), 73, true);
            return true;
        } else if ("translation_metadata".equals(str)) {
            GraphQLTranslationMetaData a27;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a27 = GraphQLTranslationMetaData__JsonHelper.m22284a(FieldAccessQueryTracker.a(jsonParser, "translation_metadata"));
            }
            graphQLStory.aw = a27;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "translation_metadata", graphQLStory.B_(), 74, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.ax = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "url", graphQLStory.B_(), 76, false);
            return true;
        } else if ("via".equals(str)) {
            GraphQLActor a28;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a28 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "via"));
            }
            graphQLStory.ay = a28;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "via", graphQLStory.B_(), 77, true);
            return true;
        } else if ("viewer_readstate".equals(str)) {
            graphQLStory.az = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "viewer_readstate", graphQLStory.B_(), 78, false);
            return true;
        } else if ("with_tags".equals(str)) {
            GraphQLWithTagsConnection a29;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a29 = GraphQLWithTagsConnection__JsonHelper.m22500a(FieldAccessQueryTracker.a(jsonParser, "with_tags"));
            }
            graphQLStory.aA = a29;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "with_tags", graphQLStory.B_(), 79, true);
            return true;
        } else if ("viewer_edit_post_feature_capabilities".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEditPostFeatureCapability fromString3 = GraphQLEditPostFeatureCapability.fromString(jsonParser.o());
                    if (fromString3 != null) {
                        r1.add(fromString3);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLStory.aB = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "viewer_edit_post_feature_capabilities", graphQLStory.B_(), 80, false);
            return true;
        } else if ("local_group_did_approve".equals(str)) {
            graphQLStory.aC = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "local_group_did_approve", graphQLStory.B_(), 81, false);
            return true;
        } else if ("local_group_did_ignore_report".equals(str)) {
            graphQLStory.aD = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "local_group_did_ignore_report", graphQLStory.B_(), 82, false);
            return true;
        } else if ("local_group_did_pin".equals(str)) {
            graphQLStory.aE = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "local_group_did_pin", graphQLStory.B_(), 83, false);
            return true;
        } else if ("local_group_did_unpin".equals(str)) {
            graphQLStory.aF = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "local_group_did_unpin", graphQLStory.B_(), 84, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.aG = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "local_last_negative_feedback_action_type", graphQLStory.B_(), 85, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStory.aH = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "local_story_visibility", graphQLStory.B_(), 86, false);
            return true;
        } else if ("story_ranking_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLStory.aI = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "story_ranking_time", graphQLStory.B_(), 87, false);
            return true;
        } else if ("message_markdown_html".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message_markdown_html"));
            }
            graphQLStory.aJ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "message_markdown_html", graphQLStory.B_(), 88, true);
            return true;
        } else if ("local_story_visible_height".equals(str)) {
            graphQLStory.aK = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "local_story_visible_height", graphQLStory.B_(), 89, false);
            return true;
        } else if (!"backdated_time".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLBackdatedTime = GraphQLBackdatedTime__JsonHelper.m6633a(FieldAccessQueryTracker.a(jsonParser, "backdated_time"));
            }
            graphQLStory.aL = graphQLBackdatedTime;
            FieldAccessQueryTracker.a(jsonParser, graphQLStory, "backdated_time", graphQLStory.B_(), 90, true);
            return true;
        }
    }

    public static void m21923a(JsonGenerator jsonGenerator, GraphQLStory graphQLStory, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStory.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLStory.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("action_links");
        if (graphQLStory.E() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLStory.E()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("actions");
        if (graphQLStory.F() != null) {
            jsonGenerator.d();
            for (GraphQLOpenGraphAction graphQLOpenGraphAction : graphQLStory.F()) {
                if (graphQLOpenGraphAction != null) {
                    GraphQLOpenGraphAction__JsonHelper.m9396a(jsonGenerator, graphQLOpenGraphAction, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("actors");
        if (graphQLStory.b() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLStory.b()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStory.G() != null) {
            jsonGenerator.a("all_substories");
            GraphQLSubstoriesConnection__JsonHelper.m22008a(jsonGenerator, graphQLStory.G(), true);
        }
        jsonGenerator.a("android_urls");
        if (graphQLStory.H() != null) {
            jsonGenerator.d();
            for (String str : graphQLStory.H()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStory.I() != null) {
            jsonGenerator.a("app_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLStory.I(), true);
        }
        if (graphQLStory.J() != null) {
            jsonGenerator.a("application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLStory.J(), true);
        }
        jsonGenerator.a("attached_action_links");
        if (graphQLStory.K() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink2 : graphQLStory.K()) {
                if (graphQLStoryActionLink2 != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStory.L() != null) {
            jsonGenerator.a("attached_story");
            m21923a(jsonGenerator, graphQLStory.L(), true);
        }
        jsonGenerator.a("attachments");
        if (graphQLStory.M() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.M()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStory.g() != null) {
            jsonGenerator.a("cache_id", graphQLStory.g());
        }
        jsonGenerator.a("can_viewer_append_photos", graphQLStory.N());
        jsonGenerator.a("can_viewer_delete", graphQLStory.O());
        jsonGenerator.a("can_viewer_edit", graphQLStory.P());
        jsonGenerator.a("can_viewer_edit_post_media", graphQLStory.Q());
        jsonGenerator.a("can_viewer_edit_post_privacy", graphQLStory.R());
        jsonGenerator.a("can_viewer_edit_tag", graphQLStory.S());
        if (graphQLStory.T() != null) {
            jsonGenerator.a("composerSessionId", graphQLStory.T());
        }
        if (graphQLStory.U() != null) {
            jsonGenerator.a("container_object_story");
            m21923a(jsonGenerator, graphQLStory.U(), true);
        }
        jsonGenerator.a("creation_time", graphQLStory.V());
        if (graphQLStory.S_() != null) {
            jsonGenerator.a("debug_info", graphQLStory.S_());
        }
        if (graphQLStory.W() != null) {
            jsonGenerator.a("display_explanation");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.W(), true);
        }
        if (graphQLStory.X() != null) {
            jsonGenerator.a("edit_history");
            GraphQLEditHistoryConnection__JsonHelper.a(jsonGenerator, graphQLStory.X(), true);
        }
        if (graphQLStory.Y() != null) {
            jsonGenerator.a("explicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLStory.Y(), true);
        }
        if (graphQLStory.Z() != null) {
            jsonGenerator.a("feed_topic_content");
            GraphQLFeedTopicContent__JsonHelper.m7466a(jsonGenerator, graphQLStory.Z(), true);
        }
        if (graphQLStory.l() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLStory.l(), true);
        }
        if (graphQLStory.aa() != null) {
            jsonGenerator.a("feedback_context");
            GraphQLFeedbackContext__JsonHelper.m7480a(jsonGenerator, graphQLStory.aa(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLStory.T_());
        if (graphQLStory.ab() != null) {
            jsonGenerator.a("followup_feed_units");
            GraphQLFollowUpFeedUnitsConnection__JsonHelper.m7533a(jsonGenerator, graphQLStory.ab(), true);
        }
        jsonGenerator.a("has_comprehensive_title", graphQLStory.ac());
        if (graphQLStory.y() != null) {
            jsonGenerator.a("hideable_token", graphQLStory.y());
        }
        if (graphQLStory.ad() != null) {
            jsonGenerator.a("icon");
            GraphQLIcon__JsonHelper.m8614a(jsonGenerator, graphQLStory.ad(), true);
        }
        if (graphQLStory.c() != null) {
            jsonGenerator.a("id", graphQLStory.c());
        }
        if (graphQLStory.ae() != null) {
            jsonGenerator.a("implicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLStory.ae(), true);
        }
        if (graphQLStory.af() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLStory.af(), true);
        }
        if (graphQLStory.ag() != null) {
            jsonGenerator.a("insights");
            GraphQLStoryInsights__JsonHelper.m21880a(jsonGenerator, graphQLStory.ag(), true);
        }
        jsonGenerator.a("is_see_first_bumped", graphQLStory.ah());
        if (graphQLStory.ai() != null) {
            jsonGenerator.a("legacy_api_story_id", graphQLStory.ai());
        }
        if (graphQLStory.aj() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.aj(), true);
        }
        jsonGenerator.a("multiShareAttachmentWithImageFields");
        if (graphQLStory.ak() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLStory.ak()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStory.C() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLStory.C(), true);
        }
        if (graphQLStory.al() != null) {
            jsonGenerator.a("place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLStory.al(), true);
        }
        if (graphQLStory.am() != null) {
            jsonGenerator.a("place_recommendation_info");
            GraphQLPlaceRecommendationPostInfo__JsonHelper.m20894a(jsonGenerator, graphQLStory.am(), true);
        }
        if (graphQLStory.an() != null) {
            jsonGenerator.a("post_promotion_info");
            GraphQLBoostedComponent__JsonHelper.m6664a(jsonGenerator, graphQLStory.an(), true);
        }
        if (graphQLStory.ao() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLStory.ao(), true);
        }
        if (graphQLStory.ap() != null) {
            jsonGenerator.a("promotion_info");
            GraphQLPagePostPromotionInfo__JsonHelper.m9514a(jsonGenerator, graphQLStory.ap(), true);
        }
        if (graphQLStory.aq() != null) {
            jsonGenerator.a("redspace_story");
            GraphQLRedSpaceStoryInfo__JsonHelper.m21376a(jsonGenerator, graphQLStory.aq(), true);
        }
        if (graphQLStory.ar() != null) {
            jsonGenerator.a("referenced_sticker");
            GraphQLSticker__JsonHelper.m21837a(jsonGenerator, graphQLStory.ar(), true);
        }
        if (graphQLStory.as() != null) {
            jsonGenerator.a("save_info");
            GraphQLStorySaveInfo__JsonHelper.m21886a(jsonGenerator, graphQLStory.as(), true);
        }
        jsonGenerator.a("see_first_actors");
        if (graphQLStory.at() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor2 : graphQLStory.at()) {
                if (graphQLActor2 != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStory.au() != null) {
            jsonGenerator.a("seen_state", graphQLStory.au().toString());
        }
        if (graphQLStory.av() != null) {
            jsonGenerator.a("shareable");
            GraphQLEntity__JsonHelper.m7103a(jsonGenerator, graphQLStory.av(), true);
        }
        if (graphQLStory.aw() != null) {
            jsonGenerator.a("shortSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.aw(), true);
        }
        if (graphQLStory.ax() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLStory.ax());
        }
        if (graphQLStory.ay() != null) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLStory.ay(), true);
        }
        jsonGenerator.a("storyAttachment");
        if (graphQLStory.az() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment22 : graphQLStory.az()) {
                if (graphQLStoryAttachment22 != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment22, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStory.aA() != null) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeader__JsonHelper.a(jsonGenerator, graphQLStory.aA(), true);
        }
        jsonGenerator.a("story_timestamp_style_list");
        if (graphQLStory.aB() != null) {
            jsonGenerator.d();
            for (GraphQLStoryTimestampStyle graphQLStoryTimestampStyle : graphQLStory.aB()) {
                if (graphQLStoryTimestampStyle != null) {
                    jsonGenerator.b(graphQLStoryTimestampStyle.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("substories_grouping_reasons");
        if (graphQLStory.aC() != null) {
            jsonGenerator.d();
            for (GraphQLSubstoriesGroupingReason graphQLSubstoriesGroupingReason : graphQLStory.aC()) {
                if (graphQLSubstoriesGroupingReason != null) {
                    jsonGenerator.b(graphQLSubstoriesGroupingReason.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("substory_count", graphQLStory.aD());
        if (graphQLStory.aE() != null) {
            jsonGenerator.a("suffix");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.aE(), true);
        }
        if (graphQLStory.aF() != null) {
            jsonGenerator.a("summary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.aF(), true);
        }
        if (graphQLStory.aG() != null) {
            jsonGenerator.a("supplemental_social_story");
            m21923a(jsonGenerator, graphQLStory.aG(), true);
        }
        if (graphQLStory.aH() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.aH(), true);
        }
        if (graphQLStory.aI() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.aI(), true);
        }
        if (graphQLStory.aJ() != null) {
            jsonGenerator.a("to");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLStory.aJ(), true);
        }
        if (graphQLStory.aK() != null) {
            jsonGenerator.a("topics_context");
            GraphQLStoryTopicsContext__JsonHelper.m21921a(jsonGenerator, graphQLStory.aK(), true);
        }
        if (graphQLStory.k() != null) {
            jsonGenerator.a("tracking", graphQLStory.k());
        }
        if (graphQLStory.aL() != null) {
            jsonGenerator.a("translatability_for_viewer");
            GraphQLPostTranslatability__JsonHelper.a(jsonGenerator, graphQLStory.aL(), true);
        }
        if (graphQLStory.aM() != null) {
            jsonGenerator.a("translated_message_for_viewer");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.aM(), true);
        }
        if (graphQLStory.aN() != null) {
            jsonGenerator.a("translation_metadata");
            GraphQLTranslationMetaData__JsonHelper.m22285a(jsonGenerator, graphQLStory.aN(), true);
        }
        if (graphQLStory.aO() != null) {
            jsonGenerator.a("url", graphQLStory.aO());
        }
        if (graphQLStory.aP() != null) {
            jsonGenerator.a("via");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLStory.aP(), true);
        }
        jsonGenerator.a("viewer_readstate", graphQLStory.aQ());
        if (graphQLStory.aR() != null) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnection__JsonHelper.m22501a(jsonGenerator, graphQLStory.aR(), true);
        }
        jsonGenerator.a("viewer_edit_post_feature_capabilities");
        if (graphQLStory.aS() != null) {
            jsonGenerator.d();
            for (GraphQLEditPostFeatureCapability graphQLEditPostFeatureCapability : graphQLStory.aS()) {
                if (graphQLEditPostFeatureCapability != null) {
                    jsonGenerator.b(graphQLEditPostFeatureCapability.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("local_group_did_approve", graphQLStory.aT());
        jsonGenerator.a("local_group_did_ignore_report", graphQLStory.aU());
        jsonGenerator.a("local_group_did_pin", graphQLStory.aV());
        jsonGenerator.a("local_group_did_unpin", graphQLStory.aW());
        if (graphQLStory.aX() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLStory.aX());
        }
        if (graphQLStory.aY() != null) {
            jsonGenerator.a("local_story_visibility", graphQLStory.aY());
        }
        jsonGenerator.a("story_ranking_time", graphQLStory.aZ());
        if (graphQLStory.ba() != null) {
            jsonGenerator.a("message_markdown_html");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStory.ba(), true);
        }
        jsonGenerator.a("local_story_visible_height", graphQLStory.bb());
        if (graphQLStory.bc() != null) {
            jsonGenerator.a("backdated_time");
            GraphQLBackdatedTime__JsonHelper.m6634a(jsonGenerator, graphQLStory.bc(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
