package com.facebook.http.observer;

import com.google.common.base.Preconditions;
import java.io.IOException;
import javax.annotation.Nullable;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: null_edges */
public abstract class AbstractFbHttpFlowObserver implements FbHttpFlowObserver {
    private HttpRequest f12026a;
    private HttpContext f12027b;
    public HttpResponse f12028c;
    public HttpFlowStatistics f12029d;

    protected final HttpContext m17720a() {
        Preconditions.checkState(this.f12026a != null, "Did you forget to call super.beginRequest?");
        return this.f12027b;
    }

    protected final HttpRequest m17725b() {
        Preconditions.checkState(this.f12026a != null, "Did you forget to call super.beginRequest?");
        return this.f12026a;
    }

    public void mo2284a(HttpRequest httpRequest, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        this.f12026a = httpRequest;
        this.f12027b = httpContext;
        this.f12029d = (HttpFlowStatistics) Preconditions.checkNotNull(httpFlowStatistics);
    }

    public void mo2283a(HttpRequest httpRequest, HttpContext httpContext) {
        boolean z = true;
        Preconditions.checkState(m17725b() != null);
        if (m17720a() == null) {
            z = false;
        }
        Preconditions.checkState(z);
        this.f12026a = httpRequest;
        this.f12027b = httpContext;
    }

    public void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        this.f12028c = httpResponse;
        Preconditions.checkState(m17720a() == httpContext);
    }

    public void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        boolean z;
        boolean z2 = true;
        if (this.f12028c == httpResponse) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (m17720a() != httpContext) {
            z2 = false;
        }
        Preconditions.checkState(z2);
    }

    public void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        boolean z;
        Preconditions.checkState(iOException != null);
        if (m17725b() == httpRequest) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (m17720a() == httpContext) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.f12028c == httpResponse) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "stored %s, passed %s", this.f12028c, httpResponse);
    }
}
