package org.whispersystems.curve25519.java;

/* compiled from: addPaymentCardParams */
public class scalarmult {
    public static int m21712a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i;
        byte[] bArr4 = new byte[32];
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        int[] iArr6 = new int[10];
        int[] iArr7 = new int[10];
        for (i = 0; i < 32; i++) {
            bArr4[i] = bArr2[i];
        }
        fe_frombytes.m21671a(iArr, bArr3);
        fe_1.m21665a(iArr2);
        fe_0.m21664a(iArr3);
        fe_copy.m21668a(iArr4, iArr);
        fe_1.m21665a(iArr5);
        i = 254;
        int i2 = 0;
        while (i >= 0) {
            int i3 = (bArr4[i / 8] >>> (i & 7)) & 1;
            i2 ^= i3;
            fe_cswap.m21669a(iArr2, iArr4, i2);
            fe_cswap.m21669a(iArr3, iArr5, i2);
            fe_sub.m21683a(iArr6, iArr4, iArr5);
            fe_sub.m21683a(iArr7, iArr2, iArr3);
            fe_add.m21666a(iArr2, iArr2, iArr3);
            fe_add.m21666a(iArr3, iArr4, iArr5);
            fe_mul.m21677a(iArr5, iArr6, iArr2);
            fe_mul.m21677a(iArr3, iArr3, iArr7);
            fe_sq.m21682a(iArr6, iArr7);
            fe_sq.m21682a(iArr7, iArr2);
            fe_add.m21666a(iArr4, iArr5, iArr3);
            fe_sub.m21683a(iArr3, iArr5, iArr3);
            fe_mul.m21677a(iArr2, iArr7, iArr6);
            fe_sub.m21683a(iArr7, iArr7, iArr6);
            fe_sq.m21682a(iArr3, iArr3);
            fe_mul121666.m21676a(iArr5, iArr7);
            fe_sq.m21682a(iArr4, iArr4);
            fe_add.m21666a(iArr6, iArr6, iArr5);
            fe_mul.m21677a(iArr5, iArr, iArr3);
            fe_mul.m21677a(iArr3, iArr7, iArr6);
            i--;
            i2 = i3;
        }
        fe_cswap.m21669a(iArr2, iArr4, i2);
        fe_cswap.m21669a(iArr3, iArr5, i2);
        fe_invert.m21673a(iArr3, iArr3);
        fe_mul.m21677a(iArr2, iArr2, iArr3);
        fe_tobytes.m21684a(bArr, iArr2);
        return 0;
    }
}
