package com.facebook.livephotos.exoplayer.extractor.webm;

import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;

/* compiled from: pageUrl */
public final class VarintReader {
    private static final long[] f7541a = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] f7542b = new byte[8];
    private int f7543c;
    private int f7544d;

    public final void m9221a() {
        this.f7543c = 0;
        this.f7544d = 0;
    }

    public final long m9220a(DefaultExtractorInput defaultExtractorInput, boolean z, boolean z2, int i) {
        if (this.f7543c == 0) {
            if (!defaultExtractorInput.m8839a(this.f7542b, 0, 1, z)) {
                return -1;
            }
            this.f7544d = m9218a(this.f7542b[0] & 255);
            if (this.f7544d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f7543c = 1;
        }
        if (this.f7544d > i) {
            this.f7543c = 0;
            return -2;
        }
        if (this.f7544d != 1) {
            defaultExtractorInput.m8842b(this.f7542b, 1, this.f7544d - 1);
        }
        this.f7543c = 0;
        return m9219a(this.f7542b, this.f7544d, z2);
    }

    public final int m9222b() {
        return this.f7544d;
    }

    public static int m9218a(int i) {
        for (int i2 = 0; i2 < f7541a.length; i2++) {
            if ((f7541a[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long m9219a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= f7541a[i - 1] ^ -1;
        }
        long j2 = j;
        for (int i2 = 1; i2 < i; i2++) {
            j2 = (j2 << 8) | (((long) bArr[i2]) & 255);
        }
        return j2;
    }
}
