package com.facebook.crypto.keychain;

/* compiled from: syncSource */
class UserStorageKeyChain$1 implements KeyChain {
    final /* synthetic */ byte[] f1514a;
    final /* synthetic */ UserStorageKeyChain f1515b;

    UserStorageKeyChain$1(UserStorageKeyChain userStorageKeyChain, byte[] bArr) {
        this.f1515b = userStorageKeyChain;
        this.f1514a = bArr;
    }

    public final byte[] m1728a() {
        return this.f1514a;
    }

    public final byte[] m1729b() {
        byte[] bArr = new byte[UserStorageKeyChain.b.ivLength];
        this.f1515b.f.nextBytes(bArr);
        return bArr;
    }
}
