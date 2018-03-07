package com.facebook.http.common;

import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.http.observer.FbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.Stage;
import com.facebook.inject.Lazy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notifications/recent_threads/ */
public class HttpFlightRecordingFlowObserver implements FbHttpFlowObserver {
    private static final Class<?> f12096a = HttpFlightRecordingFlowObserver.class;
    private final HttpFlowFlightRecorderEvent f12097b;
    private final HttpFlightRecorderRequestSupplier f12098c;
    private final Lazy<ObjectMapper> f12099d;
    private final PerfTestConfig f12100e;

    @Inject
    public HttpFlightRecordingFlowObserver(NetworkDataLogUtils networkDataLogUtils, MonotonicClock monotonicClock, HttpFlightRecorderRequestSupplier httpFlightRecorderRequestSupplier, Lazy<ObjectMapper> lazy, PerfTestConfig perfTestConfig) {
        this.f12097b = new HttpFlowFlightRecorderEvent(monotonicClock, networkDataLogUtils);
        this.f12098c = httpFlightRecorderRequestSupplier;
        this.f12099d = lazy;
        this.f12100e = perfTestConfig;
    }

    public final void mo2283a(HttpRequest httpRequest, HttpContext httpContext) {
    }

    public final void mo2284a(HttpRequest httpRequest, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        this.f12097b.m17826a(httpRequest, httpContext, httpFlowStatistics);
        HttpFlightRecorderRequestSupplier httpFlightRecorderRequestSupplier = this.f12098c;
        HttpFlowFlightRecorderEvent httpFlowFlightRecorderEvent = this.f12097b;
        httpFlightRecorderRequestSupplier.f12102a.put(httpFlowFlightRecorderEvent, httpFlowFlightRecorderEvent);
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        this.f12097b.m17827a(httpResponse);
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        HttpFlowFlightRecorderEvent httpFlowFlightRecorderEvent = this.f12097b;
        httpFlowFlightRecorderEvent.f12108e = "success";
        httpFlowFlightRecorderEvent.f12120q = httpFlowFlightRecorderEvent.f12105b.now();
        this.f12098c.m17821b(this.f12097b);
        m17812a();
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        this.f12097b.m17828a(httpResponse, iOException);
        this.f12098c.m17821b(this.f12097b);
        m17812a();
    }

    private void m17812a() {
        if (PerfTestConfigBase.m2938a()) {
            try {
                BLog.a(f12096a, ((ObjectMapper) this.f12099d.get()).m6659a(this.f12097b));
            } catch (JsonProcessingException e) {
                BLog.b(f12096a, "failed ", e);
            }
        }
    }
}
