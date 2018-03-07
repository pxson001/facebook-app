package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

/* compiled from: messaging/%s */
public class ArrayDrawable extends Drawable implements Callback, TransformAwareDrawable, TransformCallback {
    private TransformCallback f14266a;
    private final DrawableProperties f14267b = new DrawableProperties();
    private final Drawable[] f14268c;
    public final DrawableParent[] f14269d;
    private final Rect f14270e = new Rect();
    private boolean f14271f = false;
    private boolean f14272g = false;
    private boolean f14273h = false;

    /* compiled from: messaging/%s */
    public class C06031 implements DrawableParent {
        final /* synthetic */ int f14449a;
        final /* synthetic */ ArrayDrawable f14450b;

        public C06031(ArrayDrawable arrayDrawable, int i) {
            this.f14450b = arrayDrawable;
            this.f14449a = i;
        }

        public final Drawable mo2740a(Drawable drawable) {
            return this.f14450b.m20668a(this.f14449a, drawable);
        }

        public final Drawable mo2739a() {
            return this.f14450b.m20667a(this.f14449a);
        }
    }

    public ArrayDrawable(Drawable[] drawableArr) {
        int i = 0;
        Preconditions.a(drawableArr);
        this.f14268c = drawableArr;
        while (i < this.f14268c.length) {
            DrawableUtils.m20639a(this.f14268c[i], this, this);
            i++;
        }
        this.f14269d = new DrawableParent[this.f14268c.length];
    }

    public final int m20666a() {
        return this.f14268c.length;
    }

    @Nullable
    public final Drawable m20667a(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (i >= this.f14268c.length) {
            z2 = false;
        }
        Preconditions.a(z2);
        return this.f14268c[i];
    }

    @Nullable
    public final Drawable m20668a(int i, @Nullable Drawable drawable) {
        boolean z = true;
        Preconditions.a(i >= 0);
        if (i >= this.f14268c.length) {
            z = false;
        }
        Preconditions.a(z);
        Drawable drawable2 = this.f14268c[i];
        if (drawable != drawable2) {
            if (drawable != null && this.f14273h) {
                drawable.mutate();
            }
            DrawableUtils.m20639a(this.f14268c[i], null, null);
            DrawableUtils.m20639a(drawable, null, null);
            DrawableUtils.m20641a(drawable, this.f14267b);
            DrawableUtils.m20640a(drawable, (Drawable) this);
            DrawableUtils.m20639a(drawable, this, this);
            this.f14272g = false;
            this.f14268c[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    public int getIntrinsicWidth() {
        int i = -1;
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                i = Math.max(i, drawable.getIntrinsicWidth());
            }
        }
        return i > 0 ? i : -1;
    }

    public int getIntrinsicHeight() {
        int i = -1;
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                i = Math.max(i, drawable.getIntrinsicHeight());
            }
        }
        return i > 0 ? i : -1;
    }

    protected void onBoundsChange(Rect rect) {
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    public boolean isStateful() {
        if (!this.f14272g) {
            this.f14271f = false;
            for (Drawable drawable : this.f14268c) {
                int i;
                boolean z = this.f14271f;
                if (drawable == null || !drawable.isStateful()) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.f14271f = i | z;
            }
            this.f14272g = true;
        }
        return this.f14271f;
    }

    protected boolean onStateChange(int[] iArr) {
        int i = 0;
        boolean z = false;
        while (i < this.f14268c.length) {
            Drawable drawable = this.f14268c[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    protected boolean onLevelChange(int i) {
        int i2 = 0;
        boolean z = false;
        while (i2 < this.f14268c.length) {
            Drawable drawable = this.f14268c[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
            i2++;
        }
        return z;
    }

    public void draw(Canvas canvas) {
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    public boolean getPadding(Rect rect) {
        int i = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.f14270e;
        while (i < this.f14268c.length) {
            Drawable drawable = this.f14268c[i];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i++;
        }
        return true;
    }

    public Drawable mutate() {
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.f14273h = true;
        return this;
    }

    public int getOpacity() {
        if (this.f14268c.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.f14268c.length; i2++) {
            Drawable drawable = this.f14268c[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    public void setAlpha(int i) {
        this.f14267b.f14244a = i;
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f14267b.m20635a(colorFilter);
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        this.f14267b.m20636a(z);
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setFilterBitmap(boolean z) {
        this.f14267b.m20637b(z);
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.setVisible(z, z2);
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

    public final void mo2743a(TransformCallback transformCallback) {
        this.f14266a = transformCallback;
    }

    public final void mo2741a(Matrix matrix) {
        if (this.f14266a != null) {
            this.f14266a.mo2741a(matrix);
        } else {
            matrix.reset();
        }
    }

    public final void mo2742a(RectF rectF) {
        if (this.f14266a != null) {
            this.f14266a.mo2742a(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (Drawable drawable : this.f14268c) {
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
