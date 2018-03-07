package com.facebook.livephotos.exoplayer.extractor.ogg;

import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.ogg.OggUtil.PageHeader;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_info_message */
final class OggSeeker {
    private final PageHeader f7263a = new PageHeader();
    private final ParsableByteArray f7264b = new ParsableByteArray(282);
    private long f7265c = -1;
    private long f7266d;

    OggSeeker() {
    }

    public final void m9058a(long j, long j2) {
        boolean z = j > 0 && j2 > 0;
        Assertions.m9295a(z);
        this.f7265c = j;
        this.f7266d = j2;
    }

    public final void m9057a() {
        this.f7263a.m9059a();
        this.f7264b.m9331a();
    }

    public final long m9056a(long j, DefaultExtractorInput defaultExtractorInput) {
        int i = 1;
        boolean z = (this.f7265c == -1 || this.f7266d == 0) ? false : true;
        Assertions.m9297b(z);
        OggUtil.m9062a(defaultExtractorInput, this.f7263a, this.f7264b, false);
        long j2 = j - this.f7263a.f7271c;
        if (j2 <= 0 || j2 > 72000) {
            int i2 = this.f7263a.f7277i + this.f7263a.f7276h;
            if (j2 <= 0) {
                i = 2;
            }
            return (defaultExtractorInput.m8844c() - ((long) (i2 * i))) + ((j2 * this.f7265c) / this.f7266d);
        }
        defaultExtractorInput.m8838a();
        return -1;
    }
}
