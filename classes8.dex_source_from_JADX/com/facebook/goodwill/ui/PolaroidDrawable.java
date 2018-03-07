package com.facebook.goodwill.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* compiled from: fallback_feed_style */
public class PolaroidDrawable extends Drawable {
    public final Resources f13811a;
    private final LayerDrawable f13812b;
    private Drawable f13813c;
    private float f13814d;
    private int f13815e;
    private int f13816f;
    private int f13817g;
    private boolean f13818h;

    public PolaroidDrawable(Resources resources, int i, int i2, int i3, boolean z) {
        this.f13811a = resources;
        this.f13815e = i;
        this.f13816f = i2;
        this.f13817g = i3;
        this.f13818h = z;
        this.f13812b = (LayerDrawable) resources.getDrawable(2130843603);
        this.f13813c = new ColorDrawable(resources.getColor(2131363698));
    }

    public PolaroidDrawable(Resources resources, int i, int i2, int i3) {
        this(resources, i, i2, i3, true);
    }

    public void setAlpha(int i) {
        throw new UnsupportedOperationException("If you need this, implement it");
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f13814d, (float) bounds.centerX(), (float) bounds.centerY());
        this.f13812b.setBounds(bounds);
        this.f13813c.setBounds(bounds.left + this.f13815e, bounds.top + this.f13815e, bounds.right - this.f13815e, bounds.bottom - this.f13816f);
        try {
            if (this.f13818h) {
                this.f13812b.draw(canvas);
            }
            this.f13813c.draw(canvas);
        } catch (RuntimeException e) {
        }
        canvas.restore();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("If you need this, implement it");
    }

    public int getOpacity() {
        return -1;
    }

    public final void m15460a(float f) {
        if (f != this.f13814d) {
            this.f13814d = f;
            invalidateSelf();
        }
    }

    public final void m15463a(Drawable drawable) {
        this.f13813c = drawable;
        this.f13812b.invalidateSelf();
    }

    public final void m15461a(int i) {
        if (i != this.f13815e) {
            this.f13815e = i;
            invalidateSelf();
        }
    }

    public final void m15464b(int i) {
        if (i != this.f13816f) {
            this.f13816f = i;
            invalidateSelf();
        }
    }

    public final void m15465c(int i) {
        if (i != this.f13817g) {
            this.f13817g = i;
            invalidateSelf();
        }
    }

    public int getIntrinsicHeight() {
        return (this.f13817g + this.f13815e) + this.f13816f;
    }

    public int getIntrinsicWidth() {
        return this.f13817g + (this.f13815e * 2);
    }

    public final void m15462a(int i, int i2) {
        setBounds(i, i2, getIntrinsicWidth() + i, getIntrinsicHeight() + i2);
    }
}
