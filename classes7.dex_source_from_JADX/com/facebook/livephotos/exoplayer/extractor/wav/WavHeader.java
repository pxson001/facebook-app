package com.facebook.livephotos.exoplayer.extractor.wav;

/* compiled from: page_add_to_favorites_error */
public final class WavHeader {
    public final int f7521a;
    private final int f7522b;
    public final int f7523c;
    public final int f7524d;
    private final int f7525e;
    public long f7526f;
    public long f7527g;

    public WavHeader(int i, int i2, int i3, int i4, int i5) {
        this.f7521a = i;
        this.f7522b = i2;
        this.f7523c = i3;
        this.f7524d = i4;
        this.f7525e = i5;
    }

    public final long m9202a() {
        return (((this.f7527g / ((long) (this.f7524d / this.f7521a))) / ((long) this.f7521a)) * 1000000) / ((long) this.f7522b);
    }

    public final int m9203b() {
        return this.f7524d;
    }

    public final int m9205c() {
        return (this.f7522b * this.f7525e) * this.f7521a;
    }

    public final int m9206d() {
        return this.f7522b;
    }

    public final int m9207e() {
        return this.f7521a;
    }

    public final long m9204b(long j) {
        return (1000000 * j) / ((long) this.f7523c);
    }

    public final boolean m9208f() {
        return (this.f7526f == 0 || this.f7527g == 0) ? false : true;
    }
}
