package com.facebook.common.ui.util;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: should_intercept_delete_post */
public class CombinedDrawable extends Drawable implements Callback {
    private Combine f2751a;
    private Align f2752b;
    private Drawable[] f2753c;
    private int f2754d;
    private int f2755e;
    private int f2756f;

    /* compiled from: should_intercept_delete_post */
    public enum Align {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        CENTER
    }

    /* compiled from: should_intercept_delete_post */
    public enum Combine {
        HORIZONTAL,
        VERTICAL
    }

    public CombinedDrawable(Combine combine, Align align, int i, Drawable... drawableArr) {
        m3867a(combine, align);
        this.f2751a = combine;
        this.f2752b = align;
        this.f2753c = drawableArr;
        this.f2756f = i;
        m3866a();
        for (Drawable drawable : this.f2753c) {
            if (drawable != null) {
                drawable.setCallback(this);
            }
        }
    }

    public int getIntrinsicHeight() {
        return this.f2755e;
    }

    public int getIntrinsicWidth() {
        return this.f2754d;
    }

    public void draw(Canvas canvas) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (this.f2754d != 0 && this.f2755e != 0 && width != 0 && height != 0) {
            double d = ((double) width) / ((double) this.f2754d);
            double d2 = ((double) height) / ((double) this.f2755e);
            double d3 = 0.0d;
            for (Drawable drawable : this.f2753c) {
                if (drawable != null) {
                    double intrinsicWidth = ((double) drawable.getIntrinsicWidth()) * d;
                    double intrinsicHeight = ((double) drawable.getIntrinsicHeight()) * d2;
                    if (!(intrinsicWidth == 0.0d || intrinsicHeight == 0.0d)) {
                        double d4;
                        double d5;
                        double d6;
                        if (this.f2751a == Combine.HORIZONTAL) {
                            d4 = intrinsicWidth + (((double) this.f2756f) * d);
                            intrinsicWidth += d3;
                            d5 = (double) getBounds().top;
                            if (this.f2752b == Align.CENTER) {
                                d5 += (((double) height) - intrinsicHeight) / 2.0d;
                            } else if (this.f2752b == Align.BOTTOM) {
                                d5 += ((double) height) - intrinsicHeight;
                            }
                            d6 = d4;
                            d4 = d3;
                            double d7 = d5;
                            d5 = intrinsicHeight + d5;
                            intrinsicHeight = d7;
                        } else {
                            d4 = intrinsicHeight + (((double) this.f2756f) * d2);
                            intrinsicHeight += d3;
                            d5 = (double) getBounds().left;
                            if (this.f2752b == Align.CENTER) {
                                d5 += (((double) width) - intrinsicWidth) / 2.0d;
                            } else if (this.f2752b == Align.RIGHT) {
                                d5 += ((double) width) - intrinsicWidth;
                            }
                            intrinsicWidth += d5;
                            d6 = d4;
                            d4 = d5;
                            d5 = intrinsicHeight;
                            intrinsicHeight = d3;
                        }
                        d3 += d6;
                        drawable.setBounds((int) d4, (int) intrinsicHeight, (int) intrinsicWidth, (int) d5);
                        drawable.draw(canvas);
                    }
                }
            }
        }
    }

    public int getOpacity() {
        return 0;
    }

    public Drawable mutate() {
        super.mutate();
        for (Drawable drawable : this.f2753c) {
            if (drawable != null) {
                drawable.mutate();
            }
        }
        return this;
    }

    public void setAlpha(int i) {
        for (Drawable drawable : this.f2753c) {
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    public void setChangingConfigurations(int i) {
        for (Drawable drawable : this.f2753c) {
            if (drawable != null) {
                drawable.setChangingConfigurations(i);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        for (Drawable drawable : this.f2753c) {
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setColorFilter(int i, Mode mode) {
        for (Drawable drawable : this.f2753c) {
            if (drawable != null) {
                drawable.setColorFilter(i, mode);
            }
        }
    }

    public void setFilterBitmap(boolean z) {
        for (Drawable drawable : this.f2753c) {
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (Drawable drawable : this.f2753c) {
            if (drawable != null && drawable.setVisible(z, z2)) {
                visible = true;
            }
        }
        return visible;
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

    private static void m3867a(Combine combine, Align align) {
        Object obj = 1;
        if (combine == Combine.HORIZONTAL && (align == Align.LEFT || align == Align.RIGHT)) {
            obj = null;
        }
        if (combine == Combine.VERTICAL && (align == Align.TOP || align == Align.BOTTOM)) {
            obj = null;
        }
        if (obj == null) {
            throw new IllegalArgumentException("Invalid alignment type: " + align + " for given combination option: " + combine);
        }
    }

    private void m3866a() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < this.f2753c.length) {
            Drawable drawable = this.f2753c[i];
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (!(intrinsicWidth == 0 || intrinsicHeight == 0)) {
                    if (intrinsicWidth < 0 || intrinsicHeight < 0) {
                        throw new IllegalArgumentException("Can't combine drawables without intrinsic dimensions.");
                    }
                    int i4 = this.f2751a == Combine.HORIZONTAL ? intrinsicWidth : intrinsicHeight;
                    if (this.f2751a == Combine.HORIZONTAL) {
                        intrinsicWidth = intrinsicHeight;
                    }
                    if (i3 > 0) {
                        i3 += this.f2756f;
                    }
                    i3 += i4;
                    if (intrinsicWidth > i2) {
                        i2 = intrinsicWidth;
                    }
                }
            }
            i++;
        }
        this.f2754d = this.f2751a == Combine.HORIZONTAL ? i3 : i2;
        if (this.f2751a != Combine.HORIZONTAL) {
            i2 = i3;
        }
        this.f2755e = i2;
    }
}
