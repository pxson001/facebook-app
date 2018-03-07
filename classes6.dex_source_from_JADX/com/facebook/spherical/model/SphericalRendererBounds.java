package com.facebook.spherical.model;

/* compiled from: estimated_audio_bit_rate */
public class SphericalRendererBounds {
    public final float f16188a;
    public final float f16189b;
    public final float f16190c;
    public final float f16191d;
    public final boolean f16192e;
    public final boolean f16193f;

    /* compiled from: estimated_audio_bit_rate */
    public class Builder {
        public float f16182a = 0.0f;
        public float f16183b = 0.0f;
        public float f16184c = 0.0f;
        public float f16185d = 0.0f;
        public boolean f16186e = false;
        boolean f16187f = false;

        public final Builder m23740b() {
            this.f16187f = true;
            return this;
        }

        public final SphericalRendererBounds m23741c() {
            return new SphericalRendererBounds(this);
        }
    }

    SphericalRendererBounds(Builder builder) {
        this.f16188a = builder.f16182a;
        this.f16189b = builder.f16183b;
        this.f16190c = builder.f16184c;
        this.f16191d = builder.f16185d;
        this.f16193f = builder.f16187f;
        this.f16192e = builder.f16186e;
    }
}
