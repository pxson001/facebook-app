package com.facebook.livephotos.exoplayer.util;

import com.facebook.livephotos.exoplayer.MediaFormat;

/* compiled from: original_image_width */
public final class Ac3Util {
    public static final int[] f7681a = new int[]{1, 2, 3, 6};
    public static final int[] f7682b = new int[]{48000, 44100, 32000};
    public static final int[] f7683c = new int[]{24000, 22050, 16000};
    public static final int[] f7684d = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    public static final int[] f7685e = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    public static final int[] f7686f = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static MediaFormat m9289a(ParsableByteArray parsableByteArray, String str, long j, String str2) {
        int i = f7682b[(parsableByteArray.m9343f() & 192) >> 6];
        int f = parsableByteArray.m9343f();
        int i2 = f7684d[(f & 56) >> 3];
        if ((f & 4) != 0) {
            i2++;
        }
        return MediaFormat.m8740a(str, "audio/ac3", -1, -1, j, i2, i, null, str2);
    }

    public static MediaFormat m9291b(ParsableByteArray parsableByteArray, String str, long j, String str2) {
        parsableByteArray.m9339c(2);
        int i = f7682b[(parsableByteArray.m9343f() & 192) >> 6];
        int f = parsableByteArray.m9343f();
        int i2 = f7684d[(f & 14) >> 1];
        if ((f & 1) != 0) {
            i2++;
        }
        return MediaFormat.m8740a(str, "audio/eac3", -1, -1, j, i2, i, null, str2);
    }

    public static MediaFormat m9288a(ParsableBitArray parsableBitArray, String str, long j, String str2) {
        int i = 1;
        parsableBitArray.m9324b(32);
        int c = parsableBitArray.m9326c(2);
        parsableBitArray.m9324b(14);
        int c2 = parsableBitArray.m9326c(3);
        if (!((c2 & 1) == 0 || c2 == 1)) {
            parsableBitArray.m9324b(2);
        }
        if ((c2 & 4) != 0) {
            parsableBitArray.m9324b(2);
        }
        if (c2 == 2) {
            parsableBitArray.m9324b(2);
        }
        boolean b = parsableBitArray.m9325b();
        String str3 = "audio/ac3";
        c2 = f7684d[c2];
        if (!b) {
            i = 0;
        }
        return MediaFormat.m8740a(str, str3, -1, -1, j, c2 + i, f7682b[c], null, str2);
    }

    public static int m9287a(byte[] bArr) {
        int i = bArr[4] & 63;
        int i2 = f7682b[(bArr[4] & 192) >> 6];
        if (i2 == 44100) {
            i2 = (f7686f[i / 2] + (i % 2)) * 2;
        } else {
            int i3 = f7685e[i / 2];
            if (i2 == 32000) {
                i2 = i3 * 6;
            } else {
                i2 = i3 * 4;
            }
        }
        return i2;
    }

    public static int m9290b(byte[] bArr) {
        return ((((bArr[2] & 7) << 8) + (bArr[3] & 255)) + 1) * 2;
    }

    public static int m9292c(byte[] bArr) {
        return (((bArr[4] & 192) >> 6) == 3 ? 6 : f7681a[(bArr[4] & 48) >> 4]) * 256;
    }

    private Ac3Util() {
    }
}
