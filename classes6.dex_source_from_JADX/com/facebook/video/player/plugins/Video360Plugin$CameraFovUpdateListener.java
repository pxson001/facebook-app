package com.facebook.video.player.plugins;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: communication_rank */
class Video360Plugin$CameraFovUpdateListener implements AnimatorUpdateListener {
    final /* synthetic */ Video360Plugin f19406a;
    private float f19407b;
    private float f19408c;

    public Video360Plugin$CameraFovUpdateListener(Video360Plugin video360Plugin, float f, float f2) {
        this.f19406a = video360Plugin;
        this.f19407b = f;
        this.f19408c = f2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        animatedFraction = (animatedFraction * (this.f19408c - this.f19407b)) + this.f19407b;
        if (this.f19406a.a()) {
            this.f19406a.get360TextureView().setPreferredVerticalFOV(animatedFraction);
        }
    }
}
