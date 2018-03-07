package com.facebook.crypto;

import com.facebook.crypto.cipher.NativeGCMCipher;
import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.module.ConcealNativeLibrary;

/* compiled from: open_share_composer */
public class CryptoAlgoGcm {
    public final ConcealNativeLibrary f10942a;
    public final KeyChain f10943b;
    public final CryptoConfig f10944c;

    public CryptoAlgoGcm(ConcealNativeLibrary concealNativeLibrary, KeyChain keyChain, CryptoConfig cryptoConfig) {
        this.f10942a = concealNativeLibrary;
        this.f10943b = keyChain;
        this.f10944c = cryptoConfig;
    }

    public static void m16238a(NativeGCMCipher nativeGCMCipher, byte b, byte b2, byte[] bArr) {
        byte[] bArr2 = new byte[]{b2};
        nativeGCMCipher.a(new byte[]{b}, 1);
        nativeGCMCipher.a(bArr2, 1);
        nativeGCMCipher.a(bArr, bArr.length);
    }
}
