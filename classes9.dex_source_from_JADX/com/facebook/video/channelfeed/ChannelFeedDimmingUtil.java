package com.facebook.video.channelfeed;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: tax_id */
public class ChannelFeedDimmingUtil {

    /* compiled from: tax_id */
    final class C02081 implements AnimatorUpdateListener {
        final /* synthetic */ View f2132a;

        C02081(View view) {
            this.f2132a = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2132a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static void m2139a(boolean z, ValueAnimator valueAnimator, View view) {
        float f = 1.0f;
        float f2 = z ? 1.0f : 0.08f;
        if (z) {
            f = 0.08f;
        }
        valueAnimator.setDuration((long) (z ? 2000 : 300));
        if (valueAnimator.isRunning()) {
            Float f3 = (Float) valueAnimator.getAnimatedValue();
            valueAnimator.cancel();
            valueAnimator.setFloatValues(new float[]{f3.floatValue(), f});
            valueAnimator.start();
            return;
        }
        valueAnimator.setFloatValues(new float[]{f2, f});
        valueAnimator.removeAllUpdateListeners();
        valueAnimator.addUpdateListener(new C02081(view));
        valueAnimator.start();
    }
}
