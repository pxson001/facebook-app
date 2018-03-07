package com.facebook.livephotos.exoplayer.extractor.flv;

import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: page_save_success */
public final class FlvExtractor implements Extractor, SeekMap {
    private static final int f7056d = Util.m9368c("FLV");
    public int f7057a;
    public int f7058b;
    public long f7059c;
    private final ParsableByteArray f7060e = new ParsableByteArray(4);
    public final ParsableByteArray f7061g = new ParsableByteArray(9);
    private final ParsableByteArray f7062h = new ParsableByteArray(11);
    private final ParsableByteArray f7063i = new ParsableByteArray();
    public ExtractorSampleSource f7064j;
    public int f7065k = 1;
    public int f7066l;
    public AudioTagPayloadReader f7067m;
    public VideoTagPayloadReader f7068n;
    public ScriptTagPayloadReader f7069o;

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        defaultExtractorInput.m8846c(this.f7060e.f7731a, 0, 3);
        this.f7060e.m9337b(0);
        if (this.f7060e.m9346j() != f7056d) {
            return false;
        }
        defaultExtractorInput.m8846c(this.f7060e.f7731a, 0, 2);
        this.f7060e.m9337b(0);
        if ((this.f7060e.m9344g() & 250) != 0) {
            return false;
        }
        defaultExtractorInput.m8846c(this.f7060e.f7731a, 0, 4);
        this.f7060e.m9337b(0);
        int m = this.f7060e.m9349m();
        defaultExtractorInput.m8838a();
        defaultExtractorInput.m8845c(m);
        defaultExtractorInput.m8846c(this.f7060e.f7731a, 0, 4);
        this.f7060e.m9337b(0);
        if (this.f7060e.m9349m() == 0) {
            return true;
        }
        return false;
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7064j = extractorSampleSource;
    }

    public final void mo430b() {
        this.f7065k = 1;
        this.f7066l = 0;
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        while (true) {
            switch (this.f7065k) {
                case 1:
                    int i = 0;
                    if (defaultExtractorInput.m8839a(this.f7061g.f7731a, 0, 9, true)) {
                        this.f7061g.m9337b(0);
                        this.f7061g.m9339c(4);
                        int f = this.f7061g.m9343f();
                        boolean z = (f & 4) != 0;
                        if ((f & 1) != 0) {
                            i = 1;
                        }
                        if (z && this.f7067m == null) {
                            this.f7067m = new AudioTagPayloadReader(this.f7064j.m8892d(8));
                        }
                        if (i != 0 && this.f7068n == null) {
                            this.f7068n = new VideoTagPayloadReader(this.f7064j.m8892d(9));
                        }
                        if (this.f7069o == null) {
                            this.f7069o = new ScriptTagPayloadReader(null);
                        }
                        this.f7064j.m8895g();
                        this.f7064j.f7011m = this;
                        this.f7066l = (this.f7061g.m9349m() - 9) + 4;
                        this.f7065k = 2;
                        i = 1;
                    }
                    if (i != 0) {
                        break;
                    }
                    return -1;
                case 2:
                    defaultExtractorInput.m8841b(this.f7066l);
                    this.f7066l = 0;
                    this.f7065k = 3;
                    break;
                case 3:
                    if (m8925d(defaultExtractorInput)) {
                        break;
                    }
                    return -1;
                case 4:
                    if (!m8926e(defaultExtractorInput)) {
                        break;
                    }
                    return 0;
                default:
                    break;
            }
        }
    }

    private boolean m8925d(DefaultExtractorInput defaultExtractorInput) {
        if (!defaultExtractorInput.m8839a(this.f7062h.f7731a, 0, 11, true)) {
            return false;
        }
        this.f7062h.m9337b(0);
        this.f7057a = this.f7062h.m9343f();
        this.f7058b = this.f7062h.m9346j();
        this.f7059c = (long) this.f7062h.m9346j();
        this.f7059c = (((long) (this.f7062h.m9343f() << 24)) | this.f7059c) * 1000;
        this.f7062h.m9339c(3);
        this.f7065k = 4;
        return true;
    }

    private boolean m8926e(DefaultExtractorInput defaultExtractorInput) {
        boolean z = true;
        if (this.f7057a == 8 && this.f7067m != null) {
            this.f7067m.m8922b(m8927f(defaultExtractorInput), this.f7059c);
        } else if (this.f7057a == 9 && this.f7068n != null) {
            this.f7068n.m8922b(m8927f(defaultExtractorInput), this.f7059c);
        } else if (this.f7057a != 18 || this.f7069o == null) {
            defaultExtractorInput.m8841b(this.f7058b);
            z = false;
        } else {
            this.f7069o.m8922b(m8927f(defaultExtractorInput), this.f7059c);
            if (this.f7069o.f7052b != -1) {
                if (this.f7067m != null) {
                    this.f7067m.f7052b = this.f7069o.f7052b;
                }
                if (this.f7068n != null) {
                    this.f7068n.f7052b = this.f7069o.f7052b;
                }
            }
        }
        this.f7066l = 4;
        this.f7065k = 2;
        return z;
    }

    private ParsableByteArray m8927f(DefaultExtractorInput defaultExtractorInput) {
        if (this.f7058b > this.f7063i.m9342e()) {
            this.f7063i.m9334a(new byte[Math.max(this.f7063i.m9342e() * 2, this.f7058b)], 0);
        } else {
            this.f7063i.m9337b(0);
        }
        this.f7063i.m9332a(this.f7058b);
        defaultExtractorInput.m8842b(this.f7063i.f7731a, 0, this.f7058b);
        return this.f7063i;
    }

    public final boolean mo407a() {
        return false;
    }

    public final long mo406a(long j) {
        return 0;
    }
}
