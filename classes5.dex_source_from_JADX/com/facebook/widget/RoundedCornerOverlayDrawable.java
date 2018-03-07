package com.facebook.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

@Deprecated
/* compiled from: com.google.android.gms.common.internal.IGmsCallbacks */
public class RoundedCornerOverlayDrawable extends Drawable implements Callback {
    private final float[] f5703a = new float[8];
    public final Paint f5704b = new Paint(1);
    private final Paint f5705c = new Paint(1);
    public final Paint f5706d = new Paint(1);
    private final RectF f5707e = new RectF();
    private final RectF f5708f = new RectF();
    private final Path[] f5709g = new Path[4];

    public RoundedCornerOverlayDrawable() {
        int i = 0;
        this.f5704b.setStyle(Style.FILL);
        this.f5705c.setStyle(Style.STROKE);
        this.f5704b.setColor(0);
        this.f5705c.setColor(0);
        this.f5706d.setColor(0);
        while (i < 4) {
            this.f5709g[i] = new Path();
            i++;
        }
    }

    public final void m10498a(float f, float f2, float f3, float f4) {
        int i = (this.f5703a[0] == this.f5703a[1] && this.f5703a[0] == f && this.f5703a[2] == this.f5703a[3] && this.f5703a[2] == f2 && this.f5703a[4] == this.f5703a[5] && this.f5703a[4] == f3 && this.f5703a[6] == this.f5703a[7] && this.f5703a[6] == f4) ? 1 : 0;
        if (i == 0) {
            float[] fArr = this.f5703a;
            this.f5703a[1] = f;
            fArr[0] = f;
            fArr = this.f5703a;
            this.f5703a[3] = f2;
            fArr[2] = f2;
            fArr = this.f5703a;
            this.f5703a[5] = f3;
            fArr[4] = f3;
            fArr = this.f5703a;
            this.f5703a[7] = f4;
            fArr[6] = f4;
            m10496b();
            invalidateSelf();
        }
    }

    public final void m10499a(int i) {
        if (i != this.f5704b.getColor()) {
            this.f5704b.setColor(i);
            invalidateSelf();
        }
    }

    public final void m10500b(int i) {
        if (i != this.f5705c.getColor()) {
            this.f5705c.setColor(i);
            invalidateSelf();
        }
    }

