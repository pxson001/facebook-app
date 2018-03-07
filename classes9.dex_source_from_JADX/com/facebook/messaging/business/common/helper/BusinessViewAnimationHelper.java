package com.facebook.messaging.business.common.helper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;

/* compiled from: network_request_type */
public class BusinessViewAnimationHelper {

    /* compiled from: network_request_type */
    public final class C10011 implements AnimatorListener {
        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            animator.start();
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public static AnimatorSet m9021a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", new float[]{0.0f, -50.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(viewGroup2, "translationY", new float[]{50.0f, 0.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(viewGroup2, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        animatorSet.setDuration(250);
        animatorSet.setStartDelay(5000);
        return animatorSet;
    }
}
