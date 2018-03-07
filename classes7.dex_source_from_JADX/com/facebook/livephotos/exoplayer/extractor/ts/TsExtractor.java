package com.facebook.livephotos.exoplayer.extractor.ts;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.DummyTrackOutput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: page_admin_invite_accept */
public final class TsExtractor implements Extractor {
    public static final long f7505d = ((long) Util.m9368c("AC-3"));
    public static final long f7506e = ((long) Util.m9368c("EAC3"));
    public static final long f7507f = ((long) Util.m9368c("HEVC"));
    final SparseArray<TsPayloadReader> f7508a;
    final SparseBooleanArray f7509b;
    Id3Reader f7510c;
    public final PtsTimestampAdjuster f7511g;
    public final int f7512h;
    private final ParsableByteArray f7513i;
    private final ParsableBitArray f7514j;
    private ExtractorSampleSource f7515k;

    /* compiled from: page_admin_invite_accept */
    abstract class TsPayloadReader {
        public abstract void mo438a();

        public abstract void mo439a(ParsableByteArray parsableByteArray, boolean z, ExtractorSampleSource extractorSampleSource);
    }

    /* compiled from: page_admin_invite_accept */
    class PatReader extends TsPayloadReader {
        final /* synthetic */ TsExtractor f7486a;
        private final ParsableBitArray f7487b = new ParsableBitArray(new byte[4]);

        public PatReader(TsExtractor tsExtractor) {
            this.f7486a = tsExtractor;
        }

        public final void mo438a() {
        }

        public final void mo439a(ParsableByteArray parsableByteArray, boolean z, ExtractorSampleSource extractorSampleSource) {
            if (z) {
                parsableByteArray.m9339c(parsableByteArray.m9343f());
            }
            parsableByteArray.m9333a(this.f7487b, 3);
            this.f7487b.m9324b(12);
            int c = this.f7487b.m9326c(12);
            parsableByteArray.m9339c(5);
            int i = (c - 9) / 4;
            for (c = 0; c < i; c++) {
                parsableByteArray.m9333a(this.f7487b, 4);
                int c2 = this.f7487b.m9326c(16);
                this.f7487b.m9324b(3);
                if (c2 == 0) {
                    this.f7487b.m9324b(13);
                } else {
                    this.f7486a.f7508a.put(this.f7487b.m9326c(13), new PmtReader(this.f7486a));
                }
            }
        }
    }

    /* compiled from: page_admin_invite_accept */
    final class PesReader extends TsPayloadReader {
        private final ElementaryStreamReader f7488a;
        private final PtsTimestampAdjuster f7489b;
        private final ParsableBitArray f7490c = new ParsableBitArray(new byte[10]);
        private int f7491d = 0;
        private int f7492e;
        private boolean f7493f;
        private boolean f7494g;
        private boolean f7495h;
        private int f7496i;
        private int f7497j;
        private boolean f7498k;
        private long f7499l;

        public PesReader(ElementaryStreamReader elementaryStreamReader, PtsTimestampAdjuster ptsTimestampAdjuster) {
            this.f7488a = elementaryStreamReader;
            this.f7489b = ptsTimestampAdjuster;
        }

        public final void mo438a() {
            this.f7491d = 0;
            this.f7492e = 0;
            this.f7495h = false;
            this.f7488a.mo434a();
        }

