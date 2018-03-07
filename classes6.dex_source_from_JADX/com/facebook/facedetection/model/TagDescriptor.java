package com.facebook.facedetection.model;

import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.proguard.annotations.DoNotStrip;

/* compiled from: null southwest */
public class TagDescriptor {
    private final float f9824a;
    private final PointF f9825b;
    public final RectF f9826c;
    private final int f9827d;
    private final int f9828e;
    private final float f9829f;
    public final byte[] f9830g;
    public final int f9831h;
    public final int f9832i;

    @DoNotStrip
    public TagDescriptor(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, int i2, float f8, byte[] bArr, int i3, int i4) {
        this.f9824a = f;
        this.f9825b = new PointF(f2, f3);
        this.f9826c = new RectF(f4, f5, f6, f7);
        this.f9827d = i;
        this.f9828e = i2;
        this.f9829f = f8;
        this.f9830g = bArr;
        this.f9831h = i3;
        this.f9832i = i4;
    }

    public final RectF m15570a() {
        return this.f9826c;
    }

    public final byte[] m15571b() {
        return this.f9830g;
    }

    public final int m15572c() {
        return this.f9831h;
    }

    public final int m15573d() {
        return this.f9832i;
    }
}
