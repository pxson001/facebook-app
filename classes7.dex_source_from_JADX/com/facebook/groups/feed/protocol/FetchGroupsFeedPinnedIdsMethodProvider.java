package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: pymi_learn_more */
public class FetchGroupsFeedPinnedIdsMethodProvider extends AbstractAssistedProvider<FetchGroupsFeedPinnedIdsMethod> {
    public final FetchGroupsFeedPinnedIdsMethod m6815a(FeedType feedType) {
        return new FetchGroupsFeedPinnedIdsMethod(feedType, DbFeedHomeStoriesHandler.a(this));
    }
}
