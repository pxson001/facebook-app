package com.facebook.messaging.payment.value.input;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

/* compiled from: extra_cta_clicked */
public class FlyingInCharacterStaticSpan extends ReplacementSpan {
    private final float f15321a;

    public FlyingInCharacterStaticSpan(float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        if (f >= 0.0f) {
            f3 = f;
        }
        if (f3 <= 1.0f) {
            f2 = f3;
        }
        this.f15321a = f2;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        return (int) ((0.7f + (0.3f * this.f15321a)) * paint.measureText(charSequence, i, i2));
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6 = (int) (200.0f - (200.0f * this.f15321a));
        paint.setAlpha((int) (55.0f + (200.0f * this.f15321a)));
        canvas.drawText(charSequence, i, i2, f, (float) (i6 + i4), paint);
    }
}
