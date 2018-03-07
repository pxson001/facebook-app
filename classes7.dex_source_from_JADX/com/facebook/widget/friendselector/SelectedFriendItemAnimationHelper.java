package com.facebook.widget.friendselector;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

/* compiled from: db95ea2e40f4bc2223a7086014d90a63 */
public class SelectedFriendItemAnimationHelper {
    public static final Interpolator f16110a = new OvershootInterpolator(1.0f);

    /* compiled from: db95ea2e40f4bc2223a7086014d90a63 */
    final class C12711 extends AnimatorListenerAdapter {
        final /* synthetic */ View f16109a;

        C12711(View view) {
            this.f16109a = view;
        }

        public final void onAnimationStart(Animator animator) {
            SelectedFriendItemAnimationHelper.m20130g(this.f16109a, 2);
        }

        public final void onAnimationEnd(Animator animator) {
            SelectedFriendItemAnimationHelper.m20130g(this.f16109a, 0);
        }
    }

    public static Animator m20128d(View view, int i) {
        Animator animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) i}).setInterpolator(f16110a);
        animatorSet.playTogether(new Animator[]{ofFloat, r2});
        animatorSet.addListener(m20129f(view));
        return animatorSet;
    }

    public static Animator m20124a(View view) {
        Animator animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator.ofFloat(view, "scaleX", new float[]{0.0f, 1.0f}).setInterpolator(f16110a);
        ObjectAnimator.ofFloat(view, "scaleY", new float[]{0.0f, 1.0f}).setInterpolator(f16110a);
        animatorSet.playTogether(new Animator[]{ofFloat, r2, r3});
        animatorSet.addListener(m20129f(view));
        return animatorSet;
    }

    public static Animator m20126b(View view) {
        Animator animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 1.2f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 1.2f, 1.0f});
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(m20129f(view));
        return animatorSet;
    }

    public static Animator m20125a(SelectedFriendItemView selectedFriendItemView) {
        Animator ofFloat = ObjectAnimator.ofFloat(selectedFriendItemView, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(f16110a);
        ofFloat.addListener(m20129f(selectedFriendItemView));
        return ofFloat;
    }

    public static Animator m20127c(View view) {
        Animator animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 0.0f});
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(m20129f(view));
        return animatorSet;
    }

    public static AnimatorListenerAdapter m20129f(View view) {
        return new C12711(view);
    }

    public static void m20130g(View view, int i) {
        if (ViewCompat.g(view) != i) {
            ViewCompat.a(view, i, null);
        }
    }
}
