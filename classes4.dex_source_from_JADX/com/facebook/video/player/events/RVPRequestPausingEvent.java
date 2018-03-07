package com.facebook.video.player.events;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;

/* compiled from: decode_body_json */
public class RVPRequestPausingEvent extends RichVideoPlayerEvent {
    public final EventTriggerType f14167a;

    public RVPRequestPausingEvent(EventTriggerType eventTriggerType) {
        this.f14167a = eventTriggerType;
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{super.toString(), this.f14167a});
    }
}
