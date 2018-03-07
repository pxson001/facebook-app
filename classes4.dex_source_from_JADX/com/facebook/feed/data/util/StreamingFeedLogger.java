package com.facebook.feed.data.util;

import android.util.SparseIntArray;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: walmart_wifi_bssid_list */
public class StreamingFeedLogger {
    private final MonotonicClock f215a;
    public final AnalyticsLogger f216b;
    private final FbNetworkManager f217c;
    private final SparseIntArray f218d = new SparseIntArray(20);
    private long f219e;

    public static StreamingFeedLogger m231b(InjectorLike injectorLike) {
        return new StreamingFeedLogger((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike));
    }

    @Inject
    StreamingFeedLogger(MonotonicClock monotonicClock, AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager) {
        this.f215a = monotonicClock;
        this.f216b = analyticsLogger;
        this.f217c = fbNetworkManager;
    }

    public final void m233a(FetchFeedParams fetchFeedParams) {
        Preconditions.b(this.f219e == 0);
        this.f219e = this.f215a.now();
        HoneyClientEventFast a = this.f216b.a("android_feed_streaming_reliability", false);
        if (a.a()) {
            a.a("event", "start");
            a.a("fetch_type", fetchFeedParams.p.name());
            a.b();
        }
    }

    public final void m234a(FetchFeedParams fetchFeedParams, int i, boolean z) {
        Preconditions.b(this.f219e != 0);
        m228a(m230b(), true);
        m229a("complete", fetchFeedParams, i, z);
    }

    public final void m236b(FetchFeedParams fetchFeedParams, int i, boolean z) {
        boolean z2;
        if (this.f219e != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.b(z2);
        m228a(m230b(), false);
        m229a("error", fetchFeedParams, i, z);
    }

    public final void m232a() {
        Preconditions.b(this.f219e != 0);
        this.f218d.append(this.f218d.size(), m230b());
    }

    private int m230b() {
        Preconditions.b(this.f219e != 0);
        return (int) (this.f215a.now() - this.f219e);
    }

    private void m228a(int i, boolean z) {
        for (int i2 = 0; i2 < this.f218d.size(); i2++) {
            if (Math.random() < 0.005d) {
                HoneyClientEventFast a = this.f216b.a("android_feed_streaming_timings", false);
                if (a.a()) {
                    a.a("stop_reason", z ? "success" : "failure");
                    a.a("network_type", this.f217c.k());
                    a.a("network_subtype", this.f217c.l());
                    a.a("story_index", this.f218d.keyAt(i2));
                    a.a("story_time", this.f218d.valueAt(i2));
                    a.a("total_time", i);
                    a.a("total_stories_count", this.f218d.size());
                    a.b();
                }
            }
        }
    }

    public final void m235b(FetchFeedParams fetchFeedParams) {
        HoneyClientEventFast a = this.f216b.a("android_feed_streaming_reliability", false);
        if (a.a()) {
            a.a("event", "null_homestories");
            a.a("fetch_type", fetchFeedParams.p.name());
            a.b();
        }
    }

    private void m229a(String str, FetchFeedParams fetchFeedParams, int i, boolean z) {
        HoneyClientEventFast a = this.f216b.a("android_feed_streaming_reliability", false);
        if (a.a()) {
            a.a("event", str);
            a.a("fetch_type", fetchFeedParams.p.name());
            a.a("total", i);
            a.a("has_next", z);
            a.b();
        }
    }
}
