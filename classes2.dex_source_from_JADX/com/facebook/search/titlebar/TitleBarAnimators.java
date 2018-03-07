package com.facebook.search.titlebar;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.AnimationUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: response_interval_stddev */
public class TitleBarAnimators {
    private static final SpringConfig f6953a = SpringConfig.m7843b(10.0d, 12.0d);
    private final Resources f6954b;
    private final Spring f6955c = this.f6956d.m7838a();
    private final SpringSystem f6956d;
    public final AnimationUtil f6957e;
    public final RTLUtil f6958f;
    private ValueAnimator f6959g;

    public static TitleBarAnimators m11539b(InjectorLike injectorLike) {
        return new TitleBarAnimators(ResourcesMethodAutoProvider.m6510a(injectorLike), SpringSystem.m7835b(injectorLike), AnimationUtil.m11568a(injectorLike), RTLUtil.m6553a(injectorLike));
    }

    @Inject
    public TitleBarAnimators(Resources resources, SpringSystem springSystem, AnimationUtil animationUtil, RTLUtil rTLUtil) {
        this.f6954b = resources;
        this.f6956d = springSystem;
        this.f6957e = animationUtil;
        this.f6955c.m7814a(f6953a);
        this.f6958f = rTLUtil;
    }

    public final void m11540a() {
        if (this.f6959g != null) {
            this.f6959g.removeAllListeners();
            this.f6959g.removeAllUpdateListeners();
        }
        if (this.f6955c != null) {
            this.f6955c.m7831m();
        }
    }

    public final void m11541a(View view) {
        m11536a(view, 1.0f);
    }

    public final void m11544b(View view) {
        m11536a(view, 0.0f);
    }

    public static void m11537a(View view, @Nullable AnimatorListener animatorListener) {
        Animator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.3f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(600);
        animatorSet.setInterpolator(new DecelerateInterpolator(3.0f));
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        animatorSet.start();
    }

    public final void m11543a(View view, int i, @Nullable AnimatorListener animatorListener) {
        m11538a(view, AnimationAction.SHOW, i, animatorListener);
    }

    public final void m11545b(View view, int i, @Nullable AnimatorListener animatorListener) {
        m11538a(view, AnimationAction.HIDE, i, animatorListener);
    }

    public final void m11542a(View view, int i) {
        m11538a(view, AnimationAction.UNCHANGED, i, null);
    }

    private void m11538a(View view, AnimationAction animationAction, int i, @Nullable AnimatorListener animatorListener) {
        if (AnimationUtil.m11570a()) {
            this.f6957e.m11572a(view);
        }
        if (this.f6959g != null) {
            this.f6959g.removeAllListeners();
            this.f6959g.removeAllUpdateListeners();
        }
        float dimensionPixelSize = (float) this.f6954b.getDimensionPixelSize(2131429222);
        if (animationAction == AnimationAction.SHOW) {
            i -= this.f6954b.getDimensionPixelSize(2131429219);
        }
        Integer valueOf = Integer.valueOf(i);
        this.f6959g = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f6959g.setDuration(600);
        this.f6959g.setInterpolator(new DecelerateInterpolator(3.0f));
        this.f6959g.addUpdateListener(new 1(this, view, animationAction, dimensionPixelSize, valueOf));
        this.f6959g.addListener(new 2(this, view));
        if (animatorListener != null) {
            this.f6959g.addListener(animatorListener);
        }
        this.f6959g.start();
    }

    private void m11536a(View view, float f) {
        this.f6955c.m7831m();
        this.f6955c.m7815a(new 3(this, f, view));
        this.f6955c.m7818b((double) f);
    }
}
