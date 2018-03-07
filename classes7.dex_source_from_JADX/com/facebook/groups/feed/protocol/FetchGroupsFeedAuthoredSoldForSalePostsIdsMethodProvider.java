package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: question_count */
public class FetchGroupsFeedAuthoredSoldForSalePostsIdsMethodProvider extends AbstractAssistedProvider<FetchGroupsFeedAuthoredSoldForSalePostsIdsMethod> {
    public final FetchGroupsFeedAuthoredSoldForSalePostsIdsMethod m6525a(FeedType feedType) {
        return new FetchGroupsFeedAuthoredSoldForSalePostsIdsMethod(feedType, DbFeedHomeStoriesHandler.a(this));
    }
}
