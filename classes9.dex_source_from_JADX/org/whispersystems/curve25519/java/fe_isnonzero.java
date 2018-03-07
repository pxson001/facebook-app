package org.whispersystems.curve25519.java;

/* compiled from: admin_text_game_score_data */
public class fe_isnonzero {
    static final byte[] f21217a = new byte[32];

    public static int m21675a(int[] iArr) {
        byte[] bArr = new byte[32];
        fe_tobytes.m21684a(bArr, iArr);
        return crypto_verify_32.m21662a(bArr, f21217a);
    }
}
