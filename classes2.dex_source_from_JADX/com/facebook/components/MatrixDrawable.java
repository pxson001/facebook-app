package com.facebook.components;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: graph.secure */
public class MatrixDrawable extends Drawable implements Callback, Touchable {
    public Drawable f23012a;
    private DrawableMatrix f23013b;
    private boolean f23014c;

    public final void m31143a(Drawable drawable, DrawableMatrix drawableMatrix) {
        if (this.f23012a != drawable) {
            boolean z;
            if (this.f23012a != null) {
                this.f23012a.setCallback(null);
            }
            this.f23012a = drawable;
            if (this.f23012a != null) {
                this.f23012a.setCallback(this);
            }
            this.f23013b = drawableMatrix;
            if ((this.f23013b == null || !this.f23013b.f23010a) && ((VERSION.SDK_INT >= 11 || !(this.f23012a instanceof ColorDrawable)) && !(this.f23012a instanceof InsetDrawable))) {
                z = false;
            } else {
                z = true;
            }
            this.f23014c = z;
            invalidateSelf();
        }
    }

    public final void m31142a(int i, int i2) {
        int i3 = 0;
        if (this.f23012a != null) {
            Rect bounds = getBounds();
            int i4 = this.f23013b != null ? 0 : bounds.left;
            if (this.f23013b == null) {
                i3 = bounds.top;
            }
            this.f23012a.setBounds(i4, i3, i4 + i, i3 + i2);
        }
    }

    public final void m31141a() {
        if (this.f23012a != null) {
            this.f23012a.setCallback(null);
        }
        this.f23012a = null;
        this.f23013b = null;
        this.f23014c = false;
    }

    public void draw(Canvas canvas) {
        if (this.f23012a != null) {
            Rect bounds = getBounds();
            if (this.f23013b != null) {
                int save = canvas.save();
                if (this.f23014c) {
                    canvas.clipRect(bounds);
                }
                canvas.translate((float) bounds.left, (float) bounds.top);
                canvas.concat(this.f23013b);
                this.f23012a.draw(canvas);
                canvas.restoreToCount(save);
                return;
            }
            if (this.f23014c) {
                canvas.save();
                canvas.clipRect(bounds);
            }
            this.f23012a.draw(canvas);
            if (this.f23014c) {
                canvas.restore();
            }
        }
    }

    public void setChangingConfigurations(int i) {
        if (this.f23012a != null) {
            this.f23012a.setChangingConfigurations(i);
        }
    }

    public int getChangingConfigurations() {
        return this.f23012a == null ? -1 : this.f23012a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        if (this.f23012a != null) {
            this.f23012a.setDither(z);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f23012a != null) {
            this.f23012a.setFilterBitmap(z);
        }
    }

    public void setAlpha(int i) {
        if (this.f23012a != null) {
            this.f23012a.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f23012a != null) {
            this.f23012a.setColorFilter(colorFilter);
        }
    }

    public boolean isStateful() {
        return this.f23012a != null && this.f23012a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f23012a != null && this.f23012a.setState(iArr);
    }

    public int[] getState() {
        return this.f23012a == null ? null : this.f23012a.getState();
    }

    public Drawable getCurrent() {
        return this.f23012a == null ? null : this.f23012a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || (this.f23012a != null && this.f23012a.setVisible(z, z2));
    }

    public int getOpacity() {
        return this.f23012a == null ? -1 : this.f23012a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f23012a == null ? null : this.f23012a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f23012a == null ? -1 : this.f23012a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f23012a == null ? -1 : this.f23012a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f23012a == null ? -1 : this.f23012a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f23012a == null ? -1 : this.f23012a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f23012a != null && this.f23012a.getPadding(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f23012a != null && this.f23012a.setLevel(i);
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

    @TargetApi(21)
    public final boolean mo3376a(MotionEvent motionEvent, View view) {
        Rect bounds = getBounds();
        this.f23012a.setHotspot((float) (((int) motionEvent.getX()) - bounds.left), (float) (((int) motionEvent.getY()) - bounds.top));
        return false;
    }

    public final boolean mo3375a(MotionEvent motionEvent) {
        return VERSION.SDK_INT >= 21 && this.f23012a != null && (this.f23012a instanceof RippleDrawable) && motionEvent.getActionMasked() == 0 && getBounds().contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }
}
