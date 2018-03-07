package org.whispersystems.libsignal.kdf;

import java.text.ParseException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.whispersystems.libsignal.util.ByteUtil;

/* compiled from: ad_account_id_extra */
public class DerivedMessageSecrets {
    public final SecretKeySpec f21264a;
    public final SecretKeySpec f21265b;
    public final IvParameterSpec f21266c;

    public DerivedMessageSecrets(byte[] bArr) {
        try {
            byte[][] a = ByteUtil.m22408a(bArr, 32, 32, 16);
            this.f21264a = new SecretKeySpec(a[0], "AES");
            this.f21265b = new SecretKeySpec(a[1], "HmacSHA256");
            this.f21266c = new IvParameterSpec(a[2]);
        } catch (ParseException e) {
            throw new AssertionError(e);
        }
    }
}
