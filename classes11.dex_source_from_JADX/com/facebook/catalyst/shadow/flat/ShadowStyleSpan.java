package com.facebook.catalyst.shadow.flat;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* compiled from: lightweight_place_picker_more_places */
public final class ShadowStyleSpan extends CharacterStyle {
    static final ShadowStyleSpan f5807a = new ShadowStyleSpan(0.0f, 0.0f, 0.0f, 0, true);
    public float f5808b;
    public float f5809c;
    public float f5810d;
    public int f5811e;
    public boolean f5812f;

    public ShadowStyleSpan(float f, float f2, float f3, int i, boolean z) {
        this.f5808b = f;
        this.f5809c = f2;
        this.f5810d = f3;
        this.f5811e = i;
        this.f5812f = z;
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f5810d, this.f5808b, this.f5809c, this.f5811e);
    }
}
