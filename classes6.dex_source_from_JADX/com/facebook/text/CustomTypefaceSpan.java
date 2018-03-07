package com.facebook.text;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* compiled from: deltaMontageMessage */
public class CustomTypefaceSpan extends TypefaceSpan {
    private final Typeface f17598a;
    private final int f17599b;

    public CustomTypefaceSpan(String str, Typeface typeface) {
        this(str, typeface, 0);
    }

    private CustomTypefaceSpan(String str, Typeface typeface, int i) {
        super(str);
        this.f17598a = typeface;
        this.f17599b = i;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTypeface(this.f17598a);
        textPaint.setFlags(textPaint.getFlags() | this.f17599b);
    }

    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTypeface(this.f17598a);
        textPaint.setFlags(textPaint.getFlags() | this.f17599b);
    }
}
