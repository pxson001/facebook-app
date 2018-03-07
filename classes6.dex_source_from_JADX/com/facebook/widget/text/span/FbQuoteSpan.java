package com.facebook.widget.text.span;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* compiled from: com.google.android.gms.location.internal.ISettingsCallbacks */
public class FbQuoteSpan extends FbMarginSpan {
    private float f19891c;

    public FbQuoteSpan() {
        this(Resources.getSystem().getDisplayMetrics());
    }

    private FbQuoteSpan(DisplayMetrics displayMetrics) {
        super(displayMetrics);
        this.f19891c = TypedValue.applyDimension(2, 4.0f, displayMetrics);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int color = paint.getColor();
        Style style = paint.getStyle();
        paint.setColor(this.f19890b);
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) i, (float) i3, this.f19891c + ((float) i), (float) i5, paint);
        paint.setStyle(style);
        paint.setColor(color);
    }
}
