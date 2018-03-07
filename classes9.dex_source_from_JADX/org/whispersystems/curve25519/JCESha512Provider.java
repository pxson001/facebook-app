package org.whispersystems.curve25519;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: admin_text_thread_rtc_server_info_data */
public class JCESha512Provider {
    public final void m21655a(byte[] bArr, byte[] bArr2, long j) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-512");
            instance.update(bArr2, 0, (int) j);
            Object digest = instance.digest();
            System.arraycopy(digest, 0, bArr, 0, digest.length);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
