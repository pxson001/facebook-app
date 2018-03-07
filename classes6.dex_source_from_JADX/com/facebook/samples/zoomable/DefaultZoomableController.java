package com.facebook.samples.zoomable;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.facebook.samples.gestures.TransformGestureDetector;
import com.facebook.samples.zoomable.ZoomableDraweeView.C02912;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: setInitialAttachments */
public class DefaultZoomableController implements ZoomableController {
    private static final Class<?> f4801a = DefaultZoomableController.class;
    private static final RectF f4802b = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public TransformGestureDetector f4803c;
    private C02912 f4804d = null;
    private boolean f4805e = false;
    private boolean f4806f = false;
    private boolean f4807g = true;
    private boolean f4808h = true;
    public float f4809i = 1.0f;
    public float f4810j = 2.0f;
    public final RectF f4811k = new RectF();
    public final RectF f4812l = new RectF();
    private final RectF f4813m = new RectF();
    private final Matrix f4814n = new Matrix();
    private final Matrix f4815o = new Matrix();
    private final Matrix f4816p = new Matrix();
    public final float[] f4817q = new float[9];
    private final RectF f4818r = new RectF();

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: setInitialAttachments */
    public @interface LimitFlag {
    }

    public DefaultZoomableController(TransformGestureDetector transformGestureDetector) {
        this.f4803c = transformGestureDetector;
        this.f4803c.f4800b = this;
    }

    public void mo346a() {
        this.f4803c.f4799a.m7571b();
        this.f4814n.reset();
        this.f4815o.reset();
        m7596c();
    }

    public final void mo338a(C02912 c02912) {
        this.f4804d = c02912;
    }

    public final void mo341b(boolean z) {
        this.f4805e = z;
        if (!z) {
            mo346a();
        }
    }

    public final boolean mo343j() {
        return this.f4805e;
    }

    public final float mo344m() {
        return m7595c(this.f4815o);
    }

    public final void mo337a(RectF rectF) {
        if (!rectF.equals(this.f4812l)) {
            this.f4812l.set(rectF);
            m7596c();
        }
    }

    public final void mo340b(RectF rectF) {
        this.f4811k.set(rectF);
    }

    public boolean mo342b() {
        boolean z = false;
        this.f4815o.getValues(this.f4817q);
        float[] fArr = this.f4817q;
        fArr[0] = fArr[0] - 1.0f;
        fArr = this.f4817q;
        fArr[4] = fArr[4] - 1.0f;
        fArr = this.f4817q;
        fArr[8] = fArr[8] - 1.0f;
        for (int i = 0; i < 9; i++) {
            if (Math.abs(this.f4817q[i]) > 0.001f) {
                break;
            }
        }
        z = true;
        return z;
    }

    public final Matrix mo345p() {
        return this.f4815o;
    }

    public final void m7599a(Matrix matrix) {
        matrix.setRectToRect(f4802b, this.f4813m, ScaleToFit.FILL);
    }

    public final PointF m7597a(PointF pointF) {
        float[] fArr = this.f4817q;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        this.f4815o.invert(this.f4816p);
        this.f4816p.mapPoints(fArr, 0, fArr, 0, 1);
        for (int i = 0; i < 1; i++) {
            fArr[(i * 2) + 0] = (fArr[(i * 2) + 0] - this.f4812l.left) / this.f4812l.width();
            fArr[(i * 2) + 1] = (fArr[(i * 2) + 1] - this.f4812l.top) / this.f4812l.height();
        }
        return new PointF(fArr[0], fArr[1]);
    }

