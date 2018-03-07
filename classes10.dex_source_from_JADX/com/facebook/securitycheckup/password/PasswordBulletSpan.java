package com.facebook.securitycheckup.password;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.BulletSpan;

/* compiled from: http_akamai */
public class PasswordBulletSpan extends BulletSpan {
    private static Path f9865e = null;
    private final int f9866a;
    private final boolean f9867b = false;
    private final int f9868c = 0;
    private final int f9869d;

    public PasswordBulletSpan(int i, int i2) {
        super(i);
        this.f9866a = i;
        this.f9869d = i2;
    }

    public int getLeadingMargin(boolean z) {
        return (this.f9869d * 2) + this.f9866a;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            int i8 = 0;
            if (this.f9867b) {
                i8 = paint.getColor();
                paint.setColor(this.f9868c);
            }
            paint.setStyle(Style.FILL);
            if (canvas.isHardwareAccelerated()) {
                if (f9865e == null) {
                    Path path = new Path();
                    f9865e = path;
                    path.addCircle(0.0f, 0.0f, 1.2f * ((float) this.f9869d), Direction.CW);
                }
                canvas.save();
                canvas.translate((float) (((this.f9869d * i2) * 2) + i), (((float) (i3 + i5)) / 2.0f) - ((float) this.f9869d));
                canvas.drawPath(f9865e, paint);
                canvas.restore();
            } else {
                canvas.drawCircle((float) (((this.f9869d * i2) * 2) + i), (((float) (i3 + i5)) / 2.0f) - ((float) this.f9869d), (float) this.f9869d, paint);
            }
            if (this.f9867b) {
                paint.setColor(i8);
            }
            paint.setStyle(style);
        }
    }
}
