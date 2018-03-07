package com.facebook.ipc.composer.model;

/* compiled from: TITLE */
public enum ComposerSourceSurface {
    UNKNOWN("unknown"),
    ALBUM("album"),
    COMPOST("compost"),
    EVENT("event"),
    FACEWEB("faceweb"),
    GROUP_FEED("group_feed"),
    NEWSFEED("newsfeed"),
    NOTIFICATIONS("notifications"),
    PAGE_FEED("page_feed"),
    REACTION("reaction"),
    RED_SPACE("red_space"),
    SEARCH("search"),
    THIRD_PARTY_APP_VIA_FB_API("third_party_app_via_fb_api"),
    THIRD_PARTY_APP_VIA_INTENT("third_party_app_via_intent"),
    TIMELINE("timeline"),
    URI_HANDLER("uri_handler"),
    VIDEO_HOME("video_home"),
    WIDGET("widget");
    
    private final String mAnalyticsName;

    private ComposerSourceSurface(String str) {
        this.mAnalyticsName = str;
    }

    public final String getAnalyticsName() {
        return this.mAnalyticsName;
    }
}
