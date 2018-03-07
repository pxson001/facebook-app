package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pymks_email */
public final class FriendRequestCancelInputData extends GraphQlMutationCallInput {

    /* compiled from: pymks_email */
    public enum Source implements JsonSerializable {
        UNKNOWN("unknown"),
        NONE("none"),
        HC_FRIEND_BROWSER("hc_friend_browser"),
        HC_FRIENDS_TAB("hc_friends_tab"),
        HC_PROFILE_BROWSER("hc_profile_browser"),
        HC_STREAM("hc_stream"),
        HC_TIMELINE("hc_timeline"),
        HC_UFI("hc_ufi"),
        HC_REMINDER_POKE("hc_reminder_poke"),
        HC_REMINDER_BIRTHDAY("hc_reminder_birthday"),
        HC_EVENT_GUEST("hc_event_guest"),
        HC_UNKNOWN("hc_unknown"),
        HC_NUX_PAGE_SUGGESTION("hc_nux_page_suggestion"),
        ACTIVITY_LOG("activity_log"),
        API("api"),
        CONTACTS_PEOPLE("contacts_people"),
        ENTITY_CARDS("entity_cards"),
        FEED("feed"),
        FEED_FRIENDABLE_HEADER("feed_friendable_header"),
        FRIEND_BROWSER("friend_browser"),
        FC_FRIENDS("fc_friends"),
        FC_REQUESTS("fc_requests"),
        FC_SEARCH("fc_search"),
        FRIEND_LIST_PROFILE("friend_list_profile"),
        FRIENDING_CARD("friending_card"),
        FRIENDING_RADAR("friending_radar"),
        NEARBY_FRIENDS("nearby_friends"),
        OUTGOING_REQUESTS("outgoing_requests"),
        PROFILE("profile"),
        PROFILE_BROWSER("profile_browser"),
        PROFILE_BROWSER_EVENTS("profile_browser_events"),
        PB_LIKES("pb_likes"),
        PROFILE_CONN_REMOVE("profile_conn_remove"),
        PYMK("pymk"),
        PYMK_FEED("pymk_feed"),
        PYMK_JEWEL("pymk_jewel"),
        PYMK_NUX("pymk_nux"),
        PYMK_QUICK_PROMOTION("pymk_quick_promotion"),
        PYMK_CI("pymk_ci"),
        PYMK_SIDESHOW("pymk_sideshow"),
        QR_CODE("qr_code"),
        SEARCH("search"),
        SI_CANCEL_ALL("si_cancel_all"),
        SHORTCUT("shortcut"),
        TEST("test"),
        TIMELINE_FRIENDS_PAGELET("timeline_friends_pagelet"),
        TIMELINE_FRIENDS_COLLECTION("timeline_friends_collection"),
        FRIEND_FINDER("friend_finder"),
        PROFILE_GEAR("profile_gear"),
        DISCOVER_FEED("discover_feed");
        
        protected final String serverValue;

        private Source(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }
}
