package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

/* compiled from: [TE; */
public class LightBitmapDrawable extends Drawable {
    @Nullable
    public Bitmap f11897a;
    private int f11898b;
    private int f11899c;
    private int f11900d;
    public final Paint f11901e;

    public LightBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(resources, bitmap, null);
    }

    public LightBitmapDrawable(Resources resources, Bitmap bitmap, Paint paint) {
        this.f11897a = null;
        this.f11898b = 160;
        this.f11901e = new Paint(6);
        if (paint != null) {
            this.f11901e.set(paint);
        }
        this.f11897a = bitmap;
        this.f11898b = resources.getDisplayMetrics().densityDpi;
        m19946c();
    }

    private void m19946c() {
        if (this.f11897a != null) {
            this.f11899c = this.f11897a.getScaledWidth(this.f11898b);
            this.f11900d = this.f11897a.getScaledHeight(this.f11898b);
            return;
        }
        this.f11900d = -1;
        this.f11899c = -1;
    }

    public final void m19947a(Bitmap bitmap) {
        if (this.f11897a != bitmap) {
            this.f11897a = bitmap;
            m19946c();
            invalidateSelf();
        }
    }

    public void setFilterBitmap(boolean z) {
        this.f11901e.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f11901e.setDither(z);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (this.f11897a != null) {
            canvas.drawBitmap(this.f11897a, null, getBounds(), this.f11901e);
        }
    }

    public void setAlpha(int i) {
        if (i != this.f11901e.getAlpha()) {
            this.f11901e.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f11901e.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11901e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.f11901e.getColorFilter();
    }

    public int getIntrinsicWidth() {
        return this.f11899c;
    }

    public int getIntrinsicHeight() {
        return this.f11900d;
    }

    public int getOpacity() {
        return (this.f11897a == null || this.f11897a.hasAlpha() || this.f11901e.getAlpha() < 255) ? -3 : -1;
    }
}
