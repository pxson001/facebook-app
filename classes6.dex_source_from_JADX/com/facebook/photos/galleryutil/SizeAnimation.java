package com.facebook.photos.galleryutil;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: hide_suggestion */
public class SizeAnimation extends Animation {
    private View f13010a;
    private Dimension f13011b;
    private Type f13012c;
    private int f13013d;
    private int f13014e;

    /* compiled from: hide_suggestion */
    public enum Dimension {
        WIDTH,
        HEIGHT
    }

    /* compiled from: hide_suggestion */
    public enum Type {
        EXPAND,
        COLLAPSE
    }

    public SizeAnimation(View view, Dimension dimension, Type type, int i, int i2) {
        this.f13010a = view;
        this.f13011b = dimension;
        this.f13012c = type;
        this.f13013d = i;
        this.f13014e = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        if (this.f13012c == Type.COLLAPSE) {
            f = 1.0f - f;
        }
        int i = this.f13013d + ((int) (((float) (this.f13014e - this.f13013d)) * f));
        if (this.f13011b == Dimension.WIDTH) {
            this.f13010a.getLayoutParams().width = i;
        } else {
            this.f13010a.getLayoutParams().height = i;
        }
        this.f13010a.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
