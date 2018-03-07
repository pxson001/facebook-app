package com.facebook.bitmaps;

/* compiled from: android.view.RenderNode */
public class ImageScaleParam {
    public final int f10365a;
    public final int f10366b;
    public final int f10367c;
    public final boolean f10368d;

    public ImageScaleParam(int i, int i2, boolean z, int i3) {
        this.f10365a = i;
        this.f10366b = i2;
        this.f10368d = z;
        this.f10367c = i3;
    }

    public ImageScaleParam(int i, int i2, int i3) {
        this.f10365a = i;
        this.f10366b = i2;
        this.f10368d = false;
        this.f10367c = i3;
    }

    public final int m18456a() {
        return this.f10365a;
    }

    public final int m18457b() {
        return this.f10366b;
    }

    public final int m18458c() {
        return this.f10367c;
    }

    public String toString() {
        return "[" + this.f10365a + "x" + this.f10366b + "]@" + this.f10367c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ImageScaleParam)) {
            return false;
        }
        ImageScaleParam imageScaleParam = (ImageScaleParam) obj;
        if (this.f10365a == imageScaleParam.f10365a && this.f10366b == imageScaleParam.f10366b && this.f10368d == imageScaleParam.f10368d && this.f10367c == imageScaleParam.f10367c) {
            return true;
        }
        return false;
    }
}
