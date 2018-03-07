package com.facebook.facecastdisplay;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;

/* compiled from: story_attachments_icon_image */
class LiveEventsPlugin$PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
    final /* synthetic */ LiveEventsPlugin f2969a;

    public LiveEventsPlugin$PlayerStateChangedEventSubscriber(LiveEventsPlugin liveEventsPlugin) {
        this.f2969a = liveEventsPlugin;
    }

    public final void m3255b(FbEvent fbEvent) {
        RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
        if (this.f2969a.o != null && this.f2969a.o.equals(rVPPlayerStateChangedEvent.a)) {
            this.f2969a.d.removeMessages(2);
            if (rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
                this.f2969a.c.m3092b();
                if (this.f2969a.m) {
                    this.f2969a.c.setVisibility(8);
                }
            } else if (rVPPlayerStateChangedEvent.b == State.PLAYING) {
                this.f2969a.d();
            }
        }
    }

    public final Class<RVPPlayerStateChangedEvent> m3254a() {
        return RVPPlayerStateChangedEvent.class;
    }
}
