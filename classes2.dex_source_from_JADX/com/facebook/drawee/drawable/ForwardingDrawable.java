package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: messaging/thread/thread?id=%s */
public class ForwardingDrawable extends Drawable implements Callback, DrawableParent, TransformAwareDrawable, TransformCallback {
    private static final Matrix f14241d = new Matrix();
    public Drawable f14242a;
    protected TransformCallback b_;
    public final DrawableProperties f14243c = new DrawableProperties();

    public ForwardingDrawable(Drawable drawable) {
        this.f14242a = drawable;
        DrawableUtils.m20639a(this.f14242a, this, this);
    }

    public Drawable mo2744b(Drawable drawable) {
        Drawable drawable2 = this.f14242a;
        DrawableUtils.m20639a(drawable2, null, null);
        DrawableUtils.m20639a(drawable, null, null);
        DrawableUtils.m20641a(drawable, this.f14243c);
        DrawableUtils.m20640a(drawable, (Drawable) this);
        DrawableUtils.m20639a(drawable, this, this);
        this.f14242a = drawable;
        Drawable drawable3 = drawable2;
        invalidateSelf();
        return drawable3;
    }

    public int getOpacity() {
        return this.f14242a.getOpacity();
    }

    public void setAlpha(int i) {
        this.f14243c.f14244a = i;
        this.f14242a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f14243c.m20635a(colorFilter);
        this.f14242a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f14243c.m20636a(z);
        this.f14242a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f14243c.m20637b(z);
        this.f14242a.setFilterBitmap(z);
    }

    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.f14242a.setVisible(z, z2);
    }

    protected void onBoundsChange(Rect rect) {
        this.f14242a.setBounds(rect);
    }

    public boolean isStateful() {
        return this.f14242a.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        return this.f14242a.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        return this.f14242a.setLevel(i);
    }

    public void draw(Canvas canvas) {
        this.f14242a.draw(canvas);
    }

    public int getIntrinsicWidth() {
        return this.f14242a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f14242a.getIntrinsicHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f14242a.getPadding(rect);
    }

    public Drawable mutate() {
        this.f14242a.mutate();
        return this;
    }

    public Drawable getCurrent() {
        return this.f14242a;
    }

    public final Drawable mo2740a(Drawable drawable) {
        return mo2744b(drawable);
    }

    public final Drawable mo2739a() {
        return getCurrent();
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

    public final void mo2743a(TransformCallback transformCallback) {
        this.b_ = transformCallback;
    }

    protected final void m20628b(Matrix matrix) {
        if (this.b_ != null) {
            this.b_.mo2741a(matrix);
        } else {
            matrix.reset();
        }
    }

    public void mo2741a(Matrix matrix) {
        m20628b(matrix);
    }

    public final void mo2742a(RectF rectF) {
        if (this.b_ != null) {
            this.b_.mo2742a(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public final void m20629b(RectF rectF) {
        m20628b(f14241d);
        rectF.set(getBounds());
        f14241d.mapRect(rectF);
    }

    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        this.f14242a.setHotspot(f, f2);
    }
}
