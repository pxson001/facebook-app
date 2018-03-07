package org.whispersystems.libsignal.ecc;

import java.math.BigInteger;
import java.util.Arrays;
import org.whispersystems.libsignal.util.ByteUtil;

/* compiled from: ad_accounts */
public class DjbECPublicKey implements Comparable {
    public final byte[] f21261a;

    public int compareTo(Object obj) {
        return new BigInteger(this.f21261a).compareTo(new BigInteger(((DjbECPublicKey) obj).f21261a));
    }

    DjbECPublicKey(byte[] bArr) {
        this.f21261a = bArr;
    }

    public final byte[] m21741a() {
        byte[] bArr = new byte[]{(byte) 5};
        return ByteUtil.m22406a(bArr, this.f21261a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DjbECPublicKey)) {
            return false;
        }
        return Arrays.equals(this.f21261a, ((DjbECPublicKey) obj).f21261a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f21261a);
    }
}
