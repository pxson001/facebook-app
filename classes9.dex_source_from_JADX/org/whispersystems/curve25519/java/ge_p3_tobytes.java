package org.whispersystems.curve25519.java;

/* compiled from: add_members */
public class ge_p3_tobytes {
    public static void m21697a(byte[] bArr, ge_p3 org_whispersystems_curve25519_java_ge_p3) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        fe_invert.m21673a(iArr, org_whispersystems_curve25519_java_ge_p3.f21234c);
        fe_mul.m21677a(iArr2, org_whispersystems_curve25519_java_ge_p3.f21232a, iArr);
        fe_mul.m21677a(iArr3, org_whispersystems_curve25519_java_ge_p3.f21233b, iArr);
        fe_tobytes.m21684a(bArr, iArr3);
        bArr[31] = (byte) ((fe_isnegative.m21674a(iArr2) << 7) ^ bArr[31]);
    }
}
