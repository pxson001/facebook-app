package com.facebook.livephotos.exoplayer.extractor.ogg;

import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;
import java.io.EOFException;

/* compiled from: page_header_parallel_fetch_started */
final class OggUtil {
    private static final int f7279a = Util.m9368c("OggS");

    /* compiled from: page_header_parallel_fetch_started */
    public class PacketInfoHolder {
        public int f7267a;
        public int f7268b;
    }

    /* compiled from: page_header_parallel_fetch_started */
    public final class PageHeader {
        public int f7269a;
        public int f7270b;
        public long f7271c;
        public long f7272d;
        public long f7273e;
        public long f7274f;
        public int f7275g;
        public int f7276h;
        public int f7277i;
        public final int[] f7278j = new int[255];

        public final void m9059a() {
            this.f7269a = 0;
            this.f7270b = 0;
            this.f7271c = 0;
            this.f7272d = 0;
            this.f7273e = 0;
            this.f7274f = 0;
            this.f7275g = 0;
            this.f7276h = 0;
            this.f7277i = 0;
        }
    }

    OggUtil() {
    }

    public static void m9060a(DefaultExtractorInput defaultExtractorInput) {
        int i = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            if (defaultExtractorInput.f6963c != -1 && defaultExtractorInput.f6964d + ((long) r0) > defaultExtractorInput.f6963c) {
                i = (int) (defaultExtractorInput.f6963c - defaultExtractorInput.f6964d);
                if (i < 4) {
                    throw new EOFException();
                }
            }
            defaultExtractorInput.m8843b(bArr, 0, i, false);
            int i2 = 0;
            while (i2 < i - 3) {
                if (bArr[i2] == (byte) 79 && bArr[i2 + 1] == (byte) 103 && bArr[i2 + 2] == (byte) 103 && bArr[i2 + 3] == (byte) 83) {
                    defaultExtractorInput.m8841b(i2);
                    return;
                }
                i2++;
            }
            defaultExtractorInput.m8841b(i - 3);
        }
    }

    public static boolean m9062a(DefaultExtractorInput defaultExtractorInput, PageHeader pageHeader, ParsableByteArray parsableByteArray, boolean z) {
        int i;
        int i2 = 0;
        parsableByteArray.m9331a();
        pageHeader.m9059a();
        if (defaultExtractorInput.f6963c == -1 || defaultExtractorInput.f6963c - defaultExtractorInput.m8840b() >= 27) {
            i = true;
        } else {
            i = 0;
        }
        if (i == 0 || !defaultExtractorInput.m8843b(parsableByteArray.f7731a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (parsableByteArray.m9347k() == ((long) f7279a)) {
            pageHeader.f7269a = parsableByteArray.m9343f();
            if (pageHeader.f7269a == 0) {
                pageHeader.f7270b = parsableByteArray.m9343f();
                pageHeader.f7271c = parsableByteArray.m9352p();
                pageHeader.f7272d = parsableByteArray.m9348l();
                pageHeader.f7273e = parsableByteArray.m9348l();
                pageHeader.f7274f = parsableByteArray.m9348l();
                pageHeader.f7275g = parsableByteArray.m9343f();
                parsableByteArray.m9331a();
                pageHeader.f7276h = pageHeader.f7275g + 27;
                defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, pageHeader.f7275g);
                while (i2 < pageHeader.f7275g) {
                    pageHeader.f7278j[i2] = parsableByteArray.m9343f();
                    pageHeader.f7277i += pageHeader.f7278j[i2];
                    i2++;
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new ParserException("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
    }

    public static void m9061a(PageHeader pageHeader, int i, PacketInfoHolder packetInfoHolder) {
        packetInfoHolder.f7268b = 0;
        packetInfoHolder.f7267a = 0;
        while (packetInfoHolder.f7268b + i < pageHeader.f7275g) {
            int[] iArr = pageHeader.f7278j;
            int i2 = packetInfoHolder.f7268b;
            packetInfoHolder.f7268b = i2 + 1;
            int i3 = iArr[i2 + i];
            packetInfoHolder.f7267a += i3;
            if (i3 != 255) {
                return;
            }
        }
    }
}
