package com.facebook.feed.data.freshfeed;

/* compiled from: app_version_code */
class FreshFeedDataLoader$3 implements Runnable {
    final /* synthetic */ FreshFeedDataLoader f19202a;

    FreshFeedDataLoader$3(FreshFeedDataLoader freshFeedDataLoader) {
        this.f19202a = freshFeedDataLoader;
    }

    public void run() {
        this.f19202a.O.set(null);
        FreshFeedDataLoader freshFeedDataLoader = this.f19202a;
        freshFeedDataLoader.D.a(FreshFeedDataLoader.A, "PTR Rerank stories");
        FreshFeedDataLoader.b(freshFeedDataLoader, 5);
    }
}
