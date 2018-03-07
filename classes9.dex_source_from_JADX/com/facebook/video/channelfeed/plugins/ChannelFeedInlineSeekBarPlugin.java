package com.facebook.video.channelfeed.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.SeekBarBasePlugin;

/* compiled from: stream _id */
public class ChannelFeedInlineSeekBarPlugin extends SeekBarBasePlugin {
    public final View f2724l;

    /* compiled from: stream _id */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ ChannelFeedInlineSeekBarPlugin f2723a;

        public PlayerStateChangedEventSubscriber(ChannelFeedInlineSeekBarPlugin channelFeedInlineSeekBarPlugin) {
            this.f2723a = channelFeedInlineSeekBarPlugin;
        }

        public final void m2613b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (rVPPlayerStateChangedEvent.b.isPlayingState()) {
                this.f2723a.f2724l.setVisibility(0);
            } else if (rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
                this.f2723a.f2724l.setVisibility(4);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m2612a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public ChannelFeedInlineSeekBarPlugin(Context context) {
        this(context, null);
    }

    public ChannelFeedInlineSeekBarPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChannelFeedInlineSeekBarPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f.add(new PlayerStateChangedEventSubscriber(this));
        this.f2724l = a(2131560279);
    }

    protected final void m2615a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        if (z) {
            this.f2724l.setVisibility(4);
        }
    }

    protected int getContentView() {
        return 2130903539;
    }

    protected int getActiveThumbResource() {
        return 0;
    }
}
