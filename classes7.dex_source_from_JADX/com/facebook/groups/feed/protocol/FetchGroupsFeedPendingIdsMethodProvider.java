package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: pyml_unhide_feed_unit */
public class FetchGroupsFeedPendingIdsMethodProvider extends AbstractAssistedProvider<FetchGroupsFeedPendingIdsMethod> {
    public final FetchGroupsFeedPendingIdsMethod m6811a(FeedType feedType) {
        return new FetchGroupsFeedPendingIdsMethod(feedType, DbFeedHomeStoriesHandler.a(this));
    }
}
