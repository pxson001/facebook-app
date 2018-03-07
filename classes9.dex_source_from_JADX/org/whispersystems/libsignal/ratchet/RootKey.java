package org.whispersystems.libsignal.ratchet;

import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.kdf.DerivedRootSecrets;
import org.whispersystems.libsignal.kdf.HKDF;
import org.whispersystems.libsignal.util.Pair;

/* compiled from: action_result */
public class RootKey {
    private final HKDF f21345a;
    public final byte[] f21346b;

    public RootKey(HKDF hkdf, byte[] bArr) {
        this.f21345a = hkdf;
        this.f21346b = bArr;
    }

    public final Pair<RootKey, ChainKey> m21898a(ECPublicKey eCPublicKey, ECKeyPair eCKeyPair) {
        DerivedRootSecrets derivedRootSecrets = new DerivedRootSecrets(this.f21345a.m21749a(Curve.m21740a((DjbECPublicKey) eCPublicKey, eCKeyPair.f21263b), this.f21346b, "WhisperRatchet".getBytes(), 64));
        return new Pair(new RootKey(this.f21345a, derivedRootSecrets.f21267a), new ChainKey(this.f21345a, derivedRootSecrets.f21268b, 0));
    }
}
