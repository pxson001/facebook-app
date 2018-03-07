package com.facebook.widget.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.style.ReplacementSpan;

/* compiled from: com.facebook.imagepipeline.nativecode.WebpTranscoderImpl */
public class FbImageSpan extends ReplacementSpan {
    private final int f5865a;
    private final int f5866b;
    private final int f5867c;
    private final Rect f5868d;
    private final FontMetricsInt f5869e = new FontMetricsInt();
    private final Drawable f5870f;

    /* compiled from: com.facebook.imagepipeline.nativecode.WebpTranscoderImpl */
    public @interface FbImageSpanAlignment {
    }

    public FbImageSpan(Drawable drawable, @FbImageSpanAlignment int i) {
        this.f5870f = drawable;
        this.f5868d = this.f5870f.getBounds();
        this.f5865a = this.f5868d.right - this.f5868d.left;
        this.f5866b = this.f5868d.bottom - this.f5868d.top;
        this.f5867c = i;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt == null) {
            return this.f5865a;
        }
        int a = m10610a(fontMetricsInt);
        int i3 = this.f5866b + a;
        if (a < fontMetricsInt.ascent) {
            fontMetricsInt.ascent = a;
        }
        if (a < fontMetricsInt.top) {
            fontMetricsInt.top = a;
        }
        if (i3 > fontMetricsInt.descent) {
            fontMetricsInt.descent = i3;
        }
        if (i3 > fontMetricsInt.bottom) {
            fontMetricsInt.descent = i3;
        }
        return this.f5865a;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.getFontMetricsInt(this.f5869e);
        int a = m10610a(this.f5869e) + i4;
        canvas.translate(f, (float) a);
        this.f5870f.draw(canvas);
        canvas.translate(-f, (float) (-a));
    }

    private int m10610a(FontMetricsInt fontMetricsInt) {
        switch (this.f5867c) {
            case 0:
                return fontMetricsInt.descent - this.f5866b;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return (((fontMetricsInt.descent - fontMetricsInt.ascent) - this.f5866b) / 2) + fontMetricsInt.ascent;
            default:
                return -this.f5866b;
        }
    }
}
