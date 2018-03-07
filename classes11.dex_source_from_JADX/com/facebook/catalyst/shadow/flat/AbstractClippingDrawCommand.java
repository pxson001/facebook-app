package com.facebook.catalyst.shadow.flat;

import android.graphics.Canvas;

/* compiled from: map_region_before */
public abstract class AbstractClippingDrawCommand implements DrawCommand {
    public float f5607c;
    public float f5608d;
    protected boolean d_;
    public float f5609e;
    public float f5610f;

    AbstractClippingDrawCommand() {
    }

    public final boolean m6920a(float f, float f2, float f3, float f4) {
        return this.f5607c == f && this.f5608d == f2 && this.f5609e == f3 && this.f5610f == f4;
    }

    public final void m6921b(float f, float f2, float f3, float f4) {
        this.f5607c = f;
        this.f5608d = f2;
        this.f5609e = f3;
        this.f5610f = f4;
        this.d_ = this.f5607c != Float.NEGATIVE_INFINITY;
    }

    protected final void m6919a(Canvas canvas) {
        canvas.clipRect(this.f5607c, this.f5608d, this.f5609e, this.f5610f);
    }
}
