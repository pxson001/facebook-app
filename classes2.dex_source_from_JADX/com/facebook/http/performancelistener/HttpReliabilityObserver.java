package com.facebook.http.performancelistener;

import com.facebook.http.observer.FbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.Stage;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notification_settings */
public class HttpReliabilityObserver implements FbHttpFlowObserver {
    private final HttpReliabilityLogger f12130a;

    @Inject
    public HttpReliabilityObserver(HttpReliabilityLogger httpReliabilityLogger) {
        this.f12130a = httpReliabilityLogger;
    }

    public final void mo2284a(HttpRequest httpRequest, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
    }

    public final void mo2283a(HttpRequest httpRequest, HttpContext httpContext) {
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        this.f12130a.m17847b();
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        this.f12130a.m17848c();
    }
}
