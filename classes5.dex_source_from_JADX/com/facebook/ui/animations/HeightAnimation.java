package com.facebook.ui.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: composerSessionLoggingData */
public class HeightAnimation extends Animation {
    public final int f5360a;
    public final View f5361b;
    private int f5362c;

    public HeightAnimation(View view, int i) {
        this.f5361b = view;
        this.f5360a = i;
    }

    public final void m10257a() {
        applyTransformation(1.0f, null);
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f5361b.getLayoutParams().height = (int) (((float) this.f5362c) + (((float) (this.f5360a - this.f5362c)) * f));
        this.f5361b.requestLayout();
    }

    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f5362c = i2;
    }

    public boolean willChangeBounds() {
        return true;
    }
}
