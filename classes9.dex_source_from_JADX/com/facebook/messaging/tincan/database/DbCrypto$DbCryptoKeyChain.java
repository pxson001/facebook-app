package com.facebook.messaging.tincan.database;

import com.facebook.crypto.keychain.KeyChain;

/* compiled from: closeAndClearTokenInformation */
class DbCrypto$DbCryptoKeyChain implements KeyChain {
    final /* synthetic */ DbCrypto f17889a;
    private final byte[] f17890b;

    public DbCrypto$DbCryptoKeyChain(DbCrypto dbCrypto, byte[] bArr) {
        this.f17889a = dbCrypto;
        this.f17890b = bArr;
    }

    public final byte[] m17897a() {
        return this.f17890b;
    }

    public final byte[] m17898b() {
        byte[] bArr = new byte[DbCrypto.a.ivLength];
        this.f17889a.d.nextBytes(bArr);
        return bArr;
    }
}
