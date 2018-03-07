package com.facebook.leadgen.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.BulletSpan;

/* compiled from: photo_reminder_ignored */
public class CustomBulletSpan extends BulletSpan {
    private static Path f6553d = null;
    private final int f6554a;
    private final boolean f6555b = false;
    private final int f6556c = 0;

    public CustomBulletSpan(int i) {
        super(i);
        this.f6554a = i;
    }

    public int getLeadingMargin(boolean z) {
        return this.f6554a + 12;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            int i8 = 0;
            if (this.f6555b) {
                i8 = paint.getColor();
                paint.setColor(this.f6556c);
            }
            paint.setStyle(Style.FILL);
            if (canvas.isHardwareAccelerated()) {
                if (f6553d == null) {
                    Path path = new Path();
                    f6553d = path;
                    path.addCircle(0.0f, 0.0f, 7.2000003f, Direction.CW);
                }
                canvas.save();
                canvas.translate((float) ((i2 * 6) + i), ((float) (i3 + i5)) / 2.0f);
                canvas.drawPath(f6553d, paint);
                canvas.restore();
            } else {
                canvas.drawCircle((float) ((i2 * 6) + i), ((float) (i3 + i5)) / 2.0f, 6.0f, paint);
            }
            if (this.f6555b) {
                paint.setColor(i8);
            }
            paint.setStyle(style);
        }
    }
}
