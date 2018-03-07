package com.facebook.video.server.prefetcher;

/* compiled from: offline_post_expired */
public enum VideoPrefetchLocation {
    COMMERCIAL_BREAK(6),
    INSTANT_ARTICLE(5),
    CHANNEL(4),
    VIDEO_HOME(3),
    TIMELINE(2),
    MISC(1),
    NEWSFEED(0);
    
    public final int priority;

    private VideoPrefetchLocation(int i) {
        this.priority = i;
    }
}
