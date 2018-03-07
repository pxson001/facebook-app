package com.facebook.zero.logging;

import android.net.Uri;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.TriState;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.Stage;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.FbZeroTokenType;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HttpContext;

/* compiled from: not_supported */
public class ZeroHttpObserver extends AbstractFbHttpFlowObserver {
    private final AnalyticsLogger f12164a;
    private final FbSharedPreferences f12165b;
    private final Provider<TriState> f12166c;
    private final Provider<FbZeroTokenType> f12167d;

    @Inject
    public ZeroHttpObserver(AnalyticsLogger analyticsLogger, FbSharedPreferences fbSharedPreferences, Provider<TriState> provider, Provider<FbZeroTokenType> provider2) {
        this.f12164a = analyticsLogger;
        this.f12165b = fbSharedPreferences;
        this.f12166c = provider;
        this.f12167d = provider2;
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2282b(httpResponse, httpContext);
        m17866e();
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        super.mo2281a(stage, httpRequest, httpResponse, httpContext, iOException);
        m17866e();
    }

    private void m17866e() {
        if (TriState.YES.equals(this.f12166c.get())) {
            this.f12164a.mo526a(m17867f());
        }
    }

    private HoneyClientEvent m17867f() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("zero_http");
        HttpRequest b = m17725b();
        HttpFlowStatistics httpFlowStatistics = this.f12029d;
        this.f12029d.f12003j = true;
        HttpResponse httpResponse = this.f12028c;
        honeyClientEvent.m5090b("http_stack", String.valueOf(httpFlowStatistics.f11996c));
        honeyClientEvent.m5090b("network_type", httpFlowStatistics.f12000g);
        honeyClientEvent.m5090b("network_subtype", httpFlowStatistics.f12001h);
        String uri = b.getRequestLine().getUri();
        honeyClientEvent.m5090b("uri", uri);
        if (httpFlowStatistics.f11998e != null) {
            honeyClientEvent.m5090b("ip_address", httpFlowStatistics.f11998e);
        }
        FbZeroTokenType fbZeroTokenType = (FbZeroTokenType) this.f12167d.get();
        honeyClientEvent.m5090b("hostname", Uri.parse(uri).getHost());
        honeyClientEvent.m5084a("body_bytes_written", httpFlowStatistics.m17700i());
        honeyClientEvent.m5090b(fbZeroTokenType.getRegistrationStatusKey().m2012a(), this.f12165b.mo278a(fbZeroTokenType.getRegistrationStatusKey(), "unknown"));
        honeyClientEvent.m5090b(fbZeroTokenType.getCampaignIdKey().m2012a(), this.f12165b.mo278a(fbZeroTokenType.getCampaignIdKey(), ""));
        if (httpResponse != null) {
            honeyClientEvent.m5090b("content_type", NetworkDataLogUtils.m15996a(httpResponse));
            honeyClientEvent.m5084a("body_bytes_read", httpFlowStatistics.responseHeaderBytes.f12005a + httpFlowStatistics.responseBodyBytes.f12005a);
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine != null) {
                honeyClientEvent.m5090b("status_code", String.valueOf(statusLine.getStatusCode()));
            }
        }
        return honeyClientEvent;
    }
}
