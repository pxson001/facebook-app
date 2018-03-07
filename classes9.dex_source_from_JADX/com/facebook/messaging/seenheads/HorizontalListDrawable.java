package com.facebook.messaging.seenheads;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: delete_threads */
public class HorizontalListDrawable extends Drawable implements Callback {
    public final Rect f16625a = new Rect();
    private Drawable[] f16626b;
    private int f16627c;

    public final void m16633a(Drawable[] drawableArr) {
        this.f16626b = drawableArr;
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setCallback(this);
            }
        }
        invalidateSelf();
    }

    public final void m16632a(int i) {
        this.f16627c = i;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.f16625a.left + bounds.left;
        Drawable[] drawableArr = this.f16626b;
        int length = drawableArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3;
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = bounds.top + this.f16625a.top;
                int i4 = bounds.bottom - this.f16625a.bottom;
                int i5 = i4 - i3;
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (i5 > intrinsicHeight) {
                    i3 += (i5 - intrinsicHeight) / 2;
                }
                drawable.setBounds(i, i3, drawable.getIntrinsicWidth() + i, i4);
                drawable.draw(canvas);
                i3 = (drawable.getIntrinsicWidth() + this.f16627c) + i;
            } else {
                i3 = i;
            }
            i2++;
            i = i3;
        }
    }

    public int getIntrinsicWidth() {
        int i = 0;
        for (Drawable drawable : this.f16626b) {
            if (drawable != null) {
                i += drawable.getIntrinsicWidth() + this.f16627c;
            }
        }
        if (i > 0) {
            i -= this.f16627c;
        }
        return (i + this.f16625a.left) + this.f16625a.right;
    }

    public int getIntrinsicHeight() {
        int i = 0;
        for (Drawable drawable : this.f16626b) {
            if (drawable != null) {
                i = Math.max(drawable.getIntrinsicHeight(), i);
            }
        }
        return (i + this.f16625a.top) + this.f16625a.bottom;
    }

    public void setAlpha(int i) {
        for (Drawable drawable : this.f16626b) {
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        for (Drawable drawable : this.f16626b) {
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public int getOpacity() {
        int i = 0;
        for (Drawable drawable : this.f16626b) {
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
