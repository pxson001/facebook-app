package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent.State;
import com.facebook.video.player.plugins.VideoPlugin.VideoPluginAlignment;

/* compiled from: playableUri is not a network Url */
public class LiveVideoControlsPlugin<E extends AnyPlayerEnvironment> extends VideoControlsBasePlugin<E> {
    private final View f4488m;
    private final View f4489n;

    public LiveVideoControlsPlugin(Context context) {
        this(context, null);
    }

    private LiveVideoControlsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private LiveVideoControlsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4488m = m14861a(2131563518);
        this.f4489n = m14861a(2131563517);
        this.f14094f.add(new LiveVideoControlPluginExtendTimeSEventSubscriber(this));
        this.f14094f.add(new OrientationChangedEventSubscriber(this));
    }

    protected int getContentView() {
        return 2130905098;
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.mo376a(richVideoPlayerParams, z);
        if (z) {
            this.f4497r = 6000;
            this.f4488m.setVisibility(0);
            this.f4489n.setVisibility(8);
            m4994e(this, getResources().getConfiguration().orientation);
        }
    }

    protected final void mo389c(int i) {
        super.mo389c(i);
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPLiveVideoControlFadeEvent(State.FADE_OUT));
        }
    }

    protected final void mo390d(int i) {
        super.mo390d(i);
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPLiveVideoControlFadeEvent(State.FADE_IN));
        }
    }

    public static void m4994e(LiveVideoControlsPlugin liveVideoControlsPlugin, int i) {
        if (i == 2) {
            liveVideoControlsPlugin.f4499b.setVideoPluginAlignment(VideoPluginAlignment.CENTER);
        } else {
            liveVideoControlsPlugin.f4499b.setVideoPluginAlignment(VideoPluginAlignment.TOP);
        }
    }
}
