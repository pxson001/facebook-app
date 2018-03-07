package com.facebook.livephotos.exoplayer.extractor.ts;

import android.util.Log;
import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.Collections;

/* compiled from: page_event_status_update_failure */
final class H265Reader extends ElementaryStreamReader {
    private boolean f7436b;
    private final SeiReader f7437c;
    private final boolean[] f7438d = new boolean[3];
    private final NalUnitTargetBuffer f7439e = new NalUnitTargetBuffer(32, 128);
    private final NalUnitTargetBuffer f7440f = new NalUnitTargetBuffer(33, 128);
    private final NalUnitTargetBuffer f7441g = new NalUnitTargetBuffer(34, 128);
    private final NalUnitTargetBuffer f7442h = new NalUnitTargetBuffer(39, 128);
    private final NalUnitTargetBuffer f7443i = new NalUnitTargetBuffer(40, 128);
    private final SampleReader f7444j;
    private long f7445k;
    private long f7446l;
    private final ParsableByteArray f7447m;

    /* compiled from: page_event_status_update_failure */
    public final class SampleReader {
        private final TrackOutput f7425a;
        private long f7426b;
        private boolean f7427c;
        public int f7428d;
        private long f7429e;
        public boolean f7430f;
        public boolean f7431g;
        public boolean f7432h;
        private long f7433i;
        private long f7434j;
        private boolean f7435k;

        public SampleReader(TrackOutput trackOutput) {
            this.f7425a = trackOutput;
        }

        public final void m9143a(long j, int i, int i2, long j2) {
            boolean z;
            boolean z2 = false;
            this.f7431g = false;
            this.f7429e = j2;
            this.f7428d = 0;
            this.f7426b = j;
            if (i2 >= 32 && this.f7432h) {
                m9141a(i);
                this.f7432h = false;
            }
            if (i2 < 16 || i2 > 21) {
                z = false;
            } else {
                z = true;
            }
            this.f7427c = z;
            if (this.f7427c || i2 <= 9) {
                z2 = true;
            }
            this.f7430f = z2;
        }

        public final void m9142a(long j, int i) {
            if (this.f7431g) {
                if (this.f7432h) {
                    m9141a(((int) (j - this.f7426b)) + i);
                }
                this.f7433i = this.f7426b;
                this.f7434j = this.f7429e;
                this.f7432h = true;
                this.f7435k = this.f7427c;
            }
        }

        private void m9141a(int i) {
            this.f7425a.mo409a(this.f7434j, this.f7435k ? 1 : 0, (int) (this.f7426b - this.f7433i), i, null);
        }
    }

    public H265Reader(TrackOutput trackOutput, SeiReader seiReader) {
        super(trackOutput);
        this.f7437c = seiReader;
        this.f7444j = new SampleReader(trackOutput);
        this.f7447m = new ParsableByteArray();
    }

    public final void mo434a() {
        NalUnitUtil.m9316a(this.f7438d);
        this.f7439e.m9164a();
        this.f7440f.m9164a();
        this.f7441g.m9164a();
        this.f7442h.m9164a();
        this.f7443i.m9164a();
        SampleReader sampleReader = this.f7444j;
        sampleReader.f7430f = false;
        sampleReader.f7431g = false;
        sampleReader.f7432h = false;
        this.f7445k = 0;
    }

    public final void mo435a(long j, boolean z) {
        this.f7446l = j;
    }

