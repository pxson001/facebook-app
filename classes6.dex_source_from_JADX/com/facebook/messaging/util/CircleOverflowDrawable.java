package com.facebook.messaging.util;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: totalHasStableIds */
public class CircleOverflowDrawable extends Drawable {
    private final CircleOverflowRenderer f2827a;
    private int f2828b;

    public CircleOverflowDrawable(CircleOverflowRenderer circleOverflowRenderer) {
        this.f2827a = circleOverflowRenderer;
    }

    public final void m3947a(int i) {
        this.f2828b = i;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.f2827a.m3949a(canvas, this.f2828b, bounds.left, bounds.top);
    }

    public int getIntrinsicWidth() {
        return this.f2827a.f2838d;
    }

    public int getIntrinsicHeight() {
        return this.f2827a.f2838d;
    }

    public void setAlpha(int i) {
        CircleOverflowRenderer circleOverflowRenderer = this.f2827a;
        circleOverflowRenderer.f2836b.setAlpha(i);
        circleOverflowRenderer.f2837c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        CircleOverflowRenderer circleOverflowRenderer = this.f2827a;
        circleOverflowRenderer.f2836b.setColorFilter(colorFilter);
        circleOverflowRenderer.f2837c.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        int i;
        switch (this.f2827a.f2837c.getAlpha()) {
            case 0:
                i = -2;
                break;
            case 255:
                i = -1;
                break;
            default:
                i = -3;
                break;
        }
        return i;
    }
}
