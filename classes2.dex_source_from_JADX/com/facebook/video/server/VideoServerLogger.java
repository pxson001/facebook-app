package com.facebook.video.server;

import android.net.Uri;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.Lazy;
import com.facebook.video.analytics.VideoAnalytics.VideoServerAnalyticEvents;
import com.facebook.video.analytics.VideoPerformanceTracking;

/* compiled from: isSendClickedFlag */
public class VideoServerLogger {
    public final MonotonicClock f19327a;
    public final FbNetworkManager f19328b;
    public final Lazy<VideoPerformanceTracking> f19329c;
    public final DataUsageCounters f19330d;
    public final AnalyticsLogger f19331e;
    private int f19332f;

    public VideoServerLogger(MonotonicClock monotonicClock, FbNetworkManager fbNetworkManager, Lazy<VideoPerformanceTracking> lazy, DataUsageCounters dataUsageCounters, AnalyticsLogger analyticsLogger) {
        this.f19327a = monotonicClock;
        this.f19328b = fbNetworkManager;
        this.f19329c = lazy;
        this.f19330d = dataUsageCounters;
        this.f19331e = analyticsLogger;
    }

    public final RequestListenerImpl m26997a(String str, Uri uri, int i) {
        return new RequestListenerImpl(this, str, uri, i, false);
    }

    public final void m26998a(int i) {
        this.f19332f = i;
        this.f19331e.mo528a(new HoneyClientEvent(VideoServerAnalyticEvents.LAUNCH_SERVER.value).m5083a("port", this.f19332f));
    }
}
