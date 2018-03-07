package org.whispersystems.libsignal;

import com.facebook.messaging.tincan.crypto.CryptoSessionImpl;
import com.google.protobuf.GeneratedMessage.Builder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.protocol.CiphertextMessage;
import org.whispersystems.libsignal.protocol.PreKeySignalMessage;
import org.whispersystems.libsignal.protocol.SignalMessage;
import org.whispersystems.libsignal.ratchet.ChainKey;
import org.whispersystems.libsignal.ratchet.MessageKeys;
import org.whispersystems.libsignal.ratchet.RootKey;
import org.whispersystems.libsignal.state.IdentityKeyStore;
import org.whispersystems.libsignal.state.PreKeyStore;
import org.whispersystems.libsignal.state.SessionRecord;
import org.whispersystems.libsignal.state.SessionState;
import org.whispersystems.libsignal.state.SessionState.UnacknowledgedPreKeyMessageItems;
import org.whispersystems.libsignal.state.SignedPreKeyStore;
import org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey;
import org.whispersystems.libsignal.util.ByteUtil;
import org.whispersystems.libsignal.util.Pair;
import org.whispersystems.libsignal.util.guava.Optional;

/* compiled from: ad_interfaces_flow_id */
public class SessionCipher {
    public static final Object f21253a = new Object();
    private final CryptoSessionImpl f21254b;
    private final SessionBuilder f21255c;
    private final PreKeyStore f21256d;
    private final SignalProtocolAddress f21257e;

    /* compiled from: ad_interfaces_flow_id */
    public class NullDecryptionCallback {
    }

    private static MessageKeys m21724a(SessionState sessionState, DjbECPublicKey djbECPublicKey, ChainKey chainKey, int i) {
        if (chainKey.f21338e > i) {
            if (sessionState.m21929a(djbECPublicKey, i)) {
                return sessionState.m21931b(djbECPublicKey, i);
            }
            throw new DuplicateMessageException("Received message with old counter: " + chainKey.f21338e + " , " + i);
        } else if (i - chainKey.f21338e > 2000) {
            throw new InvalidMessageException("Over 2000 messages into the future!");
        } else {
            while (chainKey.f21338e < i) {
                sessionState.m21922a(djbECPublicKey, chainKey.m21887d());
                chainKey = chainKey.m21886c();
            }
            sessionState.m21934b(djbECPublicKey, chainKey.m21886c());
            return chainKey.m21887d();
        }
    }

    private SessionCipher(CryptoSessionImpl cryptoSessionImpl, PreKeyStore preKeyStore, SignedPreKeyStore signedPreKeyStore, IdentityKeyStore identityKeyStore, SignalProtocolAddress signalProtocolAddress) {
        this.f21254b = cryptoSessionImpl;
        this.f21256d = preKeyStore;
        this.f21257e = signalProtocolAddress;
        this.f21255c = new SessionBuilder(cryptoSessionImpl, preKeyStore, signedPreKeyStore, identityKeyStore, signalProtocolAddress);
    }

    public SessionCipher(CryptoSessionImpl cryptoSessionImpl, SignalProtocolAddress signalProtocolAddress) {
        this(cryptoSessionImpl, cryptoSessionImpl, cryptoSessionImpl, cryptoSessionImpl, signalProtocolAddress);
    }

    public final CiphertextMessage m21731a(byte[] bArr) {
        CiphertextMessage signalMessage;
        synchronized (f21253a) {
            SessionRecord a = this.f21254b.m17875a(this.f21257e);
            SessionState a2 = a.m21908a();
            ChainKey k = a2.m21945k();
            MessageKeys d = k.m21887d();
            DjbECPublicKey h = a2.m21943h();
            int f = a2.m21941f();
            int c = a2.m21936c();
            signalMessage = new SignalMessage(c, d.m21889b(), h, k.m21885b(), f, m21725a(c, d, bArr), a2.m21940e(), a2.m21938d());
            if (a2.m21946l()) {
                UnacknowledgedPreKeyMessageItems m = a2.m21947m();
                signalMessage = new PreKeySignalMessage(c, a2.m21948o(), m.m21915a(), m.m21916b(), m.m21917c(), a2.m21940e(), (SignalMessage) signalMessage);
            }
            a2.m21924a(k.m21886c());
            this.f21254b.m17882a(this.f21257e, a);
        }
        return signalMessage;
    }

    public final byte[] m21732a(PreKeySignalMessage preKeySignalMessage) {
        return m21726a(preKeySignalMessage, new NullDecryptionCallback());
    }

    private byte[] m21729a(SessionState sessionState, SignalMessage signalMessage) {
        if (!sessionState.f21362a.m22357y()) {
            throw new InvalidMessageException("Uninitialized session!");
        } else if (signalMessage.f21277a != sessionState.m21936c()) {
            throw new InvalidMessageException(String.format("Message version %d, but session version %d", new Object[]{Integer.valueOf(signalMessage.f21277a), Integer.valueOf(sessionState.m21936c())}));
        } else {
            int i = signalMessage.f21277a;
            DjbECPublicKey djbECPublicKey = signalMessage.f21278b;
            MessageKeys a = m21724a(sessionState, djbECPublicKey, m21723a(sessionState, djbECPublicKey), signalMessage.f21279c);
            signalMessage.m21757a(i, sessionState.m21938d(), sessionState.m21940e(), a.f21340b);
            byte[] b = m21730b(i, a, signalMessage.f21281e);
            Builder O = sessionState.f21362a.m22342O();
            if (O.f21395n == null) {
                O.f21394m = PendingPreKey.f21436c;
                O.m20312t();
            } else {
                O.f21395n.m21444g();
            }
            O.f21382a &= -257;
            sessionState.f21362a = O.m22116l();
            return b;
        }
    }

