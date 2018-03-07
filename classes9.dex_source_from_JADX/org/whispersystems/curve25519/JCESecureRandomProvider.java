package org.whispersystems.curve25519;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* compiled from: admin_text_type */
public class JCESecureRandomProvider {
    public final void m21654a(byte[] bArr) {
        try {
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