    public final void m10501c(int i) {
        if (((float) i) != this.f5705c.getStrokeWidth()) {
            this.f5705c.setStrokeWidth((float) i);
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m10496b();
    }

    private void m10496b() {
        Rect bounds = getBounds();
        this.f5707e.set((float) bounds.left, (float) bounds.top, ((float) bounds.left) + (this.f5703a[0] * 2.0f), ((float) bounds.top) + (this.f5703a[1] * 2.0f));
        Path path = this.f5709g[0];
        path.reset();
        path.moveTo((float) bounds.left, (float) bounds.top);
        path.rLineTo(0.0f, this.f5703a[1]);
        path.arcTo(this.f5707e, 180.0f, 90.0f);
        path.close();
        this.f5707e.set(((float) bounds.right) - (this.f5703a[2] * 2.0f), (float) bounds.top, (float) bounds.right, ((float) bounds.top) + (this.f5703a[3] * 2.0f));
        path = this.f5709g[1];
        path.reset();
        path.moveTo((float) bounds.right, (float) bounds.top);
        path.rLineTo(0.0f, this.f5703a[3]);
        path.arcTo(this.f5707e, 0.0f, -90.0f);
        path.close();
        this.f5707e.set(((float) bounds.right) - (this.f5703a[4] * 2.0f), ((float) bounds.bottom) - (this.f5703a[5] * 2.0f), (float) bounds.right, (float) bounds.bottom);
        path = this.f5709g[2];
        path.reset();
        path.moveTo((float) bounds.right, (float) bounds.bottom);
        path.rLineTo(0.0f, -this.f5703a[5]);
        path.arcTo(this.f5707e, 0.0f, 90.0f);
        path.close();
        this.f5707e.set((float) bounds.left, ((float) bounds.bottom) - (this.f5703a[7] * 2.0f), ((float) bounds.left) + (this.f5703a[6] * 2.0f), (float) bounds.bottom);
        path = this.f5709g[3];
        path.reset();
        path.moveTo((float) bounds.left, (float) bounds.bottom);
        path.rLineTo(0.0f, -this.f5703a[7]);
        path.arcTo(this.f5707e, 180.0f, -90.0f);
        path.close();
    }

    public void draw(Canvas canvas) {
        if (this.f5706d.getColor() != 0) {
            canvas.drawRect(getBounds(), this.f5706d);
        }
        if (this.f5704b.getColor() != 0) {
            for (int i = 0; i < 4; i++) {
                canvas.drawPath(this.f5709g[i], this.f5704b);
            }
        }
        if (this.f5705c.getColor() != 0) {
            float strokeWidth = this.f5705c.getStrokeWidth() / 2.0f;
            Rect bounds = getBounds();
            this.f5708f.set(((float) bounds.left) + strokeWidth, ((float) bounds.top) + strokeWidth, ((float) bounds.right) - strokeWidth, ((float) bounds.bottom) - strokeWidth);
            RectF rectF = this.f5708f;
            Canvas canvas2 = canvas;
            canvas2.drawLine(rectF.left, this.f5703a[1] + rectF.top, rectF.left, rectF.bottom - this.f5703a[7], this.f5705c);
            canvas2 = canvas;
            canvas2.drawLine(this.f5703a[0] + rectF.left, rectF.top, rectF.right - this.f5703a[2], rectF.top, this.f5705c);
            canvas2 = canvas;
            canvas2.drawLine(rectF.right, this.f5703a[3] + rectF.top, rectF.right, rectF.bottom - this.f5703a[5], this.f5705c);
            canvas2 = canvas;
            canvas2.drawLine(this.f5703a[6] + rectF.left, rectF.bottom, rectF.right - this.f5703a[4], rectF.bottom, this.f5705c);
            this.f5707e.set(rectF.left, rectF.top, this.f5703a[0] * 2.0f, this.f5703a[1] * 2.0f);
            canvas.drawArc(this.f5707e, 180.0f, 90.0f, false, this.f5705c);
            this.f5707e.set(rectF.right - (this.f5703a[2] * 2.0f), rectF.top, rectF.right, this.f5703a[3] * 2.0f);
            canvas.drawArc(this.f5707e, 270.0f, 90.0f, false, this.f5705c);
            this.f5707e.set(rectF.right - (this.f5703a[4] * 2.0f), rectF.bottom - (this.f5703a[5] * 2.0f), rectF.right, rectF.bottom);
            canvas.drawArc(this.f5707e, 0.0f, 90.0f, false, this.f5705c);
            this.f5707e.set(rectF.left, rectF.bottom - (this.f5703a[7] * 2.0f), rectF.left + (this.f5703a[6] * 2.0f), rectF.bottom);
            canvas.drawArc(this.f5707e, 90.0f, 90.0f, false, this.f5705c);
        }
    }

    public void setAlpha(int i) {
        m10495a(i, this.f5705c);
        m10495a(i, this.f5704b);
        m10495a(i, this.f5706d);
        invalidateSelf();
    }

    private static void m10495a(int i, Paint paint) {
        paint.setAlpha((int) ((((float) paint.getAlpha()) / 255.0f) * ((float) i)));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f5705c.setColorFilter(colorFilter);
        this.f5704b.setColorFilter(colorFilter);
        this.f5706d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return resolveOpacity(resolveOpacity(m10497e(this.f5704b.getAlpha()), m10497e(this.f5705c.getAlpha())), m10497e(this.f5706d.getAlpha()));
    }

    private static int m10497e(int i) {
        switch (i) {
            case 0:
                return -2;
            case 255:
                return -1;
            default:
                return -3;
        }
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
