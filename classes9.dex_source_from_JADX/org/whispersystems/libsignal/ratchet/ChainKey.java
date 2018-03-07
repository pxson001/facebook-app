package org.whispersystems.libsignal.ratchet;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.whispersystems.libsignal.kdf.DerivedMessageSecrets;
import org.whispersystems.libsignal.kdf.HKDF;

/* compiled from: action_sheet_message */
public class ChainKey {
    private static final byte[] f21334a = new byte[]{(byte) 1};
    private static final byte[] f21335b = new byte[]{(byte) 2};
    private final HKDF f21336c;
    public final byte[] f21337d;
    public final int f21338e;

    public ChainKey(HKDF hkdf, byte[] bArr, int i) {
        this.f21336c = hkdf;
        this.f21337d = bArr;
        this.f21338e = i;
    }

    public final int m21885b() {
        return this.f21338e;
    }

    public final ChainKey m21886c() {
        return new ChainKey(this.f21336c, m21884a(f21335b), this.f21338e + 1);
    }

    public final MessageKeys m21887d() {
        DerivedMessageSecrets derivedMessageSecrets = new DerivedMessageSecrets(this.f21336c.m21748a(m21884a(f21334a), "WhisperMessageKeys".getBytes(), 80));
        return new MessageKeys(derivedMessageSecrets.f21264a, derivedMessageSecrets.f21265b, derivedMessageSecrets.f21266c, this.f21338e);
    }

    private byte[] m21884a(byte[] bArr) {
        Object e;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(this.f21337d, "HmacSHA256"));
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (InvalidKeyException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }
}
