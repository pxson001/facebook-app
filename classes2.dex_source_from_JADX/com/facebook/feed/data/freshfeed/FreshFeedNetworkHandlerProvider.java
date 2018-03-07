package com.facebook.feed.data.freshfeed;

import android.os.Looper;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.common.appstartup.AppStartupTracker;
import com.facebook.common.executors.C0273x21b230ff;
import com.facebook.feed.data.FeedFetcherProcessor;
import com.facebook.feed.loader.FeedFetcherCache;
import com.facebook.feed.loader.FetchFeedParamsGenerator;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: scroll_position */
public class FreshFeedNetworkHandlerProvider extends AbstractAssistedProvider<FreshFeedNetworkHandler> {
    public final FreshFeedNetworkHandler m10071a(Looper looper, FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler, FreshFeedBackgroundUIWorkHandler freshFeedBackgroundUIWorkHandler) {
        return new FreshFeedNetworkHandler(looper, freshFeedDataLoaderUIHandler, freshFeedBackgroundUIWorkHandler, DbFeedHomeStoriesHandler.m9120a((InjectorLike) this), C0273x21b230ff.m10433a(this), FetchFeedParamsGenerator.m9794b((InjectorLike) this), GraphQLQueryExecutor.m10435a((InjectorLike) this), FeedFetcherProcessor.m10525a((InjectorLike) this), FeedFetcherCache.m10533a((InjectorLike) this), FetchNewsFeedMethod.m10080b((InjectorLike) this), NewsFeedXConfigReader.m8187a((InjectorLike) this), NewsFeedEventLogger.m4405a((InjectorLike) this), AppStartupTracker.m9073a((InjectorLike) this));
    }
}
