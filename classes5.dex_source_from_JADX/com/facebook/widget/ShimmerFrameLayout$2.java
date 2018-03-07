package com.facebook.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: com.google.android.gms.ads.identifier.internal.IAdvertisingIdService */
class ShimmerFrameLayout$2 implements AnimatorUpdateListener {
    final /* synthetic */ ShimmerFrameLayout f5776a;

    ShimmerFrameLayout$2(ShimmerFrameLayout shimmerFrameLayout) {
        this.f5776a = shimmerFrameLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        ShimmerFrameLayout.setMaskOffsetX(this.f5776a, (int) ((((float) this.f5776a.h.a) * (1.0f - max)) + (((float) this.f5776a.h.c) * max)));
        ShimmerFrameLayout.setMaskOffsetY(this.f5776a, (int) ((max * ((float) this.f5776a.h.d)) + (((float) this.f5776a.h.b) * (1.0f - max))));
    }
}
