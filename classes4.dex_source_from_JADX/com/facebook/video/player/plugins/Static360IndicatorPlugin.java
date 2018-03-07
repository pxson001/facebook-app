package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.base.Preconditions;

@DoNotStrip
/* compiled from: pic_hash */
public class Static360IndicatorPlugin extends RichVideoPlayerPlugin {
    public View f4772a;

    /* compiled from: pic_hash */
    public class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ Static360IndicatorPlugin f4773a;

        public PlayerStateChangedEventSubscriber(Static360IndicatorPlugin static360IndicatorPlugin) {
            this.f4773a = static360IndicatorPlugin;
        }

        public final void m5231b(FbEvent fbEvent) {
            Static360IndicatorPlugin.m5227a(this.f4773a, ((RVPPlayerStateChangedEvent) fbEvent).f14079b);
        }

        public final Class<RVPPlayerStateChangedEvent> m5230a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    @DoNotStrip
    public Static360IndicatorPlugin(Context context) {
        this(context, null);
    }

    private Static360IndicatorPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Static360IndicatorPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907226);
        this.f4772a = m14861a(2131567636);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
    }

    public static void m5227a(Static360IndicatorPlugin static360IndicatorPlugin, State state) {
        if (state.isPlayingState()) {
            static360IndicatorPlugin.f4772a.setVisibility(8);
        } else {
            static360IndicatorPlugin.f4772a.setVisibility(0);
        }
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Preconditions.checkNotNull(this.f14096h);
        m5227a(this, this.f14096h.f5115l);
    }

    protected final void mo378c() {
        this.f4772a.setVisibility(8);
    }
}
