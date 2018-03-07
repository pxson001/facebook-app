package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: scheduledIdleNotify */
public final class GraphQLActor__JsonHelper {
    public static GraphQLActor m3233a(JsonParser jsonParser) {
        GraphQLActor graphQLActor = new GraphQLActor();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3235a(graphQLActor, i, jsonParser);
            jsonParser.f();
        }
        return graphQLActor;
    }

    private static boolean m3235a(GraphQLActor graphQLActor, String str, JsonParser jsonParser) {
        long j = 0;
        double d = 0.0d;
        GraphQLProfileVideo graphQLProfileVideo = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLActor.d = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "__type__", graphQLActor.a_, 0, false);
            return true;
        } else if ("admin_info".equals(str)) {
            GraphQLPageAdminInfo a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLPageAdminInfo__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "admin_info"));
            }
            graphQLActor.e = a2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "admin_info", graphQLActor.B_(), 1, true);
            return true;
        } else if ("alternate_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.f = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "alternate_name", graphQLActor.B_(), 3, false);
            return true;
        } else if ("backing_application".equals(str)) {
            GraphQLAppStoreApplication a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLAppStoreApplication__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "backing_application"));
            }
            graphQLActor.g = a3;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "backing_application", graphQLActor.B_(), 4, true);
            return true;
        } else if ("bio_text".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "bio_text"));
            }
            graphQLActor.h = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "bio_text", graphQLActor.B_(), 5, true);
            return true;
        } else if ("birthdayFriends".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFriendsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "birthdayFriends"));
            }
            graphQLActor.i = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "birthdayFriends", graphQLActor.B_(), 6, true);
            return true;
        } else if ("can_see_viewer_montage_thread".equals(str)) {
            graphQLActor.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "can_see_viewer_montage_thread", graphQLActor.B_(), 7, false);
            return true;
        } else if ("can_viewer_act_as_memorial_contact".equals(str)) {
            graphQLActor.k = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "can_viewer_act_as_memorial_contact", graphQLActor.B_(), 8, false);
            return true;
        } else if ("can_viewer_block".equals(str)) {
            graphQLActor.l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "can_viewer_block", graphQLActor.B_(), 9, false);
            return true;
        } else if ("can_viewer_message".equals(str)) {
            graphQLActor.m = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "can_viewer_message", graphQLActor.B_(), 10, false);
            return true;
        } else if ("can_viewer_poke".equals(str)) {
            graphQLActor.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "can_viewer_poke", graphQLActor.B_(), 11, false);
            return true;
        } else if ("can_viewer_post".equals(str)) {
            graphQLActor.o = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "can_viewer_post", graphQLActor.B_(), 12, false);
            return true;
        } else if ("can_viewer_report".equals(str)) {
            graphQLActor.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "can_viewer_report", graphQLActor.B_(), 13, false);
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
            graphQLActor.q = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "category_names", graphQLActor.B_(), 14, false);
            return true;
        } else if ("communicationRank".equals(str)) {
            graphQLActor.r = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "communicationRank", graphQLActor.B_(), 15, false);
            return true;
        } else if ("cover_photo".equals(str)) {
            GraphQLFocusedPhoto a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFocusedPhoto__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "cover_photo"));
            }
            graphQLActor.s = a4;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "cover_photo", graphQLActor.B_(), 16, true);
            return true;
        } else if ("current_city".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPage__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "current_city"));
            }
            graphQLActor.t = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "current_city", graphQLActor.B_(), 17, true);
            return true;
        } else if ("email".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.u = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "email", graphQLActor.B_(), 18, false);
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
            graphQLActor.v = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "email_addresses", graphQLActor.B_(), 19, false);
            return true;
        } else if ("encrypted_cookie_sync_data".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.w = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "encrypted_cookie_sync_data", graphQLActor.B_(), 20, false);
            return true;
        } else if ("events".equals(str)) {
            GraphQLEventsConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLEventsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "events"));
            }
            graphQLActor.x = a5;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "events", graphQLActor.B_(), 21, true);
            return true;
        } else if ("friends".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFriendsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "friends"));
            }
            graphQLActor.y = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "friends", graphQLActor.B_(), 25, true);
            return true;
        } else if ("friendship_status".equals(str)) {
            graphQLActor.z = GraphQLFriendshipStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "friendship_status", graphQLActor.B_(), 26, false);
            return true;
        } else if ("gender".equals(str)) {
            graphQLActor.A = GraphQLGender.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "gender", graphQLActor.B_(), 27, false);
            return true;
        } else if ("hometown".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPage__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "hometown"));
            }
            graphQLActor.B = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "hometown", graphQLActor.B_(), 28, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.C = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "id", graphQLActor.B_(), 29, false);
            return true;
        } else if ("is_banned_by_page_viewer".equals(str)) {
            graphQLActor.D = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_banned_by_page_viewer", graphQLActor.B_(), 30, false);
            return true;
        } else if ("is_deactivated_allowed_on_messenger".equals(str)) {
            graphQLActor.E = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_deactivated_allowed_on_messenger", graphQLActor.B_(), 31, false);
            return true;
        } else if ("is_followed_by_everyone".equals(str)) {
            graphQLActor.F = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_followed_by_everyone", graphQLActor.B_(), 32, false);
            return true;
        } else if ("is_memorialized".equals(str)) {
            graphQLActor.G = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_memorialized", graphQLActor.B_(), 33, false);
            return true;
        } else if ("is_message_blocked_by_viewer".equals(str)) {
            graphQLActor.H = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_message_blocked_by_viewer", graphQLActor.B_(), 34, false);
            return true;
        } else if ("is_messenger_user".equals(str)) {
            graphQLActor.I = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_messenger_user", graphQLActor.B_(), 35, false);
            return true;
        } else if ("is_minor".equals(str)) {
            graphQLActor.J = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_minor", graphQLActor.B_(), 36, false);
            return true;
        } else if ("is_mobile_pushable".equals(str)) {
            graphQLActor.K = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_mobile_pushable", graphQLActor.B_(), 37, false);
            return true;
        } else if ("is_partial".equals(str)) {
            graphQLActor.L = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_partial", graphQLActor.B_(), 38, false);
            return true;
        } else if ("is_verified".equals(str)) {
            graphQLActor.M = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_verified", graphQLActor.B_(), 39, false);
            return true;
        } else if ("is_viewer_friend".equals(str)) {
            graphQLActor.N = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_viewer_friend", graphQLActor.B_(), 40, false);
            return true;
        } else if ("is_work_user".equals(str)) {
            graphQLActor.O = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_work_user", graphQLActor.B_(), 41, false);
            return true;
        } else if ("liked_profiles".equals(str)) {
            GraphQLLikedProfilesConnection a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLLikedProfilesConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "liked_profiles"));
            }
            graphQLActor.P = a6;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "liked_profiles", graphQLActor.B_(), 42, true);
            return true;
        } else if ("live_video_subscription_status".equals(str)) {
            graphQLActor.Q = GraphQLLiveVideoSubscriptionStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "live_video_subscription_status", graphQLActor.B_(), 43, false);
            return true;
        } else if ("messenger_install_time".equals(str)) {
            graphQLActor.R = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "messenger_install_time", graphQLActor.B_(), 44, false);
            return true;
        } else if ("messenger_invite_priority".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                d = jsonParser.G();
            }
            graphQLActor.S = d;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "messenger_invite_priority", graphQLActor.B_(), 45, false);
            return true;
        } else if ("montage_thread_fbid".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.T = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "montage_thread_fbid", graphQLActor.B_(), 46, false);
            return true;
        } else if ("mutual_friends".equals(str)) {
            GraphQLMutualFriendsConnection a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLMutualFriendsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "mutual_friends"));
            }
            graphQLActor.U = a7;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "mutual_friends", graphQLActor.B_(), 47, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.V = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "name", graphQLActor.B_(), 48, false);
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
            graphQLActor.W = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "name_search_tokens", graphQLActor.B_(), 49, false);
            return true;
        } else if ("news_feed".equals(str)) {
            GraphQLNewsFeedConnection a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLNewsFeedConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "news_feed"));
            }
            graphQLActor.X = a8;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "news_feed", graphQLActor.B_(), 50, true);
            return true;
        } else if ("page_likers".equals(str)) {
            GraphQLPageLikersConnection a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLPageLikersConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "page_likers"));
            }
            graphQLActor.Y = a9;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "page_likers", graphQLActor.B_(), 52, true);
            return true;
        } else if ("posted_item_privacy_scope".equals(str)) {
            GraphQLPrivacyScope a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLPrivacyScope__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "posted_item_privacy_scope"));
            }
            graphQLActor.Z = a10;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "posted_item_privacy_scope", graphQLActor.B_(), 53, true);
            return true;
        } else if ("profilePicture60".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profilePicture60"));
            }
            graphQLActor.aa = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "profilePicture60", graphQLActor.B_(), 54, true);
            return true;
        } else if ("profile_badge".equals(str)) {
            GraphQLProfileBadge a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLProfileBadge__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_badge"));
            }
            graphQLActor.ab = a11;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "profile_badge", graphQLActor.B_(), 55, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLPhoto__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_photo"));
            }
            graphQLActor.ac = a12;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "profile_photo", graphQLActor.B_(), 56, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_picture"));
            }
            graphQLActor.ad = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "profile_picture", graphQLActor.B_(), 57, true);
            return true;
        } else if ("profile_picture_expiration_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLActor.ae = j;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "profile_picture_expiration_time", graphQLActor.B_(), 58, false);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLActor.af = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "profile_picture_is_silhouette", graphQLActor.B_(), 59, false);
            return true;
        } else if ("requestee_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.ag = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "requestee_id", graphQLActor.B_(), 60, false);
            return true;
        } else if ("requester_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.ah = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "requester_id", graphQLActor.B_(), 61, false);
            return true;
        } else if ("secondary_subscribe_status".equals(str)) {
            graphQLActor.ai = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "secondary_subscribe_status", graphQLActor.B_(), 62, false);
            return true;
        } else if ("single_publisher_video_channels".equals(str)) {
            GraphQLSinglePublisherVideoChannelsConnection a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLSinglePublisherVideoChannelsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "single_publisher_video_channels"));
            }
            graphQLActor.aj = a13;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "single_publisher_video_channels", graphQLActor.B_(), 63, true);
            return true;
        } else if ("squareProfilePicBig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "squareProfilePicBig"));
            }
            graphQLActor.ak = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "squareProfilePicBig", graphQLActor.B_(), 64, true);
            return true;
        } else if ("squareProfilePicHuge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "squareProfilePicHuge"));
            }
            graphQLActor.al = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "squareProfilePicHuge", graphQLActor.B_(), 65, true);
            return true;
        } else if ("squareProfilePicSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "squareProfilePicSmall"));
            }
            graphQLActor.am = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "squareProfilePicSmall", graphQLActor.B_(), 66, true);
            return true;
        } else if ("structured_name".equals(str)) {
            GraphQLName a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLName__JsonHelper.m3236a(FieldAccessQueryTracker.m2235a(jsonParser, "structured_name"));
            }
            graphQLActor.an = a14;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "structured_name", graphQLActor.B_(), 67, true);
            return true;
        } else if ("subscribe_status".equals(str)) {
            graphQLActor.ao = GraphQLSubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "subscribe_status", graphQLActor.B_(), 68, false);
            return true;
        } else if ("tagline".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "tagline"));
            }
            graphQLActor.ap = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "tagline", graphQLActor.B_(), 69, true);
            return true;
        } else if ("unread_count".equals(str)) {
            graphQLActor.aq = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "unread_count", graphQLActor.B_(), 71, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.ar = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "url", graphQLActor.B_(), 72, false);
            return true;
        } else if ("username".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.as = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "username", graphQLActor.B_(), 73, false);
            return true;
        } else if ("video_channel_can_viewer_follow".equals(str)) {
            graphQLActor.at = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_can_viewer_follow", graphQLActor.B_(), 74, false);
            return true;
        } else if ("video_channel_curator_profile".equals(str)) {
            GraphQLProfile a15;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a15 = GraphQLProfile__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "video_channel_curator_profile"));
            }
            graphQLActor.au = a15;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_curator_profile", graphQLActor.B_(), 75, true);
            return true;
        } else if ("video_channel_has_new".equals(str)) {
            graphQLActor.av = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_has_new", graphQLActor.B_(), 76, false);
            return true;
        } else if ("video_channel_is_viewer_following".equals(str)) {
            graphQLActor.aw = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_is_viewer_following", graphQLActor.B_(), 77, false);
            return true;
        } else if ("video_channel_max_new_count".equals(str)) {
            graphQLActor.ax = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_max_new_count", graphQLActor.B_(), 78, false);
            return true;
        } else if ("video_channel_new_count".equals(str)) {
            graphQLActor.ay = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_new_count", graphQLActor.B_(), 79, false);
            return true;
        } else if ("video_channel_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "video_channel_subtitle"));
            }
            graphQLActor.az = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_subtitle", graphQLActor.B_(), 80, true);
            return true;
        } else if ("video_channel_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "video_channel_title"));
            }
            graphQLActor.aA = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_title", graphQLActor.B_(), 81, true);
            return true;
        } else if ("viewer_acts_as_profile".equals(str)) {
            graphQLActor.aB = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "viewer_acts_as_profile", graphQLActor.B_(), 82, false);
            return true;
        } else if ("withTaggingRank".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                d = jsonParser.G();
            }
            graphQLActor.aC = d;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "withTaggingRank", graphQLActor.B_(), 83, false);
            return true;
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            graphQLActor.aD = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_has_viewer_subscribed", graphQLActor.B_(), 84, false);
            return true;
        } else if ("video_channel_can_viewer_subscribe".equals(str)) {
            graphQLActor.aE = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "video_channel_can_viewer_subscribe", graphQLActor.B_(), 85, false);
            return true;
        } else if ("short_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLActor.aF = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "short_name", graphQLActor.B_(), 86, false);
            return true;
        } else if ("profile_video".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLProfileVideo = GraphQLProfileVideo__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "profile_video"));
            }
            graphQLActor.aG = graphQLProfileVideo;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "profile_video", graphQLActor.B_(), 89, true);
            return true;
        } else if (!"is_viewer_coworker".equals(str)) {
            return false;
        } else {
            graphQLActor.aH = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLActor, "is_viewer_coworker", graphQLActor.B_(), 90, false);
            return true;
        }
    }

    public static void m3234a(JsonGenerator jsonGenerator, GraphQLActor graphQLActor, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLActor.b() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLActor.b().e());
            jsonGenerator.g();
        }
        if (graphQLActor.j() != null) {
            jsonGenerator.a("admin_info");
            GraphQLPageAdminInfo__JsonHelper.a(jsonGenerator, graphQLActor.j(), true);
        }
        if (graphQLActor.k() != null) {
            jsonGenerator.a("alternate_name", graphQLActor.k());
        }
        if (graphQLActor.l() != null) {
            jsonGenerator.a("backing_application");
            GraphQLAppStoreApplication__JsonHelper.a(jsonGenerator, graphQLActor.l(), true);
        }
        if (graphQLActor.m() != null) {
            jsonGenerator.a("bio_text");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLActor.m(), true);
        }
        if (graphQLActor.n() != null) {
            jsonGenerator.a("birthdayFriends");
            GraphQLFriendsConnection__JsonHelper.a(jsonGenerator, graphQLActor.n(), true);
        }
        jsonGenerator.a("can_see_viewer_montage_thread", graphQLActor.o());
        jsonGenerator.a("can_viewer_act_as_memorial_contact", graphQLActor.p());
        jsonGenerator.a("can_viewer_block", graphQLActor.q());
        jsonGenerator.a("can_viewer_message", graphQLActor.r());
        jsonGenerator.a("can_viewer_poke", graphQLActor.s());
        jsonGenerator.a("can_viewer_post", graphQLActor.t());
        jsonGenerator.a("can_viewer_report", graphQLActor.u());
        jsonGenerator.a("category_names");
        if (graphQLActor.v() != null) {
            jsonGenerator.d();
            for (String str : graphQLActor.v()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("communicationRank", graphQLActor.w());
        if (graphQLActor.x() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.a(jsonGenerator, graphQLActor.x(), true);
        }
        if (graphQLActor.y() != null) {
            jsonGenerator.a("current_city");
            GraphQLPage__JsonHelper.a(jsonGenerator, graphQLActor.y(), true);
        }
        if (graphQLActor.z() != null) {
            jsonGenerator.a("email", graphQLActor.z());
        }
        jsonGenerator.a("email_addresses");
        if (graphQLActor.A() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLActor.A()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLActor.B() != null) {
            jsonGenerator.a("encrypted_cookie_sync_data", graphQLActor.B());
        }
        if (graphQLActor.C() != null) {
            jsonGenerator.a("events");
            GraphQLEventsConnection__JsonHelper.a(jsonGenerator, graphQLActor.C(), true);
        }
        if (graphQLActor.D() != null) {
            jsonGenerator.a("friends");
            GraphQLFriendsConnection__JsonHelper.a(jsonGenerator, graphQLActor.D(), true);
        }
        if (graphQLActor.E() != null) {
            jsonGenerator.a("friendship_status", graphQLActor.E().toString());
        }
        if (graphQLActor.F() != null) {
            jsonGenerator.a("gender", graphQLActor.F().toString());
        }
        if (graphQLActor.G() != null) {
            jsonGenerator.a("hometown");
            GraphQLPage__JsonHelper.a(jsonGenerator, graphQLActor.G(), true);
        }
        if (graphQLActor.H() != null) {
            jsonGenerator.a("id", graphQLActor.H());
        }
        jsonGenerator.a("is_banned_by_page_viewer", graphQLActor.I());
        jsonGenerator.a("is_deactivated_allowed_on_messenger", graphQLActor.J());
        jsonGenerator.a("is_followed_by_everyone", graphQLActor.K());
        jsonGenerator.a("is_memorialized", graphQLActor.L());
        jsonGenerator.a("is_message_blocked_by_viewer", graphQLActor.M());
        jsonGenerator.a("is_messenger_user", graphQLActor.N());
        jsonGenerator.a("is_minor", graphQLActor.O());
        jsonGenerator.a("is_mobile_pushable", graphQLActor.P());
        jsonGenerator.a("is_partial", graphQLActor.Q());
        jsonGenerator.a("is_verified", graphQLActor.R());
        jsonGenerator.a("is_viewer_friend", graphQLActor.S());
        jsonGenerator.a("is_work_user", graphQLActor.T());
        if (graphQLActor.U() != null) {
            jsonGenerator.a("liked_profiles");
            GraphQLLikedProfilesConnection__JsonHelper.a(jsonGenerator, graphQLActor.U(), true);
        }
        if (graphQLActor.V() != null) {
            jsonGenerator.a("live_video_subscription_status", graphQLActor.V().toString());
        }
        jsonGenerator.a("messenger_install_time", graphQLActor.W());
        jsonGenerator.a("messenger_invite_priority", graphQLActor.X());
        if (graphQLActor.Y() != null) {
            jsonGenerator.a("montage_thread_fbid", graphQLActor.Y());
        }
        if (graphQLActor.Z() != null) {
            jsonGenerator.a("mutual_friends");
            GraphQLMutualFriendsConnection__JsonHelper.a(jsonGenerator, graphQLActor.Z(), true);
        }
        if (graphQLActor.aa() != null) {
            jsonGenerator.a("name", graphQLActor.aa());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLActor.ab() != null) {
            jsonGenerator.d();
            for (String str22 : graphQLActor.ab()) {
                if (str22 != null) {
                    jsonGenerator.b(str22);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLActor.ac() != null) {
            jsonGenerator.a("news_feed");
            GraphQLNewsFeedConnection__JsonHelper.a(jsonGenerator, graphQLActor.ac(), true);
        }
        if (graphQLActor.ad() != null) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnection__JsonHelper.a(jsonGenerator, graphQLActor.ad(), true);
        }
        if (graphQLActor.ae() != null) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScope__JsonHelper.a(jsonGenerator, graphQLActor.ae(), true);
        }
        if (graphQLActor.af() != null) {
            jsonGenerator.a("profilePicture60");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLActor.af(), true);
        }
        if (graphQLActor.ag() != null) {
            jsonGenerator.a("profile_badge");
            GraphQLProfileBadge__JsonHelper.a(jsonGenerator, graphQLActor.ag(), true);
        }
        if (graphQLActor.ah() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.a(jsonGenerator, graphQLActor.ah(), true);
        }
        if (graphQLActor.ai() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLActor.ai(), true);
        }
        jsonGenerator.a("profile_picture_expiration_time", graphQLActor.aj());
        jsonGenerator.a("profile_picture_is_silhouette", graphQLActor.ak());
        if (graphQLActor.al() != null) {
            jsonGenerator.a("requestee_id", graphQLActor.al());
        }
        if (graphQLActor.am() != null) {
            jsonGenerator.a("requester_id", graphQLActor.am());
        }
        if (graphQLActor.an() != null) {
            jsonGenerator.a("secondary_subscribe_status", graphQLActor.an().toString());
        }
        if (graphQLActor.ao() != null) {
            jsonGenerator.a("single_publisher_video_channels");
            GraphQLSinglePublisherVideoChannelsConnection__JsonHelper.a(jsonGenerator, graphQLActor.ao(), true);
        }
        if (graphQLActor.ap() != null) {
            jsonGenerator.a("squareProfilePicBig");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLActor.ap(), true);
        }
        if (graphQLActor.aq() != null) {
            jsonGenerator.a("squareProfilePicHuge");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLActor.aq(), true);
        }
        if (graphQLActor.ar() != null) {
            jsonGenerator.a("squareProfilePicSmall");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLActor.ar(), true);
        }
        if (graphQLActor.as() != null) {
            jsonGenerator.a("structured_name");
            GraphQLName__JsonHelper.m3237a(jsonGenerator, graphQLActor.as(), true);
        }
        if (graphQLActor.at() != null) {
            jsonGenerator.a("subscribe_status", graphQLActor.at().toString());
        }
        if (graphQLActor.au() != null) {
            jsonGenerator.a("tagline");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLActor.au(), true);
        }
        jsonGenerator.a("unread_count", graphQLActor.av());
        if (graphQLActor.aw() != null) {
            jsonGenerator.a("url", graphQLActor.aw());
        }
        if (graphQLActor.ax() != null) {
            jsonGenerator.a("username", graphQLActor.ax());
        }
        jsonGenerator.a("video_channel_can_viewer_follow", graphQLActor.ay());
        if (graphQLActor.az() != null) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfile__JsonHelper.a(jsonGenerator, graphQLActor.az(), true);
        }
        jsonGenerator.a("video_channel_has_new", graphQLActor.aA());
        jsonGenerator.a("video_channel_is_viewer_following", graphQLActor.aB());
        jsonGenerator.a("video_channel_max_new_count", graphQLActor.aC());
        jsonGenerator.a("video_channel_new_count", graphQLActor.aD());
        if (graphQLActor.aE() != null) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLActor.aE(), true);
        }
        if (graphQLActor.aF() != null) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLActor.aF(), true);
        }
        jsonGenerator.a("viewer_acts_as_profile", graphQLActor.aG());
        jsonGenerator.a("withTaggingRank", graphQLActor.aH());
        jsonGenerator.a("video_channel_has_viewer_subscribed", graphQLActor.aI());
        jsonGenerator.a("video_channel_can_viewer_subscribe", graphQLActor.aJ());
        if (graphQLActor.aK() != null) {
            jsonGenerator.a("short_name", graphQLActor.aK());
        }
        if (graphQLActor.aL() != null) {
            jsonGenerator.a("profile_video");
            GraphQLProfileVideo__JsonHelper.a(jsonGenerator, graphQLActor.aL(), true);
        }
        jsonGenerator.a("is_viewer_coworker", graphQLActor.aM());
        if (z) {
            jsonGenerator.g();
        }
    }
}
