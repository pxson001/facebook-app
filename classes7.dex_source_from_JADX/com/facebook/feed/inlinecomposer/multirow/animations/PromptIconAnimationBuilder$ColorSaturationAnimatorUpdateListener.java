package com.facebook.feed.inlinecomposer.multirow.animations;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

/* compiled from: android.settings.LOCATION_SOURCE_SETTINGS */
class PromptIconAnimationBuilder$ColorSaturationAnimatorUpdateListener implements AnimatorUpdateListener {
    private final ColorMatrix f19258a = new ColorMatrix();
    private final FbDraweeView f19259b;

    public PromptIconAnimationBuilder$ColorSaturationAnimatorUpdateListener(FbDraweeView fbDraweeView) {
        this.f19259b = fbDraweeView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19258a.setSaturation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        ((GenericDraweeHierarchy) this.f19259b.getHierarchy()).a(new ColorMatrixColorFilter(this.f19258a));
    }
}
