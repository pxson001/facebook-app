package org.whispersystems.curve25519.java;

/* compiled from: admin_text_thread_journey_nickname_choices */
public class crypto_verify_32 {
    public static int m21662a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (i < 32) {
            i2 |= bArr[i] ^ bArr2[i];
            i++;
        }
        return i2;
    }
}
