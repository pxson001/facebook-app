package org.whispersystems.curve25519.java;

import org.whispersystems.curve25519.JCESha512Provider;

/* compiled from: addPaymentCardId */
public class sign_modified {
    static int m21713a(JCESha512Provider jCESha512Provider, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = new byte[64];
        byte[] bArr7 = new byte[64];
        ge_p3 org_whispersystems_curve25519_java_ge_p3 = new ge_p3();
        System.arraycopy(bArr2, 0, bArr, 64, (int) j);
        System.arraycopy(bArr3, 0, bArr, 32, 32);
        bArr[0] = (byte) -2;
        for (int i = 1; i < 32; i++) {
            bArr[i] = (byte) -1;
        }
        System.arraycopy(bArr5, 0, bArr, (int) (64 + j), 64);
        jCESha512Provider.m21655a(bArr6, bArr, 128 + j);
        System.arraycopy(bArr4, 0, bArr, 32, 32);
        sc_reduce.m21710a(bArr6);
        ge_scalarmult_base.m21700a(org_whispersystems_curve25519_java_ge_p3, bArr6);
        ge_p3_tobytes.m21697a(bArr, org_whispersystems_curve25519_java_ge_p3);
        jCESha512Provider.m21655a(bArr7, bArr, 64 + j);
        sc_reduce.m21710a(bArr7);
        Object obj = new byte[32];
        sc_muladd.m21707a(obj, bArr7, bArr3, bArr6);
        System.arraycopy(obj, 0, bArr, 32, 32);
        return 0;
    }
}
