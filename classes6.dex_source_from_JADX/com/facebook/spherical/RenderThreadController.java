package com.facebook.spherical;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.WindowManager;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: event_email_associates */
public abstract class RenderThreadController {
    public final Lock f16054a = new ReentrantLock();
    protected final float[] f16055b = new float[4];
    protected final float[] f16056c = new float[16];
    protected final float[] f16057d = new float[16];
    protected final Quaternion f16058e = new Quaternion();
    protected final Quaternion f16059f = new Quaternion();
    protected final Quaternion f16060g = new Quaternion();
    protected final Quaternion f16061h = new Quaternion();
    protected float f16062i;
    protected float f16063j;
    protected float f16064k;
    protected float f16065l;
    protected float f16066m;
    protected float f16067n;
    public float f16068o;
    private final SensorManager f16069p;
    private final WindowManager f16070q;
    private final int[] f16071r = new int[2];

    public abstract void mo1235a(float f);

    public abstract void mo1237a(SensorEvent sensorEvent);

    public abstract void mo1238a(float[] fArr);

    public abstract void mo1240c(float f, float f2);

    public RenderThreadController(SensorManager sensorManager, WindowManager windowManager) {
        this.f16069p = sensorManager;
        this.f16070q = windowManager;
        Matrix.setIdentityM(this.f16056c, 0);
    }

    public void mo1241d(float f, float f2) {
        this.f16066m = f;
        this.f16067n = f2;
    }

    public void mo1236a(float f, float f2) {
        this.f16062i = f;
        this.f16063j = f2;
    }

    public void mo1239b(float f, float f2) {
        this.f16064k = f;
        this.f16065l = f2;
    }

    protected final void m23677b(float[] fArr) {
        int i = 0;
        int rotation = this.f16070q.getDefaultDisplay().getRotation();
        int[] iArr = this.f16071r;
        switch (rotation) {
            case 1:
                iArr[0] = 2;
                iArr[1] = 129;
                break;
            case 2:
                iArr[0] = 129;
                iArr[1] = 130;
                break;
            case 3:
                iArr[0] = 130;
                iArr[1] = 1;
                break;
            default:
                iArr[0] = 1;
                iArr[1] = 2;
                break;
        }
        SensorManager.remapCoordinateSystem(fArr, this.f16071r[0], this.f16071r[1], this.f16057d);
        while (i < 16) {
            fArr[i] = this.f16057d[i];
            i++;
        }
    }
}
