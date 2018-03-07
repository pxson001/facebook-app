package com.facebook.widget;

import javax.annotation.concurrent.Immutable;

@Immutable
@Deprecated
/* compiled from: com.google.android.gms.clearcut.service.START */
public class RoundedDrawSizeParams {
    public final int f5752a;
    public final int f5753b;
    public final int f5754c;
    public final int f5755d;
    public final int f5756e;
    public final int f5757f;
    public final ScaleType f5758g;

    /* compiled from: com.google.android.gms.clearcut.service.START */
    public enum ScaleType {
        NONE,
        CENTER,
        CENTER_CROP,
        MATRIX
    }

    public RoundedDrawSizeParams(int i, int i2, int i3, int i4, int i5, int i6, ScaleType scaleType) {
        this.f5753b = i2;
        this.f5752a = i;
        this.f5754c = i3;
        this.f5755d = i4;
        this.f5756e = i5;
        this.f5757f = i6;
        this.f5758g = scaleType;
    }
}
