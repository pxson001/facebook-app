package org.whispersystems.curve25519.java;

/* compiled from: admin_text_joinable_event_type */
public class fe_isnegative {
    public static int m21674a(int[] iArr) {
        byte[] bArr = new byte[32];
        fe_tobytes.m21684a(bArr, iArr);
        return bArr[0] & 1;
    }
}
