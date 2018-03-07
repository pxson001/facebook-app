package com.facebook.livephotos.exoplayer.extractor.ogg;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.extractor.ogg.VorbisUtil.CommentHeader;
import com.facebook.livephotos.exoplayer.extractor.ogg.VorbisUtil.Mode;
import com.facebook.livephotos.exoplayer.extractor.ogg.VorbisUtil.VorbisIdHeader;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: page_get_notification_error */
public final class OggVorbisExtractor implements Extractor, SeekMap {
    private final ParsableByteArray f7285a = new ParsableByteArray(new byte[65025], 0);
    private final OggReader f7286b = new OggReader();
    private TrackOutput f7287c;
    private VorbisSetup f7288d;
    private int f7289e;
    private long f7290g;
    private boolean f7291h;
    private final OggSeeker f7292i = new OggSeeker();
    private long f7293j = -1;
    private ExtractorSampleSource f7294k;
    private VorbisIdHeader f7295l;
    private CommentHeader f7296m;
    private long f7297n;
    private long f7298o;
    private long f7299p;
    private long f7300q;

    /* compiled from: page_get_notification_error */
    final class VorbisSetup {
        public final VorbisIdHeader f7280a;
        public final CommentHeader f7281b;
        public final byte[] f7282c;
        public final Mode[] f7283d;
        public final int f7284e;

