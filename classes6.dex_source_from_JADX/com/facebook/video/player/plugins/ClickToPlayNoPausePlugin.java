package com.facebook.video.player.plugins;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.content.event.FbEvent;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: composer_attach_photo_remove */
public class ClickToPlayNoPausePlugin extends ClickToPlayPlugin {
    protected int f19305a;
    @Nullable
    public String f19306b;
    public boolean f19307c;
    private final AnimatorListener f19308l;
    private final ImageView f19309m;

    /* compiled from: composer_attach_photo_remove */
    class C14381 extends AnimatorListenerAdapter {
        final /* synthetic */ ClickToPlayNoPausePlugin f19303a;

        C14381(ClickToPlayNoPausePlugin clickToPlayNoPausePlugin) {
            this.f19303a = clickToPlayNoPausePlugin;
        }

        public void onAnimationEnd(Animator animator) {
            this.f19303a.mo1486f();
        }
    }

    /* compiled from: composer_attach_photo_remove */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ ClickToPlayNoPausePlugin f19304a;

        public PlayerStateChangedEventSubscriber(ClickToPlayNoPausePlugin clickToPlayNoPausePlugin) {
            this.f19304a = clickToPlayNoPausePlugin;
        }

        public final void m28075b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f19304a.f19306b != null && this.f19304a.f19306b.equals(rVPPlayerStateChangedEvent.a)) {
                if (rVPPlayerStateChangedEvent.b == State.PAUSED) {
                    this.f19304a.m28076a(2130840510, null);
                } else if (rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
                    this.f19304a.f19307c = true;
                } else if (this.f19304a.f19305a == 2130840510) {
                    this.f19304a.mo1486f();
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m28074a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    @DoNotStrip
    public ClickToPlayNoPausePlugin(Context context) {
        this(context, null);
    }

    public ClickToPlayNoPausePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClickToPlayNoPausePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19308l = new C14381(this);
        this.f19309m = (ImageView) a(2131560326);
        this.f.add(getPlayerStateChangedEventSubscriber());
    }

    protected void mo1484a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.mo1484a(richVideoPlayerParams, z);
        if (z) {
            this.f19307c = false;
            this.f19306b = richVideoPlayerParams.a.b;
        }
    }

    protected final void mo1485c() {
        this.f19306b = null;
    }

    protected RichVideoPlayerEventSubscriber getPlayerStateChangedEventSubscriber() {
        return new PlayerStateChangedEventSubscriber(this);
    }

    protected int getContentView() {
        return 2130903576;
    }

    public void mo1481d() {
        if (!this.f19307c) {
            super.mo1481d();
            m28076a(2130840511, this.f19308l);
        }
    }

    protected final void mo1482e() {
    }

    public final void m28076a(int i, AnimatorListener animatorListener) {
        this.f19305a = i;
        RichVideoPlayerPluginUtils.a(this.f19309m, 250, i, animatorListener);
    }

    protected final void mo1486f() {
        this.f19309m.setVisibility(8);
        this.f19309m.setAlpha(0.0f);
    }
}
