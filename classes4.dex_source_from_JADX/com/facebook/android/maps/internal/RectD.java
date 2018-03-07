package com.facebook.android.maps.internal;

/* compiled from: drawDisplayList */
public class RectD {
    private static final double[] f13551e = new double[4];
    public double f13552a;
    public double f13553b;
    public double f13554c;
    public double f13555d;

    public RectD(double d, double d2, double d3, double d4) {
        this.f13554c = d;
        this.f13552a = d2;
        this.f13555d = d3;
        this.f13553b = d4;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f13554c + ", " + this.f13552a + ", " + this.f13555d + ", " + this.f13553b + ")";
    }

    public final boolean m14417a(double d, double d2) {
        if (this.f13554c > this.f13555d || this.f13552a > this.f13553b || this.f13554c > d || d > this.f13555d || this.f13552a > d2 || d2 > this.f13553b) {
            return false;
        }
        return true;
    }

    public final void m14416a(RectD rectD) {
        this.f13552a = rectD.f13552a;
        this.f13553b = rectD.f13553b;
        this.f13554c = rectD.f13554c;
        this.f13555d = rectD.f13555d;
    }

    public final void m14415a(double d, double d2, double d3) {
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        f13551e[0] = this.f13554c - d2;
        f13551e[1] = this.f13552a - d3;
        f13551e[2] = this.f13555d - d2;
        f13551e[3] = this.f13553b - d3;
        this.f13554c = Double.POSITIVE_INFINITY;
        this.f13555d = Double.NEGATIVE_INFINITY;
        this.f13552a = Double.POSITIVE_INFINITY;
        this.f13553b = Double.NEGATIVE_INFINITY;
        for (int i = 0; i <= 2; i += 2) {
            for (int i2 = 1; i2 <= 3; i2 += 2) {
                double d4 = (f13551e[i] * cos) - (f13551e[i2] * sin);
                double d5 = (f13551e[i] * sin) + (f13551e[i2] * cos);
                if (d4 < this.f13554c) {
                    this.f13554c = d4;
                }
                if (this.f13555d < d4) {
                    this.f13555d = d4;
                }
                if (d5 < this.f13552a) {
                    this.f13552a = d5;
                }
                if (this.f13553b < d5) {
                    this.f13553b = d5;
                }
            }
        }
        this.f13554c += d2;
        this.f13555d += d2;
        this.f13552a += d3;
        this.f13553b += d3;
    }

    public final void m14418b(RectD rectD) {
        if (rectD.f13554c < rectD.f13555d && rectD.f13552a < rectD.f13553b) {
            if (this.f13554c >= this.f13555d || this.f13552a >= this.f13553b) {
                m14416a(rectD);
                return;
            }
            if (this.f13554c > rectD.f13554c) {
                this.f13554c = rectD.f13554c;
            }
            if (this.f13552a > rectD.f13552a) {
                this.f13552a = rectD.f13552a;
            }
            if (this.f13555d < rectD.f13555d) {
                this.f13555d = rectD.f13555d;
            }
            if (this.f13553b < rectD.f13553b) {
                this.f13553b = rectD.f13553b;
            }
        }
    }

    public final boolean m14419c(RectD rectD) {
        if (this.f13554c >= rectD.f13555d || rectD.f13554c >= this.f13555d || this.f13552a >= rectD.f13553b || rectD.f13552a >= this.f13553b) {
            return false;
        }
        if (this.f13554c < rectD.f13554c) {
            this.f13554c = rectD.f13554c;
        }
        if (this.f13552a < rectD.f13552a) {
            this.f13552a = rectD.f13552a;
        }
        if (this.f13555d > rectD.f13555d) {
            this.f13555d = rectD.f13555d;
        }
        if (this.f13553b > rectD.f13553b) {
            this.f13553b = rectD.f13553b;
        }
        return true;
    }

    public final boolean m14420d(RectD rectD) {
        if (this.f13554c > this.f13555d || this.f13552a > this.f13553b || this.f13554c > rectD.f13554c || rectD.f13554c > this.f13555d || this.f13554c > rectD.f13555d || rectD.f13555d > this.f13555d || this.f13552a > rectD.f13553b || rectD.f13553b > this.f13553b || this.f13552a > rectD.f13552a || rectD.f13552a > this.f13553b) {
            return false;
        }
        return true;
    }
}
