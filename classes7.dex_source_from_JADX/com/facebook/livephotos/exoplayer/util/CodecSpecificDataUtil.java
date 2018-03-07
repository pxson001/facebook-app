package com.facebook.livephotos.exoplayer.util;

import android.util.Pair;

/* compiled from: original_aspect_ratio */
public final class CodecSpecificDataUtil {
    public static final byte[] f7687a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] f7688b = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] f7689c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private CodecSpecificDataUtil() {
    }

    public static Pair<Integer, Integer> m9299a(byte[] bArr) {
        int c;
        boolean z;
        boolean z2 = true;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int c2 = parsableBitArray.m9326c(5);
        int c3 = parsableBitArray.m9326c(4);
        if (c3 == 15) {
            c = parsableBitArray.m9326c(24);
        } else {
            if (c3 < 13) {
                z = true;
            } else {
                z = false;
            }
            Assertions.m9295a(z);
            c = f7688b[c3];
        }
        c3 = parsableBitArray.m9326c(4);
        if (c2 == 5 || c2 == 29) {
            c2 = parsableBitArray.m9326c(4);
            if (c2 == 15) {
                c = parsableBitArray.m9326c(24);
            } else {
                if (c2 < 13) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.m9295a(z);
                c = f7688b[c2];
            }
            if (parsableBitArray.m9326c(5) == 22) {
                c3 = c;
                c = parsableBitArray.m9326c(4);
                c = f7689c[c];
                if (c == -1) {
                    z2 = false;
                }
                Assertions.m9295a(z2);
                return Pair.create(Integer.valueOf(c3), Integer.valueOf(c));
            }
        }
        int i = c3;
        c3 = c;
        c = i;
        c = f7689c[c];
        if (c == -1) {
            z2 = false;
        }
        Assertions.m9295a(z2);
        return Pair.create(Integer.valueOf(c3), Integer.valueOf(c));
    }

    public static byte[] m9300a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }
}
