package com.facebook.spherical;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: eventType */
class SphericalMediaAnimationHelper$CameraLookAtUpdateListener implements AnimatorUpdateListener {
    final /* synthetic */ SphericalMediaAnimationHelper f16145a;
    private HasGlToUIBridge f16146b;

    public SphericalMediaAnimationHelper$CameraLookAtUpdateListener(SphericalMediaAnimationHelper sphericalMediaAnimationHelper, HasGlToUIBridge hasGlToUIBridge) {
        this.f16145a = sphericalMediaAnimationHelper;
        this.f16146b = hasGlToUIBridge;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        if (this.f16146b.a()) {
            SphericalMediaTextureView sphericalMediaTextureView = this.f16146b.get360TextureView();
            if (sphericalMediaTextureView.e != null && sphericalMediaTextureView.e.f16149c != null) {
                GlMediaRenderThread glMediaRenderThread = sphericalMediaTextureView.e.f16149c;
                glMediaRenderThread.f16121e.f16054a.lock();
                glMediaRenderThread.f16121e.mo1235a(animatedFraction);
                glMediaRenderThread.f16121e.f16054a.unlock();
            }
        }
    }
}
