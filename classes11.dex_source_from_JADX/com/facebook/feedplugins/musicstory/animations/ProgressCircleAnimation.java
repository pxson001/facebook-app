package com.facebook.feedplugins.musicstory.animations;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: composer_entry_configuration_json_failed */
public class ProgressCircleAnimation extends Animation {
    private final ProgressCircle f8299a;
    private float f8300b;

    public ProgressCircleAnimation(ProgressCircle progressCircle) {
        this.f8300b = progressCircle.f8298e;
        this.f8299a = progressCircle;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f8299a.setAngle(this.f8300b + ((360.0f - this.f8300b) * f));
        this.f8299a.requestLayout();
    }

    public final void m9234a(int i) {
        setDuration((long) i);
        this.f8299a.setVisibility(0);
        this.f8299a.startAnimation(this);
    }

    public final void m9233a() {
        this.f8300b = this.f8299a.f8298e;
        this.f8299a.clearAnimation();
    }

    public final void m9235b() {
        this.f8300b = 0.0f;
        this.f8299a.m9232a();
        this.f8299a.clearAnimation();
        this.f8299a.setVisibility(8);
    }

    public final void m9236b(int i) {
        this.f8300b = this.f8299a.f8298e;
        m9234a(i);
    }
}
