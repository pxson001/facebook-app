package com.facebook.events.permalink.guestlist;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* compiled from: blockUserParams */
public class SeenCheckmarkImageSpan extends ImageSpan {
    private int f18519a;

    public SeenCheckmarkImageSpan(Drawable drawable, int i) {
        super(drawable);
        this.f18519a = i;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate(f, (float) (((this.f18519a + i4) / 2) - (drawable.getBounds().height() / 2)));
        drawable.draw(canvas);
        canvas.restore();
    }
}
