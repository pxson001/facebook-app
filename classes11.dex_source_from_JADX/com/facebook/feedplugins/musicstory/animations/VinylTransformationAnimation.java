package com.facebook.feedplugins.musicstory.animations;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/* compiled from: composer_date_info */
public class VinylTransformationAnimation extends Animation {
    private final VinylView f8305a;
    private final AnimationType f8306b;

    /* compiled from: composer_date_info */
    public enum AnimationType {
        SQUARE_TO_CIRCLE,
        CIRCLE_TO_SQUARE
    }

    public VinylTransformationAnimation(VinylView vinylView, AnimationType animationType) {
        this.f8305a = vinylView;
        this.f8306b = animationType;
        setInterpolator(new LinearInterpolator());
    }

    protected void applyTransformation(float f, Transformation transformation) {
        if (this.f8306b == AnimationType.SQUARE_TO_CIRCLE) {
            f = 1.0f - f;
        }
        this.f8305a.setRectangularity(f);
        this.f8305a.requestLayout();
    }
}
