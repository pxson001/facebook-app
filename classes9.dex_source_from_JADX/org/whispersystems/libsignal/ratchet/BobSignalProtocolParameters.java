package org.whispersystems.libsignal.ratchet;

import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.util.guava.Optional;

/* compiled from: action_target_id */
public class BobSignalProtocolParameters {
    private final IdentityKeyPair f21328a;
    private final ECKeyPair f21329b;
    private final Optional<ECKeyPair> f21330c;
    private final ECKeyPair f21331d;
    private final IdentityKey f21332e;
    private final DjbECPublicKey f21333f;

    /* compiled from: action_target_id */
    public class Builder {
        public IdentityKeyPair f21322a;
        public ECKeyPair f21323b;
        public Optional<ECKeyPair> f21324c;
        public ECKeyPair f21325d;
        public IdentityKey f21326e;
        public DjbECPublicKey f21327f;

        public final BobSignalProtocolParameters m21877a() {
            return new BobSignalProtocolParameters(this.f21322a, this.f21323b, this.f21325d, this.f21324c, this.f21326e, this.f21327f);
        }
    }

    BobSignalProtocolParameters(IdentityKeyPair identityKeyPair, ECKeyPair eCKeyPair, ECKeyPair eCKeyPair2, Optional<ECKeyPair> optional, IdentityKey identityKey, ECPublicKey eCPublicKey) {
        this.f21328a = identityKeyPair;
        this.f21329b = eCKeyPair;
        this.f21331d = eCKeyPair2;
        this.f21330c = optional;
        this.f21332e = identityKey;
        this.f21333f = eCPublicKey;
        if (identityKeyPair == null || eCKeyPair == null || eCKeyPair2 == null || optional == null || identityKey == null || eCPublicKey == null) {
            throw new IllegalArgumentException("Null value!");
        }
    }

    public final IdentityKeyPair m21878a() {
        return this.f21328a;
    }

    public final ECKeyPair m21879b() {
        return this.f21329b;
    }

    public final Optional<ECKeyPair> m21880c() {
        return this.f21330c;
    }

    public final IdentityKey m21881d() {
        return this.f21332e;
    }

    public final DjbECPublicKey m21882e() {
        return this.f21333f;
    }

    public final ECKeyPair m21883f() {
        return this.f21331d;
    }
}
