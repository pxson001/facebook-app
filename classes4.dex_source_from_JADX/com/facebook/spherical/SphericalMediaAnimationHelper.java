package com.facebook.spherical;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

/* compiled from: pin */
public class SphericalMediaAnimationHelper {
    private ValueAnimator f4753a;

    public final void m5210a(float f, float f2, int i, HasGlToUIBridge hasGlToUIBridge) {
        if (this.f4753a != null) {
            this.f4753a.cancel();
        }
        if (hasGlToUIBridge.mo416a()) {
            this.f4753a = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f4753a.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f4753a.setDuration((long) i);
            SphericalMediaTextureView sphericalMediaTextureView = hasGlToUIBridge.get360TextureView();
            if (!(sphericalMediaTextureView.f5304e == null || sphericalMediaTextureView.f5304e.c == null)) {
                sphericalMediaTextureView.f5304e.c.d(f, f2);
            }
            this.f4753a.addUpdateListener(new CameraLookAtUpdateListener(this, hasGlToUIBridge));
            this.f4753a.start();
        }
    }

    public final void m5209a() {
        if (this.f4753a != null && this.f4753a.isRunning()) {
            this.f4753a.cancel();
        }
    }
}
