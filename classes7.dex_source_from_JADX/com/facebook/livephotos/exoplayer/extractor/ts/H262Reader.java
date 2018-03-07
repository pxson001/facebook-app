package com.facebook.livephotos.exoplayer.extractor.ts;

import android.util.Pair;
import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: page_featured_admin_info */
final class H262Reader extends ElementaryStreamReader {
    private static final double[] f7369b = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private boolean f7370c;
    private long f7371d;
    private final boolean[] f7372e = new boolean[4];
    private final CsdBuffer f7373f = new CsdBuffer(128);
    private boolean f7374g;
    private long f7375h;
    private long f7376i;
    private boolean f7377j;
    private boolean f7378k;
    private long f7379l;
    private long f7380m;

    /* compiled from: page_featured_admin_info */
    public final class CsdBuffer {
        public int f7365a;
        public int f7366b;
        public byte[] f7367c;
        public boolean f7368d;

        public CsdBuffer(int i) {
            this.f7367c = new byte[i];
        }

        public final boolean m9116a(int i, int i2) {
            if (this.f7368d) {
                if (this.f7366b == 0 && i == 181) {
                    this.f7366b = this.f7365a;
                } else {
                    this.f7365a -= i2;
                    this.f7368d = false;
                    return true;
                }
            } else if (i == 179) {
                this.f7368d = true;
            }
            return false;
        }

        public final void m9115a(byte[] bArr, int i, int i2) {
            if (this.f7368d) {
                int i3 = i2 - i;
                if (this.f7367c.length < this.f7365a + i3) {
                    this.f7367c = Arrays.copyOf(this.f7367c, (this.f7365a + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f7367c, this.f7365a, i3);
                this.f7365a = i3 + this.f7365a;
            }
        }
    }

    public H262Reader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    public final void mo434a() {
        NalUnitUtil.m9316a(this.f7372e);
        CsdBuffer csdBuffer = this.f7373f;
        csdBuffer.f7368d = false;
        csdBuffer.f7365a = 0;
        csdBuffer.f7366b = 0;
        this.f7377j = false;
        this.f7374g = false;
        this.f7375h = 0;
    }

    public final void mo435a(long j, boolean z) {
        this.f7377j = j != -1;
        if (this.f7377j) {
            this.f7376i = j;
        }
    }

    public final void mo436a(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.m9336b() > 0) {
            int i = parsableByteArray.f7732b;
            int i2 = parsableByteArray.f7733c;
            byte[] bArr = parsableByteArray.f7731a;
            this.f7375h += (long) parsableByteArray.m9336b();
            this.f7327a.mo411a(parsableByteArray, parsableByteArray.m9336b());
            int i3 = i;
            while (true) {
                int a = NalUnitUtil.m9312a(bArr, i, i2, this.f7372e);
                if (a == i2) {
                    break;
                }
                int i4 = parsableByteArray.f7731a[a + 3] & 255;
                if (!this.f7370c) {
                    i = a - i3;
                    if (i > 0) {
                        this.f7373f.m9115a(bArr, i3, a);
                    }
                    if (this.f7373f.m9116a(i4, i < 0 ? -i : 0)) {
                        Pair a2 = m9117a(this.f7373f);
                        this.f7327a.mo410a((MediaFormat) a2.first);
                        this.f7371d = ((Long) a2.second).longValue();
                        this.f7370c = true;
                    }
                }
                if (this.f7370c && (i4 == 184 || i4 == 0)) {
                    int i5 = i2 - a;
                    if (this.f7374g) {
                        this.f7327a.mo409a(this.f7380m, this.f7378k ? 1 : 0, ((int) (this.f7375h - this.f7379l)) - i5, i5, null);
                        this.f7378k = false;
                    }
                    if (i4 == 184) {
                        this.f7374g = false;
                        this.f7378k = true;
                    } else {
                        this.f7380m = this.f7377j ? this.f7376i : this.f7380m + this.f7371d;
                        this.f7379l = this.f7375h - ((long) i5);
                        this.f7377j = false;
                        this.f7374g = true;
                    }
                }
                i = a + 3;
                i3 = a;
            }
            if (!this.f7370c) {
                this.f7373f.m9115a(bArr, i3, i2);
            }
        }
    }

    public final void mo437b() {
    }

    private static Pair<MediaFormat, Long> m9117a(CsdBuffer csdBuffer) {
        Object copyOf = Arrays.copyOf(csdBuffer.f7367c, csdBuffer.f7365a);
        int i = copyOf[5] & 255;
        int i2 = ((copyOf[4] & 255) << 4) | (i >> 4);
        int i3 = ((i & 15) << 8) | (copyOf[6] & 255);
        float f = 1.0f;
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                f = ((float) (i3 * 4)) / ((float) (i2 * 3));
                break;
            case 3:
                f = ((float) (i3 * 16)) / ((float) (i2 * 9));
                break;
            case 4:
                f = ((float) (i3 * 121)) / ((float) (i2 * 100));
                break;
        }
        MediaFormat a = MediaFormat.m8739a(null, "video/mpeg2", -1, -1, -1, i2, i3, Collections.singletonList(copyOf), -1, f);
        long j = 0;
        int i4 = (copyOf[7] & 15) - 1;
        if (i4 >= 0 && i4 < f7369b.length) {
            double d = f7369b[i4];
            i4 = csdBuffer.f7366b;
            int i5 = (copyOf[i4 + 9] & 96) >> 5;
            i4 = copyOf[i4 + 9] & 31;
            if (i5 != i4) {
                d *= (((double) i5) + 1.0d) / ((double) (i4 + 1));
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(a, Long.valueOf(j));
    }
}
