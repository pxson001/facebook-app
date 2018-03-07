package com.facebook.video.player.events;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import java.lang.ref.WeakReference;

/* compiled from: deletedStickerPacks */
public abstract class RichVideoPlayerEventSubscriber<T extends RichVideoPlayerEvent> extends FbEventSubscriber<T> {
    private WeakReference<RichVideoPlayerPlugin> f14057a;

    public final boolean m14866a(FbEvent fbEvent) {
        if (this.f14057a == null) {
            return true;
        }
        RichVideoPlayerPlugin richVideoPlayerPlugin = (RichVideoPlayerPlugin) this.f14057a.get();
        return (richVideoPlayerPlugin == null || richVideoPlayerPlugin.f14098j) ? false : true;
    }

    public RichVideoPlayerEventSubscriber(RichVideoPlayerPlugin richVideoPlayerPlugin) {
        this.f14057a = new WeakReference(richVideoPlayerPlugin);
    }
}
