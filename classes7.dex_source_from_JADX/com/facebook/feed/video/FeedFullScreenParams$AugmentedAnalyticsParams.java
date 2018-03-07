package com.facebook.feed.video;

import com.facebook.video.analytics.VideoPlaybackAnalyticsParams;
import com.facebook.video.engine.VideoPlayerParams;

/* compiled from: TPAY */
public class FeedFullScreenParams$AugmentedAnalyticsParams implements VideoPlaybackAnalyticsParams {
    private FeedFullScreenParams f22510a;
    private VideoPlayerParams f22511b;

    public FeedFullScreenParams$AugmentedAnalyticsParams(FeedFullScreenParams feedFullScreenParams, VideoPlayerParams videoPlayerParams) {
        this.f22510a = feedFullScreenParams;
        this.f22511b = videoPlayerParams;
    }

    public final boolean m25217a() {
        return this.f22511b != null && this.f22511b.a();
    }

    public final boolean m25218b() {
        return this.f22510a.b();
    }

    public final String m25219c() {
        return this.f22510a.c();
    }
}
