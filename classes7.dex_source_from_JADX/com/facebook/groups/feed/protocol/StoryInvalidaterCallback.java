package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.ComparisonType;
import com.facebook.api.feedtype.FeedType;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.common.util.Tuple;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: public_event */
class StoryInvalidaterCallback<T> implements FutureCallback<GraphQLResult<T>> {
    private final StoryInvalidaterFetchIdsMethod<T> f5699a;
    private final FeedType f5700b;
    private final DbFeedHomeStoriesHandler f5701c;

    public void onSuccess(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        int i = 0;
        if (graphQLResult.e != null) {
            ImmutableList a = this.f5699a.mo285a(graphQLResult.e);
            ImmutableList b = this.f5701c.b(this.f5700b);
            if (!b.isEmpty()) {
                Tuple tuple = (Tuple) b.get(0);
                int i2 = 0;
                while (i2 < a.size() && !((String) tuple.a).equals(a.get(i2))) {
                    i2++;
                }
                while (i2 < a.size() && i < b.size() && ((String) ((Tuple) b.get(i)).a).equals(a.get(i2))) {
                    i++;
                    i2++;
                }
                if (i < b.size()) {
                    this.f5701c.a(this.f5700b, (String) ((Tuple) b.get(i)).b, ComparisonType.LTE, EvictionReason.CONTENT_STALE);
                }
            }
        }
    }

    public StoryInvalidaterCallback(StoryInvalidaterFetchIdsMethod<T> storyInvalidaterFetchIdsMethod, FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5699a = storyInvalidaterFetchIdsMethod;
        this.f5700b = feedType;
        this.f5701c = dbFeedHomeStoriesHandler;
    }

    public void onFailure(Throwable th) {
    }
}
