package com.facebook.events.carousel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

@TargetApi(11)
/* compiled from: contacts_divebar */
public class EventsCarouselViewAnimator {
    public static void m16436a(View view, Rect rect, Rect rect2, float f, long j) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(view, "x", new float[]{(float) rect.left, (float) rect2.left})).with(ObjectAnimator.ofFloat(view, "y", new float[]{(float) rect.top, (float) rect2.top})).with(ObjectAnimator.ofFloat(view, "scaleX", new float[]{f, 1.0f})).with(ObjectAnimator.ofFloat(view, "scaleY", new float[]{f, 1.0f}));
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
    }
}
