package com.facebook.messaging.photos.view;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.facebook.samples.zoomable.ZoomableController;
import com.facebook.samples.zoomable.ZoomableDraweeView.2;

@Deprecated
/* compiled from: registration_name_prefill */
public class PhotoViewZoomableController implements ZoomableController {
    public final Matrix f3636a = new Matrix();
    public final RectF f3637b = new RectF();
    public final RectF f3638c = new RectF();
    public final RectF f3639d = new RectF();
    private final float[] f3640e = new float[9];
    private 2 f3641f;
    private boolean f3642g;

    public final void m3464a(2 2) {
        this.f3641f = 2;
    }

    public final void m3467b(boolean z) {
        this.f3642g = z;
        if (!z) {
            this.f3636a.reset();
        }
    }

    public final boolean m3469j() {
        return this.f3642g;
    }

    public final float m3470m() {
        this.f3636a.getValues(this.f3640e);
        return this.f3640e[0];
    }

    public final boolean m3468b() {
        return this.f3636a.isIdentity();
    }

    public final Matrix m3471p() {
        return this.f3636a;
    }

    public final void m3463a(RectF rectF) {
        this.f3638c.set(rectF);
    }

    public final void m3466b(RectF rectF) {
        this.f3637b.set(rectF);
    }

    public final boolean m3465a(MotionEvent motionEvent) {
        return false;
    }

    public final void m3462a(float f, float f2, float f3) {
        m3459c(f, f2, f3);
    }

    private void m3459c(float f, float f2, float f3) {
        float b = m3458b(f) / m3470m();
        this.f3636a.postScale(b, b, f2, f3);
        m3457a(true, true);
        m3460e();
    }

    public final void m3461a(float f, float f2) {
        this.f3636a.postTranslate(f, f2);
        m3457a(true, true);
        m3460e();
    }

    private void m3460e() {
        if (this.f3641f != null) {
            this.f3641f.a(this.f3636a);
        }
    }

    private static float m3458b(float f) {
        if (f > 4.0f) {
            return 4.0f;
        }
        if (f < 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private void m3457a(boolean z, boolean z2) {
        float height;
        float f = 0.0f;
        this.f3639d.set(this.f3638c);
        this.f3636a.mapRect(this.f3639d);
        float height2 = this.f3639d.height();
        float width = this.f3639d.width();
        if (z2) {
            height = this.f3637b.height();
            if (height2 < height) {
                height2 = ((height - height2) / 2.0f) - this.f3639d.top;
            } else if (this.f3639d.top > this.f3637b.top) {
                height2 = this.f3637b.top - this.f3639d.top;
            } else if (this.f3639d.bottom < this.f3637b.bottom) {
                height2 = this.f3637b.bottom - this.f3639d.bottom;
            }
            if (z) {
                height = this.f3637b.width();
                if (width < height) {
                    f = ((height - width) / 2.0f) - this.f3639d.left;
                } else if (this.f3639d.left > this.f3637b.left) {
                    f = this.f3637b.left - this.f3639d.left;
                } else if (this.f3639d.right < this.f3637b.right) {
                    f = this.f3637b.right - this.f3639d.right;
                }
            }
            this.f3636a.postTranslate(f, height2);
        }
        height2 = 0.0f;
        if (z) {
            height = this.f3637b.width();
            if (width < height) {
                f = ((height - width) / 2.0f) - this.f3639d.left;
            } else if (this.f3639d.left > this.f3637b.left) {
                f = this.f3637b.left - this.f3639d.left;
            } else if (this.f3639d.right < this.f3637b.right) {
                f = this.f3637b.right - this.f3639d.right;
            }
        }
        this.f3636a.postTranslate(f, height2);
    }
}
