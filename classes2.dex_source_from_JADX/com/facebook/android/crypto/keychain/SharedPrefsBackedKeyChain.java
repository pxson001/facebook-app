package com.facebook.android.crypto.keychain;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.keychain.KeyChain;

/* compiled from: optimistic_model_class */
public class SharedPrefsBackedKeyChain implements KeyChain {
    protected byte[] f10932a;
    protected boolean f10933b;
    private final CryptoConfig f10934c;
    public final SharedPreferences f10935d;
    public final FixedSecureRandom f10936e;

    public SharedPrefsBackedKeyChain(Context context, CryptoConfig cryptoConfig) {
        String str;
        if (cryptoConfig == CryptoConfig.KEY_128) {
            str = "crypto";
        } else {
            str = "crypto." + String.valueOf(cryptoConfig);
        }
        this.f10935d = context.getSharedPreferences(str, 0);
        this.f10936e = new FixedSecureRandom();
        this.f10934c = cryptoConfig;
    }

    public final synchronized byte[] mo2085a() {
        if (!this.f10933b) {
            this.f10932a = m16223a("cipher_key", this.f10934c.keyLength);
        }
        this.f10933b = true;
        return this.f10932a;
    }

    public final byte[] mo2086b() {
        byte[] bArr = new byte[this.f10934c.ivLength];
        this.f10936e.nextBytes(bArr);
        return bArr;
    }

    private byte[] m16223a(String str, int i) {
        String string = this.f10935d.getString(str, null);
        byte[] bArr;
        if (string == null) {
            String str2;
            bArr = new byte[i];
            this.f10936e.nextBytes(bArr);
            Editor edit = this.f10935d.edit();
            if (bArr == null) {
                str2 = null;
            } else {
                str2 = Base64.encodeToString(bArr, 0);
            }
            edit.putString(str, str2);
            edit.commit();
            return bArr;
        }
        if (string == null) {
            bArr = null;
        } else {
            bArr = Base64.decode(string, 0);
        }
        return bArr;
    }
}
