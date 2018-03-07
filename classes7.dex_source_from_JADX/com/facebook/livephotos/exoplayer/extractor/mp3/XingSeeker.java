package com.facebook.livephotos.exoplayer.extractor.mp3;

import com.facebook.livephotos.exoplayer.util.MpegAudioHeader;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: page_rating_error */
final class XingSeeker implements Seeker {
    private final long f7102a;
    private final long f7103b;
    private final long f7104c;
    private final long[] f7105d;
    private final long f7106e;
    private final int f7107g;

    public static XingSeeker m8971a(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        int i = mpegAudioHeader.f7709g;
        int i2 = mpegAudioHeader.f7706d;
        long j3 = j + ((long) mpegAudioHeader.f7705c);
        int m = parsableByteArray.m9349m();
        if ((m & 1) == 1) {
            int s = parsableByteArray.m9355s();
            if (s != 0) {
                long a = Util.m9362a((long) s, ((long) i) * 1000000, (long) i2);
                if ((m & 6) != 6) {
                    return new XingSeeker(j3, a, j2);
                }
                long s2 = (long) parsableByteArray.m9355s();
                parsableByteArray.m9339c(1);
                long[] jArr = new long[99];
                for (s = 0; s < 99; s++) {
                    jArr[s] = (long) parsableByteArray.m9343f();
                }
                return new XingSeeker(j3, a, j2, jArr, s2, mpegAudioHeader.f7705c);
            }
        }
        return null;
    }

    private XingSeeker(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    private XingSeeker(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f7102a = j;
        this.f7103b = j2;
        this.f7104c = j3;
        this.f7105d = jArr;
        this.f7106e = j4;
        this.f7107g = i;
    }

    public final boolean mo407a() {
        return this.f7105d != null;
    }

    public final long mo406a(long j) {
        float f = 256.0f;
        float f2 = 0.0f;
        if (!mo407a()) {
            return this.f7102a;
        }
        float f3 = (((float) j) * 100.0f) / ((float) this.f7103b);
        if (f3 <= 0.0f) {
            f = 0.0f;
        } else if (f3 < 100.0f) {
            int i = (int) f3;
            if (i != 0) {
                f2 = (float) this.f7105d[i - 1];
            }
            if (i < 99) {
                f = (float) this.f7105d[i];
            }
            f = ((f - f2) * (f3 - ((float) i))) + f2;
        }
        return Math.min(this.f7102a + Math.round((((double) f) * 0.00390625d) * ((double) this.f7106e)), this.f7104c != -1 ? this.f7104c - 1 : ((this.f7102a - ((long) this.f7107g)) + this.f7106e) - 1);
    }

    public final long mo432b(long j) {
        if (!mo407a() || j < this.f7102a) {
            return 0;
        }
        double d = (256.0d * ((double) (j - this.f7102a))) / ((double) this.f7106e);
        int a = Util.m9361a(this.f7105d, (long) d, true, false) + 1;
        long a2 = m8970a(a);
        long j2 = a == 0 ? 0 : this.f7105d[a - 1];
        long j3 = a == 99 ? 256 : this.f7105d[a];
        return a2 + (j3 == j2 ? 0 : (long) ((((double) (m8970a(a + 1) - a2)) * (d - ((double) j2))) / ((double) (j3 - j2))));
    }

    public final long mo431b() {
        return this.f7103b;
    }

    private long m8970a(int i) {
        return (this.f7103b * ((long) i)) / 100;
    }
}
