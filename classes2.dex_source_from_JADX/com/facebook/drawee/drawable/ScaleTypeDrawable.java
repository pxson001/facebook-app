package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

/* compiled from: messaging/compose/ */
public class ScaleTypeDrawable extends ForwardingDrawable {
    @VisibleForTesting
    public ScalingUtils$ScaleType f14250a;
    @VisibleForTesting
    Object f14251c;
    @VisibleForTesting
    PointF f14252d = null;
    @VisibleForTesting
    int f14253e = 0;
    @VisibleForTesting
    int f14254f = 0;
    @VisibleForTesting
    Matrix f14255g;
    private Matrix f14256h = new Matrix();

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        super((Drawable) Preconditions.a(drawable));
        this.f14250a = scalingUtils$ScaleType;
    }

    public final Drawable mo2744b(Drawable drawable) {
        Drawable b = super.mo2744b(drawable);
        m20651d();
        return b;
    }

    public final void m20654a(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.f14250a = scalingUtils$ScaleType;
        this.f14251c = null;
        m20651d();
        invalidateSelf();
    }

    public final void m20653a(PointF pointF) {
        if (this.f14252d == null) {
            this.f14252d = new PointF();
        }
        this.f14252d.set(pointF);
        m20651d();
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        m20650c();
        if (this.f14255g != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f14255g);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        m20651d();
    }

    private void m20650c() {
        Object obj = null;
        Object obj2;
        if (this.f14250a instanceof ScalingUtils$StatefulScaleType) {
            Object a = ((ScalingUtils$StatefulScaleType) this.f14250a).m21594a();
            obj2 = (a == null || !a.equals(this.f14251c)) ? 1 : null;
            this.f14251c = a;
        } else {
            obj2 = null;
        }
        if (!(this.f14253e == getCurrent().getIntrinsicWidth() && this.f14254f == getCurrent().getIntrinsicHeight())) {
            obj = 1;
        }
        if (obj != null || r0 != null) {
            m20651d();
        }
    }

    @VisibleForTesting
    private void m20651d() {
        float f = 0.5f;
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f14253e = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.f14254f = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.f14255g = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.f14255g = null;
        } else if (this.f14250a == ScalingUtils$ScaleType.f14214a) {
            current.setBounds(bounds);
            this.f14255g = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            ScalingUtils$ScaleType scalingUtils$ScaleType = this.f14250a;
            Matrix matrix = this.f14256h;
            float f2 = this.f14252d != null ? this.f14252d.x : 0.5f;
            if (this.f14252d != null) {
                f = this.f14252d.y;
            }
            scalingUtils$ScaleType.mo2731a(matrix, bounds, intrinsicWidth, intrinsicHeight, f2, f);
            this.f14255g = this.f14256h;
        }
    }

    public final void mo2741a(Matrix matrix) {
        m20628b(matrix);
        m20650c();
        if (this.f14255g != null) {
            matrix.preConcat(this.f14255g);
        }
    }
}
