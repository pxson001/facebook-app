package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventNotificationSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventType;
import com.facebook.graphql.enums.GraphQLEventVisibility;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: imageLowRes */
public final class GraphQLEvent__JsonHelper {
    public static GraphQLEvent m7344a(JsonParser jsonParser) {
        GraphQLEvent graphQLEvent = new GraphQLEvent();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7346a(graphQLEvent, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEvent;
    }

    private static boolean m7346a(GraphQLEvent graphQLEvent, String str, JsonParser jsonParser) {
        long j = 0;
        GraphQLEventTicketProvider graphQLEventTicketProvider = null;
        if ("action_style".equals(str)) {
            graphQLEvent.d = GraphQLEventActionStyle.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "action_style", graphQLEvent.a_, 0, false);
            return true;
        } else if ("album".equals(str)) {
            GraphQLAlbum a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLAlbum__JsonHelper.m6510a(FieldAccessQueryTracker.a(jsonParser, "album"));
            }
            graphQLEvent.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "album", graphQLEvent.B_(), 1, true);
            return true;
        } else if ("allEventDeclines".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventDeclinesConnection__JsonHelper.m7169a(FieldAccessQueryTracker.a(jsonParser, "allEventDeclines"));
            }
            graphQLEvent.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "allEventDeclines", graphQLEvent.B_(), 2, true);
            return true;
        } else if ("allEventMaybes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMaybesConnection__JsonHelper.m7224a(FieldAccessQueryTracker.a(jsonParser, "allEventMaybes"));
            }
            graphQLEvent.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "allEventMaybes", graphQLEvent.B_(), 3, true);
            return true;
        } else if ("allEventMembers".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMembersConnection__JsonHelper.m7245a(FieldAccessQueryTracker.a(jsonParser, "allEventMembers"));
            }
            graphQLEvent.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "allEventMembers", graphQLEvent.B_(), 4, true);
            return true;
        } else if ("attending_activity".equals(str)) {
            GraphQLInlineActivity a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLInlineActivity__JsonHelper.m8696a(FieldAccessQueryTracker.a(jsonParser, "attending_activity"));
            }
            graphQLEvent.i = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "attending_activity", graphQLEvent.B_(), 5, true);
            return true;
        } else if ("blurredCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "blurredCoverPhoto"));
            }
            graphQLEvent.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "blurredCoverPhoto", graphQLEvent.B_(), 6, true);
            return true;
        } else if ("boostable_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "boostable_story"));
            }
            graphQLEvent.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "boostable_story", graphQLEvent.B_(), 7, true);
            return true;
        } else if ("can_guests_invite_friends".equals(str)) {
            graphQLEvent.l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_guests_invite_friends", graphQLEvent.B_(), 8, false);
            return true;
        } else if ("can_post_be_moderated".equals(str)) {
            graphQLEvent.m = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_post_be_moderated", graphQLEvent.B_(), 9, false);
            return true;
        } else if ("can_view_members".equals(str)) {
            graphQLEvent.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_view_members", graphQLEvent.B_(), 10, false);
            return true;
        } else if ("can_viewer_change_guest_status".equals(str)) {
            graphQLEvent.o = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_viewer_change_guest_status", graphQLEvent.B_(), 11, false);
            return true;
        } else if ("can_viewer_create_post".equals(str)) {
            graphQLEvent.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_viewer_create_post", graphQLEvent.B_(), 12, false);
            return true;
        } else if ("can_viewer_join".equals(str)) {
            graphQLEvent.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_viewer_join", graphQLEvent.B_(), 13, false);
            return true;
        } else if ("can_viewer_message".equals(str)) {
            graphQLEvent.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_viewer_message", graphQLEvent.B_(), 14, false);
            return true;
        } else if ("can_viewer_post".equals(str)) {
            graphQLEvent.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_viewer_post", graphQLEvent.B_(), 15, false);
            return true;
        } else if ("category_icon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "category_icon"));
            }
            graphQLEvent.t = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "category_icon", graphQLEvent.B_(), 16, true);
            return true;
        } else if ("connection_style".equals(str)) {
            graphQLEvent.u = GraphQLConnectionStyle.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "connection_style", graphQLEvent.B_(), 17, false);
            return true;
        } else if ("contextual_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.v = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "contextual_name", graphQLEvent.B_(), 18, false);
            return true;
        } else if ("cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "cover_photo"));
            }
            graphQLEvent.w = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "cover_photo", graphQLEvent.B_(), 19, true);
            return true;
        } else if ("created_for_group".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLGroup__JsonHelper.m8518a(FieldAccessQueryTracker.a(jsonParser, "created_for_group"));
            }
            graphQLEvent.x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "created_for_group", graphQLEvent.B_(), 20, true);
            return true;
        } else if ("creation_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "creation_story"));
            }
            graphQLEvent.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "creation_story", graphQLEvent.B_(), 21, true);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLEvent.z = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "creation_time", graphQLEvent.B_(), 22, false);
            return true;
        } else if ("end_timestamp".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLEvent.A = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "end_timestamp", graphQLEvent.B_(), 23, false);
            return true;
        } else if ("eventCategoryLabel".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventCategoryData__JsonHelper.m7122a(FieldAccessQueryTracker.a(jsonParser, "eventCategoryLabel"));
            }
            graphQLEvent.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "eventCategoryLabel", graphQLEvent.B_(), 24, true);
            return true;
        } else if ("eventProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "eventProfilePicture"));
            }
            graphQLEvent.C = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "eventProfilePicture", graphQLEvent.B_(), 25, true);
            return true;
        } else if ("eventUrl".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.D = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "eventUrl", graphQLEvent.B_(), 26, false);
            return true;
        } else if ("event_buy_ticket_display_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.E = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_buy_ticket_display_url", graphQLEvent.B_(), 27, false);
            return true;
        } else if ("event_buy_ticket_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.F = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_buy_ticket_url", graphQLEvent.B_(), 28, false);
            return true;
        } else if ("event_category_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventCategoryData__JsonHelper.m7122a(FieldAccessQueryTracker.a(jsonParser, "event_category_info"));
            }
            graphQLEvent.G = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_category_info", graphQLEvent.B_(), 29, true);
            return true;
        } else if ("event_cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "event_cover_photo"));
            }
            graphQLEvent.H = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_cover_photo", graphQLEvent.B_(), 30, true);
            return true;
        } else if ("event_creator".equals(str)) {
            GraphQLActor a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "event_creator"));
            }
            graphQLEvent.I = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_creator", graphQLEvent.B_(), 31, true);
            return true;
        } else if ("event_declines".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventDeclinesConnection__JsonHelper.m7169a(FieldAccessQueryTracker.a(jsonParser, "event_declines"));
            }
            graphQLEvent.J = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_declines", graphQLEvent.B_(), 32, true);
            return true;
        } else if ("event_description".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "event_description"));
            }
            graphQLEvent.K = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_description", graphQLEvent.B_(), 33, true);
            return true;
        } else if ("event_hosts".equals(str)) {
            GraphQLEventHostsConnection a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLEventHostsConnection__JsonHelper.m7191a(FieldAccessQueryTracker.a(jsonParser, "event_hosts"));
            }
            graphQLEvent.L = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_hosts", graphQLEvent.B_(), 34, true);
            return true;
        } else if ("event_invitees".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventInviteesConnection__JsonHelper.m7206a(FieldAccessQueryTracker.a(jsonParser, "event_invitees"));
            }
            graphQLEvent.M = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_invitees", graphQLEvent.B_(), 35, true);
            return true;
        } else if ("event_kind".equals(str)) {
            graphQLEvent.N = GraphQLEventPrivacyType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_kind", graphQLEvent.B_(), 36, false);
            return true;
        } else if ("event_maybes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMaybesConnection__JsonHelper.m7224a(FieldAccessQueryTracker.a(jsonParser, "event_maybes"));
            }
            graphQLEvent.O = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_maybes", graphQLEvent.B_(), 37, true);
            return true;
        } else if ("event_members".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMembersConnection__JsonHelper.m7245a(FieldAccessQueryTracker.a(jsonParser, "event_members"));
            }
            graphQLEvent.P = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_members", graphQLEvent.B_(), 38, true);
            return true;
        } else if ("event_place".equals(str)) {
            GraphQLPlace a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "event_place"));
            }
            graphQLEvent.Q = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_place", graphQLEvent.B_(), 39, true);
            return true;
        } else if ("event_privacy_type".equals(str)) {
            graphQLEvent.R = GraphQLEventPrivacyType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_privacy_type", graphQLEvent.B_(), 40, false);
            return true;
        } else if ("event_ticket_provider_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.S = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_ticket_provider_name", graphQLEvent.B_(), 41, false);
            return true;
        } else if ("event_type".equals(str)) {
            graphQLEvent.T = GraphQLEventType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_type", graphQLEvent.B_(), 42, false);
            return true;
        } else if ("event_user_location_shares_count".equals(str)) {
            graphQLEvent.U = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_user_location_shares_count", graphQLEvent.B_(), 43, false);
            return true;
        } else if ("event_user_location_shares_start_interval".equals(str)) {
            graphQLEvent.V = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_user_location_shares_start_interval", graphQLEvent.B_(), 44, false);
            return true;
        } else if ("event_viewer_capability".equals(str)) {
            GraphQLEventViewerCapability a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLEventViewerCapability__JsonHelper.m7326a(FieldAccessQueryTracker.a(jsonParser, "event_viewer_capability"));
            }
            graphQLEvent.W = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_viewer_capability", graphQLEvent.B_(), 45, true);
            return true;
        } else if ("event_visibility".equals(str)) {
            graphQLEvent.X = GraphQLEventVisibility.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_visibility", graphQLEvent.B_(), 46, false);
            return true;
        } else if ("event_watchers".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventWatchersConnection__JsonHelper.m7332a(FieldAccessQueryTracker.a(jsonParser, "event_watchers"));
            }
            graphQLEvent.Y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_watchers", graphQLEvent.B_(), 47, true);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLEvent.Z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "feedAwesomizerProfilePicture", graphQLEvent.B_(), 48, true);
            return true;
        } else if ("friendEventDeclines".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventDeclinesConnection__JsonHelper.m7169a(FieldAccessQueryTracker.a(jsonParser, "friendEventDeclines"));
            }
            graphQLEvent.aa = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventDeclines", graphQLEvent.B_(), 49, true);
            return true;
        } else if ("friendEventInvitees".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventInviteesConnection__JsonHelper.m7206a(FieldAccessQueryTracker.a(jsonParser, "friendEventInvitees"));
            }
            graphQLEvent.ab = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventInvitees", graphQLEvent.B_(), 50, true);
            return true;
        } else if ("friendEventInviteesFirst5".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventInviteesConnection__JsonHelper.m7206a(FieldAccessQueryTracker.a(jsonParser, "friendEventInviteesFirst5"));
            }
            graphQLEvent.ac = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventInviteesFirst5", graphQLEvent.B_(), 51, true);
            return true;
        } else if ("friendEventMaybes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMaybesConnection__JsonHelper.m7224a(FieldAccessQueryTracker.a(jsonParser, "friendEventMaybes"));
            }
            graphQLEvent.ad = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventMaybes", graphQLEvent.B_(), 52, true);
            return true;
        } else if ("friendEventMaybesFirst5".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMaybesConnection__JsonHelper.m7224a(FieldAccessQueryTracker.a(jsonParser, "friendEventMaybesFirst5"));
            }
            graphQLEvent.ae = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventMaybesFirst5", graphQLEvent.B_(), 53, true);
            return true;
        } else if ("friendEventMembers".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMembersConnection__JsonHelper.m7245a(FieldAccessQueryTracker.a(jsonParser, "friendEventMembers"));
            }
            graphQLEvent.af = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventMembers", graphQLEvent.B_(), 54, true);
            return true;
        } else if ("friendEventMembersFirst5".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMembersConnection__JsonHelper.m7245a(FieldAccessQueryTracker.a(jsonParser, "friendEventMembersFirst5"));
            }
            graphQLEvent.ag = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventMembersFirst5", graphQLEvent.B_(), 55, true);
            return true;
        } else if ("friendEventWatchers".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventWatchersConnection__JsonHelper.m7332a(FieldAccessQueryTracker.a(jsonParser, "friendEventWatchers"));
            }
            graphQLEvent.ah = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventWatchers", graphQLEvent.B_(), 56, true);
            return true;
        } else if ("friendEventWatchersFirst5".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventWatchersConnection__JsonHelper.m7332a(FieldAccessQueryTracker.a(jsonParser, "friendEventWatchersFirst5"));
            }
            graphQLEvent.ai = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friendEventWatchersFirst5", graphQLEvent.B_(), 57, true);
            return true;
        } else if ("friends_going".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMembersConnection__JsonHelper.m7245a(FieldAccessQueryTracker.a(jsonParser, "friends_going"));
            }
            graphQLEvent.aj = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friends_going", graphQLEvent.B_(), 58, true);
            return true;
        } else if ("friends_interested".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventWatchersConnection__JsonHelper.m7332a(FieldAccessQueryTracker.a(jsonParser, "friends_interested"));
            }
            graphQLEvent.ak = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friends_interested", graphQLEvent.B_(), 59, true);
            return true;
        } else if ("friends_invited".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventInviteesConnection__JsonHelper.m7206a(FieldAccessQueryTracker.a(jsonParser, "friends_invited"));
            }
            graphQLEvent.al = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "friends_invited", graphQLEvent.B_(), 60, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.am = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "id", graphQLEvent.B_(), 62, false);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLEvent.an = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "imageHighOrig", graphQLEvent.B_(), 63, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLEvent.ao = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "inline_activities", graphQLEvent.B_(), 64, true);
            return true;
        } else if ("is_all_day".equals(str)) {
            graphQLEvent.ap = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "is_all_day", graphQLEvent.B_(), 65, false);
            return true;
        } else if ("is_canceled".equals(str)) {
            graphQLEvent.aq = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "is_canceled", graphQLEvent.B_(), 66, false);
            return true;
        } else if ("is_event_draft".equals(str)) {
            graphQLEvent.ar = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "is_event_draft", graphQLEvent.B_(), 67, false);
            return true;
        } else if ("is_message_blocked_by_viewer".equals(str)) {
            graphQLEvent.as = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "is_message_blocked_by_viewer", graphQLEvent.B_(), 68, false);
            return true;
        } else if ("is_privacy_locked".equals(str)) {
            graphQLEvent.at = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "is_privacy_locked", graphQLEvent.B_(), 69, false);
            return true;
        } else if ("live_permalink_time_range_sentence".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.au = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "live_permalink_time_range_sentence", graphQLEvent.B_(), 71, false);
            return true;
        } else if ("location".equals(str)) {
            GraphQLLocation a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "location"));
            }
            graphQLEvent.av = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "location", graphQLEvent.B_(), 72, true);
            return true;
        } else if ("map_bounding_box".equals(str)) {
            GraphQLGeoRectangle a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLGeoRectangle__JsonHelper.m7766a(FieldAccessQueryTracker.a(jsonParser, "map_bounding_box"));
            }
            graphQLEvent.aw = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "map_bounding_box", graphQLEvent.B_(), 73, true);
            return true;
        } else if ("map_zoom_level".equals(str)) {
            graphQLEvent.ax = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "map_zoom_level", graphQLEvent.B_(), 74, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.ay = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "name", graphQLEvent.B_(), 75, false);
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
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLEvent.az = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "name_search_tokens", graphQLEvent.B_(), 76, false);
            return true;
        } else if ("open_graph_composer_preview".equals(str)) {
            GraphQLStoryAttachment a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "open_graph_composer_preview"));
            }
            graphQLEvent.aA = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "open_graph_composer_preview", graphQLEvent.B_(), 77, true);
            return true;
        } else if ("otherEventDeclines".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventDeclinesConnection__JsonHelper.m7169a(FieldAccessQueryTracker.a(jsonParser, "otherEventDeclines"));
            }
            graphQLEvent.aB = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "otherEventDeclines", graphQLEvent.B_(), 78, true);
            return true;
        } else if ("otherEventInvitees".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventInviteesConnection__JsonHelper.m7206a(FieldAccessQueryTracker.a(jsonParser, "otherEventInvitees"));
            }
            graphQLEvent.aC = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "otherEventInvitees", graphQLEvent.B_(), 79, true);
            return true;
        } else if ("otherEventMaybes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMaybesConnection__JsonHelper.m7224a(FieldAccessQueryTracker.a(jsonParser, "otherEventMaybes"));
            }
            graphQLEvent.aD = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "otherEventMaybes", graphQLEvent.B_(), 80, true);
            return true;
        } else if ("otherEventMembers".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventMembersConnection__JsonHelper.m7245a(FieldAccessQueryTracker.a(jsonParser, "otherEventMembers"));
            }
            graphQLEvent.aE = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "otherEventMembers", graphQLEvent.B_(), 81, true);
            return true;
        } else if ("otherEventWatchers".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLEventWatchersConnection__JsonHelper.m7332a(FieldAccessQueryTracker.a(jsonParser, "otherEventWatchers"));
            }
            graphQLEvent.aF = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "otherEventWatchers", graphQLEvent.B_(), 82, true);
            return true;
        } else if ("parent_group".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLGroup__JsonHelper.m8518a(FieldAccessQueryTracker.a(jsonParser, "parent_group"));
            }
            graphQLEvent.aG = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "parent_group", graphQLEvent.B_(), 83, true);
            return true;
        } else if ("pending_post_count".equals(str)) {
            graphQLEvent.aH = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "pending_post_count", graphQLEvent.B_(), 84, false);
            return true;
        } else if ("placeProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "placeProfilePicture"));
            }
            graphQLEvent.aI = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "placeProfilePicture", graphQLEvent.B_(), 85, true);
            return true;
        } else if ("place_topic_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.aJ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "place_topic_id", graphQLEvent.B_(), 86, false);
            return true;
        } else if ("place_type".equals(str)) {
            graphQLEvent.aK = GraphQLPlaceType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "place_type", graphQLEvent.B_(), 87, false);
            return true;
        } else if ("post_approval_required".equals(str)) {
            graphQLEvent.aL = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "post_approval_required", graphQLEvent.B_(), 88, false);
            return true;
        } else if ("posted_item_privacy_scope".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "posted_item_privacy_scope"));
            }
            graphQLEvent.aM = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "posted_item_privacy_scope", graphQLEvent.B_(), 89, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLEvent.aN = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "privacy_scope", graphQLEvent.B_(), 90, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLEvent.aO = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profileImageLarge", graphQLEvent.B_(), 91, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLEvent.aP = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profileImageSmall", graphQLEvent.B_(), 92, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLEvent.aQ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profilePicture50", graphQLEvent.B_(), 93, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLEvent.aR = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profilePictureHighRes", graphQLEvent.B_(), 94, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLEvent.aS = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profilePictureLarge", graphQLEvent.B_(), 95, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLEvent.aT = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profile_photo", graphQLEvent.B_(), 96, true);
            return true;
        } else if ("profile_pic_large".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_large"));
            }
            graphQLEvent.aU = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profile_pic_large", graphQLEvent.B_(), 97, true);
            return true;
        } else if ("profile_pic_medium".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_medium"));
            }
            graphQLEvent.aV = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profile_pic_medium", graphQLEvent.B_(), 98, true);
            return true;
        } else if ("profile_pic_small".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_pic_small"));
            }
            graphQLEvent.aW = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profile_pic_small", graphQLEvent.B_(), 99, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLEvent.aX = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profile_picture", graphQLEvent.B_(), 100, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLEvent.aY = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "profile_picture_is_silhouette", graphQLEvent.B_(), 101, false);
            return true;
        } else if ("saved_collection".equals(str)) {
            GraphQLTimelineAppCollection a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "saved_collection"));
            }
            graphQLEvent.aZ = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "saved_collection", graphQLEvent.B_(), 102, true);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLEvent.ba = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "social_context", graphQLEvent.B_(), 103, true);
            return true;
        } else if ("start_time_sentence".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.bb = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "start_time_sentence", graphQLEvent.B_(), 104, false);
            return true;
        } else if ("start_timestamp".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLEvent.bc = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "start_timestamp", graphQLEvent.B_(), 105, false);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLEvent.bd = a13;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "streaming_profile_picture", graphQLEvent.B_(), 106, true);
            return true;
        } else if ("suggested_event_context_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suggested_event_context_sentence"));
            }
            graphQLEvent.be = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "suggested_event_context_sentence", graphQLEvent.B_(), 107, true);
            return true;
        } else if ("supports_event_stories".equals(str)) {
            graphQLEvent.bf = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "supports_event_stories", graphQLEvent.B_(), 108, false);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLEvent.bg = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "taggable_object_profile_picture", graphQLEvent.B_(), 109, true);
            return true;
        } else if ("time_range".equals(str)) {
            GraphQLEventTimeRange a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLEventTimeRange__JsonHelper.m7303a(FieldAccessQueryTracker.a(jsonParser, "time_range"));
            }
            graphQLEvent.bh = a14;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "time_range", graphQLEvent.B_(), 110, true);
            return true;
        } else if ("time_range_sentence".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.bi = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "time_range_sentence", graphQLEvent.B_(), 111, false);
            return true;
        } else if ("timezone".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.bj = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "timezone", graphQLEvent.B_(), 112, false);
            return true;
        } else if ("unread_count".equals(str)) {
            graphQLEvent.bk = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "unread_count", graphQLEvent.B_(), 113, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.bl = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "url", graphQLEvent.B_(), 114, false);
            return true;
        } else if ("username".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLEvent.bm = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "username", graphQLEvent.B_(), 115, false);
            return true;
        } else if ("viewer_guest_status".equals(str)) {
            graphQLEvent.bn = GraphQLEventGuestStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "viewer_guest_status", graphQLEvent.B_(), 116, false);
            return true;
        } else if ("viewer_has_pending_invite".equals(str)) {
            graphQLEvent.bo = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "viewer_has_pending_invite", graphQLEvent.B_(), 117, false);
            return true;
        } else if ("viewer_inviters".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLActor a15 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "viewer_inviters"));
                    if (a15 != null) {
                        r1.add(a15);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLEvent.bp = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "viewer_inviters", graphQLEvent.B_(), 118, true);
            return true;
        } else if ("viewer_notification_subscription_level".equals(str)) {
            graphQLEvent.bq = GraphQLEventNotificationSubscriptionLevel.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "viewer_notification_subscription_level", graphQLEvent.B_(), 119, false);
            return true;
        } else if ("viewer_saved_state".equals(str)) {
            graphQLEvent.br = GraphQLSavedState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "viewer_saved_state", graphQLEvent.B_(), 120, false);
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
            graphQLEvent.bs = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "viewer_timeline_collections_containing", graphQLEvent.B_(), 121, true);
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
            graphQLEvent.bt = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "viewer_timeline_collections_supported", graphQLEvent.B_(), 122, true);
            return true;
        } else if ("viewer_watch_status".equals(str)) {
            graphQLEvent.bu = GraphQLEventWatchStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "viewer_watch_status", graphQLEvent.B_(), 123, false);
            return true;
        } else if ("event_promotion_status".equals(str)) {
            graphQLEvent.bv = GraphQLBoostedPostStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_promotion_status", graphQLEvent.B_(), 124, false);
            return true;
        } else if ("is_official".equals(str)) {
            graphQLEvent.bw = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "is_official", graphQLEvent.B_(), 125, false);
            return true;
        } else if ("scheduled_publish_timestamp".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLEvent.bx = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "scheduled_publish_timestamp", graphQLEvent.B_(), 127, false);
            return true;
        } else if ("can_viewer_purchase_onsite_tickets".equals(str)) {
            graphQLEvent.by = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "can_viewer_purchase_onsite_tickets", graphQLEvent.B_(), 128, false);
            return true;
        } else if (!"event_ticket_provider".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLEventTicketProvider = GraphQLEventTicketProvider__JsonHelper.m7297a(FieldAccessQueryTracker.a(jsonParser, "event_ticket_provider"));
            }
            graphQLEvent.bz = graphQLEventTicketProvider;
            FieldAccessQueryTracker.a(jsonParser, graphQLEvent, "event_ticket_provider", graphQLEvent.B_(), 129, true);
            return true;
        }
    }

    public static void m7345a(JsonGenerator jsonGenerator, GraphQLEvent graphQLEvent, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEvent.j() != null) {
            jsonGenerator.a("action_style", graphQLEvent.j().toString());
        }
        if (graphQLEvent.k() != null) {
            jsonGenerator.a("album");
            GraphQLAlbum__JsonHelper.m6511a(jsonGenerator, graphQLEvent.k(), true);
        }
        if (graphQLEvent.l() != null) {
            jsonGenerator.a("allEventDeclines");
            GraphQLEventDeclinesConnection__JsonHelper.m7170a(jsonGenerator, graphQLEvent.l(), true);
        }
        if (graphQLEvent.m() != null) {
            jsonGenerator.a("allEventMaybes");
            GraphQLEventMaybesConnection__JsonHelper.m7225a(jsonGenerator, graphQLEvent.m(), true);
        }
        if (graphQLEvent.n() != null) {
            jsonGenerator.a("allEventMembers");
            GraphQLEventMembersConnection__JsonHelper.m7246a(jsonGenerator, graphQLEvent.n(), true);
        }
        if (graphQLEvent.o() != null) {
            jsonGenerator.a("attending_activity");
            GraphQLInlineActivity__JsonHelper.m8697a(jsonGenerator, graphQLEvent.o(), true);
        }
        if (graphQLEvent.p() != null) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLEvent.p(), true);
        }
        if (graphQLEvent.q() != null) {
            jsonGenerator.a("boostable_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLEvent.q(), true);
        }
        jsonGenerator.a("can_guests_invite_friends", graphQLEvent.r());
        jsonGenerator.a("can_post_be_moderated", graphQLEvent.s());
        jsonGenerator.a("can_view_members", graphQLEvent.t());
        jsonGenerator.a("can_viewer_change_guest_status", graphQLEvent.u());
        jsonGenerator.a("can_viewer_create_post", graphQLEvent.v());
        jsonGenerator.a("can_viewer_join", graphQLEvent.w());
        jsonGenerator.a("can_viewer_message", graphQLEvent.x());
        jsonGenerator.a("can_viewer_post", graphQLEvent.y());
        if (graphQLEvent.z() != null) {
            jsonGenerator.a("category_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.z(), true);
        }
        if (graphQLEvent.A() != null) {
            jsonGenerator.a("connection_style", graphQLEvent.A().toString());
        }
        if (graphQLEvent.B() != null) {
            jsonGenerator.a("contextual_name", graphQLEvent.B());
        }
        if (graphQLEvent.C() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLEvent.C(), true);
        }
        if (graphQLEvent.D() != null) {
            jsonGenerator.a("created_for_group");
            GraphQLGroup__JsonHelper.m8519a(jsonGenerator, graphQLEvent.D(), true);
        }
        if (graphQLEvent.E() != null) {
            jsonGenerator.a("creation_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLEvent.E(), true);
        }
        jsonGenerator.a("creation_time", graphQLEvent.F());
        jsonGenerator.a("end_timestamp", graphQLEvent.G());
        if (graphQLEvent.H() != null) {
            jsonGenerator.a("eventCategoryLabel");
            GraphQLEventCategoryData__JsonHelper.m7123a(jsonGenerator, graphQLEvent.H(), true);
        }
        if (graphQLEvent.I() != null) {
            jsonGenerator.a("eventProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.I(), true);
        }
        if (graphQLEvent.J() != null) {
            jsonGenerator.a("eventUrl", graphQLEvent.J());
        }
        if (graphQLEvent.K() != null) {
            jsonGenerator.a("event_buy_ticket_display_url", graphQLEvent.K());
        }
        if (graphQLEvent.L() != null) {
            jsonGenerator.a("event_buy_ticket_url", graphQLEvent.L());
        }
        if (graphQLEvent.M() != null) {
            jsonGenerator.a("event_category_info");
            GraphQLEventCategoryData__JsonHelper.m7123a(jsonGenerator, graphQLEvent.M(), true);
        }
        if (graphQLEvent.N() != null) {
            jsonGenerator.a("event_cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLEvent.N(), true);
        }
        if (graphQLEvent.O() != null) {
            jsonGenerator.a("event_creator");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLEvent.O(), true);
        }
        if (graphQLEvent.P() != null) {
            jsonGenerator.a("event_declines");
            GraphQLEventDeclinesConnection__JsonHelper.m7170a(jsonGenerator, graphQLEvent.P(), true);
        }
        if (graphQLEvent.Q() != null) {
            jsonGenerator.a("event_description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEvent.Q(), true);
        }
        if (graphQLEvent.R() != null) {
            jsonGenerator.a("event_hosts");
            GraphQLEventHostsConnection__JsonHelper.m7192a(jsonGenerator, graphQLEvent.R(), true);
        }
        if (graphQLEvent.S() != null) {
            jsonGenerator.a("event_invitees");
            GraphQLEventInviteesConnection__JsonHelper.m7207a(jsonGenerator, graphQLEvent.S(), true);
        }
        if (graphQLEvent.T() != null) {
            jsonGenerator.a("event_kind", graphQLEvent.T().toString());
        }
        if (graphQLEvent.U() != null) {
            jsonGenerator.a("event_maybes");
            GraphQLEventMaybesConnection__JsonHelper.m7225a(jsonGenerator, graphQLEvent.U(), true);
        }
        if (graphQLEvent.V() != null) {
            jsonGenerator.a("event_members");
            GraphQLEventMembersConnection__JsonHelper.m7246a(jsonGenerator, graphQLEvent.V(), true);
        }
        if (graphQLEvent.W() != null) {
            jsonGenerator.a("event_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLEvent.W(), true);
        }
        if (graphQLEvent.X() != null) {
            jsonGenerator.a("event_privacy_type", graphQLEvent.X().toString());
        }
        if (graphQLEvent.Y() != null) {
            jsonGenerator.a("event_ticket_provider_name", graphQLEvent.Y());
        }
        if (graphQLEvent.Z() != null) {
            jsonGenerator.a("event_type", graphQLEvent.Z().toString());
        }
        jsonGenerator.a("event_user_location_shares_count", graphQLEvent.aa());
        jsonGenerator.a("event_user_location_shares_start_interval", graphQLEvent.ab());
        if (graphQLEvent.ac() != null) {
            jsonGenerator.a("event_viewer_capability");
            GraphQLEventViewerCapability__JsonHelper.m7327a(jsonGenerator, graphQLEvent.ac(), true);
        }
        if (graphQLEvent.ad() != null) {
            jsonGenerator.a("event_visibility", graphQLEvent.ad().toString());
        }
        if (graphQLEvent.ae() != null) {
            jsonGenerator.a("event_watchers");
            GraphQLEventWatchersConnection__JsonHelper.m7333a(jsonGenerator, graphQLEvent.ae(), true);
        }
        if (graphQLEvent.af() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.af(), true);
        }
        if (graphQLEvent.ag() != null) {
            jsonGenerator.a("friendEventDeclines");
            GraphQLEventDeclinesConnection__JsonHelper.m7170a(jsonGenerator, graphQLEvent.ag(), true);
        }
        if (graphQLEvent.ah() != null) {
            jsonGenerator.a("friendEventInvitees");
            GraphQLEventInviteesConnection__JsonHelper.m7207a(jsonGenerator, graphQLEvent.ah(), true);
        }
        if (graphQLEvent.ai() != null) {
            jsonGenerator.a("friendEventInviteesFirst5");
            GraphQLEventInviteesConnection__JsonHelper.m7207a(jsonGenerator, graphQLEvent.ai(), true);
        }
        if (graphQLEvent.aj() != null) {
            jsonGenerator.a("friendEventMaybes");
            GraphQLEventMaybesConnection__JsonHelper.m7225a(jsonGenerator, graphQLEvent.aj(), true);
        }
        if (graphQLEvent.ak() != null) {
            jsonGenerator.a("friendEventMaybesFirst5");
            GraphQLEventMaybesConnection__JsonHelper.m7225a(jsonGenerator, graphQLEvent.ak(), true);
        }
        if (graphQLEvent.al() != null) {
            jsonGenerator.a("friendEventMembers");
            GraphQLEventMembersConnection__JsonHelper.m7246a(jsonGenerator, graphQLEvent.al(), true);
        }
        if (graphQLEvent.am() != null) {
            jsonGenerator.a("friendEventMembersFirst5");
            GraphQLEventMembersConnection__JsonHelper.m7246a(jsonGenerator, graphQLEvent.am(), true);
        }
        if (graphQLEvent.an() != null) {
            jsonGenerator.a("friendEventWatchers");
            GraphQLEventWatchersConnection__JsonHelper.m7333a(jsonGenerator, graphQLEvent.an(), true);
        }
        if (graphQLEvent.ao() != null) {
            jsonGenerator.a("friendEventWatchersFirst5");
            GraphQLEventWatchersConnection__JsonHelper.m7333a(jsonGenerator, graphQLEvent.ao(), true);
        }
        if (graphQLEvent.ap() != null) {
            jsonGenerator.a("friends_going");
            GraphQLEventMembersConnection__JsonHelper.m7246a(jsonGenerator, graphQLEvent.ap(), true);
        }
        if (graphQLEvent.aq() != null) {
            jsonGenerator.a("friends_interested");
            GraphQLEventWatchersConnection__JsonHelper.m7333a(jsonGenerator, graphQLEvent.aq(), true);
        }
        if (graphQLEvent.ar() != null) {
            jsonGenerator.a("friends_invited");
            GraphQLEventInviteesConnection__JsonHelper.m7207a(jsonGenerator, graphQLEvent.ar(), true);
        }
        if (graphQLEvent.as() != null) {
            jsonGenerator.a("id", graphQLEvent.as());
        }
        if (graphQLEvent.at() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.at(), true);
        }
        if (graphQLEvent.au() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLEvent.au(), true);
        }
        jsonGenerator.a("is_all_day", graphQLEvent.av());
        jsonGenerator.a("is_canceled", graphQLEvent.aw());
        jsonGenerator.a("is_event_draft", graphQLEvent.ax());
        jsonGenerator.a("is_message_blocked_by_viewer", graphQLEvent.ay());
        jsonGenerator.a("is_privacy_locked", graphQLEvent.az());
        if (graphQLEvent.aA() != null) {
            jsonGenerator.a("live_permalink_time_range_sentence", graphQLEvent.aA());
        }
        if (graphQLEvent.aB() != null) {
            jsonGenerator.a("location");
            GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLEvent.aB(), true);
        }
        if (graphQLEvent.aC() != null) {
            jsonGenerator.a("map_bounding_box");
            GraphQLGeoRectangle__JsonHelper.m7767a(jsonGenerator, graphQLEvent.aC(), true);
        }
        jsonGenerator.a("map_zoom_level", graphQLEvent.aD());
        if (graphQLEvent.aE() != null) {
            jsonGenerator.a("name", graphQLEvent.aE());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLEvent.aF() != null) {
            jsonGenerator.d();
            for (String str : graphQLEvent.aF()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEvent.aG() != null) {
            jsonGenerator.a("open_graph_composer_preview");
            GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLEvent.aG(), true);
        }
        if (graphQLEvent.aH() != null) {
            jsonGenerator.a("otherEventDeclines");
            GraphQLEventDeclinesConnection__JsonHelper.m7170a(jsonGenerator, graphQLEvent.aH(), true);
        }
        if (graphQLEvent.aI() != null) {
            jsonGenerator.a("otherEventInvitees");
            GraphQLEventInviteesConnection__JsonHelper.m7207a(jsonGenerator, graphQLEvent.aI(), true);
        }
        if (graphQLEvent.aJ() != null) {
            jsonGenerator.a("otherEventMaybes");
            GraphQLEventMaybesConnection__JsonHelper.m7225a(jsonGenerator, graphQLEvent.aJ(), true);
        }
        if (graphQLEvent.aK() != null) {
            jsonGenerator.a("otherEventMembers");
            GraphQLEventMembersConnection__JsonHelper.m7246a(jsonGenerator, graphQLEvent.aK(), true);
        }
        if (graphQLEvent.aL() != null) {
            jsonGenerator.a("otherEventWatchers");
            GraphQLEventWatchersConnection__JsonHelper.m7333a(jsonGenerator, graphQLEvent.aL(), true);
        }
        if (graphQLEvent.aM() != null) {
            jsonGenerator.a("parent_group");
            GraphQLGroup__JsonHelper.m8519a(jsonGenerator, graphQLEvent.aM(), true);
        }
        jsonGenerator.a("pending_post_count", graphQLEvent.aN());
        if (graphQLEvent.aO() != null) {
            jsonGenerator.a("placeProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.aO(), true);
        }
        if (graphQLEvent.aP() != null) {
            jsonGenerator.a("place_topic_id", graphQLEvent.aP());
        }
        if (graphQLEvent.aQ() != null) {
            jsonGenerator.a("place_type", graphQLEvent.aQ().toString());
        }
        jsonGenerator.a("post_approval_required", graphQLEvent.aR());
        if (graphQLEvent.aS() != null) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLEvent.aS(), true);
        }
        if (graphQLEvent.aT() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLEvent.aT(), true);
        }
        if (graphQLEvent.aU() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.aU(), true);
        }
        if (graphQLEvent.aV() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.aV(), true);
        }
        if (graphQLEvent.aW() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.aW(), true);
        }
        if (graphQLEvent.aX() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.aX(), true);
        }
        if (graphQLEvent.aY() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.aY(), true);
        }
        if (graphQLEvent.aZ() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLEvent.aZ(), true);
        }
        if (graphQLEvent.ba() != null) {
            jsonGenerator.a("profile_pic_large");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.ba(), true);
        }
        if (graphQLEvent.bb() != null) {
            jsonGenerator.a("profile_pic_medium");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.bb(), true);
        }
        if (graphQLEvent.bc() != null) {
            jsonGenerator.a("profile_pic_small");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.bc(), true);
        }
        if (graphQLEvent.bd() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.bd(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLEvent.be());
        if (graphQLEvent.bf() != null) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLEvent.bf(), true);
        }
        if (graphQLEvent.bg() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEvent.bg(), true);
        }
        if (graphQLEvent.bh() != null) {
            jsonGenerator.a("start_time_sentence", graphQLEvent.bh());
        }
        jsonGenerator.a("start_timestamp", graphQLEvent.bi());
        if (graphQLEvent.bj() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLEvent.bj(), true);
        }
        if (graphQLEvent.bk() != null) {
            jsonGenerator.a("suggested_event_context_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEvent.bk(), true);
        }
        jsonGenerator.a("supports_event_stories", graphQLEvent.bl());
        if (graphQLEvent.bm() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEvent.bm(), true);
        }
        if (graphQLEvent.bn() != null) {
            jsonGenerator.a("time_range");
            GraphQLEventTimeRange__JsonHelper.m7304a(jsonGenerator, graphQLEvent.bn(), true);
        }
        if (graphQLEvent.bo() != null) {
            jsonGenerator.a("time_range_sentence", graphQLEvent.bo());
        }
        if (graphQLEvent.bp() != null) {
            jsonGenerator.a("timezone", graphQLEvent.bp());
        }
        jsonGenerator.a("unread_count", graphQLEvent.bq());
        if (graphQLEvent.br() != null) {
            jsonGenerator.a("url", graphQLEvent.br());
        }
        if (graphQLEvent.bs() != null) {
            jsonGenerator.a("username", graphQLEvent.bs());
        }
        if (graphQLEvent.bt() != null) {
            jsonGenerator.a("viewer_guest_status", graphQLEvent.bt().toString());
        }
        jsonGenerator.a("viewer_has_pending_invite", graphQLEvent.bu());
        jsonGenerator.a("viewer_inviters");
        if (graphQLEvent.bv() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLEvent.bv()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEvent.bw() != null) {
            jsonGenerator.a("viewer_notification_subscription_level", graphQLEvent.bw().toString());
        }
        if (graphQLEvent.bx() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLEvent.bx().toString());
        }
        jsonGenerator.a("viewer_timeline_collections_containing");
        if (graphQLEvent.by() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection : graphQLEvent.by()) {
                if (graphQLTimelineAppCollection != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("viewer_timeline_collections_supported");
        if (graphQLEvent.bz() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection2 : graphQLEvent.bz()) {
                if (graphQLTimelineAppCollection2 != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEvent.bA() != null) {
            jsonGenerator.a("viewer_watch_status", graphQLEvent.bA().toString());
        }
        if (graphQLEvent.bB() != null) {
            jsonGenerator.a("event_promotion_status", graphQLEvent.bB().toString());
        }
        jsonGenerator.a("is_official", graphQLEvent.bC());
        jsonGenerator.a("scheduled_publish_timestamp", graphQLEvent.bD());
        jsonGenerator.a("can_viewer_purchase_onsite_tickets", graphQLEvent.bE());
        if (graphQLEvent.bF() != null) {
            jsonGenerator.a("event_ticket_provider");
            GraphQLEventTicketProvider__JsonHelper.m7298a(jsonGenerator, graphQLEvent.bF(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
