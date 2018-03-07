package com.facebook.feed.data;

import com.facebook.api.feedtype.FeedType;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.data.freshfeed.FreshFeedDataLoader;
import com.facebook.feed.data.typemanager.PreferredFeedTypeManager;
import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: sgny_size_param */
public class FeedDataLoaderFactory implements IHaveUserData {
    private static final Object f5025f = new Object();
    @VisibleForTesting
    WeakReference<IFeedDataLoader> f5026a = new WeakReference(null);
    private final Provider<FeedDataLoader> f5027b;
    private final Provider<FreshFeedDataLoader> f5028c;
    public final PreferredFeedTypeManager f5029d;
    private final QeAccessor f5030e;

    private static FeedDataLoaderFactory m8946b(InjectorLike injectorLike) {
        return new FeedDataLoaderFactory(PreferredFeedTypeManager.m4198a(injectorLike), IdBasedProvider.m1811a(injectorLike.getApplicationInjector(), 1305), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedProvider.m1811a(injectorLike.getApplicationInjector(), 1316));
    }

    @Inject
    public FeedDataLoaderFactory(PreferredFeedTypeManager preferredFeedTypeManager, @NeedsApplicationInjector Provider<FeedDataLoader> provider, QeAccessor qeAccessor, @NeedsApplicationInjector Provider<FreshFeedDataLoader> provider2) {
        this.f5027b = provider;
        this.f5029d = preferredFeedTypeManager;
        this.f5030e = qeAccessor;
        this.f5028c = provider2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.feed.data.FeedDataLoaderFactory m8944a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.m1499a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.mo191b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.m1454a(r1);
        r4 = r3.m8951b();	 Catch:{ all -> 0x006c }
        r1 = f5025f;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.m8952c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.m1504b(r1);	 Catch:{  }
        r6 = r0.m1455a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.m1474e();	 Catch:{ all -> 0x0062 }
        r1 = m8946b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f5025f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.feed.data.FeedDataLoaderFactory) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.feed.data.FeedDataLoaderFactory) r0;	 Catch:{  }
        r3.m8952c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.m1505c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.m8952c();
        throw r0;
    L_0x0071:
        r0 = f5025f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.feed.data.FeedDataLoaderFactory) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.FeedDataLoaderFactory.a(com.facebook.inject.InjectorLike):com.facebook.feed.data.FeedDataLoaderFactory");
    }

    public final IFeedDataLoader m8949a(FeedType feedType) {
        if (Objects.equal(feedType, this.f5029d.m4200a())) {
            return m8947b(feedType);
        }
        return m8945a(feedType, false);
    }

    private IFeedDataLoader m8947b(FeedType feedType) {
        if (this.f5026a == null || this.f5026a.get() == null || !Objects.equal(feedType, ((IFeedDataLoader) this.f5026a.get()).mo1318l())) {
            this.f5026a = new WeakReference(m8945a(feedType, true));
        }
        return (IFeedDataLoader) this.f5026a.get();
    }

    public final IFeedDataLoader m8948a() {
        return m8949a(this.f5029d.m4200a());
    }

    private IFeedDataLoader m8945a(FeedType feedType, boolean z) {
        IFeedDataLoader iFeedDataLoader;
        if (FeedType.f5039b.equals(feedType) && this.f5030e.mo596a(ExperimentsForNewsFeedAbTestModule.f5083J, false)) {
            iFeedDataLoader = (IFeedDataLoader) this.f5028c.get();
        } else {
            iFeedDataLoader = (IFeedDataLoader) this.f5027b.get();
        }
        iFeedDataLoader.mo1313a(feedType);
        iFeedDataLoader.mo1314a(z);
        return iFeedDataLoader;
    }

    public static FeedDataLoader m8943a(FeedType feedType, Provider<FeedDataLoader> provider) {
        FeedDataLoader feedDataLoader = (FeedDataLoader) provider.get();
        feedDataLoader.mo1313a(feedType);
        feedDataLoader.mo1314a(false);
        return feedDataLoader;
    }

    public void clearUserData() {
        if (this.f5026a != null && this.f5026a.get() != null && this.f5030e.mo596a(ExperimentsForNewsFeedAbTestModule.f5078E, false)) {
            ((IFeedDataLoader) this.f5026a.get()).mo1317j();
        }
    }
}
