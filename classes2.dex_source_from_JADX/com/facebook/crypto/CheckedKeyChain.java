package com.facebook.crypto;

import com.facebook.crypto.keychain.KeyChain;

/* compiled from: openssl_version */
class CheckedKeyChain implements KeyChain {
    private final KeyChain f10940a;
    private final CryptoConfig f10941b;

    public CheckedKeyChain(KeyChain keyChain, CryptoConfig cryptoConfig) {
        this.f10940a = keyChain;
        this.f10941b = cryptoConfig;
    }

    public final byte[] mo2085a() {
        byte[] a = this.f10940a.mo2085a();
        m16235a(a, this.f10941b.keyLength, "Key");
        return a;
    }

    public final byte[] mo2086b() {
        byte[] b = this.f10940a.mo2086b();
        m16235a(b, this.f10941b.ivLength, "IV");
        return b;
    }

    private static void m16235a(byte[] bArr, int i, String str) {
        if (bArr.length != i) {
            throw new IllegalStateException(str + " should be " + i + " bytes long but is " + bArr.length);
        }
    }
}
