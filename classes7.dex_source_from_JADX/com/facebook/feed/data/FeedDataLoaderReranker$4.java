package com.facebook.feed.data;

import com.facebook.api.feed.FetchFeedResult;
import com.facebook.graphql.executor.RequestObserver;

/* compiled from: application/pgs */
class FeedDataLoaderReranker$4 implements Runnable {
    final /* synthetic */ RequestObserver f19176a;
    final /* synthetic */ FetchFeedResult f19177b;
    final /* synthetic */ FeedDataLoaderReranker f19178c;

    FeedDataLoaderReranker$4(FeedDataLoaderReranker feedDataLoaderReranker, RequestObserver requestObserver, FetchFeedResult fetchFeedResult) {
        this.f19178c = feedDataLoaderReranker;
        this.f19176a = requestObserver;
        this.f19177b = fetchFeedResult;
    }

    public void run() {
        this.f19176a.a(this.f19177b);
        this.f19176a.a();
    }
}
