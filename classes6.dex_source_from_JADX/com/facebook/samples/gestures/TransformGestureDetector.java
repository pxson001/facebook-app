package com.facebook.samples.gestures;

import com.facebook.samples.zoomable.DefaultZoomableController;

/* compiled from: setInitialFacecastInfo */
public class TransformGestureDetector {
    public final MultiPointerGestureDetector f4799a;
    public DefaultZoomableController f4800b = null;

    public TransformGestureDetector(MultiPointerGestureDetector multiPointerGestureDetector) {
        this.f4799a = multiPointerGestureDetector;
        this.f4799a.f4798i = this;
    }

    private static float m7573a(float[] fArr, int i) {
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            f += fArr[i2];
        }
        if (i > 0) {
            return f / ((float) i);
        }
        return 0.0f;
    }

    public final void m7574e() {
        this.f4799a.m7572c();
    }

    public final float m7575f() {
        return m7573a(this.f4799a.f4794e, this.f4799a.f4791b);
    }

    public final float m7576g() {
        return m7573a(this.f4799a.f4795f, this.f4799a.f4791b);
    }

    public final float m7577h() {
        return m7573a(this.f4799a.f4796g, this.f4799a.f4791b) - m7573a(this.f4799a.f4794e, this.f4799a.f4791b);
    }

    public final float m7578i() {
        return m7573a(this.f4799a.f4797h, this.f4799a.f4791b) - m7573a(this.f4799a.f4795f, this.f4799a.f4791b);
    }

    public final float m7579j() {
        if (this.f4799a.f4791b < 2) {
            return 1.0f;
        }
        return ((float) Math.hypot((double) (this.f4799a.f4796g[1] - this.f4799a.f4796g[0]), (double) (this.f4799a.f4797h[1] - this.f4799a.f4797h[0]))) / ((float) Math.hypot((double) (this.f4799a.f4794e[1] - this.f4799a.f4794e[0]), (double) (this.f4799a.f4795f[1] - this.f4799a.f4795f[0])));
    }
}
