package com.google.zxing.qrcode.encoder;

/* compiled from: event_discovery */
public final class MaskUtil {
    private MaskUtil() {
    }

    static int m13834c(ByteMatrix byteMatrix) {
        byte[][] bArr = byteMatrix.f13578a;
        int i = byteMatrix.f13579b;
        int i2 = byteMatrix.f13580c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = 0;
            while (i5 < i) {
                if (i5 + 6 < i && bArr[i3][i5] == (byte) 1 && bArr[i3][i5 + 1] == (byte) 0 && bArr[i3][i5 + 2] == (byte) 1 && bArr[i3][i5 + 3] == (byte) 1 && bArr[i3][i5 + 4] == (byte) 1 && bArr[i3][i5 + 5] == (byte) 0 && bArr[i3][i5 + 6] == (byte) 1 && ((i5 + 10 < i && bArr[i3][i5 + 7] == (byte) 0 && bArr[i3][i5 + 8] == (byte) 0 && bArr[i3][i5 + 9] == (byte) 0 && bArr[i3][i5 + 10] == (byte) 0) || (i5 - 4 >= 0 && bArr[i3][i5 - 1] == (byte) 0 && bArr[i3][i5 - 2] == (byte) 0 && bArr[i3][i5 - 3] == (byte) 0 && bArr[i3][i5 - 4] == (byte) 0))) {
                    i4 += 40;
                }
                if (i3 + 6 < i2 && bArr[i3][i5] == (byte) 1 && bArr[i3 + 1][i5] == (byte) 0 && bArr[i3 + 2][i5] == (byte) 1 && bArr[i3 + 3][i5] == (byte) 1 && bArr[i3 + 4][i5] == (byte) 1 && bArr[i3 + 5][i5] == (byte) 0 && bArr[i3 + 6][i5] == (byte) 1 && ((i3 + 10 < i2 && bArr[i3 + 7][i5] == (byte) 0 && bArr[i3 + 8][i5] == (byte) 0 && bArr[i3 + 9][i5] == (byte) 0 && bArr[i3 + 10][i5] == (byte) 0) || (i3 - 4 >= 0 && bArr[i3 - 1][i5] == (byte) 0 && bArr[i3 - 2][i5] == (byte) 0 && bArr[i3 - 3][i5] == (byte) 0 && bArr[i3 - 4][i5] == (byte) 0))) {
                    i4 += 40;
                }
                i5++;
            }
            i3++;
        }
        return i4;
    }

    static int m13835d(ByteMatrix byteMatrix) {
        byte[][] bArr = byteMatrix.f13578a;
        int i = byteMatrix.f13579b;
        int i2 = byteMatrix.f13580c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            byte[] bArr2 = bArr[i4];
            for (int i5 = 0; i5 < i; i5++) {
                if (bArr2[i5] == (byte) 1) {
                    i3++;
                }
            }
        }
        return ((int) (Math.abs((((double) i3) / ((double) (byteMatrix.f13580c * byteMatrix.f13579b))) - 0.5d) * 20.0d)) * 10;
    }

    static boolean m13833a(int i, int i2, int i3) {
        int i4;
        switch (i) {
            case 0:
                i4 = (i3 + i2) & 1;
                break;
            case 1:
                i4 = i3 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i4 = ((i3 >>> 1) + (i2 / 3)) & 1;
                break;
            case 5:
                i4 = i3 * i2;
                i4 = (i4 % 3) + (i4 & 1);
                break;
            case 6:
                i4 = i3 * i2;
                i4 = ((i4 % 3) + (i4 & 1)) & 1;
                break;
            case 7:
                i4 = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i);
        }
        if (i4 == 0) {
            return true;
        }
        return false;
    }

    public static int m13832a(ByteMatrix byteMatrix, boolean z) {
        int i;
        int i2;
        if (z) {
            i = byteMatrix.f13580c;
        } else {
            i = byteMatrix.f13579b;
        }
        if (z) {
            i2 = byteMatrix.f13579b;
        } else {
            i2 = byteMatrix.f13580c;
        }
        byte[][] bArr = byteMatrix.f13578a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            byte b = (byte) -1;
            int i5 = 0;
            int i6 = 0;
            while (i5 < i2) {
                int i7;
                int i8;
                byte b2;
                byte b3 = z ? bArr[i3][i5] : bArr[i5][i3];
                byte b4;
                if (b3 == b) {
                    b4 = b;
                    i7 = i6 + 1;
                    i8 = i4;
                    b2 = b4;
                } else {
                    if (i6 >= 5) {
                        i4 += (i6 - 5) + 3;
                    }
                    i7 = 1;
                    b4 = b3;
                    i8 = i4;
                    b2 = b4;
                }
                i5++;
                i6 = i7;
                b = b2;
                i4 = i8;
            }
            if (i6 > 5) {
                i4 += (i6 - 5) + 3;
            }
            i3++;
        }
        return i4;
    }
}
