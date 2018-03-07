package com.facebook.crypto.keychain;

/* compiled from: abbr_name */
public class UserStorageKeyChain$CryptoUnavailable extends Exception {
    public UserStorageKeyChain$CryptoUnavailable(Throwable th) {
        super("Crypto library is unavailable", th);
    }
}
