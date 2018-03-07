package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupCategory;
import com.facebook.graphql.enums.GraphQLGroupContentRestrictionReason;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: frames_prompt */
public final class GraphQLGroup__JsonHelper {
    public static GraphQLGroup m8518a(JsonParser jsonParser) {
        GraphQLGroup graphQLGroup = new GraphQLGroup();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8520a(graphQLGroup, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGroup;
    }

    private static boolean m8520a(GraphQLGroup graphQLGroup, String str, JsonParser jsonParser) {
        long j = 0;
        List list = null;
        GraphQLGroup a;
        if ("admin_aware_group".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = m8518a(FieldAccessQueryTracker.a(jsonParser, "admin_aware_group"));
            }
            graphQLGroup.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "admin_aware_group", graphQLGroup.a_, 0, true);
            return true;
        } else if ("blurredCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "blurredCoverPhoto"));
            }
            graphQLGroup.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "blurredCoverPhoto", graphQLGroup.B_(), 1, true);
            return true;
        } else if ("bookmark_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "bookmark_image"));
            }
            graphQLGroup.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "bookmark_image", graphQLGroup.B_(), 2, true);
            return true;
        } else if ("can_viewer_change_cover_photo".equals(str)) {
            graphQLGroup.g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "can_viewer_change_cover_photo", graphQLGroup.B_(), 3, false);
            return true;
        } else if ("can_viewer_change_name".equals(str)) {
            graphQLGroup.h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "can_viewer_change_name", graphQLGroup.B_(), 4, false);
            return true;
        } else if ("can_viewer_claim_adminship".equals(str)) {
            graphQLGroup.i = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "can_viewer_claim_adminship", graphQLGroup.B_(), 5, false);
            return true;
        } else if ("can_viewer_message".equals(str)) {
            graphQLGroup.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "can_viewer_message", graphQLGroup.B_(), 6, false);
            return true;
        } else if ("can_viewer_post".equals(str)) {
            graphQLGroup.k = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "can_viewer_post", graphQLGroup.B_(), 7, false);
            return true;
        } else if ("community_category".equals(str)) {
            graphQLGroup.l = GraphQLGroupCategory.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "community_category", graphQLGroup.B_(), 8, false);
            return true;
        } else if ("cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "cover_photo"));
            }
            graphQLGroup.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "cover_photo", graphQLGroup.B_(), 9, true);
            return true;
        } else if ("delta_hash".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGroup.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "delta_hash", graphQLGroup.B_(), 10, false);
            return true;
        } else if ("description".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGroup.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "description", graphQLGroup.B_(), 11, false);
            return true;
        } else if ("end_of_privacy_grace_period".equals(str)) {
            graphQLGroup.p = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "end_of_privacy_grace_period", graphQLGroup.B_(), 12, false);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLGroup.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "feedAwesomizerProfilePicture", graphQLGroup.B_(), 13, true);
            return true;
        } else if ("full_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGroup.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "full_name", graphQLGroup.B_(), 14, false);
            return true;
        } else if ("groupItemCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "groupItemCoverPhoto"));
            }
            graphQLGroup.s = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "groupItemCoverPhoto", graphQLGroup.B_(), 15, true);
            return true;
        } else if ("group_cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "group_cover_photo"));
            }
            graphQLGroup.t = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_cover_photo", graphQLGroup.B_(), 16, true);
            return true;
        } else if ("group_logo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "group_logo"));
            }
            graphQLGroup.u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_logo", graphQLGroup.B_(), 17, true);
            return true;
        } else if ("group_mediaset".equals(str)) {
            GraphQLMediaSet a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLMediaSet__JsonHelper.m9076a(FieldAccessQueryTracker.a(jsonParser, "group_mediaset"));
            }
            graphQLGroup.v = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_mediaset", graphQLGroup.B_(), 18, true);
            return true;
        } else if ("group_members".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLGroupMembersConnection__JsonHelper.m8458a(FieldAccessQueryTracker.a(jsonParser, "group_members"));
            }
            graphQLGroup.w = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_members", graphQLGroup.B_(), 19, true);
            return true;
        } else if ("group_members_viewer_friend_count".equals(str)) {
            graphQLGroup.x = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_members_viewer_friend_count", graphQLGroup.B_(), 20, false);
            return true;
        } else if ("group_owner_authored_stories".equals(str)) {
            GraphQLGroupOwnerAuthoredStoriesConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLGroupOwnerAuthoredStoriesConnection__JsonHelper.m8490a(FieldAccessQueryTracker.a(jsonParser, "group_owner_authored_stories"));
            }
            graphQLGroup.y = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_owner_authored_stories", graphQLGroup.B_(), 21, true);
            return true;
        } else if ("group_photorealistic_icon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "group_photorealistic_icon"));
            }
            graphQLGroup.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_photorealistic_icon", graphQLGroup.B_(), 22, true);
            return true;
        } else if ("has_viewer_favorited".equals(str)) {
            graphQLGroup.A = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "has_viewer_favorited", graphQLGroup.B_(), 23, false);
            return true;
        } else if ("has_viewer_hidden".equals(str)) {
            graphQLGroup.B = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "has_viewer_hidden", graphQLGroup.B_(), 24, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGroup.C = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "id", graphQLGroup.B_(), 25, false);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLGroup.D = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "imageHighOrig", graphQLGroup.B_(), 26, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLGroup.E = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "inline_activities", graphQLGroup.B_(), 27, true);
            return true;
        } else if ("is_message_blocked_by_viewer".equals(str)) {
            graphQLGroup.F = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "is_message_blocked_by_viewer", graphQLGroup.B_(), 28, false);
            return true;
        } else if ("is_viewer_newly_added".equals(str)) {
            graphQLGroup.G = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "is_viewer_newly_added", graphQLGroup.B_(), 30, false);
            return true;
        } else if ("join_approval_setting".equals(str)) {
            graphQLGroup.H = GraphQLGroupJoinApprovalSetting.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "join_approval_setting", graphQLGroup.B_(), 31, false);
            return true;
        } else if ("last_activity_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLGroup.I = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "last_activity_time", graphQLGroup.B_(), 32, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGroup.J = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "name", graphQLGroup.B_(), 33, false);
            return true;
        } else if ("name_search_tokens".equals(str)) {
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
                list = ImmutableList.copyOf(r1);
            }
            graphQLGroup.K = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "name_search_tokens", graphQLGroup.B_(), 34, false);
            return true;
        } else if ("parent_group".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = m8518a(FieldAccessQueryTracker.a(jsonParser, "parent_group"));
            }
            graphQLGroup.L = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "parent_group", graphQLGroup.B_(), 35, true);
            return true;
        } else if ("photoForLauncherShortcut".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "photoForLauncherShortcut"));
            }
            graphQLGroup.M = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "photoForLauncherShortcut", graphQLGroup.B_(), 36, true);
            return true;
        } else if ("post_permission_setting".equals(str)) {
            graphQLGroup.N = GraphQLGroupPostPermissionSetting.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "post_permission_setting", graphQLGroup.B_(), 38, false);
            return true;
        } else if ("posted_item_privacy_scope".equals(str)) {
            GraphQLPrivacyScope a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "posted_item_privacy_scope"));
            }
            graphQLGroup.O = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "posted_item_privacy_scope", graphQLGroup.B_(), 39, true);
            return true;
        } else if ("previous_visibility".equals(str)) {
            graphQLGroup.P = GraphQLGroupVisibility.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "previous_visibility", graphQLGroup.B_(), 40, false);
            return true;
        } else if ("privacy_change_threshold".equals(str)) {
            graphQLGroup.Q = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "privacy_change_threshold", graphQLGroup.B_(), 41, false);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLGroup.R = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profileImageLarge", graphQLGroup.B_(), 42, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLGroup.S = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profileImageSmall", graphQLGroup.B_(), 43, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLGroup.T = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profilePicture50", graphQLGroup.B_(), 44, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLGroup.U = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profilePictureHighRes", graphQLGroup.B_(), 45, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLGroup.V = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profilePictureLarge", graphQLGroup.B_(), 46, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLGroup.W = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profile_photo", graphQLGroup.B_(), 47, true);
            return true;
        } else if ("profile_pic_large".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_large"));
            }
            graphQLGroup.X = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profile_pic_large", graphQLGroup.B_(), 48, true);
            return true;
        } else if ("profile_pic_medium".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_medium"));
            }
            graphQLGroup.Y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profile_pic_medium", graphQLGroup.B_(), 49, true);
            return true;
        } else if ("profile_pic_small".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_small"));
            }
            graphQLGroup.Z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profile_pic_small", graphQLGroup.B_(), 50, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLGroup.aa = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profile_picture", graphQLGroup.B_(), 51, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLGroup.ab = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "profile_picture_is_silhouette", graphQLGroup.B_(), 52, false);
            return true;
        } else if ("requires_admin_membership_approval".equals(str)) {
            graphQLGroup.ac = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "requires_admin_membership_approval", graphQLGroup.B_(), 53, false);
            return true;
        } else if ("requires_post_approval".equals(str)) {
            graphQLGroup.ad = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "requires_post_approval", graphQLGroup.B_(), 54, false);
            return true;
        } else if ("seen_group_purposes_modal".equals(str)) {
            graphQLGroup.ae = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "seen_group_purposes_modal", graphQLGroup.B_(), 55, false);
            return true;
        } else if ("settingsRowCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "settingsRowCoverPhoto"));
            }
            graphQLGroup.af = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "settingsRowCoverPhoto", graphQLGroup.B_(), 56, true);
            return true;
        } else if ("should_show_notif_settings_transition_nux".equals(str)) {
            graphQLGroup.ag = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "should_show_notif_settings_transition_nux", graphQLGroup.B_(), 57, false);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLGroup.ah = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "social_context", graphQLGroup.B_(), 58, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLGroup.ai = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "streaming_profile_picture", graphQLGroup.B_(), 59, true);
            return true;
        } else if ("subscribe_status".equals(str)) {
            graphQLGroup.aj = GraphQLSubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "subscribe_status", graphQLGroup.B_(), 60, false);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLGroup.ak = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "taggable_object_profile_picture", graphQLGroup.B_(), 62, true);
            return true;
        } else if ("treehouseMembers".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLGroupMembersConnection__JsonHelper.m8458a(FieldAccessQueryTracker.a(jsonParser, "treehouseMembers"));
            }
            graphQLGroup.al = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "treehouseMembers", graphQLGroup.B_(), 63, true);
            return true;
        } else if ("treehouseheaderCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "treehouseheaderCoverPhoto"));
            }
            graphQLGroup.am = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "treehouseheaderCoverPhoto", graphQLGroup.B_(), 64, true);
            return true;
        } else if ("unread_count".equals(str)) {
            graphQLGroup.an = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "unread_count", graphQLGroup.B_(), 65, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGroup.ao = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "url", graphQLGroup.B_(), 66, false);
            return true;
        } else if ("username".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGroup.ap = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "username", graphQLGroup.B_(), 67, false);
            return true;
        } else if ("video_channel_can_viewer_follow".equals(str)) {
            graphQLGroup.aq = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_can_viewer_follow", graphQLGroup.B_(), 68, false);
            return true;
        } else if ("video_channel_can_viewer_subscribe".equals(str)) {
            graphQLGroup.ar = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_can_viewer_subscribe", graphQLGroup.B_(), 69, false);
            return true;
        } else if ("video_channel_curator_profile".equals(str)) {
            GraphQLProfile a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "video_channel_curator_profile"));
            }
            graphQLGroup.as = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_curator_profile", graphQLGroup.B_(), 70, true);
            return true;
        } else if ("video_channel_has_new".equals(str)) {
            graphQLGroup.at = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_has_new", graphQLGroup.B_(), 71, false);
            return true;
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            graphQLGroup.au = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_has_viewer_subscribed", graphQLGroup.B_(), 72, false);
            return true;
        } else if ("video_channel_is_viewer_following".equals(str)) {
            graphQLGroup.av = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_is_viewer_following", graphQLGroup.B_(), 73, false);
            return true;
        } else if ("video_channel_is_viewer_pinned".equals(str)) {
            graphQLGroup.aw = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_is_viewer_pinned", graphQLGroup.B_(), 74, false);
            return true;
        } else if ("video_channel_max_new_count".equals(str)) {
            graphQLGroup.ax = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_max_new_count", graphQLGroup.B_(), 75, false);
            return true;
        } else if ("video_channel_new_count".equals(str)) {
            graphQLGroup.ay = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_new_count", graphQLGroup.B_(), 76, false);
            return true;
        } else if ("video_channel_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_channel_subtitle"));
            }
            graphQLGroup.az = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_subtitle", graphQLGroup.B_(), 77, true);
            return true;
        } else if ("video_channel_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_channel_title"));
            }
            graphQLGroup.aA = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "video_channel_title", graphQLGroup.B_(), 78, true);
            return true;
        } else if ("viewer_content_safety_restrictions".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLGroupContentRestrictionReason fromString = GraphQLGroupContentRestrictionReason.fromString(jsonParser.o());
                    if (fromString != null) {
                        r1.add(fromString);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLGroup.aB = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_content_safety_restrictions", graphQLGroup.B_(), 79, false);
            return true;
        } else if ("viewer_join_state".equals(str)) {
            graphQLGroup.aC = GraphQLGroupJoinState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_join_state", graphQLGroup.B_(), 80, false);
            return true;
        } else if ("viewer_last_visited_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLGroup.aD = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_last_visited_time", graphQLGroup.B_(), 81, false);
            return true;
        } else if ("viewer_leave_scenario".equals(str)) {
            graphQLGroup.aE = GraphQLLeavingGroupScenario.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_leave_scenario", graphQLGroup.B_(), 82, false);
            return true;
        } else if ("viewer_post_status".equals(str)) {
            graphQLGroup.aF = GraphQLGroupPostStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_post_status", graphQLGroup.B_(), 83, false);
            return true;
        } else if ("viewer_push_subscription_level".equals(str)) {
            graphQLGroup.aG = GraphQLGroupPushSubscriptionLevel.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_push_subscription_level", graphQLGroup.B_(), 84, false);
            return true;
        } else if ("viewer_request_to_join_subscription_level".equals(str)) {
            graphQLGroup.aH = GraphQLGroupRequestToJoinSubscriptionLevel.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_request_to_join_subscription_level", graphQLGroup.B_(), 85, false);
            return true;
        } else if ("viewer_subscription_level".equals(str)) {
            graphQLGroup.aI = GraphQLGroupSubscriptionLevel.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_subscription_level", graphQLGroup.B_(), 86, false);
            return true;
        } else if ("visibility".equals(str)) {
            graphQLGroup.aJ = GraphQLGroupVisibility.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "visibility", graphQLGroup.B_(), 87, false);
            return true;
        } else if ("visibility_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "visibility_sentence"));
            }
            graphQLGroup.aK = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "visibility_sentence", graphQLGroup.B_(), 88, true);
            return true;
        } else if ("work_logo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "work_logo"));
            }
            graphQLGroup.aL = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "work_logo", graphQLGroup.B_(), 89, true);
            return true;
        } else if ("viewer_admin_type".equals(str)) {
            graphQLGroup.aM = GraphQLGroupAdminType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "viewer_admin_type", graphQLGroup.B_(), 90, false);
            return true;
        } else if ("group_configs".equals(str)) {
            GraphQLGroupConfigurationsConnection a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLGroupConfigurationsConnection__JsonHelper.m8398a(FieldAccessQueryTracker.a(jsonParser, "group_configs"));
            }
            graphQLGroup.aN = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_configs", graphQLGroup.B_(), 91, true);
            return true;
        } else if ("tips_channel".equals(str)) {
            GraphQLAYMTChannel a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLAYMTChannel__JsonHelper.m6353a(FieldAccessQueryTracker.a(jsonParser, "tips_channel"));
            }
            graphQLGroup.aO = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "tips_channel", graphQLGroup.B_(), 92, true);
            return true;
        } else if ("is_multi_company_group".equals(str)) {
            graphQLGroup.aP = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "is_multi_company_group", graphQLGroup.B_(), 93, false);
            return true;
        } else if (!"group_topic_tags".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPage a11 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "group_topic_tags"));
                    if (a11 != null) {
                        r1.add(a11);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLGroup.aQ = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroup, "group_topic_tags", graphQLGroup.B_(), 94, true);
            return true;
        }
    }

    public static void m8519a(JsonGenerator jsonGenerator, GraphQLGroup graphQLGroup, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGroup.j() != null) {
            jsonGenerator.a("admin_aware_group");
            m8519a(jsonGenerator, graphQLGroup.j(), true);
        }
        if (graphQLGroup.k() != null) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLGroup.k(), true);
        }
        if (graphQLGroup.l() != null) {
            jsonGenerator.a("bookmark_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.l(), true);
        }
        jsonGenerator.a("can_viewer_change_cover_photo", graphQLGroup.m());
        jsonGenerator.a("can_viewer_change_name", graphQLGroup.n());
        jsonGenerator.a("can_viewer_claim_adminship", graphQLGroup.o());
        jsonGenerator.a("can_viewer_message", graphQLGroup.p());
        jsonGenerator.a("can_viewer_post", graphQLGroup.q());
        if (graphQLGroup.r() != null) {
            jsonGenerator.a("community_category", graphQLGroup.r().toString());
        }
        if (graphQLGroup.s() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLGroup.s(), true);
        }
        if (graphQLGroup.t() != null) {
            jsonGenerator.a("delta_hash", graphQLGroup.t());
        }
        if (graphQLGroup.u() != null) {
            jsonGenerator.a("description", graphQLGroup.u());
        }
        jsonGenerator.a("end_of_privacy_grace_period", graphQLGroup.v());
        if (graphQLGroup.w() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.w(), true);
        }
        if (graphQLGroup.x() != null) {
            jsonGenerator.a("full_name", graphQLGroup.x());
        }
        if (graphQLGroup.y() != null) {
            jsonGenerator.a("groupItemCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLGroup.y(), true);
        }
        if (graphQLGroup.z() != null) {
            jsonGenerator.a("group_cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLGroup.z(), true);
        }
        if (graphQLGroup.A() != null) {
            jsonGenerator.a("group_logo");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.A(), true);
        }
        if (graphQLGroup.B() != null) {
            jsonGenerator.a("group_mediaset");
            GraphQLMediaSet__JsonHelper.m9077a(jsonGenerator, graphQLGroup.B(), true);
        }
        if (graphQLGroup.C() != null) {
            jsonGenerator.a("group_members");
            GraphQLGroupMembersConnection__JsonHelper.m8459a(jsonGenerator, graphQLGroup.C(), true);
        }
        jsonGenerator.a("group_members_viewer_friend_count", graphQLGroup.D());
        if (graphQLGroup.E() != null) {
            jsonGenerator.a("group_owner_authored_stories");
            GraphQLGroupOwnerAuthoredStoriesConnection__JsonHelper.m8491a(jsonGenerator, graphQLGroup.E(), true);
        }
        if (graphQLGroup.F() != null) {
            jsonGenerator.a("group_photorealistic_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.F(), true);
        }
        jsonGenerator.a("has_viewer_favorited", graphQLGroup.G());
        jsonGenerator.a("has_viewer_hidden", graphQLGroup.H());
        if (graphQLGroup.I() != null) {
            jsonGenerator.a("id", graphQLGroup.I());
        }
        if (graphQLGroup.J() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.J(), true);
        }
        if (graphQLGroup.K() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLGroup.K(), true);
        }
        jsonGenerator.a("is_message_blocked_by_viewer", graphQLGroup.L());
        jsonGenerator.a("is_viewer_newly_added", graphQLGroup.M());
        if (graphQLGroup.N() != null) {
            jsonGenerator.a("join_approval_setting", graphQLGroup.N().toString());
        }
        jsonGenerator.a("last_activity_time", graphQLGroup.O());
        if (graphQLGroup.P() != null) {
            jsonGenerator.a("name", graphQLGroup.P());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLGroup.Q() != null) {
            jsonGenerator.d();
            for (String str : graphQLGroup.Q()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroup.R() != null) {
            jsonGenerator.a("parent_group");
            m8519a(jsonGenerator, graphQLGroup.R(), true);
        }
        if (graphQLGroup.S() != null) {
            jsonGenerator.a("photoForLauncherShortcut");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLGroup.S(), true);
        }
        if (graphQLGroup.T() != null) {
            jsonGenerator.a("post_permission_setting", graphQLGroup.T().toString());
        }
        if (graphQLGroup.U() != null) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLGroup.U(), true);
        }
        if (graphQLGroup.V() != null) {
            jsonGenerator.a("previous_visibility", graphQLGroup.V().toString());
        }
        jsonGenerator.a("privacy_change_threshold", graphQLGroup.W());
        if (graphQLGroup.X() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.X(), true);
        }
        if (graphQLGroup.Y() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.Y(), true);
        }
        if (graphQLGroup.Z() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.Z(), true);
        }
        if (graphQLGroup.aa() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.aa(), true);
        }
        if (graphQLGroup.ab() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.ab(), true);
        }
        if (graphQLGroup.ac() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLGroup.ac(), true);
        }
        if (graphQLGroup.ad() != null) {
            jsonGenerator.a("profile_pic_large");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.ad(), true);
        }
        if (graphQLGroup.ae() != null) {
            jsonGenerator.a("profile_pic_medium");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.ae(), true);
        }
        if (graphQLGroup.af() != null) {
            jsonGenerator.a("profile_pic_small");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.af(), true);
        }
        if (graphQLGroup.ag() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.ag(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLGroup.ah());
        jsonGenerator.a("requires_admin_membership_approval", graphQLGroup.ai());
        jsonGenerator.a("requires_post_approval", graphQLGroup.aj());
        jsonGenerator.a("seen_group_purposes_modal", graphQLGroup.ak());
        if (graphQLGroup.al() != null) {
            jsonGenerator.a("settingsRowCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLGroup.al(), true);
        }
        jsonGenerator.a("should_show_notif_settings_transition_nux", graphQLGroup.am());
        if (graphQLGroup.an() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroup.an(), true);
        }
        if (graphQLGroup.ao() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLGroup.ao(), true);
        }
        if (graphQLGroup.ap() != null) {
            jsonGenerator.a("subscribe_status", graphQLGroup.ap().toString());
        }
        if (graphQLGroup.aq() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.aq(), true);
        }
        if (graphQLGroup.ar() != null) {
            jsonGenerator.a("treehouseMembers");
            GraphQLGroupMembersConnection__JsonHelper.m8459a(jsonGenerator, graphQLGroup.ar(), true);
        }
        if (graphQLGroup.as() != null) {
            jsonGenerator.a("treehouseheaderCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLGroup.as(), true);
        }
        jsonGenerator.a("unread_count", graphQLGroup.at());
        if (graphQLGroup.au() != null) {
            jsonGenerator.a("url", graphQLGroup.au());
        }
        if (graphQLGroup.av() != null) {
            jsonGenerator.a("username", graphQLGroup.av());
        }
        jsonGenerator.a("video_channel_can_viewer_follow", graphQLGroup.aw());
        jsonGenerator.a("video_channel_can_viewer_subscribe", graphQLGroup.ax());
        if (graphQLGroup.ay() != null) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLGroup.ay(), true);
        }
        jsonGenerator.a("video_channel_has_new", graphQLGroup.az());
        jsonGenerator.a("video_channel_has_viewer_subscribed", graphQLGroup.aA());
        jsonGenerator.a("video_channel_is_viewer_following", graphQLGroup.aB());
        jsonGenerator.a("video_channel_is_viewer_pinned", graphQLGroup.aC());
        jsonGenerator.a("video_channel_max_new_count", graphQLGroup.aD());
        jsonGenerator.a("video_channel_new_count", graphQLGroup.aE());
        if (graphQLGroup.aF() != null) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroup.aF(), true);
        }
        if (graphQLGroup.aG() != null) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroup.aG(), true);
        }
        jsonGenerator.a("viewer_content_safety_restrictions");
        if (graphQLGroup.aH() != null) {
            jsonGenerator.d();
            for (GraphQLGroupContentRestrictionReason graphQLGroupContentRestrictionReason : graphQLGroup.aH()) {
                if (graphQLGroupContentRestrictionReason != null) {
                    jsonGenerator.b(graphQLGroupContentRestrictionReason.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroup.aI() != null) {
            jsonGenerator.a("viewer_join_state", graphQLGroup.aI().toString());
        }
        jsonGenerator.a("viewer_last_visited_time", graphQLGroup.aJ());
        if (graphQLGroup.aK() != null) {
            jsonGenerator.a("viewer_leave_scenario", graphQLGroup.aK().toString());
        }
        if (graphQLGroup.aL() != null) {
            jsonGenerator.a("viewer_post_status", graphQLGroup.aL().toString());
        }
        if (graphQLGroup.aM() != null) {
            jsonGenerator.a("viewer_push_subscription_level", graphQLGroup.aM().toString());
        }
        if (graphQLGroup.aN() != null) {
            jsonGenerator.a("viewer_request_to_join_subscription_level", graphQLGroup.aN().toString());
        }
        if (graphQLGroup.aO() != null) {
            jsonGenerator.a("viewer_subscription_level", graphQLGroup.aO().toString());
        }
        if (graphQLGroup.aP() != null) {
            jsonGenerator.a("visibility", graphQLGroup.aP().toString());
        }
        if (graphQLGroup.aQ() != null) {
            jsonGenerator.a("visibility_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroup.aQ(), true);
        }
        if (graphQLGroup.aR() != null) {
            jsonGenerator.a("work_logo");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroup.aR(), true);
        }
        if (graphQLGroup.aS() != null) {
            jsonGenerator.a("viewer_admin_type", graphQLGroup.aS().toString());
        }
        if (graphQLGroup.aT() != null) {
            jsonGenerator.a("group_configs");
            GraphQLGroupConfigurationsConnection__JsonHelper.m8399a(jsonGenerator, graphQLGroup.aT(), true);
        }
        if (graphQLGroup.aU() != null) {
            jsonGenerator.a("tips_channel");
            GraphQLAYMTChannel__JsonHelper.m6354a(jsonGenerator, graphQLGroup.aU(), true);
        }
        jsonGenerator.a("is_multi_company_group", graphQLGroup.aV());
        jsonGenerator.a("group_topic_tags");
        if (graphQLGroup.aW() != null) {
            jsonGenerator.d();
            for (GraphQLPage graphQLPage : graphQLGroup.aW()) {
                if (graphQLPage != null) {
                    GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPage, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
