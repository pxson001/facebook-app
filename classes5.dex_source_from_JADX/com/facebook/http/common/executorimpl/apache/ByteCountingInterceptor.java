package com.facebook.http.common.executorimpl.apache;

import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.http.engine.ReportingInputStream;
import com.facebook.http.engine.ReportingOutputStream;
import com.facebook.http.observer.HttpFlowStatistics;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.protocol.HttpContext;

/* compiled from: doBeforeTextChanged */
public class ByteCountingInterceptor implements HttpRequestInterceptor, HttpResponseInterceptor {
    private NetworkDataLogUtils f4961a;

    /* compiled from: doBeforeTextChanged */
    class RequestStatisticEntityWrapper extends HttpEntityWrapper {
        private final HttpFlowStatistics f4959a;

        public RequestStatisticEntityWrapper(HttpEntity httpEntity, HttpFlowStatistics httpFlowStatistics) {
            super(httpEntity);
            this.f4959a = httpFlowStatistics;
        }

        public void writeTo(OutputStream outputStream) {
            this.f4959a.requestBodyBytes.a = 0;
            this.wrappedEntity.writeTo(new ReportingOutputStream(outputStream, this.f4959a.requestBodyBytes));
        }
    }

    /* compiled from: doBeforeTextChanged */
    class ResponseStatisticEntityWrapper extends HttpEntityWrapper {
        private final HttpFlowStatistics f4960a;

        public ResponseStatisticEntityWrapper(HttpEntity httpEntity, HttpFlowStatistics httpFlowStatistics) {
            super(httpEntity);
            this.f4960a = httpFlowStatistics;
        }

        public InputStream getContent() {
            return new ReportingInputStream(this.wrappedEntity.getContent(), this.f4960a.responseBodyBytes);
        }
    }

    public ByteCountingInterceptor(NetworkDataLogUtils networkDataLogUtils) {
        this.f4961a = (NetworkDataLogUtils) Preconditions.checkNotNull(networkDataLogUtils);
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        HttpFlowStatistics a = FbHttpClientRequestExecutor.m9919a(httpContext);
        NetworkDataLogUtils networkDataLogUtils = this.f4961a;
        long a2 = NetworkDataLogUtils.a(httpResponse);
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine != null) {
            a2 += (long) statusLine.toString().length();
        }
        a.responseHeaderBytes.a = a2;
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            httpResponse.setEntity(new ResponseStatisticEntityWrapper(entity, a));
        }
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        HttpFlowStatistics a = FbHttpClientRequestExecutor.m9919a(httpContext);
        NetworkDataLogUtils networkDataLogUtils = this.f4961a;
        long a2 = NetworkDataLogUtils.a(httpRequest);
        RequestLine requestLine = httpRequest.getRequestLine();
        if (requestLine != null) {
            a2 += (long) requestLine.toString().length();
        }
        a.requestHeaderBytes.a = a2;
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            HttpEntity entity = httpEntityEnclosingRequest.getEntity();
            if (entity != null) {
                httpEntityEnclosingRequest.setEntity(new RequestStatisticEntityWrapper(entity, a));
            }
        }
    }
}
