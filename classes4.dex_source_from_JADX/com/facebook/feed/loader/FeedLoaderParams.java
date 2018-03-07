package com.facebook.feed.loader;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.protocol.FetchFeedMethod;
import com.facebook.graphql.executor.RequestSubscriber;

/* compiled from: warning */
public class FeedLoaderParams {
    public final FetchFeedParams f187a;
    private final DataFreshnessParam f188b;
    public final FetchFeedMethod f189c;
    private final String f190d;
    public final long f191e;
    public final RequestSubscriber<FetchFeedResult> f192f;
    public boolean f193g;

    public FeedLoaderParams(FetchFeedParams fetchFeedParams, DataFreshnessParam dataFreshnessParam, FetchFeedMethod fetchFeedMethod, RequestSubscriber<FetchFeedResult> requestSubscriber, String str, long j) {
        this.f187a = fetchFeedParams;
        this.f188b = dataFreshnessParam;
        this.f189c = fetchFeedMethod;
        this.f190d = str;
        this.f191e = j;
        this.f192f = requestSubscriber;
    }

    public final FetchFeedParams m213a() {
        return this.f187a;
    }

    public final DataFreshnessParam m214b() {
        return this.f188b;
    }

    public final FetchFeedMethod m215c() {
        return this.f189c;
    }

    public final String m216d() {
        return this.f190d;
    }

    public final RequestSubscriber<FetchFeedResult> m217f() {
        return this.f192f;
    }
}
