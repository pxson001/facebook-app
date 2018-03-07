package com.facebook.friends.constants;

import java.io.Serializable;
import javax.annotation.Nullable;

/* compiled from: me/newcomer_audience */
public enum FriendRequestMakeRef {
    QR_CODE("qr_code"),
    JEWEL("jewel"),
    PYMK_FEED("pymk_feed"),
    PYMK_JEWEL("pymk_jewel"),
    SEARCH("search"),
    SHORTCUT("shortcut"),
    PROFILE_BROWSER_LIKES("pb_likes"),
    FRIENDING_CARD("friending_card"),
    NEWSFEED("nf"),
    FRIENDS_CENTER("fc_pymk"),
    FRIENDING_RADAR("friending_radar"),
    CI_PYMK("ci_pymk"),
    CONTACT_IMPORTER("friend_finder"),
    NEARBY_FRIENDS("nearby_friends"),
    FRIENDS_TAB("fr_tab"),
    PROFILE_SHARE("profile_share"),
    TIMELINE_FRIENDS_BOX("tl_fr_box");
    
    public final String value;

    private FriendRequestMakeRef(String str) {
        this.value = str;
    }

    @Nullable
    public static FriendRequestMakeRef from(@Nullable Serializable serializable) {
        if (serializable instanceof FriendRequestMakeRef) {
            return (FriendRequestMakeRef) serializable;
        }
        if (serializable instanceof String) {
            for (FriendRequestMakeRef friendRequestMakeRef : values()) {
                if (friendRequestMakeRef.value.equals(serializable)) {
                    return friendRequestMakeRef;
                }
            }
        }
        return null;
    }

    public static boolean isProfileShareMakeRef(@Nullable FriendRequestMakeRef friendRequestMakeRef) {
        return friendRequestMakeRef == PROFILE_SHARE;
    }
}