    private void m7593b(float[] fArr, float[] fArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            fArr[(i2 * 2) + 0] = (fArr2[(i2 * 2) + 0] * this.f4812l.width()) + this.f4812l.left;
            fArr[(i2 * 2) + 1] = (fArr2[(i2 * 2) + 1] * this.f4812l.height()) + this.f4812l.top;
        }
    }

    protected final boolean m7603a(Matrix matrix, float f, PointF pointF, PointF pointF2, int i) {
        float[] fArr = this.f4817q;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        m7593b(fArr, fArr, 1);
        float f2 = pointF2.x - fArr[0];
        float f3 = pointF2.y - fArr[1];
        matrix.setScale(f, f, fArr[0], fArr[1]);
        int a = m7591a(matrix, fArr[0], fArr[1], i) | 0;
        matrix.postTranslate(f2, f3);
        return a | m7594b(matrix, i);
    }

    public final void m7605b(Matrix matrix) {
        this.f4815o.set(matrix);
        m7596c();
    }

    public final boolean mo339a(MotionEvent motionEvent) {
        Integer.valueOf(motionEvent.getAction());
        return this.f4805e ? this.f4803c.f4799a.m7570a(motionEvent) : false;
    }

    public void mo347a(TransformGestureDetector transformGestureDetector) {
        this.f4814n.set(this.f4815o);
    }

    public void mo348b(TransformGestureDetector transformGestureDetector) {
        boolean a = m7592a(this.f4815o, 7);
        m7596c();
        if (a) {
            this.f4803c.m7574e();
        }
    }

    private boolean m7592a(Matrix matrix, int i) {
        TransformGestureDetector transformGestureDetector = this.f4803c;
        matrix.set(this.f4814n);
        if (this.f4806f) {
            float f;
            if (transformGestureDetector.f4799a.f4791b < 2) {
                f = 0.0f;
            } else {
                float f2 = transformGestureDetector.f4799a.f4795f[1] - transformGestureDetector.f4799a.f4795f[0];
                float f3 = transformGestureDetector.f4799a.f4797h[1] - transformGestureDetector.f4799a.f4797h[0];
                f = (float) Math.atan2((double) f2, (double) (transformGestureDetector.f4799a.f4794e[1] - transformGestureDetector.f4799a.f4794e[0]));
                f = ((float) Math.atan2((double) f3, (double) (transformGestureDetector.f4799a.f4796g[1] - transformGestureDetector.f4799a.f4796g[0]))) - f;
            }
            matrix.postRotate(f * 57.29578f, transformGestureDetector.m7575f(), transformGestureDetector.m7576g());
        }
        if (this.f4807g) {
            float j = transformGestureDetector.m7579j();
            matrix.postScale(j, j, transformGestureDetector.m7575f(), transformGestureDetector.m7576g());
        }
        int a = m7591a(matrix, transformGestureDetector.m7575f(), transformGestureDetector.m7576g(), i) | 0;
        if (this.f4808h) {
            matrix.postTranslate(transformGestureDetector.m7577h(), transformGestureDetector.m7578i());
        }
        return m7594b(matrix, i) | a;
    }

    private void m7596c() {
        this.f4815o.mapRect(this.f4813m, this.f4812l);
        if (this.f4804d != null && mo343j()) {
            this.f4804d.m7631a(this.f4815o);
        }
    }

    private boolean m7591a(Matrix matrix, float f, float f2, int i) {
        if (!m7590a(i, 4)) {
            return false;
        }
        float c = m7595c(matrix);
        float f3 = this.f4809i;
        f3 = Math.min(Math.max(f3, c), this.f4810j);
        if (f3 == c) {
            return false;
        }
        float f4 = f3 / c;
        matrix.postScale(f4, f4, f, f2);
        return true;
    }

    private boolean m7594b(Matrix matrix, int i) {
        if (!m7590a(i, 3)) {
            return false;
        }
        float a;
        RectF rectF = this.f4818r;
        rectF.set(this.f4812l);
        matrix.mapRect(rectF);
        float a2 = m7590a(i, 1) ? m7589a(rectF.left, rectF.right, this.f4811k.left, this.f4811k.right, this.f4812l.centerX()) : 0.0f;
        if (m7590a(i, 2)) {
            a = m7589a(rectF.top, rectF.bottom, this.f4811k.top, this.f4811k.bottom, this.f4812l.centerY());
        } else {
            a = 0.0f;
        }
        if (a2 == 0.0f && a == 0.0f) {
            return false;
        }
        matrix.postTranslate(a2, a);
        return true;
    }

    private static boolean m7590a(int i, int i2) {
        return (i & i2) != 0;
    }

    private static float m7589a(float f, float f2, float f3, float f4, float f5) {
        float f6 = f2 - f;
        float f7 = f4 - f3;
        if (f6 < Math.min(f5 - f3, f4 - f5) * 2.0f) {
            return f5 - ((f2 + f) / 2.0f);
        }
        if (f6 < f7) {
            if (f5 < (f3 + f4) / 2.0f) {
                return f3 - f;
            }
            return f4 - f2;
        } else if (f > f3) {
            return f3 - f;
        } else {
            if (f2 < f4) {
                return f4 - f2;
            }
            return 0.0f;
        }
    }

    private float m7595c(Matrix matrix) {
        matrix.getValues(this.f4817q);
        return this.f4817q[0];
    }
}
