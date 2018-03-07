package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.ClickToPlayNoPausePlugin;
import com.facebook.video.player.plugins.PlaybackController.State;
import javax.inject.Inject;

/* compiled from: Time between Device Info analytics events */
public class LiveContextClickToPlayNoPausePlugin extends ClickToPlayNoPausePlugin {
    @Inject
    public CommercialBreakInfoTracker f22131l;
    private final AnimatorListener f22132m;

    /* compiled from: Time between Device Info analytics events */
    class C18891 extends AnimatorListenerAdapter {
        final /* synthetic */ LiveContextClickToPlayNoPausePlugin f22129a;

        C18891(LiveContextClickToPlayNoPausePlugin liveContextClickToPlayNoPausePlugin) {
            this.f22129a = liveContextClickToPlayNoPausePlugin;
        }

        public void onAnimationEnd(Animator animator) {
            LiveContextClickToPlayNoPausePlugin.m24772k(this.f22129a);
        }
    }

    /* compiled from: Time between Device Info analytics events */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ LiveContextClickToPlayNoPausePlugin f22130a;

        public PlayerStateChangedEventSubscriber(LiveContextClickToPlayNoPausePlugin liveContextClickToPlayNoPausePlugin) {
            this.f22130a = liveContextClickToPlayNoPausePlugin;
        }

        public final void m24762b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f22130a.b != null && this.f22130a.b.equals(rVPPlayerStateChangedEvent.a)) {
                if (rVPPlayerStateChangedEvent.b == State.PAUSED) {
                    this.f22130a.d.setVisibility(0);
                    this.f22130a.a(2130840510, null);
                    return;
                }
                if (rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
                    this.f22130a.c = true;
                }
                LiveContextClickToPlayNoPausePlugin.m24772k(this.f22130a);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m24761a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    private static <T extends View> void m24766a(Class<T> cls, T t) {
        m24767a((Object) t, t.getContext());
    }

    private static void m24767a(Object obj, Context context) {
        ((LiveContextClickToPlayNoPausePlugin) obj).f22131l = CommercialBreakInfoTracker.a(FbInjector.get(context));
    }

    private void m24765a(CommercialBreakInfoTracker commercialBreakInfoTracker) {
        this.f22131l = commercialBreakInfoTracker;
    }

    @DoNotStrip
    public LiveContextClickToPlayNoPausePlugin(Context context) {
        this(context, null);
    }

    public LiveContextClickToPlayNoPausePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveContextClickToPlayNoPausePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22132m = new C18891(this);
        m24766a(LiveContextClickToPlayNoPausePlugin.class, (View) this);
    }

    protected RichVideoPlayerEventSubscriber getPlayerStateChangedEventSubscriber() {
        return new PlayerStateChangedEventSubscriber(this);
    }

    protected final void m24773a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        if (z) {
            m24772k(this);
        }
    }

    public final void m24774d() {
        if (!this.c) {
            if (this.f22131l.e(this.b) == RVPCommercialBreakStateChangeEvent.State.LIVE) {
                super.d();
            }
            a(2130840511, this.f22132m);
        }
    }

    public static void m24772k(LiveContextClickToPlayNoPausePlugin liveContextClickToPlayNoPausePlugin) {
        liveContextClickToPlayNoPausePlugin.d.setVisibility(8);
        liveContextClickToPlayNoPausePlugin.f();
    }
}
