package com.facebook.messaging.tincan.messenger;

import android.util.JsonReader;
import android.util.JsonWriter;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.tincan.crypto.CryptoEngine;
import com.facebook.messaging.tincan.crypto.CryptoSession;
import com.facebook.messaging.tincan.crypto.CryptoSessionStorage$MessageMetaData;
import com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler;
import com.facebook.messaging.tincan.database.DbWriteTincanHandler;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: clicks */
public class MessengerCryptoSessionStorage {
    private static final Class<?> f18014a = MessengerCryptoSessionStorage.class;
    private static final Object f18015f = new Object();
    private final DbFetchTincanCryptoHandler f18016b;
    public final DbWriteTincanHandler f18017c;
    private final Provider<CryptoEngine> f18018d;
    public final TincanHelper f18019e;

    private static MessengerCryptoSessionStorage m18004b(InjectorLike injectorLike) {
        return new MessengerCryptoSessionStorage(DbFetchTincanCryptoHandler.m17899a(injectorLike), DbWriteTincanHandler.a(injectorLike), IdBasedProvider.a(injectorLike, 8558), TincanHelper.b(injectorLike));
    }

    @Inject
    public MessengerCryptoSessionStorage(DbFetchTincanCryptoHandler dbFetchTincanCryptoHandler, DbWriteTincanHandler dbWriteTincanHandler, Provider<CryptoEngine> provider, TincanHelper tincanHelper) {
        this.f18016b = dbFetchTincanCryptoHandler;
        this.f18017c = dbWriteTincanHandler;
        this.f18018d = provider;
        this.f18019e = tincanHelper;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage m18003a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f18015f;	 Catch:{ all -> 0x006c }
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
        r1 = m18004b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f18015f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage) r0;	 Catch:{  }
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
        r0 = f18015f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage");
    }

    @Nullable
    public final CryptoSession m18006a(String str) {
        String a = this.f18016b.m17904a(this.f18019e.a(str));
        if (a == null) {
            BLog.b(f18014a, "No crypto state retrieved for session %s", new Object[]{str});
            return null;
        }
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(a));
            CryptoSession a2 = ((CryptoEngine) this.f18018d.get()).m17852a(jsonReader);
            jsonReader.close();
            return a2;
        } catch (Throwable e) {
            BLog.b(f18014a, e.getMessage(), e);
            return null;
        }
    }

    public final void m18007a(CryptoSession cryptoSession) {
        try {
            this.f18017c.a(this.f18019e.a(cryptoSession.mo710c()), m18005b(cryptoSession));
        } catch (Throwable e) {
            BLog.b(f18014a, e.getMessage(), e);
        }
    }

    public final void m18010a(CryptoSessionStorage$MessageMetaData cryptoSessionStorage$MessageMetaData, CryptoSession cryptoSession) {
        try {
            this.f18017c.a(this.f18019e.a(cryptoSession.mo710c()), m18005b(cryptoSession), cryptoSessionStorage$MessageMetaData.f17878f);
        } catch (Throwable e) {
            BLog.b(f18014a, e.getMessage(), e);
        }
    }

    public final void m18009a(CryptoSession cryptoSession, String str) {
        ThreadKey a = this.f18019e.a(cryptoSession.mo710c());
        ThreadKey a2 = this.f18019e.a(str);
        Preconditions.checkState(ThreadKey.h(a));
        cryptoSession.mo705a(str);
        try {
            this.f18017c.a(a, a2, m18005b(cryptoSession));
        } catch (Throwable e) {
            BLog.b(f18014a, e.getMessage(), e);
        }
    }

    public final void m18008a(CryptoSession cryptoSession, CryptoSessionStorage$MessageMetaData cryptoSessionStorage$MessageMetaData, byte[] bArr) {
        long j = cryptoSessionStorage$MessageMetaData.f17877e;
        ThreadKey a = this.f18019e.a(cryptoSession.mo710c());
        String str = cryptoSessionStorage$MessageMetaData.f17878f;
        ParticipantInfo participantInfo = new ParticipantInfo(new UserKey(Type.FACEBOOK, Long.toString(cryptoSessionStorage$MessageMetaData.f17873a)), null);
        MessageBuilder newBuilder = Message.newBuilder();
        newBuilder.a(str);
        newBuilder.d(str);
        newBuilder.a(a);
        newBuilder.a(j / 1000);
        newBuilder.a(participantInfo);
        try {
            this.f18017c.a(newBuilder.R(), bArr, m18005b(cryptoSession));
        } catch (Throwable e) {
            BLog.b(f18014a, e.getMessage(), e);
        }
    }

    public final void m18011c(String str) {
        this.f18017c.a(this.f18019e.a(str), "");
    }

    private static String m18005b(CryptoSession cryptoSession) {
        Writer stringWriter = new StringWriter();
        cryptoSession.mo704a(new JsonWriter(stringWriter));
        return stringWriter.toString();
    }
}
