package org.whispersystems.libsignal.ratchet;

import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.util.guava.Optional;

/* compiled from: actions_remaining */
public class AliceSignalProtocolParameters {
    private final IdentityKeyPair f21316a;
    private final ECKeyPair f21317b;
    private final IdentityKey f21318c;
    private final DjbECPublicKey f21319d;
    private final Optional<ECPublicKey> f21320e;
    private final DjbECPublicKey f21321f;

    /* compiled from: actions_remaining */
    public class Builder {
        private IdentityKeyPair f21310a;
        private ECKeyPair f21311b;
        private IdentityKey f21312c;
        private DjbECPublicKey f21313d;
        private DjbECPublicKey f21314e;
        private Optional<ECPublicKey> f21315f;

        public final Builder m21865a(IdentityKeyPair identityKeyPair) {
            this.f21310a = identityKeyPair;
            return this;
        }

        public final Builder m21867a(ECKeyPair eCKeyPair) {
            this.f21311b = eCKeyPair;
            return this;
        }

        public final Builder m21866a(DjbECPublicKey djbECPublicKey) {
            this.f21314e = djbECPublicKey;
            return this;
        }

        public final Builder m21864a(IdentityKey identityKey) {
            this.f21312c = identityKey;
            return this;
        }

        public final Builder m21870b(DjbECPublicKey djbECPublicKey) {
            this.f21313d = djbECPublicKey;
            return this;
        }

        public final Builder m21868a(Optional<ECPublicKey> optional) {
            this.f21315f = optional;
            return this;
        }

        public final AliceSignalProtocolParameters m21869a() {
            return new AliceSignalProtocolParameters(this.f21310a, this.f21311b, this.f21312c, this.f21313d, this.f21314e, this.f21315f);
        }
    }

    private AliceSignalProtocolParameters(IdentityKeyPair identityKeyPair, ECKeyPair eCKeyPair, IdentityKey identityKey, ECPublicKey eCPublicKey, ECPublicKey eCPublicKey2, Optional<ECPublicKey> optional) {
        this.f21316a = identityKeyPair;
        this.f21317b = eCKeyPair;
        this.f21318c = identityKey;
        this.f21319d = eCPublicKey;
        this.f21321f = eCPublicKey2;
        this.f21320e = optional;
        if (identityKeyPair == null || eCKeyPair == null || identityKey == null || eCPublicKey == null || eCPublicKey2 == null || optional == null) {
            throw new IllegalArgumentException("Null values!");
        }
    }

    public final IdentityKeyPair m21871a() {
        return this.f21316a;
    }

    public final ECKeyPair m21872b() {
        return this.f21317b;
    }

    public final IdentityKey m21873c() {
        return this.f21318c;
    }

    public final DjbECPublicKey m21874d() {
        return this.f21319d;
    }

    public final Optional<ECPublicKey> m21875e() {
        return this.f21320e;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final DjbECPublicKey m21876f() {
        return this.f21321f;
    }
}
