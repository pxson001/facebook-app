package com.facebook.video.player;

import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerParams;
import com.google.common.collect.ImmutableMap;

/* compiled from: composer_post_retry */
public interface BaseInlineVideoPlayer extends VideoSubtitlesListener {
    void mo1451a(int i, int i2);

    void mo1452a(int i, String str);

    void mo1453a(EventTriggerType eventTriggerType, VideoMediaState videoMediaState);

    void mo1454a(VideoPlayerParams videoPlayerParams, ImmutableMap<String, ? extends Object> immutableMap);

    void mo1455a(String str, String str2, String str3);

    void mo1456a(boolean z, EventTriggerType eventTriggerType);

    boolean mo1457a();

    boolean mo1458b();

    void mo1459c();

    boolean callOnClick();

    void mo1461d();

    void mo1462e();

    void mo1463f();

    void mo1464g();

    FbDraweeView getCoverImage();

    int getCurrentPosition();

    InlineVideoView getInlineVideoView();

    int getLastStartPosition();

    LayoutParams getLayoutParams();

    void mo1469h();

    void setAlwaysPlayVideoUnmuted(boolean z);

    void setBackgroundResource(int i);

    void setChannelEligibility(ChannelEligibility channelEligibility);

    void setEndScreenVideoPlayerListener(OnClickListener onClickListener);

    void setIsVideoCompleted(boolean z);

    void setLayoutParams(LayoutParams layoutParams);

    void setOnClickPlayerListener(OnClickListener onClickListener);

    void setOriginalPlayReason(EventTriggerType eventTriggerType);

    void setPauseMediaPlayerOnVideoPause(boolean z);

    void setPlayerOrigin(PlayerOrigin playerOrigin);

    void setVideoListener(VideoPlayerListener videoPlayerListener);
}
