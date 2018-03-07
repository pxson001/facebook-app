package com.facebook.feed.data;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.graphql.executor.RequestObserver;

/* compiled from: application/pgs */
class FeedDataLoaderReranker$3 implements Runnable {
    final /* synthetic */ FetchFeedParams f19173a;
    final /* synthetic */ RequestObserver f19174b;
    final /* synthetic */ FeedDataLoaderReranker f19175c;

    FeedDataLoaderReranker$3(FeedDataLoaderReranker feedDataLoaderReranker, FetchFeedParams fetchFeedParams, RequestObserver requestObserver) {
        this.f19175c = feedDataLoaderReranker;
        this.f19173a = fetchFeedParams;
        this.f19174b = requestObserver;
    }

    public void run() {
        FeedDataLoaderReranker.a(this.f19175c, FetchFeedResult.a(this.f19173a), this.f19174b);
        this.f19175c.h.set(null);
    }
}
