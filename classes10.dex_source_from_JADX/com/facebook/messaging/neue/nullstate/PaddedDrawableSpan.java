package com.facebook.messaging.neue.nullstate;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;

/* compiled from: richtext_link_click */
public class PaddedDrawableSpan extends DynamicDrawableSpan {
    private final int f3351a;
    private final int f3352b;
    private final Drawable f3353c;

    public PaddedDrawableSpan(Drawable drawable, int i, int i2) {
        this.f3353c = drawable;
        this.f3351a = i;
        this.f3352b = i2;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        super.draw(canvas, charSequence, i, i2, f + ((float) this.f3351a), i3, i4, i5, paint);
    }

    public Drawable getDrawable() {
        return this.f3353c;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        return (super.getSize(paint, charSequence, i, i2, fontMetricsInt) + this.f3351a) + this.f3352b;
    }
}
