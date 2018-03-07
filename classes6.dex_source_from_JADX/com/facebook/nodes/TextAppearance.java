package com.facebook.nodes;

import android.graphics.Typeface;
import android.text.TextPaint;

/* compiled from: thread_message_lifetime */
public abstract class TextAppearance {
    public static TextPaint m4192a(int i, int i2, int i3, int i4, int i5, float f, float f2, float f3) {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(i);
        textPaint.setTextSize((float) i2);
        if (i3 >= 0) {
            textPaint.setTypeface(Typeface.defaultFromStyle(i3));
        }
        textPaint.linkColor = i4;
        if (i5 != 0) {
            textPaint.setShadowLayer(f3, f, f2, i5);
        }
        return textPaint;
    }
}
