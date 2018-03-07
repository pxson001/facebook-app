package com.facebook.events.dashboard;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: composer/?link={%s} */
public class DateSpan extends MetricAffectingSpan {
    private final Typeface f16495a;
    private final int f16496b;
    private final int f16497c;

    public DateSpan(Typeface typeface, int i, int i2) {
        this.f16495a = typeface;
        this.f16496b = i;
        this.f16497c = i2;
    }

    public void updateDrawState(TextPaint textPaint) {
        m16924a(textPaint, this.f16495a, this.f16496b, this.f16497c);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m16924a(textPaint, this.f16495a, this.f16496b, this.f16497c);
    }

    private static void m16924a(Paint paint, Typeface typeface, int i, int i2) {
        int i3;
        Typeface typeface2 = paint.getTypeface();
        if (typeface2 == null) {
            i3 = 0;
        } else {
            i3 = typeface2.getStyle();
        }
        if (typeface == null) {
            Typeface.create(typeface, i2);
        }
        i3 &= typeface.getStyle() ^ -1;
        if ((i3 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i3 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
        if (i > 0) {
            paint.setTextSize((float) i);
        }
    }
}
