package com.facebook.video.player.plugins;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.spherical.ui.SphericalIndicator360View;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.player.events.RVP360IndicatorEvent;
import com.facebook.video.player.events.RVPFirstPlayEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: picture */
public class Video360IndicatorPlugin extends RichVideoPlayerPlugin {
    @Inject
    public Video360PlayerConfig f4754a;
    private SphericalIndicator360View f4755b;
    public View f4756c;
    public AnimatorSet f4757d;
    private ObjectAnimator f4758l;
    private ObjectAnimator f4759m;
    private ObjectAnimator f4760n;

    /* compiled from: picture */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ Video360IndicatorPlugin f4769a;

        public PlayerStateChangedEventSubscriber(Video360IndicatorPlugin video360IndicatorPlugin) {
            this.f4769a = video360IndicatorPlugin;
        }

        public final void m5222b(FbEvent fbEvent) {
            if (((RVPPlayerStateChangedEvent) fbEvent).f14079b == State.PLAYBACK_COMPLETE) {
                this.f4769a.f4756c.setVisibility(8);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m5221a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: picture */
    class FirstPlayEventSubscriber extends RichVideoPlayerEventSubscriber<RVPFirstPlayEvent> {
        final /* synthetic */ Video360IndicatorPlugin f4770a;

        public FirstPlayEventSubscriber(Video360IndicatorPlugin video360IndicatorPlugin) {
            this.f4770a = video360IndicatorPlugin;
        }

        public final void m5224b(FbEvent fbEvent) {
            Video360IndicatorPlugin video360IndicatorPlugin = this.f4770a;
            if (video360IndicatorPlugin.f4754a.f) {
                video360IndicatorPlugin.f4756c.setVisibility(0);
                video360IndicatorPlugin.f4756c.setAlpha(1.0f);
                video360IndicatorPlugin.f4757d.start();
            }
        }

        public final Class<RVPFirstPlayEvent> m5223a() {
            return RVPFirstPlayEvent.class;
        }
    }

    /* compiled from: picture */
    class IndicatorEventSubscriber extends RichVideoPlayerEventSubscriber<RVP360IndicatorEvent> {
        final /* synthetic */ Video360IndicatorPlugin f4771a;

        public IndicatorEventSubscriber(Video360IndicatorPlugin video360IndicatorPlugin) {
            this.f4771a = video360IndicatorPlugin;
        }

        public final void m5226b(FbEvent fbEvent) {
            switch (1.a[((RVP360IndicatorEvent) fbEvent).a.ordinal()]) {
                case 1:
                    if (this.f4771a.f4757d.isRunning()) {
                        this.f4771a.f4757d.cancel();
                    }
                    this.f4771a.f4756c.setVisibility(8);
                    return;
                default:
                    return;
            }
        }

        public final Class<RVP360IndicatorEvent> m5225a() {
            return RVP360IndicatorEvent.class;
        }
    }

    public static void m5211a(Object obj, Context context) {
        ((Video360IndicatorPlugin) obj).f4754a = Video360PlayerConfig.b(FbInjector.get(context));
    }

    @DoNotStrip
    public Video360IndicatorPlugin(Context context) {
        this(context, null);
    }

    private Video360IndicatorPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Video360IndicatorPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = Video360IndicatorPlugin.class;
        m5211a(this, getContext());
        m5212d();
    }

    private void m5212d() {
        setContentView(2130907652);
        this.f4755b = (SphericalIndicator360View) m14861a(2131568289);
        this.f4756c = m14861a(2131568288);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new FirstPlayEventSubscriber(this));
        this.f14094f.add(new IndicatorEventSubscriber(this));
        m5213e();
        this.f4756c.setVisibility(4);
        this.f4756c.setAlpha(0.0f);
    }

    @VisibleForTesting
    public View getContainerView() {
        return this.f4756c;
    }

    private void m5213e() {
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(2131428261);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{dimensionPixelSize, 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, dimensionPixelSize});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, 0.0f});
        this.f4760n = ObjectAnimator.ofPropertyValuesHolder(this.f4756c, new PropertyValuesHolder[]{ofFloat});
        this.f4760n.setInterpolator(PathInterpolatorCompat.m14975a(0.23f, 1.0f, 0.32f, 1.0f));
        this.f4760n.setDuration(1000);
        this.f4758l = ObjectAnimator.ofPropertyValuesHolder(this.f4756c, new PropertyValuesHolder[]{ofFloat2});
        this.f4758l.setInterpolator(PathInterpolatorCompat.m14975a(0.23f, 1.0f, 0.32f, 1.0f));
        this.f4758l.setDuration(1000);
        this.f4759m = this.f4755b.f4764d;
        this.f4759m.setInterpolator(PathInterpolatorCompat.m14975a(0.23f, 1.0f, 0.32f, 1.0f));
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f4756c, new PropertyValuesHolder[]{ofFloat3});
        ofPropertyValuesHolder.setDuration(4000);
        this.f4757d = new AnimatorSet();
        this.f4757d.play(this.f4760n).with(this.f4759m);
        this.f4757d.play(ofPropertyValuesHolder).after(this.f4760n);
        this.f4757d.play(this.f4758l).after(ofPropertyValuesHolder);
    }

    @VisibleForTesting
    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f4757d = animatorSet;
    }

    protected final void mo378c() {
        this.f4756c.setVisibility(8);
    }
}
