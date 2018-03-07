package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: VISIT_PAGES_FEED */
public final class GraphQLProfile__JsonHelper {
    public static GraphQLProfile m21114a(JsonParser jsonParser) {
        GraphQLProfile graphQLProfile = new GraphQLProfile();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21116a(graphQLProfile, i, jsonParser);
            jsonParser.f();
        }
        return graphQLProfile;
    }

    private static boolean m21116a(GraphQLProfile graphQLProfile, String str, JsonParser jsonParser) {
        double d = 0.0d;
        GraphQLUser graphQLUser = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLProfile.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "__type__", graphQLProfile.a_, 0, false);
            return true;
        } else if ("address".equals(str)) {
            GraphQLStreetAddress a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLStreetAddress__JsonHelper.m21936a(FieldAccessQueryTracker.a(jsonParser, "address"));
            }
            graphQLProfile.e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "address", graphQLProfile.B_(), 1, true);
            return true;
        } else if ("alternate_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLProfile.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "alternate_name", graphQLProfile.B_(), 3, false);
            return true;
        } else if ("best_description".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "best_description"));
            }
            graphQLProfile.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "best_description", graphQLProfile.B_(), 4, true);
            return true;
        } else if ("bylines".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLBylineFragment a3 = GraphQLBylineFragment__JsonHelper.m6711a(FieldAccessQueryTracker.a(jsonParser, "bylines"));
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
            graphQLProfile.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "bylines", graphQLProfile.B_(), 5, true);
            return true;
        } else if ("can_viewer_act_as_memorial_contact".equals(str)) {
            graphQLProfile.i = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "can_viewer_act_as_memorial_contact", graphQLProfile.B_(), 6, false);
            return true;
        } else if ("can_viewer_block".equals(str)) {
            graphQLProfile.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "can_viewer_block", graphQLProfile.B_(), 7, false);
            return true;
        } else if ("can_viewer_change_guest_status".equals(str)) {
            graphQLProfile.k = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "can_viewer_change_guest_status", graphQLProfile.B_(), 8, false);
            return true;
        } else if ("can_viewer_like".equals(str)) {
            graphQLProfile.l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "can_viewer_like", graphQLProfile.B_(), 9, false);
            return true;
        } else if ("can_viewer_message".equals(str)) {
            graphQLProfile.m = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "can_viewer_message", graphQLProfile.B_(), 10, false);
            return true;
        } else if ("can_viewer_poke".equals(str)) {
            graphQLProfile.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "can_viewer_poke", graphQLProfile.B_(), 11, false);
            return true;
        } else if ("can_viewer_post".equals(str)) {
            graphQLProfile.o = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "can_viewer_post", graphQLProfile.B_(), 12, false);
            return true;
        } else if ("can_viewer_report".equals(str)) {
            graphQLProfile.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "can_viewer_report", graphQLProfile.B_(), 13, false);
            return true;
        } else if ("category_names".equals(str)) {
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
            graphQLProfile.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "category_names", graphQLProfile.B_(), 14, false);
            return true;
        } else if ("communicationRank".equals(str)) {
            graphQLProfile.r = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "communicationRank", graphQLProfile.B_(), 15, false);
            return true;
        } else if ("connection_style".equals(str)) {
            graphQLProfile.s = GraphQLConnectionStyle.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "connection_style", graphQLProfile.B_(), 16, false);
            return true;
        } else if ("cover_photo".equals(str)) {
            GraphQLFocusedPhoto a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "cover_photo"));
            }
            graphQLProfile.t = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "cover_photo", graphQLProfile.B_(), 17, true);
            return true;
        } else if ("does_viewer_like".equals(str)) {
            graphQLProfile.u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "does_viewer_like", graphQLProfile.B_(), 18, false);
            return true;
        } else if ("education_experiences".equals(str)) {
            GraphQLUserEducationExperiencesConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLUserEducationExperiencesConnection__JsonHelper.m22389a(FieldAccessQueryTracker.a(jsonParser, "education_experiences"));
            }
            graphQLProfile.v = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "education_experiences", graphQLProfile.B_(), 19, true);
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
            graphQLProfile.w = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "email_addresses", graphQLProfile.B_(), 20, false);
            return true;
        } else if ("event_kind".equals(str)) {
            graphQLProfile.x = GraphQLEventPrivacyType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "event_kind", graphQLProfile.B_(), 21, false);
            return true;
        } else if ("events_calendar_subscriber_count".equals(str)) {
            graphQLProfile.y = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "events_calendar_subscriber_count", graphQLProfile.B_(), 23, false);
            return true;
        } else if ("events_calendar_subscription_status".equals(str)) {
            graphQLProfile.z = GraphQLEventsCalendarSubscriptionStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "events_calendar_subscription_status", graphQLProfile.B_(), 24, false);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLProfile.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "feedAwesomizerProfilePicture", graphQLProfile.B_(), 25, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLProfile.B = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "feedback", graphQLProfile.B_(), 26, true);
            return true;
        } else if ("friends".equals(str)) {
            GraphQLFriendsConnection a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLFriendsConnection__JsonHelper.m7608a(FieldAccessQueryTracker.a(jsonParser, "friends"));
            }
            graphQLProfile.C = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "friends", graphQLProfile.B_(), 27, true);
            return true;
        } else if ("friendship_status".equals(str)) {
            graphQLProfile.D = GraphQLFriendshipStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "friendship_status", graphQLProfile.B_(), 28, false);
            return true;
        } else if ("group_members".equals(str)) {
            GraphQLGroupMembersConnection a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLGroupMembersConnection__JsonHelper.m8458a(FieldAccessQueryTracker.a(jsonParser, "group_members"));
            }
            graphQLProfile.E = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "group_members", graphQLProfile.B_(), 29, true);
            return true;
        } else if ("group_members_viewer_friend_count".equals(str)) {
            graphQLProfile.F = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "group_members_viewer_friend_count", graphQLProfile.B_(), 30, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLProfile.G = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "id", graphQLProfile.B_(), 31, false);
            return true;
        } else if ("is_followed_by_everyone".equals(str)) {
            graphQLProfile.H = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "is_followed_by_everyone", graphQLProfile.B_(), 33, false);
            return true;
        } else if ("is_messenger_user".equals(str)) {
            graphQLProfile.I = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "is_messenger_user", graphQLProfile.B_(), 34, false);
            return true;
        } else if ("is_playable".equals(str)) {
            graphQLProfile.J = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "is_playable", graphQLProfile.B_(), 35, false);
            return true;
        } else if ("is_verified".equals(str)) {
            graphQLProfile.K = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "is_verified", graphQLProfile.B_(), 36, false);
            return true;
        } else if ("is_viewer_friend".equals(str)) {
            graphQLProfile.L = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "is_viewer_friend", graphQLProfile.B_(), 37, false);
            return true;
        } else if ("is_work_user".equals(str)) {
            graphQLProfile.M = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "is_work_user", graphQLProfile.B_(), 38, false);
            return true;
        } else if ("location".equals(str)) {
            GraphQLLocation a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "location"));
            }
            graphQLProfile.N = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "location", graphQLProfile.B_(), 39, true);
            return true;
        } else if ("mutual_friends".equals(str)) {
            GraphQLMutualFriendsConnection a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLMutualFriendsConnection__JsonHelper.m9146a(FieldAccessQueryTracker.a(jsonParser, "mutual_friends"));
            }
            graphQLProfile.O = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "mutual_friends", graphQLProfile.B_(), 40, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLProfile.P = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "name", graphQLProfile.B_(), 41, false);
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
            graphQLProfile.Q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "name_search_tokens", graphQLProfile.B_(), 42, false);
            return true;
        } else if ("new_activity_count".equals(str)) {
            graphQLProfile.R = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "new_activity_count", graphQLProfile.B_(), 43, false);
            return true;
        } else if ("open_graph_composer_preview".equals(str)) {
            GraphQLStoryAttachment a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "open_graph_composer_preview"));
            }
            graphQLProfile.S = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "open_graph_composer_preview", graphQLProfile.B_(), 44, true);
            return true;
        } else if ("page".equals(str)) {
            GraphQLPage a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
            }
            graphQLProfile.T = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "page", graphQLProfile.B_(), 45, true);
            return true;
        } else if ("page_likers".equals(str)) {
            GraphQLPageLikersConnection a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLPageLikersConnection__JsonHelper.m9494a(FieldAccessQueryTracker.a(jsonParser, "page_likers"));
            }
            graphQLProfile.U = a13;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "page_likers", graphQLProfile.B_(), 46, true);
            return true;
        } else if ("page_visits".equals(str)) {
            GraphQLPageVisitsConnection a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLPageVisitsConnection__JsonHelper.m9551a(FieldAccessQueryTracker.a(jsonParser, "page_visits"));
            }
            graphQLProfile.V = a14;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "page_visits", graphQLProfile.B_(), 47, true);
            return true;
        } else if ("playable_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLProfile.W = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "playable_url", graphQLProfile.B_(), 48, false);
            return true;
        } else if ("posted_item_privacy_scope".equals(str)) {
            GraphQLPrivacyScope a15;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a15 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "posted_item_privacy_scope"));
            }
            graphQLProfile.X = a15;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "posted_item_privacy_scope", graphQLProfile.B_(), 49, true);
            return true;
        } else if ("preliminaryProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "preliminaryProfilePicture"));
            }
            graphQLProfile.Y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "preliminaryProfilePicture", graphQLProfile.B_(), 50, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLProfile.Z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "profileImageLarge", graphQLProfile.B_(), 51, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLProfile.aa = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "profileImageSmall", graphQLProfile.B_(), 52, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLProfile.ab = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "profilePicture50", graphQLProfile.B_(), 53, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLProfile.ac = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "profilePictureLarge", graphQLProfile.B_(), 54, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLProfile.ad = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "profile_picture", graphQLProfile.B_(), 55, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLProfile.ae = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "profile_picture_is_silhouette", graphQLProfile.B_(), 56, false);
            return true;
        } else if ("related_article_title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLProfile.af = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "related_article_title", graphQLProfile.B_(), 57, false);
            return true;
        } else if ("secondary_subscribe_status".equals(str)) {
            graphQLProfile.ag = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "secondary_subscribe_status", graphQLProfile.B_(), 58, false);
            return true;
        } else if ("short_category_names".equals(str)) {
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
            graphQLProfile.ah = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "short_category_names", graphQLProfile.B_(), 59, false);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLProfile.ai = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "social_context", graphQLProfile.B_(), 60, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a16;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a16 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLProfile.aj = a16;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "streaming_profile_picture", graphQLProfile.B_(), 61, true);
            return true;
        } else if ("structured_name".equals(str)) {
            GraphQLName a17;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a17 = GraphQLName__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "structured_name"));
            }
            graphQLProfile.ak = a17;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "structured_name", graphQLProfile.B_(), 62, true);
            return true;
        } else if ("structured_names".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLName a18 = GraphQLName__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "structured_names"));
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
            graphQLProfile.al = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "structured_names", graphQLProfile.B_(), 63, true);
            return true;
        } else if ("subscribe_status".equals(str)) {
            graphQLProfile.am = GraphQLSubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "subscribe_status", graphQLProfile.B_(), 64, false);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLProfile.an = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "taggable_object_profile_picture", graphQLProfile.B_(), 65, true);
            return true;
        } else if ("tagline".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "tagline"));
            }
            graphQLProfile.ao = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "tagline", graphQLProfile.B_(), 66, true);
            return true;
        } else if ("trending_topic_data".equals(str)) {
            GraphQLTrendingTopicData a19;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a19 = GraphQLTrendingTopicData__JsonHelper.m22301a(FieldAccessQueryTracker.a(jsonParser, "trending_topic_data"));
            }
            graphQLProfile.ap = a19;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "trending_topic_data", graphQLProfile.B_(), 68, true);
            return true;
        } else if ("trending_topic_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLProfile.aq = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "trending_topic_name", graphQLProfile.B_(), 69, false);
            return true;
        } else if ("unique_keyword".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLProfile.ar = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "unique_keyword", graphQLProfile.B_(), 70, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLProfile.as = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "url", graphQLProfile.B_(), 71, false);
            return true;
        } else if ("viewer_affinity".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                d = jsonParser.G();
            }
            graphQLProfile.at = d;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "viewer_affinity", graphQLProfile.B_(), 72, false);
            return true;
        } else if ("viewer_guest_status".equals(str)) {
            graphQLProfile.au = GraphQLEventGuestStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "viewer_guest_status", graphQLProfile.B_(), 73, false);
            return true;
        } else if ("viewer_has_pending_invite".equals(str)) {
            graphQLProfile.av = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "viewer_has_pending_invite", graphQLProfile.B_(), 74, false);
            return true;
        } else if ("viewer_join_state".equals(str)) {
            graphQLProfile.aw = GraphQLGroupJoinState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "viewer_join_state", graphQLProfile.B_(), 75, false);
            return true;
        } else if ("viewer_recommendation".equals(str)) {
            GraphQLContactRecommendationField a20;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a20 = GraphQLContactRecommendationField__JsonHelper.m6880a(FieldAccessQueryTracker.a(jsonParser, "viewer_recommendation"));
            }
            graphQLProfile.ax = a20;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "viewer_recommendation", graphQLProfile.B_(), 76, true);
            return true;
        } else if ("viewer_saved_state".equals(str)) {
            graphQLProfile.ay = GraphQLSavedState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "viewer_saved_state", graphQLProfile.B_(), 77, false);
            return true;
        } else if ("viewer_watch_status".equals(str)) {
            graphQLProfile.az = GraphQLEventWatchStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "viewer_watch_status", graphQLProfile.B_(), 78, false);
            return true;
        } else if ("visibility_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "visibility_sentence"));
            }
            graphQLProfile.aA = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "visibility_sentence", graphQLProfile.B_(), 79, true);
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
            graphQLProfile.aB = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "websites", graphQLProfile.B_(), 80, false);
            return true;
        } else if ("work_experiences".equals(str)) {
            GraphQLUserWorkExperiencesConnection a21;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a21 = GraphQLUserWorkExperiencesConnection__JsonHelper.m22405a(FieldAccessQueryTracker.a(jsonParser, "work_experiences"));
            }
            graphQLProfile.aC = a21;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "work_experiences", graphQLProfile.B_(), 81, true);
            return true;
        } else if ("global_share".equals(str)) {
            GraphQLExternalUrl a22;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a22 = GraphQLExternalUrl__JsonHelper.m7429a(FieldAccessQueryTracker.a(jsonParser, "global_share"));
            }
            graphQLProfile.aD = a22;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "global_share", graphQLProfile.B_(), 82, true);
            return true;
        } else if (!"invitee".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLUser = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "invitee"));
            }
            graphQLProfile.aE = graphQLUser;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfile, "invitee", graphQLProfile.B_(), 83, true);
            return true;
        }
    }

    public static void m21115a(JsonGenerator jsonGenerator, GraphQLProfile graphQLProfile, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLProfile.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLProfile.j().e());
            jsonGenerator.g();
        }
        if (graphQLProfile.k() != null) {
            jsonGenerator.a("address");
            GraphQLStreetAddress__JsonHelper.m21937a(jsonGenerator, graphQLProfile.k(), true);
        }
        if (graphQLProfile.l() != null) {
            jsonGenerator.a("alternate_name", graphQLProfile.l());
        }
        if (graphQLProfile.m() != null) {
            jsonGenerator.a("best_description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLProfile.m(), true);
        }
        jsonGenerator.a("bylines");
        if (graphQLProfile.n() != null) {
            jsonGenerator.d();
            for (GraphQLBylineFragment graphQLBylineFragment : graphQLProfile.n()) {
                if (graphQLBylineFragment != null) {
                    GraphQLBylineFragment__JsonHelper.m6712a(jsonGenerator, graphQLBylineFragment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("can_viewer_act_as_memorial_contact", graphQLProfile.o());
        jsonGenerator.a("can_viewer_block", graphQLProfile.p());
        jsonGenerator.a("can_viewer_change_guest_status", graphQLProfile.q());
        jsonGenerator.a("can_viewer_like", graphQLProfile.r());
        jsonGenerator.a("can_viewer_message", graphQLProfile.s());
        jsonGenerator.a("can_viewer_poke", graphQLProfile.t());
        jsonGenerator.a("can_viewer_post", graphQLProfile.u());
        jsonGenerator.a("can_viewer_report", graphQLProfile.v());
        jsonGenerator.a("category_names");
        if (graphQLProfile.w() != null) {
            jsonGenerator.d();
            for (String str : graphQLProfile.w()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("communicationRank", graphQLProfile.x());
        if (graphQLProfile.y() != null) {
            jsonGenerator.a("connection_style", graphQLProfile.y().toString());
        }
        if (graphQLProfile.z() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLProfile.z(), true);
        }
        jsonGenerator.a("does_viewer_like", graphQLProfile.A());
        if (graphQLProfile.B() != null) {
            jsonGenerator.a("education_experiences");
            GraphQLUserEducationExperiencesConnection__JsonHelper.m22390a(jsonGenerator, graphQLProfile.B(), true);
        }
        jsonGenerator.a("email_addresses");
        if (graphQLProfile.C() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLProfile.C()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLProfile.D() != null) {
            jsonGenerator.a("event_kind", graphQLProfile.D().toString());
        }
        jsonGenerator.a("events_calendar_subscriber_count", graphQLProfile.E());
        if (graphQLProfile.F() != null) {
            jsonGenerator.a("events_calendar_subscription_status", graphQLProfile.F().toString());
        }
        if (graphQLProfile.G() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProfile.G(), true);
        }
        if (graphQLProfile.H() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLProfile.H(), true);
        }
        if (graphQLProfile.I() != null) {
            jsonGenerator.a("friends");
            GraphQLFriendsConnection__JsonHelper.m7609a(jsonGenerator, graphQLProfile.I(), true);
        }
        if (graphQLProfile.J() != null) {
            jsonGenerator.a("friendship_status", graphQLProfile.J().toString());
        }
        if (graphQLProfile.K() != null) {
            jsonGenerator.a("group_members");
            GraphQLGroupMembersConnection__JsonHelper.m8459a(jsonGenerator, graphQLProfile.K(), true);
        }
        jsonGenerator.a("group_members_viewer_friend_count", graphQLProfile.L());
        if (graphQLProfile.b() != null) {
            jsonGenerator.a("id", graphQLProfile.b());
        }
        jsonGenerator.a("is_followed_by_everyone", graphQLProfile.M());
        jsonGenerator.a("is_messenger_user", graphQLProfile.N());
        jsonGenerator.a("is_playable", graphQLProfile.O());
        jsonGenerator.a("is_verified", graphQLProfile.P());
        jsonGenerator.a("is_viewer_friend", graphQLProfile.Q());
        jsonGenerator.a("is_work_user", graphQLProfile.R());
        if (graphQLProfile.S() != null) {
            jsonGenerator.a("location");
            GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLProfile.S(), true);
        }
        if (graphQLProfile.T() != null) {
            jsonGenerator.a("mutual_friends");
            GraphQLMutualFriendsConnection__JsonHelper.m9147a(jsonGenerator, graphQLProfile.T(), true);
        }
        if (graphQLProfile.U() != null) {
            jsonGenerator.a("name", graphQLProfile.U());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLProfile.V() != null) {
            jsonGenerator.d();
            for (String str22 : graphQLProfile.V()) {
                if (str22 != null) {
                    jsonGenerator.b(str22);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("new_activity_count", graphQLProfile.W());
        if (graphQLProfile.X() != null) {
            jsonGenerator.a("open_graph_composer_preview");
            GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLProfile.X(), true);
        }
        if (graphQLProfile.Y() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLProfile.Y(), true);
        }
        if (graphQLProfile.Z() != null) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnection__JsonHelper.m9495a(jsonGenerator, graphQLProfile.Z(), true);
        }
        if (graphQLProfile.aa() != null) {
            jsonGenerator.a("page_visits");
            GraphQLPageVisitsConnection__JsonHelper.m9552a(jsonGenerator, graphQLProfile.aa(), true);
        }
        if (graphQLProfile.ab() != null) {
            jsonGenerator.a("playable_url", graphQLProfile.ab());
        }
        if (graphQLProfile.ac() != null) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLProfile.ac(), true);
        }
        if (graphQLProfile.ad() != null) {
            jsonGenerator.a("preliminaryProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProfile.ad(), true);
        }
        if (graphQLProfile.ae() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProfile.ae(), true);
        }
        if (graphQLProfile.af() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProfile.af(), true);
        }
        if (graphQLProfile.ag() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProfile.ag(), true);
        }
        if (graphQLProfile.ah() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProfile.ah(), true);
        }
        if (graphQLProfile.ai() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProfile.ai(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLProfile.aj());
        if (graphQLProfile.ak() != null) {
            jsonGenerator.a("related_article_title", graphQLProfile.ak());
        }
        if (graphQLProfile.al() != null) {
            jsonGenerator.a("secondary_subscribe_status", graphQLProfile.al().toString());
        }
        jsonGenerator.a("short_category_names");
        if (graphQLProfile.am() != null) {
            jsonGenerator.d();
            for (String str222 : graphQLProfile.am()) {
                if (str222 != null) {
                    jsonGenerator.b(str222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLProfile.an() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLProfile.an(), true);
        }
        if (graphQLProfile.ao() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLProfile.ao(), true);
        }
        if (graphQLProfile.ap() != null) {
            jsonGenerator.a("structured_name");
            GraphQLName__JsonHelper.a(jsonGenerator, graphQLProfile.ap(), true);
        }
        jsonGenerator.a("structured_names");
        if (graphQLProfile.aq() != null) {
            jsonGenerator.d();
            for (GraphQLName graphQLName : graphQLProfile.aq()) {
                if (graphQLName != null) {
                    GraphQLName__JsonHelper.a(jsonGenerator, graphQLName, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLProfile.ar() != null) {
            jsonGenerator.a("subscribe_status", graphQLProfile.ar().toString());
        }
        if (graphQLProfile.as() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLProfile.as(), true);
        }
        if (graphQLProfile.at() != null) {
            jsonGenerator.a("tagline");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLProfile.at(), true);
        }
        if (graphQLProfile.au() != null) {
            jsonGenerator.a("trending_topic_data");
            GraphQLTrendingTopicData__JsonHelper.m22302a(jsonGenerator, graphQLProfile.au(), true);
        }
        if (graphQLProfile.av() != null) {
            jsonGenerator.a("trending_topic_name", graphQLProfile.av());
        }
        if (graphQLProfile.aw() != null) {
            jsonGenerator.a("unique_keyword", graphQLProfile.aw());
        }
        if (graphQLProfile.ax() != null) {
            jsonGenerator.a("url", graphQLProfile.ax());
        }
        jsonGenerator.a("viewer_affinity", graphQLProfile.ay());
        if (graphQLProfile.az() != null) {
            jsonGenerator.a("viewer_guest_status", graphQLProfile.az().toString());
        }
        jsonGenerator.a("viewer_has_pending_invite", graphQLProfile.aA());
        if (graphQLProfile.aB() != null) {
            jsonGenerator.a("viewer_join_state", graphQLProfile.aB().toString());
        }
        if (graphQLProfile.aC() != null) {
            jsonGenerator.a("viewer_recommendation");
            GraphQLContactRecommendationField__JsonHelper.m6881a(jsonGenerator, graphQLProfile.aC(), true);
        }
        if (graphQLProfile.aD() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLProfile.aD().toString());
        }
        if (graphQLProfile.aE() != null) {
            jsonGenerator.a("viewer_watch_status", graphQLProfile.aE().toString());
        }
        if (graphQLProfile.aF() != null) {
            jsonGenerator.a("visibility_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLProfile.aF(), true);
        }
        jsonGenerator.a("websites");
        if (graphQLProfile.aG() != null) {
            jsonGenerator.d();
            for (String str2222 : graphQLProfile.aG()) {
                if (str2222 != null) {
                    jsonGenerator.b(str2222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLProfile.aH() != null) {
            jsonGenerator.a("work_experiences");
            GraphQLUserWorkExperiencesConnection__JsonHelper.m22406a(jsonGenerator, graphQLProfile.aH(), true);
        }
        if (graphQLProfile.aI() != null) {
            jsonGenerator.a("global_share");
            GraphQLExternalUrl__JsonHelper.m7430a(jsonGenerator, graphQLProfile.aI(), true);
        }
        if (graphQLProfile.aJ() != null) {
            jsonGenerator.a("invitee");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLProfile.aJ(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
