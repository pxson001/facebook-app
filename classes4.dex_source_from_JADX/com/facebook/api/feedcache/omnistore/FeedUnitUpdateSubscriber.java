package com.facebook.api.feedcache.omnistore;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.SubscriptionParams.Builder;
import com.facebook.omnistore.module.OmnistoreMethodAutoProvider;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

@UserScoped
/* compiled from: last_sync_full_refresh_ms */
public class FeedUnitUpdateSubscriber implements OmnistoreUpdateSubscriber {
    private static final Object f9542d = new Object();
    private final CollectionName f9543a;
    private final Omnistore f9544b;
    @GuardedBy("this")
    @Nullable
    private Collection f9545c;

    private static FeedUnitUpdateSubscriber m9921b(InjectorLike injectorLike) {
        return new FeedUnitUpdateSubscriber(CollectionName_PrivacyUpdateCollectionMethodAutoProvider.m9926a(injectorLike), OmnistoreMethodAutoProvider.m9936x12664788(injectorLike));
    }

    @Inject
    public FeedUnitUpdateSubscriber(CollectionName collectionName, Omnistore omnistore) {
        this.f9543a = collectionName;
        this.f9544b = omnistore;
    }

    public final void m9923a() {
        m9922c();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.api.feedcache.omnistore.FeedUnitUpdateSubscriber m9920a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9542d;	 Catch:{ all -> 0x006c }
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
        r1 = m9921b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9542d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.omnistore.FeedUnitUpdateSubscriber) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.api.feedcache.omnistore.FeedUnitUpdateSubscriber) r0;	 Catch:{  }
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
        r0 = f9542d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.omnistore.FeedUnitUpdateSubscriber) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.omnistore.FeedUnitUpdateSubscriber.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.omnistore.FeedUnitUpdateSubscriber");
    }

    public final synchronized Collection mo764b() {
        Collection collection;
        if (this.f9545c != null) {
            collection = this.f9545c;
        } else {
            this.f9545c = this.f9544b.subscribeCollection(this.f9543a, new Builder().collectionParams("").idl("namespace com.facebook.api.feedcache.omnistore.flatbuffer;\n\ntable FeedUnit {\n  graphqlid:string;\n  valid:int;\n  likes:int;\n  comments:int;\n}\n\nroot_type FeedUnit;\n").build());
            collection = this.f9545c;
        }
        return collection;
    }

    private synchronized void m9922c() {
        this.f9545c = null;
        this.f9544b.unsubscribeCollection(this.f9543a);
    }
}
