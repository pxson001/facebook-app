package com.facebook.logging.cdn;

import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.Stage;
import com.facebook.logging.cdn.CdnLoggerConstants.HEADERS;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.performancelogger.SequenceTrackingLoggerHelper;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notification_image */
public class CdnLoggerFlowObserver extends AbstractFbHttpFlowObserver {
    private final PerformanceLogger f12138a;
    private boolean f12139b = false;
    private MarkerConfig f12140c;
    private String f12141d;
    private String f12142e;

    @Inject
    public CdnLoggerFlowObserver(PerformanceLogger performanceLogger) {
        this.f12138a = performanceLogger;
    }

    public final void mo2284a(HttpRequest httpRequest, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        super.mo2284a(httpRequest, httpContext, httpFlowStatistics);
        this.f12141d = httpRequest.getRequestLine().getUri();
        this.f12142e = CdnLoggerHelper.m17687b(this.f12141d);
        if (this.f12142e == null) {
            this.f12139b = true;
            return;
        }
        this.f12140c = new SequenceTrackingLoggerHelper(this.f12138a, 1.0d).a(4849672, "CDN_IMAGE_LOAD_LOGGER");
        this.f12138a.mo391c(this.f12140c);
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2282b(httpResponse, httpContext);
        if (!this.f12139b) {
            Map map = this.f12140c.f1703l;
            for (String firstHeader : HEADERS.a) {
                Header firstHeader2 = httpResponse.getFirstHeader(firstHeader);
                if (firstHeader2 != null) {
                    map.put("header." + firstHeader2.getName(), firstHeader2.getValue());
                }
            }
            map.put("url", CdnLoggerHelper.m17686a(this.f12141d));
            map.put("cdn_type", this.f12142e);
            this.f12140c.m3387a(map);
            this.f12138a.mo387b(this.f12140c);
        }
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        super.mo2281a(stage, httpRequest, httpResponse, httpContext, iOException);
        if (!this.f12139b) {
            this.f12138a.mo393d(this.f12140c);
        }
    }
}
