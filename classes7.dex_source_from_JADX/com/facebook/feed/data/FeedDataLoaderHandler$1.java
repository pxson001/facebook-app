package com.facebook.feed.data;

import com.facebook.feed.loader.IFeedDataLoader;

/* compiled from: application/ttml+xml */
public class FeedDataLoaderHandler$1 implements Runnable {
    final /* synthetic */ FeedDataLoaderHandler f19168a;

    public FeedDataLoaderHandler$1(FeedDataLoaderHandler feedDataLoaderHandler) {
        this.f19168a = feedDataLoaderHandler;
    }

    public void run() {
        IFeedDataLoader a = ((FeedDataLoaderFactory) this.f19168a.b.get()).a(this.f19168a.a.a());
        a.m();
        a.f();
    }
}
