package com.facebook.feed.data;

import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.data.FetchFeedDirection;
import com.facebook.debug.log.BLog;
import com.facebook.feed.data.FeedDataLoader.RerankingStatus;
import com.facebook.feed.loader.LoadIntentHint;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.graphql.executor.RequestSubscriber;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: application/vobsub */
class FeedDataLoader$2 extends RequestSubscriber<FetchFeedResult> {
    final /* synthetic */ long f19157a;
    final /* synthetic */ FeedDataLoader f19158b;
    private final long f19159c = this.f19158b.ai.a();

    FeedDataLoader$2(FeedDataLoader feedDataLoader, long j) {
        this.f19158b = feedDataLoader;
        this.f19157a = j;
    }

    public final void m22687a(Object obj) {
        FetchFeedResult fetchFeedResult = (FetchFeedResult) obj;
        TracerDetour.a("FeedDataLoader.loadAfterCacheDataSuccess", 117642616);
        try {
            if (this.f19157a > 0) {
                this.f19158b.V.a(true);
            }
            FeedDataLoader.a(this.f19158b, fetchFeedResult, FetchFeedDirection.BEFORE, false, 0);
        } finally {
            TracerDetour.a(-368062486);
        }
    }

    public final void m22686a() {
        if (this.f19157a > 0) {
            this.f19158b.av = RerankingStatus.SCHEDULED_RERANKED;
            this.f19158b.au = this.f19158b.ai.a() - this.f19159c;
        } else {
            this.f19158b.av = RerankingStatus.INSTANT_RERANKED;
            FeedDataLoader.c(this.f19158b, true);
        }
        FeedDataLoader.O(this.f19158b);
        this.f19158b.m.a(0, LoadIntentHint.AvoidNewStoryPill);
    }

    public final void m22688a(Throwable th) {
        if (this.f19157a > 0) {
            this.f19158b.au = this.f19158b.ai.a() - this.f19159c;
        }
        FeedDataLoader.O(this.f19158b);
        BLog.b(FeedDataLoader.E, th, "PTR Reranking failed", new Object[0]);
        this.f19158b.a(Event.PTR_RERANKING_FAILURE);
        FeedDataLoader.a(this.f19158b, th, FetchFeedDirection.BEFORE);
    }
}
