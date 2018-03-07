package com.facebook.livephotos.exoplayer.extractor.ts;

import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: page_follow_regular_error */
public final class AdtsExtractor implements Extractor {
    private static final int f7338a = Util.m9368c("ID3");
    private final long f7339b;
    private final ParsableByteArray f7340c;
    private AdtsReader f7341d;
    private boolean f7342e;

    public AdtsExtractor() {
        this(0);
    }

    private AdtsExtractor(long j) {
        this.f7339b = j;
        this.f7340c = new ParsableByteArray(200);
    }

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        int i;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.f7731a);
        int i2 = 0;
        while (true) {
            defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, 10);
            parsableByteArray.m9337b(0);
            if (parsableByteArray.m9346j() != f7338a) {
                break;
            }
            i = ((((parsableByteArray.f7731a[6] & 127) << 21) | ((parsableByteArray.f7731a[7] & 127) << 14)) | ((parsableByteArray.f7731a[8] & 127) << 7)) | (parsableByteArray.f7731a[9] & 127);
            i2 += i + 10;
            defaultExtractorInput.m8845c(i);
        }
        defaultExtractorInput.m8838a();
        defaultExtractorInput.m8845c(i2);
        i = 0;
        int i3 = 0;
        int i4 = i2;
        while (true) {
            defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, 2);
            parsableByteArray.m9337b(0);
            if ((parsableByteArray.m9344g() & 65526) != 65520) {
                defaultExtractorInput.m8838a();
                i = i4 + 1;
                if (i - i2 >= 8192) {
                    return false;
                }
                defaultExtractorInput.m8845c(i);
                i3 = 0;
                i4 = i;
                i = 0;
            } else {
                i++;
                if (i >= 4 && i3 > 188) {
                    return true;
                }
                defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, 4);
                parsableBitArray.m9322a(14);
                int c = parsableBitArray.m9326c(13);
                defaultExtractorInput.m8845c(c - 6);
                i3 += c;
            }
        }
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7341d = new AdtsReader(extractorSampleSource.m8892d(0), extractorSampleSource.m8892d(1));
        extractorSampleSource.m8895g();
        extractorSampleSource.f7011m = SeekMap.f6955f;
    }

    public final void mo430b() {
        this.f7342e = false;
        this.f7341d.mo434a();
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        int a = defaultExtractorInput.m8837a(this.f7340c.f7731a, 0, 200);
        if (a == -1) {
            return -1;
        }
        this.f7340c.m9337b(0);
        this.f7340c.m9332a(a);
        if (!this.f7342e) {
            this.f7341d.mo435a(this.f7339b, true);
            this.f7342e = true;
        }
        this.f7341d.mo436a(this.f7340c);
        return 0;
    }
}
