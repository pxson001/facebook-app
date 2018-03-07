package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: viewer_readstate */
public class DrawableWrapperDonut extends Drawable implements Callback, DrawableWrapper {
    static final Mode f224a = Mode.SRC_IN;
    Drawable f225b;
    private ColorStateList f226c;
    private Mode f227d = f224a;
    private int f228e = Integer.MIN_VALUE;

    DrawableWrapperDonut(Drawable drawable) {
        m256a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f225b.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f225b.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f225b.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f225b.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f225b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f225b.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f225b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f225b.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return (this.f226c != null && this.f226c.isStateful()) || this.f225b.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m257a(iArr) || this.f225b.setState(iArr);
    }

    public int[] getState() {
        return this.f225b.getState();
    }

    public Drawable getCurrent() {
        return this.f225b.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f225b.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f225b.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f225b.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f225b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f225b.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f225b.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f225b.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f225b.getPadding(rect);
    }

    public Drawable mutate() {
        Drawable drawable = this.f225b;
        Drawable mutate = drawable.mutate();
        if (mutate != drawable) {
            m256a(mutate);
        }
        return this;
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
        return this.f225b.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f226c = colorStateList;
        m257a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f227d = mode;
        m257a(getState());
    }

    private boolean m257a(int[] iArr) {
        if (!(this.f226c == null || this.f227d == null)) {
            int colorForState = this.f226c.getColorForState(iArr, this.f226c.getDefaultColor());
            if (colorForState != this.f228e) {
                setColorFilter(colorForState, this.f227d);
                this.f228e = colorForState;
                return true;
            }
        }
        return false;
    }

    private void m256a(Drawable drawable) {
        if (this.f225b != null) {
            this.f225b.setCallback(null);
        }
        this.f225b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidateSelf();
    }
}
