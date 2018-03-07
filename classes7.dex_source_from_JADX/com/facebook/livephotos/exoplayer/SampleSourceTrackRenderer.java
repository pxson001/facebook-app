package com.facebook.livephotos.exoplayer;

import com.facebook.livephotos.exoplayer.SampleSource.SampleSourceReader;
import java.util.Arrays;

/* compiled from: paints */
public abstract class SampleSourceTrackRenderer extends TrackRenderer {
    private final SampleSourceReader[] f6749a;
    private int[] f6750b;
    private int[] f6751c;
    private SampleSourceReader f6752d;
    private int f6753e;
    private long f6754f;

    protected abstract void mo375a(long j);

    protected abstract void mo376a(long j, long j2, boolean z);

    protected abstract boolean mo377a(MediaFormat mediaFormat);

    public SampleSourceTrackRenderer(SampleSource... sampleSourceArr) {
        this.f6749a = new SampleSourceReader[sampleSourceArr.length];
        for (int i = 0; i < sampleSourceArr.length; i++) {
            this.f6749a[i] = sampleSourceArr[i].mo414a();
        }
    }

    protected final boolean mo367b(long j) {
        int i;
        int i2 = 1;
        for (SampleSourceReader c : this.f6749a) {
            i2 &= c.mo421c();
        }
        if (i2 == 0) {
            return false;
        }
        i2 = 0;
        for (SampleSourceReader c2 : this.f6749a) {
            i2 += c2.mo422d();
        }
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int length = this.f6749a.length;
        i2 = 0;
        long j2 = 0;
        int i3 = 0;
        while (i3 < length) {
            SampleSourceReader sampleSourceReader = this.f6749a[i3];
            int d = sampleSourceReader.mo422d();
            i = i2;
            i2 = 0;
            while (i2 < d) {
                MediaFormat a = sampleSourceReader.mo413a(i2);
                try {
                    if (mo377a(a)) {
                        iArr[i] = i3;
                        iArr2[i] = i2;
                        i++;
                        if (j2 != -1) {
                            long j3 = a.f6850e;
                            if (j3 == -1) {
                                j2 = -1;
                            } else if (j3 != -2) {
                                j2 = Math.max(j2, j3);
                            }
                        }
                    }
                    i2++;
                } catch (Throwable e) {
                    throw new ExoPlaybackException(e);
                }
            }
            i3++;
            i2 = i;
        }
        this.f6754f = j2;
        this.f6750b = Arrays.copyOf(iArr, i2);
        this.f6751c = Arrays.copyOf(iArr2, i2);
        return true;
    }

    protected final long mo370n() {
        return this.f6752d.mo423e();
    }

    protected long mo371o() {
        return this.f6754f;
    }

    protected final void mo372p() {
        if (this.f6752d != null) {
            m8623a(this.f6752d);
            return;
        }
        for (SampleSourceReader a : this.f6749a) {
            m8623a(a);
        }
    }

    protected void mo369g() {
        this.f6752d.mo420c(this.f6753e);
        this.f6752d = null;
    }

    protected final void mo373q() {
        for (SampleSourceReader f : this.f6749a) {
            f.mo424f();
        }
    }

    protected final int mo374r() {
        return this.f6751c.length;
    }

    protected final MediaFormat mo364a(int i) {
        return this.f6749a[this.f6750b[i]].mo413a(this.f6751c[i]);
    }

    protected void mo365a(int i, long j, boolean z) {
        long j2 = j;
        this.f6752d = this.f6749a[this.f6750b[i]];
        this.f6753e = this.f6751c[i];
        this.f6752d.mo415a(this.f6753e, j2);
        mo375a(j2);
    }

    protected final void mo366a(long j, long j2) {
        long j3 = j;
        mo376a(m8624f(j3), j2, this.f6752d.mo419b(this.f6753e, j3));
    }

    protected final void mo368c(long j) {
        long j2 = j;
        this.f6752d.mo416a(j2);
        m8624f(j2);
    }

    public final int m8625a(long j, MediaFormatHolder mediaFormatHolder, SampleHolder sampleHolder) {
        return this.f6752d.mo412a(this.f6753e, j, mediaFormatHolder, sampleHolder);
    }

    private long m8624f(long j) {
        long b = this.f6752d.mo417b(this.f6753e);
        if (b == Long.MIN_VALUE) {
            return j;
        }
        mo375a(b);
        return b;
    }

    private static void m8623a(SampleSourceReader sampleSourceReader) {
        try {
            sampleSourceReader.mo418b();
        } catch (Throwable e) {
            throw new ExoPlaybackException(e);
        }
    }
}
