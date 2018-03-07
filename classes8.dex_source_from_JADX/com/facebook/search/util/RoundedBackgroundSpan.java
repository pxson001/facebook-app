package com.facebook.search.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/* compiled from: mentioned_ids */
public class RoundedBackgroundSpan extends ReplacementSpan {
    private final float f8917a;
    private final int f8918b;
    private final int f8919c;
    private final float f8920d;
    private final float f8921e;
    private final FontMetrics f8922f = new FontMetrics();

    /* compiled from: mentioned_ids */
    public class Builder {
        public float f8912a = 4.0f;
        public int f8913b = 16777215;
        public int f8914c = 0;
        public float f8915d = 3.0f;
        public float f8916e = 10.0f;
    }

    public RoundedBackgroundSpan(float f, int i, int i2, float f2, float f3) {
        this.f8917a = f;
        this.f8918b = i;
        this.f8919c = i2;
        this.f8920d = f2;
        this.f8921e = f3;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.getFontMetrics(this.f8922f);
        int i6 = i4 + 4;
        float f2 = (this.f8922f.descent - this.f8922f.ascent) + (2.0f * this.f8920d);
        float f3 = ((float) i6) - f2;
        float f4 = (((float) i6) - this.f8922f.descent) - this.f8920d;
        RectF rectF = new RectF(f, f3, m10656a(paint, charSequence, i, i2) + f, f2 + f3);
        paint.setColor(this.f8918b);
        canvas.drawRoundRect(rectF, this.f8917a, this.f8917a, paint);
        paint.setColor(this.f8919c);
        canvas.drawText(charSequence, i, i2, f + this.f8921e, f4, paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        return (int) Math.ceil((double) m10656a(paint, charSequence, i, i2));
    }

    private float m10656a(Paint paint, CharSequence charSequence, int i, int i2) {
        return paint.measureText(charSequence, i, i2) + (2.0f * this.f8921e);
    }
}
