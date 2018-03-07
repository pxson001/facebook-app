package com.facebook.facecastdisplay;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: story_attachments_icon_image */
class LiveEventsPlugin$LiveVideoControlFadeSubscriber extends RichVideoPlayerEventSubscriber<RVPLiveVideoControlFadeEvent> {
    final /* synthetic */ LiveEventsPlugin f2967a;

    public LiveEventsPlugin$LiveVideoControlFadeSubscriber(LiveEventsPlugin liveEventsPlugin) {
        this.f2967a = liveEventsPlugin;
    }

    public final void m3251b(FbEvent fbEvent) {
        switch (LiveEventsPlugin$1.f2964a[((RVPLiveVideoControlFadeEvent) fbEvent).a.ordinal()]) {
            case 1:
                this.f2967a.c.m3091a(true);
                return;
            case 2:
                this.f2967a.c.m3091a(false);
                return;
            default:
                return;
        }
    }

    public final Class<RVPLiveVideoControlFadeEvent> m3250a() {
        return RVPLiveVideoControlFadeEvent.class;
    }
}
