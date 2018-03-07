package com.facebook.livephotos.exoplayer.extractor.ts;

import android.util.SparseArray;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_checkin_successful */
public final class PsExtractor implements Extractor {
    private final PtsTimestampAdjuster f7475a;
    private final SparseArray<PesReader> f7476b;
    private final ParsableByteArray f7477c;
    private boolean f7478d;
    private boolean f7479e;
    private boolean f7480f;
    private ExtractorSampleSource f7481g;

    /* compiled from: page_checkin_successful */
    public final class PesReader {
        public final ElementaryStreamReader f7467a;
        private final PtsTimestampAdjuster f7468b;
        public final ParsableBitArray f7469c = new ParsableBitArray(new byte[64]);
        public boolean f7470d;
        public boolean f7471e;
        public boolean f7472f;
        public int f7473g;
        private long f7474h;

        public PesReader(ElementaryStreamReader elementaryStreamReader, PtsTimestampAdjuster ptsTimestampAdjuster) {
            this.f7467a = elementaryStreamReader;
            this.f7468b = ptsTimestampAdjuster;
        }

        public final void m9170a(ParsableByteArray parsableByteArray) {
            parsableByteArray.m9335a(this.f7469c.f7727a, 0, 3);
            this.f7469c.m9322a(0);
            this.f7469c.m9324b(8);
            this.f7470d = this.f7469c.m9325b();
            this.f7471e = this.f7469c.m9325b();
            this.f7469c.m9324b(6);
            this.f7473g = this.f7469c.m9326c(8);
            parsableByteArray.m9335a(this.f7469c.f7727a, 0, this.f7473g);
            this.f7469c.m9322a(0);
            m9169c();
            this.f7467a.mo435a(this.f7474h, true);
            this.f7467a.mo436a(parsableByteArray);
            this.f7467a.mo437b();
        }

        private void m9169c() {
            this.f7474h = 0;
            if (this.f7470d) {
                this.f7469c.m9324b(4);
                long c = ((long) this.f7469c.m9326c(3)) << 30;
                this.f7469c.m9324b(1);
                c |= (long) (this.f7469c.m9326c(15) << 15);
                this.f7469c.m9324b(1);
                c |= (long) this.f7469c.m9326c(15);
                this.f7469c.m9324b(1);
                if (!this.f7472f && this.f7471e) {
                    this.f7469c.m9324b(4);
                    long c2 = ((long) this.f7469c.m9326c(3)) << 30;
                    this.f7469c.m9324b(1);
                    c2 |= (long) (this.f7469c.m9326c(15) << 15);
                    this.f7469c.m9324b(1);
                    c2 |= (long) this.f7469c.m9326c(15);
                    this.f7469c.m9324b(1);
                    this.f7468b.m9176a(c2);
                    this.f7472f = true;
                }
                this.f7474h = this.f7468b.m9176a(c);
            }
        }
    }

    public PsExtractor() {
        this(new PtsTimestampAdjuster(0));
    }

    private PsExtractor(PtsTimestampAdjuster ptsTimestampAdjuster) {
        this.f7475a = ptsTimestampAdjuster;
        this.f7477c = new ParsableByteArray(4096);
        this.f7476b = new SparseArray();
    }

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        byte[] bArr = new byte[14];
        defaultExtractorInput.m8846c(bArr, 0, 14);
        if (442 != (((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        defaultExtractorInput.m8845c(bArr[13] & 7);
        defaultExtractorInput.m8846c(bArr, 0, 3);
        if (1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)))) {
            return true;
        }
        return false;
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7481g = extractorSampleSource;
        extractorSampleSource.f7011m = SeekMap.f6955f;
    }

    public final void mo430b() {
        this.f7475a.m9177a();
        for (int i = 0; i < this.f7476b.size(); i++) {
            PesReader pesReader = (PesReader) this.f7476b.valueAt(i);
            pesReader.f7472f = false;
            pesReader.f7467a.mo434a();
        }
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        if (!defaultExtractorInput.m8843b(this.f7477c.f7731a, 0, 4, true)) {
            return -1;
        }
        this.f7477c.m9337b(0);
        int m = this.f7477c.m9349m();
        if (m == 441) {
            return -1;
        }
        if (m == 442) {
            defaultExtractorInput.m8846c(this.f7477c.f7731a, 0, 10);
            this.f7477c.m9337b(0);
            this.f7477c.m9339c(9);
            defaultExtractorInput.m8841b((this.f7477c.m9343f() & 7) + 14);
            return 0;
        } else if (m == 443) {
            defaultExtractorInput.m8846c(this.f7477c.f7731a, 0, 2);
            this.f7477c.m9337b(0);
            defaultExtractorInput.m8841b(this.f7477c.m9344g() + 6);
            return 0;
        } else if (((m & -256) >> 8) != 1) {
            defaultExtractorInput.m8841b(1);
            return 0;
        } else {
            int i = m & 255;
            PesReader pesReader = (PesReader) this.f7476b.get(i);
            if (!this.f7478d) {
                if (pesReader == null) {
                    ElementaryStreamReader elementaryStreamReader = null;
                    if (!this.f7479e && i == 189) {
                        elementaryStreamReader = new Ac3Reader(this.f7481g.m8892d(i), false);
                        this.f7479e = true;
                    } else if (!this.f7479e && (i & 224) == 192) {
                        elementaryStreamReader = new MpegAudioReader(this.f7481g.m8892d(i));
                        this.f7479e = true;
                    } else if (!this.f7480f && (i & 240) == 224) {
                        elementaryStreamReader = new H262Reader(this.f7481g.m8892d(i));
                        this.f7480f = true;
                    }
                    if (elementaryStreamReader != null) {
                        pesReader = new PesReader(elementaryStreamReader, this.f7475a);
                        this.f7476b.put(i, pesReader);
                    }
                }
                if ((this.f7479e && this.f7480f) || defaultExtractorInput.f6964d > 1048576) {
                    this.f7478d = true;
                    this.f7481g.m8895g();
                }
            }
            defaultExtractorInput.m8846c(this.f7477c.f7731a, 0, 2);
            this.f7477c.m9337b(0);
            m = this.f7477c.m9344g() + 6;
            if (pesReader == null) {
                defaultExtractorInput.m8841b(m);
            } else {
                if (this.f7477c.m9342e() < m) {
                    this.f7477c.m9334a(new byte[m], m);
                }
                defaultExtractorInput.m8842b(this.f7477c.f7731a, 0, m);
                this.f7477c.m9337b(6);
                this.f7477c.m9332a(m);
                pesReader.m9170a(this.f7477c);
                this.f7477c.m9332a(this.f7477c.m9342e());
            }
            return 0;
        }
    }
}
