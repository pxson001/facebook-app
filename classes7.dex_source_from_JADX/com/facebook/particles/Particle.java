package com.facebook.particles;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.common.util.MathUtil;

/* compiled from: max_phoneme_length */
public class Particle {
    public SimpleParticleStyle f9203a;
    private float f9204b;
    public float f9205c;
    public float f9206d;
    public float f9207e;
    public float f9208f;
    public float f9209g;
    private float f9210h;
    private float f9211i;
    private float f9212j;
    private float f9213k;
    public float f9214l;
    public long f9215m;
    public long f9216n;

    public Particle(SimpleParticleStyle simpleParticleStyle) {
        m11262a(simpleParticleStyle);
    }

    public final void m11262a(SimpleParticleStyle simpleParticleStyle) {
        float f = Float.NEGATIVE_INFINITY;
        this.f9203a = simpleParticleStyle;
        this.f9215m = 0;
        this.f9216n = 0;
        this.f9205c = 0.0f;
        this.f9206d = 0.0f;
        this.f9208f = simpleParticleStyle.f9233b.mo482a();
        this.f9209g = simpleParticleStyle.f9234c.mo482a();
        this.f9207e = simpleParticleStyle.m11281f();
        if (simpleParticleStyle.f9235d) {
            if (this.f9209g < 0.0f) {
                f = this.f9209g;
            }
            this.f9210h = f;
            this.f9211i = this.f9209g > 0.0f ? this.f9209g : Float.POSITIVE_INFINITY;
        } else {
            this.f9210h = Float.NEGATIVE_INFINITY;
            this.f9211i = Float.POSITIVE_INFINITY;
        }
        this.f9204b = simpleParticleStyle.f9237f.mo482a();
        this.f9212j = simpleParticleStyle.f9238g.mo482a();
        this.f9213k = simpleParticleStyle.f9239h.mo482a();
        this.f9214l = simpleParticleStyle.f9241j.mo482a();
    }

    public final float m11260a() {
        return this.f9205c;
    }

    public final float m11263b() {
        return this.f9206d;
    }

    public final float m11265d() {
        return this.f9204b;
    }

    public final float m11266e() {
        return this.f9213k;
    }

    public final float m11267f() {
        return (float) this.f9203a.m11278a();
    }

    public final float m11268g() {
        return (float) this.f9203a.m11280b();
    }

    public final void m11264b(long j) {
        if (this.f9216n == 0) {
            this.f9216n = j;
        }
        if (this.f9215m == 0) {
            this.f9215m = j;
        }
        float f = ((float) (j - this.f9216n)) / 1000.0f;
        if ((this.f9207e <= 0.0f || this.f9209g >= 0.0f) && (this.f9207e >= 0.0f || this.f9209g <= 0.0f)) {
            this.f9209g += this.f9207e * f;
        } else {
            float f2 = 5.0f + ((15.0f * (-this.f9209g)) / this.f9207e);
            this.f9209g = ((f2 * this.f9207e) * f) + this.f9209g;
            this.f9208f *= 1.0f - (10.0f * f);
        }
        this.f9209g = MathUtil.b(this.f9209g, this.f9210h, this.f9211i);
        this.f9205c += this.f9208f * f;
        this.f9206d += this.f9209g * f;
        this.f9204b = (f * this.f9212j) + this.f9204b;
        this.f9216n = j;
    }

    public final void m11261a(Canvas canvas, Paint paint, long j) {
        canvas.save();
        canvas.translate(this.f9205c, this.f9206d);
        canvas.rotate(this.f9204b);
        canvas.scale(this.f9213k, this.f9213k);
        SimpleParticleStyle simpleParticleStyle = this.f9203a;
        long j2 = this.f9203a.f9240i;
        simpleParticleStyle.m11279a(canvas, paint, ((j2 > 0 ? ((float) (j - this.f9215m)) / ((float) j2) : 0.0f) + this.f9214l) % 1.0f);
        canvas.restore();
    }
}
