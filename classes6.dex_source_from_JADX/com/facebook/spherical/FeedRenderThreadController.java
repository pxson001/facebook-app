package com.facebook.spherical;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.WindowManager;
import com.facebook.spherical.model.SphericalRendererBounds;
import com.google.common.base.Preconditions;

/* compiled from: event_declines.count */
public class FeedRenderThreadController extends RenderThreadController {
    private SphericalRendererBounds f16072A;
    private float f16073p = 0.0f;
    private float f16074q = 0.0f;
    private float f16075r;
    private float f16076s;
    private float f16077t;
    private float f16078u;
    private Quaternion f16079v;
    private float f16080w;
    private float f16081x;
    private float f16082y;
    private float f16083z;

    public FeedRenderThreadController(SensorManager sensorManager, WindowManager windowManager, SphericalRendererBounds sphericalRendererBounds) {
        super(sensorManager, windowManager);
        this.f16072A = sphericalRendererBounds;
        this.f16080w = this.f16072A.f16189b;
        this.f16081x = this.f16072A.f16188a;
        this.f16082y = this.f16072A.f16190c;
        this.f16083z = this.f16072A.f16191d;
        Preconditions.checkArgument(this.f16072A.f16193f);
    }

    public final void mo1236a(float f, float f2) {
        super.mo1236a(f, f2);
        m23681f(f2, f);
    }

    public final void mo1239b(float f, float f2) {
        super.mo1239b(f, f2);
        m23681f(f2, f);
    }

    public final void mo1240c(float f, float f2) {
        m23681f(-f2, -f);
    }

    public final void mo1237a(SensorEvent sensorEvent) {
        SensorManager.getQuaternionFromVector(this.f16055b, sensorEvent.values);
        if (this.f16079v == null) {
            this.f16079v = new Quaternion();
            this.f16079v.m23718a(this.f16055b);
        }
        this.f16061h.m23718a(this.f16055b);
        this.f16079v.m23717a(this.f16079v, this.f16061h, this.f16068o);
        sensorEvent.values[0] = this.f16079v.f16142b;
        sensorEvent.values[1] = this.f16079v.f16143c;
        sensorEvent.values[2] = this.f16079v.f16144d;
        sensorEvent.values[3] = this.f16079v.f16141a;
        SensorManager.getRotationMatrixFromVector(this.f16057d, sensorEvent.values);
        m23677b(this.f16057d);
        SensorManager.getAngleChange(this.f16055b, this.f16057d, this.f16056c);
        for (int i = 0; i < 16; i++) {
            this.f16056c[i] = this.f16057d[i];
        }
        Matrix.rotateM(this.f16057d, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        m23681f((float) Math.toDegrees((double) this.f16055b[1]), (float) Math.toDegrees((((double) this.f16055b[0]) * Math.sin((double) ((float) Math.toRadians((double) ViewportOrientationTracker.c(this.f16057d))))) + ((double) (-this.f16055b[2]))));
    }

    public final void mo1241d(float f, float f2) {
        super.mo1241d(f, f2);
        this.f16075r = this.f16073p;
        this.f16076s = f2;
        this.f16077t = this.f16074q % 360.0f;
        if (this.f16077t > 180.0f) {
            this.f16077t -= 360.0f;
        } else if (this.f16077t < -180.0f) {
            this.f16077t += 360.0f;
        }
        this.f16078u = this.f16064k + f;
    }

    public final void mo1235a(float f) {
        this.f16073p = this.f16075r + ((this.f16076s - this.f16075r) * f);
        this.f16074q = this.f16077t + ((this.f16078u - this.f16077t) * f);
    }

    public final void mo1238a(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, this.f16073p, 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(fArr, 0, this.f16074q, 0.0f, 1.0f, 0.0f);
    }

    public final void m23689e(float f, float f2) {
        this.f16080w = f;
        this.f16081x = f2;
    }

    private void m23681f(float f, float f2) {
        this.f16073p = (m23680a(this.f16073p, f, this.f16082y, this.f16083z) * f) + this.f16073p;
        this.f16073p = Math.max(this.f16073p, this.f16082y);
        this.f16073p = Math.min(this.f16073p, this.f16083z);
        if (this.f16072A.f16192e) {
            this.f16074q = (m23680a(this.f16074q, f2, this.f16081x, this.f16080w) * f2) + this.f16074q;
            this.f16074q = Math.max(this.f16074q, this.f16081x);
            this.f16074q = Math.min(this.f16074q, this.f16080w);
            return;
        }
        this.f16074q += f2;
    }

    private static float m23680a(float f, float f2, float f3, float f4) {
        if (f2 < 0.0f && f < f3 + 10.0f && f > f3) {
            return Math.abs(f - f3) / 10.0f;
        }
        if (f2 <= 0.0f || f <= f4 - 10.0f || f >= f4) {
            return 1.0f;
        }
        return Math.abs(f - f4) / 10.0f;
    }
}
