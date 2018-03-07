package com.facebook.video.player.events;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;

/* compiled from: payment_method */
public class RVPRequestSeekingEvent extends RichVideoPlayerEvent {
    public final EventTriggerType f5320a;
    public final int f5321b;

    public RVPRequestSeekingEvent(int i, EventTriggerType eventTriggerType) {
        this.f5321b = i;
        this.f5320a = eventTriggerType;
    }

    public String toString() {
        return String.format("%s: %s, time: %d", new Object[]{super.toString(), this.f5320a, Integer.valueOf(this.f5321b)});
    }
}
