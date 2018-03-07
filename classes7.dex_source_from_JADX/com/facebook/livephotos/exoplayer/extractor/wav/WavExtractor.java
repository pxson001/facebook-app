package com.facebook.livephotos.exoplayer.extractor.wav;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;

/* compiled from: page_add_to_favorites_success */
public final class WavExtractor implements Extractor, SeekMap {
    private ExtractorSampleSource f7516a;
    private TrackOutput f7517b;
    private WavHeader f7518c;
    private int f7519d;
    private int f7520e;

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        return WavHeaderReader.m9210a(defaultExtractorInput) != null;
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7516a = extractorSampleSource;
        this.f7517b = extractorSampleSource.m8892d(0);
        this.f7518c = null;
        extractorSampleSource.m8895g();
    }

    public final void mo430b() {
        this.f7520e = 0;
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        if (this.f7518c == null) {
            this.f7518c = WavHeaderReader.m9210a(defaultExtractorInput);
            if (this.f7518c == null) {
                throw new ParserException("Error initializing WavHeader. Did you sniff first?");
            }
            this.f7519d = this.f7518c.m9203b();
        }
        if (!this.f7518c.m9208f()) {
            WavHeaderReader.m9211a(defaultExtractorInput, this.f7518c);
            this.f7517b.mo410a(MediaFormat.m8740a(null, "audio/raw", this.f7518c.m9205c(), 32768, this.f7518c.m9202a(), this.f7518c.m9207e(), this.f7518c.m9206d(), null, null));
            this.f7516a.f7011m = this;
        }
        int a = this.f7517b.mo408a(defaultExtractorInput, 32768 - this.f7520e, true);
        if (a != -1) {
            this.f7520e += a;
        }
        int i = (this.f7520e / this.f7519d) * this.f7519d;
        if (i > 0) {
            long c = defaultExtractorInput.m8844c() - ((long) this.f7520e);
            this.f7520e -= i;
            this.f7517b.mo409a(this.f7518c.m9204b(c), 1, i, this.f7520e, null);
        }
        if (a == -1) {
            return -1;
        }
        return 0;
    }

    public final boolean mo407a() {
        return true;
    }

    public final long mo406a(long j) {
        WavHeader wavHeader = this.f7518c;
        return ((((((long) wavHeader.f7523c) * j) / 1000000) / ((long) wavHeader.f7521a)) * ((long) wavHeader.f7521a)) + wavHeader.f7526f;
    }
}
