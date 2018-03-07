package com.facebook.video.player;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoDataSourceInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoPlayerInfo;
import com.facebook.video.analytics.VideoTimeSpentInfo;
import com.facebook.video.engine.VideoDataSource;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: composer_picks_privacy_from_typeahead_filter */
public class FullScreenParams {
    public Uri f19008a;
    private int f19009b;
    private ImageRequest f19010c;
    public ImmutableList<VideoDataSource> f19011d;
    public float f19012e = 0.0f;
    public boolean f19013f = false;
    public int f19014g;
    public int f19015h;
    private final VideoDataSourceInfo f19016i = new VideoDataSourceInfo();
    private final VideoTimeSpentInfo f19017j = new VideoTimeSpentInfo();
    public final VideoPlayerInfo f19018k = new VideoPlayerInfo(PlayerType.FULL_SCREEN_PLAYER);
    public VideoFeedStoryInfo f19019l = new VideoFeedStoryInfo();
    private VideoAnalyticsRequiredInfo f19020m = new VideoAnalyticsRequiredInfo();

    public FullScreenParams(ImmutableList<VideoDataSource> immutableList, int i, VideoAnalyticsRequiredInfo videoAnalyticsRequiredInfo, VideoFeedStoryInfo videoFeedStoryInfo, ImageRequest imageRequest) {
        boolean z = (immutableList == null || immutableList.isEmpty()) ? false : true;
        Preconditions.checkArgument(z);
        this.f19011d = immutableList;
        this.f19008a = ((VideoDataSource) immutableList.get(0)).b;
        this.f19009b = i;
        this.f19010c = imageRequest;
        this.f19019l.b = videoFeedStoryInfo.b;
        this.f19020m = videoAnalyticsRequiredInfo;
        this.f19019l = videoFeedStoryInfo;
    }

    public FullScreenParams(Uri uri, int i, EventTriggerType eventTriggerType, ImageRequest imageRequest) {
        this.f19008a = uri;
        this.f19009b = i;
        this.f19010c = imageRequest;
        this.f19019l.b = eventTriggerType;
    }

    public final int m27712c() {
        if (this.f19015h > 0) {
            return this.f19015h - this.f19014g;
        }
        return this.f19009b;
    }

    public final ImageRequest m27713d() {
        return this.f19010c;
    }

    public final int m27714e() {
        return this.f19017j.c;
    }

    public static EventTriggerType m27709g() {
        return EventTriggerType.BY_USER;
    }

    public final FullScreenParams m27711a(PlayerOrigin playerOrigin) {
        this.f19018k.b = playerOrigin;
        return this;
    }

    public final float m27715h() {
        return this.f19012e;
    }

    public final ArrayNode m27716i() {
        return this.f19019l.a;
    }

    public final boolean m27717l() {
        return this.f19019l.d;
    }

    public final int m27718m() {
        return this.f19017j.b;
    }

    public static StreamSourceType m27710n() {
        return StreamSourceType.FROM_STREAM;
    }

    public final String m27719o() {
        return this.f19020m.a;
    }

    public final VideoDataSourceInfo m27720p() {
        return this.f19016i;
    }

    public final VideoTimeSpentInfo m27721q() {
        return this.f19017j;
    }

    public final VideoAnalyticsRequiredInfo m27722r() {
        return this.f19020m;
    }

    public final VideoPlayerInfo m27723s() {
        return this.f19018k;
    }
}
