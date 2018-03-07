package com.facebook.video.videohome.environment;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: start_stream_upload */
public class VideoHomeHScrollLiveVideosComponentKey implements ContextStateKey<String, VideoHomeHScrollLiveVideosComponentPersistentState> {
    private static final String f2854a = VideoHomeHScrollLiveVideosComponentKey.class.getSimpleName();
    private String f2855b;

    public VideoHomeHScrollLiveVideosComponentKey(String str, long j) {
        this.f2855b = f2854a + str + j;
    }

    public final Object m2767a() {
        return new VideoHomeHScrollLiveVideosComponentPersistentState();
    }

    public final Object m2768b() {
        return this.f2855b;
    }
}
