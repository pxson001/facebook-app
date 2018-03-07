package com.facebook.livephotos.exoplayer.extractor.mp3;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.GaplessInfo;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.MpegAudioHeader;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;
import java.io.EOFException;

/* compiled from: page_remove_from_favorites_error */
public final class Mp3Extractor implements Extractor {
    private static final int f7085a = Util.m9368c("Xing");
    private static final int f7086b = Util.m9368c("Info");
    private static final int f7087c = Util.m9368c("VBRI");
    private final long f7088d;
    private final ParsableByteArray f7089e;
    private final MpegAudioHeader f7090f;
    private ExtractorSampleSource f7091g;
    private TrackOutput f7092h;
    private int f7093i;
    private GaplessInfo f7094j;
    private Seeker f7095k;
    private long f7096l;
    private int f7097m;
    private int f7098n;

    /* compiled from: page_remove_from_favorites_error */
    interface Seeker extends SeekMap {
        long mo431b();

        long mo432b(long j);
    }

    public Mp3Extractor() {
        this(-1);
    }

    private Mp3Extractor(long j) {
        this.f7088d = j;
        this.f7089e = new ParsableByteArray(4);
        this.f7090f = new MpegAudioHeader();
        this.f7096l = -1;
    }

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        return m8956a(defaultExtractorInput, true);
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7091g = extractorSampleSource;
        this.f7092h = extractorSampleSource.m8892d(0);
        extractorSampleSource.m8895g();
    }

    public final void mo430b() {
        this.f7093i = 0;
        this.f7097m = 0;
        this.f7096l = -1;
        this.f7098n = 0;
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        if (this.f7093i == 0 && !m8959d(defaultExtractorInput)) {
            return -1;
        }
        if (this.f7095k == null) {
            m8960e(defaultExtractorInput);
            this.f7091g.f7011m = this.f7095k;
            MediaFormat a = MediaFormat.m8740a(null, this.f7090f.f7704b, -1, 4096, this.f7095k.mo431b(), this.f7090f.f7707e, this.f7090f.f7706d, null, null);
            if (this.f7094j != null) {
                a = a.m8747a(this.f7094j.f7026a, this.f7094j.f7027b);
            }
            this.f7092h.mo410a(a);
        }
        return m8957b(defaultExtractorInput);
    }

    private int m8957b(DefaultExtractorInput defaultExtractorInput) {
        if (this.f7098n == 0) {
            if (!m8958c(defaultExtractorInput)) {
                return -1;
            }
            if (this.f7096l == -1) {
                this.f7096l = this.f7095k.mo432b(defaultExtractorInput.f6964d);
                if (this.f7088d != -1) {
                    long b = this.f7095k.mo432b(0);
                    this.f7096l = (this.f7088d - b) + this.f7096l;
                }
            }
            this.f7098n = this.f7090f.f7705c;
        }
        int a = this.f7092h.mo408a(defaultExtractorInput, this.f7098n, true);
        if (a == -1) {
            return -1;
        }
        this.f7098n -= a;
        if (this.f7098n > 0) {
            return 0;
        }
        this.f7092h.mo409a(((((long) this.f7097m) * 1000000) / ((long) this.f7090f.f7706d)) + this.f7096l, 1, this.f7090f.f7705c, 0, null);
        this.f7097m += this.f7090f.f7709g;
        this.f7098n = 0;
        return 0;
    }

    private boolean m8958c(DefaultExtractorInput defaultExtractorInput) {
        defaultExtractorInput.m8838a();
        if (!defaultExtractorInput.m8843b(this.f7089e.f7731a, 0, 4, true)) {
            return false;
        }
        this.f7089e.m9337b(0);
        int m = this.f7089e.m9349m();
        if ((m & -128000) != (this.f7093i & -128000) || MpegAudioHeader.m9307a(m) == -1) {
            this.f7093i = 0;
            defaultExtractorInput.m8841b(1);
            return m8959d(defaultExtractorInput);
        }
        MpegAudioHeader.m9309a(m, this.f7090f);
        return true;
    }

    private boolean m8959d(DefaultExtractorInput defaultExtractorInput) {
        boolean z = false;
        try {
            z = m8956a(defaultExtractorInput, false);
        } catch (EOFException e) {
        }
        return z;
    }

    private boolean m8956a(DefaultExtractorInput defaultExtractorInput, boolean z) {
        int b;
        int i;
        int i2;
        int i3;
        int i4;
        defaultExtractorInput.m8838a();
        if (defaultExtractorInput.f6964d == 0) {
            this.f7094j = Id3Util.m8951a(defaultExtractorInput);
            b = (int) defaultExtractorInput.m8840b();
            if (!z) {
                defaultExtractorInput.m8841b(b);
            }
            i = b;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        while (true) {
            if (z && i4 == 4096) {
                return false;
            }
            if (!z && i4 == 131072) {
                throw new ParserException("Searched too many bytes.");
            } else if (!defaultExtractorInput.m8843b(this.f7089e.f7731a, 0, 4, true)) {
                return false;
            } else {
                this.f7089e.m9337b(0);
                b = this.f7089e.m9349m();
                if (i2 == 0 || (b & -128000) == (i2 & -128000)) {
                    int a = MpegAudioHeader.m9307a(b);
                    if (a != -1) {
                        i3++;
                        if (i3 != 1) {
                            if (i3 == 4) {
                                break;
                            }
                            b = i2;
                        } else {
                            MpegAudioHeader.m9309a(b, this.f7090f);
                        }
                        defaultExtractorInput.m8845c(a - 4);
                        i2 = b;
                    }
                }
                b = i4 + 1;
                if (z) {
                    defaultExtractorInput.m8838a();
                    defaultExtractorInput.m8845c(i + b);
                    i2 = 0;
                    i3 = 0;
                    i4 = b;
                } else {
                    defaultExtractorInput.m8841b(1);
                    i2 = 0;
                    i3 = 0;
                    i4 = b;
                }
            }
        }
        if (z) {
            defaultExtractorInput.m8841b(i + i4);
        } else {
            defaultExtractorInput.m8838a();
        }
        this.f7093i = i2;
        return true;
    }

    private void m8960e(DefaultExtractorInput defaultExtractorInput) {
        int i = 21;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f7090f.f7705c);
        defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, this.f7090f.f7705c);
        long j = defaultExtractorInput.f6964d;
        long j2 = defaultExtractorInput.f6963c;
        if ((this.f7090f.f7703a & 1) != 0) {
            if (this.f7090f.f7707e != 1) {
                i = 36;
            }
        } else if (this.f7090f.f7707e == 1) {
            i = 13;
        }
        parsableByteArray.m9337b(i);
        int m = parsableByteArray.m9349m();
        if (m == f7085a || m == f7086b) {
            this.f7095k = XingSeeker.m8971a(this.f7090f, parsableByteArray, j, j2);
            if (this.f7095k != null && this.f7094j == null) {
                defaultExtractorInput.m8838a();
                defaultExtractorInput.m8845c(i + 141);
                defaultExtractorInput.m8846c(this.f7089e.f7731a, 0, 3);
                this.f7089e.m9337b(0);
                this.f7094j = GaplessInfo.m8897a(this.f7089e.m9346j());
            }
            defaultExtractorInput.m8841b(this.f7090f.f7705c);
        } else {
            parsableByteArray.m9337b(36);
            if (parsableByteArray.m9349m() == f7087c) {
                this.f7095k = VbriSeeker.m8965a(this.f7090f, parsableByteArray, j, j2);
                defaultExtractorInput.m8841b(this.f7090f.f7705c);
            }
        }
        if (this.f7095k == null) {
            defaultExtractorInput.m8838a();
            defaultExtractorInput.m8846c(this.f7089e.f7731a, 0, 4);
            this.f7089e.m9337b(0);
            MpegAudioHeader.m9309a(this.f7089e.m9349m(), this.f7090f);
            this.f7095k = new ConstantBitrateSeeker(defaultExtractorInput.f6964d, this.f7090f.f7708f, j2);
        }
    }
}
