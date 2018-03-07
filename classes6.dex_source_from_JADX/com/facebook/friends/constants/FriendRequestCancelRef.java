package com.facebook.friends.constants;

/* compiled from: me/nux_wizard_user_state */
public enum FriendRequestCancelRef {
    CONTACT_IMPORTER("friend_finder"),
    ENTITY_CARDS("entity_cards"),
    FEED("feed"),
    FEED_FRIENDABLE_HEADER("feed_friendable_header"),
    FRIEND_LIST_PROFILE("friend_list_profile"),
    FRIENDING_CARD("friending_card"),
    FRIENDING_RADAR("friending_radar"),
    FRIENDS_CENTER_FRIENDS("fc_friends"),
    FRIENDS_CENTER_OUTGOING_REQUESTS_TAB("outgoing_requests"),
    FRIENDS_CENTER_REQUESTS("fc_requests"),
    FRIENDS_CENTER_SEARCH("fc_search"),
    FRIENDS_CENTER_SUGGESTIONS("friend_browser"),
    FRIENDS_TAB("timeline_friends_pagelet"),
    NEARBY_FRIENDS("nearby_friends"),
    PROFILE("profile"),
    PROFILE_BROWSER_EVENTS("profile_browser_events"),
    PROFILE_BROWSER_LIKES("pb_likes"),
    PYMK_SIDESHOW("pymk_sideshow"),
    PYMK_CI("pymk_ci"),
    PYMK_FEED("pymk_feed"),
    PYMK_JEWEL("pymk_jewel"),
    PYMK_NUX("pymk_nux"),
    PYMK_QUICK_PROMOTION("pymk_quick_promotion"),
    QR_CODE("qr_code"),
    SEARCH("search"),
    TIMELINE_FRIENDS_COLLECTION("timeline_friends_collection");
    
    public final String value;

    private FriendRequestCancelRef(String str) {
        this.value = str;
    }
}
