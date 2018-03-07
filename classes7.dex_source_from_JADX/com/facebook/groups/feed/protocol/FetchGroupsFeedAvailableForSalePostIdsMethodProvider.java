package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: question_add_poll_option_option_tag */
public class FetchGroupsFeedAvailableForSalePostIdsMethodProvider extends AbstractAssistedProvider<FetchGroupsFeedAvailableForSalePostIdsMethod> {
    public final FetchGroupsFeedAvailableForSalePostIdsMethod m6529a(FeedType feedType) {
        return new FetchGroupsFeedAvailableForSalePostIdsMethod(feedType, DbFeedHomeStoriesHandler.a(this));
    }
}
