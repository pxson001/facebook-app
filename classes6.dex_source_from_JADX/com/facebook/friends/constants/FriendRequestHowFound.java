package com.facebook.friends.constants;

/* compiled from: me/notify_me */
public enum FriendRequestHowFound {
    CI_PYMK("ci_pymk"),
    CONTACT_IMPORTER("friend_finder"),
    ENTITY_CARDS("entity_cards"),
    FEED_FRIENDABLE_HEADER("feed_friendable_header"),
    FRIENDING_CARD("friending_card"),
    FRIENDING_RADAR("friending_radar"),
    FRIENDS_CENTER_FRIENDS("friend_center_friends"),
    FRIENDS_CENTER_OUTGOING_REQUESTS_TAB("friend_center_outgoing_req"),
    FRIENDS_CENTER_REQUESTS("friend_center_requests"),
    FRIENDS_CENTER_SEARCH("friend_center_search"),
    FRIENDS_CENTER_SUGGESTIONS("friend_browser"),
    FRIENDS_TAB("timeline_friends_pagelet"),
    NEARBY_FRIENDS("nearby_friends"),
    NETEGO_PYMK("netego_pymk"),
    NEWSFEED("newsfeed"),
    PROFILE_BROWSER("profile_browser"),
    PROFILE_BROWSER_EVENTS("profile_browser_events"),
    PROFILE_BUTTON("profile_button"),
    PROFILE_FRIENDS_BOX("friends_box"),
    PYMK("people_you_may_know"),
    PYMK_SIDESHOW("pymk_sideshow"),
    PYMK_NUX("wizard_importers"),
    SEARCH("search"),
    SUGGESTION("friend_suggestion"),
    TIMELINE_FRIENDS_COLLECTION("timeline_friends_collection");
    
    public final String value;

    private FriendRequestHowFound(String str) {
        this.value = str;
    }
}
