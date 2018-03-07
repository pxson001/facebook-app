package com.facebook.messaging.tincan.crypto;

import android.util.JsonReader;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.TincanDebugErrorReporter;
import com.facebook.messaging.tincan.crypto.CryptoSessionImpl.State;
import com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage;
import com.facebook.messaging.tincan.messenger.MessengerIdentityKeyStore;
import com.facebook.messaging.tincan.thrift.RequestPreKeyBundle;
import com.facebook.messaging.tincan.thrift.ThriftFactory;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.InvalidKeyIdException;
import org.whispersystems.libsignal.SessionBuilder;
import org.whispersystems.libsignal.SessionCipher;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.protocol.CiphertextMessage;
import org.whispersystems.libsignal.protocol.PreKeySignalMessage;
import org.whispersystems.libsignal.protocol.SignalMessage;
import org.whispersystems.libsignal.state.IdentityKeyStore;
import org.whispersystems.libsignal.state.PreKeyBundle;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.state.SignedPreKeyRecord;
import org.whispersystems.libsignal.util.KeyHelper;

@UserScoped
/* compiled from: com.facebook.FacebookCallback */
public class CryptoEngine {
    private static final Class<?> f17855a = CryptoEngine.class;
    private static final Object f17856e = new Object();
    private final IdentityKeyStore f17857b;
    private final TincanDebugErrorReporter f17858c;
    private final CryptoSessionFactory f17859d;

