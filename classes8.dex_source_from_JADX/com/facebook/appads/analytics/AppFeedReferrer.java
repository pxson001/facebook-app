package com.facebook.appads.analytics;

import javax.annotation.Nullable;

/* compiled from: is_unarchived_client */
public enum AppFeedReferrer {
    APP_DISCOVERY_MENU("app_discovery_menu"),
    BOOKMARK("bookmark"),
    END_OF_HSCROLL("end_of_hscroll"),
    REACTION("reaction"),
    RETURN_FROM_APP_STORE("return_from_app_store"),
    SECONDARY_ACTIONS_MENU("secondary_actions_menu"),
    UFI_SEE_MORE("ufi_see_more"),
    UNKNOWN("unknown"),
    URL_SEGUE("url_segue");
    
    private final String mEventName;

    private AppFeedReferrer(String str) {
        this.mEventName = str;
    }

    public final String getEventName() {
        return this.mEventName;
    }

    @Nullable
    public static AppFeedReferrer fromString(String str) {
        for (AppFeedReferrer appFeedReferrer : values()) {
            if (appFeedReferrer.getEventName().equalsIgnoreCase(str)) {
                return appFeedReferrer;
            }
        }
        return null;
    }
}
