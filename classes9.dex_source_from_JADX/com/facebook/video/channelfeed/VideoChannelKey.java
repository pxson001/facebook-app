package com.facebook.video.channelfeed;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: subscription_id */
public class VideoChannelKey implements ContextStateKey<String, VideoChannelPersistentState> {
    private static final String f2659a = VideoChannelKey.class.getName();
    private final String f2660b;

    public VideoChannelKey(String str) {
        this.f2660b = f2659a + str;
    }

    public final Object m2568a() {
        return new VideoChannelPersistentState();
    }

    public final Object m2569b() {
        return this.f2660b;
    }
}
