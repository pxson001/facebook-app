package com.facebook.livephotos.exoplayer.util;

import com.facebook.livephotos.exoplayer.MediaFormat;

/* compiled from: org.internet */
public final class DtsUtil {
    private static final int[] f7690a = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] f7691b = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] f7692c = new int[]{64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final ParsableBitArray f7693d = new ParsableBitArray();

    public static MediaFormat m9301a(byte[] bArr, String str, long j, String str2) {
        ParsableBitArray parsableBitArray = f7693d;
        parsableBitArray.m9323a(bArr, bArr.length);
        parsableBitArray.m9324b(60);
        int i = f7690a[parsableBitArray.m9326c(6)];
        int i2 = f7691b[parsableBitArray.m9326c(4)];
        int c = parsableBitArray.m9326c(5);
        c = c >= f7692c.length ? -1 : (f7692c[c] * 1000) / 2;
        parsableBitArray.m9324b(10);
        return MediaFormat.m8740a(str, "audio/vnd.dts", c, -1, j, i + (parsableBitArray.m9326c(2) > 0 ? 1 : 0), i2, null, str2);
    }

    private DtsUtil() {
    }
}
