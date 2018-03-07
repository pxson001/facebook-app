package com.facebook.ipc.katana.findfriends;

import java.io.Serializable;

/* compiled from: launch_logging_params */
public enum CIFlow {
    NEWS_FEED_FIND_FRIENDS("NEWS_FEED_FIND_FRIENDS"),
    NEWS_FEED_MEGAPHONE("NEWS_FEED_MEGAPHONE"),
    NEWS_FEED_PYMI("NEWS_FEED_PYMI"),
    NEWS_FEED_PYMK("NEWS_FEED_PYMK"),
    FRIENDS_TAB("FRIENDS_TAB"),
    FRIEND_BROWSER("FRIEND_BROWSER"),
    NEW_ACCOUNT_NUX("NEW_ACCOUNT_NUX"),
    INTERSTITIAL("INTERSTITIAL"),
    BOOKMARKS("BOOKMARKS"),
    SEARCH_BOX("SEARCH_BOX"),
    FRIEND_REQUEST_TAB("FRIEND_REQUEST_TAB"),
    FRIENDS_CENTER("FRIENDS_CENTER"),
    CONTINUOUS_SYNC("CONTINUOUS_SYNC"),
    IORG_INCENTIVE_INVITE("IORG_INCENTIVE_INVITE"),
    UNKNOWN("UNKNOWN");
    
    public final String value;

    private CIFlow(String str) {
        this.value = str;
    }

    public static CIFlow fromString(String str) {
        for (CIFlow cIFlow : values()) {
            if (cIFlow.value.equalsIgnoreCase(str)) {
                return cIFlow;
            }
        }
        return UNKNOWN;
    }

    public static CIFlow fromSerializable(Serializable serializable) {
        if (serializable == null) {
            return UNKNOWN;
        }
        if (serializable instanceof CIFlow) {
            return (CIFlow) serializable;
        }
        if (serializable instanceof String) {
            return fromString((String) serializable);
        }
        return UNKNOWN;
    }
}
