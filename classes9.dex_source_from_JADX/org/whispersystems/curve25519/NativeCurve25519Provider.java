package org.whispersystems.curve25519;

/* compiled from: admin_text_thread_rtc_event */
class NativeCurve25519Provider implements Curve25519Provider {
    private static boolean f21213a;
    private static Throwable f21214b;
    private JCESecureRandomProvider f21215c = new JCESecureRandomProvider();

    private native boolean smokeCheck(int i);

    public native byte[] calculateAgreement(byte[] bArr, byte[] bArr2);

    public native byte[] calculateSignature(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native byte[] generatePrivateKey(byte[] bArr);

    public native byte[] generatePublicKey(byte[] bArr);

    public native boolean verifySignature(byte[] bArr, byte[] bArr2, byte[] bArr3);

    static {
        Throwable e;
        f21213a = false;
        f21214b = null;
        try {
            System.loadLibrary("curve25519");
            f21213a = true;
            return;
        } catch (UnsatisfiedLinkError e2) {
            e = e2;
        } catch (SecurityException e3) {
            e = e3;
        }
        f21213a = false;
        f21214b = e;
    }

    NativeCurve25519Provider() {
        if (f21213a) {
            try {
                smokeCheck(31337);
                return;
            } catch (Throwable e) {
                throw new NoSuchProviderException(e);
            }
        }
        throw new NoSuchProviderException(f21214b);
    }

    public final byte[] mo930a() {
        return generatePrivateKey(mo931a(32));
    }

    public final byte[] mo931a(int i) {
        byte[] bArr = new byte[i];
        this.f21215c.m21654a(bArr);
        return bArr;
    }

    public final void mo929a(JCESecureRandomProvider jCESecureRandomProvider) {
        this.f21215c = jCESecureRandomProvider;
    }
}
