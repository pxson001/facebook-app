package com.facebook.drawee.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import com.facebook.drawee.view.DraweeHolder;

/* compiled from: office_location */
public class DraweeSpan extends DynamicDrawableSpan {
    public final DraweeHolder f8884a;

    public DraweeSpan(DraweeHolder draweeHolder, int i) {
        super(i);
        this.f8884a = draweeHolder;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.f8884a.b) {
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        }
    }

    public Drawable getDrawable() {
        return this.f8884a.h();
    }
}
