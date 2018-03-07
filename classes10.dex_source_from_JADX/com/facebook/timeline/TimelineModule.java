package com.facebook.timeline;

import com.facebook.composer.publish.ComposerPublishServiceHandler;
import com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.module.CountingMemoryCache_BitmapMemoryCacheMethodAutoProvider;
import com.facebook.imagepipeline.module.CountingMemoryCache_SimpleImageMemoryCacheMethodAutoProvider;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.pages.app.annotation.IsUserTimelineEnabled;
import com.facebook.privacy.service.PrivacyCacheServiceHandler;
import com.facebook.timeline.annotations.IsMleDeleteEnabled;
import com.facebook.timeline.cache.db.TimelineDbCache;
import com.facebook.timeline.service.TimelineSectionQueue;
import com.facebook.timeline.service.TimelineSectionServiceHandler;
import com.google.common.annotations.VisibleForTesting;

@InjectorModule
/* compiled from: groups_seeds_composer_create_event */
public class TimelineModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsUserTimelineEnabled
    public static Boolean m10332a() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @IsMleDeleteEnabled
    static Boolean m10333c() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @TimelineSectionQueue
    public static BlueServiceHandler m10331a(PrivacyCacheServiceHandler privacyCacheServiceHandler, ComposerPublishDbCacheServiceHandler composerPublishDbCacheServiceHandler, ComposerPublishServiceHandler composerPublishServiceHandler, TimelineSectionServiceHandler timelineSectionServiceHandler) {
        return new FilterChainLink(privacyCacheServiceHandler, new FilterChainLink(composerPublishDbCacheServiceHandler, new FilterChainLink(composerPublishServiceHandler, timelineSectionServiceHandler)));
    }

    @VisibleForTesting
    public static GraphQLCacheManager getInstanceForTest_GraphQLCacheManager(FbInjector fbInjector) {
        return GraphQLCacheManager.a(fbInjector);
    }

    @VisibleForTesting
    public static TimelineDbCache getInstanceForTest_TimelineDbCache(FbInjector fbInjector) {
        return TimelineDbCache.a(fbInjector);
    }

    @VisibleForTesting
    public static CountingMemoryCache getInstanceForTest_SimpleImageMemoryCache(FbInjector fbInjector) {
        return CountingMemoryCache_SimpleImageMemoryCacheMethodAutoProvider.a(fbInjector);
    }

    @VisibleForTesting
    public static CountingMemoryCache getInstanceForTest_BitmapMemoryCache(FbInjector fbInjector) {
        return CountingMemoryCache_BitmapMemoryCacheMethodAutoProvider.a(fbInjector);
    }
}
