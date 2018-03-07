package com.facebook.feedplugins.musicstory.animations;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.google.common.base.Preconditions;

/* compiled from: composer_delete_session */
public class VinylRotationAnimation extends Animation {
    private final VinylView f8301a;
    private float f8302b;
    private float f8303c;
    public float f8304d;

    public VinylRotationAnimation(VinylView vinylView) {
        this.f8301a = (VinylView) Preconditions.checkNotNull(vinylView);
        setInterpolator(new LinearInterpolator());
    }

    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f8302b = resolveSize(1, 0.5f, i, i3);
        this.f8303c = resolveSize(1, 0.5f, i2, i4);
    }

    protected void applyTransformation(float f, Transformation transformation) {
        float scaleFactor = getScaleFactor();
        this.f8304d += 7.0f;
        transformation.getMatrix().setRotate(this.f8304d, this.f8302b * scaleFactor, scaleFactor * this.f8303c);
        this.f8301a.invalidate();
    }
}
