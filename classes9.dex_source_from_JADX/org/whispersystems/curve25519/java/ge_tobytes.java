package org.whispersystems.curve25519.java;

/* compiled from: addRepeatedField() can only be called on repeated fields. */
public class ge_tobytes {
    public static void m21704a(byte[] bArr, ge_p2 org_whispersystems_curve25519_java_ge_p2) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        fe_invert.m21673a(iArr, org_whispersystems_curve25519_java_ge_p2.f21231c);
        fe_mul.m21677a(iArr2, org_whispersystems_curve25519_java_ge_p2.f21229a, iArr);
        fe_mul.m21677a(iArr3, org_whispersystems_curve25519_java_ge_p2.f21230b, iArr);
        fe_tobytes.m21684a(bArr, iArr3);
        bArr[31] = (byte) ((fe_isnegative.m21674a(iArr2) << 7) ^ bArr[31]);
    }
}
