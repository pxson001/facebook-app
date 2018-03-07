package com.facebook.video.player.events;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;

/* compiled from: payment_request */
public class RVPRequestPlayingEvent extends RichVideoPlayerEvent {
    public final EventTriggerType f5318a;
    public final int f5319b;

    public RVPRequestPlayingEvent(EventTriggerType eventTriggerType) {
        this(eventTriggerType, -1);
    }

    public RVPRequestPlayingEvent(EventTriggerType eventTriggerType, int i) {
        this.f5318a = eventTriggerType;
        this.f5319b = i;
    }

    public String toString() {
        return String.format("%s: %s, lastStartPosition: %d", new Object[]{super.toString(), this.f5318a, Integer.valueOf(this.f5319b)});
    }
}
