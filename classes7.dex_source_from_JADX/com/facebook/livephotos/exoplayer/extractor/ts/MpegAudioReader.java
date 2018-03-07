package com.facebook.livephotos.exoplayer.extractor.ts;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.MpegAudioHeader;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_edit_review_privacy_success */
public final class MpegAudioReader extends ElementaryStreamReader {
    public final ParsableByteArray f7453b = new ParsableByteArray(4);
    private final MpegAudioHeader f7454c;
    public int f7455d = 0;
    public int f7456e;
    private boolean f7457f;
    public boolean f7458g;
    private long f7459h;
    private int f7460i;
    private long f7461j;

    public MpegAudioReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.f7453b.f7731a[0] = (byte) -1;
        this.f7454c = new MpegAudioHeader();
    }

    public final void mo434a() {
        this.f7455d = 0;
        this.f7456e = 0;
        this.f7458g = false;
    }

    public final void mo435a(long j, boolean z) {
        this.f7461j = j;
    }

    public final void mo436a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m9336b() > 0) {
            switch (this.f7455d) {
                case 0:
                    byte[] bArr = parsableByteArray.f7731a;
                    int i = parsableByteArray.f7732b;
                    int i2 = parsableByteArray.f7733c;
                    int i3 = i;
                    while (i3 < i2) {
                        int i4;
                        boolean z = (bArr[i3] & 255) == 255;
                        if (this.f7458g && (bArr[i3] & 224) == 224) {
                            i4 = 1;
                        } else {
                            boolean z2 = false;
                        }
                        this.f7458g = z;
                        if (i4 != 0) {
                            parsableByteArray.m9337b(i3 + 1);
                            this.f7458g = false;
                            this.f7453b.f7731a[1] = bArr[i3];
                            this.f7456e = 2;
                            this.f7455d = 1;
                            break;
                        }
                        i3++;
                    }
                    parsableByteArray.m9337b(i2);
                    break;
                case 1:
                    m9158c(parsableByteArray);
                    break;
                case 2:
                    m9159d(parsableByteArray);
                    break;
                default:
                    break;
            }
        }
    }

    public final void mo437b() {
    }

    private void m9158c(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.m9336b(), 4 - this.f7456e);
        parsableByteArray.m9335a(this.f7453b.f7731a, this.f7456e, min);
        this.f7456e = min + this.f7456e;
        if (this.f7456e >= 4) {
            this.f7453b.m9337b(0);
            if (MpegAudioHeader.m9309a(this.f7453b.m9349m(), this.f7454c)) {
                this.f7460i = this.f7454c.f7705c;
                if (!this.f7457f) {
                    this.f7459h = (1000000 * ((long) this.f7454c.f7709g)) / ((long) this.f7454c.f7706d);
                    this.f7327a.mo410a(MediaFormat.m8740a(null, this.f7454c.f7704b, -1, 4096, -1, this.f7454c.f7707e, this.f7454c.f7706d, null, null));
                    this.f7457f = true;
                }
                this.f7453b.m9337b(0);
                this.f7327a.mo411a(this.f7453b, 4);
                this.f7455d = 2;
                return;
            }
            this.f7456e = 0;
            this.f7455d = 1;
        }
    }

    private void m9159d(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.m9336b(), this.f7460i - this.f7456e);
        this.f7327a.mo411a(parsableByteArray, min);
        this.f7456e = min + this.f7456e;
        if (this.f7456e >= this.f7460i) {
            this.f7327a.mo409a(this.f7461j, 1, this.f7460i, 0, null);
            this.f7461j += this.f7459h;
            this.f7456e = 0;
            this.f7455d = 0;
        }
    }
}
