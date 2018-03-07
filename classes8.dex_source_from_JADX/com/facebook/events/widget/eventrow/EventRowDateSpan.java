package com.facebook.events.widget.eventrow;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: header_decorative_image */
public class EventRowDateSpan extends MetricAffectingSpan {
    private final Typeface f11484a;
    private final int f11485b;
    private final int f11486c;

    public EventRowDateSpan(Typeface typeface, int i, int i2) {
        this.f11484a = typeface;
        this.f11485b = i;
        this.f11486c = i2;
    }

    public void updateDrawState(TextPaint textPaint) {
        m13412a(textPaint, this.f11484a, this.f11485b, this.f11486c);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m13412a(textPaint, this.f11484a, this.f11485b, this.f11486c);
    }

    private static void m13412a(Paint paint, Typeface typeface, int i, int i2) {
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
