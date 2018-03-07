package com.facebook.feed.protocol;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.FetchFeedParams;

/* compiled from: use_jni */
class FeedReliabilityLogger$1 implements Runnable {
    final /* synthetic */ FetchFeedParams f452a;
    final /* synthetic */ boolean f453b;
    final /* synthetic */ FeedReliabilityLogger f454c;

    FeedReliabilityLogger$1(FeedReliabilityLogger feedReliabilityLogger, FetchFeedParams fetchFeedParams, boolean z) {
        this.f454c = feedReliabilityLogger;
        this.f452a = fetchFeedParams;
        this.f453b = z;
    }

    public void run() {
        HoneyClientEvent a = new HoneyClientEvent("feed_e2e_load_success").b("client_query_id", this.f452a.g).a("from_primed_result", this.f453b);
        a.c = "native_newsfeed";
        FeedReliabilityLogger.a(this.f454c, a);
    }
}