        public final void mo439a(ParsableByteArray parsableByteArray, boolean z, ExtractorSampleSource extractorSampleSource) {
            if (z) {
                switch (this.f7491d) {
                    case 2:
                        Log.w("TsExtractor", "Unexpected start indicator reading extended header");
                        break;
                    case 3:
                        if (this.f7497j != -1) {
                            Log.w("TsExtractor", "Unexpected start indicator: expected " + this.f7497j + " more bytes");
                        }
                        this.f7488a.mo437b();
                        break;
                }
                m9183a(1);
            }
            while (parsableByteArray.m9336b() > 0) {
                switch (this.f7491d) {
                    case 0:
                        parsableByteArray.m9339c(parsableByteArray.m9336b());
                        break;
                    case 1:
                        if (!m9184a(parsableByteArray, this.f7490c.f7727a, 9)) {
                            break;
                        }
                        m9183a(m9185b() ? 2 : 0);
                        break;
                    case 2:
                        if (m9184a(parsableByteArray, this.f7490c.f7727a, Math.min(10, this.f7496i)) && m9184a(parsableByteArray, null, this.f7496i)) {
                            m9186c();
                            this.f7488a.mo435a(this.f7499l, this.f7498k);
                            m9183a(3);
                            break;
                        }
                    case 3:
                        int i;
                        int b = parsableByteArray.m9336b();
                        if (this.f7497j == -1) {
                            i = 0;
                        } else {
                            i = b - this.f7497j;
                        }
                        if (i > 0) {
                            b -= i;
                            parsableByteArray.m9332a(parsableByteArray.f7732b + b);
                        }
                        this.f7488a.mo436a(parsableByteArray);
                        if (this.f7497j == -1) {
                            break;
                        }
                        this.f7497j -= b;
                        if (this.f7497j != 0) {
                            break;
                        }
                        this.f7488a.mo437b();
                        m9183a(1);
                        break;
                    default:
                        break;
                }
            }
        }

        private void m9183a(int i) {
            this.f7491d = i;
            this.f7492e = 0;
        }

