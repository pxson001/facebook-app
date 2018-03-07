package com.facebook.video.channelfeed;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: synced_ccu_setting_with_server */
public class ChannelFeedOverlayHeaderView extends CustomLinearLayout implements CanFocusDim {
    public final FbTextView f2367a;
    private final ValueAnimator f2368b;
    private final ValueAnimator f2369c;
    public boolean f2370d;
    private boolean f2371e;

    /* compiled from: synced_ccu_setting_with_server */
    class C02161 implements AnimatorListener {
        final /* synthetic */ ChannelFeedOverlayHeaderView f2365a;

        C02161(ChannelFeedOverlayHeaderView channelFeedOverlayHeaderView) {
            this.f2365a = channelFeedOverlayHeaderView;
        }

        public void onAnimationStart(Animator animator) {
            if (this.f2365a.f2370d) {
                this.f2365a.f2367a.setVisibility(0);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f2365a.f2370d) {
                this.f2365a.f2367a.setVisibility(8);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: synced_ccu_setting_with_server */
    class C02172 implements AnimatorUpdateListener {
        final /* synthetic */ ChannelFeedOverlayHeaderView f2366a;

        C02172(ChannelFeedOverlayHeaderView channelFeedOverlayHeaderView) {
            this.f2366a = channelFeedOverlayHeaderView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f = (Float) valueAnimator.getAnimatedValue();
            this.f2366a.f2367a.setAlpha(f.floatValue());
            this.f2366a.f2367a.setTranslationY(((1.0f - f.floatValue()) * ((float) this.f2366a.f2367a.getHeight())) / 2.0f);
        }
    }

    public ChannelFeedOverlayHeaderView(Context context) {
        this(context, null);
    }

    public ChannelFeedOverlayHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChannelFeedOverlayHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2368b = new ValueAnimator();
        this.f2369c = new ValueAnimator();
        this.f2370d = false;
        this.f2371e = false;
        setContentView(2130903543);
        this.f2367a = (FbTextView) a(2131560281);
        this.f2368b.setDuration(300);
        this.f2368b.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f2368b.addListener(new C02161(this));
        this.f2369c.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f2367a.setAlpha(0.0f);
        this.f2367a.setVisibility(8);
    }

    public void setTitle(String str) {
        this.f2367a.setText(str);
    }

    public final void m2325c() {
        if (!this.f2370d) {
            this.f2370d = true;
            m2322e();
        }
    }

    public final void m2326d() {
        if (this.f2370d) {
            this.f2370d = false;
            m2322e();
        }
    }

    public final void mo66a() {
        if (this.f2370d && !this.f2371e) {
            this.f2371e = true;
            ChannelFeedDimmingUtil.m2139a(this.f2371e, this.f2369c, this.f2367a);
        }
    }

    public final void mo67b() {
        if (this.f2370d && this.f2371e) {
            this.f2371e = false;
            ChannelFeedDimmingUtil.m2139a(this.f2371e, this.f2369c, this.f2367a);
        }
    }

    private void m2322e() {
        float f = 1.0f;
        float f2 = this.f2370d ? 0.0f : 1.0f;
        if (!this.f2370d) {
            f = 0.0f;
        }
        if (this.f2368b.isRunning()) {
            this.f2368b.reverse();
            return;
        }
        this.f2368b.setFloatValues(new float[]{f2, f});
        this.f2368b.removeAllUpdateListeners();
        this.f2368b.addUpdateListener(new C02172(this));
        this.f2368b.start();
    }
}
