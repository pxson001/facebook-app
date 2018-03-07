package org.whispersystems.libsignal.state;

import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;

/* compiled from: action_link_if_moments_installed */
public class PreKeyBundle {
    private int f21347a;
    private int f21348b;
    private int f21349c;
    private DjbECPublicKey f21350d;
    private int f21351e;
    private DjbECPublicKey f21352f;
    private byte[] f21353g;
    private IdentityKey f21354h;

    public PreKeyBundle(int i, int i2, int i3, DjbECPublicKey djbECPublicKey, int i4, DjbECPublicKey djbECPublicKey2, byte[] bArr, IdentityKey identityKey) {
        this.f21347a = i;
        this.f21348b = i2;
        this.f21349c = i3;
        this.f21350d = djbECPublicKey;
        this.f21351e = i4;
        this.f21352f = djbECPublicKey2;
        this.f21353g = bArr;
        this.f21354h = identityKey;
    }

    public final int m21899a() {
        return this.f21349c;
    }

    public final DjbECPublicKey m21900b() {
        return this.f21350d;
    }

    public final int m21901c() {
        return this.f21351e;
    }

    public final DjbECPublicKey m21902d() {
        return this.f21352f;
    }

    public final byte[] m21903e() {
        return this.f21353g;
    }

    public final IdentityKey m21904f() {
        return this.f21354h;
    }

    public final int m21905g() {
        return this.f21347a;
    }
}
