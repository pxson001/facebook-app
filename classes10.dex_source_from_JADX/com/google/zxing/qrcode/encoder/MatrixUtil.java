package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

/* compiled from: event_discover_suggestion_filters */
public final class MatrixUtil {
    public static final int[][] f13583a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] f13584b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] f13585c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] f13586d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private MatrixUtil() {
    }

    private static void m13843a(Version version, BitArray bitArray) {
        bitArray.m13666a(version.f13550c, 6);
        bitArray.m13666a(m13837a(version.f13550c, 7973), 12);
        if (bitArray.f13476b != 18) {
            throw new WriterException("should not happen but we got: " + bitArray.f13476b);
        }
    }

    static void m13840a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i, ByteMatrix byteMatrix) {
        int i2;
        for (i2 = 0; i2 < byteMatrix.f13580c; i2++) {
            for (int i3 = 0; i3 < byteMatrix.f13579b; i3++) {
                byteMatrix.f13578a[i2][i3] = (byte) -1;
            }
        }
        int length = f13583a[0].length;
        m13850d(0, 0, byteMatrix);
        m13850d(byteMatrix.f13579b - length, 0, byteMatrix);
        m13850d(0, byteMatrix.f13579b - length, byteMatrix);
        m13838a(0, 7, byteMatrix);
        m13838a(byteMatrix.f13579b - 8, 7, byteMatrix);
        m13838a(0, byteMatrix.f13579b - 8, byteMatrix);
        m13844b(7, 0, byteMatrix);
        m13844b((byteMatrix.f13580c - 7) - 1, 0, byteMatrix);
        m13844b(7, byteMatrix.f13580c - 7, byteMatrix);
        m13849c(byteMatrix);
        m13848c(version, byteMatrix);
        for (length = 8; length < byteMatrix.f13579b - 8; length++) {
            i2 = (length + 1) % 2;
            if (m13846b(byteMatrix.m13810a(length, 6))) {
                byteMatrix.m13812a(length, 6, i2);
            }
            if (m13846b(byteMatrix.m13810a(6, length))) {
                byteMatrix.m13812a(6, length, i2);
            }
        }
        m13842a(errorCorrectionLevel, i, byteMatrix);
        m13845b(version, byteMatrix);
        m13839a(bitArray, i, byteMatrix);
    }

    private static void m13842a(ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) {
        BitArray bitArray = new BitArray();
        m13841a(errorCorrectionLevel, i, bitArray);
        for (int i2 = 0; i2 < bitArray.f13476b; i2++) {
            boolean a = bitArray.m13670a((bitArray.f13476b - 1) - i2);
            byteMatrix.m13813a(f13586d[i2][0], f13586d[i2][1], a);
            if (i2 < 8) {
                byteMatrix.m13813a((byteMatrix.f13579b - i2) - 1, 8, a);
            } else {
                byteMatrix.m13813a(8, (byteMatrix.f13580c - 7) + (i2 - 8), a);
            }
        }
    }

    private static void m13845b(Version version, ByteMatrix byteMatrix) {
        if (version.f13550c >= 7) {
            BitArray bitArray = new BitArray();
            m13843a(version, bitArray);
            int i = 17;
            int i2 = 0;
            while (i2 < 6) {
                int i3 = i;
                for (i = 0; i < 3; i++) {
                    boolean a = bitArray.m13670a(i3);
                    i3--;
                    byteMatrix.m13813a(i2, (byteMatrix.f13580c - 11) + i, a);
                    byteMatrix.m13813a((byteMatrix.f13580c - 11) + i, i2, a);
                }
                i2++;
                i = i3;
            }
        }
    }

    private static void m13839a(BitArray bitArray, int i, ByteMatrix byteMatrix) {
        int i2 = byteMatrix.f13579b - 1;
        int i3 = byteMatrix.f13580c - 1;
        int i4 = -1;
        int i5 = 0;
        while (i2 > 0) {
            int i6;
            int i7;
            if (i2 == 6) {
                i6 = i3;
                i7 = i2 - 1;
                i3 = i5;
            } else {
                i6 = i3;
                i7 = i2;
                i3 = i5;
            }
            while (i6 >= 0 && i6 < byteMatrix.f13580c) {
                for (i5 = 0; i5 < 2; i5++) {
                    int i8 = i7 - i5;
                    if (m13846b(byteMatrix.m13810a(i8, i6))) {
                        boolean z;
                        if (i3 < bitArray.f13476b) {
                            boolean a = bitArray.m13670a(i3);
                            i2 = i3 + 1;
                            z = a;
                        } else {
                            i2 = i3;
                            z = false;
                        }
                        if (i != -1 && MaskUtil.m13833a(i, i8, i6)) {
                            if (z) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                        byteMatrix.m13813a(i8, i6, z);
                        i3 = i2;
                    }
                }
                i6 += i4;
            }
            i4 = -i4;
            i2 = i7 - 2;
            i5 = i3;
            i3 = i6 + i4;
        }
        if (i5 != bitArray.f13476b) {
            throw new WriterException("Not all bits consumed: " + i5 + '/' + bitArray.f13476b);
        }
    }

    private static int m13836a(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    private static int m13837a(int i, int i2) {
        int a = m13836a(i2);
        int i3 = i << (a - 1);
        while (m13836a(i3) >= a) {
            i3 ^= i2 << (m13836a(i3) - a);
        }
        return i3;
    }

    private static void m13841a(ErrorCorrectionLevel errorCorrectionLevel, int i, BitArray bitArray) {
        Object obj;
        if (i < 0 || i >= 8) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i;
        bitArray.m13666a(bits, 5);
        bitArray.m13666a(m13837a(bits, 1335), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.m13666a(21522, 15);
        bitArray.m13672b(bitArray2);
        if (bitArray.f13476b != 15) {
            throw new WriterException("should not happen but we got: " + bitArray.f13476b);
        }
    }

    public static boolean m13846b(int i) {
        return i == -1;
    }

    public static void m13849c(ByteMatrix byteMatrix) {
        if (byteMatrix.m13810a(8, byteMatrix.f13580c - 8) == (byte) 0) {
            throw new WriterException();
        }
        byteMatrix.m13812a(8, byteMatrix.f13580c - 8, 1);
    }

    public static void m13838a(int i, int i2, ByteMatrix byteMatrix) {
        int i3 = 0;
        while (i3 < 8) {
            if (m13846b(byteMatrix.m13810a(i + i3, i2))) {
                byteMatrix.m13812a(i + i3, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    public static void m13844b(int i, int i2, ByteMatrix byteMatrix) {
        int i3 = 0;
        while (i3 < 7) {
            if (m13846b(byteMatrix.m13810a(i, i2 + i3))) {
                byteMatrix.m13812a(i, i2 + i3, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void m13847c(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                byteMatrix.m13812a(i + i4, i2 + i3, f13584b[i3][i4]);
            }
        }
    }

    public static void m13850d(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                byteMatrix.m13812a(i + i4, i2 + i3, f13583a[i3][i4]);
            }
        }
    }

    public static void m13848c(Version version, ByteMatrix byteMatrix) {
        if (version.f13550c >= 2) {
            int i = version.f13550c - 1;
            int[] iArr = f13585c[i];
            int length = f13585c[i].length;
            for (int i2 = 0; i2 < length; i2++) {
                for (i = 0; i < length; i++) {
                    int i3 = iArr[i2];
                    int i4 = iArr[i];
                    if (!(i4 == -1 || i3 == -1 || !m13846b(byteMatrix.m13810a(i4, i3)))) {
                        m13847c(i4 - 2, i3 - 2, byteMatrix);
                    }
                }
            }
        }
    }
}
