package com.facebook.livephotos.exoplayer.extractor.mp3;

import com.facebook.livephotos.exoplayer.util.MpegAudioHeader;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: page_rating_successful */
final class VbriSeeker implements Seeker {
    private final long[] f7099a;
    private final long[] f7100b;
    private final long f7101c;

    public static VbriSeeker m8965a(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        parsableByteArray.m9339c(10);
        int m = parsableByteArray.m9349m();
        if (m <= 0) {
            return null;
        }
        int i = mpegAudioHeader.f7706d;
        long a = Util.m9362a((long) m, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, (long) i);
        int g = parsableByteArray.m9344g();
        int g2 = parsableByteArray.m9344g();
        int g3 = parsableByteArray.m9344g();
        parsableByteArray.m9339c(2);
        long j3 = j + ((long) mpegAudioHeader.f7705c);
        long[] jArr = new long[(g + 1)];
        long[] jArr2 = new long[(g + 1)];
        jArr[0] = 0;
        jArr2[0] = j3;
        for (m = 1; m < jArr.length; m++) {
            int f;
            long j4;
            switch (g3) {
                case 1:
                    f = parsableByteArray.m9343f();
                    break;
                case 2:
                    f = parsableByteArray.m9344g();
                    break;
                case 3:
                    f = parsableByteArray.m9346j();
                    break;
                case 4:
                    f = parsableByteArray.m9355s();
                    break;
                default:
                    return null;
            }
            j3 += (long) (f * g2);
            jArr[m] = (((long) m) * a) / ((long) g);
            if (j2 == -1) {
                j4 = j3;
            } else {
                j4 = Math.min(j2, j3);
            }
            jArr2[m] = j4;
        }
        return new VbriSeeker(jArr, jArr2, a);
    }

    private VbriSeeker(long[] jArr, long[] jArr2, long j) {
        this.f7099a = jArr;
        this.f7100b = jArr2;
        this.f7101c = j;
    }

    public final boolean mo407a() {
        return true;
    }

    public final long mo406a(long j) {
        return this.f7100b[Util.m9361a(this.f7099a, j, true, true)];
    }

    public final long mo432b(long j) {
        return this.f7099a[Util.m9361a(this.f7100b, j, true, true)];
    }

    public final long mo431b() {
        return this.f7101c;
    }
}
