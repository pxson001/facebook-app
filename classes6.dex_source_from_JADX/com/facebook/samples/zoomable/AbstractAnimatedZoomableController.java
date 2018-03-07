package com.facebook.samples.zoomable;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.facebook.samples.gestures.TransformGestureDetector;
import javax.annotation.Nullable;

/* compiled from: setInitialAppAttribution */
public abstract class AbstractAnimatedZoomableController extends DefaultZoomableController {
    public boolean f4819a;
    public final float[] f4820b = new float[9];
    public final float[] f4821c = new float[9];
    public final float[] f4822d = new float[9];
    private final Matrix f4823e = new Matrix();
    public final Matrix f4824f = new Matrix();

    public abstract void mo349b(Matrix matrix, long j, @Nullable Runnable runnable);

    protected abstract void mo350g();

    protected abstract Class<?> mo351h();

    public AbstractAnimatedZoomableController(TransformGestureDetector transformGestureDetector) {
        super(transformGestureDetector);
    }

    public final void mo346a() {
        mo350g();
        this.f4824f.reset();
        this.f4823e.reset();
        super.mo346a();
    }

    public final void m7615a(float f, PointF pointF, PointF pointF2, int i, long j, @Nullable Runnable runnable) {
        Long.valueOf(j);
        m7603a(this.f4823e, f, pointF, pointF2, i);
        m7616a(this.f4823e, j, runnable);
    }

    public final void m7616a(Matrix matrix, long j, @Nullable Runnable runnable) {
        Long.valueOf(j);
        if (j <= 0) {
            m7613c(matrix);
        } else {
            mo349b(matrix, j, runnable);
        }
    }

    private void m7613c(Matrix matrix) {
        mo350g();
        this.f4824f.set(matrix);
        super.m7605b(matrix);
        this.f4803c.m7574e();
    }

    public final void mo348b(TransformGestureDetector transformGestureDetector) {
        if (!this.f4819a) {
            super.mo348b(transformGestureDetector);
        }
    }

    public final boolean mo342b() {
        return !this.f4819a && super.mo342b();
    }

    public final void mo347a(TransformGestureDetector transformGestureDetector) {
        mo350g();
        super.mo347a(transformGestureDetector);
    }
}
