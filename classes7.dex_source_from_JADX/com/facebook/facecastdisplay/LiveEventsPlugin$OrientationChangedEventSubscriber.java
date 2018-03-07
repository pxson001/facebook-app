package com.facebook.facecastdisplay;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPOrientationChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: story_attachments_icon_image */
class LiveEventsPlugin$OrientationChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPOrientationChangedEvent> {
    final /* synthetic */ LiveEventsPlugin f2968a;

    public LiveEventsPlugin$OrientationChangedEventSubscriber(LiveEventsPlugin liveEventsPlugin) {
        this.f2968a = liveEventsPlugin;
    }

    public final void m3253b(FbEvent fbEvent) {
        LiveEventsPlugin.c(this.f2968a, ((RVPOrientationChangedEvent) fbEvent).a);
    }

    public final Class<RVPOrientationChangedEvent> m3252a() {
        return RVPOrientationChangedEvent.class;
    }
}
