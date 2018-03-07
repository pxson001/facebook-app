package com.facebook.livephotos.exoplayer.extractor.ts;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.Ac3Util;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_follow_regular_success */
public final class Ac3Reader extends ElementaryStreamReader {
    private final boolean f7328b;
    private final ParsableBitArray f7329c = new ParsableBitArray(new byte[8]);
    private final ParsableByteArray f7330d = new ParsableByteArray(this.f7329c.f7727a);
    private int f7331e = 0;
    public int f7332f;
    private boolean f7333g;
    private long f7334h;
    private MediaFormat f7335i;
    private int f7336j;
    private long f7337k;

    public Ac3Reader(TrackOutput trackOutput, boolean z) {
        super(trackOutput);
        this.f7328b = z;
    }

    public final void mo434a() {
        this.f7331e = 0;
        this.f7332f = 0;
        this.f7333g = false;
    }

    public final void mo435a(long j, boolean z) {
        this.f7337k = j;
    }

    public final void mo436a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m9336b() > 0) {
            switch (this.f7331e) {
                case 0:
                    if (!m9090b(parsableByteArray)) {
                        break;
                    }
                    this.f7331e = 1;
                    this.f7330d.f7731a[0] = (byte) 11;
                    this.f7330d.f7731a[1] = (byte) 119;
                    this.f7332f = 2;
                    break;
                case 1:
                    Object obj;
                    byte[] bArr = this.f7330d.f7731a;
                    int min = Math.min(parsableByteArray.m9336b(), 8 - this.f7332f);
                    parsableByteArray.m9335a(bArr, this.f7332f, min);
                    this.f7332f = min + this.f7332f;
                    if (this.f7332f == 8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        break;
                    }
                    m9091c();
                    this.f7330d.m9337b(0);
                    this.f7327a.mo411a(this.f7330d, 8);
                    this.f7331e = 2;
                    break;
                case 2:
                    int min2 = Math.min(parsableByteArray.m9336b(), this.f7336j - this.f7332f);
                    this.f7327a.mo411a(parsableByteArray, min2);
                    this.f7332f = min2 + this.f7332f;
                    if (this.f7332f != this.f7336j) {
                        break;
                    }
                    this.f7327a.mo409a(this.f7337k, 1, this.f7336j, 0, null);
                    this.f7337k += this.f7334h;
                    this.f7331e = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public final void mo437b() {
    }

    private boolean m9090b(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m9336b() > 0) {
            if (this.f7333g) {
                int f = parsableByteArray.m9343f();
                if (f == 119) {
                    this.f7333g = false;
                    return true;
                }
                this.f7333g = f == 11;
            } else {
                this.f7333g = parsableByteArray.m9343f() == 11;
            }
        }
        return false;
    }

    private void m9091c() {
        int b;
        if (this.f7335i == null) {
            MediaFormat a;
            if (this.f7328b) {
                int i;
                ParsableBitArray parsableBitArray = this.f7329c;
                parsableBitArray.m9324b(32);
                int c = parsableBitArray.m9326c(2);
                if (c == 3) {
                    i = Ac3Util.f7683c[parsableBitArray.m9326c(2)];
                } else {
                    parsableBitArray.m9324b(2);
                    i = Ac3Util.f7682b[c];
                }
                c = parsableBitArray.m9326c(3);
                boolean b2 = parsableBitArray.m9325b();
                String str = "audio/eac3";
                int i2 = Ac3Util.f7684d[c];
                if (b2) {
                    c = 1;
                } else {
                    c = 0;
                }
                a = MediaFormat.m8740a(null, str, -1, -1, -1, i2 + c, i, null, null);
            } else {
                a = Ac3Util.m9288a(this.f7329c, null, -1, null);
            }
            this.f7335i = a;
            this.f7327a.mo410a(this.f7335i);
        }
        if (this.f7328b) {
            b = Ac3Util.m9290b(this.f7329c.f7727a);
        } else {
            b = Ac3Util.m9287a(this.f7329c.f7727a);
        }
        this.f7336j = b;
        if (this.f7328b) {
            b = Ac3Util.m9292c(this.f7329c.f7727a);
        } else {
            b = 1536;
        }
        this.f7334h = (long) ((int) ((((long) b) * 1000000) / ((long) this.f7335i.f6860o)));
    }
}
