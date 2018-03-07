package com.facebook.crypto;

import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.module.ConcealNativeLibrary;
import java.security.SecureRandom;

/* compiled from: optimistic_scan_finish_time_ms */
public abstract class Conceal {
    public final ConcealNativeLibrary f10929a;
    public final SecureRandom f10930b;

    protected Conceal(ConcealNativeLibrary concealNativeLibrary, SecureRandom secureRandom) {
        this.f10929a = concealNativeLibrary;
        this.f10930b = secureRandom;
    }

    public final Crypto m16213a(KeyChain keyChain) {
        return m16215c(keyChain);
    }

    public final Crypto m16214b(KeyChain keyChain) {
        return new Crypto(keyChain, this.f10929a, CryptoConfig.KEY_128);
    }

    public final Crypto m16215c(KeyChain keyChain) {
        return new Crypto(keyChain, this.f10929a, CryptoConfig.KEY_256);
    }
}
