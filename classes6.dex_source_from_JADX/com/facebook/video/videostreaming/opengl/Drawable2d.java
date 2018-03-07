package com.facebook.video.videostreaming.opengl;

import java.nio.FloatBuffer;

/* compiled from: sIIcls */
public class Drawable2d {
    private static final float[] f5393a = new float[]{0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
    private static final float[] f5394b = new float[]{0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer f5395c = GLUtil.m8118a(f5393a);
    private static final FloatBuffer f5396d = GLUtil.m8118a(f5394b);
    private static final float[] f5397e = new float[]{-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
    private static final float[] f5398f = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final FloatBuffer f5399g = GLUtil.m8118a(f5397e);
    private static final FloatBuffer f5400h = GLUtil.m8118a(f5398f);
    private static final float[] f5401i = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] f5402j = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] f5403k = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static final FloatBuffer f5404l = GLUtil.m8118a(f5401i);
    private static final FloatBuffer f5405m = GLUtil.m8118a(f5403k);
    private static final FloatBuffer f5406n = GLUtil.m8118a(f5402j);
    public FloatBuffer f5407o;
    private FloatBuffer f5408p;
    private FloatBuffer f5409q;
    private int f5410r;
    private int f5411s = 2;
    private int f5412t;
    private int f5413u;
    private Prefab f5414v;

    /* compiled from: sIIcls */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE,
        FULL_SQUARE
    }

    public Drawable2d(Prefab prefab) {
        switch (prefab) {
            case TRIANGLE:
                this.f5407o = f5395c;
                this.f5408p = f5396d;
                this.f5410r = f5393a.length / this.f5411s;
                break;
            case RECTANGLE:
                this.f5407o = f5399g;
                this.f5408p = f5400h;
                this.f5410r = f5397e.length / this.f5411s;
                break;
            case FULL_RECTANGLE:
                this.f5407o = f5404l;
                this.f5408p = f5406n;
                this.f5409q = f5405m;
                this.f5410r = f5401i.length / this.f5411s;
                break;
            default:
                throw new RuntimeException("Unknown shape " + prefab);
        }
        this.f5413u = 8;
        this.f5412t = this.f5411s * 4;
        this.f5414v = prefab;
    }

    public final FloatBuffer m8098b() {
        return this.f5408p;
    }

    public final FloatBuffer m8099c() {
        return this.f5409q;
    }

    public final int m8100d() {
        return this.f5410r;
    }

    public final int m8101e() {
        return this.f5412t;
    }

    public final int m8102f() {
        return this.f5413u;
    }

    public final int m8103g() {
        return this.f5411s;
    }

    public final void m8097a(int i, int i2, int i3, float f) {
        float[] fArr;
        float[] fArr2;
        float max = (float) Math.max(i, i2);
        float min = (float) Math.min(i, i2);
        if (f >= 1.0f) {
            f = 1.0f / f;
        }
        float abs = Math.abs(f - (min / max)) * 0.5f;
        if (i3 == 1) {
            fArr = new float[]{0.0f, 1.0f - abs, 0.0f, abs, 1.0f, 1.0f - abs, 1.0f, abs};
            fArr2 = new float[]{0.0f, abs, 0.0f, 1.0f - abs, 1.0f, abs, 1.0f, 1.0f - abs};
        } else if (i3 == 2) {
            fArr = new float[]{1.0f, abs, 0.0f, abs, 1.0f, 1.0f - abs, 0.0f, 1.0f - abs};
            fArr2 = new float[]{0.0f, abs, 1.0f, abs, 0.0f, 1.0f - abs, 1.0f, 1.0f - abs};
        } else if (i3 == 3) {
            fArr = new float[]{1.0f, abs, 1.0f, 1.0f - abs, 0.0f, abs, 0.0f, 1.0f - abs};
            fArr2 = new float[]{1.0f, 1.0f - abs, 1.0f, abs, 0.0f, 1.0f - abs, 0.0f, abs};
        } else {
            fArr = new float[]{0.0f, abs, 1.0f, abs, 0.0f, 1.0f - abs, 1.0f, 1.0f - abs};
            fArr2 = new float[]{1.0f, abs, 0.0f, abs, 1.0f, 1.0f - abs, 0.0f, 1.0f - abs};
        }
        this.f5408p = GLUtil.m8118a(fArr);
        this.f5409q = GLUtil.m8118a(fArr2);
    }

    public String toString() {
        if (this.f5414v != null) {
            return "[Drawable2d: " + this.f5414v + "]";
        }
        return "[Drawable2d: ...]";
    }
}
