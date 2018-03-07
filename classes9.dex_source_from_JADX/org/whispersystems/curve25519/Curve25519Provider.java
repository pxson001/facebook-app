package org.whispersystems.curve25519;

/* compiled from: ads_targeting */
public interface Curve25519Provider {
    void mo929a(JCESecureRandomProvider jCESecureRandomProvider);

    byte[] mo930a();

    byte[] mo931a(int i);

    byte[] calculateAgreement(byte[] bArr, byte[] bArr2);

    byte[] calculateSignature(byte[] bArr, byte[] bArr2, byte[] bArr3);

    byte[] generatePublicKey(byte[] bArr);

    boolean verifySignature(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
