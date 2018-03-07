package org.whispersystems.curve25519.java;

/* compiled from: admin_snippet */
public class fe_mul121666 {
    public static void m21676a(int[] iArr, int[] iArr2) {
        int i = iArr2[0];
        int i2 = iArr2[1];
        int i3 = iArr2[2];
        int i4 = iArr2[3];
        int i5 = iArr2[4];
        int i6 = iArr2[5];
        int i7 = iArr2[6];
        int i8 = iArr2[7];
        long j = ((long) i2) * 121666;
        long j2 = ((long) i4) * 121666;
        long j3 = ((long) i6) * 121666;
        long j4 = ((long) i8) * 121666;
        long j5 = ((long) iArr2[9]) * 121666;
        long j6 = (16777216 + j5) >> 25;
        long j7 = (((long) i) * 121666) + (19 * j6);
        j5 -= j6 << 25;
        j6 = (16777216 + j) >> 25;
        long j8 = (((long) i3) * 121666) + j6;
        j -= j6 << 25;
        j6 = (16777216 + j2) >> 25;
        long j9 = (((long) i5) * 121666) + j6;
        j2 -= j6 << 25;
        j6 = (16777216 + j3) >> 25;
        long j10 = (((long) i7) * 121666) + j6;
        j3 -= j6 << 25;
        j6 = (16777216 + j4) >> 25;
        long j11 = (((long) iArr2[8]) * 121666) + j6;
        j4 -= j6 << 25;
        j6 = (33554432 + j7) >> 26;
        j += j6;
        j7 -= j6 << 26;
        j6 = (33554432 + j8) >> 26;
        j2 += j6;
        j8 -= j6 << 26;
        j6 = (33554432 + j9) >> 26;
        j3 += j6;
        j9 -= j6 << 26;
        j6 = (33554432 + j10) >> 26;
        j4 += j6;
        j10 -= j6 << 26;
        j6 = (33554432 + j11) >> 26;
        j5 += j6;
        j11 -= j6 << 26;
        iArr[0] = (int) j7;
        iArr[1] = (int) j;
        iArr[2] = (int) j8;
        iArr[3] = (int) j2;
        iArr[4] = (int) j9;
        iArr[5] = (int) j3;
        iArr[6] = (int) j10;
        iArr[7] = (int) j4;
        iArr[8] = (int) j11;
        iArr[9] = (int) j5;
    }
}
