package com.facebook.feed.ui.feedprefetch;

import com.facebook.api.feed.FetchFeedResult;

/* compiled from: TopicFeedList */
class FeedPrefetchLoader$2 implements Runnable {
    final /* synthetic */ FetchFeedResult f21880a;
    final /* synthetic */ FeedPrefetchLoader f21881b;

    FeedPrefetchLoader$2(FeedPrefetchLoader feedPrefetchLoader, FetchFeedResult fetchFeedResult) {
        this.f21881b = feedPrefetchLoader;
        this.f21880a = fetchFeedResult;
    }

    public void run() {
        FeedPrefetchLoader.b(this.f21881b, this.f21880a);
    }
}
