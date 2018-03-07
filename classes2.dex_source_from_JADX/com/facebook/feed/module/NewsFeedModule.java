package com.facebook.feed.module;

import com.facebook.api.feedcache.db.FeedDbCacheServiceHandler;
import com.facebook.api.feedcache.memory.FeedMemoryCacheServiceHandler;
import com.facebook.api.ufiservices.UFIServicesHandler;
import com.facebook.composer.publish.ComposerPublishServiceHandler;
import com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.LazyFilterChainLink;
import com.facebook.feed.annotations.ForNewsfeed;
import com.facebook.feed.annotations.IsTopicEnabled;
import com.facebook.feed.data.FeedDataLoaderHandler;
import com.facebook.feed.protocol.UpdateTimelineAppCollectionMethod;
import com.facebook.feed.server.FeedUnitPreRenderProcessFilter;
import com.facebook.feed.server.NewsFeedServiceHandler;
import com.facebook.feed.server.UpdateCollectionServiceHandler;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.provider.IProvidePreferences;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.privacy.service.PrivacyCacheServiceHandler;
import com.facebook.saved.common.sync.SavedEventHandler;
import com.facebook.ufiservices.annotations.IsCommentEditingEnabled;
import javax.inject.Provider;

@InjectorModule
/* compiled from: initialCapacity */
public class NewsFeedModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsCommentEditingEnabled
    public static Boolean m27770a() {
        return Boolean.valueOf(true);
    }

    @IsTopicEnabled
    @ProviderMethod
    public static Boolean m27771e() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @ForNewsfeed
    public static UpdateCollectionServiceHandler m27769a(Lazy<SavedEventHandler> lazy, FbSharedPreferences fbSharedPreferences, Provider<SingleMethodRunner> provider, Provider<UpdateTimelineAppCollectionMethod> provider2) {
        return new UpdateCollectionServiceHandler(lazy, fbSharedPreferences, provider, provider2, "update_timeline_app_collection_in_newsfeed");
    }

    @ProviderMethod
    @ForNewsfeed
    static BlueServiceHandler m27768a(Lazy<UpdateCollectionServiceHandler> lazy, Lazy<NewsFeedServiceHandler> lazy2, Lazy<UFIServicesHandler> lazy3, Lazy<ComposerPublishServiceHandler> lazy4, Lazy<PrivacyCacheServiceHandler> lazy5, Lazy<ComposerPublishDbCacheServiceHandler> lazy6, Lazy<FeedDbCacheServiceHandler> lazy7, Lazy<FeedUnitPreRenderProcessFilter> lazy8, Lazy<FeedMemoryCacheServiceHandler> lazy9, Lazy<FeedDataLoaderHandler> lazy10) {
        return new LazyFilterChainLink(lazy10, new LazyFilterChainLink(lazy9, new LazyFilterChainLink(lazy8, new LazyFilterChainLink(lazy7, new LazyFilterChainLink(lazy6, new LazyFilterChainLink(lazy5, new LazyFilterChainLink(lazy4, new LazyFilterChainLink(lazy3, new LazyFilterChainLink(lazy, lazy2)))))))));
    }

    @ProviderMethod
    @ForNewsfeed
    static IProvidePreferences m27772f() {
        return new 1();
    }
}
