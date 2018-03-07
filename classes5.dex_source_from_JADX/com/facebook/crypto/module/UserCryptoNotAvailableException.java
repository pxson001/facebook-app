package com.facebook.crypto.module;

/* compiled from: abbrName */
public class UserCryptoNotAvailableException extends Exception {
    public UserCryptoNotAvailableException() {
        super("LoggedInUserCrypto was not configured yet (user key not provided)");
    }
}
