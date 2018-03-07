package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: queueType cannot be null */
public class FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethodProvider extends AbstractAssistedProvider<FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethod> {
    public final FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethod m6517a(FeedType feedType) {
        return new FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethod(feedType, DbFeedHomeStoriesHandler.a(this));
    }
}
