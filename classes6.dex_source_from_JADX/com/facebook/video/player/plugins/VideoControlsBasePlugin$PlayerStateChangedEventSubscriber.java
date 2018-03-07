package com.facebook.video.player.plugins;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;

/* compiled from: commerce_view_product_details */
class VideoControlsBasePlugin$PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
    final /* synthetic */ VideoControlsBasePlugin f19421a;

    public VideoControlsBasePlugin$PlayerStateChangedEventSubscriber(VideoControlsBasePlugin videoControlsBasePlugin) {
        this.f19421a = videoControlsBasePlugin;
    }

    public final void m28199b(FbEvent fbEvent) {
        RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
        if (!this.f19421a.p && rVPPlayerStateChangedEvent.b == State.ATTEMPT_TO_PLAY) {
            this.f19421a.p = true;
        }
        if (this.f19421a.q != ChromeBehavior.AUTO) {
            return;
        }
        if (rVPPlayerStateChangedEvent.b == State.PAUSED || rVPPlayerStateChangedEvent.b == State.SEEKING) {
            this.f19421a.o.removeMessages(1);
        } else if (rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
            VideoControlsBasePlugin.l(this.f19421a);
        } else if (this.f19421a.p) {
            this.f19421a.e();
        }
    }

    public final Class<RVPPlayerStateChangedEvent> m28198a() {
        return RVPPlayerStateChangedEvent.class;
    }
}
