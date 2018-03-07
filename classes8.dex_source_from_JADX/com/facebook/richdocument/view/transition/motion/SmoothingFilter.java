package com.facebook.richdocument.view.transition.motion;

import java.util.Arrays;

/* compiled from: optional */
public class SmoothingFilter {
    private final float f7024a;
    public long f7025b;
    public float[] f7026c;
    private long f7027d;
    public long f7028e;
    private long f7029f;
    private int f7030g;

    public SmoothingFilter() {
        this(2.0f);
    }

    public SmoothingFilter(float f) {
        this.f7025b = Long.MAX_VALUE;
        this.f7026c = null;
        this.f7024a = f;
    }

    public final void m7346a(long j, float[] fArr) {
        if (m7345a(fArr)) {
            long j2 = this.f7027d;
            this.f7027d = j;
            this.f7028e = this.f7027d - j2;
            if (this.f7026c == null || this.f7028e > this.f7025b) {
                this.f7026c = Arrays.copyOf(fArr, fArr.length);
                this.f7029f = 0;
                this.f7030g = 1;
                this.f7028e = 0;
                return;
            }
            this.f7029f += this.f7028e;
            float f = ((float) this.f7029f) / ((float) this.f7030g);
            if (this.f7028e > 0) {
                for (int i = 0; i < this.f7026c.length; i++) {
                    float[] fArr2 = this.f7026c;
                    fArr2[i] = fArr2[i] + ((fArr[i] - this.f7026c[i]) / ((this.f7024a * f) / ((float) this.f7028e)));
                }
            }
            this.f7030g++;
        }
    }

    public static boolean m7345a(float[] fArr) {
        for (float f : fArr) {
            if (f == Float.NaN) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return Arrays.toString(this.f7026c);
    }
}
