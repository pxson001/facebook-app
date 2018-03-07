package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.content.event.FbEvent;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.widget.soundwave.SoundWaveView;
import com.google.common.base.Preconditions;

/* compiled from: composer_add_location */
public class SoundWavePlugin extends RichVideoPlayerPlugin {
    public SoundWaveView f19380a;

    /* compiled from: composer_add_location */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ SoundWavePlugin f19379a;

        public PlayerStateChangedEventSubscriber(SoundWavePlugin soundWavePlugin) {
            this.f19379a = soundWavePlugin;
        }

        public final void m28154b(FbEvent fbEvent) {
            this.f19379a.m28156a(((RVPPlayerStateChangedEvent) fbEvent).b);
        }

        public final Class<RVPPlayerStateChangedEvent> m28153a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public SoundWavePlugin(Context context) {
        this(context, null);
    }

    public SoundWavePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SoundWavePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907160);
        this.f19380a = (SoundWaveView) a(2131567094);
        this.f.add(new PlayerStateChangedEventSubscriber(this));
    }

    protected final void m28155a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Preconditions.checkNotNull(this.h);
        m28156a(this.h.l);
    }

    protected final void m28157c() {
        this.f19380a.setVisibility(0);
        this.f19380a.m28595b();
    }

    protected void m28156a(State state) {
        if (state == State.PLAYING) {
            this.f19380a.m28594a();
            this.f19380a.setVisibility(0);
            return;
        }
        this.f19380a.setVisibility(8);
        this.f19380a.m28595b();
    }
}
