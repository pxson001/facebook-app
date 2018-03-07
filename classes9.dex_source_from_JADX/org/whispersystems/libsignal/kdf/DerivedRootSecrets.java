package org.whispersystems.libsignal.kdf;

import org.whispersystems.libsignal.util.ByteUtil;

/* compiled from: adInterfacesUploadAdImageParams */
public class DerivedRootSecrets {
    public final byte[] f21267a;
    public final byte[] f21268b;

    public DerivedRootSecrets(byte[] bArr) {
        byte[][] a = ByteUtil.m22407a(bArr, 32, 32);
        this.f21267a = a[0];
        this.f21268b = a[1];
    }
}
