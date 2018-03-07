package com.facebook.ui.animations;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: components_pagination */
public class ScaleUpDownAnimation {
    private ScaleUpDownAnimation() {
    }

    private static void m10260a(View view, String str, String str2, float f, long j, boolean z, AnimatorListener animatorListener) {
        Animator ofFloat = ObjectAnimator.ofFloat(view, str, new float[]{f});
        Animator ofFloat2 = ObjectAnimator.ofFloat(view, str2, new float[]{f});
        ofFloat.setDuration(j);
        ofFloat2.setDuration(j);
        Animator ofFloat3 = ObjectAnimator.ofFloat(view, str, new float[]{1.0f});
        Animator ofFloat4 = ObjectAnimator.ofFloat(view, str2, new float[]{1.0f});
        ofFloat3.setDuration(j);
        ofFloat4.setDuration(j);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat).before(ofFloat3);
        animatorSet.play(ofFloat3).with(ofFloat4);
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        if (z) {
            animatorSet.play(ofFloat3).before(BounceAnimationCreator.m10255a(view, str, str2));
        }
        animatorSet.start();
    }

    public static void m10259a(View view, float f, long j, boolean z, AnimatorListener animatorListener) {
        m10260a(view, "scaleX", "scaleY", f, j, z, animatorListener);
    }
}
