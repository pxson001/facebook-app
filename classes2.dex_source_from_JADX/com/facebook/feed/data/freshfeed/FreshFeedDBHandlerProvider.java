package com.facebook.feed.data.freshfeed;

import android.os.Looper;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: scroll_index */
public class FreshFeedDBHandlerProvider extends AbstractAssistedProvider<FreshFeedDBHandler> {
    public final FreshFeedDBHandler m10072a(Looper looper, FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler, FreshFeedBackgroundUIWorkHandler freshFeedBackgroundUIWorkHandler) {
        return new FreshFeedDBHandler(looper, freshFeedDataLoaderUIHandler, freshFeedBackgroundUIWorkHandler, DbFeedHomeStoriesHandler.m9120a((InjectorLike) this), NewsFeedEventLogger.m4405a((InjectorLike) this));
    }
}
