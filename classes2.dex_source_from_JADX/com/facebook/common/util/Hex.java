package com.facebook.common.util;

/* compiled from: few */
public class Hex {
    private static final char[] f23786a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] f23787b = new char[256];
    private static final char[] f23788c = new char[256];
    private static final byte[] f23789d = new byte[103];

    static {
        int i;
        int i2 = 0;
        for (i = 0; i < 256; i++) {
            f23787b[i] = f23786a[(i >> 4) & 15];
            f23788c[i] = f23786a[i & 15];
        }
        for (i = 0; i <= 70; i++) {
            f23789d[i] = (byte) -1;
        }
        for (byte b = (byte) 0; b < (byte) 10; b = (byte) (b + 1)) {
            f23789d[b + 48] = b;
        }
        while (i2 < 6) {
            f23789d[i2 + 65] = (byte) (i2 + 10);
            f23789d[i2 + 97] = (byte) (i2 + 10);
            i2 = (byte) (i2 + 1);
        }
    }

    public static String m32193a(byte[] bArr, boolean z) {
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            if (i2 == 0 && z) {
                break;
            }
            int i3 = i + 1;
            cArr[i] = f23787b[i2];
            i = i3 + 1;
            cArr[i3] = f23788c[i2];
        }
        return new String(cArr, 0, i);
    }

    public static byte[] m32194a(String str) {
        Object obj = 1;
        int length = str.length();
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr = new byte[(length >> 1)];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt <= 'f') {
                byte b = f23789d[charAt];
                if (b == (byte) -1) {
                    break;
                }
                i = i3 + 1;
                char charAt2 = str.charAt(i3);
                if (charAt2 > 'f') {
                    break;
                }
                byte b2 = f23789d[charAt2];
                if (b2 == (byte) -1) {
                    break;
                }
                bArr[i2] = (byte) (b2 | (b << 4));
                i2++;
            } else {
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return bArr;
        }
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + str);
    }
}
