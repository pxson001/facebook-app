package com.facebook.video.player.plugins;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPLiveVideoControlChangeHideTimeEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: composer_add_location_failure */
class C1444xaffb7303 extends RichVideoPlayerEventSubscriber<RVPLiveVideoControlChangeHideTimeEvent> {
    final /* synthetic */ LiveVideoControlsPlugin f19356a;

    public C1444xaffb7303(LiveVideoControlsPlugin liveVideoControlsPlugin) {
        this.f19356a = liveVideoControlsPlugin;
    }

    public final void m28132b(FbEvent fbEvent) {
        switch (LiveVideoControlsPlugin$1.f19355a[((RVPLiveVideoControlChangeHideTimeEvent) fbEvent).f19286a.ordinal()]) {
            case 1:
                this.f19356a.f();
                return;
            case 2:
                this.f19356a.e();
                return;
            default:
                return;
        }
    }

    public final Class<RVPLiveVideoControlChangeHideTimeEvent> m28131a() {
        return RVPLiveVideoControlChangeHideTimeEvent.class;
    }
}
