package com.facebook.video.commercialbreak.plugins;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPCommercialBreakPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: location_trigger */
class C1027x623c8445 extends RichVideoPlayerEventSubscriber<RVPCommercialBreakPlayerStateChangedEvent> {
    final /* synthetic */ CommercialBreakPlugin f9755a;

    public C1027x623c8445(CommercialBreakPlugin commercialBreakPlugin) {
        this.f9755a = commercialBreakPlugin;
    }

    public final void m11446b(FbEvent fbEvent) {
        switch (CommercialBreakPlugin$2.f9753c[((RVPCommercialBreakPlayerStateChangedEvent) fbEvent).a.ordinal()]) {
            case 1:
                if (this.f9755a.A != null) {
                    this.f9755a.l.a(this.f9755a.A);
                }
                this.f9755a.A = null;
                return;
            case 2:
                String str = CommercialBreakPlugin.q;
                this.f9755a.t.sendEmptyMessage(4);
                return;
            case 3:
                CommercialBreakPlugin.b(this.f9755a, 0);
                this.f9755a.p.a(CommercialBreakPlugin.q, "Commercial break RVP playback error");
                return;
            default:
                return;
        }
    }

    public final Class<RVPCommercialBreakPlayerStateChangedEvent> m11445a() {
        return RVPCommercialBreakPlayerStateChangedEvent.class;
    }
}
