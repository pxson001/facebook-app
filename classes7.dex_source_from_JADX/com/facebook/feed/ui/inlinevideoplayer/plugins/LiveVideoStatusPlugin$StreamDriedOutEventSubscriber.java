package com.facebook.feed.ui.inlinevideoplayer.plugins;

import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.player.events.RVPStreamDriedOutEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;

/* compiled from: The ViewPager center page can't be < 0 */
class LiveVideoStatusPlugin$StreamDriedOutEventSubscriber extends RichVideoPlayerEventSubscriber<RVPStreamDriedOutEvent> {
    final /* synthetic */ LiveVideoStatusPlugin f22271a;

    public LiveVideoStatusPlugin$StreamDriedOutEventSubscriber(LiveVideoStatusPlugin liveVideoStatusPlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
        this.f22271a = liveVideoStatusPlugin;
        super(richVideoPlayerPlugin);
    }

    public final void m24911b(FbEvent fbEvent) {
        if (this.f22271a.p.s && !this.f22271a.x) {
            boolean z;
            String str = LiveVideoStatusPlugin.a;
            String str2 = this.f22271a.t;
            if (this.f22271a.u != null) {
                this.f22271a.u.name();
            }
            if (this.f22271a.s.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean.valueOf(z);
            if (this.f22271a.u == GraphQLVideoBroadcastStatus.LIVE) {
                LiveVideoStatusPlugin.m(this.f22271a);
                HandlerDetour.a(this.f22271a.o, this.f22271a.z);
                HandlerDetour.a(this.f22271a.o, this.f22271a.z, -1439187874);
            }
        }
    }

    public final Class<RVPStreamDriedOutEvent> m24910a() {
        return RVPStreamDriedOutEvent.class;
    }
}
