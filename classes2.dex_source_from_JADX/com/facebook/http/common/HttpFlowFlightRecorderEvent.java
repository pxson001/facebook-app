package com.facebook.http.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.facebook.common.flightrecorder.FlightRecorderEvent;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.TriState;
import com.facebook.http.observer.ByteCounter;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.RequestContext;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.net.URI;
import javax.annotation.Nullable;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

@SuppressLint({"UsingDefaultJsonDeserializer"})
/* compiled from: notifications/ */
public class HttpFlowFlightRecorderEvent implements FlightRecorderEvent {
    private static final Class<?> f12104a = HttpFlowFlightRecorderEvent.class;
    public final MonotonicClock f12105b;
    private final NetworkDataLogUtils f12106c;
    public long f12107d = -1;
    public String f12108e;
    public String f12109f;
    public String f12110g;
    public String f12111h;
    public String f12112i;
    public String f12113j;
    public String f12114k;
    public String f12115l;
    public String f12116m;
    public int f12117n = -1;
    public long f12118o = -1;
    public HttpFlowStatistics f12119p;
    public long f12120q = -1;
    public long f12121r;

    public HttpFlowFlightRecorderEvent(MonotonicClock monotonicClock, NetworkDataLogUtils networkDataLogUtils) {
        this.f12105b = monotonicClock;
        this.f12106c = networkDataLogUtils;
    }

    @JsonProperty("start_time")
    public long getStartTime() {
        return this.f12107d;
    }

    public static void m17823a(ToStringHelper toStringHelper, String str, ByteCounter byteCounter) {
        Preconditions.checkNotNull(byteCounter);
        long j = byteCounter.f12005a;
        if (j >= 0) {
            toStringHelper.add(str, j);
        }
    }

    public final void m17826a(HttpRequest httpRequest, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        this.f12107d = this.f12105b.now();
        this.f12108e = "inFlight";
        m17824c();
        this.f12109f = RequestContext.m17674a(httpContext).f11977a;
        this.f12110g = RequestContext.m17674a(httpContext).f11978b;
        this.f12121r = RequestContext.m17674a(httpContext).f11979c;
        URI uri = httpRequest instanceof HttpUriRequest ? ((HttpUriRequest) httpRequest).getURI() : URI.create(httpRequest.getRequestLine().getUri());
        this.f12111h = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()).toURI();
        this.f12113j = SecureHashUtil.b(httpRequest.getRequestLine().getUri());
        this.f12119p = httpFlowStatistics;
    }

    public final void m17827a(HttpResponse httpResponse) {
        m17824c();
        this.f12117n = httpResponse.getStatusLine().getStatusCode();
        this.f12118o = NetworkDataLogUtils.m15997c(httpResponse);
        if (httpResponse.containsHeader("X-FB-Connection-Quality")) {
            this.f12116m = httpResponse.getFirstHeader("X-FB-Connection-Quality").getValue();
        }
        TriState triState = this.f12119p.f11995b;
        if (triState.isSet()) {
            this.f12115l = triState.toString();
        }
    }

    public final void m17828a(@Nullable HttpResponse httpResponse, IOException iOException) {
        m17824c();
        this.f12108e = "error";
        this.f12120q = this.f12105b.now();
        this.f12114k = m17822a((Throwable) iOException);
        if (httpResponse != null) {
            this.f12117n = httpResponse.getStatusLine().getStatusCode();
        }
    }

    @VisibleForTesting
    private static String m17822a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        Throwable th2 = null;
        Throwable th3 = th;
        while (th3 != null) {
            if (th2 != null) {
                stringBuilder.append(" -> ");
            }
            if (th2 == null || !Objects.equal(th3.getMessage(), th2.getMessage())) {
                stringBuilder.append(th3.toString());
            } else {
                stringBuilder.append(th3.getClass().getName());
            }
            th2 = th3;
            th3 = th3.getCause();
        }
        return stringBuilder.toString();
    }

    @Nullable
    private void m17824c() {
        if (TextUtils.isEmpty(this.f12112i) && this.f12119p != null && this.f12119p.f11998e != null) {
            this.f12112i = this.f12119p.f11998e;
        }
    }

    public final String mo2286a() {
        ToStringHelper toStringHelper = new ToStringHelper(this.f12108e);
        if (this.f12107d != -1) {
            long j;
            if (this.f12120q > 0) {
                j = this.f12120q;
            } else {
                j = this.f12105b.now();
            }
            toStringHelper.add("duration_ms", j - this.f12107d);
        }
        if (this.f12109f != null) {
            toStringHelper.add("request_name", (Object) this.f12109f);
        }
        if (this.f12110g != null) {
            toStringHelper.add("request_priority", (Object) this.f12110g);
        }
        toStringHelper.add("creation_to_stage_time", this.f12121r);
        if (this.f12111h != null) {
            toStringHelper.add("host", (Object) this.f12111h);
        }
        if (this.f12112i != null) {
            toStringHelper.add("ip_addr", (Object) this.f12112i);
        }
        if (this.f12113j != null) {
            toStringHelper.add("uri_md5", (Object) this.f12113j);
        }
        if (this.f12117n != -1) {
            toStringHelper.add("response_code", this.f12117n);
        }
        if (this.f12119p != null) {
            m17823a(toStringHelper, "body_bytes_sent", this.f12119p.requestBodyBytes);
            m17823a(toStringHelper, "body_bytes_read", this.f12119p.responseBodyBytes);
            m17823a(toStringHelper, "bytes_read_by_app", this.f12119p.bytesReadByApp);
        }
        if (this.f12118o != -1) {
            toStringHelper.add("content_length", this.f12118o);
        }
        if (this.f12115l != null) {
            toStringHelper.add("using_spdy", this.f12115l);
        }
        if (this.f12116m != null) {
            toStringHelper.add("connection_quality", this.f12116m);
        }
        if (this.f12114k != null) {
            toStringHelper.add("exception", (Object) this.f12114k);
        }
        return toStringHelper.toString();
    }
}
