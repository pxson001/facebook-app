package com.facebook.livephotos.exoplayer.extractor.mp4;

import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_like_successful */
public final class TrackFragment {
    public DefaultSampleValues f7239a;
    public long f7240b;
    public long f7241c;
    public int f7242d;
    public int[] f7243e;
    public int[] f7244f;
    public long[] f7245g;
    public boolean[] f7246h;
    public boolean f7247i;
    public boolean[] f7248j;
    public int f7249k;
    public ParsableByteArray f7250l;
    public boolean f7251m;

    TrackFragment() {
    }

    public final void m9048a() {
        this.f7242d = 0;
        this.f7247i = false;
        this.f7251m = false;
    }

    public final void m9049a(int i) {
        this.f7242d = i;
        if (this.f7243e == null || this.f7243e.length < this.f7242d) {
            int i2 = (i * 125) / 100;
            this.f7243e = new int[i2];
            this.f7244f = new int[i2];
            this.f7245g = new long[i2];
            this.f7246h = new boolean[i2];
            this.f7248j = new boolean[i2];
        }
    }

    public final void m9051b(int i) {
        if (this.f7250l == null || this.f7250l.f7733c < i) {
            this.f7250l = new ParsableByteArray(i);
        }
        this.f7249k = i;
        this.f7247i = true;
        this.f7251m = true;
    }

    public final void m9050a(DefaultExtractorInput defaultExtractorInput) {
        defaultExtractorInput.m8842b(this.f7250l.f7731a, 0, this.f7249k);
        this.f7250l.m9337b(0);
        this.f7251m = false;
    }

    public final long m9052c(int i) {
        return this.f7245g[i] + ((long) this.f7244f[i]);
    }
}
