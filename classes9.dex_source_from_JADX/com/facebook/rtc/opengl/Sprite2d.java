package com.facebook.rtc.opengl;

import android.opengl.Matrix;

/* compiled from: application/vnd.oma.drm.content */
public class Sprite2d {
    private Drawable2d f19897a = new Drawable2d();
    private float[] f19898b = new float[4];
    public int f19899c;
    public float[] f19900d;
    public boolean f19901e;
    private final float[] f19902f = new float[16];
    public float f19903g;

    public Sprite2d() {
        this.f19898b[3] = 1.0f;
        this.f19899c = -1;
        this.f19900d = new float[16];
        this.f19901e = false;
    }

    private float[] m19615b() {
        if (!this.f19901e) {
            float[] fArr = this.f19900d;
            Matrix.setIdentityM(fArr, 0);
            Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(fArr, 0, 1.0f, 1.0f, 1.0f);
            this.f19901e = true;
        }
        return this.f19900d;
    }

    public final void m19616a(Texture2dProgram texture2dProgram, float[] fArr) {
        Matrix.multiplyMM(this.f19902f, 0, fArr, 0, m19615b(), 0);
        texture2dProgram.m19617a(this.f19902f, Drawable2d.f19850c, 0, Drawable2d.m19573c(), Drawable2d.m19576f(), Drawable2d.m19574d(), GlUtil.f19875a, Drawable2d.m19572b(), this.f19899c, Drawable2d.m19575e(), this.f19903g);
    }
}
