package com.facebook.crypto.module;

import com.facebook.android.crypto.keychain.FixedSecureRandom;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.keychain.KeyChain;
import java.io.UnsupportedEncodingException;

/* compiled from: open_permalink_view */
public class FixedKeyChain implements KeyChain {
    private static final FixedSecureRandom f10946a = new FixedSecureRandom();
    private final CryptoConfig f10947b;
    private final byte[] f10948c = new byte[this.f10947b.keyLength];
    private final byte[] f10949d = new byte[64];

    public FixedKeyChain(CryptoConfig cryptoConfig) {
        this.f10947b = cryptoConfig;
        m16241a(this.f10948c, "WRITE2shaver@fb.c");
        m16241a(this.f10949d, "MAC_KEY_4_TEST_EMAIL_SHAVER@FB.COM ");
    }

    public static byte[] m16242a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    private static void m16241a(byte[] bArr, String str) {
        Object a = m16242a(str);
        for (int i = 0; i < bArr.length; i += a.length) {
            System.arraycopy(a, 0, bArr, i, Math.min(a.length, bArr.length - i));
        }
    }

    public final byte[] mo2085a() {
        return this.f10948c;
    }

    public final byte[] mo2086b() {
        byte[] bArr = new byte[this.f10947b.ivLength];
        f10946a.nextBytes(bArr);
        return bArr;
    }
}
