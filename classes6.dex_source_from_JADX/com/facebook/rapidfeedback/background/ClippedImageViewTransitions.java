package com.facebook.rapidfeedback.background;

import android.graphics.Rect;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: failed to redindex contacts db */
public class ClippedImageViewTransitions extends Animation {
    private final ClippedImageView f15373a;
    private final ClippedImageView f15374b;
    private final int f15375c;
    private final int f15376d;
    private final int f15377e;
    private final Type f15378f;
    private Rect f15379g;
    private Rect f15380h;

    /* compiled from: failed to redindex contacts db */
    public enum Type {
        EXPAND,
        COLLAPSE
    }

    public ClippedImageViewTransitions(ClippedImageView clippedImageView, ClippedImageView clippedImageView2, int i, int i2, int i3, Type type) {
        this.f15373a = clippedImageView;
        this.f15374b = clippedImageView2;
        this.f15375c = i;
        this.f15376d = i2;
        this.f15377e = i3;
        this.f15378f = type;
        this.f15379g = clippedImageView.f15372c;
        this.f15380h = clippedImageView2.f15372c;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        int i;
        if (this.f15378f == Type.EXPAND) {
            i = (int) (((float) (this.f15375c - (this.f15376d / 2))) * f);
            this.f15379g.top = (this.f15375c - (this.f15376d / 2)) - i;
            this.f15379g.bottom = (this.f15377e + (this.f15375c - (this.f15376d / 2))) - i;
            this.f15373a.setDrawableBounds(this.f15379g);
            this.f15373a.invalidate();
            i = (int) (((float) ((this.f15377e - this.f15375c) - (this.f15376d / 2))) * f);
            this.f15380h.top = ((this.f15375c + (this.f15376d / 2)) - this.f15377e) + i;
            this.f15380h.bottom = i + (this.f15375c + (this.f15376d / 2));
            this.f15374b.setDrawableBounds(this.f15380h);
            this.f15374b.invalidate();
        } else if (this.f15378f == Type.COLLAPSE) {
            i = (int) (((float) (this.f15375c - (this.f15376d / 2))) * f);
            this.f15379g.top = i;
            this.f15379g.bottom = i + this.f15377e;
            this.f15373a.setDrawableBounds(this.f15379g);
            this.f15373a.invalidate();
            i = (int) (((float) ((this.f15377e - this.f15375c) - (this.f15376d / 2))) * f);
            this.f15380h.top = -i;
            this.f15380h.bottom = this.f15377e - i;
            this.f15374b.setDrawableBounds(this.f15380h);
            this.f15374b.invalidate();
        }
    }
}
