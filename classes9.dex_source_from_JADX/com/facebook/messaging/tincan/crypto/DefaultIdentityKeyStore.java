package com.facebook.messaging.tincan.crypto;

import android.util.Base64;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.prefs.TincanPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.state.IdentityKeyStore;
import org.whispersystems.libsignal.util.KeyHelper;

@UserScoped
/* compiled from: close_session_out_of_sync */
public class DefaultIdentityKeyStore implements IdentityKeyStore {
    public static final PrefKey f17879a = ((PrefKey) TincanPrefKeys.f18076a.a("identity_key"));
    private static final Class<?> f17880b = DefaultIdentityKeyStore.class;
    private static final Object f17881f = new Object();
    private final FbSharedPreferences f17882c;
    private final Map<String, IdentityKey> f17883d = new HashMap();
    private IdentityKeyPair f17884e = null;

    private static DefaultIdentityKeyStore m17891b(InjectorLike injectorLike) {
        return new DefaultIdentityKeyStore((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public DefaultIdentityKeyStore(FbSharedPreferences fbSharedPreferences) {
        this.f17882c = fbSharedPreferences;
    }

    public final IdentityKeyPair mo702a() {
        if (this.f17884e == null) {
            String a = this.f17882c.a(f17879a, null);
            if (a != null) {
                try {
                    this.f17884e = new IdentityKeyPair(Base64.decode(a, 0));
                } catch (Throwable e) {
                    BLog.b(f17880b, "Couldn't retrieve local identity key pair", e);
                }
            }
            if (this.f17884e == null) {
                this.f17884e = KeyHelper.m22412a();
                this.f17882c.edit().a(f17879a, Base64.encodeToString(this.f17884e.m21718c(), 0)).commit();
            }
        }
        return this.f17884e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.crypto.DefaultIdentityKeyStore m17890a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f17881f;	 Catch:{ all -> 0x006c }
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
        r1 = m17891b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17881f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.crypto.DefaultIdentityKeyStore) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.crypto.DefaultIdentityKeyStore) r0;	 Catch:{  }
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
        r0 = f17881f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.crypto.DefaultIdentityKeyStore) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.crypto.DefaultIdentityKeyStore.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.crypto.DefaultIdentityKeyStore");
    }

    public final int mo707b() {
        return 0;
    }

    public final void mo706a(String str, IdentityKey identityKey) {
        this.f17883d.put(str, identityKey);
    }

    public final boolean mo709b(String str, IdentityKey identityKey) {
        if (this.f17883d.containsKey(str)) {
            return identityKey.equals(this.f17883d.get(str));
        }
        return true;
    }
}
