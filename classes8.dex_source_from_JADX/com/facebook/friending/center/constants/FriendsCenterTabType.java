package com.facebook.friending.center.constants;

/* compiled from: fontSize */
public enum FriendsCenterTabType {
    SUGGESTIONS(2131239323, "friends_center_suggestions_tab"),
    SEARCH(2131239324, "friends_center_search_tab"),
    REQUESTS(2131239325, "friends_center_requests_tab"),
    CONTACTS(2131239326, "friends_center_contacts_tab"),
    INVITES(2131239327, "friends_center_invites_tab"),
    FRIENDS(2131239330, "friends_center_friends_tab");
    
    public final String analyticsTag;
    public final int titleResId;

    private FriendsCenterTabType(int i, String str) {
        this.titleResId = i;
        this.analyticsTag = str;
    }

    public static FriendsCenterTabType fromString(String str) {
        for (FriendsCenterTabType friendsCenterTabType : values()) {
            if (friendsCenterTabType.name().equalsIgnoreCase(str)) {
                return friendsCenterTabType;
            }
        }
        return SUGGESTIONS;
    }
}
