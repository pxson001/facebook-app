package com.facebook.friends.constants;

/* compiled from: me/bulkcontacts */
public enum PeopleYouMayKnowLocation {
    ENTITY_CARDS("entity_cards"),
    FEED("mobile_in_feed"),
    FRIENDS_CENTER("friends_center"),
    JEWEL("mobile_jewel"),
    NUX("nux"),
    QUICK_PROMOTION("quick_promotion"),
    IMMERSIVE("immersive"),
    SELF_PROFILE("self_profile");
    
    public final String value;

    private PeopleYouMayKnowLocation(String str) {
        this.value = str;
    }
}
