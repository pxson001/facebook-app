package org.whispersystems.curve25519;

/* compiled from: admin_text_thread_message_lifetime */
public class OpportunisticCurve25519Provider implements Curve25519Provider {
    private Curve25519Provider f21216a;

    OpportunisticCurve25519Provider() {
        try {
            this.f21216a = new NativeCurve25519Provider();
        } catch (NoSuchProviderException e) {
            this.f21216a = new JavaCurve25519Provider();
        }
    }

    public byte[] calculateAgreement(byte[] bArr, byte[] bArr2) {
        return this.f21216a.calculateAgreement(bArr, bArr2);
    }

    public byte[] generatePublicKey(byte[] bArr) {
        return this.f21216a.generatePublicKey(bArr);
    }

    public final byte[] mo930a() {
        return this.f21216a.mo930a();
    }

    public final byte[] mo931a(int i) {
        return this.f21216a.mo931a(i);
    }

    public final void mo929a(JCESecureRandomProvider jCESecureRandomProvider) {
        this.f21216a.mo929a(jCESecureRandomProvider);
    }

    public byte[] calculateSignature(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f21216a.calculateSignature(bArr, bArr2, bArr3);
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f21216a.verifySignature(bArr, bArr2, bArr3);
    }
}
