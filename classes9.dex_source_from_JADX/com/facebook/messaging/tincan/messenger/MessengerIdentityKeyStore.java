package com.facebook.messaging.tincan.messenger;

import android.util.Base64;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.FutureUtils;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.database.DbFetchTincanIdentityKeys;
import com.facebook.messaging.tincan.database.DbTincanPropertyKey;
import com.facebook.messaging.tincan.database.DbTincanPropertyUtil;
import com.facebook.messaging.tincan.database.DbWriteTincanHandler;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Arrays;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.state.IdentityKeyStore;
import org.whispersystems.libsignal.util.KeyHelper;

@UserScoped
/* compiled from: click_update_in_payment_error_dialog */
public class MessengerIdentityKeyStore implements IdentityKeyStore {
    public static final Class<?> f18024a = MessengerIdentityKeyStore.class;
    public static final DbTincanPropertyKey f18025b = new DbTincanPropertyKey("local_identity_key");
    private static final DbTincanPropertyKey f18026c = new DbTincanPropertyKey("local_registration_id");
    private static final Object f18027k = new Object();
    public final DbTincanPropertyUtil f18028d;
    private final DbWriteTincanHandler f18029e;
    private final DbFetchTincanIdentityKeys f18030f;
    private final ListeningExecutorService f18031g;
    private IdentityKeyPair f18032h;
    private boolean f18033i;
    private int f18034j;

    /* compiled from: click_update_in_payment_error_dialog */
    class C21111 implements Callable<IdentityKeyPair> {
        final /* synthetic */ MessengerIdentityKeyStore f18023a;

        C21111(MessengerIdentityKeyStore messengerIdentityKeyStore) {
            this.f18023a = messengerIdentityKeyStore;
        }

        public Object call() {
            Object identityKeyPair;
            String a = this.f18023a.f18028d.m17914a(MessengerIdentityKeyStore.f18025b);
            if (a != null) {
                try {
                    identityKeyPair = new IdentityKeyPair(Base64.decode(a, 0));
                } catch (Throwable e) {
                    BLog.b(MessengerIdentityKeyStore.f18024a, "Couldn't retrieve local identity key pair, generating new one", e);
                }
                if (identityKeyPair == null) {
                    return identityKeyPair;
                }
                IdentityKeyPair a2 = KeyHelper.m22412a();
                this.f18023a.f18028d.m17915a(MessengerIdentityKeyStore.f18025b, Base64.encodeToString(a2.m21718c(), 0));
                return a2;
            }
            identityKeyPair = null;
            if (identityKeyPair == null) {
                return identityKeyPair;
            }
            IdentityKeyPair a22 = KeyHelper.m22412a();
            this.f18023a.f18028d.m17915a(MessengerIdentityKeyStore.f18025b, Base64.encodeToString(a22.m21718c(), 0));
            return a22;
        }
    }

    private static MessengerIdentityKeyStore m18015b(InjectorLike injectorLike) {
        return new MessengerIdentityKeyStore(new DbTincanPropertyUtil(IdBasedProvider.a(injectorLike, 8567)), DbWriteTincanHandler.a(injectorLike), DbFetchTincanIdentityKeys.m17907a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.messenger.MessengerIdentityKeyStore m18014a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f18027k;	 Catch:{ all -> 0x006c }
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
        r1 = m18015b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f18027k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.MessengerIdentityKeyStore) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.messenger.MessengerIdentityKeyStore) r0;	 Catch:{  }
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
        r0 = f18027k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.MessengerIdentityKeyStore) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.MessengerIdentityKeyStore.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.MessengerIdentityKeyStore");
    }

    @Inject
    public MessengerIdentityKeyStore(DbTincanPropertyUtil dbTincanPropertyUtil, DbWriteTincanHandler dbWriteTincanHandler, DbFetchTincanIdentityKeys dbFetchTincanIdentityKeys, ListeningExecutorService listeningExecutorService) {
        this.f18028d = dbTincanPropertyUtil;
        this.f18029e = dbWriteTincanHandler;
        this.f18030f = dbFetchTincanIdentityKeys;
        this.f18031g = listeningExecutorService;
    }

    public final synchronized IdentityKeyPair mo702a() {
        IdentityKeyPair identityKeyPair;
        if (this.f18032h != null) {
            identityKeyPair = this.f18032h;
        } else {
            this.f18032h = (IdentityKeyPair) FutureUtils.a(this.f18031g.a(new C21111(this)));
            if (this.f18032h == null) {
                BLog.b(f18024a, "Could not retrieve nor generate local identity key pair. See above in log...");
            }
            identityKeyPair = this.f18032h;
        }
        return identityKeyPair;
    }

    public final int mo707b() {
        if (this.f18033i) {
            return this.f18034j;
        }
        String a = this.f18028d.m17914a(f18026c);
        if (a != null) {
            this.f18034j = Integer.parseInt(a);
        } else {
            this.f18034j = KeyHelper.m22410a(false);
            this.f18028d.m17915a(f18026c, Integer.toString(this.f18034j));
        }
        this.f18033i = true;
        return this.f18034j;
    }

    public final void mo706a(String str, IdentityKey identityKey) {
        this.f18029e.a(str, identityKey.m21715b());
    }

    public final boolean mo709b(String str, IdentityKey identityKey) {
        byte[] a = this.f18030f.m17909a(str);
        if (a == null) {
            return true;
        }
        return Arrays.equals(a, identityKey.m21715b());
    }
}
