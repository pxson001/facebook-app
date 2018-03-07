package com.facebook.video.player.events;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoResolution;

/* compiled from: pause_upload */
public class RVPRequestSetResolutionEvent extends RichVideoPlayerEvent {
    public final EventTriggerType f5322a;
    public final VideoResolution f5323b;

    public RVPRequestSetResolutionEvent(EventTriggerType eventTriggerType, VideoResolution videoResolution) {
        this.f5322a = eventTriggerType;
        this.f5323b = videoResolution;
    }
}
