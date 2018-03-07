package com.facebook.videocodec.base;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: total_assets_downloaded */
public class VideoMetadata {
    public final long f5480a;
    public final int f5481b;
    public final int f5482c;
    public final int f5483d;
    public final int f5484e;
    public final long f5485f;
    public final int f5486g;
    public final SphericalMetadata f5487h;
    public String f5488i;
    public String f5489j;

    public final boolean m8159a() {
        return this.f5487h != null && this.f5487h.f5477a;
    }

    public VideoMetadata(long j, int i, int i2, int i3, int i4, long j2, int i5, SphericalMetadata sphericalMetadata, String str, String str2) {
        this.f5480a = j;
        this.f5481b = i;
        this.f5482c = i2;
        this.f5483d = i3;
        this.f5484e = i4;
        this.f5485f = j2;
        this.f5486g = i5;
        this.f5487h = sphericalMetadata;
        this.f5488i = str;
        this.f5489j = str2;
    }
}
