package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* compiled from: event_guest_list */
public final class AlignmentPattern extends ResultPoint {
    public final float f13554a;

    AlignmentPattern(float f, float f2, float f3) {
        super(f, f2);
        this.f13554a = f3;
    }

    final AlignmentPattern m13779b(float f, float f2, float f3) {
        return new AlignmentPattern((this.f13473a + f2) / 2.0f, (this.f13474b + f) / 2.0f, (this.f13554a + f3) / 2.0f);
    }
}
