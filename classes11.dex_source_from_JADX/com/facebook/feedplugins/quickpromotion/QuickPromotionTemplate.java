package com.facebook.feedplugins.quickpromotion;

import java.util.Locale;

/* compiled from: carrier_manager_impression */
public enum QuickPromotionTemplate {
    NEWSFEED,
    NEWSFEED_BRANDED_VIDEO,
    NEWSFEED_LARGE_IMAGE,
    UNKNOWN;

    public static QuickPromotionTemplate fromString(String str) {
        if (str != null) {
            return valueOf(str.toUpperCase(Locale.US));
        }
        try {
            return UNKNOWN;
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
