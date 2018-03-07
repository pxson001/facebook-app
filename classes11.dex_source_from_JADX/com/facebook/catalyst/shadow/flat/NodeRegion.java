package com.facebook.catalyst.shadow.flat;

/* compiled from: location_pin_clicked_ */
public class NodeRegion {
    static final NodeRegion[] f5771a = new NodeRegion[0];
    static final NodeRegion f5772b = new NodeRegion(0.0f, 0.0f, 0.0f, 0.0f, -1, false);
    final float f5773c;
    final float f5774d;
    final float f5775e;
    final float f5776f;
    final int f5777g;
    final boolean f5778h;

    NodeRegion(float f, float f2, float f3, float f4, int i, boolean z) {
        this.f5773c = f;
        this.f5774d = f2;
        this.f5775e = f3;
        this.f5776f = f4;
        this.f5777g = i;
        this.f5778h = z;
    }

    public final boolean m7107a(float f, float f2) {
        return this.f5773c <= f && f < this.f5775e && this.f5774d <= f2 && f2 < this.f5776f;
    }

    int mo178b(float f, float f2) {
        return this.f5777g;
    }
}
