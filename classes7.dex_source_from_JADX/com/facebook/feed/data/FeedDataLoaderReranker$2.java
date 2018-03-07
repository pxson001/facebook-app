package com.facebook.feed.data;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.DiskCacheReadException;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbCacheResultRerankRequest;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.RequestObserver;

/* compiled from: application/pgs */
public class FeedDataLoaderReranker$2 implements Runnable {
    final /* synthetic */ RequestObserver f19170a;
    final /* synthetic */ FetchFeedParams f19171b;
    final /* synthetic */ FeedDataLoaderReranker f19172c;

    /* compiled from: application/pgs */
    public class C16661 {
        final /* synthetic */ FeedDataLoaderReranker$2 f19169a;

        C16661(FeedDataLoaderReranker$2 feedDataLoaderReranker$2) {
            this.f19169a = feedDataLoaderReranker$2;
        }

        public final void m22693a(FetchFeedResult fetchFeedResult) {
            FeedDataLoaderReranker.a(this.f19169a.f19172c, fetchFeedResult, this.f19169a.f19170a);
        }
    }

    public FeedDataLoaderReranker$2(FeedDataLoaderReranker feedDataLoaderReranker, RequestObserver requestObserver, FetchFeedParams fetchFeedParams) {
        this.f19172c = feedDataLoaderReranker;
        this.f19170a = requestObserver;
        this.f19171b = fetchFeedParams;
    }

    public void run() {
        if (!this.f19172c.c.b(new FeedDbCacheResultRerankRequest(new C16661(this), this.f19171b, this.f19172c.j()))) {
            try {
                FeedDataLoaderReranker.a(this.f19172c, this.f19172c.k.a(this.f19171b), this.f19170a);
            } catch (DiskCacheReadException e) {
                BLog.b(FeedDataLoaderReranker.a, "fetchHomeStoriesFromDb failed", e);
                this.f19170a.a(e);
            } catch (Exception e2) {
                FeedDataLoaderReranker.a(this.f19172c, FetchFeedResult.a(this.f19171b), this.f19170a);
            }
        }
        this.f19172c.g.set(null);
    }
}
