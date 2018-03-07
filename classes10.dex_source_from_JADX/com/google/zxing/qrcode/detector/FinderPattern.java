package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* compiled from: event_edit_composer */
public final class FinderPattern extends ResultPoint {
    public final float f13566a;
    public int f13567b;

    FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private FinderPattern(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f13566a = f3;
        this.f13567b = i;
    }

    final FinderPattern m13795b(float f, float f2, float f3) {
        int i = this.f13567b + 1;
        return new FinderPattern(((((float) this.f13567b) * this.f13473a) + f2) / ((float) i), ((((float) this.f13567b) * this.f13474b) + f) / ((float) i), ((((float) this.f13567b) * this.f13566a) + f3) / ((float) i), i);
    }
}
