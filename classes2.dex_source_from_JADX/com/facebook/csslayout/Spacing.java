package com.facebook.csslayout;

import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: fullscreen_video_player */
public class Spacing {
    private static final int[] f22820a = new int[]{1, 2, 4, 8, 16, 32, 64, HTTPTransportCallback.BODY_BYTES_RECEIVED, 256};
    private final float[] f22821b = m30941b();
    @Nullable
    private float[] f22822c = null;
    private int f22823d = 0;
    private boolean f22824e;

    public final boolean m30945a(int i, float f) {
        boolean z = false;
        if (FloatUtil.m30999a(this.f22821b[i], f)) {
            return false;
        }
        this.f22821b[i] = f;
        if (CSSConstants.m31000a(f)) {
            this.f22823d &= f22820a[i] ^ -1;
        } else {
            this.f22823d |= f22820a[i];
        }
        if (!((this.f22823d & f22820a[8]) == 0 && (this.f22823d & f22820a[4]) == 0 && (this.f22823d & f22820a[5]) == 0)) {
            z = true;
        }
        this.f22824e = z;
        return true;
    }

    public final boolean m30947b(int i, float f) {
        if (this.f22822c == null) {
            this.f22822c = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Float.NaN, Float.NaN, 0.0f};
        }
        if (FloatUtil.m30999a(this.f22822c[i], f)) {
            return false;
        }
        this.f22822c[i] = f;
        return true;
    }

    public final float m30942a(int i) {
        float f = this.f22822c != null ? this.f22822c[i] : (i == 6 || i == 7) ? Float.NaN : 0.0f;
        if (this.f22823d == 0) {
            return f;
        }
        if ((this.f22823d & f22820a[i]) != 0) {
            return this.f22821b[i];
        }
        if (!this.f22824e) {
            return f;
        }
        int i2 = (i == 1 || i == 3) ? 4 : 5;
        if ((this.f22823d & f22820a[i2]) != 0) {
            return this.f22821b[i2];
        }
        if ((this.f22823d & f22820a[8]) != 0) {
            return this.f22821b[8];
        }
        return f;
    }

    public final float m30946b(int i) {
        return this.f22821b[i];
    }

    final void m30944a() {
        Arrays.fill(this.f22821b, Float.NaN);
        this.f22822c = null;
        this.f22824e = false;
        this.f22823d = 0;
    }

    final float m30943a(int i, int i2) {
        return (this.f22823d & f22820a[i]) != 0 ? this.f22821b[i] : m30942a(i2);
    }

    private static float[] m30941b() {
        return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    }
}
