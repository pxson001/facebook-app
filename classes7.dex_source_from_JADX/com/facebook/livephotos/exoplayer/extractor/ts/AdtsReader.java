package com.facebook.livephotos.exoplayer.extractor.ts;

import android.util.Log;
import android.util.Pair;
import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.CodecSpecificDataUtil;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: page_follow_error */
public final class AdtsReader extends ElementaryStreamReader {
    public static final byte[] f7343b = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    private final ParsableBitArray f7344c = new ParsableBitArray(new byte[7]);
    public final ParsableByteArray f7345d = new ParsableByteArray(Arrays.copyOf(f7343b, 10));
    private final TrackOutput f7346e;
    public int f7347f;
    public int f7348g;
    public int f7349h;
    public boolean f7350i;
    private boolean f7351j;
    private long f7352k;
    public int f7353l;
    private long f7354m;
    private TrackOutput f7355n;
    private long f7356o;

    public AdtsReader(TrackOutput trackOutput, TrackOutput trackOutput2) {
        super(trackOutput);
        this.f7346e = trackOutput2;
        trackOutput2.mo410a(MediaFormat.m8738a());
        m9102c();
    }

    public final void mo434a() {
        m9102c();
    }

    public final void mo435a(long j, boolean z) {
        this.f7354m = j;
    }

    public final void mo436a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m9336b() > 0) {
            switch (this.f7347f) {
                case 0:
                    byte[] bArr = parsableByteArray.f7731a;
                    int i = parsableByteArray.f7732b;
                    int i2 = parsableByteArray.f7733c;
                    int i3 = i;
                    while (i3 < i2) {
                        i = i3 + 1;
                        i3 = bArr[i3] & 255;
                        if (this.f7349h == 512 && i3 >= 240 && i3 != 255) {
                            this.f7350i = (i3 & 1) == 0;
                            this.f7347f = 2;
                            this.f7348g = 0;
                            parsableByteArray.m9337b(i);
                            break;
                        }
                        switch (i3 | this.f7349h) {
                            case 329:
                                this.f7349h = 768;
                                i3 = i;
                                break;
                            case 511:
                                this.f7349h = 512;
                                i3 = i;
                                break;
                            case 836:
                                this.f7349h = 1024;
                                i3 = i;
                                break;
                            case 1075:
                                this.f7347f = 1;
                                this.f7348g = f7343b.length;
                                this.f7353l = 0;
                                this.f7345d.m9337b(0);
                                parsableByteArray.m9337b(i);
                                break;
                            default:
                                if (this.f7349h == 256) {
                                    i3 = i;
                                    break;
                                }
                                this.f7349h = 256;
                                i3 = i - 1;
                                break;
                        }
                    }
                    parsableByteArray.m9337b(i3);
                    break;
                case 1:
                    if (!m9101a(parsableByteArray, this.f7345d.f7731a, 10)) {
                        break;
                    }
                    m9104f();
                    break;
                case 2:
                    if (!m9101a(parsableByteArray, this.f7344c.f7727a, this.f7350i ? 7 : 5)) {
                        break;
                    }
                    m9105g();
                    break;
                case 3:
                    m9103c(parsableByteArray);
                    break;
                default:
                    break;
            }
        }
    }

    public final void mo437b() {
    }

    private boolean m9101a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.m9336b(), i - this.f7348g);
        parsableByteArray.m9335a(bArr, this.f7348g, min);
        this.f7348g = min + this.f7348g;
        return this.f7348g == i;
    }

    private void m9102c() {
        this.f7347f = 0;
        this.f7348g = 0;
        this.f7349h = 256;
    }

    private void m9100a(TrackOutput trackOutput, long j, int i, int i2) {
        this.f7347f = 3;
        this.f7348g = i;
        this.f7355n = trackOutput;
        this.f7356o = j;
        this.f7353l = i2;
    }

    private void m9104f() {
        this.f7346e.mo411a(this.f7345d, 10);
        this.f7345d.m9337b(6);
        m9100a(this.f7346e, 0, 10, this.f7345d.m9354r() + 10);
    }

    private void m9105g() {
        int i = 2;
        this.f7344c.m9322a(0);
        if (this.f7351j) {
            this.f7344c.m9324b(10);
        } else {
            int c = this.f7344c.m9326c(2) + 1;
            if (c == 1) {
                Log.w("AdtsReader", "Detected AAC Main audio, but assuming AAC LC.");
            } else {
                i = c;
            }
            c = this.f7344c.m9326c(4);
            this.f7344c.m9324b(1);
            Object a = CodecSpecificDataUtil.m9300a(i, c, this.f7344c.m9326c(3));
            Pair a2 = CodecSpecificDataUtil.m9299a(a);
            MediaFormat a3 = MediaFormat.m8740a(null, "audio/mp4a-latm", -1, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(a), null);
            this.f7352k = 1024000000 / ((long) a3.f6860o);
            this.f7327a.mo410a(a3);
            this.f7351j = true;
        }
        this.f7344c.m9324b(4);
        int c2 = (this.f7344c.m9326c(13) - 2) - 5;
        if (this.f7350i) {
            c2 -= 2;
        }
        m9100a(this.f7327a, this.f7352k, 0, c2);
    }

    private void m9103c(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.m9336b(), this.f7353l - this.f7348g);
        this.f7355n.mo411a(parsableByteArray, min);
        this.f7348g = min + this.f7348g;
        if (this.f7348g == this.f7353l) {
            this.f7355n.mo409a(this.f7354m, 1, this.f7353l, 0, null);
            this.f7354m += this.f7356o;
            m9102c();
        }
    }
}
