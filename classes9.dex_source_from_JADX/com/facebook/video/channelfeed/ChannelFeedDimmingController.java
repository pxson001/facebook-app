package com.facebook.video.channelfeed;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.common.collect.WeakHashSets;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.inject.Assisted;
import com.facebook.video.player.RichVideoPlayer;
import java.lang.ref.WeakReference;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: teamInfo */
public class ChannelFeedDimmingController<V> extends VideoViewController<V> {
    private final Set<View> f2124a = WeakHashSets.a();
    private final ValueAnimator f2125b = new ValueAnimator();
    private final ChannelFeedFocusDimmingManager f2126c;
    private final float f2127d;
    private State f2128e = State.DIMMED;
    private State f2129f = null;
    private float f2130g;
    @Nullable
    private WeakReference<RichVideoPlayer> f2131h;

    /* compiled from: teamInfo */
    class C02061 implements AnimatorUpdateListener {
        final /* synthetic */ ChannelFeedDimmingController f2122a;

        C02061(ChannelFeedDimmingController channelFeedDimmingController) {
            this.f2122a = channelFeedDimmingController;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ChannelFeedDimmingController.m2127a(this.f2122a, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: teamInfo */
    enum State {
        DIMMED,
        UNDIMMED,
        FOCUS_DIMMED
    }

    @Inject
    public ChannelFeedDimmingController(@Assisted String str, @Assisted float f, ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager) {
        super(str);
        this.f2126c = channelFeedFocusDimmingManager;
        this.f2125b.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f2130g = f;
        this.f2127d = f;
    }

    public final void m2135b(V v) {
        if (this.f2128e != State.UNDIMMED) {
            RichVideoPlayer e = m2128e();
            if (e != null) {
                this.f2126c.m2187a(this, e);
            }
            m2126a(State.UNDIMMED);
            m2129f();
        }
    }

    public final void m2132a(V v) {
        if (this.f2128e != State.DIMMED) {
            RichVideoPlayer e = m2128e();
            if (e != null) {
                this.f2126c.m2188b(this, e);
            }
            m2126a(State.DIMMED);
            m2129f();
        }
    }

    public final void m2131a(RichVideoPlayer richVideoPlayer) {
        this.f2131h = new WeakReference(richVideoPlayer);
    }

    public final void m2133b() {
        if (this.f2131h != null) {
            this.f2131h.clear();
        }
    }

    public final void m2130a(View view) {
        this.f2124a.add(view);
        m2129f();
    }

    public final void m2134b(View view) {
        this.f2124a.remove(view);
    }

    public final void m2136c() {
        if (this.f2128e == State.UNDIMMED) {
            m2126a(State.FOCUS_DIMMED);
            m2129f();
        }
    }

    public final void m2137d() {
        if (this.f2128e == State.FOCUS_DIMMED) {
            m2126a(State.UNDIMMED);
            m2129f();
        }
    }

    @Nullable
    private RichVideoPlayer m2128e() {
        return this.f2131h == null ? null : (RichVideoPlayer) this.f2131h.get();
    }

    private void m2126a(State state) {
        this.f2129f = this.f2128e;
        this.f2128e = state;
    }

    private void m2129f() {
        float f;
        int i = 300;
        float f2 = 1.0f;
        switch (this.f2128e) {
            case DIMMED:
                f = this.f2127d;
                break;
            case UNDIMMED:
                f2 = this.f2127d;
                f = 1.0f;
                break;
            case FOCUS_DIMMED:
                f = this.f2127d;
                i = 2000;
                break;
            default:
                return;
        }
        this.f2125b.setDuration((long) i);
        if (!this.f2125b.isRunning() && f == this.f2130g) {
            m2127a(this, f);
        } else if (!this.f2125b.isRunning()) {
            this.f2130g = f;
            this.f2125b.setFloatValues(new float[]{f2, f});
            this.f2125b.removeAllUpdateListeners();
            this.f2125b.addUpdateListener(new C02061(this));
            this.f2125b.start();
        } else if (f != this.f2130g) {
            this.f2130g = f;
            Float f3 = (Float) this.f2125b.getAnimatedValue();
            this.f2125b.cancel();
            this.f2125b.setFloatValues(new float[]{f3.floatValue(), f});
            this.f2125b.start();
        }
    }

    public static void m2127a(ChannelFeedDimmingController channelFeedDimmingController, float f) {
        Object obj = null;
        Object obj2 = (channelFeedDimmingController.f2128e == State.FOCUS_DIMMED && channelFeedDimmingController.f2129f == State.UNDIMMED) ? 1 : null;
        if (channelFeedDimmingController.f2128e == State.UNDIMMED && channelFeedDimmingController.f2129f == State.FOCUS_DIMMED) {
            obj = 1;
        }
        for (View view : channelFeedDimmingController.f2124a) {
            if (!(view instanceof ChannelFeedVideoAttachmentView) || (obj2 == null && r2 == null)) {
                view.setAlpha(f);
            }
        }
    }
}
