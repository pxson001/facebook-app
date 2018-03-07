package com.facebook.feed.analytics;

/* compiled from: id must not be null */
public enum StoryRenderContext {
    NEWSFEED("native_newsfeed"),
    PERMALINK("native_permalink"),
    REACTION("reaction_dialog"),
    CHANNEL_VIDEO_PLAYER("video_channel_player"),
    FULLSCREEN_VIDEO_PLAYER("video_fullscreen_player"),
    VIDEO_HOME("video_home"),
    VIDEO_CHANNEL("video_channel_feed"),
    TIMELINE("native_timeline"),
    PAGE("pages_public_view"),
    EVENT("event_feed"),
    GROUP("group_feed"),
    SEARCH("search"),
    GOODWILL_THROWBACK("goodwill_throwback"),
    PHOTOS_FEED("photos_feed"),
    REDSPACE("redspace"),
    UNKNOWN("unknown");
    
    public final String analyticModule;

    private StoryRenderContext(String str) {
        this.analyticModule = str;
    }
}
