package com.facebook.feed.data;

import com.facebook.feed.data.FeedFetcher.FeedFetcherRunnable;

/* compiled from: application/id3 */
class FeedFetcher$FeedFetcherRunnable$2 implements Runnable {
    final /* synthetic */ Exception f19179a;
    final /* synthetic */ FeedFetcherRunnable f19180b;

    FeedFetcher$FeedFetcherRunnable$2(FeedFetcherRunnable feedFetcherRunnable, Exception exception) {
        this.f19180b = feedFetcherRunnable;
        this.f19179a = exception;
    }

    public void run() {
        this.f19180b.b.f.a(this.f19179a);
    }
}
