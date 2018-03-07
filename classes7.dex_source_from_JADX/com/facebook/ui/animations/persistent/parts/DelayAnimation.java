package com.facebook.ui.animations.persistent.parts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import com.facebook.ui.animations.persistent.PersistentAnimation;

/* compiled from: error while closing BufferedOutputStream. */
public class DelayAnimation implements PersistentAnimation {
    private final long f15224a;
    private final AnimatorListener f15225b;

    public DelayAnimation(long j, AnimatorListener animatorListener) {
        this.f15224a = j;
        this.f15225b = animatorListener;
    }

    public final Animator mo1179a(float f) {
        Animator ofInt = ValueAnimator.ofInt(new int[]{0, 1});
        ofInt.setDuration((long) ((1.0f - f) * ((float) this.f15224a)));
        if (this.f15225b != null) {
            ofInt.addListener(this.f15225b);
        }
        return ofInt;
    }

    public final long mo1178a() {
        return this.f15224a;
    }
}
