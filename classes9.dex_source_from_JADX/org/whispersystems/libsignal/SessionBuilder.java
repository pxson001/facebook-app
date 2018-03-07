package org.whispersystems.libsignal;

import com.facebook.messaging.tincan.crypto.CryptoSessionImpl;
import java.util.Arrays;
import java.util.Iterator;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.protocol.PreKeySignalMessage;
import org.whispersystems.libsignal.ratchet.AliceSignalProtocolParameters;
import org.whispersystems.libsignal.ratchet.BobSignalProtocolParameters.Builder;
import org.whispersystems.libsignal.ratchet.RatchetingSession;
import org.whispersystems.libsignal.state.IdentityKeyStore;
import org.whispersystems.libsignal.state.PreKeyBundle;
import org.whispersystems.libsignal.state.PreKeyStore;
import org.whispersystems.libsignal.state.SessionRecord;
import org.whispersystems.libsignal.state.SessionState;
import org.whispersystems.libsignal.state.SignedPreKeyStore;
import org.whispersystems.libsignal.util.Medium;
import org.whispersystems.libsignal.util.guava.Absent;
import org.whispersystems.libsignal.util.guava.Optional;

/* compiled from: ad_interfaces_get_direction_preview */
public class SessionBuilder {
    private static final String f21247a = SessionBuilder.class.getSimpleName();
    private final CryptoSessionImpl f21248b;
    public final PreKeyStore f21249c;
    public final SignedPreKeyStore f21250d;
    public final IdentityKeyStore f21251e;
    private final SignalProtocolAddress f21252f;

    public SessionBuilder(CryptoSessionImpl cryptoSessionImpl, PreKeyStore preKeyStore, SignedPreKeyStore signedPreKeyStore, IdentityKeyStore identityKeyStore, SignalProtocolAddress signalProtocolAddress) {
        this.f21248b = cryptoSessionImpl;
        this.f21249c = preKeyStore;
        this.f21250d = signedPreKeyStore;
        this.f21251e = identityKeyStore;
        this.f21252f = signalProtocolAddress;
    }

    public SessionBuilder(CryptoSessionImpl cryptoSessionImpl, SignalProtocolAddress signalProtocolAddress) {
        this(cryptoSessionImpl, cryptoSessionImpl, cryptoSessionImpl, cryptoSessionImpl, signalProtocolAddress);
    }

    final Optional<Integer> m21719a(SessionRecord sessionRecord, PreKeySignalMessage preKeySignalMessage) {
        IdentityKey identityKey = preKeySignalMessage.f21274f;
        if (this.f21251e.mo709b(this.f21252f.f21258a, identityKey)) {
            Object obj;
            Optional optional;
            int i = preKeySignalMessage.f21269a;
            byte[] a = preKeySignalMessage.f21273e.m21741a();
            if (sessionRecord.f21356a.m21936c() == i && Arrays.equals(a, sessionRecord.f21356a.m21935b())) {
                obj = 1;
            } else {
                Iterator it = sessionRecord.f21357b.iterator();
                while (it.hasNext()) {
                    SessionState sessionState = (SessionState) it.next();
                    if (sessionState.m21936c() == i && Arrays.equals(a, sessionState.m21935b())) {
                        int i2 = 1;
                        break;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                optional = Absent.f21482a;
            } else {
                ECKeyPair a2 = this.f21250d.mo711c(preKeySignalMessage.f21272d).m21949a();
                Builder builder = new Builder();
                builder.f21327f = preKeySignalMessage.f21273e;
                Builder builder2 = builder;
                builder2.f21326e = preKeySignalMessage.f21274f;
                builder2 = builder2;
                builder2.f21322a = this.f21251e.mo702a();
                builder2 = builder2;
                builder2.f21323b = a2;
                builder2.f21325d = a2;
                if (preKeySignalMessage.f21271c.mo939a()) {
                    builder.f21324c = Optional.m22417a(this.f21249c.mo703a(((Integer) preKeySignalMessage.f21271c.mo940b()).intValue()).m21906a());
                } else {
                    builder.f21324c = Absent.f21482a;
                }
                if (!sessionRecord.f21358c) {
                    sessionRecord.m21913d();
                }
                RatchetingSession.m21896a(sessionRecord.f21356a, builder.m21877a());
                sessionRecord.f21356a.m21939d(this.f21251e.mo707b());
                sessionRecord.f21356a.m21937c(preKeySignalMessage.f21270b);
                sessionRecord.f21356a.m21927a(preKeySignalMessage.f21273e.m21741a());
                optional = (!preKeySignalMessage.f21271c.mo939a() || ((Integer) preKeySignalMessage.f21271c.mo940b()).intValue() == Medium.f21479a) ? Absent.f21482a : preKeySignalMessage.f21271c;
            }
            Optional optional2 = optional;
            this.f21251e.mo706a(this.f21252f.f21258a, identityKey);
            return optional2;
        }
        throw new UntrustedIdentityException(this.f21252f.f21258a, identityKey);
    }

    public final void m21720a(PreKeyBundle preKeyBundle) {
        synchronized (SessionCipher.f21253a) {
            if (!this.f21251e.mo709b(this.f21252f.m21734a(), preKeyBundle.m21904f())) {
                throw new UntrustedIdentityException(this.f21252f.m21734a(), preKeyBundle.m21904f());
            } else if (preKeyBundle.m21902d() != null && !Curve.m21738a(preKeyBundle.m21904f().m21714a(), preKeyBundle.m21902d().m21741a(), preKeyBundle.m21903e())) {
                throw new InvalidKeyException("Invalid signature on device key!");
            } else if (preKeyBundle.m21902d() == null) {
                throw new InvalidKeyException("No signed prekey!");
            } else {
                SessionRecord a = this.f21248b.m17875a(this.f21252f);
                ECKeyPair a2 = Curve.m21737a();
                DjbECPublicKey d = preKeyBundle.m21902d();
                Optional b = Optional.m22418b(preKeyBundle.m21900b());
                Optional a3 = b.mo939a() ? Optional.m22417a(Integer.valueOf(preKeyBundle.m21899a())) : Optional.m22419c();
                AliceSignalProtocolParameters.Builder newBuilder = AliceSignalProtocolParameters.newBuilder();
                newBuilder.m21867a(a2).m21865a(this.f21251e.mo702a()).m21864a(preKeyBundle.m21904f()).m21870b(d).m21866a(d).m21868a(b);
                if (!a.m21912c()) {
                    a.m21913d();
                }
                RatchetingSession.m21895a(a.m21908a(), newBuilder.m21869a());
                a.m21908a().m21926a(a3, preKeyBundle.m21901c(), a2.m21742a());
                a.m21908a().m21939d(this.f21251e.mo707b());
                a.m21908a().m21937c(preKeyBundle.m21905g());
                a.m21908a().m21927a(a2.m21742a().m21741a());
                this.f21248b.m17882a(this.f21252f, a);
                this.f21251e.mo706a(this.f21252f.m21734a(), preKeyBundle.m21904f());
            }
        }
    }
}
