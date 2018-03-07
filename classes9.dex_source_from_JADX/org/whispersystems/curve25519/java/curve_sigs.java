package org.whispersystems.curve25519.java;

import org.whispersystems.curve25519.JCESha512Provider;

/* compiled from: admin_text_thread_journey_emoji_choices */
public class curve_sigs {
    public static int m21663a(JCESha512Provider jCESha512Provider, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) {
        ge_p3 org_whispersystems_curve25519_java_ge_p3 = new ge_p3();
        byte[] bArr5 = new byte[32];
        Object obj = new byte[(i + 128)];
        ge_scalarmult_base.m21700a(org_whispersystems_curve25519_java_ge_p3, bArr2);
        ge_p3_tobytes.m21697a(bArr5, org_whispersystems_curve25519_java_ge_p3);
        byte b = (byte) (bArr5[31] & 128);
        sign_modified.m21713a(jCESha512Provider, obj, bArr3, (long) i, bArr2, bArr5, bArr4);
        System.arraycopy(obj, 0, bArr, 0, 64);
        bArr[63] = (byte) (bArr[63] & 127);
        bArr[63] = (byte) (b | bArr[63]);
        return 0;
    }
}
