package com.facebook.contacts.handlers;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.omnistore.OmnistoreInsertContactHandler;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.contacts.protocol.methods.DeleteContactMethod;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: results_limit */
public class DeleteContactHandler {
    private static final Object f3390h = new Object();
    public final ContactsCache f3391a;
    public final BaseFbBroadcastManager f3392b;
    public final AbstractSingleMethodRunner f3393c;
    public final DeleteContactMethod f3394d;
    public final Provider<ContactsStorageMode> f3395e;
    public final Lazy<DbInsertContactHandler> f3396f;
    public final Lazy<OmnistoreInsertContactHandler> f3397g;

    private static DeleteContactHandler m3620b(InjectorLike injectorLike) {
        return new DeleteContactHandler(ContactsCache.m3455a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new DeleteContactMethod(), IdBasedProvider.a(injectorLike, 939), IdBasedSingletonScopeProvider.b(injectorLike, 924), IdBasedLazy.a(injectorLike, 5357));
    }

    @Inject
    public DeleteContactHandler(ContactsCache contactsCache, FbBroadcastManager fbBroadcastManager, SingleMethodRunner singleMethodRunner, DeleteContactMethod deleteContactMethod, Provider<ContactsStorageMode> provider, Lazy<DbInsertContactHandler> lazy, Lazy<OmnistoreInsertContactHandler> lazy2) {
        this.f3391a = contactsCache;
        this.f3392b = fbBroadcastManager;
        this.f3393c = singleMethodRunner;
        this.f3394d = deleteContactMethod;
        this.f3395e = provider;
        this.f3396f = lazy;
        this.f3397g = lazy2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.handlers.DeleteContactHandler m3619a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3390h;	 Catch:{ all -> 0x006c }
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
        r1 = m3620b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3390h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.handlers.DeleteContactHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.handlers.DeleteContactHandler) r0;	 Catch:{  }
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
        r0 = f3390h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.handlers.DeleteContactHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.handlers.DeleteContactHandler.a(com.facebook.inject.InjectorLike):com.facebook.contacts.handlers.DeleteContactHandler");
    }
}
