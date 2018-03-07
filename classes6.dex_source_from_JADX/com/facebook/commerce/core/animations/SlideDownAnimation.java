package com.facebook.commerce.core.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: primary_category */
public class SlideDownAnimation extends Animation {
    public float f7453a;
    private View f7454b;

    public SlideDownAnimation(int i, View view) {
        this.f7454b = view;
        setDuration((long) i);
    }

    protected void applyTransformation(float f, Transformation transformation) {
        if (f == 1.0f) {
            this.f7454b.getLayoutParams().height = -2;
        } else {
            this.f7454b.getLayoutParams().height = (int) (this.f7453a * f);
        }
        this.f7454b.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
