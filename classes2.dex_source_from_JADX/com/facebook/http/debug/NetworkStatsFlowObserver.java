package com.facebook.http.debug;

import android.net.Uri;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.RequestContext;
import com.facebook.http.observer.Stage;
import com.google.common.base.Preconditions;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notification_source */
public class NetworkStatsFlowObserver extends AbstractFbHttpFlowObserver {
    private final NetworkStats f12122a;
    private final NetworkTimeStats f12123b;
    private final MonotonicClock f12124c;
    private HttpHost f12125d;
    @Nullable
    public String f12126e;
    private long f12127f;

    @Inject
    public NetworkStatsFlowObserver(NetworkStats networkStats, NetworkTimeStats networkTimeStats, MonotonicClock monotonicClock) {
        this.f12122a = networkStats;
        this.f12123b = networkTimeStats;
        this.f12124c = monotonicClock;
    }

    public final void mo2283a(HttpRequest httpRequest, HttpContext httpContext) {
        super.mo2283a(httpRequest, httpContext);
        Uri parse = Uri.parse(httpRequest.getRequestLine().getUri());
        this.f12125d = new HttpHost(parse.getHost(), parse.getPort(), parse.getScheme());
        this.f12126e = RequestContext.m17674a(httpContext).f11977a;
        this.f12122a.m13568a(m17830e(), this.f12126e, httpRequest);
        this.f12127f = this.f12124c.now();
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2285a(httpResponse, httpContext);
        HttpFlowStatistics httpFlowStatistics = this.f12029d;
        if (httpFlowStatistics.f11997d.asBoolean(true)) {
            this.f12122a.m13565a(m17830e(), this.f12126e);
        }
        this.f12122a.m13567a(m17830e(), this.f12126e, httpFlowStatistics.requestHeaderBytes.f12005a, httpFlowStatistics.requestBodyBytes.getCount(), httpFlowStatistics.responseHeaderBytes.getCount());
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2282b(httpResponse, httpContext);
        this.f12122a.m13566a(m17830e(), this.f12126e, this.f12029d.responseBodyBytes.f12005a);
        this.f12123b.m17837a(this.f12126e, this.f12124c.now() - this.f12127f);
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        super.mo2281a(stage, httpRequest, httpResponse, httpContext, iOException);
        this.f12122a.m13566a(m17830e(), this.f12126e, this.f12029d.responseBodyBytes.f12005a);
        this.f12123b.m17837a(this.f12126e, this.f12124c.now() - this.f12127f);
    }

    private HttpHost m17830e() {
        return (HttpHost) Preconditions.checkNotNull(this.f12125d);
    }
}
