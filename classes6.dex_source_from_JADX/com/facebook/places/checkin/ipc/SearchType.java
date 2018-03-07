package com.facebook.places.checkin.ipc;

import java.util.Locale;

/* compiled from: frames_overlayitem_list */
public enum SearchType {
    CHECKIN,
    EVENT,
    PHOTO,
    STATUS,
    VIDEO,
    ALBUM_CREATOR,
    GALLERY,
    HIDE_GEOHUBS,
    LIGHTWEIGHT_PLACE_PICKER,
    PLACE_TIPS_APP,
    PLACE_TIPS_EMPLOYEE_SETTINGS,
    SOCIAL_SEARCH_COMMENT,
    SOCIAL_SEARCH_CONVERSION,
    FORSALE_POST;

    public final String toLegacyString() {
        return "mobile_" + toString().toLowerCase(Locale.US);
    }

    public final boolean isSocialSearchType() {
        return this == SOCIAL_SEARCH_COMMENT || this == SOCIAL_SEARCH_CONVERSION;
    }
}
