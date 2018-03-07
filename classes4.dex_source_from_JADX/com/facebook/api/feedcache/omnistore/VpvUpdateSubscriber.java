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
/* compiled from: keyword_only */
public class VpvUpdateSubscriber implements OmnistoreUpdateSubscriber {
    private static final Object f9681d = new Object();
    private final CollectionName f9682a;
    private final Omnistore f9683b;
    @GuardedBy("this")
    @Nullable
    private Collection f9684c;

    private static VpvUpdateSubscriber m10108b(InjectorLike injectorLike) {
        return new VpvUpdateSubscriber(CollectionName_VpvUpdateCollectionMethodAutoProvider.m10112a(injectorLike), OmnistoreMethodAutoProvider.m9936x12664788(injectorLike));
    }

    @Inject
    public VpvUpdateSubscriber(CollectionName collectionName, Omnistore omnistore) {
        this.f9682a = collectionName;
        this.f9683b = omnistore;
    }

    public final void m10110a() {
        m10109c();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.api.feedcache.omnistore.VpvUpdateSubscriber m10107a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9681d;	 Catch:{ all -> 0x006c }
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
        r1 = m10108b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9681d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.omnistore.VpvUpdateSubscriber) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.api.feedcache.omnistore.VpvUpdateSubscriber) r0;	 Catch:{  }
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
        r0 = f9681d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.api.feedcache.omnistore.VpvUpdateSubscriber) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.omnistore.VpvUpdateSubscriber.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.omnistore.VpvUpdateSubscriber");
    }

    public final synchronized Collection mo764b() {
        Collection collection;
        if (this.f9684c != null) {
            collection = this.f9684c;
        } else {
            this.f9684c = this.f9683b.subscribeCollection(this.f9682a, new Builder().collectionParams("").idl("namespace com.facebook.api.feedcache.omnistore.flatbuffer;\n\ntable VpvUnit {\n  trackingcode:string;\n  seen:int;\n}\n\nroot_type VpvUnit;\n").build());
            collection = this.f9684c;
        }
        return collection;
    }

    private synchronized void m10109c() {
        this.f9684c = null;
        this.f9683b.unsubscribeCollection(this.f9682a);
    }
}
