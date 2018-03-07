package com.facebook.messaging.tincan.crypto;

import org.whispersystems.libsignal.state.IdentityKeyStore;

/* compiled from: com.facebook.CallbackManager */
public class CryptoSessionFactory {
    private static final Class<?> f17860a = CryptoSessionFactory.class;
    public final IdentityKeyStore f17861b;

    public CryptoSessionFactory(IdentityKeyStore identityKeyStore) {
        this.f17861b = identityKeyStore;
    }

    public final CryptoSessionImpl m17859a(String str) {
        return new CryptoSessionImpl(str, this.f17861b);
    }
}
