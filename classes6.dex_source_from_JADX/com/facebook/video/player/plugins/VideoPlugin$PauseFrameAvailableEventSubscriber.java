package com.facebook.video.player.plugins;

import android.graphics.Bitmap;
import com.facebook.content.event.FbEvent;
import com.facebook.video.player.events.RVPPauseFrameAvailableEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: commerce_view_product_collection */
class VideoPlugin$PauseFrameAvailableEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPauseFrameAvailableEvent> {
    final /* synthetic */ VideoPlugin f19423a;

    public VideoPlugin$PauseFrameAvailableEventSubscriber(VideoPlugin videoPlugin) {
        this.f19423a = videoPlugin;
    }

    public final void m28201b(FbEvent fbEvent) {
        RVPPauseFrameAvailableEvent rVPPauseFrameAvailableEvent = (RVPPauseFrameAvailableEvent) fbEvent;
        if (this.f19423a.i != null) {
            Bitmap bitmap = rVPPauseFrameAvailableEvent.f19289a;
            int currentPositionMs = this.f19423a.i.getCurrentPositionMs();
            this.f19423a.l.a(this.f19423a.i.getVideoId(), currentPositionMs, bitmap);
            VideoPlugin.setPauseFrame(this.f19423a, bitmap);
        }
    }

    public final Class<RVPPauseFrameAvailableEvent> m28200a() {
        return RVPPauseFrameAvailableEvent.class;
    }
}
