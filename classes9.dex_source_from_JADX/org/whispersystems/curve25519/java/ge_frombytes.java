package org.whispersystems.curve25519.java;

/* compiled from: address_typeahead_select */
public class ge_frombytes {
    static int[] f21223a = new int[]{-10913610, 13857413, -15372611, 6949391, 114729, -8787816, -6275908, -3247719, -18696448, -12055116};
    static int[] f21224b = new int[]{-32595792, -7943725, 9377950, 3500415, 12389472, -272473, -25146209, -2005654, 326686, 11406482};

    static int m21688a(ge_p3 org_whispersystems_curve25519_java_ge_p3, byte[] bArr) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        fe_frombytes.m21671a(org_whispersystems_curve25519_java_ge_p3.f21233b, bArr);
        fe_1.m21665a(org_whispersystems_curve25519_java_ge_p3.f21234c);
        fe_sq.m21682a(iArr, org_whispersystems_curve25519_java_ge_p3.f21233b);
        fe_mul.m21677a(iArr2, iArr, f21223a);
        fe_sub.m21683a(iArr, iArr, org_whispersystems_curve25519_java_ge_p3.f21234c);
        fe_add.m21666a(iArr2, iArr2, org_whispersystems_curve25519_java_ge_p3.f21234c);
        fe_sq.m21682a(iArr3, iArr2);
        fe_mul.m21677a(iArr3, iArr3, iArr2);
        fe_sq.m21682a(org_whispersystems_curve25519_java_ge_p3.f21232a, iArr3);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p3.f21232a, iArr2);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p3.f21232a, iArr);
        fe_pow22523.m21680a(org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p3.f21232a);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p3.f21232a, iArr3);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p3.f21232a, iArr);
        fe_sq.m21682a(iArr4, org_whispersystems_curve25519_java_ge_p3.f21232a);
        fe_mul.m21677a(iArr4, iArr4, iArr2);
        fe_sub.m21683a(iArr5, iArr4, iArr);
        if (fe_isnonzero.m21675a(iArr5) != 0) {
            fe_add.m21666a(iArr5, iArr4, iArr);
            if (fe_isnonzero.m21675a(iArr5) != 0) {
                return -1;
            }
            fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p3.f21232a, f21224b);
        }
        if (fe_isnegative.m21674a(org_whispersystems_curve25519_java_ge_p3.f21232a) == ((bArr[31] >>> 7) & 1)) {
            fe_neg.m21679a(org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p3.f21232a);
        }
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21235d, org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p3.f21233b);
        return 0;
    }
}
