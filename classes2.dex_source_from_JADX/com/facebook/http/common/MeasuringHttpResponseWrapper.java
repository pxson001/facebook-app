package com.facebook.http.common;

import com.facebook.inject.Assisted;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.params.HttpParams;

/* compiled from: mHighPriTimings */
public class MeasuringHttpResponseWrapper implements HttpResponse {
    private final MeasuringEntityProvider f15550a;
    private final HttpResponse f15551b;
    @GuardedBy("this")
    private HttpEntity f15552c;
    @GuardedBy("this")
    private MeasuringEntity f15553d;

    @Inject
    public MeasuringHttpResponseWrapper(MeasuringEntityProvider measuringEntityProvider, @Assisted HttpResponse httpResponse) {
        this.f15550a = measuringEntityProvider;
        this.f15551b = httpResponse;
    }

    public final synchronized long m22190a() {
        return this.f15553d == null ? -1 : this.f15553d.m22192a();
    }

    public synchronized HttpEntity getEntity() {
        if (this.f15552c == null) {
            HttpEntity entity = this.f15551b.getEntity();
            if (!entity.isRepeatable()) {
                entity = this.f15550a.m22191a(this.f15551b.getEntity());
                this.f15553d = entity;
            }
            this.f15552c = entity;
        }
        return this.f15552c;
    }

    public StatusLine getStatusLine() {
        return this.f15551b.getStatusLine();
    }

    public void setStatusLine(StatusLine statusLine) {
        this.f15551b.setStatusLine(statusLine);
    }

    public void setStatusLine(ProtocolVersion protocolVersion, int i) {
        this.f15551b.setStatusLine(protocolVersion, i);
    }

    public void setStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        this.f15551b.setStatusLine(protocolVersion, i, str);
    }

    public void setStatusCode(int i) {
        this.f15551b.setStatusCode(i);
    }

    public void setReasonPhrase(String str) {
        this.f15551b.setReasonPhrase(str);
    }

    public synchronized void setEntity(HttpEntity httpEntity) {
        this.f15551b.setEntity(httpEntity);
        this.f15552c = null;
        this.f15553d = null;
    }

    public Locale getLocale() {
        return this.f15551b.getLocale();
    }

    public void setLocale(Locale locale) {
        this.f15551b.setLocale(locale);
    }

    public ProtocolVersion getProtocolVersion() {
        return this.f15551b.getProtocolVersion();
    }

    public boolean containsHeader(String str) {
        return this.f15551b.containsHeader(str);
    }

    public Header[] getHeaders(String str) {
        return this.f15551b.getHeaders(str);
    }

    public Header getFirstHeader(String str) {
        return this.f15551b.getFirstHeader(str);
    }

    public Header getLastHeader(String str) {
        return this.f15551b.getLastHeader(str);
    }

    public Header[] getAllHeaders() {
        return this.f15551b.getAllHeaders();
    }

    public void addHeader(Header header) {
        this.f15551b.addHeader(header);
    }

    public void addHeader(String str, String str2) {
        this.f15551b.addHeader(str, str2);
    }

    public void setHeader(Header header) {
        this.f15551b.setHeader(header);
    }

    public void setHeader(String str, String str2) {
        this.f15551b.setHeader(str, str2);
    }

    public void setHeaders(Header[] headerArr) {
        this.f15551b.setHeaders(headerArr);
    }

    public void removeHeader(Header header) {
        this.f15551b.removeHeader(header);
    }

    public void removeHeaders(String str) {
        this.f15551b.removeHeaders(str);
    }

    public HeaderIterator headerIterator() {
        return this.f15551b.headerIterator();
    }

    public HeaderIterator headerIterator(String str) {
        return this.f15551b.headerIterator(str);
    }

    public HttpParams getParams() {
        return this.f15551b.getParams();
    }

    public void setParams(HttpParams httpParams) {
        this.f15551b.setParams(httpParams);
    }
}
