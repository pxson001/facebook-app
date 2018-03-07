package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: queueParams */
public class FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethodProvider extends AbstractAssistedProvider<FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethod> {
    public final FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethod m6521a(FeedType feedType) {
        return new FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethod(feedType, DbFeedHomeStoriesHandler.a(this));
    }
}
