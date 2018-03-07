package com.facebook.android.maps.model;

import com.facebook.android.maps.model.BitmapDescriptorFactory.C09321;

/* compiled from: audio_url */
public final class MarkerOptions {
    private static final LatLng f8616a = new LatLng(0.0d, 0.0d);
    public LatLng f8617b = f8616a;
    public BitmapDescriptor f8618c = BitmapDescriptorFactory.m14557a("hue_" + 240.0f, new C09321(240.0f));
    public float f8619d = 1.0f;
    public boolean f8620e;
    public boolean f8621f;
    public float f8622g;
    public String f8623h;
    public String f8624i;
    public float f8625j;
    public boolean f8626k = true;
    private final float[] f8627l = new float[]{0.5f, 0.0f};
    private final float[] f8628m = new float[]{0.5f, 1.0f};

    public final MarkerOptions m14599a(float f, float f2) {
        this.f8628m[0] = f;
        this.f8628m[1] = f2;
        return this;
    }

    public final float m14600b() {
        return this.f8628m[0];
    }

    public final float m14601c() {
        return this.f8628m[1];
    }

    public final float m14602e() {
        return this.f8627l[0];
    }

    public final float m14603f() {
        return this.f8627l[1];
    }

    public final LatLng m14604g() {
        return this.f8617b;
    }
}
