package com.facebook.api.feed;

import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: seen_state */
public class FetchFeedParamsBuilder {
    public DataFreshnessParam f5799a;
    public FeedType f5800b;
    public int f5801c;
    public long f5802d;
    public long f5803e;
    @Nullable
    public String f5804f;
    @Nullable
    public String f5805g;
    public String f5806h;
    public FetchFeedCause f5807i = FetchFeedCause.UNKNOWN;
    public boolean f5808j;
    public FetchTypeForLogging f5809k = FetchTypeForLogging.UNSET;
    public FeedFetchContext f5810l = FeedFetchContext.f5815a;
    @Nullable
    public CallerContext f5811m;
    @Nullable
    public ImmutableList<String> f5812n;
    public boolean f5813o;
    public boolean f5814p;

    public final FetchFeedParamsBuilder m9928a(DataFreshnessParam dataFreshnessParam) {
        this.f5799a = dataFreshnessParam;
        return this;
    }

    public final FetchFeedParamsBuilder m9927a(FeedType feedType) {
        this.f5800b = feedType;
        return this;
    }

    public final FetchFeedParamsBuilder m9923a(int i) {
        this.f5801c = i;
        return this;
    }

    public final FetchFeedParamsBuilder m9929b(@Nullable String str) {
        this.f5805g = str;
        return this;
    }

    public final FetchFeedParamsBuilder m9925a(FetchFeedCause fetchFeedCause) {
        this.f5807i = (FetchFeedCause) Preconditions.checkNotNull(fetchFeedCause);
        return this;
    }

    public final FetchFeedParamsBuilder m9926a(FetchFeedParams fetchFeedParams) {
        this.f5804f = fetchFeedParams.f5787e;
        this.f5805g = fetchFeedParams.f5786d;
        this.f5799a = fetchFeedParams.f5783a;
        this.f5800b = fetchFeedParams.f5784b;
        this.f5801c = fetchFeedParams.f5785c;
        this.f5807i = fetchFeedParams.f5788f;
        this.f5808j = fetchFeedParams.f5797o;
        this.f5809k = fetchFeedParams.f5798p;
        this.f5810l = fetchFeedParams.f5790h;
        this.f5806h = fetchFeedParams.f5789g;
        this.f5811m = fetchFeedParams.f5792j;
        this.f5812n = fetchFeedParams.f5791i;
        this.f5813o = fetchFeedParams.f5793k;
        this.f5802d = fetchFeedParams.f5795m;
        this.f5803e = fetchFeedParams.f5796n;
        return this;
    }

    public final FetchFeedParamsBuilder m9924a(FeedFetchContext feedFetchContext) {
        this.f5810l = feedFetchContext;
        return this;
    }

    public final FetchFeedParams m9930q() {
        boolean z;
        Preconditions.checkNotNull(this.f5799a);
        if (this.f5801c > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        Preconditions.checkNotNull(this.f5800b);
        Preconditions.checkNotNull(this.f5810l);
        return new FetchFeedParams(this);
    }
}
