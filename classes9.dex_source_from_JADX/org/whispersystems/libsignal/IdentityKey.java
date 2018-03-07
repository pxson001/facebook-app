package org.whispersystems.libsignal;

import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;

/* compiled from: addMontageViewer */
public class IdentityKey {
    public final DjbECPublicKey f21244a;

    public IdentityKey(DjbECPublicKey djbECPublicKey) {
        this.f21244a = djbECPublicKey;
    }

    public IdentityKey(byte[] bArr, int i) {
        this.f21244a = Curve.m21736a(bArr, i);
    }

    public final DjbECPublicKey m21714a() {
        return this.f21244a;
    }

    public final byte[] m21715b() {
        return this.f21244a.m21741a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof IdentityKey)) {
            return this.f21244a.equals(((IdentityKey) obj).f21244a);
        }
        return false;
    }

    public int hashCode() {
        return this.f21244a.hashCode();
    }
}
