package com.facebook.analytics;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.common.util.StringUtil;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.RequestContext;
import com.facebook.http.observer.Stage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: notifications_sync */
public class AnalyticsHttpErrorReporter extends AbstractFbHttpFlowObserver {
    private final AnalyticsLogger f12087a;
    private final ConnectivityManager f12088b;
    private final TimeWindowThrottlingPolicy f12089c;

    @Inject
    public AnalyticsHttpErrorReporter(AnalyticsLogger analyticsLogger, ConnectivityManager connectivityManager, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy) {
        this.f12087a = analyticsLogger;
        this.f12088b = connectivityManager;
        this.f12089c = timeWindowThrottlingPolicy;
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2282b(httpResponse, httpContext);
        if (httpContext.getAttribute("fb_http_retried_exceptions") != null) {
            m17805a(Stage.HTTP_CLIENT_EXECUTE, m17725b(), httpContext, null);
            httpContext.removeAttribute("fb_http_retried_exceptions");
        }
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        m17805a(stage, httpRequest, httpContext, iOException);
    }

    private void m17805a(Stage stage, HttpRequest httpRequest, HttpContext httpContext, IOException iOException) {
        URI uri;
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("http_error");
        honeyClientEvent.m5090b("stage", stage.toString());
        honeyClientEvent.m5090b("error", iOException != null ? iOException.getClass().getSimpleName() : "none");
        NetworkInfo activeNetworkInfo = this.f12088b.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            honeyClientEvent.m5090b("network", activeNetworkInfo.getTypeName());
            honeyClientEvent.m5090b("network_state", activeNetworkInfo.getDetailedState().toString());
        } else {
            honeyClientEvent.m5090b("network", "none");
        }
        RequestContext a = RequestContext.m17674a(httpContext);
        String str = a.f11977a;
        if (str != null) {
            honeyClientEvent.m5090b("request_name", str);
        }
        if (httpRequest instanceof HttpUriRequest) {
            uri = ((HttpUriRequest) httpRequest).getURI();
        } else {
            uri = URI.create(httpRequest.getRequestLine().getUri());
        }
        honeyClientEvent.m5090b("uri", uri.toString());
        honeyClientEvent.m5090b("method", httpRequest.getRequestLine().getMethod());
        str = a.f11983g;
        if (str != null) {
            honeyClientEvent.m5090b("category", str);
        }
        HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.proxy_host");
        if (httpHost != null) {
            honeyClientEvent.m5090b("proxy", httpHost.toString());
        } else {
            List<String> list = (List) httpContext.getAttribute("fb_http_retried_exceptions");
            if (list != null) {
                JsonNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
                for (String h : list) {
                    arrayNode.m13394h(h);
                }
                honeyClientEvent.m5085a("retried_exceptions", arrayNode);
                honeyClientEvent.m5083a("retry_count", list.size());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uri.getScheme()).append('_').append(uri.getHost());
        m17804a(honeyClientEvent, "stage", stringBuilder);
        m17804a(honeyClientEvent, "error", stringBuilder);
        m17804a(honeyClientEvent, "network", stringBuilder);
        m17804a(honeyClientEvent, "network_state", stringBuilder);
        m17804a(honeyClientEvent, "category", stringBuilder);
        m17804a(honeyClientEvent, "method", stringBuilder);
        m17804a(honeyClientEvent, "proxy", stringBuilder);
        if (!this.f12089c.m15992a(stringBuilder.toString(), 3600000)) {
            this.f12087a.mo526a(honeyClientEvent);
        }
    }

    private static void m17804a(HoneyClientEvent honeyClientEvent, String str, StringBuilder stringBuilder) {
        CharSequence m = honeyClientEvent.m5101m(str);
        if (!StringUtil.m3589a(m)) {
            stringBuilder.append('_').append(m);
        }
    }
}
