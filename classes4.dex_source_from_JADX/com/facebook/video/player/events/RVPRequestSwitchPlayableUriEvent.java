package com.facebook.video.player.events;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoPlayer.VideoSourceType;
import javax.annotation.Nullable;

/* compiled from: pause */
public class RVPRequestSwitchPlayableUriEvent extends RichVideoPlayerEvent {
    @Nullable
    public final String f5324a;
    public final EventTriggerType f5325b;
    public final VideoSourceType f5326c;
    public final String f5327d;

    public RVPRequestSwitchPlayableUriEvent(@Nullable String str, EventTriggerType eventTriggerType, VideoSourceType videoSourceType, @Nullable String str2) {
        this.f5324a = str;
        this.f5325b = eventTriggerType;
        this.f5326c = videoSourceType;
        this.f5327d = str2;
    }
}
