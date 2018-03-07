package com.facebook.saved.analytics;

import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: setExternalRefName */
public enum SaveAnalyticsLogger$Referer {
    MOBILE_STORY_SAVE_BUTTON_FLYOUT(23),
    MOBILE_NETEGO_SAVE_BUTTON_FLYOUT(24),
    MOBILE_PAGE_SAVE_BUTTON_FLYOUT(25),
    MOBILE_NETEGO_SEE_ALL_LINK(26),
    MOBILE_PAGE_TOAST_LINK(27),
    MOBILE_SAVED_BOOKMARK(29),
    SAVED_TOAST_RECENT_ITEM_COUNT(53);
    
    private final int mRefererId;

    private SaveAnalyticsLogger$Referer(int i) {
        this.mRefererId = i;
    }

    public final String toString() {
        return String.valueOf(this.mRefererId);
    }

    public static Optional<SaveAnalyticsLogger$Referer> fromString(String str) {
        for (SaveAnalyticsLogger$Referer saveAnalyticsLogger$Referer : values()) {
            if (saveAnalyticsLogger$Referer.toString().equals(str)) {
                return Optional.of(saveAnalyticsLogger$Referer);
            }
        }
        return Absent.INSTANCE;
    }
}