        private boolean m9184a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
            int min = Math.min(parsableByteArray.m9336b(), i - this.f7492e);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                parsableByteArray.m9339c(min);
            } else {
                parsableByteArray.m9335a(bArr, this.f7492e, min);
            }
            this.f7492e = min + this.f7492e;
            if (this.f7492e != i) {
                return false;
            }
            return true;
        }

        private boolean m9185b() {
            this.f7490c.m9322a(0);
            int c = this.f7490c.m9326c(24);
            if (c != 1) {
                Log.w("TsExtractor", "Unexpected start code prefix: " + c);
                this.f7497j = -1;
                return false;
            }
            this.f7490c.m9324b(8);
            int c2 = this.f7490c.m9326c(16);
            this.f7490c.m9324b(5);
            this.f7498k = this.f7490c.m9325b();
            this.f7490c.m9324b(2);
            this.f7493f = this.f7490c.m9325b();
            this.f7494g = this.f7490c.m9325b();
            this.f7490c.m9324b(6);
            this.f7496i = this.f7490c.m9326c(8);
            if (c2 == 0) {
                this.f7497j = -1;
            } else {
                this.f7497j = ((c2 + 6) - 9) - this.f7496i;
            }
            return true;
        }

        private void m9186c() {
            this.f7490c.m9322a(0);
            this.f7499l = -1;
            if (this.f7493f) {
                this.f7490c.m9324b(4);
                long c = ((long) this.f7490c.m9326c(3)) << 30;
                this.f7490c.m9324b(1);
                c |= (long) (this.f7490c.m9326c(15) << 15);
                this.f7490c.m9324b(1);
                c |= (long) this.f7490c.m9326c(15);
                this.f7490c.m9324b(1);
                if (!this.f7495h && this.f7494g) {
                    this.f7490c.m9324b(4);
                    long c2 = ((long) this.f7490c.m9326c(3)) << 30;
                    this.f7490c.m9324b(1);
                    c2 |= (long) (this.f7490c.m9326c(15) << 15);
                    this.f7490c.m9324b(1);
                    c2 |= (long) this.f7490c.m9326c(15);
                    this.f7490c.m9324b(1);
                    this.f7489b.m9176a(c2);
                    this.f7495h = true;
                }
                this.f7499l = this.f7489b.m9176a(c);
            }
        }
    }

    /* compiled from: page_admin_invite_accept */
    class PmtReader extends TsPayloadReader {
        final /* synthetic */ TsExtractor f7500a;
        private final ParsableBitArray f7501b = new ParsableBitArray(new byte[5]);
        private final ParsableByteArray f7502c = new ParsableByteArray();
        private int f7503d;
        private int f7504e;

        public PmtReader(TsExtractor tsExtractor) {
            this.f7500a = tsExtractor;
        }

        public final void mo438a() {
        }

        public final void mo439a(ParsableByteArray parsableByteArray, boolean z, ExtractorSampleSource extractorSampleSource) {
            if (z) {
                parsableByteArray.m9339c(parsableByteArray.m9343f());
                parsableByteArray.m9333a(this.f7501b, 3);
                this.f7501b.m9324b(12);
                this.f7503d = this.f7501b.m9326c(12);
                if (this.f7502c.m9342e() < this.f7503d) {
                    this.f7502c.m9334a(new byte[this.f7503d], this.f7503d);
                } else {
                    this.f7502c.m9331a();
                    this.f7502c.m9332a(this.f7503d);
                }
            }
            int min = Math.min(parsableByteArray.m9336b(), this.f7503d - this.f7504e);
            parsableByteArray.m9335a(this.f7502c.f7731a, this.f7504e, min);
            this.f7504e = min + this.f7504e;
            if (this.f7504e >= this.f7503d) {
                this.f7502c.m9339c(7);
                this.f7502c.m9333a(this.f7501b, 2);
                this.f7501b.m9324b(4);
                min = this.f7501b.m9326c(12);
                this.f7502c.m9339c(min);
                if (this.f7500a.f7510c == null) {
                    this.f7500a.f7510c = new Id3Reader(extractorSampleSource.m8892d(21));
                }
                int i = ((this.f7503d - 9) - min) - 4;
                while (i > 0) {
                    this.f7502c.m9333a(this.f7501b, 5);
                    min = this.f7501b.m9326c(8);
                    this.f7501b.m9324b(3);
                    int c = this.f7501b.m9326c(13);
                    this.f7501b.m9324b(4);
                    int c2 = this.f7501b.m9326c(12);
                    if (min == 6) {
                        min = m9189a(this.f7502c, c2);
                    } else {
                        this.f7502c.m9339c(c2);
                    }
                    int i2 = i - (c2 + 5);
                    if (this.f7500a.f7509b.get(min)) {
                        i = i2;
                    } else {
                        ElementaryStreamReader h262Reader;
                        switch (min) {
                            case 2:
                                h262Reader = new H262Reader(extractorSampleSource.m8892d(2));
                                break;
                            case 3:
                                h262Reader = new MpegAudioReader(extractorSampleSource.m8892d(3));
                                break;
                            case 4:
                                h262Reader = new MpegAudioReader(extractorSampleSource.m8892d(4));
                                break;
                            case 15:
                                if ((this.f7500a.f7512h & 2) == 0) {
                                    h262Reader = new AdtsReader(extractorSampleSource.m8892d(15), new DummyTrackOutput());
                                    break;
                                } else {
                                    h262Reader = null;
                                    break;
                                }
                            case 21:
                                h262Reader = this.f7500a.f7510c;
                                break;
                            case 27:
                                if ((this.f7500a.f7512h & 4) == 0) {
                                    h262Reader = new H264Reader(extractorSampleSource.m8892d(27), new SeiReader(extractorSampleSource.m8892d(256)), (this.f7500a.f7512h & 1) != 0, (this.f7500a.f7512h & 8) != 0);
                                    break;
                                } else {
                                    h262Reader = null;
                                    break;
                                }
                            case 36:
                                h262Reader = new H265Reader(extractorSampleSource.m8892d(36), new SeiReader(extractorSampleSource.m8892d(256)));
                                break;
                            case 129:
                                h262Reader = new Ac3Reader(extractorSampleSource.m8892d(129), false);
                                break;
                            case 130:
                            case 138:
                                h262Reader = new DtsReader(extractorSampleSource.m8892d(138));
                                break;
                            case 135:
                                h262Reader = new Ac3Reader(extractorSampleSource.m8892d(135), true);
                                break;
                            default:
                                h262Reader = null;
                                break;
                        }
                        if (h262Reader != null) {
                            this.f7500a.f7509b.put(min, true);
                            this.f7500a.f7508a.put(c, new PesReader(h262Reader, this.f7500a.f7511g));
                        }
                        i = i2;
                    }
                }
                extractorSampleSource.m8895g();
            }
        }

        private static int m9189a(ParsableByteArray parsableByteArray, int i) {
            int i2 = -1;
            int i3 = parsableByteArray.f7732b + i;
            while (parsableByteArray.f7732b < i3) {
                int f = parsableByteArray.m9343f();
                int f2 = parsableByteArray.m9343f();
                if (f == 5) {
                    long k = parsableByteArray.m9347k();
                    if (k == TsExtractor.f7505d) {
                        i2 = 129;
                    } else if (k == TsExtractor.f7506e) {
                        i2 = 135;
                    } else if (k == TsExtractor.f7507f) {
                        i2 = 36;
                    }
                    parsableByteArray.m9337b(i3);
                    return i2;
                }
                if (f == 106) {
                    i2 = 129;
                } else if (f == 122) {
                    i2 = 135;
                } else if (f == 123) {
                    i2 = 138;
                }
                parsableByteArray.m9339c(f2);
            }
            parsableByteArray.m9337b(i3);
            return i2;
        }
    }

    public TsExtractor() {
        this(new PtsTimestampAdjuster(0));
    }

    private TsExtractor(PtsTimestampAdjuster ptsTimestampAdjuster) {
        this(ptsTimestampAdjuster, 0);
    }

    private TsExtractor(PtsTimestampAdjuster ptsTimestampAdjuster, int i) {
        this.f7511g = ptsTimestampAdjuster;
        this.f7512h = i;
        this.f7513i = new ParsableByteArray(188);
        this.f7514j = new ParsableBitArray(new byte[3]);
        this.f7508a = new SparseArray();
        this.f7508a.put(0, new PatReader(this));
        this.f7509b = new SparseBooleanArray();
    }

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        byte[] bArr = new byte[1];
        for (int i = 0; i < 5; i++) {
            defaultExtractorInput.m8846c(bArr, 0, 1);
            if ((bArr[0] & 255) != 71) {
                return false;
            }
            defaultExtractorInput.m8845c(187);
        }
        return true;
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7515k = extractorSampleSource;
        extractorSampleSource.f7011m = SeekMap.f6955f;
    }

    public final void mo430b() {
        this.f7511g.m9177a();
        for (int i = 0; i < this.f7508a.size(); i++) {
            ((TsPayloadReader) this.f7508a.valueAt(i)).mo438a();
        }
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        if (!defaultExtractorInput.m8839a(this.f7513i.f7731a, 0, 188, true)) {
            return -1;
        }
        this.f7513i.m9337b(0);
        this.f7513i.m9332a(188);
        if (this.f7513i.m9343f() != 71) {
            return 0;
        }
        this.f7513i.m9333a(this.f7514j, 3);
        this.f7514j.m9324b(1);
        boolean b = this.f7514j.m9325b();
        this.f7514j.m9324b(1);
        int c = this.f7514j.m9326c(13);
        this.f7514j.m9324b(2);
        boolean b2 = this.f7514j.m9325b();
        boolean b3 = this.f7514j.m9325b();
        if (b2) {
            this.f7513i.m9339c(this.f7513i.m9343f());
        }
        if (b3) {
            TsPayloadReader tsPayloadReader = (TsPayloadReader) this.f7508a.get(c);
            if (tsPayloadReader != null) {
                tsPayloadReader.mo439a(this.f7513i, b, this.f7515k);
            }
        }
        return 0;
    }
}
