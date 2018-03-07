package com.facebook.feed.logging;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feedtype.FeedType;

/* compiled from: android.intent.action.SENDTO */
public class CacheStateLogger$CacheStateLoggingTask implements Runnable {
    final /* synthetic */ CacheStateLogger f19336a;
    private FeedType f19337b;
    private int f19338c;

    public CacheStateLogger$CacheStateLoggingTask(CacheStateLogger cacheStateLogger, FeedType feedType, int i) {
        this.f19336a = cacheStateLogger;
        this.f19337b = feedType;
        this.f19338c = i;
    }

    public void run() {
        AnalyticsLogger analyticsLogger = this.f19336a.c;
        CacheStateLogger cacheStateLogger = this.f19336a;
        FeedType feedType = this.f19337b;
        int i = this.f19338c;
        CacheStateLogger cacheStateLogger2 = this.f19336a;
        int a = cacheStateLogger2.b.a(this.f19337b, true);
        CacheStateLogger cacheStateLogger3 = this.f19336a;
        int d = cacheStateLogger3.b.d(this.f19337b);
        CacheStateLogger cacheStateLogger4 = this.f19336a;
        analyticsLogger.a(CacheStateLogger.a(cacheStateLogger, feedType, i, a, d, cacheStateLogger4.b.e(this.f19337b)));
    }
}
