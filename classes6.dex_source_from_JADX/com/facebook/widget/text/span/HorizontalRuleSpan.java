package com.facebook.widget.text.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

/* compiled from: com.google.android.gms.location.internal.IGeofencerCallbacks */
public class HorizontalRuleSpan extends ReplacementSpan {
    private int f19895a = -7829368;

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            fontMetricsInt.top = -3;
            fontMetricsInt.ascent = -3;
            fontMetricsInt.bottom = 3;
            fontMetricsInt.descent = 3;
        }
        return (int) paint.measureText(charSequence, i, i2);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int color = paint.getColor();
        float strokeWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(3.0f);
        paint.setColor(this.f19895a);
        int i6 = (i5 + i3) / 2;
        float f2 = (float) i6;
        canvas.drawLine(0.0f, (float) i6, (float) canvas.getWidth(), f2, paint);
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);
    }
}
