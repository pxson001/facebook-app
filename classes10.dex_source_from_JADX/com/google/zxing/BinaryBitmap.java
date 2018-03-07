package com.google.zxing;

import com.google.zxing.common.BitMatrix;

/* compiled from: events_creation_prefill_theme_id */
public final class BinaryBitmap {
    private final Binarizer f13450a;
    private BitMatrix f13451b;

    public BinaryBitmap(Binarizer binarizer) {
        if (binarizer == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f13450a = binarizer;
    }

    public final BitMatrix m13649a() {
        if (this.f13451b == null) {
            this.f13451b = this.f13450a.mo681b();
        }
        return this.f13451b;
    }
}
