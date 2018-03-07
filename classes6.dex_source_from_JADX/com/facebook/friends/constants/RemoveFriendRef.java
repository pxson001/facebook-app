package com.facebook.friends.constants;

/* compiled from: me/blacklisted_pysf_users */
public enum RemoveFriendRef {
    ENTITY_CARDS("entity_cards"),
    FRIENDS_TAB("bd_friends_tab"),
    FRIENDING_RADAR("friending_radar"),
    FRIENDS_CENTER_FRIENDS("bd_fc_friends"),
    FRIENDS_CENTER_REQUESTS("button_dropdown"),
    FRIENDS_CENTER_REQUESTS_PYMK("bd_fc_requests"),
    FRIENDS_CENTER_SEARCH("bd_fc_search"),
    FRIENDS_CENTER_SUGGESTIONS("bd_fc_suggestions"),
    NEARBY_FRIENDS("nearby_friends"),
    PROFILE_BUTTON("bd_profile_button"),
    PROFILE_BROWSER("bd_profile_browser"),
    PYMK_FEED("pymk_feed"),
    QR_CODE("qr_code"),
    TIMELINE_FRIENDS_COLLECTION("timeline_friends_collection");
    
    public final String value;

    private RemoveFriendRef(String str) {
        this.value = str;
    }
}
