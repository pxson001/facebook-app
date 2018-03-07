package com.facebook.livephotos.exoplayer.extractor.webm;

import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_network_before_cache */
final class Sniffer {
    private final ParsableByteArray f7539a = new ParsableByteArray(8);
    private int f7540b;

    public final boolean m9217a(DefaultExtractorInput defaultExtractorInput) {
        long d = defaultExtractorInput.m8847d();
        long j = (d == -1 || d > 1024) ? 1024 : d;
        int i = (int) j;
        defaultExtractorInput.m8846c(this.f7539a.f7731a, 0, 4);
        j = this.f7539a.m9347k();
        this.f7540b = 4;
        while (j != 440786851) {
            int i2 = this.f7540b + 1;
            this.f7540b = i2;
            if (i2 == i) {
                return false;
            }
            defaultExtractorInput.m8846c(this.f7539a.f7731a, 0, 1);
            j = ((j << 8) & -256) | ((long) (this.f7539a.f7731a[0] & 255));
        }
        j = m9216b(defaultExtractorInput);
        long j2 = (long) this.f7540b;
        if (j == Long.MIN_VALUE || (d != -1 && j2 + j >= d)) {
            return false;
        }
        while (((long) this.f7540b) < j2 + j) {
            if (m9216b(defaultExtractorInput) == Long.MIN_VALUE) {
                return false;
            }
            d = m9216b(defaultExtractorInput);
            if (d < 0 || d > 2147483647L) {
                return false;
            }
            if (d != 0) {
                defaultExtractorInput.m8845c((int) d);
                this.f7540b = (int) (d + ((long) this.f7540b));
            }
        }
        return ((long) this.f7540b) == j + j2;
    }

    private long m9216b(DefaultExtractorInput defaultExtractorInput) {
        int i = 0;
        defaultExtractorInput.m8846c(this.f7539a.f7731a, 0, 1);
        int i2 = this.f7539a.f7731a[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i4++;
            i3 >>= 1;
        }
        i3 = (i3 ^ -1) & i2;
        defaultExtractorInput.m8846c(this.f7539a.f7731a, 1, i4);
        while (i < i4) {
            i3 = (i3 << 8) + (this.f7539a.f7731a[i + 1] & 255);
            i++;
        }
        this.f7540b += i4 + 1;
        return (long) i3;
    }
}
