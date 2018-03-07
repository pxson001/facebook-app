package com.facebook.ui.animations.persistent.parts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

/* compiled from: entityFbid */
public class ViewScaleAnimation implements PersistentAnimation {
    private final View f15242a;
    private final long f15243b;
    private final float f15244c;
    private final float f15245d;
    @Nullable
    private final AnimatorListener f15246e;

    public ViewScaleAnimation(View view, long j, float f, float f2, AnimatorListener animatorListener) {
        this.f15242a = view;
        this.f15243b = j;
        this.f15244c = f;
        this.f15245d = f2;
        this.f15246e = animatorListener;
    }

    public final Animator mo1179a(float f) {
        float b = m19228b(f);
        Animator animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f15242a, "scaleX", new float[]{b, this.f15245d})).with(ObjectAnimator.ofFloat(this.f15242a, "scaleY", new float[]{b, this.f15245d}));
        if (this.f15246e != null) {
            animatorSet.addListener(this.f15246e);
        }
        animatorSet.setDuration((long) ((1.0f - f) * ((float) this.f15243b)));
        return animatorSet;
    }

    public final long mo1178a() {
        return this.f15243b;
    }

    @VisibleForTesting
    private float m19228b(float f) {
        return this.f15244c + ((this.f15245d - this.f15244c) * f);
    }
}
