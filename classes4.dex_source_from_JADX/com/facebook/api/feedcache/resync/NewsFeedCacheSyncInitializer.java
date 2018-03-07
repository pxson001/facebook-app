package com.facebook.api.feedcache.resync;

import android.content.Context;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.api.feedcache.omnistore.annotations.IsOmnistorePrivacyUpdateEnable;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mounted_ro */
public class NewsFeedCacheSyncInitializer implements IHaveUserData, INeedInit {
    private final NewsFeedCacheSyncScheduler f7510a;
    private final QeAccessor f7511b;
    private final AsyncFeedXConfigReader f7512c;
    private final Context f7513d;
    @IsOmnistorePrivacyUpdateEnable
    private final Provider<Boolean> f7514e;

    public static NewsFeedCacheSyncInitializer m7809b(InjectorLike injectorLike) {
        return new NewsFeedCacheSyncInitializer(NewsFeedCacheSyncScheduler.m7810a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), AsyncFeedXConfigReader.a(injectorLike), IdBasedProvider.a(injectorLike, 3894));
    }

    @Inject
    public NewsFeedCacheSyncInitializer(NewsFeedCacheSyncScheduler newsFeedCacheSyncScheduler, QeAccessor qeAccessor, Context context, AsyncFeedXConfigReader asyncFeedXConfigReader, Provider<Boolean> provider) {
        this.f7510a = newsFeedCacheSyncScheduler;
        this.f7511b = qeAccessor;
        this.f7513d = context;
        this.f7512c = asyncFeedXConfigReader;
        this.f7514e = provider;
    }

    public void init() {
        this.f7510a.m7815b();
        if (!((Boolean) this.f7514e.get()).booleanValue()) {
            NewsFeedCacheInvalidationGCMService.m8295a(this.f7513d, ((long) this.f7512c.e(60)) * 60);
        }
    }

    public void clearUserData() {
        this.f7510a.m7813a();
        NewsFeedCacheInvalidationGCMService.m8294a(this.f7513d);
    }
}
