package com.facebook.feed.ui.inlinevideoplayer.plugins;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;

/* compiled from: The ViewPager center page can't be < 0 */
class LiveVideoStatusPlugin$StateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
    final /* synthetic */ LiveVideoStatusPlugin f22270a;

    public final void m24909b(FbEvent fbEvent) {
        String str;
        boolean z;
        RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
        String str2 = LiveVideoStatusPlugin.a;
        Object[] objArr = new Object[5];
        objArr[0] = rVPPlayerStateChangedEvent.b;
        objArr[1] = this.f22270a.t;
        if (this.f22270a.u == null) {
            str = "null";
        } else {
            str = this.f22270a.u.name();
        }
        objArr[2] = str;
        objArr[3] = this.f22270a.s.getParent();
        if (this.f22270a.s.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        objArr[4] = Boolean.valueOf(z);
        LiveVideoStatusPlugin.b(this.f22270a, rVPPlayerStateChangedEvent.b);
    }

    public LiveVideoStatusPlugin$StateChangedEventSubscriber(LiveVideoStatusPlugin liveVideoStatusPlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
        this.f22270a = liveVideoStatusPlugin;
        super(richVideoPlayerPlugin);
    }

    public final Class<RVPPlayerStateChangedEvent> m24908a() {
        return RVPPlayerStateChangedEvent.class;
    }
}
