package org.whispersystems.curve25519.java;

/* compiled from: admin_text_target_id */
public class fe_frombytes {
    private static long m21670a(byte[] bArr, int i) {
        return ((((long) bArr[i + 0]) & 255) | ((((long) bArr[i + 1]) << 8) & 65280)) | ((((long) bArr[i + 2]) << 16) & 16711680);
    }

    private static long m21672b(byte[] bArr, int i) {
        return (((((long) bArr[i + 0]) & 255) | ((((long) bArr[i + 1]) << 8) & 65280)) | ((((long) bArr[i + 2]) << 16) & 16711680)) | ((((long) bArr[i + 3]) << 24) & 4278190080L);
    }

    public static void m21671a(int[] iArr, byte[] bArr) {
        long b = m21672b(bArr, 0);
        long a = m21670a(bArr, 4) << 6;
        long a2 = m21670a(bArr, 7) << 5;
        long a3 = m21670a(bArr, 10) << 3;
        long a4 = m21670a(bArr, 13) << 2;
        long b2 = m21672b(bArr, 16);
        long a5 = m21670a(bArr, 23) << 5;
        long a6 = (m21670a(bArr, 29) & 8388607) << 2;
        long j = (16777216 + a6) >> 25;
        b += 19 * j;
        a6 -= j << 25;
        j = (16777216 + a) >> 25;
        a2 += j;
        a -= j << 25;
        j = (16777216 + a3) >> 25;
        a4 += j;
        a3 -= j << 25;
        j = (16777216 + b2) >> 25;
        long a7 = (m21670a(bArr, 20) << 7) + j;
        b2 -= j << 25;
        j = (16777216 + a5) >> 25;
        long a8 = (m21670a(bArr, 26) << 4) + j;
        a5 -= j << 25;
        j = (33554432 + b) >> 26;
        a += j;
        b -= j << 26;
        j = (33554432 + a2) >> 26;
        a3 += j;
        a2 -= j << 26;
        j = (33554432 + a4) >> 26;
        b2 += j;
        a4 -= j << 26;
        j = (33554432 + a7) >> 26;
        a5 += j;
        a7 -= j << 26;
        j = (33554432 + a8) >> 26;
        a6 += j;
        a8 -= j << 26;
        iArr[0] = (int) b;
        iArr[1] = (int) a;
        iArr[2] = (int) a2;
        iArr[3] = (int) a3;
        iArr[4] = (int) a4;
        iArr[5] = (int) b2;
        iArr[6] = (int) a7;
        iArr[7] = (int) a5;
        iArr[8] = (int) a8;
        iArr[9] = (int) a6;
    }
}
