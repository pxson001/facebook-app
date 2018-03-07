package com.facebook.livephotos.exoplayer.extractor.mp4;

import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: page_network_before_cache */
public final class Sniffer {
    private static final int[] f7220a = new int[]{Util.m9368c("isom"), Util.m9368c("iso2"), Util.m9368c("avc1"), Util.m9368c("hvc1"), Util.m9368c("hev1"), Util.m9368c("mp41"), Util.m9368c("mp42"), Util.m9368c("3g2a"), Util.m9368c("3g2b"), Util.m9368c("3gr6"), Util.m9368c("3gs6"), Util.m9368c("3ge6"), Util.m9368c("3gg6"), Util.m9368c("M4V "), Util.m9368c("M4A "), Util.m9368c("f4v "), Util.m9368c("kddi"), Util.m9368c("M4VP"), Util.m9368c("qt  "), Util.m9368c("MSNV")};

    public static boolean m9047a(DefaultExtractorInput defaultExtractorInput, int i, boolean z) {
        long d = defaultExtractorInput.m8847d();
        if (d == -1 || d > ((long) i)) {
            d = (long) i;
        }
        int i2 = (int) d;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        Object obj = null;
        boolean z2 = false;
        long o;
        for (int i3 = 0; i3 < i2; i3 = (int) (((long) i3) + o)) {
            int i4;
            defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, 8);
            parsableByteArray.m9337b(0);
            long k = parsableByteArray.m9347k();
            int m = parsableByteArray.m9349m();
            if (k == 1) {
                defaultExtractorInput.m8846c(parsableByteArray.f7731a, 8, 8);
                i4 = 16;
                o = parsableByteArray.m9351o();
            } else {
                long j = k;
                i4 = 8;
                o = j;
            }
            if (o < ((long) i4)) {
                return false;
            }
            i4 = ((int) o) - i4;
            if (m != Atom.f7134a) {
                if (m != Atom.f7115H) {
                    if (i4 != 0) {
                        if (((long) i3) + o >= ((long) i2)) {
                            break;
                        }
                        defaultExtractorInput.m8845c(i4);
                    } else {
                        continue;
                    }
                } else {
                    z2 = true;
                    break;
                }
            } else if (i4 < 8) {
                return false;
            } else {
                int i5 = (i4 - 8) / 4;
                defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, (i5 + 2) * 4);
                for (i4 = 0; i4 < i5 + 2; i4++) {
                    if (i4 != 1 && m9046a(parsableByteArray.m9349m())) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    return false;
                }
            }
        }
        if (obj == null || z != r3) {
            return false;
        }
        return true;
    }

    private static boolean m9046a(int i) {
        if ((i >>> 8) == Util.m9368c("3gp")) {
            return true;
        }
        for (int i2 : f7220a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
