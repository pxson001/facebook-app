package com.facebook.ui.media.fetch;

import android.net.Uri;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.http.common.NetworkDataLogUtils;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;

/* compiled from: mc_payments_new_checkout_flow */
public class MediaResponseHandler<T> implements ResponseHandler<T> {
    private static final Class<?> f14735a = MediaResponseHandler.class;
    private final Uri f14736b;
    private final DownloadResultResponseHandler<T> f14737c;
    public final String f14738d;
    private final WebRequestCounters f14739e;
    public final AnalyticsLogger f14740f;
    private final TimeWindowThrottlingPolicy f14741g;
    private final NetworkDataLogUtils f14742h;
    private final CdnHttpRequestHandler f14743i;

    public MediaResponseHandler(Uri uri, DownloadResultResponseHandler<T> downloadResultResponseHandler, String str, WebRequestCounters webRequestCounters, AnalyticsLogger analyticsLogger, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy, NetworkDataLogUtils networkDataLogUtils, CdnHttpRequestHandler cdnHttpRequestHandler) {
        this.f14736b = uri;
        this.f14737c = downloadResultResponseHandler;
        this.f14738d = str;
        this.f14739e = webRequestCounters;
        this.f14740f = analyticsLogger;
        this.f14741g = timeWindowThrottlingPolicy;
        this.f14742h = networkDataLogUtils;
        this.f14743i = cdnHttpRequestHandler;
    }

    public T handleResponse(HttpResponse httpResponse) {
        CdnHeaderResponse cdnHeaderResponse = CdnHeaderResponse.NOT_IN_GK;
        if (this.f14743i != null && this.f14743i.mo1678a()) {
            cdnHeaderResponse = this.f14743i.mo1676a(httpResponse);
        }
        String uri = this.f14736b.toString();
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        HttpEntity entity = httpResponse.getEntity();
        if (statusCode != 200 || entity == null) {
            m21152a("MediaDownloader (HTTP code)", uri, statusCode);
            if (statusCode != 200) {
                throw new HttpResponseException(statusCode, statusLine.getReasonPhrase());
            }
            throw new ClientProtocolException("Missing HTTP entity");
        }
        this.f14739e.m16003c(uri);
        InputStream content = entity.getContent();
        try {
            T a = this.f14737c.mo2824a(content, NetworkDataLogUtils.m15997c(httpResponse), cdnHeaderResponse);
            return a;
        } finally {
            content.close();
        }
    }

    private void m21152a(String str, String str2, int i) {
        URI create = URI.create(str2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(create.getScheme()).append('_').append(create.getHost());
        stringBuilder.append('_').append(str).append('_').append(i);
        if (!this.f14741g.m15992a(stringBuilder.toString(), 3600000)) {
            new StringBuilder().append(str).append(" Url: ").append(str2);
            this.f14740f.mo526a(new HoneyClientEvent("media_downloader_failure").m5090b("category", str + ":" + this.f14738d).m5090b("url", str2).m5083a("http_code", i));
        }
    }
}
