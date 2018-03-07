package com.facebook.analytics;

import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.Stage;
import java.io.IOException;
import java.net.URI;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: null_page_info */
public class AnalyticsHttpDataLogger extends AbstractFbHttpFlowObserver {
    private static final Class<?> f12024a = AnalyticsHttpDataLogger.class;
    private final NetworkDataLogger f12025b;

    @Inject
    public AnalyticsHttpDataLogger(NetworkDataLogger networkDataLogger) {
        this.f12025b = networkDataLogger;
    }

    private boolean m17716e() {
        return this.f12025b != null;
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2282b(httpResponse, httpContext);
        if (m17716e()) {
            m17717f();
        }
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        super.mo2281a(stage, httpRequest, httpResponse, httpContext, iOException);
        if (m17716e()) {
            m17717f();
        }
    }

    private void m17717f() {
        this.f12025b.m17739a(URI.create(m17725b().getRequestLine().getUri()), this.f12029d, m17720a(), this.f12028c);
    }
}
