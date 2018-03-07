package com.facebook.livephotos.exoplayer.extractor.ogg;

import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.ogg.OggUtil.PacketInfoHolder;
import com.facebook.livephotos.exoplayer.extractor.ogg.OggUtil.PageHeader;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_internal */
public final class OggReader {
    public final PageHeader f7258a = new PageHeader();
    public final ParsableByteArray f7259b = new ParsableByteArray(282);
    private final PacketInfoHolder f7260c = new PacketInfoHolder();
    public int f7261d = -1;
    private long f7262e;

    OggReader() {
    }

    public final boolean m9055a(DefaultExtractorInput defaultExtractorInput, ParsableByteArray parsableByteArray) {
        boolean z = (defaultExtractorInput == null || parsableByteArray == null) ? false : true;
        Assertions.m9297b(z);
        for (boolean z2 = false; !z2; z2 = z) {
            int i;
            if (this.f7261d < 0) {
                if (!OggUtil.m9062a(defaultExtractorInput, this.f7258a, this.f7259b, true)) {
                    return false;
                }
                int i2 = this.f7258a.f7276h;
                if ((this.f7258a.f7270b & 1) == 1 && parsableByteArray.f7733c == 0) {
                    OggUtil.m9061a(this.f7258a, 0, this.f7260c);
                    i = this.f7260c.f7268b + 0;
                    i2 += this.f7260c.f7267a;
                } else {
                    i = 0;
                }
                defaultExtractorInput.m8841b(i2);
                this.f7261d = i;
            }
            OggUtil.m9061a(this.f7258a, this.f7261d, this.f7260c);
            i = this.f7260c.f7268b + this.f7261d;
            if (this.f7260c.f7267a > 0) {
                defaultExtractorInput.m8842b(parsableByteArray.f7731a, parsableByteArray.f7733c, this.f7260c.f7267a);
                parsableByteArray.m9332a(parsableByteArray.f7733c + this.f7260c.f7267a);
                z = this.f7258a.f7278j[i + -1] != 255;
            } else {
                z = z2;
            }
            if (i == this.f7258a.f7275g) {
                i = -1;
            }
            this.f7261d = i;
        }
        return true;
    }

    public final long m9053a(DefaultExtractorInput defaultExtractorInput) {
        boolean z;
        if (defaultExtractorInput.f6963c != -1) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m9295a(z);
        OggUtil.m9060a(defaultExtractorInput);
        this.f7258a.m9059a();
        while ((this.f7258a.f7270b & 4) != 4) {
            if (this.f7258a.f7277i > 0) {
                defaultExtractorInput.m8841b(this.f7258a.f7277i);
            }
            OggUtil.m9062a(defaultExtractorInput, this.f7258a, this.f7259b, false);
            defaultExtractorInput.m8841b(this.f7258a.f7276h);
        }
        return this.f7258a.f7271c;
    }

    public final long m9054a(DefaultExtractorInput defaultExtractorInput, long j) {
        OggUtil.m9060a(defaultExtractorInput);
        OggUtil.m9062a(defaultExtractorInput, this.f7258a, this.f7259b, false);
        while (this.f7258a.f7271c < j) {
            defaultExtractorInput.m8841b(this.f7258a.f7276h + this.f7258a.f7277i);
            this.f7262e = this.f7258a.f7271c;
            OggUtil.m9062a(defaultExtractorInput, this.f7258a, this.f7259b, false);
        }
        if (this.f7262e == 0) {
            throw new ParserException();
        }
        defaultExtractorInput.m8838a();
        long j2 = this.f7262e;
        this.f7262e = 0;
        this.f7261d = -1;
        return j2;
    }
}
