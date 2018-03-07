package com.facebook.video.player.plugins;

import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPOrientationChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: composer_add_location_failure */
class LiveVideoControlsPlugin$OrientationChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPOrientationChangedEvent> {
    final /* synthetic */ LiveVideoControlsPlugin f19357a;

    public LiveVideoControlsPlugin$OrientationChangedEventSubscriber(LiveVideoControlsPlugin liveVideoControlsPlugin) {
        this.f19357a = liveVideoControlsPlugin;
    }

    public final void m28134b(FbEvent fbEvent) {
        LiveVideoControlsPlugin.e(this.f19357a, ((RVPOrientationChangedEvent) fbEvent).f19288a);
    }

    public final Class<RVPOrientationChangedEvent> m28133a() {
        return RVPOrientationChangedEvent.class;
    }
}
