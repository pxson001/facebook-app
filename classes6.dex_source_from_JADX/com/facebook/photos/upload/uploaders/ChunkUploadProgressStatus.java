package com.facebook.photos.upload.uploaders;

/* compiled from: from_payment_trigger */
public class ChunkUploadProgressStatus {
    long f14300a = -1;
    long f14301b = -1;
    long f14302c = -1;
    public float f14303d = -1.0f;
    float f14304e = -1.0f;
    long f14305f = -1;
    long f14306g = -1;
    public final String f14307h;

    public ChunkUploadProgressStatus(long j, float f, float f2, long j2, long j3, String str) {
        this.f14302c = j;
        this.f14303d = f;
        this.f14304e = f2;
        this.f14300a = j2;
        this.f14301b = j3;
        this.f14307h = str;
    }

    public final String m21958a() {
        return this.f14307h;
    }

    public final long m21959b() {
        return this.f14300a;
    }

    public final long m21960c() {
        return this.f14301b;
    }

    public final long m21961d() {
        return this.f14302c;
    }

    public final float m21962e() {
        return this.f14303d;
    }

    public final float m21963f() {
        return this.f14304e;
    }

    public final long m21964g() {
        return this.f14305f;
    }

    public final long m21965h() {
        return this.f14306g;
    }
}
