package com.facebook.feed.ui.fullscreenvideoplayer.commentwithvideo;

import com.facebook.feed.ui.fullscreenvideoplayer.FeedFullScreenVideoPlayer;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.player.RichVideoPlayerParams;

/* compiled from: TimelineLoadProfilePicPreview */
public class VideoFeedbackParams {
    public final String f21973a;
    public final RichVideoPlayerParams f21974b;
    public final int f21975c;
    public final boolean f21976d;
    public final PlayerOrigin f21977e;
    public FeedFullScreenVideoPlayer f21978f;

    public VideoFeedbackParams(String str, RichVideoPlayerParams richVideoPlayerParams, int i, boolean z, PlayerOrigin playerOrigin) {
        this.f21973a = str;
        this.f21974b = richVideoPlayerParams;
        this.f21975c = i;
        this.f21976d = z;
        this.f21977e = playerOrigin;
    }
}
