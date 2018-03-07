package com.facebook.crypto.keychain;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.crudolib.prefs.LightSharedPreferences$Editor;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.crypto.Conceal;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.Entity;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.BaseEncoding;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: open_graph */
public class UserStorageKeyChain implements KeyChain {
    private static final String f10952a = UserStorageKeyChain.class.getName();
    public static final CryptoConfig f10953b = CryptoConfig.KEY_256;
    private static final BaseEncoding f10954c = BaseEncoding.f10965e.mo2094c();
    private static final Entity f10955d = Entity.m16303a("device_key");
    private final LightSharedPreferencesImpl f10956e;
    public final SecureRandom f10957f = this.f10959h.f10930b;
    private final AbstractFbErrorReporter f10958g;
    private final Conceal f10959h;
    @Nullable
    private byte[] f10960i;

    public UserStorageKeyChain(LightSharedPreferencesFactory lightSharedPreferencesFactory, Conceal conceal, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10956e = lightSharedPreferencesFactory.m2550a("user_storage_device_key");
        this.f10958g = abstractFbErrorReporter;
        this.f10959h = conceal;
        m16258g();
    }

    public final synchronized byte[] mo2085a() {
        if (this.f10960i == null) {
            this.f10958g.m2340a(f10952a, "Key is not configured");
            throw new KeyChainException("Key is not configured");
        }
        return this.f10960i;
    }

    public final byte[] mo2086b() {
        byte[] bArr = new byte[CryptoConfig.KEY_256.ivLength];
        this.f10957f.nextBytes(bArr);
        return bArr;
    }

    public final synchronized void m16262c() {
        if (this.f10960i != null) {
            m16254b(this.f10960i);
            this.f10960i = null;
            m16256c("user_storage_device_key");
        }
    }

    public final synchronized boolean m16263d() {
        return this.f10960i != null;
    }

    public final synchronized void m16259a(String str, String str2, @Nullable String str3) {
        List<byte[]> arrayList = new ArrayList(2);
        arrayList.add(m16252a(str2));
        if (!Strings.isNullOrEmpty(str3)) {
            arrayList.add(m16252a(str3));
        }
        String str4 = "user_storage_encrypted_key." + str;
        LightSharedPreferences$Editor b = this.f10956e.m2648b();
        try {
            LoadEncryptedKeyResult a = m16250a(str4, (List) arrayList);
            this.f10960i = a.a;
            if (this.f10960i == null) {
                this.f10960i = m16257f();
            }
            Preconditions.checkNotNull(this.f10960i);
            if (a.b != 0) {
                m16251a(str4, (byte[]) arrayList.get(0), b);
            }
            b.mo3283a("user_storage_device_key", f10954c.m16271a(this.f10960i));
            b.mo3287c();
            for (byte[] b2 : arrayList) {
                m16254b(b2);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            b.mo3287c();
            for (byte[] b22 : arrayList) {
                m16254b(b22);
            }
        }
    }

    private LoadEncryptedKeyResult m16250a(String str, List<byte[]> list) {
        byte[] b = m16255b(str);
        if (b != null) {
            for (int i = 0; i < list.size(); i++) {
                byte[] a = m16253a((byte[]) list.get(i), b);
                if (a != null) {
                    return new LoadEncryptedKeyResult(a, i);
                }
            }
            this.f10958g.m2340a(f10952a, "Cannot decrypt device-key with either user-key!");
        }
        return new LoadEncryptedKeyResult();
    }

    @Nullable
    private byte[] m16253a(byte[] bArr, byte[] bArr2) {
        Throwable e;
        try {
            return m16249a(bArr).m16234b(bArr2, f10955d);
        } catch (CryptoInitializationException e2) {
            e = e2;
            throw new CryptoUnavailable(e);
        } catch (KeyChainException e3) {
            e = e3;
            throw new CryptoUnavailable(e);
        } catch (Throwable e4) {
            this.f10958g.m2343a(f10952a, "Wrong user-key", e4);
            return null;
        }
    }

    private byte[] m16257f() {
        byte[] bArr = new byte[f10953b.keyLength];
        this.f10957f.nextBytes(bArr);
        return bArr;
    }

    private void m16258g() {
        if (this.f10960i != null) {
            m16254b(this.f10960i);
            this.f10960i = null;
        }
        byte[] b = m16255b("user_storage_device_key");
        if (b == null || b.length == f10953b.keyLength) {
            this.f10960i = b;
            return;
        }
        m16256c("user_storage_device_key");
        this.f10958g.m2340a(f10952a, "Error loading device key. Length: " + b.length);
    }

    private void m16251a(String str, byte[] bArr, LightSharedPreferences$Editor lightSharedPreferences$Editor) {
        Throwable e;
        Preconditions.checkNotNull(this.f10960i);
        try {
            lightSharedPreferences$Editor.mo3283a(str, f10954c.m16271a(m16249a(bArr).m16233a(this.f10960i, f10955d)));
        } catch (CryptoInitializationException e2) {
            e = e2;
            throw new CryptoUnavailable(e);
        } catch (KeyChainException e3) {
            e = e3;
            throw new CryptoUnavailable(e);
        } catch (Throwable e4) {
            throw new CryptoUnavailable(e4);
        }
    }

    private Crypto m16249a(byte[] bArr) {
        return this.f10959h.m16215c(new 1(this, bArr));
    }

    private static byte[] m16252a(@Nullable String str) {
        if (str == null) {
            throw new InvalidKeyException("Key cannot be null", null);
        }
        try {
            byte[] a = f10954c.m16273a((CharSequence) str);
            if (a.length == f10953b.keyLength) {
                return a;
            }
            throw new InvalidKeyException("Incorrect key length: " + a.length + ". It should be: " + f10953b.keyLength, null);
        } catch (Throwable e) {
            throw new InvalidKeyException("Incorrect key, invalid hex", e);
        }
    }

    @Nullable
    private byte[] m16255b(String str) {
        byte[] bArr = null;
        CharSequence a = this.f10956e.m2643a(str, "");
        if (!a.isEmpty()) {
            try {
                bArr = f10954c.m16273a(a);
            } catch (IllegalArgumentException e) {
                this.f10958g.m2340a(f10952a, "Error loading hex key, " + str + " = " + a);
                m16256c(str);
            }
        }
        return bArr;
    }

    private void m16256c(String str) {
        this.f10956e.m2648b().mo3279a(str).mo3287c();
    }

    private static void m16254b(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }
}
