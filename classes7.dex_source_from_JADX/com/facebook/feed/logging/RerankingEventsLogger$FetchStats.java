package com.facebook.feed.logging;

import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;

/* compiled from: android.intent.action.PACKAGE_CHANGED */
public class RerankingEventsLogger$FetchStats {
    public final FetchFeedCause f19350a;
    public final long f19351b;
    public final long f19352c;
    public final long f19353d;
    public final boolean f19354e;
    public final boolean f19355f;

    public RerankingEventsLogger$FetchStats(FetchFeedCause fetchFeedCause, long j, long j2, long j3, boolean z, boolean z2) {
        this.f19350a = fetchFeedCause;
        this.f19351b = j;
        this.f19352c = j3;
        this.f19353d = j2;
        this.f19354e = z;
        this.f19355f = z2;
    }
}
