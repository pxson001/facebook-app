package com.facebook.react.views.text;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* compiled from: lightweight_place_picker_more_places */
public class ShadowStyleSpan extends CharacterStyle {
    private final float f11553a;
    private final float f11554b;
    private final float f11555c;
    private final int f11556d;

    public ShadowStyleSpan(float f, float f2, float f3, int i) {
        this.f11553a = f;
        this.f11554b = f2;
        this.f11555c = f3;
        this.f11556d = i;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f11555c, this.f11553a, this.f11554b, this.f11556d);
    }
}
