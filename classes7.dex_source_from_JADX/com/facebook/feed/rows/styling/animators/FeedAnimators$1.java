package com.facebook.feed.rows.styling.animators;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: showPopupMenu */
class FeedAnimators$1 implements AnimatorUpdateListener {
    final /* synthetic */ View f3752a;
    final /* synthetic */ FeedAnimators f3753b;

    FeedAnimators$1(FeedAnimators feedAnimators, View view) {
        this.f3753b = feedAnimators;
        this.f3752a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        this.f3752a.getLayoutParams().height = num.intValue();
        this.f3752a.requestLayout();
    }
}