    private static CryptoEngine m17850b(InjectorLike injectorLike) {
        return new CryptoEngine(MessengerIdentityKeyStore.m18014a(injectorLike), TincanDebugErrorReporter.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.crypto.CryptoEngine m17846a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f17856e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m17850b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17856e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.crypto.CryptoEngine) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.crypto.CryptoEngine) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f17856e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.crypto.CryptoEngine) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.crypto.CryptoEngine.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.crypto.CryptoEngine");
    }

    @Inject
    public CryptoEngine(IdentityKeyStore identityKeyStore, TincanDebugErrorReporter tincanDebugErrorReporter) {
        this.f17857b = identityKeyStore;
        this.f17858c = tincanDebugErrorReporter;
        this.f17859d = new CryptoSessionFactory(identityKeyStore);
    }

    @Nullable
    public final RequestPreKeyBundle m17854a(String str, MessengerCryptoSessionStorage messengerCryptoSessionStorage) {
        CryptoSession a = this.f17859d.m17859a(str);
        try {
            PreKeyRecord preKeyRecord = (PreKeyRecord) KeyHelper.m22411a(0, 1).get(0);
            SignedPreKeyRecord a2 = KeyHelper.m22413a(this.f17857b.mo702a(), 0);
            a.m17876a(0, preKeyRecord);
            a.m17877a(0, a2);
        } catch (Throwable e) {
            this.f17858c.a(f17855a, "Request payload generation error for new session", e);
        }
        return m17853a(a, messengerCryptoSessionStorage);
    }

    @Nullable
    public final RequestPreKeyBundle m17853a(CryptoSession cryptoSession, MessengerCryptoSessionStorage messengerCryptoSessionStorage) {
        RequestPreKeyBundle a;
        Throwable e;
        cryptoSession = (CryptoSessionImpl) cryptoSession;
        try {
            PreKeyRecord a2 = cryptoSession.mo703a(0);
            SignedPreKeyRecord c = cryptoSession.mo711c(0);
            a = ThriftFactory.m18181a(this.f17857b.mo702a().m21716a().m21715b(), a2.m21906a().m21742a().m21741a(), c.m21949a().m21742a().m21741a(), c.m21950b());
            try {
                cryptoSession.m17879a(State.SENDER_ACCEPT_PENDING);
            } catch (InvalidKeyIdException e2) {
                e = e2;
                this.f17858c.a(f17855a, "Request payload generation error", e);
                cryptoSession.m17879a(State.PRE_KEY_ERROR);
                messengerCryptoSessionStorage.m18007a(cryptoSession);
                return a;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            a = null;
            e = th;
            this.f17858c.a(f17855a, "Request payload generation error", e);
            cryptoSession.m17879a(State.PRE_KEY_ERROR);
            messengerCryptoSessionStorage.m18007a(cryptoSession);
            return a;
        }
        messengerCryptoSessionStorage.m18007a(cryptoSession);
        return a;
    }

    public final void m17855a(String str, RequestPreKeyBundle requestPreKeyBundle, CryptoSessionStorage$MessageMetaData cryptoSessionStorage$MessageMetaData, MessengerCryptoSessionStorage messengerCryptoSessionStorage) {
        CryptoSession a = this.f17859d.m17859a(str);
        new SessionBuilder(a, new SignalProtocolAddress(str, 0)).m21720a(new PreKeyBundle(this.f17857b.mo707b(), 0, 0, Curve.m21736a(requestPreKeyBundle.pre_key, 0), 0, Curve.m21736a(requestPreKeyBundle.signed_pre_key, 0), requestPreKeyBundle.signed_pre_key_signature, new IdentityKey(requestPreKeyBundle.identity_key, 0)));
        a.f17865d = State.RECEIVER_ACCEPT_PENDING;
        messengerCryptoSessionStorage.m18010a(cryptoSessionStorage$MessageMetaData, a);
    }

    @Nullable
    public static byte[] m17849a(CryptoSession cryptoSession, byte[] bArr, MessengerCryptoSessionStorage messengerCryptoSessionStorage) {
        CryptoSession cryptoSession2 = (CryptoSessionImpl) cryptoSession;
        CiphertextMessage a = new SessionCipher(cryptoSession2, new SignalProtocolAddress(cryptoSession.mo710c(), 0)).m21731a(bArr);
        byte[] bArr2 = null;
        if (a instanceof PreKeySignalMessage) {
            bArr2 = a.mo937a();
            cryptoSession2.f17865d = State.RUNNING;
        } else {
            cryptoSession2.f17865d = State.ACCEPT_GEN_ERROR;
        }
        messengerCryptoSessionStorage.m18007a(cryptoSession2);
        return bArr2;
    }

    public static ProcessAcceptPayloadResult m17847a(CryptoSession cryptoSession, String str, byte[] bArr, MessengerCryptoSessionStorage messengerCryptoSessionStorage) {
        CryptoSessionImpl cryptoSessionImpl = (CryptoSessionImpl) cryptoSession;
        String c = cryptoSession.mo710c();
        Object a = new SessionCipher(cryptoSessionImpl, new SignalProtocolAddress(str, 0)).m21732a(new PreKeySignalMessage(bArr));
        Preconditions.checkNotNull(a);
        cryptoSessionImpl.f17865d = State.RUNNING;
        messengerCryptoSessionStorage.m18007a(cryptoSession);
        return new ProcessAcceptPayloadResult(true, a, c, str);
    }

    public static byte[] m17851b(CryptoSession cryptoSession, byte[] bArr, MessengerCryptoSessionStorage messengerCryptoSessionStorage) {
        CryptoSession cryptoSession2 = (CryptoSessionImpl) cryptoSession;
        CiphertextMessage a = new SessionCipher(cryptoSession2, new SignalProtocolAddress(cryptoSession.mo710c(), 0)).m21731a(bArr);
        if (a instanceof PreKeySignalMessage) {
            a = ((PreKeySignalMessage) a).f21275g;
        }
        cryptoSession2.m17889d();
        messengerCryptoSessionStorage.m18007a(cryptoSession2);
        return a.mo937a();
    }

    @Nullable
    public static byte[] m17848a(CryptoSession cryptoSession, CryptoSessionStorage$MessageMetaData cryptoSessionStorage$MessageMetaData, byte[] bArr, MessengerCryptoSessionStorage messengerCryptoSessionStorage) {
        CryptoSessionImpl cryptoSessionImpl = (CryptoSessionImpl) cryptoSession;
        byte[] a = new SessionCipher(cryptoSessionImpl, new SignalProtocolAddress(cryptoSession.mo710c(), 0)).m21733a(new SignalMessage(bArr));
        cryptoSessionImpl.m17889d();
        messengerCryptoSessionStorage.m18008a(cryptoSessionImpl, cryptoSessionStorage$MessageMetaData, a);
        return a;
    }

    public final CryptoSession m17852a(JsonReader jsonReader) {
        return new CryptoSessionImpl(jsonReader, this.f17859d.f17861b);
    }
}
