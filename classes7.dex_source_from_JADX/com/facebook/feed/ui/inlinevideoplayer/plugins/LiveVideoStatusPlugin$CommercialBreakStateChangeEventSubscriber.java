package com.facebook.feed.ui.inlinevideoplayer.plugins;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: The ViewPager center page can't be < 0 */
class LiveVideoStatusPlugin$CommercialBreakStateChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPCommercialBreakStateChangeEvent> {
    final /* synthetic */ LiveVideoStatusPlugin f22269a;

    public LiveVideoStatusPlugin$CommercialBreakStateChangeEventSubscriber(LiveVideoStatusPlugin liveVideoStatusPlugin) {
        this.f22269a = liveVideoStatusPlugin;
    }

    public final void m24907b(FbEvent fbEvent) {
        boolean z;
        RVPCommercialBreakStateChangeEvent rVPCommercialBreakStateChangeEvent = (RVPCommercialBreakStateChangeEvent) fbEvent;
        LiveVideoStatusPlugin liveVideoStatusPlugin = this.f22269a;
        if (rVPCommercialBreakStateChangeEvent.a != State.LIVE) {
            z = true;
        } else {
            z = false;
        }
        liveVideoStatusPlugin.x = z;
        LiveVideoStatusPlugin liveVideoStatusPlugin2 = this.f22269a;
        if (rVPCommercialBreakStateChangeEvent.a != State.LIVE) {
            liveVideoStatusPlugin2.b.setVisibility(8);
            liveVideoStatusPlugin2.d.setVisibility(8);
        }
        this.f22269a.a(rVPCommercialBreakStateChangeEvent.a);
    }

    public final Class<RVPCommercialBreakStateChangeEvent> m24906a() {
        return RVPCommercialBreakStateChangeEvent.class;
    }
}
