package com.facebook.video.player.events;

import com.facebook.video.player.plugins.ChromeBehavior;

/* compiled from: pagesAccessTokenPrefetchParams */
public class RVPChromeBehaviorChangeEvent extends RichVideoPlayerEvent {
    public final ChromeBehavior f5392a;

    public RVPChromeBehaviorChangeEvent(ChromeBehavior chromeBehavior) {
        this.f5392a = chromeBehavior;
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{super.toString(), this.f5392a});
    }
}