    public final void mo436a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m9336b() > 0) {
            int i = parsableByteArray.f7732b;
            int i2 = parsableByteArray.f7733c;
            byte[] bArr = parsableByteArray.f7731a;
            this.f7445k += (long) parsableByteArray.m9336b();
            this.f7327a.mo411a(parsableByteArray, parsableByteArray.m9336b());
            while (i < i2) {
                int a = NalUnitUtil.m9312a(bArr, i, i2, this.f7438d);
                if (a == i2) {
                    m9147a(bArr, i, i2);
                    return;
                }
                int i3 = (bArr[a + 3] & 126) >> 1;
                int i4 = a - i;
                if (i4 > 0) {
                    m9147a(bArr, i, a);
                }
                int i5 = i2 - a;
                long j = this.f7445k - ((long) i5);
                m9148b(j, i5, i4 < 0 ? -i4 : 0, this.f7446l);
                m9145a(j, i5, i3, this.f7446l);
                i = a + 3;
            }
        }
    }

    public final void mo437b() {
    }

    private void m9145a(long j, int i, int i2, long j2) {
        if (!this.f7436b) {
            this.f7439e.m9165a(i2);
            this.f7440f.m9165a(i2);
            this.f7441g.m9165a(i2);
        }
        this.f7442h.m9165a(i2);
        this.f7443i.m9165a(i2);
        this.f7444j.m9143a(j, i, i2, j2);
    }

    private void m9147a(byte[] bArr, int i, int i2) {
        if (this.f7436b) {
            SampleReader sampleReader = this.f7444j;
            if (sampleReader.f7430f) {
                int i3 = (i + 2) - sampleReader.f7428d;
                if (i3 < i2) {
                    sampleReader.f7431g = (bArr[i3] & 128) != 0;
                    sampleReader.f7430f = false;
                } else {
                    sampleReader.f7428d += i2 - i;
                }
            }
        } else {
            this.f7439e.m9166a(bArr, i, i2);
            this.f7440f.m9166a(bArr, i, i2);
            this.f7441g.m9166a(bArr, i, i2);
        }
        this.f7442h.m9166a(bArr, i, i2);
        this.f7443i.m9166a(bArr, i, i2);
    }

    private void m9148b(long j, int i, int i2, long j2) {
        if (this.f7436b) {
            this.f7444j.m9142a(j, i);
        } else {
            this.f7439e.m9168b(i2);
            this.f7440f.m9168b(i2);
            this.f7441g.m9168b(i2);
            if (this.f7439e.f7466e && this.f7440f.f7466e && this.f7441g.f7466e) {
                this.f7327a.mo410a(m9144a(this.f7439e, this.f7440f, this.f7441g));
                this.f7436b = true;
            }
        }
        if (this.f7442h.m9168b(i2)) {
            this.f7447m.m9334a(this.f7442h.f7462a, NalUnitUtil.m9310a(this.f7442h.f7462a, this.f7442h.f7463b));
            this.f7447m.m9339c(5);
            this.f7437c.m9178a(j2, this.f7447m);
        }
        if (this.f7443i.m9168b(i2)) {
            this.f7447m.m9334a(this.f7443i.f7462a, NalUnitUtil.m9310a(this.f7443i.f7462a, this.f7443i.f7463b));
            this.f7447m.m9339c(5);
            this.f7437c.m9178a(j2, this.f7447m);
        }
    }

    private static MediaFormat m9144a(NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i;
        float f;
        Object obj = new byte[((nalUnitTargetBuffer.f7463b + nalUnitTargetBuffer2.f7463b) + nalUnitTargetBuffer3.f7463b)];
        System.arraycopy(nalUnitTargetBuffer.f7462a, 0, obj, 0, nalUnitTargetBuffer.f7463b);
        System.arraycopy(nalUnitTargetBuffer2.f7462a, 0, obj, nalUnitTargetBuffer.f7463b, nalUnitTargetBuffer2.f7463b);
        System.arraycopy(nalUnitTargetBuffer3.f7462a, 0, obj, nalUnitTargetBuffer.f7463b + nalUnitTargetBuffer2.f7463b, nalUnitTargetBuffer3.f7463b);
        NalUnitUtil.m9310a(nalUnitTargetBuffer2.f7462a, nalUnitTargetBuffer2.f7463b);
        ParsableBitArray parsableBitArray = new ParsableBitArray(nalUnitTargetBuffer2.f7462a);
        parsableBitArray.m9324b(44);
        int c = parsableBitArray.m9326c(3);
        parsableBitArray.m9324b(1);
        parsableBitArray.m9324b(88);
        parsableBitArray.m9324b(8);
        int i2 = 0;
        for (i = 0; i < c; i++) {
            if (parsableBitArray.m9325b()) {
                i2 += 89;
            }
            if (parsableBitArray.m9325b()) {
                i2 += 8;
            }
        }
        parsableBitArray.m9324b(i2);
        if (c > 0) {
            parsableBitArray.m9324b((8 - c) * 2);
        }
        parsableBitArray.m9328d();
        int d = parsableBitArray.m9328d();
        if (d == 3) {
            parsableBitArray.m9324b(1);
        }
        int d2 = parsableBitArray.m9328d();
        int d3 = parsableBitArray.m9328d();
        if (parsableBitArray.m9325b()) {
            int d4 = parsableBitArray.m9328d();
            int d5 = parsableBitArray.m9328d();
            int d6 = parsableBitArray.m9328d();
            int d7 = parsableBitArray.m9328d();
            i = (d == 1 || d == 2) ? 2 : 1;
            d2 -= i * (d4 + d5);
            d3 -= (d == 1 ? 2 : 1) * (d6 + d7);
        }
        parsableBitArray.m9328d();
        parsableBitArray.m9328d();
        i = parsableBitArray.m9328d();
        i2 = parsableBitArray.m9325b() ? 0 : c;
        while (i2 <= c) {
            parsableBitArray.m9328d();
            parsableBitArray.m9328d();
            parsableBitArray.m9328d();
            i2++;
        }
        parsableBitArray.m9328d();
        parsableBitArray.m9328d();
        parsableBitArray.m9328d();
        parsableBitArray.m9328d();
        parsableBitArray.m9328d();
        parsableBitArray.m9328d();
        if (parsableBitArray.m9325b() && parsableBitArray.m9325b()) {
            m9146a(parsableBitArray);
        }
        parsableBitArray.m9324b(2);
        if (parsableBitArray.m9325b()) {
            parsableBitArray.m9324b(8);
            parsableBitArray.m9328d();
            parsableBitArray.m9328d();
            parsableBitArray.m9324b(1);
        }
        m9149b(parsableBitArray);
        if (parsableBitArray.m9325b()) {
            for (i2 = 0; i2 < parsableBitArray.m9328d(); i2++) {
                parsableBitArray.m9324b((i + 4) + 1);
            }
        }
        parsableBitArray.m9324b(2);
        float f2 = 1.0f;
        if (parsableBitArray.m9325b() && parsableBitArray.m9325b()) {
            c = parsableBitArray.m9326c(8);
            if (c == 255) {
                c = parsableBitArray.m9326c(16);
                i = parsableBitArray.m9326c(16);
                if (!(c == 0 || i == 0)) {
                    f2 = ((float) c) / ((float) i);
                }
                f = f2;
            } else if (c < NalUnitUtil.f7724b.length) {
                f = NalUnitUtil.f7724b[c];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + c);
            }
            return MediaFormat.m8739a(null, "video/hevc", -1, -1, -1, d2, d3, Collections.singletonList(obj), -1, f);
        }
        f = 1.0f;
        return MediaFormat.m8739a(null, "video/hevc", -1, -1, -1, d2, d3, Collections.singletonList(obj), -1, f);
    }

    private static void m9146a(ParsableBitArray parsableBitArray) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (parsableBitArray.m9325b()) {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        parsableBitArray.m9329e();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        parsableBitArray.m9329e();
                    }
                } else {
                    parsableBitArray.m9328d();
                }
            }
            i++;
        }
    }

    private static void m9149b(ParsableBitArray parsableBitArray) {
        int d = parsableBitArray.m9328d();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < d) {
            boolean b;
            if (i != 0) {
                b = parsableBitArray.m9325b();
            } else {
                b = z;
            }
            int i3;
            if (b) {
                parsableBitArray.m9324b(1);
                parsableBitArray.m9328d();
                for (i3 = 0; i3 <= i2; i3++) {
                    if (parsableBitArray.m9325b()) {
                        parsableBitArray.m9324b(1);
                    }
                }
            } else {
                int d2 = parsableBitArray.m9328d();
                int d3 = parsableBitArray.m9328d();
                i2 = d2 + d3;
                for (i3 = 0; i3 < d2; i3++) {
                    parsableBitArray.m9328d();
                    parsableBitArray.m9324b(1);
                }
                for (i3 = 0; i3 < d3; i3++) {
                    parsableBitArray.m9328d();
                    parsableBitArray.m9324b(1);
                }
            }
            i++;
            z = b;
        }
    }
}
