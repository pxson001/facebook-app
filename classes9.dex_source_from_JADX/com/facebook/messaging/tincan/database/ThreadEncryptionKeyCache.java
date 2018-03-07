package com.facebook.messaging.tincan.database;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@UserScoped
/* compiled from: client_specified_extra_data */
public class ThreadEncryptionKeyCache {
    private static final Object f17909d = new Object();
    private final Map<ThreadKey, byte[]> f17910a = new HashMap();
    private final TincanDbThreadsFetcher f17911b;
    private final DbCrypto f17912c;

    private static ThreadEncryptionKeyCache m17922b(InjectorLike injectorLike) {
        return new ThreadEncryptionKeyCache(TincanDbThreadsFetcher.a(injectorLike), DbCrypto.a(injectorLike));
    }

    @Inject
    public ThreadEncryptionKeyCache(TincanDbThreadsFetcher tincanDbThreadsFetcher, DbCrypto dbCrypto) {
        this.f17911b = tincanDbThreadsFetcher;
        this.f17912c = dbCrypto;
    }

    public final void m17923a(ThreadKey threadKey, byte[] bArr) {
        this.f17910a.put(threadKey, bArr);
    }

    public final byte[] m17924a(ThreadKey threadKey) {
        Throwable e;
        if (this.f17910a.containsKey(threadKey)) {
            return (byte[]) this.f17910a.get(threadKey);
        }
        byte[] a = this.f17911b.a(threadKey);
        if (a == null) {
            return a;
        }
        try {
            a = this.f17912c.b(a);
            this.f17910a.put(threadKey, a);
            return a;
        } catch (KeyChainException e2) {
            e = e2;
            throw new RuntimeException("Failed to decrypt thread key", e);
        } catch (CryptoInitializationException e3) {
            e = e3;
            throw new RuntimeException("Failed to decrypt thread key", e);
        } catch (IOException e4) {
            e = e4;
            throw new RuntimeException("Failed to decrypt thread key", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.database.ThreadEncryptionKeyCache m17921a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f17909d;	 Catch:{ all -> 0x006c }
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
        r1 = m17922b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17909d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.database.ThreadEncryptionKeyCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.database.ThreadEncryptionKeyCache) r0;	 Catch:{  }
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
        r0 = f17909d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.database.ThreadEncryptionKeyCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.database.ThreadEncryptionKeyCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.database.ThreadEncryptionKeyCache");
    }
}
