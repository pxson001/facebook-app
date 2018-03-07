package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLCommercePageSetting;
import com.facebook.graphql.enums.GraphQLCommercePageType;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPagePaymentOption;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLReactionRequestedUnit;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: email_ac */
public final class GraphQLPage__JsonHelper {
    public static GraphQLPage m9553a(JsonParser jsonParser) {
        GraphQLPage graphQLPage = new GraphQLPage();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9555a(graphQLPage, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPage;
    }

    private static boolean m9555a(GraphQLPage graphQLPage, String str, JsonParser jsonParser) {
        GraphQLPageCallToAction graphQLPageCallToAction = null;
        GraphQLTextWithEntities a;
        if ("about".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "about"));
            }
            graphQLPage.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "about", graphQLPage.a_, 0, true);
            return true;
        } else if ("activity_admin_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPageAdminInfo__JsonHelper.m9467a(FieldAccessQueryTracker.a(jsonParser, "activity_admin_info"));
            }
            graphQLPage.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "activity_admin_info", graphQLPage.B_(), 1, true);
            return true;
        } else if ("address".equals(str)) {
            GraphQLStreetAddress a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLStreetAddress__JsonHelper.m21936a(FieldAccessQueryTracker.a(jsonParser, "address"));
            }
            graphQLPage.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "address", graphQLPage.B_(), 2, true);
            return true;
        } else if ("admin_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPageAdminInfo__JsonHelper.m9467a(FieldAccessQueryTracker.a(jsonParser, "admin_info"));
            }
            graphQLPage.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "admin_info", graphQLPage.B_(), 3, true);
            return true;
        } else if ("albums".equals(str)) {
            GraphQLAlbumsConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLAlbumsConnection__JsonHelper.m6518a(FieldAccessQueryTracker.a(jsonParser, "albums"));
            }
            graphQLPage.h = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "albums", graphQLPage.B_(), 4, true);
            return true;
        } else if ("android_urls".equals(str)) {
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
            graphQLPage.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "android_urls", graphQLPage.B_(), 6, false);
            return true;
        } else if ("attribution".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLAttributionEntry a4 = GraphQLAttributionEntry__JsonHelper.m6616a(FieldAccessQueryTracker.a(jsonParser, "attribution"));
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
            graphQLPage.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "attribution", graphQLPage.B_(), 7, true);
            return true;
        } else if ("author_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "author_text", graphQLPage.B_(), 8, false);
            return true;
        } else if ("away_toggle_expiration".equals(str)) {
            graphQLPage.l = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "away_toggle_expiration", graphQLPage.B_(), 9, false);
            return true;
        } else if ("best_description".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "best_description"));
            }
            graphQLPage.m = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "best_description", graphQLPage.B_(), 10, true);
            return true;
        } else if ("blurredCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "blurredCoverPhoto"));
            }
            graphQLPage.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "blurredCoverPhoto", graphQLPage.B_(), 11, true);
            return true;
        } else if ("business_info".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLBusinessInfo a5 = GraphQLBusinessInfo__JsonHelper.m6705a(FieldAccessQueryTracker.a(jsonParser, "business_info"));
                    if (a5 != null) {
                        r1.add(a5);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPage.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "business_info", graphQLPage.B_(), 12, true);
            return true;
        } else if ("can_see_viewer_montage_thread".equals(str)) {
            graphQLPage.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_see_viewer_montage_thread", graphQLPage.B_(), 13, false);
            return true;
        } else if ("can_viewer_claim".equals(str)) {
            graphQLPage.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_viewer_claim", graphQLPage.B_(), 14, false);
            return true;
        } else if ("can_viewer_get_notification".equals(str)) {
            graphQLPage.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_viewer_get_notification", graphQLPage.B_(), 15, false);
            return true;
        } else if ("can_viewer_like".equals(str)) {
            graphQLPage.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_viewer_like", graphQLPage.B_(), 16, false);
            return true;
        } else if ("can_viewer_message".equals(str)) {
            graphQLPage.t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_viewer_message", graphQLPage.B_(), 17, false);
            return true;
        } else if ("can_viewer_post".equals(str)) {
            graphQLPage.u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_viewer_post", graphQLPage.B_(), 18, false);
            return true;
        } else if ("can_viewer_post_photo_to_timeline".equals(str)) {
            graphQLPage.v = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_viewer_post_photo_to_timeline", graphQLPage.B_(), 19, false);
            return true;
        } else if ("can_viewer_rate".equals(str)) {
            graphQLPage.w = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_viewer_rate", graphQLPage.B_(), 20, false);
            return true;
        } else if ("categories".equals(str)) {
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
            graphQLPage.x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "categories", graphQLPage.B_(), 21, false);
            return true;
        } else if ("category_icon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "category_icon"));
            }
            graphQLPage.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "category_icon", graphQLPage.B_(), 22, true);
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
            graphQLPage.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "category_names", graphQLPage.B_(), 23, false);
            return true;
        } else if ("category_type".equals(str)) {
            graphQLPage.A = GraphQLPageCategoryType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "category_type", graphQLPage.B_(), 24, false);
            return true;
        } else if ("city".equals(str)) {
            GraphQLPage a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = m9553a(FieldAccessQueryTracker.a(jsonParser, "city"));
            }
            graphQLPage.B = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "city", graphQLPage.B_(), 25, true);
            return true;
        } else if ("commerce_page_settings".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLCommercePageSetting fromString = GraphQLCommercePageSetting.fromString(jsonParser.o());
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
            graphQLPage.C = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "commerce_page_settings", graphQLPage.B_(), 26, false);
            return true;
        } else if ("commerce_page_type".equals(str)) {
            graphQLPage.D = GraphQLCommercePageType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "commerce_page_type", graphQLPage.B_(), 27, false);
            return true;
        } else if ("contact".equals(str)) {
            GraphQLContact a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLContact__JsonHelper.m6884a(FieldAccessQueryTracker.a(jsonParser, "contact"));
            }
            graphQLPage.E = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "contact", graphQLPage.B_(), 28, true);
            return true;
        } else if ("contextual_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.F = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "contextual_name", graphQLPage.B_(), 29, false);
            return true;
        } else if ("cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "cover_photo"));
            }
            graphQLPage.G = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "cover_photo", graphQLPage.B_(), 30, true);
            return true;
        } else if ("display_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.H = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "display_name", graphQLPage.B_(), 31, false);
            return true;
        } else if ("does_viewer_like".equals(str)) {
            graphQLPage.I = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "does_viewer_like", graphQLPage.B_(), 32, false);
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
            graphQLPage.J = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "email_addresses", graphQLPage.B_(), 33, false);
            return true;
        } else if ("entity_card_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "entity_card_subtitle"));
            }
            graphQLPage.K = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "entity_card_subtitle", graphQLPage.B_(), 34, true);
            return true;
        } else if ("events_calendar_can_viewer_subscribe".equals(str)) {
            graphQLPage.L = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "events_calendar_can_viewer_subscribe", graphQLPage.B_(), 35, false);
            return true;
        } else if ("events_calendar_subscriber_count".equals(str)) {
            graphQLPage.M = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "events_calendar_subscriber_count", graphQLPage.B_(), 36, false);
            return true;
        } else if ("events_calendar_subscription_status".equals(str)) {
            graphQLPage.N = GraphQLEventsCalendarSubscriptionStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "events_calendar_subscription_status", graphQLPage.B_(), 37, false);
            return true;
        } else if ("events_occurring_here".equals(str)) {
            GraphQLEventsOccurringHereConnection a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLEventsOccurringHereConnection__JsonHelper.m7357a(FieldAccessQueryTracker.a(jsonParser, "events_occurring_here"));
            }
            graphQLPage.O = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "events_occurring_here", graphQLPage.B_(), 38, true);
            return true;
        } else if ("expressed_as_place".equals(str)) {
            graphQLPage.P = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "expressed_as_place", graphQLPage.B_(), 39, false);
            return true;
        } else if ("featured_video".equals(str)) {
            GraphQLVideo a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLVideo__JsonHelper.m22483a(FieldAccessQueryTracker.a(jsonParser, "featured_video"));
            }
            graphQLPage.Q = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "featured_video", graphQLPage.B_(), 40, true);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLPage.R = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "feedAwesomizerProfilePicture", graphQLPage.B_(), 41, true);
            return true;
        } else if ("firstSection".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTimelineSectionsConnection__JsonHelper.m22223a(FieldAccessQueryTracker.a(jsonParser, "firstSection"));
            }
            graphQLPage.S = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "firstSection", graphQLPage.B_(), 42, true);
            return true;
        } else if ("followup_feed_units".equals(str)) {
            GraphQLFollowUpFeedUnitsConnection a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLFollowUpFeedUnitsConnection__JsonHelper.m7532a(FieldAccessQueryTracker.a(jsonParser, "followup_feed_units"));
            }
            graphQLPage.T = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "followup_feed_units", graphQLPage.B_(), 43, true);
            return true;
        } else if ("friends_who_like".equals(str)) {
            GraphQLFriendsWhoLikeConnection a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLFriendsWhoLikeConnection__JsonHelper.m7641a(FieldAccessQueryTracker.a(jsonParser, "friends_who_like"));
            }
            graphQLPage.U = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "friends_who_like", graphQLPage.B_(), 44, true);
            return true;
        } else if ("friends_who_visited".equals(str)) {
            GraphQLFriendsWhoVisitedConnection a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLFriendsWhoVisitedConnection__JsonHelper.m7647a(FieldAccessQueryTracker.a(jsonParser, "friends_who_visited"));
            }
            graphQLPage.V = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "friends_who_visited", graphQLPage.B_(), 45, true);
            return true;
        } else if ("full_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.W = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "full_name", graphQLPage.B_(), 46, false);
            return true;
        } else if ("hours".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLTimeRange a13 = GraphQLTimeRange__JsonHelper.m22114a(FieldAccessQueryTracker.a(jsonParser, "hours"));
                    if (a13 != null) {
                        r1.add(a13);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPage.X = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "hours", graphQLPage.B_(), 48, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.Y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "id", graphQLPage.B_(), 49, false);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLPage.Z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "imageHighOrig", graphQLPage.B_(), 50, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLPage.aa = a14;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "inline_activities", graphQLPage.B_(), 51, true);
            return true;
        } else if ("instant_articles_enabled".equals(str)) {
            graphQLPage.ab = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "instant_articles_enabled", graphQLPage.B_(), 52, false);
            return true;
        } else if ("is_always_open".equals(str)) {
            graphQLPage.ac = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_always_open", graphQLPage.B_(), 53, false);
            return true;
        } else if ("is_away_toggle_on".equals(str)) {
            graphQLPage.ad = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_away_toggle_on", graphQLPage.B_(), 54, false);
            return true;
        } else if ("is_banned_by_page_viewer".equals(str)) {
            graphQLPage.ae = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_banned_by_page_viewer", graphQLPage.B_(), 55, false);
            return true;
        } else if ("is_commerce".equals(str)) {
            graphQLPage.af = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_commerce", graphQLPage.B_(), 56, false);
            return true;
        } else if ("is_eligible_for_page_verification".equals(str)) {
            graphQLPage.ag = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_eligible_for_page_verification", graphQLPage.B_(), 57, false);
            return true;
        } else if ("is_message_blocked_by_viewer".equals(str)) {
            graphQLPage.ah = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_message_blocked_by_viewer", graphQLPage.B_(), 58, false);
            return true;
        } else if ("is_messenger_promotion_blocked_by_viewer".equals(str)) {
            graphQLPage.ai = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_messenger_promotion_blocked_by_viewer", graphQLPage.B_(), 59, false);
            return true;
        } else if ("is_messenger_user".equals(str)) {
            graphQLPage.aj = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_messenger_user", graphQLPage.B_(), 60, false);
            return true;
        } else if ("is_owned".equals(str)) {
            graphQLPage.ak = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_owned", graphQLPage.B_(), 61, false);
            return true;
        } else if ("is_permanently_closed".equals(str)) {
            graphQLPage.al = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_permanently_closed", graphQLPage.B_(), 62, false);
            return true;
        } else if ("is_place_map_hidden".equals(str)) {
            graphQLPage.am = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_place_map_hidden", graphQLPage.B_(), 63, false);
            return true;
        } else if ("is_service_page".equals(str)) {
            graphQLPage.an = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_service_page", graphQLPage.B_(), 64, false);
            return true;
        } else if ("is_verified".equals(str)) {
            graphQLPage.ao = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_verified", graphQLPage.B_(), 65, false);
            return true;
        } else if ("is_verified_page".equals(str)) {
            graphQLPage.ap = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_verified_page", graphQLPage.B_(), 66, false);
            return true;
        } else if ("is_viewer_notified_about".equals(str)) {
            graphQLPage.aq = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_viewer_notified_about", graphQLPage.B_(), 67, false);
            return true;
        } else if ("liked_profiles".equals(str)) {
            GraphQLLikedProfilesConnection a15;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a15 = GraphQLLikedProfilesConnection__JsonHelper.m8914a(FieldAccessQueryTracker.a(jsonParser, "liked_profiles"));
            }
            graphQLPage.ar = a15;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "liked_profiles", graphQLPage.B_(), 68, true);
            return true;
        } else if ("live_video_subscription_status".equals(str)) {
            graphQLPage.as = GraphQLLiveVideoSubscriptionStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "live_video_subscription_status", graphQLPage.B_(), 69, false);
            return true;
        } else if ("location".equals(str)) {
            GraphQLLocation a16;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a16 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "location"));
            }
            graphQLPage.at = a16;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "location", graphQLPage.B_(), 70, true);
            return true;
        } else if ("map_bounding_box".equals(str)) {
            GraphQLGeoRectangle a17;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a17 = GraphQLGeoRectangle__JsonHelper.m7766a(FieldAccessQueryTracker.a(jsonParser, "map_bounding_box"));
            }
            graphQLPage.au = a17;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "map_bounding_box", graphQLPage.B_(), 71, true);
            return true;
        } else if ("map_zoom_level".equals(str)) {
            graphQLPage.av = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "map_zoom_level", graphQLPage.B_(), 72, false);
            return true;
        } else if ("menu_info".equals(str)) {
            GraphQLPageMenuInfo a18;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a18 = GraphQLPageMenuInfo__JsonHelper.m9500a(FieldAccessQueryTracker.a(jsonParser, "menu_info"));
            }
            graphQLPage.aw = a18;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "menu_info", graphQLPage.B_(), 73, true);
            return true;
        } else if ("message_permalink".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.ax = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "message_permalink", graphQLPage.B_(), 74, false);
            return true;
        } else if ("montage_thread_fbid".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.ay = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "montage_thread_fbid", graphQLPage.B_(), 75, false);
            return true;
        } else if ("music_object".equals(str)) {
            GraphQLOpenGraphObject a19;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a19 = GraphQLOpenGraphObject__JsonHelper.m9409a(FieldAccessQueryTracker.a(jsonParser, "music_object"));
            }
            graphQLPage.az = a19;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "music_object", graphQLPage.B_(), 76, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.aA = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "name", graphQLPage.B_(), 77, false);
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
            graphQLPage.aB = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "name_search_tokens", graphQLPage.B_(), 78, false);
            return true;
        } else if ("neighborhood_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.aC = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "neighborhood_name", graphQLPage.B_(), 79, false);
            return true;
        } else if ("new_activity_count".equals(str)) {
            graphQLPage.aD = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "new_activity_count", graphQLPage.B_(), 80, false);
            return true;
        } else if ("open_graph_composer_preview".equals(str)) {
            GraphQLStoryAttachment a20;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a20 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "open_graph_composer_preview"));
            }
            graphQLPage.aE = a20;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "open_graph_composer_preview", graphQLPage.B_(), 81, true);
            return true;
        } else if ("overall_rating".equals(str)) {
            graphQLPage.aF = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "overall_rating", graphQLPage.B_(), 82, false);
            return true;
        } else if ("overall_star_rating".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLRating__JsonHelper.m21310a(FieldAccessQueryTracker.a(jsonParser, "overall_star_rating"));
            }
            graphQLPage.aG = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "overall_star_rating", graphQLPage.B_(), 83, true);
            return true;
        } else if ("owned_events".equals(str)) {
            GraphQLOwnedEventsConnection a21;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a21 = GraphQLOwnedEventsConnection__JsonHelper.m9435a(FieldAccessQueryTracker.a(jsonParser, "owned_events"));
            }
            graphQLPage.aH = a21;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "owned_events", graphQLPage.B_(), 84, true);
            return true;
        } else if ("pageProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "pageProfilePicture"));
            }
            graphQLPage.aI = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "pageProfilePicture", graphQLPage.B_(), 85, true);
            return true;
        } else if ("page_likers".equals(str)) {
            GraphQLPageLikersConnection a22;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a22 = GraphQLPageLikersConnection__JsonHelper.m9494a(FieldAccessQueryTracker.a(jsonParser, "page_likers"));
            }
            graphQLPage.aJ = a22;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "page_likers", graphQLPage.B_(), 86, true);
            return true;
        } else if ("page_nux".equals(str)) {
            graphQLPage.aK = GraphQLReactionRequestedUnit.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "page_nux", graphQLPage.B_(), 87, false);
            return true;
        } else if ("page_payment_options".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPagePaymentOption fromString2 = GraphQLPagePaymentOption.fromString(jsonParser.o());
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
            graphQLPage.aL = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "page_payment_options", graphQLPage.B_(), 88, false);
            return true;
        } else if ("page_visits".equals(str)) {
            GraphQLPageVisitsConnection a23;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a23 = GraphQLPageVisitsConnection__JsonHelper.m9551a(FieldAccessQueryTracker.a(jsonParser, "page_visits"));
            }
            graphQLPage.aM = a23;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "page_visits", graphQLPage.B_(), 89, true);
            return true;
        } else if ("pending_claims_count".equals(str)) {
            graphQLPage.aN = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "pending_claims_count", graphQLPage.B_(), 90, false);
            return true;
        } else if ("permanently_closed_status".equals(str)) {
            graphQLPage.aO = GraphQLPermanentlyClosedStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "permanently_closed_status", graphQLPage.B_(), 91, false);
            return true;
        } else if ("phone_number".equals(str)) {
            GraphQLPhoneNumber a24;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a24 = GraphQLPhoneNumber__JsonHelper.m20713a(FieldAccessQueryTracker.a(jsonParser, "phone_number"));
            }
            graphQLPage.aP = a24;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "phone_number", graphQLPage.B_(), 92, true);
            return true;
        } else if ("placeProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "placeProfilePicture"));
            }
            graphQLPage.aQ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "placeProfilePicture", graphQLPage.B_(), 93, true);
            return true;
        } else if ("place_open_status".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "place_open_status"));
            }
            graphQLPage.aR = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "place_open_status", graphQLPage.B_(), 94, true);
            return true;
        } else if ("place_open_status_type".equals(str)) {
            graphQLPage.aS = GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "place_open_status_type", graphQLPage.B_(), 95, false);
            return true;
        } else if ("place_topic_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.aT = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "place_topic_id", graphQLPage.B_(), 96, false);
            return true;
        } else if ("place_type".equals(str)) {
            graphQLPage.aU = GraphQLPlaceType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "place_type", graphQLPage.B_(), 97, false);
            return true;
        } else if ("posted_item_privacy_scope".equals(str)) {
            GraphQLPrivacyScope a25;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a25 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "posted_item_privacy_scope"));
            }
            graphQLPage.aV = a25;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "posted_item_privacy_scope", graphQLPage.B_(), 98, true);
            return true;
        } else if ("posted_photos".equals(str)) {
            GraphQLPostedPhotosConnection a26;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a26 = GraphQLPostedPhotosConnection__JsonHelper.m20974a(FieldAccessQueryTracker.a(jsonParser, "posted_photos"));
            }
            graphQLPage.aW = a26;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "posted_photos", graphQLPage.B_(), 99, true);
            return true;
        } else if ("price_range_description".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.aX = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "price_range_description", graphQLPage.B_(), 100, false);
            return true;
        } else if ("privacy_option".equals(str)) {
            GraphQLPrivacyOption a27;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a27 = GraphQLPrivacyOption__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "privacy_option"));
            }
            graphQLPage.aY = a27;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "privacy_option", graphQLPage.B_(), 101, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLPage.aZ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profileImageLarge", graphQLPage.B_(), 102, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLPage.ba = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profileImageSmall", graphQLPage.B_(), 103, true);
            return true;
        } else if ("profilePicture32".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture32"));
            }
            graphQLPage.bb = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profilePicture32", graphQLPage.B_(), 104, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLPage.bc = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profilePicture50", graphQLPage.B_(), 105, true);
            return true;
        } else if ("profilePicture60".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture60"));
            }
            graphQLPage.bd = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profilePicture60", graphQLPage.B_(), 106, true);
            return true;
        } else if ("profilePicture74".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture74"));
            }
            graphQLPage.be = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profilePicture74", graphQLPage.B_(), 107, true);
            return true;
        } else if ("profilePictureAsCover".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureAsCover"));
            }
            graphQLPage.bf = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profilePictureAsCover", graphQLPage.B_(), 108, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLPage.bg = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profilePictureHighRes", graphQLPage.B_(), 109, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLPage.bh = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profilePictureLarge", graphQLPage.B_(), 110, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a28;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a28 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLPage.bi = a28;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profile_photo", graphQLPage.B_(), 111, true);
            return true;
        } else if ("profile_pic_large".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_large"));
            }
            graphQLPage.bj = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profile_pic_large", graphQLPage.B_(), 112, true);
            return true;
        } else if ("profile_pic_medium".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_medium"));
            }
            graphQLPage.bk = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profile_pic_medium", graphQLPage.B_(), 113, true);
            return true;
        } else if ("profile_pic_small".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_small"));
            }
            graphQLPage.bl = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profile_pic_small", graphQLPage.B_(), 114, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLPage.bm = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profile_picture", graphQLPage.B_(), 115, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLPage.bn = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profile_picture_is_silhouette", graphQLPage.B_(), 116, false);
            return true;
        } else if ("raters".equals(str)) {
            GraphQLPageStarRatersConnection a29;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a29 = GraphQLPageStarRatersConnection__JsonHelper.m9521a(FieldAccessQueryTracker.a(jsonParser, "raters"));
            }
            graphQLPage.bo = a29;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "raters", graphQLPage.B_(), 117, true);
            return true;
        } else if ("recent_claims_count".equals(str)) {
            graphQLPage.bp = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "recent_claims_count", graphQLPage.B_(), 118, false);
            return true;
        } else if ("rectangular_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "rectangular_profile_picture"));
            }
            graphQLPage.bq = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "rectangular_profile_picture", graphQLPage.B_(), 119, true);
            return true;
        } else if ("redirection_info".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLRedirectionInfo a30 = GraphQLRedirectionInfo__JsonHelper.m21381a(FieldAccessQueryTracker.a(jsonParser, "redirection_info"));
                    if (a30 != null) {
                        r1.add(a30);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPage.br = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "redirection_info", graphQLPage.B_(), 120, true);
            return true;
        } else if ("related_article_title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.bs = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "related_article_title", graphQLPage.B_(), 121, false);
            return true;
        } else if ("representative_place_photos".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPhoto a31 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "representative_place_photos"));
                    if (a31 != null) {
                        r1.add(a31);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPage.bt = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "representative_place_photos", graphQLPage.B_(), 122, true);
            return true;
        } else if ("requestee_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.bu = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "requestee_id", graphQLPage.B_(), 123, false);
            return true;
        } else if ("requester_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.bv = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "requester_id", graphQLPage.B_(), 124, false);
            return true;
        } else if ("review_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "review_context"));
            }
            graphQLPage.bw = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "review_context", graphQLPage.B_(), 125, true);
            return true;
        } else if ("review_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLContactRecommendationField__JsonHelper.m6880a(FieldAccessQueryTracker.a(jsonParser, "review_story"));
            }
            graphQLPage.bx = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "review_story", graphQLPage.B_(), 126, true);
            return true;
        } else if ("saved_collection".equals(str)) {
            GraphQLTimelineAppCollection a32;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a32 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "saved_collection"));
            }
            graphQLPage.by = a32;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "saved_collection", graphQLPage.B_(), 127, true);
            return true;
        } else if ("secondary_subscribe_status".equals(str)) {
            graphQLPage.bz = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "secondary_subscribe_status", graphQLPage.B_(), 128, false);
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
            graphQLPage.bA = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "short_category_names", graphQLPage.B_(), 129, false);
            return true;
        } else if ("should_ask_for_menu".equals(str)) {
            graphQLPage.bB = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_ask_for_menu", graphQLPage.B_(), 130, false);
            return true;
        } else if ("should_show_message_button".equals(str)) {
            graphQLPage.bC = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_show_message_button", graphQLPage.B_(), 131, false);
            return true;
        } else if ("should_show_recent_activity_entry_point".equals(str)) {
            graphQLPage.bD = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_show_recent_activity_entry_point", graphQLPage.B_(), 132, false);
            return true;
        } else if ("should_show_recent_checkins_entry_point".equals(str)) {
            graphQLPage.bE = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_show_recent_checkins_entry_point", graphQLPage.B_(), 133, false);
            return true;
        } else if ("should_show_recent_mentions_entry_point".equals(str)) {
            graphQLPage.bF = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_show_recent_mentions_entry_point", graphQLPage.B_(), 134, false);
            return true;
        } else if ("should_show_recent_reviews_entry_point".equals(str)) {
            graphQLPage.bG = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_show_recent_reviews_entry_point", graphQLPage.B_(), 135, false);
            return true;
        } else if ("should_show_recent_shares_entry_point".equals(str)) {
            graphQLPage.bH = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_show_recent_shares_entry_point", graphQLPage.B_(), 136, false);
            return true;
        } else if ("should_show_reviews_on_profile".equals(str)) {
            graphQLPage.bI = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_show_reviews_on_profile", graphQLPage.B_(), 137, false);
            return true;
        } else if ("show_video_hub".equals(str)) {
            graphQLPage.bJ = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "show_video_hub", graphQLPage.B_(), 138, false);
            return true;
        } else if ("single_publisher_video_channels".equals(str)) {
            GraphQLSinglePublisherVideoChannelsConnection a33;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a33 = GraphQLSinglePublisherVideoChannelsConnection__JsonHelper.m21662a(FieldAccessQueryTracker.a(jsonParser, "single_publisher_video_channels"));
            }
            graphQLPage.bK = a33;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "single_publisher_video_channels", graphQLPage.B_(), 139, true);
            return true;
        } else if ("sports_match_data".equals(str)) {
            GraphQLSportsDataMatchData a34;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a34 = GraphQLSportsDataMatchData__JsonHelper.m21786a(FieldAccessQueryTracker.a(jsonParser, "sports_match_data"));
            }
            graphQLPage.bL = a34;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "sports_match_data", graphQLPage.B_(), 140, true);
            return true;
        } else if ("spotlight_locals_snippets".equals(str)) {
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
            graphQLPage.bM = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "spotlight_locals_snippets", graphQLPage.B_(), 141, false);
            return true;
        } else if ("spotlight_snippets_message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "spotlight_snippets_message"));
            }
            graphQLPage.bN = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "spotlight_snippets_message", graphQLPage.B_(), 142, true);
            return true;
        } else if ("squareProfilePicBig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "squareProfilePicBig"));
            }
            graphQLPage.bO = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "squareProfilePicBig", graphQLPage.B_(), 143, true);
            return true;
        } else if ("squareProfilePicHuge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "squareProfilePicHuge"));
            }
            graphQLPage.bP = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "squareProfilePicHuge", graphQLPage.B_(), 144, true);
            return true;
        } else if ("squareProfilePicSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "squareProfilePicSmall"));
            }
            graphQLPage.bQ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "squareProfilePicSmall", graphQLPage.B_(), 145, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a35;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a35 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLPage.bR = a35;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "streaming_profile_picture", graphQLPage.B_(), 146, true);
            return true;
        } else if ("subscribe_status".equals(str)) {
            graphQLPage.bS = GraphQLSubscribeStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "subscribe_status", graphQLPage.B_(), 147, false);
            return true;
        } else if ("super_category_type".equals(str)) {
            graphQLPage.bT = GraphQLPageSuperCategoryType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "super_category_type", graphQLPage.B_(), 148, false);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLPage.bU = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "taggable_object_profile_picture", graphQLPage.B_(), 149, true);
            return true;
        } else if ("timeline_pinned_unit".equals(str)) {
            GraphQLStory a36;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a36 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "timeline_pinned_unit"));
            }
            graphQLPage.bV = a36;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "timeline_pinned_unit", graphQLPage.B_(), 150, true);
            return true;
        } else if ("timeline_sections".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTimelineSectionsConnection__JsonHelper.m22223a(FieldAccessQueryTracker.a(jsonParser, "timeline_sections"));
            }
            graphQLPage.bW = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "timeline_sections", graphQLPage.B_(), 151, true);
            return true;
        } else if ("top_category_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.bX = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "top_category_name", graphQLPage.B_(), 152, false);
            return true;
        } else if ("top_headline_object".equals(str)) {
            GraphQLNode a37;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a37 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "top_headline_object"));
            }
            graphQLPage.bY = a37;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "top_headline_object", graphQLPage.B_(), 153, true);
            return true;
        } else if ("topic_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "topic_image"));
            }
            graphQLPage.bZ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "topic_image", graphQLPage.B_(), 154, true);
            return true;
        } else if ("trending_topic_data".equals(str)) {
            GraphQLTrendingTopicData a38;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a38 = GraphQLTrendingTopicData__JsonHelper.m22301a(FieldAccessQueryTracker.a(jsonParser, "trending_topic_data"));
            }
            graphQLPage.ca = a38;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "trending_topic_data", graphQLPage.B_(), 155, true);
            return true;
        } else if ("trending_topic_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.cb = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "trending_topic_name", graphQLPage.B_(), 156, false);
            return true;
        } else if ("unique_keyword".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.cc = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "unique_keyword", graphQLPage.B_(), 157, false);
            return true;
        } else if ("unread_count".equals(str)) {
            graphQLPage.cd = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "unread_count", graphQLPage.B_(), 158, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.ce = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "url", graphQLPage.B_(), 159, false);
            return true;
        } else if ("username".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.cf = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "username", graphQLPage.B_(), 160, false);
            return true;
        } else if ("verification_status".equals(str)) {
            graphQLPage.cg = GraphQLPageVerificationBadge.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "verification_status", graphQLPage.B_(), 161, false);
            return true;
        } else if ("video_channel_can_viewer_follow".equals(str)) {
            graphQLPage.ch = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_can_viewer_follow", graphQLPage.B_(), 162, false);
            return true;
        } else if ("video_channel_can_viewer_subscribe".equals(str)) {
            graphQLPage.ci = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_can_viewer_subscribe", graphQLPage.B_(), 163, false);
            return true;
        } else if ("video_channel_curator_profile".equals(str)) {
            GraphQLProfile a39;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a39 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "video_channel_curator_profile"));
            }
            graphQLPage.cj = a39;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_curator_profile", graphQLPage.B_(), 164, true);
            return true;
        } else if ("video_channel_has_new".equals(str)) {
            graphQLPage.ck = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_has_new", graphQLPage.B_(), 165, false);
            return true;
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            graphQLPage.cl = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_has_viewer_subscribed", graphQLPage.B_(), 166, false);
            return true;
        } else if ("video_channel_is_viewer_following".equals(str)) {
            graphQLPage.cm = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_is_viewer_following", graphQLPage.B_(), 167, false);
            return true;
        } else if ("video_channel_is_viewer_pinned".equals(str)) {
            graphQLPage.cn = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_is_viewer_pinned", graphQLPage.B_(), 168, false);
            return true;
        } else if ("video_channel_max_new_count".equals(str)) {
            graphQLPage.co = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_max_new_count", graphQLPage.B_(), 169, false);
            return true;
        } else if ("video_channel_new_count".equals(str)) {
            graphQLPage.cp = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_new_count", graphQLPage.B_(), 170, false);
            return true;
        } else if ("video_channel_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_channel_subtitle"));
            }
            graphQLPage.cq = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_subtitle", graphQLPage.B_(), 171, true);
            return true;
        } else if ("video_channel_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_channel_title"));
            }
            graphQLPage.cr = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "video_channel_title", graphQLPage.B_(), 172, true);
            return true;
        } else if ("viewer_acts_as_profile".equals(str)) {
            graphQLPage.cs = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "viewer_acts_as_profile", graphQLPage.B_(), 173, false);
            return true;
        } else if ("viewer_profile_permissions".equals(str)) {
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
            graphQLPage.ct = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "viewer_profile_permissions", graphQLPage.B_(), 174, false);
            return true;
        } else if ("viewer_recommendation".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLContactRecommendationField__JsonHelper.m6880a(FieldAccessQueryTracker.a(jsonParser, "viewer_recommendation"));
            }
            graphQLPage.cu = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "viewer_recommendation", graphQLPage.B_(), 175, true);
            return true;
        } else if ("viewer_saved_state".equals(str)) {
            graphQLPage.cv = GraphQLSavedState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "viewer_saved_state", graphQLPage.B_(), 176, false);
            return true;
        } else if ("viewer_star_rating".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLRating__JsonHelper.m21310a(FieldAccessQueryTracker.a(jsonParser, "viewer_star_rating"));
            }
            graphQLPage.cw = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "viewer_star_rating", graphQLPage.B_(), 177, true);
            return true;
        } else if ("viewer_timeline_collections_containing".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "viewer_timeline_collections_containing"));
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
            graphQLPage.cx = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "viewer_timeline_collections_containing", graphQLPage.B_(), 178, true);
            return true;
        } else if ("viewer_timeline_collections_supported".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "viewer_timeline_collections_supported"));
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
            graphQLPage.cy = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "viewer_timeline_collections_supported", graphQLPage.B_(), 179, true);
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
            graphQLPage.cz = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "websites", graphQLPage.B_(), 180, false);
            return true;
        } else if ("should_show_username".equals(str)) {
            graphQLPage.cA = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "should_show_username", graphQLPage.B_(), 181, false);
            return true;
        } else if ("viewer_visits".equals(str)) {
            GraphQLViewerVisitsConnection a40;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a40 = GraphQLViewerVisitsConnection__JsonHelper.m22492a(FieldAccessQueryTracker.a(jsonParser, "viewer_visits"));
            }
            graphQLPage.cB = a40;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "viewer_visits", graphQLPage.B_(), 182, true);
            return true;
        } else if ("page_logo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_logo"));
            }
            graphQLPage.cC = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "page_logo", graphQLPage.B_(), 183, true);
            return true;
        } else if ("page_icon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_icon"));
            }
            graphQLPage.cD = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "page_icon", graphQLPage.B_(), 184, true);
            return true;
        } else if ("is_viewer_subscribed_to_messenger_content".equals(str)) {
            graphQLPage.cE = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_viewer_subscribed_to_messenger_content", graphQLPage.B_(), 185, false);
            return true;
        } else if ("can_viewer_follow".equals(str)) {
            graphQLPage.cF = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "can_viewer_follow", graphQLPage.B_(), 186, false);
            return true;
        } else if ("locally_updated_containing_collection_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPage.cG = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "locally_updated_containing_collection_id", graphQLPage.B_(), 187, false);
            return true;
        } else if ("page_thumbnail_uri".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_thumbnail_uri"));
            }
            graphQLPage.cH = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "page_thumbnail_uri", graphQLPage.B_(), 188, true);
            return true;
        } else if ("timeline_stories".equals(str)) {
            GraphQLTimelineStoriesConnection a41;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a41 = GraphQLTimelineStoriesConnection__JsonHelper.m22229a(FieldAccessQueryTracker.a(jsonParser, "timeline_stories"));
            }
            graphQLPage.cI = a41;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "timeline_stories", graphQLPage.B_(), 189, true);
            return true;
        } else if ("profile_video".equals(str)) {
            GraphQLProfileVideo a42;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a42 = GraphQLProfileVideo__JsonHelper.m21111a(FieldAccessQueryTracker.a(jsonParser, "profile_video"));
            }
            graphQLPage.cJ = a42;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "profile_video", graphQLPage.B_(), 190, true);
            return true;
        } else if ("is_messenger_platform_bot".equals(str)) {
            graphQLPage.cK = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_messenger_platform_bot", graphQLPage.B_(), 191, false);
            return true;
        } else if ("page_call_to_action".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageCallToAction = GraphQLPageCallToAction__JsonHelper.m9484a(FieldAccessQueryTracker.a(jsonParser, "page_call_to_action"));
            }
            graphQLPage.cL = graphQLPageCallToAction;
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "page_call_to_action", graphQLPage.B_(), 192, true);
            return true;
        } else if (!"is_eligible_for_commercial_break".equals(str)) {
            return false;
        } else {
            graphQLPage.cM = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPage, "is_eligible_for_commercial_break", graphQLPage.B_(), 193, false);
            return true;
        }
    }

    public static void m9554a(JsonGenerator jsonGenerator, GraphQLPage graphQLPage, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPage.j() != null) {
            jsonGenerator.a("about");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPage.j(), true);
        }
        if (graphQLPage.k() != null) {
            jsonGenerator.a("activity_admin_info");
            GraphQLPageAdminInfo__JsonHelper.m9468a(jsonGenerator, graphQLPage.k(), true);
        }
        if (graphQLPage.l() != null) {
            jsonGenerator.a("address");
            GraphQLStreetAddress__JsonHelper.m21937a(jsonGenerator, graphQLPage.l(), true);
        }
        if (graphQLPage.m() != null) {
            jsonGenerator.a("admin_info");
            GraphQLPageAdminInfo__JsonHelper.m9468a(jsonGenerator, graphQLPage.m(), true);
        }
        if (graphQLPage.n() != null) {
            jsonGenerator.a("albums");
            GraphQLAlbumsConnection__JsonHelper.m6519a(jsonGenerator, graphQLPage.n(), true);
        }
        jsonGenerator.a("android_urls");
        if (graphQLPage.o() != null) {
            jsonGenerator.d();
            for (String str : graphQLPage.o()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("attribution");
        if (graphQLPage.p() != null) {
            jsonGenerator.d();
            for (GraphQLAttributionEntry graphQLAttributionEntry : graphQLPage.p()) {
                if (graphQLAttributionEntry != null) {
                    GraphQLAttributionEntry__JsonHelper.m6617a(jsonGenerator, graphQLAttributionEntry, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.q() != null) {
            jsonGenerator.a("author_text", graphQLPage.q());
        }
        jsonGenerator.a("away_toggle_expiration", graphQLPage.r());
        if (graphQLPage.s() != null) {
            jsonGenerator.a("best_description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPage.s(), true);
        }
        if (graphQLPage.t() != null) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLPage.t(), true);
        }
        jsonGenerator.a("business_info");
        if (graphQLPage.u() != null) {
            jsonGenerator.d();
            for (GraphQLBusinessInfo graphQLBusinessInfo : graphQLPage.u()) {
                if (graphQLBusinessInfo != null) {
                    GraphQLBusinessInfo__JsonHelper.m6706a(jsonGenerator, graphQLBusinessInfo, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("can_see_viewer_montage_thread", graphQLPage.v());
        jsonGenerator.a("can_viewer_claim", graphQLPage.w());
        jsonGenerator.a("can_viewer_get_notification", graphQLPage.x());
        jsonGenerator.a("can_viewer_like", graphQLPage.y());
        jsonGenerator.a("can_viewer_message", graphQLPage.z());
        jsonGenerator.a("can_viewer_post", graphQLPage.A());
        jsonGenerator.a("can_viewer_post_photo_to_timeline", graphQLPage.B());
        jsonGenerator.a("can_viewer_rate", graphQLPage.C());
        jsonGenerator.a("categories");
        if (graphQLPage.D() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLPage.D()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.E() != null) {
            jsonGenerator.a("category_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.E(), true);
        }
        jsonGenerator.a("category_names");
        if (graphQLPage.F() != null) {
            jsonGenerator.d();
            for (String str22 : graphQLPage.F()) {
                if (str22 != null) {
                    jsonGenerator.b(str22);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.G() != null) {
            jsonGenerator.a("category_type", graphQLPage.G().toString());
        }
        if (graphQLPage.H() != null) {
            jsonGenerator.a("city");
            m9554a(jsonGenerator, graphQLPage.H(), true);
        }
        jsonGenerator.a("commerce_page_settings");
        if (graphQLPage.I() != null) {
            jsonGenerator.d();
            for (GraphQLCommercePageSetting graphQLCommercePageSetting : graphQLPage.I()) {
                if (graphQLCommercePageSetting != null) {
                    jsonGenerator.b(graphQLCommercePageSetting.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.J() != null) {
            jsonGenerator.a("commerce_page_type", graphQLPage.J().toString());
        }
        if (graphQLPage.K() != null) {
            jsonGenerator.a("contact");
            GraphQLContact__JsonHelper.m6885a(jsonGenerator, graphQLPage.K(), true);
        }
        if (graphQLPage.L() != null) {
            jsonGenerator.a("contextual_name", graphQLPage.L());
        }
        if (graphQLPage.M() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLPage.M(), true);
        }
        if (graphQLPage.N() != null) {
            jsonGenerator.a("display_name", graphQLPage.N());
        }
        jsonGenerator.a("does_viewer_like", graphQLPage.O());
        jsonGenerator.a("email_addresses");
        if (graphQLPage.P() != null) {
            jsonGenerator.d();
            for (String str222 : graphQLPage.P()) {
                if (str222 != null) {
                    jsonGenerator.b(str222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.Q() != null) {
            jsonGenerator.a("entity_card_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPage.Q(), true);
        }
        jsonGenerator.a("events_calendar_can_viewer_subscribe", graphQLPage.R());
        jsonGenerator.a("events_calendar_subscriber_count", graphQLPage.S());
        if (graphQLPage.T() != null) {
            jsonGenerator.a("events_calendar_subscription_status", graphQLPage.T().toString());
        }
        if (graphQLPage.U() != null) {
            jsonGenerator.a("events_occurring_here");
            GraphQLEventsOccurringHereConnection__JsonHelper.m7358a(jsonGenerator, graphQLPage.U(), true);
        }
        jsonGenerator.a("expressed_as_place", graphQLPage.V());
        if (graphQLPage.W() != null) {
            jsonGenerator.a("featured_video");
            GraphQLVideo__JsonHelper.m22484a(jsonGenerator, graphQLPage.W(), true);
        }
        if (graphQLPage.X() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.X(), true);
        }
        if (graphQLPage.Y() != null) {
            jsonGenerator.a("firstSection");
            GraphQLTimelineSectionsConnection__JsonHelper.m22224a(jsonGenerator, graphQLPage.Y(), true);
        }
        if (graphQLPage.Z() != null) {
            jsonGenerator.a("followup_feed_units");
            GraphQLFollowUpFeedUnitsConnection__JsonHelper.m7533a(jsonGenerator, graphQLPage.Z(), true);
        }
        if (graphQLPage.aa() != null) {
            jsonGenerator.a("friends_who_like");
            GraphQLFriendsWhoLikeConnection__JsonHelper.m7642a(jsonGenerator, graphQLPage.aa(), true);
        }
        if (graphQLPage.ab() != null) {
            jsonGenerator.a("friends_who_visited");
            GraphQLFriendsWhoVisitedConnection__JsonHelper.m7648a(jsonGenerator, graphQLPage.ab(), true);
        }
        if (graphQLPage.ac() != null) {
            jsonGenerator.a("full_name", graphQLPage.ac());
        }
        jsonGenerator.a("hours");
        if (graphQLPage.ad() != null) {
            jsonGenerator.d();
            for (GraphQLTimeRange graphQLTimeRange : graphQLPage.ad()) {
                if (graphQLTimeRange != null) {
                    GraphQLTimeRange__JsonHelper.m22115a(jsonGenerator, graphQLTimeRange, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.ae() != null) {
            jsonGenerator.a("id", graphQLPage.ae());
        }
        if (graphQLPage.af() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.af(), true);
        }
        if (graphQLPage.ag() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLPage.ag(), true);
        }
        jsonGenerator.a("instant_articles_enabled", graphQLPage.ah());
        jsonGenerator.a("is_always_open", graphQLPage.ai());
        jsonGenerator.a("is_away_toggle_on", graphQLPage.aj());
        jsonGenerator.a("is_banned_by_page_viewer", graphQLPage.ak());
        jsonGenerator.a("is_commerce", graphQLPage.al());
        jsonGenerator.a("is_eligible_for_page_verification", graphQLPage.am());
        jsonGenerator.a("is_message_blocked_by_viewer", graphQLPage.an());
        jsonGenerator.a("is_messenger_promotion_blocked_by_viewer", graphQLPage.ao());
        jsonGenerator.a("is_messenger_user", graphQLPage.ap());
        jsonGenerator.a("is_owned", graphQLPage.aq());
        jsonGenerator.a("is_permanently_closed", graphQLPage.ar());
        jsonGenerator.a("is_place_map_hidden", graphQLPage.as());
        jsonGenerator.a("is_service_page", graphQLPage.at());
        jsonGenerator.a("is_verified", graphQLPage.au());
        jsonGenerator.a("is_verified_page", graphQLPage.av());
        jsonGenerator.a("is_viewer_notified_about", graphQLPage.aw());
        if (graphQLPage.ax() != null) {
            jsonGenerator.a("liked_profiles");
            GraphQLLikedProfilesConnection__JsonHelper.m8915a(jsonGenerator, graphQLPage.ax(), true);
        }
        if (graphQLPage.ay() != null) {
            jsonGenerator.a("live_video_subscription_status", graphQLPage.ay().toString());
        }
        if (graphQLPage.az() != null) {
            jsonGenerator.a("location");
            GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLPage.az(), true);
        }
        if (graphQLPage.aA() != null) {
            jsonGenerator.a("map_bounding_box");
            GraphQLGeoRectangle__JsonHelper.m7767a(jsonGenerator, graphQLPage.aA(), true);
        }
        jsonGenerator.a("map_zoom_level", graphQLPage.aB());
        if (graphQLPage.aC() != null) {
            jsonGenerator.a("menu_info");
            GraphQLPageMenuInfo__JsonHelper.m9501a(jsonGenerator, graphQLPage.aC(), true);
        }
        if (graphQLPage.aD() != null) {
            jsonGenerator.a("message_permalink", graphQLPage.aD());
        }
        if (graphQLPage.aE() != null) {
            jsonGenerator.a("montage_thread_fbid", graphQLPage.aE());
        }
        if (graphQLPage.aF() != null) {
            jsonGenerator.a("music_object");
            GraphQLOpenGraphObject__JsonHelper.m9410a(jsonGenerator, graphQLPage.aF(), true);
        }
        if (graphQLPage.aG() != null) {
            jsonGenerator.a("name", graphQLPage.aG());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLPage.aH() != null) {
            jsonGenerator.d();
            for (String str2222 : graphQLPage.aH()) {
                if (str2222 != null) {
                    jsonGenerator.b(str2222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.aI() != null) {
            jsonGenerator.a("neighborhood_name", graphQLPage.aI());
        }
        jsonGenerator.a("new_activity_count", graphQLPage.aJ());
        if (graphQLPage.aK() != null) {
            jsonGenerator.a("open_graph_composer_preview");
            GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLPage.aK(), true);
        }
        jsonGenerator.a("overall_rating", graphQLPage.aL());
        if (graphQLPage.aM() != null) {
            jsonGenerator.a("overall_star_rating");
            GraphQLRating__JsonHelper.m21311a(jsonGenerator, graphQLPage.aM(), true);
        }
        if (graphQLPage.aN() != null) {
            jsonGenerator.a("owned_events");
            GraphQLOwnedEventsConnection__JsonHelper.m9436a(jsonGenerator, graphQLPage.aN(), true);
        }
        if (graphQLPage.aO() != null) {
            jsonGenerator.a("pageProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.aO(), true);
        }
        if (graphQLPage.aP() != null) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnection__JsonHelper.m9495a(jsonGenerator, graphQLPage.aP(), true);
        }
        if (graphQLPage.aQ() != null) {
            jsonGenerator.a("page_nux", graphQLPage.aQ().toString());
        }
        jsonGenerator.a("page_payment_options");
        if (graphQLPage.aR() != null) {
            jsonGenerator.d();
            for (GraphQLPagePaymentOption graphQLPagePaymentOption : graphQLPage.aR()) {
                if (graphQLPagePaymentOption != null) {
                    jsonGenerator.b(graphQLPagePaymentOption.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.aS() != null) {
            jsonGenerator.a("page_visits");
            GraphQLPageVisitsConnection__JsonHelper.m9552a(jsonGenerator, graphQLPage.aS(), true);
        }
        jsonGenerator.a("pending_claims_count", graphQLPage.aT());
        if (graphQLPage.aU() != null) {
            jsonGenerator.a("permanently_closed_status", graphQLPage.aU().toString());
        }
        if (graphQLPage.aV() != null) {
            jsonGenerator.a("phone_number");
            GraphQLPhoneNumber__JsonHelper.m20714a(jsonGenerator, graphQLPage.aV(), true);
        }
        if (graphQLPage.aW() != null) {
            jsonGenerator.a("placeProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.aW(), true);
        }
        if (graphQLPage.aX() != null) {
            jsonGenerator.a("place_open_status");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPage.aX(), true);
        }
        if (graphQLPage.aY() != null) {
            jsonGenerator.a("place_open_status_type", graphQLPage.aY().toString());
        }
        if (graphQLPage.aZ() != null) {
            jsonGenerator.a("place_topic_id", graphQLPage.aZ());
        }
        if (graphQLPage.ba() != null) {
            jsonGenerator.a("place_type", graphQLPage.ba().toString());
        }
        if (graphQLPage.bb() != null) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLPage.bb(), true);
        }
        if (graphQLPage.bc() != null) {
            jsonGenerator.a("posted_photos");
            GraphQLPostedPhotosConnection__JsonHelper.m20975a(jsonGenerator, graphQLPage.bc(), true);
        }
        if (graphQLPage.bd() != null) {
            jsonGenerator.a("price_range_description", graphQLPage.bd());
        }
        if (graphQLPage.be() != null) {
            jsonGenerator.a("privacy_option");
            GraphQLPrivacyOption__JsonHelper.a(jsonGenerator, graphQLPage.be(), true);
        }
        if (graphQLPage.bf() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bf(), true);
        }
        if (graphQLPage.bg() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bg(), true);
        }
        if (graphQLPage.bh() != null) {
            jsonGenerator.a("profilePicture32");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bh(), true);
        }
        if (graphQLPage.bi() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bi(), true);
        }
        if (graphQLPage.bj() != null) {
            jsonGenerator.a("profilePicture60");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bj(), true);
        }
        if (graphQLPage.bk() != null) {
            jsonGenerator.a("profilePicture74");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bk(), true);
        }
        if (graphQLPage.bl() != null) {
            jsonGenerator.a("profilePictureAsCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bl(), true);
        }
        if (graphQLPage.bm() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bm(), true);
        }
        if (graphQLPage.bn() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bn(), true);
        }
        if (graphQLPage.bo() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPage.bo(), true);
        }
        if (graphQLPage.bp() != null) {
            jsonGenerator.a("profile_pic_large");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bp(), true);
        }
        if (graphQLPage.bq() != null) {
            jsonGenerator.a("profile_pic_medium");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bq(), true);
        }
        if (graphQLPage.br() != null) {
            jsonGenerator.a("profile_pic_small");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.br(), true);
        }
        if (graphQLPage.bs() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bs(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLPage.bt());
        if (graphQLPage.bu() != null) {
            jsonGenerator.a("raters");
            GraphQLPageStarRatersConnection__JsonHelper.m9522a(jsonGenerator, graphQLPage.bu(), true);
        }
        jsonGenerator.a("recent_claims_count", graphQLPage.bv());
        if (graphQLPage.bw() != null) {
            jsonGenerator.a("rectangular_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bw(), true);
        }
        jsonGenerator.a("redirection_info");
        if (graphQLPage.bx() != null) {
            jsonGenerator.d();
            for (GraphQLRedirectionInfo graphQLRedirectionInfo : graphQLPage.bx()) {
                if (graphQLRedirectionInfo != null) {
                    GraphQLRedirectionInfo__JsonHelper.m21382a(jsonGenerator, graphQLRedirectionInfo, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.by() != null) {
            jsonGenerator.a("related_article_title", graphQLPage.by());
        }
        jsonGenerator.a("representative_place_photos");
        if (graphQLPage.bz() != null) {
            jsonGenerator.d();
            for (GraphQLPhoto graphQLPhoto : graphQLPage.bz()) {
                if (graphQLPhoto != null) {
                    GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPhoto, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.bA() != null) {
            jsonGenerator.a("requestee_id", graphQLPage.bA());
        }
        if (graphQLPage.bB() != null) {
            jsonGenerator.a("requester_id", graphQLPage.bB());
        }
        if (graphQLPage.bC() != null) {
            jsonGenerator.a("review_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPage.bC(), true);
        }
        if (graphQLPage.bD() != null) {
            jsonGenerator.a("review_story");
            GraphQLContactRecommendationField__JsonHelper.m6881a(jsonGenerator, graphQLPage.bD(), true);
        }
        if (graphQLPage.bE() != null) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLPage.bE(), true);
        }
        if (graphQLPage.bF() != null) {
            jsonGenerator.a("secondary_subscribe_status", graphQLPage.bF().toString());
        }
        jsonGenerator.a("short_category_names");
        if (graphQLPage.bG() != null) {
            jsonGenerator.d();
            for (String str22222 : graphQLPage.bG()) {
                if (str22222 != null) {
                    jsonGenerator.b(str22222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("should_ask_for_menu", graphQLPage.bH());
        jsonGenerator.a("should_show_message_button", graphQLPage.bI());
        jsonGenerator.a("should_show_recent_activity_entry_point", graphQLPage.bJ());
        jsonGenerator.a("should_show_recent_checkins_entry_point", graphQLPage.bK());
        jsonGenerator.a("should_show_recent_mentions_entry_point", graphQLPage.bL());
        jsonGenerator.a("should_show_recent_reviews_entry_point", graphQLPage.bM());
        jsonGenerator.a("should_show_recent_shares_entry_point", graphQLPage.bN());
        jsonGenerator.a("should_show_reviews_on_profile", graphQLPage.bO());
        jsonGenerator.a("show_video_hub", graphQLPage.bP());
        if (graphQLPage.bQ() != null) {
            jsonGenerator.a("single_publisher_video_channels");
            GraphQLSinglePublisherVideoChannelsConnection__JsonHelper.m21663a(jsonGenerator, graphQLPage.bQ(), true);
        }
        if (graphQLPage.bR() != null) {
            jsonGenerator.a("sports_match_data");
            GraphQLSportsDataMatchData__JsonHelper.m21787a(jsonGenerator, graphQLPage.bR(), true);
        }
        jsonGenerator.a("spotlight_locals_snippets");
        if (graphQLPage.bS() != null) {
            jsonGenerator.d();
            for (String str222222 : graphQLPage.bS()) {
                if (str222222 != null) {
                    jsonGenerator.b(str222222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.bT() != null) {
            jsonGenerator.a("spotlight_snippets_message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPage.bT(), true);
        }
        if (graphQLPage.bU() != null) {
            jsonGenerator.a("squareProfilePicBig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bU(), true);
        }
        if (graphQLPage.bV() != null) {
            jsonGenerator.a("squareProfilePicHuge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bV(), true);
        }
        if (graphQLPage.bW() != null) {
            jsonGenerator.a("squareProfilePicSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.bW(), true);
        }
        if (graphQLPage.bX() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLPage.bX(), true);
        }
        if (graphQLPage.bY() != null) {
            jsonGenerator.a("subscribe_status", graphQLPage.bY().toString());
        }
        if (graphQLPage.bZ() != null) {
            jsonGenerator.a("super_category_type", graphQLPage.bZ().toString());
        }
        if (graphQLPage.ca() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.ca(), true);
        }
        if (graphQLPage.cb() != null) {
            jsonGenerator.a("timeline_pinned_unit");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLPage.cb(), true);
        }
        if (graphQLPage.cc() != null) {
            jsonGenerator.a("timeline_sections");
            GraphQLTimelineSectionsConnection__JsonHelper.m22224a(jsonGenerator, graphQLPage.cc(), true);
        }
        if (graphQLPage.cd() != null) {
            jsonGenerator.a("top_category_name", graphQLPage.cd());
        }
        if (graphQLPage.ce() != null) {
            jsonGenerator.a("top_headline_object");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLPage.ce(), true);
        }
        if (graphQLPage.cf() != null) {
            jsonGenerator.a("topic_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.cf(), true);
        }
        if (graphQLPage.cg() != null) {
            jsonGenerator.a("trending_topic_data");
            GraphQLTrendingTopicData__JsonHelper.m22302a(jsonGenerator, graphQLPage.cg(), true);
        }
        if (graphQLPage.ch() != null) {
            jsonGenerator.a("trending_topic_name", graphQLPage.ch());
        }
        if (graphQLPage.ci() != null) {
            jsonGenerator.a("unique_keyword", graphQLPage.ci());
        }
        jsonGenerator.a("unread_count", graphQLPage.cj());
        if (graphQLPage.ck() != null) {
            jsonGenerator.a("url", graphQLPage.ck());
        }
        if (graphQLPage.cl() != null) {
            jsonGenerator.a("username", graphQLPage.cl());
        }
        if (graphQLPage.cm() != null) {
            jsonGenerator.a("verification_status", graphQLPage.cm().toString());
        }
        jsonGenerator.a("video_channel_can_viewer_follow", graphQLPage.cn());
        jsonGenerator.a("video_channel_can_viewer_subscribe", graphQLPage.co());
        if (graphQLPage.cp() != null) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLPage.cp(), true);
        }
        jsonGenerator.a("video_channel_has_new", graphQLPage.cq());
        jsonGenerator.a("video_channel_has_viewer_subscribed", graphQLPage.cr());
        jsonGenerator.a("video_channel_is_viewer_following", graphQLPage.cs());
        jsonGenerator.a("video_channel_is_viewer_pinned", graphQLPage.ct());
        jsonGenerator.a("video_channel_max_new_count", graphQLPage.cu());
        jsonGenerator.a("video_channel_new_count", graphQLPage.cv());
        if (graphQLPage.cw() != null) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPage.cw(), true);
        }
        if (graphQLPage.cx() != null) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPage.cx(), true);
        }
        jsonGenerator.a("viewer_acts_as_profile", graphQLPage.cy());
        jsonGenerator.a("viewer_profile_permissions");
        if (graphQLPage.cz() != null) {
            jsonGenerator.d();
            for (String str2222222 : graphQLPage.cz()) {
                if (str2222222 != null) {
                    jsonGenerator.b(str2222222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPage.cA() != null) {
            jsonGenerator.a("viewer_recommendation");
            GraphQLContactRecommendationField__JsonHelper.m6881a(jsonGenerator, graphQLPage.cA(), true);
        }
        if (graphQLPage.cB() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLPage.cB().toString());
        }
        if (graphQLPage.cC() != null) {
            jsonGenerator.a("viewer_star_rating");
            GraphQLRating__JsonHelper.m21311a(jsonGenerator, graphQLPage.cC(), true);
        }
        jsonGenerator.a("viewer_timeline_collections_containing");
        if (graphQLPage.cD() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection : graphQLPage.cD()) {
                if (graphQLTimelineAppCollection != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("viewer_timeline_collections_supported");
        if (graphQLPage.cE() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection2 : graphQLPage.cE()) {
                if (graphQLTimelineAppCollection2 != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("websites");
        if (graphQLPage.cF() != null) {
            jsonGenerator.d();
            for (String str22222222 : graphQLPage.cF()) {
                if (str22222222 != null) {
                    jsonGenerator.b(str22222222);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("should_show_username", graphQLPage.cG());
        if (graphQLPage.cH() != null) {
            jsonGenerator.a("viewer_visits");
            GraphQLViewerVisitsConnection__JsonHelper.m22493a(jsonGenerator, graphQLPage.cH(), true);
        }
        if (graphQLPage.cI() != null) {
            jsonGenerator.a("page_logo");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.cI(), true);
        }
        if (graphQLPage.cJ() != null) {
            jsonGenerator.a("page_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.cJ(), true);
        }
        jsonGenerator.a("is_viewer_subscribed_to_messenger_content", graphQLPage.cK());
        jsonGenerator.a("can_viewer_follow", graphQLPage.cL());
        if (graphQLPage.cM() != null) {
            jsonGenerator.a("locally_updated_containing_collection_id", graphQLPage.cM());
        }
        if (graphQLPage.cN() != null) {
            jsonGenerator.a("page_thumbnail_uri");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPage.cN(), true);
        }
        if (graphQLPage.cO() != null) {
            jsonGenerator.a("timeline_stories");
            GraphQLTimelineStoriesConnection__JsonHelper.m22230a(jsonGenerator, graphQLPage.cO(), true);
        }
        if (graphQLPage.cP() != null) {
            jsonGenerator.a("profile_video");
            GraphQLProfileVideo__JsonHelper.m21112a(jsonGenerator, graphQLPage.cP(), true);
        }
        jsonGenerator.a("is_messenger_platform_bot", graphQLPage.cQ());
        if (graphQLPage.cR() != null) {
            jsonGenerator.a("page_call_to_action");
            GraphQLPageCallToAction__JsonHelper.m9485a(jsonGenerator, graphQLPage.cR(), true);
        }
        jsonGenerator.a("is_eligible_for_commercial_break", graphQLPage.cS());
        if (z) {
            jsonGenerator.g();
        }
    }
}
