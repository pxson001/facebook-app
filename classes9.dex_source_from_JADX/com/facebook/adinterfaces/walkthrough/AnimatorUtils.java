package com.facebook.adinterfaces.walkthrough;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: Unexpected request code received %s */
public class AnimatorUtils {

    /* compiled from: Unexpected request code received %s */
    class MarginLayoutParamsAnimatorUpdateListener implements AnimatorUpdateListener {
        private View f23390a;
        private int f23391b;

        public MarginLayoutParamsAnimatorUpdateListener(View view, int i) {
            this.f23390a = view;
            this.f23391b = i;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f23390a.getLayoutParams();
            marginLayoutParams.setMargins(this.f23391b == 0 ? num.intValue() : marginLayoutParams.leftMargin, this.f23391b == 1 ? num.intValue() : marginLayoutParams.topMargin, this.f23391b == 2 ? num.intValue() : marginLayoutParams.rightMargin, this.f23391b == 3 ? num.intValue() : marginLayoutParams.bottomMargin);
            this.f23390a.setLayoutParams(marginLayoutParams);
            this.f23390a.invalidate();
        }
    }

    public static void m25327a(View view, Rect rect) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        Animator ofInt = ValueAnimator.ofInt(new int[]{marginLayoutParams.leftMargin, rect.left});
        ofInt.addUpdateListener(new MarginLayoutParamsAnimatorUpdateListener(view, 0));
        Animator ofInt2 = ValueAnimator.ofInt(new int[]{marginLayoutParams.rightMargin, rect.right});
        ofInt2.addUpdateListener(new MarginLayoutParamsAnimatorUpdateListener(view, 2));
        Animator ofInt3 = ValueAnimator.ofInt(new int[]{marginLayoutParams.topMargin, rect.top});
        ofInt3.addUpdateListener(new MarginLayoutParamsAnimatorUpdateListener(view, 1));
        Animator ofInt4 = ValueAnimator.ofInt(new int[]{marginLayoutParams.bottomMargin, rect.bottom});
        ofInt4.addUpdateListener(new MarginLayoutParamsAnimatorUpdateListener(view, 3));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofInt).with(ofInt3).with(ofInt2).with(ofInt4);
        animatorSet.start();
    }
}
