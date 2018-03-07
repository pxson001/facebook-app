package org.whispersystems.curve25519;

import org.whispersystems.curve25519.java.curve_sigs;
import org.whispersystems.curve25519.java.fe_1;
import org.whispersystems.curve25519.java.fe_add;
import org.whispersystems.curve25519.java.fe_frombytes;
import org.whispersystems.curve25519.java.fe_invert;
import org.whispersystems.curve25519.java.fe_mul;
import org.whispersystems.curve25519.java.fe_sub;
import org.whispersystems.curve25519.java.fe_tobytes;
import org.whispersystems.curve25519.java.ge_p3;
import org.whispersystems.curve25519.java.ge_scalarmult_base;
import org.whispersystems.curve25519.java.open;
import org.whispersystems.curve25519.java.scalarmult;

/* compiled from: ads_section */
abstract class BaseJavaCurve25519Provider implements Curve25519Provider {
    private final JCESha512Provider f21208a;
    private JCESecureRandomProvider f21209b;

    protected BaseJavaCurve25519Provider(JCESha512Provider jCESha512Provider, JCESecureRandomProvider jCESecureRandomProvider) {
        this.f21208a = jCESha512Provider;
        this.f21209b = jCESecureRandomProvider;
    }

    public void mo929a(JCESecureRandomProvider jCESecureRandomProvider) {
        this.f21209b = jCESecureRandomProvider;
    }

    public byte[] calculateAgreement(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        scalarmult.m21712a(bArr3, bArr, bArr2);
        return bArr3;
    }

    public byte[] generatePublicKey(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        ge_p3 org_whispersystems_curve25519_java_ge_p3 = new ge_p3();
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        ge_scalarmult_base.m21700a(org_whispersystems_curve25519_java_ge_p3, bArr);
        fe_add.m21666a(iArr, org_whispersystems_curve25519_java_ge_p3.f21233b, org_whispersystems_curve25519_java_ge_p3.f21234c);
        fe_sub.m21683a(iArr2, org_whispersystems_curve25519_java_ge_p3.f21234c, org_whispersystems_curve25519_java_ge_p3.f21233b);
        fe_invert.m21673a(iArr3, iArr2);
        fe_mul.m21677a(iArr4, iArr, iArr3);
        fe_tobytes.m21684a(bArr2, iArr4);
        return bArr2;
    }

    public byte[] mo930a() {
        Object obj = new byte[32];
        System.arraycopy(mo931a(32), 0, obj, 0, 32);
        obj[0] = (byte) (obj[0] & 248);
        obj[31] = (byte) (obj[31] & 127);
        obj[31] = (byte) (obj[31] | 64);
        return obj;
    }

    public byte[] calculateSignature(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[64];
        if (curve_sigs.m21663a(this.f21208a, bArr4, bArr2, bArr3, bArr3.length, bArr) == 0) {
            return bArr4;
        }
        throw new IllegalArgumentException("Message exceeds max length!");
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        JCESha512Provider jCESha512Provider = this.f21208a;
        int length = bArr2.length;
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        int[] iArr6 = new int[10];
        byte[] bArr4 = new byte[32];
        Object obj = new byte[(length + 64)];
        byte[] bArr5 = new byte[(length + 64)];
        fe_frombytes.m21671a(iArr, bArr);
        fe_1.m21665a(iArr5);
        fe_sub.m21683a(iArr2, iArr, iArr5);
        fe_add.m21666a(iArr3, iArr, iArr5);
        fe_invert.m21673a(iArr4, iArr3);
        fe_mul.m21677a(iArr6, iArr2, iArr4);
        fe_tobytes.m21684a(bArr4, iArr6);
        bArr4[31] = (byte) (bArr4[31] & 127);
        bArr4[31] = (byte) (bArr4[31] | (bArr3[63] & 128));
        System.arraycopy(bArr3, 0, obj, 0, 64);
        obj[63] = (byte) (obj[63] & 127);
        System.arraycopy(bArr2, 0, obj, 64, length);
        return open.m21705a(jCESha512Provider, bArr5, obj, (long) (length + 64), bArr4) == 0;
    }

    public byte[] mo931a(int i) {
        byte[] bArr = new byte[i];
        this.f21209b.m21654a(bArr);
        return bArr;
    }
}
