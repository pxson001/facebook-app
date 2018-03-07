package com.facebook.feed.data.freshfeed;

import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.protocol.FetchFeedMethod;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: scrolled_by */
public class FreshFeedFetcher extends Handler {
    private final FreshFeedDBHandlerProvider f5942a;
    private final FreshFeedNetworkHandlerProvider f5943b;
    private final FbHandlerThreadFactory f5944c;
    public HandlerThread f5945d;
    public HandlerThread f5946e;
    public FreshFeedDBHandler f5947f;
    public FreshFeedNetworkHandler f5948g;
    private final FreshFeedDataLoaderUIHandler f5949h;
    private final FreshFeedBackgroundUIWorkHandler f5950i;

    /* compiled from: scrolled_by */
    public class FetchParams {
        public final DataFreshnessParam f5953a;
        public final FeedType f5954b;
        public final FetchFeedMethod f5955c;
        public final String f5956d;
        public final long f5957e;
        public final String f5958f;
        public final FetchFeedCause f5959g;

        public FetchParams(DataFreshnessParam dataFreshnessParam, FeedType feedType, FetchFeedMethod fetchFeedMethod, String str, long j, String str2, FetchFeedCause fetchFeedCause) {
            this.f5953a = dataFreshnessParam;
            this.f5954b = feedType;
            this.f5955c = fetchFeedMethod;
            this.f5956d = str;
            this.f5957e = j;
            this.f5958f = str2;
            this.f5959g = fetchFeedCause;
        }
    }

    @Inject
    public FreshFeedFetcher(@Assisted FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler, @Assisted FreshFeedBackgroundUIWorkHandler freshFeedBackgroundUIWorkHandler, FreshFeedNetworkHandlerProvider freshFeedNetworkHandlerProvider, FreshFeedDBHandlerProvider freshFeedDBHandlerProvider, FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f5949h = freshFeedDataLoaderUIHandler;
        this.f5942a = freshFeedDBHandlerProvider;
        this.f5943b = freshFeedNetworkHandlerProvider;
        this.f5944c = fbHandlerThreadFactory;
        this.f5950i = freshFeedBackgroundUIWorkHandler;
    }

    public final void m10067a() {
        TracerDetour.a("FreshFeedFetcher.loadEdgesFromDB", -156024942);
        try {
            m10065d();
            this.f5947f.m20233b();
        } finally {
            TracerDetour.a(-196203094);
        }
    }

    public final void m10069b() {
        TracerDetour.a("FreshFeedFetcher.reLoadEdgesFromDB", 221135197);
        try {
            m10065d();
            this.f5947f.m20234c();
        } finally {
            TracerDetour.a(-1564486878);
        }
    }

    public final void m10068a(FetchParams fetchParams) {
        TracerDetour.a("FreshFeedFetcher.loadNewDataFromNetwork", 921508463);
        try {
            m10066e();
            this.f5948g.m10430a(fetchParams);
        } finally {
            TracerDetour.a(868026923);
        }
    }

    public final void m10070b(FetchParams fetchParams) {
        TracerDetour.a("FreshFeedFetcher.loadMoreDataFromNetwork", 1320824202);
        try {
            m10066e();
            this.f5948g.m10432b(fetchParams);
        } finally {
            TracerDetour.a(1898295057);
        }
    }

    private void m10065d() {
        TracerDetour.a("FreshFeedFetcher.ensureDBHandler", 464683804);
        try {
            if (this.f5945d == null) {
                this.f5945d = this.f5944c.m3580a("freshfeed_db_fetcher", ThreadPriority.FOREGROUND);
                this.f5945d.start();
                this.f5947f = this.f5942a.m10072a(this.f5945d.getLooper(), this.f5949h, this.f5950i);
            }
            TracerDetour.a(-1236335876);
        } catch (Throwable th) {
            TracerDetour.a(-1214608041);
        }
    }

    private void m10066e() {
        TracerDetour.a("FreshFeedFetcher.ensureNetworkHandler", 36549283);
        try {
            if (this.f5946e == null) {
                this.f5946e = this.f5944c.m3580a("freshfeed_network_fetcher", ThreadPriority.FOREGROUND);
                this.f5946e.start();
                this.f5948g = this.f5943b.m10071a(this.f5946e.getLooper(), this.f5949h, this.f5950i);
            }
            TracerDetour.a(-387959521);
        } catch (Throwable th) {
            TracerDetour.a(310321995);
        }
    }
}