    private byte[] m21726a(PreKeySignalMessage preKeySignalMessage, NullDecryptionCallback nullDecryptionCallback) {
        byte[] a;
        synchronized (f21253a) {
            SessionRecord a2 = this.f21254b.m17875a(this.f21257e);
            Optional a3 = this.f21255c.m21719a(a2, preKeySignalMessage);
            a = m21728a(a2, preKeySignalMessage.m21755h());
            this.f21254b.m17882a(this.f21257e, a2);
            if (a3.mo939a()) {
                this.f21256d.mo708b(((Integer) a3.mo940b()).intValue());
            }
        }
        return a;
    }

    public final byte[] m21733a(SignalMessage signalMessage) {
        return m21727a(signalMessage, new NullDecryptionCallback());
    }

    private byte[] m21727a(SignalMessage signalMessage, NullDecryptionCallback nullDecryptionCallback) {
        byte[] a;
        synchronized (f21253a) {
            if (this.f21254b.m17886b(this.f21257e)) {
                SessionRecord a2 = this.f21254b.m17875a(this.f21257e);
                a = m21728a(a2, signalMessage);
                this.f21254b.m17882a(this.f21257e, a2);
            } else {
                throw new NoSessionException("No session for: " + this.f21257e);
            }
        }
        return a;
    }

    private byte[] m21728a(SessionRecord sessionRecord, SignalMessage signalMessage) {
        byte[] a;
        synchronized (f21253a) {
            Iterator it = sessionRecord.m21910b().iterator();
            List linkedList = new LinkedList();
            SessionState sessionState;
            try {
                sessionState = new SessionState(sessionRecord.m21908a());
                a = m21729a(sessionState, signalMessage);
                sessionRecord.m21911b(sessionState);
            } catch (InvalidMessageException e) {
                linkedList.add(e);
                while (it.hasNext()) {
                    try {
                        sessionState = new SessionState((SessionState) it.next());
                        a = m21729a(sessionState, signalMessage);
                        it.remove();
                        sessionRecord.m21909a(sessionState);
                    } catch (InvalidMessageException e2) {
                        linkedList.add(e2);
                    }
                }
                throw new InvalidMessageException("No valid sessions.", linkedList);
            }
        }
        return a;
    }

    private static ChainKey m21723a(SessionState sessionState, DjbECPublicKey djbECPublicKey) {
        try {
            if (sessionState.m21928a(djbECPublicKey)) {
                return sessionState.m21930b(djbECPublicKey);
            }
            Pair a = sessionState.m21942g().m21898a(djbECPublicKey, sessionState.m21944i());
            ECKeyPair a2 = Curve.m21737a();
            Pair a3 = ((RootKey) a.m22415a()).m21898a(djbECPublicKey, a2);
            sessionState.m21925a((RootKey) a3.m22415a());
            sessionState.m21921a(djbECPublicKey, (ChainKey) a.m22416b());
            sessionState.m21932b(Math.max(sessionState.m21945k().m21885b() - 1, 0));
            sessionState.m21923a(a2, (ChainKey) a3.m22416b());
            return (ChainKey) a.m22416b();
        } catch (Throwable e) {
            throw new InvalidMessageException(e);
        }
    }

    private byte[] m21725a(int i, MessageKeys messageKeys, byte[] bArr) {
        Cipher a;
        if (i >= 3) {
            try {
                a = m21722a(1, messageKeys.m21888a(), messageKeys.m21890c());
            } catch (IllegalBlockSizeException e) {
                Object e2 = e;
                throw new AssertionError(e2);
            } catch (BadPaddingException e3) {
                e2 = e3;
                throw new AssertionError(e2);
            }
        }
        a = m21721a(1, messageKeys.m21888a(), messageKeys.m21891d());
        return a.doFinal(bArr);
    }

    private byte[] m21730b(int i, MessageKeys messageKeys, byte[] bArr) {
        Cipher a;
        if (i >= 3) {
            try {
                a = m21722a(2, messageKeys.m21888a(), messageKeys.m21890c());
            } catch (IllegalBlockSizeException e) {
                Throwable e2 = e;
                throw new InvalidMessageException(e2);
            } catch (BadPaddingException e3) {
                e2 = e3;
                throw new InvalidMessageException(e2);
            }
        }
        a = m21721a(2, messageKeys.m21888a(), messageKeys.m21891d());
        return a.doFinal(bArr);
    }

    private static Cipher m21721a(int i, SecretKeySpec secretKeySpec, int i2) {
        Object e;
        try {
            Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
            byte[] bArr = new byte[16];
            ByteUtil.m22409b(bArr, 0, i2);
            instance.init(i, secretKeySpec, new IvParameterSpec(bArr));
            return instance;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (NoSuchPaddingException e3) {
            e = e3;
            throw new AssertionError(e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new AssertionError(e);
        } catch (InvalidAlgorithmParameterException e5) {
            e = e5;
            throw new AssertionError(e);
        }
    }

    private static Cipher m21722a(int i, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec) {
        Object e;
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(i, secretKeySpec, ivParameterSpec);
            return instance;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (NoSuchPaddingException e3) {
            e = e3;
            throw new AssertionError(e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new AssertionError(e);
        } catch (InvalidAlgorithmParameterException e5) {
            e = e5;
            throw new AssertionError(e);
        }
    }
}
