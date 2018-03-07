package org.whispersystems.libsignal.ecc;

/* compiled from: ad_account_set_currency_timezone */
public class ECKeyPair {
    public final DjbECPublicKey f21262a;
    public final DjbECPrivateKey f21263b;

    public ECKeyPair(DjbECPublicKey djbECPublicKey, DjbECPrivateKey djbECPrivateKey) {
        this.f21262a = djbECPublicKey;
        this.f21263b = djbECPrivateKey;
    }

    public final DjbECPublicKey m21742a() {
        return this.f21262a;
    }

    public final DjbECPrivateKey m21743b() {
        return this.f21263b;
    }
}
