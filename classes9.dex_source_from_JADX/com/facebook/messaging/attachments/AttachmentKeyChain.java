package com.facebook.messaging.attachments;

import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.keychain.KeyChain;
import java.security.SecureRandom;

/* compiled from: p2p_decline_fail */
class AttachmentKeyChain implements KeyChain {
    private final CryptoConfig f7699a;
    private final SecureRandom f7700b;
    private final byte[] f7701c;

    public AttachmentKeyChain(CryptoConfig cryptoConfig, SecureRandom secureRandom, byte[] bArr) {
        this.f7699a = cryptoConfig;
        this.f7700b = secureRandom;
        this.f7701c = bArr;
    }

    public final byte[] m7996a() {
        return this.f7701c;
    }

    public final byte[] m7997b() {
        byte[] bArr = new byte[this.f7699a.ivLength];
        this.f7700b.nextBytes(bArr);
        return bArr;
    }
}
