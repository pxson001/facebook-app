package com.facebook.livephotos.exoplayer.extractor.ts;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.DtsUtil;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_feed_id */
public final class DtsReader extends ElementaryStreamReader {
    private final ParsableByteArray f7357b = new ParsableByteArray(new byte[15]);
    private int f7358c;
    public int f7359d;
    public int f7360e;
    private long f7361f;
    private MediaFormat f7362g;
    private int f7363h;
    private long f7364i;

    public DtsReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.f7357b.f7731a[0] = Byte.MAX_VALUE;
        this.f7357b.f7731a[1] = (byte) -2;
        this.f7357b.f7731a[2] = Byte.MIN_VALUE;
        this.f7357b.f7731a[3] = (byte) 1;
        this.f7358c = 0;
    }

    public final void mo434a() {
        this.f7358c = 0;
        this.f7359d = 0;
        this.f7360e = 0;
    }

    public final void mo435a(long j, boolean z) {
        this.f7364i = j;
    }

    public final void mo436a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m9336b() > 0) {
            int i;
            switch (this.f7358c) {
                case 0:
                    i = 0;
                    while (parsableByteArray.m9336b() > 0) {
                        this.f7360e <<= 8;
                        this.f7360e |= parsableByteArray.m9343f();
                        if (this.f7360e == 2147385345) {
                            this.f7360e = 0;
                            i = 1;
                            if (i == 0) {
                                break;
                            }
                            this.f7359d = 4;
                            this.f7358c = 1;
                            break;
                        }
                    }
                    if (i == 0) {
                        this.f7359d = 4;
                        this.f7358c = 1;
                    }
                case 1:
                    Object obj;
                    byte[] bArr = this.f7357b.f7731a;
                    i = Math.min(parsableByteArray.m9336b(), 15 - this.f7359d);
                    parsableByteArray.m9335a(bArr, this.f7359d, i);
                    this.f7359d = i + this.f7359d;
                    if (this.f7359d == 15) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        break;
                    }
                    m9110c();
                    this.f7357b.m9337b(0);
                    this.f7327a.mo411a(this.f7357b, 15);
                    this.f7358c = 2;
                    break;
                case 2:
                    int min = Math.min(parsableByteArray.m9336b(), this.f7363h - this.f7359d);
                    this.f7327a.mo411a(parsableByteArray, min);
                    this.f7359d = min + this.f7359d;
                    if (this.f7359d != this.f7363h) {
                        break;
                    }
                    this.f7327a.mo409a(this.f7364i, 1, this.f7363h, 0, null);
                    this.f7364i += this.f7361f;
                    this.f7358c = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public final void mo437b() {
    }

    private void m9110c() {
        byte[] bArr = this.f7357b.f7731a;
        if (this.f7362g == null) {
            this.f7362g = DtsUtil.m9301a(bArr, null, -1, null);
            this.f7327a.mo410a(this.f7362g);
        }
        this.f7363h = ((((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) | ((bArr[7] & 240) >> 4)) + 1;
        this.f7361f = (long) ((int) ((((long) (((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32)) * 1000000) / ((long) this.f7362g.f6860o)));
    }
}
