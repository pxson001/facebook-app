package com.facebook.debug.http;

import android.os.SystemClock;
import com.facebook.debug.http.DebugHttpFlowReporter.ErrorResponseInfo;
import com.facebook.debug.http.DebugHttpFlowReporter.RequestInfo;
import com.facebook.debug.http.DebugHttpFlowReporter.ResponseInfo;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.Stage;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.stethointernal.chrome.network.CompressionHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notifications_tab */
public class DebugHttpFlowObserver extends AbstractFbHttpFlowObserver {
    private static final AtomicInteger f12082a = new AtomicInteger();
    private int f12083b = -1;
    @Nullable
    private String f12084c;
    public Set<DebugHttpFlowReporter> f12085d;
    private ByteArrayOutputStream f12086e = null;

    @Inject
    public DebugHttpFlowObserver(Set<DebugHttpFlowReporter> set) {
        this.f12085d = set;
    }

    public final void mo2284a(HttpRequest httpRequest, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        super.mo2284a(httpRequest, httpContext, httpFlowStatistics);
        this.f12083b = f12082a.incrementAndGet();
        RequestInfo requestInfo = null;
        for (DebugHttpFlowReporter debugHttpFlowReporter : this.f12085d) {
            if (debugHttpFlowReporter.mo2291a()) {
                if (requestInfo == null) {
                    requestInfo = m17794a(httpRequest);
                }
                debugHttpFlowReporter.mo2289a(requestInfo);
            }
        }
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2282b(httpResponse, httpContext);
        ResponseInfo responseInfo = null;
        for (DebugHttpFlowReporter debugHttpFlowReporter : this.f12085d) {
            if (debugHttpFlowReporter.mo2291a()) {
                if (responseInfo == null) {
                    responseInfo = m17795a(httpResponse);
                }
                debugHttpFlowReporter.mo2290a(responseInfo);
            }
        }
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        super.mo2281a(stage, httpRequest, httpResponse, httpContext, iOException);
        ErrorResponseInfo errorResponseInfo = null;
        for (DebugHttpFlowReporter debugHttpFlowReporter : this.f12085d) {
            if (debugHttpFlowReporter.mo2291a()) {
                if (errorResponseInfo == null) {
                    errorResponseInfo = m17793a(stage, httpResponse, iOException);
                }
                debugHttpFlowReporter.mo2288a(errorResponseInfo);
            }
        }
    }

    @Nullable
    public final InputStream m17800a(@Nullable InputStream inputStream) {
        Object obj;
        for (DebugHttpFlowReporter a : this.f12085d) {
            if (a.mo2291a()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return inputStream;
        }
        if (inputStream == null) {
            return null;
        }
        this.f12086e = new ByteArrayOutputStream();
        return new TeeInputStream(inputStream, this.f12086e);
    }

    private RequestInfo m17794a(HttpRequest httpRequest) {
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.a = m17798f();
        requestInfo.b = m17799g();
        requestInfo.c = httpRequest;
        ByteArrayOutputStream b = m17797b(httpRequest);
        if (b != null) {
            requestInfo.d = b.toByteArray();
        }
        return requestInfo;
    }

    private ResponseInfo m17795a(HttpResponse httpResponse) {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.c = m17798f();
        responseInfo.d = m17799g();
        responseInfo.e = httpResponse;
        if (this.f12086e != null) {
            responseInfo.f = this.f12086e.toByteArray();
        }
        return responseInfo;
    }

    private ErrorResponseInfo m17793a(Stage stage, @Nullable HttpResponse httpResponse, IOException iOException) {
        ErrorResponseInfo errorResponseInfo = new ErrorResponseInfo();
        errorResponseInfo.c = m17798f();
        errorResponseInfo.d = m17799g();
        errorResponseInfo.b = stage;
        errorResponseInfo.a = "unknown";
        switch (1.a[stage.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                errorResponseInfo.a = iOException.toString();
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                errorResponseInfo.a = iOException.toString();
                errorResponseInfo.e = httpResponse;
                if (this.f12086e != null) {
                    errorResponseInfo.f = this.f12086e.toByteArray();
                    break;
                }
                break;
        }
        return errorResponseInfo;
    }

    private static ByteArrayOutputStream m17797b(HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            try {
                return m17796a(((HttpEntityEnclosingRequest) httpRequest).getEntity());
            } catch (Exception e) {
            }
        }
        return null;
    }

    private static ByteArrayOutputStream m17796a(HttpEntity httpEntity) {
        HttpEntity a = CompressionHelper.a(httpEntity);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a.writeTo(byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    private String m17798f() {
        if (this.f12084c == null) {
            if (this.f12083b == -1) {
                throw new IllegalStateException("Invoked getRequestId before beginRequest");
            }
            this.f12084c = String.valueOf(this.f12083b);
        }
        return this.f12084c;
    }

    private static long m17799g() {
        return SystemClock.uptimeMillis();
    }
}
