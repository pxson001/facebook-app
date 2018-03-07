package com.facebook.photos.editgallery.animations;

import android.graphics.PointF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.google.common.base.Preconditions;

/* compiled from: last_minutiae_opened */
public class EditGalleryAnimation {
    public final PointF f10483a;
    public final int f10484b;
    public float f10485c;

    public EditGalleryAnimation(AnimationParam animationParam, AnimationParam animationParam2, PointF pointF, int i) {
        Preconditions.checkNotNull(animationParam);
        Preconditions.checkNotNull(animationParam2);
        Preconditions.checkNotNull(pointF);
        this.f10483a = pointF;
        this.f10485c = animationParam.m12364a() - animationParam2.m12364a();
        if (Math.abs(this.f10485c) < 100.0f) {
            this.f10485c = 100.0f;
        }
        this.f10484b = Math.abs(this.f10485c) > ((float) (i / 2)) ? 500 : 250;
    }

    public final void m12365a(View view, AnimationListener animationListener) {
        view.setVisibility(0);
        view.setAlpha(1.0f);
        Animation translateAnimation = new TranslateAnimation(this.f10483a.x, this.f10483a.x, this.f10483a.y + this.f10485c, this.f10483a.y);
        translateAnimation.setDuration((long) this.f10484b);
        if (animationListener != null) {
            translateAnimation.setAnimationListener(animationListener);
        }
        view.clearAnimation();
        view.setAnimation(translateAnimation);
        translateAnimation.startNow();
    }
}
