package com.facebook.ui.animations.persistent.parts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: entity_fbid */
public class UpdateListenerAnimation implements PersistentAnimation {
    private final AnimatorUpdateListener f15237a;
    private final long f15238b;
    private final float f15239c;
    private final float f15240d;
    private final AnimatorListener f15241e;

    public UpdateListenerAnimation(AnimatorUpdateListener animatorUpdateListener, long j, float f, float f2, AnimatorListener animatorListener) {
        this.f15237a = animatorUpdateListener;
        this.f15238b = j;
        this.f15239c = f;
        this.f15240d = f2;
        this.f15241e = animatorListener;
    }

    public final Animator mo1179a(float f) {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{m19225b(f), this.f15240d});
        ofFloat.addUpdateListener(this.f15237a);
        if (this.f15241e != null) {
            ofFloat.addListener(this.f15241e);
        }
        ofFloat.setDuration((long) ((1.0f - f) * ((float) this.f15238b)));
        return ofFloat;
    }

    public final long mo1178a() {
        return this.f15238b;
    }

    @VisibleForTesting
    private float m19225b(float f) {
        return this.f15239c + ((this.f15240d - this.f15239c) * f);
    }
}
