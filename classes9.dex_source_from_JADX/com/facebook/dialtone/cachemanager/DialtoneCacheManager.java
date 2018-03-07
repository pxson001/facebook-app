package com.facebook.dialtone.cachemanager;

import com.facebook.events.data.EventsDatabaseSupplier;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.notifications.cache.NotificationStoryCache;
import com.facebook.notifications.db.GraphQLNotificationsDatabaseSupplier;
import com.facebook.notifications.module.NotificationStoryCache_OverflowedNotificationCacheMethodAutoProvider;
import com.facebook.notifications.module.NotificationStoryCache_RegularNotificationCacheMethodAutoProvider;
import com.facebook.photos.db.PhotosDatabaseSupplier;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.timeline.cache.db.TimelineDbCache;
import javax.inject.Inject;

/* compiled from: The field 'newStatus' has been assigned the invalid value  */
public class DialtoneCacheManager {
    public final DefaultBlueServiceOperationFactory f24209a;
    public final FbSharedPreferences f24210b;
    public final NotificationStoryCache f24211c;
    public final NotificationStoryCache f24212d;
    public final TimelineDbCache f24213e;
    public final GraphQLDiskCache f24214f;
    public final GraphQLNotificationsDatabaseSupplier f24215g;
    public final PhotosDatabaseSupplier f24216h;
    public final Lazy<EventsDatabaseSupplier> f24217i;

    public static DialtoneCacheManager m26172b(InjectorLike injectorLike) {
        return new DialtoneCacheManager(DefaultBlueServiceOperationFactory.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (GraphQLDiskCache) GraphQLDiskCacheImpl.a(injectorLike), TimelineDbCache.m851a(injectorLike), NotificationStoryCache_RegularNotificationCacheMethodAutoProvider.b(injectorLike), NotificationStoryCache_OverflowedNotificationCacheMethodAutoProvider.b(injectorLike), GraphQLNotificationsDatabaseSupplier.a(injectorLike), PhotosDatabaseSupplier.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5589));
    }

    @Inject
    public DialtoneCacheManager(BlueServiceOperationFactory blueServiceOperationFactory, FbSharedPreferences fbSharedPreferences, GraphQLDiskCache graphQLDiskCache, TimelineDbCache timelineDbCache, NotificationStoryCache notificationStoryCache, NotificationStoryCache notificationStoryCache2, GraphQLNotificationsDatabaseSupplier graphQLNotificationsDatabaseSupplier, PhotosDatabaseSupplier photosDatabaseSupplier, Lazy<EventsDatabaseSupplier> lazy) {
        this.f24209a = blueServiceOperationFactory;
        this.f24210b = fbSharedPreferences;
        this.f24211c = notificationStoryCache;
        this.f24212d = notificationStoryCache2;
        this.f24213e = timelineDbCache;
        this.f24214f = graphQLDiskCache;
        this.f24215g = graphQLNotificationsDatabaseSupplier;
        this.f24216h = photosDatabaseSupplier;
        this.f24217i = lazy;
    }
}
