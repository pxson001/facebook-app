package com.facebook.facecastdisplay;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: story_attachments_icon_image */
class LiveEventsPlugin$CommercialBreakStateChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPCommercialBreakStateChangeEvent> {
    final /* synthetic */ LiveEventsPlugin f2966a;

    public LiveEventsPlugin$CommercialBreakStateChangeEventSubscriber(LiveEventsPlugin liveEventsPlugin) {
        this.f2966a = liveEventsPlugin;
    }

    public final void m3249b(FbEvent fbEvent) {
        switch (LiveEventsPlugin$1.f2965b[((RVPCommercialBreakStateChangeEvent) fbEvent).a.ordinal()]) {
            case 1:
                this.f2966a.c.m3094d();
                return;
            case 2:
            case 3:
            case 4:
            case 5:
                this.f2966a.c.m3095e();
                return;
            default:
                return;
        }
    }

    public final Class<RVPCommercialBreakStateChangeEvent> m3248a() {
        return RVPCommercialBreakStateChangeEvent.class;
    }
}
