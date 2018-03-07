package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: sModelFiles */
public final class GraphQLUser__JsonHelper {
    public static GraphQLUser m3267a(JsonParser jsonParser) {
        GraphQLUser graphQLUser = new GraphQLUser();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3269a(graphQLUser, i, jsonParser);
            jsonParser.f();
        }
        return graphQLUser;
    }

    private static boolean m3269a(GraphQLUser graphQLUser, String str, JsonParser jsonParser) {
        long j = 0;
        double d = 0.0d;
        GraphQLProfileVideo graphQLProfileVideo = null;
        GraphQLImage a;
        if ("Image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "Image"));
            }
            graphQLUser.d = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "Image", graphQLUser.a_, 0, true);
            return true;
        } else if ("address".equals(str)) {
            GraphQLStreetAddress a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLStreetAddress__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "address"));
            }
            graphQLUser.e = a2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "address", graphQLUser.B_(), 1, true);
            return true;
        } else if ("albums".equals(str)) {
            GraphQLAlbumsConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLAlbumsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "albums"));
            }
            graphQLUser.f = a3;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "albums", graphQLUser.B_(), 2, true);
            return true;
        } else if ("alternate_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.g = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "alternate_name", graphQLUser.B_(), 4, false);
            return true;
        } else if ("backstage_audience_mode".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.h = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "backstage_audience_mode", graphQLUser.B_(), 5, false);
            return true;
        } else if ("bio_text".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "bio_text"));
            }
            graphQLUser.i = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "bio_text", graphQLUser.B_(), 6, true);
            return true;
        } else if ("birthdayFriends".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFriendsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "birthdayFriends"));
            }
            graphQLUser.j = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "birthdayFriends", graphQLUser.B_(), 7, true);
            return true;
        } else if ("blurredCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "blurredCoverPhoto"));
            }
            graphQLUser.k = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "blurredCoverPhoto", graphQLUser.B_(), 8, true);
            return true;
        } else if ("bylines".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLBylineFragment a4 = GraphQLBylineFragment__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "bylines"));
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
            graphQLUser.l = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "bylines", graphQLUser.B_(), 9, true);
            return true;
        } else if ("can_see_viewer_montage_thread".equals(str)) {
            graphQLUser.m = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "can_see_viewer_montage_thread", graphQLUser.B_(), 10, false);
            return true;
        } else if ("can_viewer_act_as_memorial_contact".equals(str)) {
            graphQLUser.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "can_viewer_act_as_memorial_contact", graphQLUser.B_(), 11, false);
            return true;
        } else if ("can_viewer_block".equals(str)) {
            graphQLUser.o = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "can_viewer_block", graphQLUser.B_(), 12, false);
            return true;
        } else if ("can_viewer_message".equals(str)) {
            graphQLUser.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "can_viewer_message", graphQLUser.B_(), 13, false);
            return true;
        } else if ("can_viewer_poke".equals(str)) {
            graphQLUser.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "can_viewer_poke", graphQLUser.B_(), 14, false);
            return true;
        } else if ("can_viewer_post".equals(str)) {
            graphQLUser.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "can_viewer_post", graphQLUser.B_(), 15, false);
            return true;
        } else if ("can_viewer_report".equals(str)) {
            graphQLUser.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "can_viewer_report", graphQLUser.B_(), 16, false);
            return true;
        } else if ("communicationRank".equals(str)) {
            graphQLUser.t = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "communicationRank", graphQLUser.B_(), 17, false);
            return true;
        } else if ("contact".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLContact__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "contact"));
            }
            graphQLUser.u = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "contact", graphQLUser.B_(), 18, true);
            return true;
        } else if ("cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "cover_photo"));
            }
            graphQLUser.v = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "cover_photo", graphQLUser.B_(), 19, true);
            return true;
        } else if ("current_city".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPage__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "current_city"));
            }
            graphQLUser.w = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "current_city", graphQLUser.B_(), 20, true);
            return true;
        } else if ("education_experiences".equals(str)) {
            GraphQLUserEducationExperiencesConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLUserEducationExperiencesConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "education_experiences"));
            }
            graphQLUser.x = a5;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "education_experiences", graphQLUser.B_(), 21, true);
            return true;
        } else if ("email_addresses".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
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
            graphQLUser.y = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "email_addresses", graphQLUser.B_(), 22, false);
            return true;
        } else if ("encrypted_cookie_sync_data".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.z = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "encrypted_cookie_sync_data", graphQLUser.B_(), 23, false);
            return true;
        } else if ("events".equals(str)) {
            GraphQLEventsConnection a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLEventsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "events"));
            }
            graphQLUser.A = a6;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "events", graphQLUser.B_(), 24, true);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLUser.B = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "feedAwesomizerProfilePicture", graphQLUser.B_(), 26, true);
            return true;
        } else if ("firstSection".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTimelineSectionsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "firstSection"));
            }
            graphQLUser.C = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "firstSection", graphQLUser.B_(), 27, true);
            return true;
        } else if ("first_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.D = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "first_name", graphQLUser.B_(), 28, false);
            return true;
        } else if ("followup_feed_units".equals(str)) {
            GraphQLFollowUpFeedUnitsConnection a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLFollowUpFeedUnitsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "followup_feed_units"));
            }
            graphQLUser.E = a7;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "followup_feed_units", graphQLUser.B_(), 29, true);
            return true;
        } else if ("friends".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFriendsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "friends"));
            }
            graphQLUser.F = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "friends", graphQLUser.B_(), 30, true);
            return true;
        } else if ("friendship_status".equals(str)) {
            graphQLUser.G = GraphQLFriendshipStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "friendship_status", graphQLUser.B_(), 31, false);
            return true;
        } else if ("gender".equals(str)) {
            graphQLUser.H = GraphQLGender.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "gender", graphQLUser.B_(), 32, false);
            return true;
        } else if ("hometown".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPage__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "hometown"));
            }
            graphQLUser.I = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "hometown", graphQLUser.B_(), 34, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.J = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "id", graphQLUser.B_(), 35, false);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "imageHighOrig"));
            }
            graphQLUser.K = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "imageHighOrig", graphQLUser.B_(), 36, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLInlineActivitiesConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "inline_activities"));
            }
            graphQLUser.L = a8;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "inline_activities", graphQLUser.B_(), 37, true);
            return true;
        } else if ("is_banned_by_page_viewer".equals(str)) {
            graphQLUser.M = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_banned_by_page_viewer", graphQLUser.B_(), 38, false);
            return true;
        } else if ("is_blocked_by_viewer".equals(str)) {
            graphQLUser.N = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_blocked_by_viewer", graphQLUser.B_(), 39, false);
            return true;
        } else if ("is_deactivated_allowed_on_messenger".equals(str)) {
            graphQLUser.O = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_deactivated_allowed_on_messenger", graphQLUser.B_(), 40, false);
            return true;
        } else if ("is_followed_by_everyone".equals(str)) {
            graphQLUser.P = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_followed_by_everyone", graphQLUser.B_(), 41, false);
            return true;
        } else if ("is_memorialized".equals(str)) {
            graphQLUser.Q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_memorialized", graphQLUser.B_(), 42, false);
            return true;
        } else if ("is_message_blocked_by_viewer".equals(str)) {
            graphQLUser.R = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_message_blocked_by_viewer", graphQLUser.B_(), 43, false);
            return true;
        } else if ("is_messenger_user".equals(str)) {
            graphQLUser.S = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_messenger_user", graphQLUser.B_(), 44, false);
            return true;
        } else if ("is_minor".equals(str)) {
            graphQLUser.T = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_minor", graphQLUser.B_(), 45, false);
            return true;
        } else if ("is_mobile_pushable".equals(str)) {
            graphQLUser.U = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_mobile_pushable", graphQLUser.B_(), 46, false);
            return true;
        } else if ("is_partial".equals(str)) {
            graphQLUser.V = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_partial", graphQLUser.B_(), 47, false);
            return true;
        } else if ("is_pymm_hidden".equals(str)) {
            graphQLUser.W = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_pymm_hidden", graphQLUser.B_(), 48, false);
            return true;
        } else if ("is_pysf_blacklisted".equals(str)) {
            graphQLUser.X = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_pysf_blacklisted", graphQLUser.B_(), 49, false);
            return true;
        } else if ("is_verified".equals(str)) {
            graphQLUser.Y = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_verified", graphQLUser.B_(), 50, false);
            return true;
        } else if ("is_viewer_coworker".equals(str)) {
            graphQLUser.Z = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_viewer_coworker", graphQLUser.B_(), 51, false);
            return true;
        } else if ("is_viewer_friend".equals(str)) {
            graphQLUser.aa = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_viewer_friend", graphQLUser.B_(), 52, false);
            return true;
        } else if ("is_viewer_notified_about".equals(str)) {
            graphQLUser.ab = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_viewer_notified_about", graphQLUser.B_(), 53, false);
            return true;
        } else if ("is_work_user".equals(str)) {
            graphQLUser.ac = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_work_user", graphQLUser.B_(), 54, false);
            return true;
        } else if ("liked_profiles".equals(str)) {
            GraphQLLikedProfilesConnection a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLLikedProfilesConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "liked_profiles"));
            }
            graphQLUser.ad = a9;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "liked_profiles", graphQLUser.B_(), 55, true);
            return true;
        } else if ("live_video_subscription_status".equals(str)) {
            graphQLUser.ae = GraphQLLiveVideoSubscriptionStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "live_video_subscription_status", graphQLUser.B_(), 56, false);
            return true;
        } else if ("lowres_profile".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "lowres_profile"));
            }
            graphQLUser.af = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "lowres_profile", graphQLUser.B_(), 57, true);
            return true;
        } else if ("messenger_contact".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLContact__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "messenger_contact"));
            }
            graphQLUser.ag = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "messenger_contact", graphQLUser.B_(), 58, true);
            return true;
        } else if ("messenger_install_time".equals(str)) {
            graphQLUser.ah = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "messenger_install_time", graphQLUser.B_(), 59, false);
            return true;
        } else if ("messenger_invite_priority".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                d = jsonParser.G();
            }
            graphQLUser.ai = d;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "messenger_invite_priority", graphQLUser.B_(), 60, false);
            return true;
        } else if ("montage_thread_fbid".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.aj = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "montage_thread_fbid", graphQLUser.B_(), 61, false);
            return true;
        } else if ("mutual_friends".equals(str)) {
            GraphQLMutualFriendsConnection a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLMutualFriendsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "mutual_friends"));
            }
            graphQLUser.ak = a10;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "mutual_friends", graphQLUser.B_(), 62, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.al = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "name", graphQLUser.B_(), 63, false);
            return true;
        } else if ("name_search_tokens".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
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
            graphQLUser.am = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "name_search_tokens", graphQLUser.B_(), 64, false);
            return true;
        } else if ("news_feed".equals(str)) {
            GraphQLNewsFeedConnection a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLNewsFeedConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "news_feed"));
            }
            graphQLUser.an = a11;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "news_feed", graphQLUser.B_(), 65, true);
            return true;
        } else if ("posted_item_privacy_scope".equals(str)) {
            GraphQLPrivacyScope a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLPrivacyScope__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "posted_item_privacy_scope"));
            }
            graphQLUser.ao = a12;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "posted_item_privacy_scope", graphQLUser.B_(), 66, true);
            return true;
        } else if ("preliminaryProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "preliminaryProfilePicture"));
            }
            graphQLUser.ap = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "preliminaryProfilePicture", graphQLUser.B_(), 67, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profileImageLarge"));
            }
            graphQLUser.aq = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profileImageLarge", graphQLUser.B_(), 68, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profileImageSmall"));
            }
            graphQLUser.ar = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profileImageSmall", graphQLUser.B_(), 69, true);
            return true;
        } else if ("profilePicture32".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profilePicture32"));
            }
            graphQLUser.as = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profilePicture32", graphQLUser.B_(), 70, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profilePicture50"));
            }
            graphQLUser.at = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profilePicture50", graphQLUser.B_(), 71, true);
            return true;
        } else if ("profilePicture60".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profilePicture60"));
            }
            graphQLUser.au = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profilePicture60", graphQLUser.B_(), 72, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profilePictureHighRes"));
            }
            graphQLUser.av = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profilePictureHighRes", graphQLUser.B_(), 73, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profilePictureLarge"));
            }
            graphQLUser.aw = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profilePictureLarge", graphQLUser.B_(), 74, true);
            return true;
        } else if ("profile_badge".equals(str)) {
            GraphQLProfileBadge a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLProfileBadge__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_badge"));
            }
            graphQLUser.ax = a13;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_badge", graphQLUser.B_(), 75, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLPhoto__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_photo"));
            }
            graphQLUser.ay = a14;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_photo", graphQLUser.B_(), 76, true);
            return true;
        } else if ("profile_pic_large".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_pic_large"));
            }
            graphQLUser.az = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_pic_large", graphQLUser.B_(), 77, true);
            return true;
        } else if ("profile_pic_medium".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_pic_medium"));
            }
            graphQLUser.aA = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_pic_medium", graphQLUser.B_(), 78, true);
            return true;
        } else if ("profile_pic_small".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_pic_small"));
            }
            graphQLUser.aB = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_pic_small", graphQLUser.B_(), 79, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_picture"));
            }
            graphQLUser.aC = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_picture", graphQLUser.B_(), 80, true);
            return true;
        } else if ("profile_picture_expiration_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLUser.aD = j;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_picture_expiration_time", graphQLUser.B_(), 81, false);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLUser.aE = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_picture_is_silhouette", graphQLUser.B_(), 82, false);
            return true;
        } else if ("receiver_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.aF = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "receiver_id", graphQLUser.B_(), 83, false);
            return true;
        } else if ("registration_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLUser.aG = j;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "registration_time", graphQLUser.B_(), 84, false);
            return true;
        } else if ("requestee_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.aH = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "requestee_id", graphQLUser.B_(), 86, false);
            return true;
        } else if ("requester_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.aI = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "requester_id", graphQLUser.B_(), 87, false);
            return true;
        } else if ("secondary_subscribe_status".equals(str)) {
            graphQLUser.aJ = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "secondary_subscribe_status", graphQLUser.B_(), 88, false);
            return true;
        } else if ("sender_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.aK = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "sender_id", graphQLUser.B_(), 89, false);
            return true;
        } else if ("single_publisher_video_channels".equals(str)) {
            GraphQLSinglePublisherVideoChannelsConnection a15;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a15 = GraphQLSinglePublisherVideoChannelsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "single_publisher_video_channels"));
            }
            graphQLUser.aL = a15;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "single_publisher_video_channels", graphQLUser.B_(), 90, true);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "social_context"));
            }
            graphQLUser.aM = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "social_context", graphQLUser.B_(), 91, true);
            return true;
        } else if ("squareProfilePicBig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "squareProfilePicBig"));
            }
            graphQLUser.aN = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "squareProfilePicBig", graphQLUser.B_(), 92, true);
            return true;
        } else if ("squareProfilePicHuge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "squareProfilePicHuge"));
            }
            graphQLUser.aO = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "squareProfilePicHuge", graphQLUser.B_(), 93, true);
            return true;
        } else if ("squareProfilePicSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "squareProfilePicSmall"));
            }
            graphQLUser.aP = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "squareProfilePicSmall", graphQLUser.B_(), 94, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a16;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a16 = GraphQLStreamingImage__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "streaming_profile_picture"));
            }
            graphQLUser.aQ = a16;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "streaming_profile_picture", graphQLUser.B_(), 95, true);
            return true;
        } else if ("structured_name".equals(str)) {
            GraphQLName a17;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a17 = GraphQLName__JsonHelper.m3236a(FieldAccessQueryTracker.m2235a(jsonParser, "structured_name"));
            }
            graphQLUser.aR = a17;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "structured_name", graphQLUser.B_(), 96, true);
            return true;
        } else if ("structured_names".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLName a18 = GraphQLName__JsonHelper.m3236a(FieldAccessQueryTracker.m2235a(jsonParser, "structured_names"));
                    if (a18 != null) {
                        r1.add(a18);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLUser.aS = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "structured_names", graphQLUser.B_(), 97, true);
            return true;
        } else if ("subscribe_status".equals(str)) {
            graphQLUser.aT = GraphQLSubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "subscribe_status", graphQLUser.B_(), 98, false);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLUser.aU = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "taggable_object_profile_picture", graphQLUser.B_(), 99, true);
            return true;
        } else if ("tagline".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "tagline"));
            }
            graphQLUser.aV = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "tagline", graphQLUser.B_(), 100, true);
            return true;
        } else if ("timeline_sections".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTimelineSectionsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "timeline_sections"));
            }
            graphQLUser.aW = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "timeline_sections", graphQLUser.B_(), 101, true);
            return true;
        } else if ("unread_count".equals(str)) {
            graphQLUser.aX = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "unread_count", graphQLUser.B_(), 102, false);
            return true;
        } else if ("unseen_stories".equals(str)) {
            GraphQLUnseenStoriesConnection a19;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a19 = GraphQLUnseenStoriesConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "unseen_stories"));
            }
            graphQLUser.aY = a19;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "unseen_stories", graphQLUser.B_(), 103, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.aZ = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "url", graphQLUser.B_(), 104, false);
            return true;
        } else if ("username".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.ba = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "username", graphQLUser.B_(), 105, false);
            return true;
        } else if ("video_channel_can_viewer_follow".equals(str)) {
            graphQLUser.bb = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_can_viewer_follow", graphQLUser.B_(), 106, false);
            return true;
        } else if ("video_channel_can_viewer_subscribe".equals(str)) {
            graphQLUser.bc = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_can_viewer_subscribe", graphQLUser.B_(), 107, false);
            return true;
        } else if ("video_channel_curator_profile".equals(str)) {
            GraphQLProfile a20;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a20 = GraphQLProfile__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "video_channel_curator_profile"));
            }
            graphQLUser.bd = a20;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_curator_profile", graphQLUser.B_(), 108, true);
            return true;
        } else if ("video_channel_has_new".equals(str)) {
            graphQLUser.be = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_has_new", graphQLUser.B_(), 109, false);
            return true;
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            graphQLUser.bf = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_has_viewer_subscribed", graphQLUser.B_(), 110, false);
            return true;
        } else if ("video_channel_is_viewer_following".equals(str)) {
            graphQLUser.bg = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_is_viewer_following", graphQLUser.B_(), 111, false);
            return true;
        } else if ("video_channel_is_viewer_pinned".equals(str)) {
            graphQLUser.bh = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_is_viewer_pinned", graphQLUser.B_(), 112, false);
            return true;
        } else if ("video_channel_max_new_count".equals(str)) {
            graphQLUser.bi = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_max_new_count", graphQLUser.B_(), 113, false);
            return true;
        } else if ("video_channel_new_count".equals(str)) {
            graphQLUser.bj = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_new_count", graphQLUser.B_(), 114, false);
            return true;
        } else if ("video_channel_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "video_channel_subtitle"));
            }
            graphQLUser.bk = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_subtitle", graphQLUser.B_(), 115, true);
            return true;
        } else if ("video_channel_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "video_channel_title"));
            }
            graphQLUser.bl = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "video_channel_title", graphQLUser.B_(), 116, true);
            return true;
        } else if ("viewer_affinity".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                d = jsonParser.G();
            }
            graphQLUser.bm = d;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "viewer_affinity", graphQLUser.B_(), 117, false);
            return true;
        } else if ("websites".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
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
            graphQLUser.bn = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "websites", graphQLUser.B_(), 119, false);
            return true;
        } else if ("withTaggingRank".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                d = jsonParser.G();
            }
            graphQLUser.bo = d;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "withTaggingRank", graphQLUser.B_(), 120, false);
            return true;
        } else if ("work_experiences".equals(str)) {
            GraphQLUserWorkExperiencesConnection a21;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a21 = GraphQLUserWorkExperiencesConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "work_experiences"));
            }
            graphQLUser.bp = a21;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "work_experiences", graphQLUser.B_(), 121, true);
            return true;
        } else if ("created_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLUser.bq = j;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "created_time", graphQLUser.B_(), 122, false);
            return true;
        } else if ("admin_profile_pic".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "admin_profile_pic"));
            }
            graphQLUser.br = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "admin_profile_pic", graphQLUser.B_(), 123, true);
            return true;
        } else if ("big_profile_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "big_profile_image"));
            }
            graphQLUser.bs = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "big_profile_image", graphQLUser.B_(), 124, true);
            return true;
        } else if ("tiny_profile_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "tiny_profile_image"));
            }
            graphQLUser.bt = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "tiny_profile_image", graphQLUser.B_(), 125, true);
            return true;
        } else if ("mutual_contacts_count".equals(str)) {
            graphQLUser.bu = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "mutual_contacts_count", graphQLUser.B_(), 126, false);
            return true;
        } else if ("short_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLUser.bv = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "short_name", graphQLUser.B_(), 127, false);
            return true;
        } else if ("is_messenger_cymk_hidden".equals(str)) {
            graphQLUser.bw = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "is_messenger_cymk_hidden", graphQLUser.B_(), 128, false);
            return true;
        } else if ("has_viewer_posted_for_birthday".equals(str)) {
            graphQLUser.bx = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "has_viewer_posted_for_birthday", graphQLUser.B_(), 131, false);
            return true;
        } else if ("timeline_stories".equals(str)) {
            GraphQLTimelineStoriesConnection a22;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a22 = GraphQLTimelineStoriesConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "timeline_stories"));
            }
            graphQLUser.by = a22;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "timeline_stories", graphQLUser.B_(), 132, true);
            return true;
        } else if (!"profile_video".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLProfileVideo = GraphQLProfileVideo__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_video"));
            }
            graphQLUser.bz = graphQLProfileVideo;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLUser, "profile_video", graphQLUser.B_(), 133, true);
            return true;
        }
    }

    public static void m3268a(JsonGenerator jsonGenerator, GraphQLUser graphQLUser, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLUser.j() != null) {
            jsonGenerator.a("Image");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.j(), true);
        }
        if (graphQLUser.k() != null) {
            jsonGenerator.a("address");
            GraphQLStreetAddress__JsonHelper.a(jsonGenerator, graphQLUser.k(), true);
        }
        if (graphQLUser.l() != null) {
            jsonGenerator.a("albums");
            GraphQLAlbumsConnection__JsonHelper.a(jsonGenerator, graphQLUser.l(), true);
        }
        if (graphQLUser.m() != null) {
            jsonGenerator.a("alternate_name", graphQLUser.m());
        }
        if (graphQLUser.n() != null) {
            jsonGenerator.a("backstage_audience_mode", graphQLUser.n());
        }
        if (graphQLUser.o() != null) {
            jsonGenerator.a("bio_text");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLUser.o(), true);
        }
        if (graphQLUser.p() != null) {
            jsonGenerator.a("birthdayFriends");
            GraphQLFriendsConnection__JsonHelper.a(jsonGenerator, graphQLUser.p(), true);
        }
        if (graphQLUser.q() != null) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.a(jsonGenerator, graphQLUser.q(), true);
        }
        jsonGenerator.a("bylines");
        if (graphQLUser.r() != null) {
            jsonGenerator.d();
            for (GraphQLBylineFragment graphQLBylineFragment : graphQLUser.r()) {
                if (graphQLBylineFragment != null) {
                    GraphQLBylineFragment__JsonHelper.a(jsonGenerator, graphQLBylineFragment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("can_see_viewer_montage_thread", graphQLUser.s());
        jsonGenerator.a("can_viewer_act_as_memorial_contact", graphQLUser.t());
        jsonGenerator.a("can_viewer_block", graphQLUser.u());
        jsonGenerator.a("can_viewer_message", graphQLUser.v());
        jsonGenerator.a("can_viewer_poke", graphQLUser.w());
        jsonGenerator.a("can_viewer_post", graphQLUser.x());
        jsonGenerator.a("can_viewer_report", graphQLUser.y());
        jsonGenerator.a("communicationRank", graphQLUser.z());
        if (graphQLUser.A() != null) {
            jsonGenerator.a("contact");
            GraphQLContact__JsonHelper.a(jsonGenerator, graphQLUser.A(), true);
        }
        if (graphQLUser.B() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.a(jsonGenerator, graphQLUser.B(), true);
        }
        if (graphQLUser.C() != null) {
            jsonGenerator.a("current_city");
            GraphQLPage__JsonHelper.a(jsonGenerator, graphQLUser.C(), true);
        }
        if (graphQLUser.D() != null) {
            jsonGenerator.a("education_experiences");
            GraphQLUserEducationExperiencesConnection__JsonHelper.a(jsonGenerator, graphQLUser.D(), true);
        }
        jsonGenerator.a("email_addresses");
        if (graphQLUser.E() != null) {
            jsonGenerator.d();
            for (String str : graphQLUser.E()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLUser.F() != null) {
            jsonGenerator.a("encrypted_cookie_sync_data", graphQLUser.F());
        }
        if (graphQLUser.G() != null) {
            jsonGenerator.a("events");
            GraphQLEventsConnection__JsonHelper.a(jsonGenerator, graphQLUser.G(), true);
        }
        if (graphQLUser.H() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.H(), true);
        }
        if (graphQLUser.I() != null) {
            jsonGenerator.a("firstSection");
            GraphQLTimelineSectionsConnection__JsonHelper.a(jsonGenerator, graphQLUser.I(), true);
        }
        if (graphQLUser.J() != null) {
            jsonGenerator.a("first_name", graphQLUser.J());
        }
        if (graphQLUser.K() != null) {
            jsonGenerator.a("followup_feed_units");
            GraphQLFollowUpFeedUnitsConnection__JsonHelper.a(jsonGenerator, graphQLUser.K(), true);
        }
        if (graphQLUser.L() != null) {
            jsonGenerator.a("friends");
            GraphQLFriendsConnection__JsonHelper.a(jsonGenerator, graphQLUser.L(), true);
        }
        if (graphQLUser.M() != null) {
            jsonGenerator.a("friendship_status", graphQLUser.M().toString());
        }
        if (graphQLUser.N() != null) {
            jsonGenerator.a("gender", graphQLUser.N().toString());
        }
        if (graphQLUser.O() != null) {
            jsonGenerator.a("hometown");
            GraphQLPage__JsonHelper.a(jsonGenerator, graphQLUser.O(), true);
        }
        if (graphQLUser.P() != null) {
            jsonGenerator.a("id", graphQLUser.P());
        }
        if (graphQLUser.Q() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.Q(), true);
        }
        if (graphQLUser.R() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.a(jsonGenerator, graphQLUser.R(), true);
        }
        jsonGenerator.a("is_banned_by_page_viewer", graphQLUser.S());
        jsonGenerator.a("is_blocked_by_viewer", graphQLUser.T());
        jsonGenerator.a("is_deactivated_allowed_on_messenger", graphQLUser.U());
        jsonGenerator.a("is_followed_by_everyone", graphQLUser.V());
        jsonGenerator.a("is_memorialized", graphQLUser.W());
        jsonGenerator.a("is_message_blocked_by_viewer", graphQLUser.X());
        jsonGenerator.a("is_messenger_user", graphQLUser.Y());
        jsonGenerator.a("is_minor", graphQLUser.Z());
        jsonGenerator.a("is_mobile_pushable", graphQLUser.aa());
        jsonGenerator.a("is_partial", graphQLUser.ab());
        jsonGenerator.a("is_pymm_hidden", graphQLUser.ac());
        jsonGenerator.a("is_pysf_blacklisted", graphQLUser.ad());
        jsonGenerator.a("is_verified", graphQLUser.ae());
        jsonGenerator.a("is_viewer_coworker", graphQLUser.af());
        jsonGenerator.a("is_viewer_friend", graphQLUser.ag());
        jsonGenerator.a("is_viewer_notified_about", graphQLUser.ah());
        jsonGenerator.a("is_work_user", graphQLUser.ai());
        if (graphQLUser.aj() != null) {
            jsonGenerator.a("liked_profiles");
            GraphQLLikedProfilesConnection__JsonHelper.a(jsonGenerator, graphQLUser.aj(), true);
        }
        if (graphQLUser.ak() != null) {
            jsonGenerator.a("live_video_subscription_status", graphQLUser.ak().toString());
        }
        if (graphQLUser.al() != null) {
            jsonGenerator.a("lowres_profile");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.al(), true);
        }
        if (graphQLUser.am() != null) {
            jsonGenerator.a("messenger_contact");
            GraphQLContact__JsonHelper.a(jsonGenerator, graphQLUser.am(), true);
        }
        jsonGenerator.a("messenger_install_time", graphQLUser.an());
        jsonGenerator.a("messenger_invite_priority", graphQLUser.ao());
        if (graphQLUser.ap() != null) {
            jsonGenerator.a("montage_thread_fbid", graphQLUser.ap());
        }
        if (graphQLUser.aq() != null) {
            jsonGenerator.a("mutual_friends");
            GraphQLMutualFriendsConnection__JsonHelper.a(jsonGenerator, graphQLUser.aq(), true);
        }
        if (graphQLUser.ar() != null) {
            jsonGenerator.a("name", graphQLUser.ar());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLUser.as() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLUser.as()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLUser.at() != null) {
            jsonGenerator.a("news_feed");
            GraphQLNewsFeedConnection__JsonHelper.a(jsonGenerator, graphQLUser.at(), true);
        }
        if (graphQLUser.au() != null) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScope__JsonHelper.a(jsonGenerator, graphQLUser.au(), true);
        }
        if (graphQLUser.av() != null) {
            jsonGenerator.a("preliminaryProfilePicture");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.av(), true);
        }
        if (graphQLUser.aw() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aw(), true);
        }
        if (graphQLUser.ax() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.ax(), true);
        }
        if (graphQLUser.ay() != null) {
            jsonGenerator.a("profilePicture32");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.ay(), true);
        }
        if (graphQLUser.az() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.az(), true);
        }
        if (graphQLUser.aA() != null) {
            jsonGenerator.a("profilePicture60");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aA(), true);
        }
        if (graphQLUser.aB() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aB(), true);
        }
        if (graphQLUser.aC() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aC(), true);
        }
        if (graphQLUser.aD() != null) {
            jsonGenerator.a("profile_badge");
            GraphQLProfileBadge__JsonHelper.a(jsonGenerator, graphQLUser.aD(), true);
        }
        if (graphQLUser.aE() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.a(jsonGenerator, graphQLUser.aE(), true);
        }
        if (graphQLUser.aF() != null) {
            jsonGenerator.a("profile_pic_large");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aF(), true);
        }
        if (graphQLUser.aG() != null) {
            jsonGenerator.a("profile_pic_medium");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aG(), true);
        }
        if (graphQLUser.aH() != null) {
            jsonGenerator.a("profile_pic_small");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aH(), true);
        }
        if (graphQLUser.aI() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aI(), true);
        }
        jsonGenerator.a("profile_picture_expiration_time", graphQLUser.aJ());
        jsonGenerator.a("profile_picture_is_silhouette", graphQLUser.aK());
        if (graphQLUser.aL() != null) {
            jsonGenerator.a("receiver_id", graphQLUser.aL());
        }
        jsonGenerator.a("registration_time", graphQLUser.aM());
        if (graphQLUser.aN() != null) {
            jsonGenerator.a("requestee_id", graphQLUser.aN());
        }
        if (graphQLUser.aO() != null) {
            jsonGenerator.a("requester_id", graphQLUser.aO());
        }
        if (graphQLUser.aP() != null) {
            jsonGenerator.a("secondary_subscribe_status", graphQLUser.aP().toString());
        }
        if (graphQLUser.aQ() != null) {
            jsonGenerator.a("sender_id", graphQLUser.aQ());
        }
        if (graphQLUser.aR() != null) {
            jsonGenerator.a("single_publisher_video_channels");
            GraphQLSinglePublisherVideoChannelsConnection__JsonHelper.a(jsonGenerator, graphQLUser.aR(), true);
        }
        if (graphQLUser.aS() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLUser.aS(), true);
        }
        if (graphQLUser.aT() != null) {
            jsonGenerator.a("squareProfilePicBig");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aT(), true);
        }
        if (graphQLUser.aU() != null) {
            jsonGenerator.a("squareProfilePicHuge");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aU(), true);
        }
        if (graphQLUser.aV() != null) {
            jsonGenerator.a("squareProfilePicSmall");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.aV(), true);
        }
        if (graphQLUser.aW() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.a(jsonGenerator, graphQLUser.aW(), true);
        }
        if (graphQLUser.aX() != null) {
            jsonGenerator.a("structured_name");
            GraphQLName__JsonHelper.m3237a(jsonGenerator, graphQLUser.aX(), true);
        }
        jsonGenerator.a("structured_names");
        if (graphQLUser.aY() != null) {
            jsonGenerator.d();
            for (GraphQLName graphQLName : graphQLUser.aY()) {
                if (graphQLName != null) {
                    GraphQLName__JsonHelper.m3237a(jsonGenerator, graphQLName, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLUser.aZ() != null) {
            jsonGenerator.a("subscribe_status", graphQLUser.aZ().toString());
        }
        if (graphQLUser.ba() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.ba(), true);
        }
        if (graphQLUser.bb() != null) {
            jsonGenerator.a("tagline");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLUser.bb(), true);
        }
        if (graphQLUser.bc() != null) {
            jsonGenerator.a("timeline_sections");
            GraphQLTimelineSectionsConnection__JsonHelper.a(jsonGenerator, graphQLUser.bc(), true);
        }
        jsonGenerator.a("unread_count", graphQLUser.bd());
        if (graphQLUser.be() != null) {
            jsonGenerator.a("unseen_stories");
            GraphQLUnseenStoriesConnection__JsonHelper.a(jsonGenerator, graphQLUser.be(), true);
        }
        if (graphQLUser.bf() != null) {
            jsonGenerator.a("url", graphQLUser.bf());
        }
        if (graphQLUser.bg() != null) {
            jsonGenerator.a("username", graphQLUser.bg());
        }
        jsonGenerator.a("video_channel_can_viewer_follow", graphQLUser.bh());
        jsonGenerator.a("video_channel_can_viewer_subscribe", graphQLUser.bi());
        if (graphQLUser.bj() != null) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfile__JsonHelper.a(jsonGenerator, graphQLUser.bj(), true);
        }
        jsonGenerator.a("video_channel_has_new", graphQLUser.bk());
        jsonGenerator.a("video_channel_has_viewer_subscribed", graphQLUser.bl());
        jsonGenerator.a("video_channel_is_viewer_following", graphQLUser.bm());
        jsonGenerator.a("video_channel_is_viewer_pinned", graphQLUser.bn());
        jsonGenerator.a("video_channel_max_new_count", graphQLUser.bo());
        jsonGenerator.a("video_channel_new_count", graphQLUser.bp());
        if (graphQLUser.bq() != null) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLUser.bq(), true);
        }
        if (graphQLUser.br() != null) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLUser.br(), true);
        }
        jsonGenerator.a("viewer_affinity", graphQLUser.bs());
        jsonGenerator.a("websites");
        if (graphQLUser.bt() != null) {
            jsonGenerator.d();
            for (String str22 : graphQLUser.bt()) {
                if (str22 != null) {
                    jsonGenerator.b(str22);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("withTaggingRank", graphQLUser.bu());
        if (graphQLUser.bv() != null) {
            jsonGenerator.a("work_experiences");
            GraphQLUserWorkExperiencesConnection__JsonHelper.a(jsonGenerator, graphQLUser.bv(), true);
        }
        jsonGenerator.a("created_time", graphQLUser.bw());
        if (graphQLUser.bx() != null) {
            jsonGenerator.a("admin_profile_pic");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.bx(), true);
        }
        if (graphQLUser.by() != null) {
            jsonGenerator.a("big_profile_image");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.by(), true);
        }
        if (graphQLUser.bz() != null) {
            jsonGenerator.a("tiny_profile_image");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLUser.bz(), true);
        }
        jsonGenerator.a("mutual_contacts_count", graphQLUser.bA());
        if (graphQLUser.bB() != null) {
            jsonGenerator.a("short_name", graphQLUser.bB());
        }
        jsonGenerator.a("is_messenger_cymk_hidden", graphQLUser.bC());
        jsonGenerator.a("has_viewer_posted_for_birthday", graphQLUser.bD());
        if (graphQLUser.bE() != null) {
            jsonGenerator.a("timeline_stories");
            GraphQLTimelineStoriesConnection__JsonHelper.a(jsonGenerator, graphQLUser.bE(), true);
        }
        if (graphQLUser.bF() != null) {
            jsonGenerator.a("profile_video");
            GraphQLProfileVideo__JsonHelper.a(jsonGenerator, graphQLUser.bF(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