        public VorbisSetup(VorbisIdHeader vorbisIdHeader, CommentHeader commentHeader, byte[] bArr, Mode[] modeArr, int i) {
            this.f7280a = vorbisIdHeader;
            this.f7281b = commentHeader;
            this.f7282c = bArr;
            this.f7283d = modeArr;
            this.f7284e = i;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo429a(com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput r6) {
        /*
        r5 = this;
        r4 = 7;
        r0 = 0;
        r1 = new com.facebook.livephotos.exoplayer.extractor.ogg.OggUtil$PageHeader;	 Catch:{ ParserException -> 0x003d, all -> 0x0044 }
        r1.<init>();	 Catch:{ ParserException -> 0x003d, all -> 0x0044 }
        r2 = r5.f7285a;	 Catch:{ ParserException -> 0x003d, all -> 0x0044 }
        r3 = 1;
        r2 = com.facebook.livephotos.exoplayer.extractor.ogg.OggUtil.m9062a(r6, r1, r2, r3);	 Catch:{ ParserException -> 0x003d, all -> 0x0044 }
        if (r2 == 0) goto L_0x001b;
    L_0x0010:
        r2 = r1.f7270b;	 Catch:{ ParserException -> 0x003d, all -> 0x0044 }
        r2 = r2 & 2;
        r3 = 2;
        if (r2 != r3) goto L_0x001b;
    L_0x0017:
        r1 = r1.f7277i;	 Catch:{ ParserException -> 0x003d, all -> 0x0044 }
        if (r1 >= r4) goto L_0x0021;
    L_0x001b:
        r1 = r5.f7285a;
        r1.m9331a();
    L_0x0020:
        return r0;
    L_0x0021:
        r1 = r5.f7285a;	 Catch:{  }
        r1.m9331a();	 Catch:{  }
        r1 = r5.f7285a;	 Catch:{  }
        r1 = r1.f7731a;	 Catch:{  }
        r2 = 0;
        r3 = 7;
        r6.m8846c(r1, r2, r3);	 Catch:{  }
        r1 = 1;
        r2 = r5.f7285a;	 Catch:{  }
        r3 = 1;
        r0 = com.facebook.livephotos.exoplayer.extractor.ogg.VorbisUtil.m9080a(r1, r2, r3);	 Catch:{  }
        r1 = r5.f7285a;
        r1.m9331a();
        goto L_0x0020;
    L_0x003d:
        r1 = move-exception;
        r1 = r5.f7285a;
        r1.m9331a();
        goto L_0x0020;
    L_0x0044:
        r0 = move-exception;
        r1 = r5.f7285a;
        r1.m9331a();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.exoplayer.extractor.ogg.OggVorbisExtractor.a(com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput):boolean");
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7287c = extractorSampleSource.m8892d(0);
        extractorSampleSource.m8895g();
        this.f7294k = extractorSampleSource;
    }

    public final void mo430b() {
        OggReader oggReader = this.f7286b;
        oggReader.f7258a.m9059a();
        oggReader.f7259b.m9331a();
        oggReader.f7261d = -1;
        this.f7289e = 0;
        this.f7290g = 0;
        this.f7291h = false;
        this.f7285a.m9331a();
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        long j;
        if (this.f7299p == 0) {
            if (this.f7288d == null) {
                this.f7297n = defaultExtractorInput.m8847d();
                this.f7288d = m9064a(defaultExtractorInput, this.f7285a);
                this.f7298o = defaultExtractorInput.m8844c();
                this.f7294k.m8884a((SeekMap) this);
                if (this.f7297n != -1) {
                    positionHolder.f7028a = defaultExtractorInput.m8847d() - 8000;
                    return 1;
                }
            }
            if (this.f7297n == -1) {
                j = -1;
            } else {
                j = this.f7286b.m9053a(defaultExtractorInput);
            }
            this.f7299p = j;
            List arrayList = new ArrayList();
            arrayList.add(this.f7288d.f7280a.f7326j);
            arrayList.add(this.f7288d.f7282c);
            if (this.f7297n == -1) {
                j = -1;
            } else {
                j = (this.f7299p * 1000000) / this.f7288d.f7280a.f7319c;
            }
            this.f7300q = j;
            this.f7287c.mo410a(MediaFormat.m8740a(null, "audio/vorbis", this.f7288d.f7280a.f7321e, 65025, this.f7300q, this.f7288d.f7280a.f7318b, (int) this.f7288d.f7280a.f7319c, arrayList, null));
            if (this.f7297n != -1) {
                this.f7292i.m9058a(this.f7297n - this.f7298o, this.f7299p);
                positionHolder.f7028a = this.f7298o;
                return 1;
            }
        }
        if (!this.f7291h && this.f7293j > -1) {
            OggUtil.m9060a(defaultExtractorInput);
            j = this.f7292i.m9056a(this.f7293j, defaultExtractorInput);
            if (j != -1) {
                positionHolder.f7028a = j;
                return 1;
            }
            this.f7290g = this.f7286b.m9054a(defaultExtractorInput, this.f7293j);
            this.f7289e = this.f7295l.f7323g;
            this.f7291h = true;
            this.f7292i.m9057a();
        }
        if (!this.f7286b.m9055a(defaultExtractorInput, this.f7285a)) {
            return -1;
        }
        if ((this.f7285a.f7731a[0] & 1) != 1) {
            int a = m9063a(this.f7285a.f7731a[0], this.f7288d);
            int i = this.f7291h ? (this.f7289e + a) / 4 : 0;
            if (this.f7290g + ((long) i) >= this.f7293j) {
                m9065a(this.f7285a, (long) i);
                long j2 = (this.f7290g * 1000000) / this.f7288d.f7280a.f7319c;
                this.f7287c.mo411a(this.f7285a, this.f7285a.m9338c());
                this.f7287c.mo409a(j2, 1, this.f7285a.m9338c(), 0, null);
                this.f7293j = -1;
            }
            this.f7291h = true;
            this.f7290g = ((long) i) + this.f7290g;
            this.f7289e = a;
        }
        this.f7285a.m9331a();
        return 0;
    }

    private VorbisSetup m9064a(DefaultExtractorInput defaultExtractorInput, ParsableByteArray parsableByteArray) {
        if (this.f7295l == null) {
            this.f7286b.m9055a(defaultExtractorInput, parsableByteArray);
            this.f7295l = VorbisUtil.m9078a(parsableByteArray);
            parsableByteArray.m9331a();
        }
        if (this.f7296m == null) {
            this.f7286b.m9055a(defaultExtractorInput, parsableByteArray);
            this.f7296m = VorbisUtil.m9082b(parsableByteArray);
            parsableByteArray.m9331a();
        }
        this.f7286b.m9055a(defaultExtractorInput, parsableByteArray);
        Object obj = new byte[parsableByteArray.f7733c];
        System.arraycopy(parsableByteArray.f7731a, 0, obj, 0, parsableByteArray.f7733c);
        Mode[] a = VorbisUtil.m9081a(parsableByteArray, this.f7295l.f7318b);
        int a2 = VorbisUtil.m9076a(a.length - 1);
        parsableByteArray.m9331a();
        return new VorbisSetup(this.f7295l, this.f7296m, obj, a, a2);
    }

    private static void m9065a(ParsableByteArray parsableByteArray, long j) {
        parsableByteArray.m9332a(parsableByteArray.f7733c + 4);
        parsableByteArray.f7731a[parsableByteArray.f7733c - 4] = (byte) ((int) (j & 255));
        parsableByteArray.f7731a[parsableByteArray.f7733c - 3] = (byte) ((int) ((j >>> 8) & 255));
        parsableByteArray.f7731a[parsableByteArray.f7733c - 2] = (byte) ((int) ((j >>> 16) & 255));
        parsableByteArray.f7731a[parsableByteArray.f7733c - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    private static int m9063a(byte b, VorbisSetup vorbisSetup) {
        if (vorbisSetup.f7283d[(b >> 1) & (255 >>> (8 - vorbisSetup.f7284e))].f7313a) {
            return vorbisSetup.f7280a.f7324h;
        }
        return vorbisSetup.f7280a.f7323g;
    }

    public final boolean mo407a() {
        return (this.f7288d == null || this.f7297n == -1) ? false : true;
    }

    public final long mo406a(long j) {
        if (j == 0) {
            this.f7293j = -1;
            return this.f7298o;
        }
        this.f7293j = (this.f7288d.f7280a.f7319c * j) / 1000000;
        return Math.max(this.f7298o, (((this.f7297n - this.f7298o) * j) / this.f7300q) - 4000);
    }
}
