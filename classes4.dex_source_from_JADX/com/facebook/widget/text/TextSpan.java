package com.facebook.widget.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

/* compiled from: ndid */
public class TextSpan extends ReplacementSpan {
    private final TextPaint f7271a;
    private final Rect f7272b = new Rect();
    private final int f7273c;
    private int f7274d;

    public TextSpan(TextPaint textPaint, int i) {
        this.f7271a = textPaint;
        this.f7273c = i;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        paint.getTextBounds(charSequence.toString(), i, i2, this.f7272b);
        return this.f7272b.width();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        this.f7274d = this.f7271a.getColor();
        this.f7271a.setColor(this.f7273c);
        canvas.drawText(charSequence, i, i2, f, (float) i4, this.f7271a);
        this.f7271a.setColor(this.f7274d);
    }
}
