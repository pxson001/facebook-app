package com.facebook.widget.text.span;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* compiled from: com.google.android.gms.location.internal.IFusedLocationProviderCallback */
public class ListSpan extends FbMarginSpan {
    public static int f19896c = 0;
    public static int f19897d = 1;
    private float f19898e;
    private int f19899f;
    public int f19900g;
    public int f19901h;

    public ListSpan() {
        this(Resources.getSystem().getDisplayMetrics());
    }

    private ListSpan(DisplayMetrics displayMetrics) {
        super(displayMetrics);
        this.f19899f = -7829368;
        this.f19900g = f19896c;
        this.f19898e = TypedValue.applyDimension(2, 3.0f, displayMetrics);
    }

    public final FbMarginSpan mo1506a(int i) {
        this.f19899f = i;
        return this;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            int color = paint.getColor();
            Style style = paint.getStyle();
            paint.setColor(this.f19899f);
            paint.setStyle(Style.FILL);
            if (this.f19900g == f19897d) {
                canvas.drawText((this.f19901h < 10 ? " " : "") + this.f19901h + ".", (float) i, (float) i4, paint);
            } else {
                canvas.drawCircle(((float) i) + ((((float) i2) * this.f19889a) / 2.0f), ((float) (i3 + i5)) / 2.0f, this.f19898e, paint);
            }
            paint.setColor(color);
            paint.setStyle(style);
        }
    }
}
