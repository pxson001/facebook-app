package org.whispersystems.curve25519.java;

import org.whispersystems.curve25519.JCESha512Provider;

/* compiled from: addRepeatedField() called on a singular field. */
public class open {
    public static int m21705a(JCESha512Provider jCESha512Provider, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        Object obj = new byte[32];
        Object obj2 = new byte[32];
        Object obj3 = new byte[32];
        byte[] bArr4 = new byte[64];
        byte[] bArr5 = new byte[32];
        ge_p3 org_whispersystems_curve25519_java_ge_p3 = new ge_p3();
        ge_p2 org_whispersystems_curve25519_java_ge_p2 = new ge_p2();
        if (j < 64) {
            return -1;
        }
        if ((bArr2[63] & 224) != 0) {
            return -1;
        }
        if (ge_frombytes.m21688a(org_whispersystems_curve25519_java_ge_p3, bArr3) != 0) {
            return -1;
        }
        jCESha512Provider.m21655a(new byte[64], bArr3, 32);
        System.arraycopy(bArr3, 0, obj, 0, 32);
        System.arraycopy(bArr2, 0, obj2, 0, 32);
        System.arraycopy(bArr2, 32, obj3, 0, 32);
        System.arraycopy(bArr2, 0, bArr, 0, (int) j);
        System.arraycopy(obj, 0, bArr, 32, 32);
        jCESha512Provider.m21655a(bArr4, bArr, j);
        sc_reduce.m21710a(bArr4);
        ge_double_scalarmult.m21686a(org_whispersystems_curve25519_java_ge_p2, bArr4, org_whispersystems_curve25519_java_ge_p3, obj3);
        ge_tobytes.m21704a(bArr5, org_whispersystems_curve25519_java_ge_p2);
        if (crypto_verify_32.m21662a(bArr5, obj2) != 0) {
            return -1;
        }
        System.arraycopy(bArr, 64, bArr, 0, (int) (j - 64));
        return 0;
    }
}
