package com.facebook.friends.constants;

/* compiled from: me/inline_privacy_survey_events */
public enum FriendRequestResponseRef {
    ENTITY_CARDS("entity_cards"),
    FEED_FRIENDABLE_HEADER("feed_friendable_header"),
    FRIEND_LIST_PROFILE("friend_list_profile"),
    FRIENDING_CARD("friending_card"),
    FRIENDING_RADAR("friending_radar"),
    FRIENDS_CENTER_FRIENDS("friends_center_friends"),
    FRIENDS_CENTER_REQUESTS("m_find_friends"),
    FRIENDS_CENTER_SEARCH("friends_center_search"),
    FRIENDS_TAB("friends_tab"),
    MOBILE_JEWEL("m_jewel"),
    NEARBY_FRIENDS("nearby_friends"),
    NUX("/gettingstarted.php"),
    PROFILE("/profile.php"),
    PROFILE_BROWSER("profile_browser"),
    PROFILE_BROWSER_EVENTS("profile_browser_events"),
    PYMK_FEED("pymk_feed"),
    QR_CODE("qr_code"),
    QUICK_PROMOTION("quick_promotion"),
    SEARCH("search");
    
    public final String value;

    private FriendRequestResponseRef(String str) {
        this.value = str;
    }
}
