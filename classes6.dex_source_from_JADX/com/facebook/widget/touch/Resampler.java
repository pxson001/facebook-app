package com.facebook.widget.touch;

import com.facebook.common.collect.RingBuffer;

/* compiled from: queueEntityId */
public class Resampler {
    private static final float[] f6275a = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    private boolean f6276b;
    private RingBuffer<SamplePoint> f6277c;

    /* compiled from: queueEntityId */
    public class SamplePoint {
        float f6272a;
        float f6273b;
        public long f6274c;

        SamplePoint(float f, float f2, long j) {
            this.f6272a = f;
            this.f6273b = f2;
            this.f6274c = j;
        }

        final void m8815a(float f, float f2, long j) {
            this.f6272a = f;
            this.f6273b = f2;
            this.f6274c = j;
        }

        public final float m8816b() {
            return this.f6272a;
        }

        public final float m8817c() {
            return this.f6273b;
        }
    }

    public Resampler() {
        this(false);
    }

    public Resampler(boolean z) {
        this.f6276b = false;
        this.f6276b = z;
        this.f6277c = new RingBuffer(8);
    }

    public final void m8819a() {
        int d = this.f6277c.d();
        for (int i = 0; i < d; i++) {
            ((SamplePoint) this.f6277c.a(i)).f6274c = -1;
        }
    }

    public final void m8820a(float f, float f2, long j) {
        Object obj;
        if (this.f6277c.c()) {
            obj = (SamplePoint) this.f6277c.a();
            obj.m8815a(f, f2, j);
        } else {
            obj = new SamplePoint(f, f2, j);
        }
        this.f6277c.a(obj);
    }

    public final void m8821a(long j, SamplePoint samplePoint) {
        m8818b(j, samplePoint);
    }

    private void m8818b(long j, SamplePoint samplePoint) {
        int d = this.f6277c.d();
        if (d == 0) {
            throw new IndexOutOfBoundsException("Can't estimate with no samples");
        }
        float f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        int i = 0;
        for (int i2 = d - 1; i2 >= 0; i2--) {
            SamplePoint samplePoint2 = (SamplePoint) this.f6277c.a(i2);
            if (samplePoint2.f6274c < 0 || j - samplePoint2.f6274c > 100) {
                break;
            }
            float f14 = (float) (samplePoint2.f6274c - j);
            float f15 = f14 * f14;
            float f16 = f6275a[i2];
            f16 *= f16;
            f2 += (f16 * f15) * f15;
            f3 += (f16 * f15) * f14;
            f4 += f16 * f15;
            f5 += f16 * f15;
            f6 += f16 * f14;
            f7 += 1.0f * f16;
            f8 += (f16 * f15) * samplePoint2.f6272a;
            f9 += (f16 * f14) * samplePoint2.f6272a;
            f10 += samplePoint2.f6272a * f16;
            f11 += (f15 * f16) * samplePoint2.f6273b;
            f12 += (f14 * f16) * samplePoint2.f6273b;
            f13 += samplePoint2.f6273b * f16;
            i++;
        }
        float f17 = ((((f5 * f7) - (f6 * f6)) * f2) - (((f7 * f3) - (f4 * f6)) * f3)) + (((f3 * f6) - (f5 * f4)) * f4);
        if (!this.f6276b || Math.abs(f17) <= 1.0E-4f || i < 3) {
            f17 = (f5 * f7) - (f6 * f6);
            if (Math.abs(f17) <= 1.0E-4f || i < 2) {
                samplePoint2 = (SamplePoint) this.f6277c.a(d - 1);
                f = samplePoint2.f6272a;
                f17 = samplePoint2.f6273b;
            } else {
                f = (1.0f / f17) * (((-f6) * f9) + (f5 * f10));
                f17 = (1.0f / f17) * (((-f6) * f12) + (f13 * f5));
            }
        } else {
            f = (1.0f / f17) * (((((f3 * f6) - (f5 * f4)) * f8) + (f9 * ((f4 * f3) - (f2 * f6)))) + (f10 * ((f2 * f5) - (f3 * f3))));
            f17 = (1.0f / f17) * (((((f3 * f6) - (f5 * f4)) * f11) + (f12 * ((f4 * f3) - (f2 * f6)))) + (f13 * ((f2 * f5) - (f3 * f3))));
        }
        samplePoint.m8815a(f, f17, j);
    }
}
