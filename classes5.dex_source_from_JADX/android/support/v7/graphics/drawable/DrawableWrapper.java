package android.support.v7.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.graphics.drawable.DrawableCompat;

/* compiled from: viewer_recommendation */
public class DrawableWrapper extends Drawable implements Callback {
    public Drawable f653a;

    public DrawableWrapper(Drawable drawable) {
        if (this.f653a != null) {
            this.f653a.setCallback(null);
        }
        this.f653a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f653a.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f653a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f653a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f653a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f653a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f653a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f653a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f653a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f653a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f653a.setState(iArr);
    }

    public int[] getState() {
        return this.f653a.getState();
    }

    public void jumpToCurrentState() {
        DrawableCompat.a(this.f653a);
    }

    public Drawable getCurrent() {
        return this.f653a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f653a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f653a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f653a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f653a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f653a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f653a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f653a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f653a.getPadding(rect);
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

    protected boolean onLevelChange(int i) {
        return this.f653a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.a(this.f653a, z);
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.a.b(this.f653a);
    }

    public void setTint(int i) {
        DrawableCompat.a(this.f653a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.a(this.f653a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        DrawableCompat.a(this.f653a, mode);
    }

    public void setHotspot(float f, float f2) {
        DrawableCompat.a(this.f653a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        DrawableCompat.a(this.f653a, i, i2, i3, i4);
    }
}
