package com.facebook.payments.shipping.protocol;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.model.User;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ForwardingLoadingCache;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: backstage_camera_capture */
public class MailingAddressCache extends ForwardingLoadingCache<String, ImmutableList<MailingAddress>> {
    private static final Object f19049e = new Object();
    private final DefaultAndroidThreadUtil f19050a;
    private final LoadingCache<String, ImmutableList<MailingAddress>> f19051b;
    public final ListeningExecutorService f19052c;
    public final Provider<User> f19053d;

    /* compiled from: backstage_camera_capture */
    public class C22462 implements Callable<ImmutableList<MailingAddress>> {
        final /* synthetic */ String f19047a;
        final /* synthetic */ MailingAddressCache f19048b;

        public C22462(MailingAddressCache mailingAddressCache, String str) {
            this.f19048b = mailingAddressCache;
            this.f19047a = str;
        }

        public Object call() {
            return this.f19048b.m19014a(this.f19047a);
        }
    }

    private static MailingAddressCache m19013b(InjectorLike injectorLike) {
        return new MailingAddressCache(MailingAddressProtocolUtil.m19019b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    public final /* synthetic */ Object m19015c(Object obj) {
        return m19014a((String) obj);
    }

    protected final /* synthetic */ Cache m19016d() {
        return m19018f();
    }

    protected final /* synthetic */ Object m19017e() {
        return m19018f();
    }

    @Inject
    public MailingAddressCache(final MailingAddressProtocolUtil mailingAddressProtocolUtil, AndroidThreadUtil androidThreadUtil, ListeningExecutorService listeningExecutorService, Provider<User> provider) {
        this.f19050a = androidThreadUtil;
        this.f19052c = listeningExecutorService;
        this.f19053d = provider;
        this.f19051b = CacheBuilder.newBuilder().a(10, TimeUnit.MINUTES).a(new CacheLoader<String, ImmutableList<MailingAddress>>(this) {
            final /* synthetic */ MailingAddressCache f19046b;

            public final Object m19011a(Object obj) {
                return (ImmutableList) FutureDetour.a(mailingAddressProtocolUtil.m19020a(), 943328959);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.payments.shipping.protocol.MailingAddressCache m19012a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f19049e;	 Catch:{ all -> 0x006c }
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
        r1 = m19013b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f19049e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.payments.shipping.protocol.MailingAddressCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.payments.shipping.protocol.MailingAddressCache) r0;	 Catch:{  }
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
        r0 = f19049e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.payments.shipping.protocol.MailingAddressCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.payments.shipping.protocol.MailingAddressCache.a(com.facebook.inject.InjectorLike):com.facebook.payments.shipping.protocol.MailingAddressCache");
    }

    protected final LoadingCache<String, ImmutableList<MailingAddress>> m19018f() {
        return this.f19051b;
    }

    public final ImmutableList<MailingAddress> m19014a(String str) {
        this.f19050a.b();
        return (ImmutableList) super.c(str);
    }
}
