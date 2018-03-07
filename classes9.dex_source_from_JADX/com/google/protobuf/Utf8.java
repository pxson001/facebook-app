package com.google.protobuf;

/* compiled from: all_phones */
public final class Utf8 {
    private Utf8() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m21522a(int r7, byte[] r8, int r9, int r10) {
        /*
        r3 = -32;
        r4 = -96;
        r1 = -1;
        r6 = -65;
        if (r7 == 0) goto L_0x0082;
    L_0x0009:
        if (r9 < r10) goto L_0x000c;
    L_0x000b:
        return r7;
    L_0x000c:
        r5 = (byte) r7;
        if (r5 >= r3) goto L_0x001b;
    L_0x000f:
        r0 = -62;
        if (r5 < r0) goto L_0x0019;
    L_0x0013:
        r0 = r9 + 1;
        r2 = r8[r9];
        if (r2 <= r6) goto L_0x0081;
    L_0x0019:
        r7 = r1;
        goto L_0x000b;
    L_0x001b:
        r0 = -16;
        if (r5 >= r0) goto L_0x0046;
    L_0x001f:
        r0 = r7 >> 8;
        r0 = r0 ^ -1;
        r0 = (byte) r0;
        if (r0 != 0) goto L_0x0031;
    L_0x0026:
        r2 = r9 + 1;
        r0 = r8[r9];
        if (r2 < r10) goto L_0x0032;
    L_0x002c:
        r7 = m21520a(r5, r0);
        goto L_0x000b;
    L_0x0031:
        r2 = r9;
    L_0x0032:
        if (r0 > r6) goto L_0x0044;
    L_0x0034:
        if (r5 != r3) goto L_0x0038;
    L_0x0036:
        if (r0 < r4) goto L_0x0044;
    L_0x0038:
        r3 = -19;
        if (r5 != r3) goto L_0x003e;
    L_0x003c:
        if (r0 >= r4) goto L_0x0044;
    L_0x003e:
        r9 = r2 + 1;
        r0 = r8[r2];
        if (r0 <= r6) goto L_0x0082;
    L_0x0044:
        r7 = r1;
        goto L_0x000b;
    L_0x0046:
        r0 = r7 >> 8;
        r0 = r0 ^ -1;
        r2 = (byte) r0;
        r0 = 0;
        if (r2 != 0) goto L_0x0059;
    L_0x004e:
        r3 = r9 + 1;
        r2 = r8[r9];
        if (r3 < r10) goto L_0x0087;
    L_0x0054:
        r7 = m21520a(r5, r2);
        goto L_0x000b;
    L_0x0059:
        r0 = r7 >> 16;
        r0 = (byte) r0;
        r4 = r2;
        r3 = r9;
    L_0x005e:
        if (r0 != 0) goto L_0x006b;
    L_0x0060:
        r2 = r3 + 1;
        r0 = r8[r3];
        if (r2 < r10) goto L_0x006c;
    L_0x0066:
        r7 = m21521a(r5, r4, r0);
        goto L_0x000b;
    L_0x006b:
        r2 = r3;
    L_0x006c:
        if (r4 > r6) goto L_0x007f;
    L_0x006e:
        r3 = r5 << 28;
        r4 = r4 + 112;
        r3 = r3 + r4;
        r3 = r3 >> 30;
        if (r3 != 0) goto L_0x007f;
    L_0x0077:
        if (r0 > r6) goto L_0x007f;
    L_0x0079:
        r9 = r2 + 1;
        r0 = r8[r2];
        if (r0 <= r6) goto L_0x0082;
    L_0x007f:
        r7 = r1;
        goto L_0x000b;
    L_0x0081:
        r9 = r0;
    L_0x0082:
        r7 = m21523b(r8, r9, r10);
        goto L_0x000b;
    L_0x0087:
        r4 = r2;
        goto L_0x005e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.a(int, byte[], int, int):int");
    }

    public static int m21523b(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= (byte) 0) {
            i++;
        }
        if (i >= i2) {
            return 0;
        }
        return m21524c(bArr, i, i2);
    }

    private static int m21524c(byte[] bArr, int i, int i2) {
        while (i < i2) {
            int i3 = i + 1;
            int i4 = bArr[i];
            if (i4 < 0) {
                if (i4 < -32) {
                    if (i3 >= i2) {
                        return i4;
                    }
                    if (i4 >= -62) {
                        i4 = i3 + 1;
                        if (bArr[i3] > (byte) -65) {
                        }
                    }
                    return -1;
                } else if (i4 < -16) {
                    if (i3 >= i2 - 1) {
                        return m21525d(bArr, i3, i2);
                    }
                    r3 = i3 + 1;
                    r2 = bArr[i3];
                    if (r2 <= (byte) -65 && ((i4 != -32 || r2 >= (byte) -96) && (i4 != -19 || r2 < (byte) -96))) {
                        i4 = r3 + 1;
                        if (bArr[r3] > (byte) -65) {
                        }
                    }
                    return -1;
                } else if (i3 >= i2 - 2) {
                    return m21525d(bArr, i3, i2);
                } else {
                    r3 = i3 + 1;
                    r2 = bArr[i3];
                    if (r2 <= (byte) -65 && (((i4 << 28) + (r2 + 112)) >> 30) == 0) {
                        i3 = r3 + 1;
                        if (bArr[r3] <= (byte) -65) {
                            i4 = i3 + 1;
                            if (bArr[i3] > (byte) -65) {
                            }
                        }
                    }
                    return -1;
                }
                i = i4;
            } else {
                i = i3;
            }
        }
        return 0;
    }

    private static int m21519a(int i) {
        return i > -12 ? -1 : i;
    }

    private static int m21520a(int i, int i2) {
        return (i > -12 || i2 > -65) ? -1 : (i2 << 8) ^ i;
    }

    private static int m21521a(int i, int i2, int i3) {
        return (i > -12 || i2 > -65 || i3 > -65) ? -1 : ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    private static int m21525d(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return m21519a(b);
            case 1:
                return m21520a(b, bArr[i]);
            case 2:
                return m21521a(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }
}
