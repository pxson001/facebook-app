package com.facebook.video.player.plugins;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPChromeBehaviorChangeEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;

/* compiled from: commerce_view_product_details */
class VideoControlsBasePlugin$ChromeStateEventSubscriber extends RichVideoPlayerEventSubscriber<RVPChromeBehaviorChangeEvent> {
    final /* synthetic */ VideoControlsBasePlugin f19419a;

    public VideoControlsBasePlugin$ChromeStateEventSubscriber(VideoControlsBasePlugin videoControlsBasePlugin) {
        this.f19419a = videoControlsBasePlugin;
    }

    public final void m28197b(FbEvent fbEvent) {
        RVPChromeBehaviorChangeEvent rVPChromeBehaviorChangeEvent = (RVPChromeBehaviorChangeEvent) fbEvent;
        this.f19419a.q = rVPChromeBehaviorChangeEvent.a;
        if (this.f19419a.q == ChromeBehavior.AUTO) {
            State state;
            if (this.f19419a.h != null) {
                state = this.f19419a.h.l;
            } else {
                state = State.UNPREPARED;
            }
            if (this.f19419a.d && r0.isPlayingState()) {
                this.f19419a.o.sendEmptyMessageDelayed(2, 400);
            }
        } else if (this.f19419a.q == ChromeBehavior.ALWAYS_HIDDEN) {
            this.f19419a.o.removeMessages(1);
            this.f19419a.c(0);
        } else if (this.f19419a.q == ChromeBehavior.ALWAYS_VISIBLE) {
            this.f19419a.o.removeMessages(1);
            this.f19419a.d(0);
        }
    }

    public final Class<RVPChromeBehaviorChangeEvent> m28196a() {
        return RVPChromeBehaviorChangeEvent.class;
    }
}
