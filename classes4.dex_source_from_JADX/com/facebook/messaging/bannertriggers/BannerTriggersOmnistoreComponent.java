package com.facebook.messaging.bannertriggers;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Collection.SortDirection;
import com.facebook.omnistore.Cursor;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.Delta.Type;
import com.facebook.omnistore.IndexedFields;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.module.OmnistoreComponent;
import com.facebook.omnistore.module.OmnistoreComponent$SubscriptionInfo;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: language_switcher_login_locale_clicked */
public class BannerTriggersOmnistoreComponent implements OmnistoreComponent {
    private static final Class<?> f9645a = BannerTriggersOmnistoreComponent.class;
    private static final Object f9646h = new Object();
    private final Provider<String> f9647b;
    private final Provider<Boolean> f9648c;
    private final DefaultAndroidThreadUtil f9649d;
    private final BannerTriggersCache f9650e;
    @Nullable
    public volatile Listener f9651f;
    @Nullable
    public volatile Listener f9652g;

    private static BannerTriggersOmnistoreComponent m10083b(InjectorLike injectorLike) {
        return new BannerTriggersOmnistoreComponent(IdBasedProvider.a(injectorLike, 4443), IdBasedProvider.a(injectorLike, 4109), DefaultAndroidThreadUtil.b(injectorLike), BannerTriggersCache.m10086a(injectorLike));
    }

    @Inject
    public BannerTriggersOmnistoreComponent(Provider<String> provider, Provider<Boolean> provider2, AndroidThreadUtil androidThreadUtil, BannerTriggersCache bannerTriggersCache) {
        this.f9647b = provider;
        this.f9648c = provider2;
        this.f9649d = androidThreadUtil;
        this.f9650e = bannerTriggersCache;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent m10082a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9646h;	 Catch:{ all -> 0x006c }
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
        r1 = m10083b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9646h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent) r0;	 Catch:{  }
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
        r0 = f9646h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent.a(com.facebook.inject.InjectorLike):com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent");
    }

    public final void m10084a(Listener listener) {
        this.f9649d.a();
        this.f9651f = listener;
    }

    public final void m10085b(Listener listener) {
        this.f9649d.a();
        this.f9652g = listener;
    }

    public OmnistoreComponent$SubscriptionInfo provideSubscriptionInfo(Omnistore omnistore) {
        if (((Boolean) this.f9648c.get()).booleanValue()) {
            return OmnistoreComponent$SubscriptionInfo.forOpenSubscription(omnistore.createCollectionNameBuilder("messenger_bannertriggers").addSegment((String) this.f9647b.get()).build());
        }
        return OmnistoreComponent$SubscriptionInfo.IGNORED_INFO;
    }

    public void onCollectionAvailable(Collection collection) {
        Cursor query = collection.query("", -1, SortDirection.ASCENDING);
        while (query.step()) {
            this.f9650e.m10090a(query.getPrimaryKey(), Long.valueOf(Long.parseLong(query.getSortKey())));
        }
    }

    public void onDeltasReceived(List<Delta> list) {
        for (Delta delta : list) {
            if (delta.mType != Type.DELETE) {
                this.f9650e.m10090a(delta.mPrimaryKey, Long.valueOf(Long.parseLong(delta.mSortKey)));
                if (this.f9651f != null || this.f9652g != null) {
                    this.f9649d.a(new 1(this));
                }
            }
        }
    }

    public IndexedFields indexObject(String str, String str2, ByteBuffer byteBuffer) {
        return new IndexedFields();
    }

    public void onCollectionInvalidated() {
        this.f9650e.m10089a();
    }
}
