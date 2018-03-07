package com.facebook.spherical;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.WindowManager;

/* compiled from: event_counts */
public class FullScreenRenderThreadController extends RenderThreadController {
    private final Quaternion f16084p = new Quaternion();
    private final Quaternion f16085q = new Quaternion();
    private final Quaternion f16086r = new Quaternion();
    private final Quaternion f16087s = new Quaternion();
    private final Quaternion f16088t = new Quaternion();

    public FullScreenRenderThreadController(SensorManager sensorManager, WindowManager windowManager) {
        super(sensorManager, windowManager);
        Matrix.setIdentityM(this.f16056c, 0);
    }

    public final void mo1236a(float f, float f2) {
        super.mo1236a(f, f2);
        m23690e(f, f2);
    }

    public final void mo1239b(float f, float f2) {
        super.mo1239b(f, f2);
        this.f16061h.m23715a((float) Math.toRadians((double) f2), 1.0f, 0.0f, 0.0f);
        this.f16060g.m23719b(this.f16061h);
        this.f16061h.m23715a((float) Math.toRadians((double) f), 0.0f, 1.0f, 0.0f);
        this.f16060g.m23721c(this.f16061h);
    }

    public final void mo1240c(float f, float f2) {
        m23690e(-f, -f2);
    }

    public final void mo1237a(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f16056c, sensorEvent.values);
        m23677b(this.f16056c);
    }

    public final void mo1241d(float f, float f2) {
        super.mo1241d(f, f2);
        this.f16060g.m23720b(this.f16057d);
        Matrix.multiplyMM(this.f16057d, 0, this.f16056c, 0, this.f16057d, 0);
        float c = f2 - ViewportOrientationTracker.c(this.f16057d);
        float a = (this.f16064k + f) - ViewportOrientationTracker.a(this.f16057d);
        this.f16084p.m23716a(this.f16058e);
        this.f16085q.m23715a((float) Math.toRadians((double) c), 1.0f, 0.0f, 0.0f);
        this.f16086r.m23716a(this.f16059f);
        this.f16087s.m23715a((float) Math.toRadians((double) a), 0.0f, 1.0f, 0.0f);
    }

    public final void mo1235a(float f) {
        this.f16058e.m23717a(this.f16084p, this.f16085q, f);
        this.f16059f.m23717a(this.f16086r, this.f16087s, f);
    }

    public final void mo1238a(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
        this.f16059f.m23720b(this.f16057d);
        Matrix.multiplyMM(fArr, 0, this.f16057d, 0, fArr, 0);
        this.f16060g.m23720b(this.f16057d);
        Matrix.multiplyMM(fArr, 0, this.f16057d, 0, fArr, 0);
        Matrix.multiplyMM(fArr, 0, this.f16056c, 0, fArr, 0);
        this.f16058e.m23720b(this.f16057d);
        Matrix.multiplyMM(fArr, 0, this.f16057d, 0, fArr, 0);
    }

    private void m23690e(float f, float f2) {
        this.f16061h.m23715a((float) Math.toRadians((double) f2), 1.0f, 0.0f, 0.0f);
        this.f16058e.m23719b(this.f16061h);
        this.f16061h.m23715a((float) Math.toRadians((double) f), 0.0f, 1.0f, 0.0f);
        this.f16059f.m23721c(this.f16061h);
    }
}
