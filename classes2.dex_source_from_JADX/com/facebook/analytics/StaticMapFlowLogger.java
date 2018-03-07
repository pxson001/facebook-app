package com.facebook.analytics;

import android.net.Uri;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.TriState;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notifications_seen */
public class StaticMapFlowLogger extends AbstractFbHttpFlowObserver {
    private final boolean f12090a;
    private final AnalyticsLogger f12091b;

    @Inject
    public StaticMapFlowLogger(TriState triState, AnalyticsLogger analyticsLogger) {
        this.f12091b = analyticsLogger;
        this.f12090a = triState.asBoolean(false);
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2285a(httpResponse, httpContext);
        if (this.f12090a) {
            Uri parse = Uri.parse(m17725b().getRequestLine().getUri());
            String host = parse.getHost();
            String path = parse.getPath();
            Object obj = ("maps.google.com".equals(host) || "maps.googleapis.com".equals(host) || path.startsWith("/maps/static") || path.startsWith("/static_map.php")) ? 1 : null;
            if (obj != null) {
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("static_map_http_flow");
                honeyClientEvent.f3099c = "oxygen_map";
                this.f12091b.mo526a(honeyClientEvent.m5090b("uri", parse.toString()).m5083a("status_code", httpResponse.getStatusLine().getStatusCode()));
            }
        }
    }
}
