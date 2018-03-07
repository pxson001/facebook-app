package com.facebook.widget.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;

/* compiled from: com.facebook.home.dev */
public class RoundedBackgroundSpan extends ReplacementSpan {
    private final float f5872a;
    private final float f5873b;
    private final Paint f5874c;
    private final Rect f5875d;
    private final RectF f5876e;
    private final FontMetrics f5877f;
    private float f5878g;
    private Integer f5879h;

    public RoundedBackgroundSpan(float f, float f2, Paint paint) {
        this.f5875d = new Rect();
        this.f5876e = new RectF();
        this.f5877f = new FontMetrics();
        this.f5872a = f;
        this.f5873b = f2;
        this.f5874c = paint;
    }

    private RoundedBackgroundSpan(float f, float f2, int i) {
        this.f5875d = new Rect();
        this.f5876e = new RectF();
        this.f5877f = new FontMetrics();
        this.f5872a = f;
        this.f5873b = f2;
        this.f5874c = new Paint();
        this.f5874c.setColor(i);
    }

    public RoundedBackgroundSpan(float f, float f2, int i, @Nullable Integer num) {
        this(f, f2, i);
        this.f5879h = num;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        paint.getTextBounds(charSequence.toString(), i, i2, this.f5875d);
        this.f5878g = ((float) this.f5875d.width()) + (2.0f * this.f5873b);
        return (int) Math.ceil((double) this.f5878g);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.getFontMetrics(this.f5877f);
        float f2 = (this.f5877f.descent - this.f5877f.ascent) + (2.0f * this.f5872a);
        float f3 = (((float) i4) + this.f5877f.ascent) - this.f5872a;
        this.f5876e.set(f, f3, this.f5878g + f, f3 + f2);
        canvas.drawRoundRect(this.f5876e, f2 / 2.0f, f2 / 2.0f, this.f5874c);
        if (this.f5879h != null) {
            int color = paint.getColor();
            paint.setColor(this.f5879h.intValue());
            canvas.drawText(charSequence, i, i2, f + this.f5873b, (float) i4, paint);
            paint.setColor(color);
            return;
        }
        canvas.drawText(charSequence, i, i2, f + this.f5873b, (float) i4, paint);
    }
}
