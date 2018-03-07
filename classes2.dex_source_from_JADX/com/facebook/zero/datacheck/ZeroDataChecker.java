package com.facebook.zero.datacheck;

import android.net.Uri;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.Stage;
import com.google.common.base.Strings;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HttpContext;

/* compiled from: note/%s */
public class ZeroDataChecker extends AbstractFbHttpFlowObserver {
    private static final Class<?> f12159a = ZeroDataChecker.class;
    private ZeroDataCheckerState f12160b;
    public Provider<String> f12161c;
    private Provider<Boolean> f12162d;
    private final FbAppType f12163e;

    private int m17863f() {
        HttpResponse httpResponse = this.f12028c;
        if (httpResponse != null) {
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine != null) {
                return statusLine.getStatusCode();
            }
        }
        return -1;
    }

    @Inject
    public ZeroDataChecker(ZeroDataCheckerState zeroDataCheckerState, Provider<String> provider, Provider<Boolean> provider2, FbAppType fbAppType) {
        this.f12160b = zeroDataCheckerState;
        this.f12161c = provider;
        this.f12162d = provider2;
        this.f12163e = fbAppType;
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2282b(httpResponse, httpContext);
        m17862e();
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        super.mo2281a(stage, httpRequest, httpResponse, httpContext, iOException);
        m17862e();
    }

    private void m17862e() {
        String uri = m17725b().getRequestLine().getUri();
        String host = Uri.parse(uri).getHost();
        if (((Boolean) this.f12162d.get()).booleanValue()) {
            Object obj;
            if (Strings.isNullOrEmpty((String) this.f12161c.get())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null && this.f12163e.j == Product.FB4A) {
                if (host == null) {
                    this.f12160b.m8462b();
                } else if (host.equals("h.facebook.com") || host.equals("b-api.facebook.com") || host.equals("b-graph.facebook.com") || host.equals("b-www.facebook.com") || host.equals("b-m.facebook.com") || host.equals("free.facebook.com") || host.equals("static.0.facebook.com") || host.equals("static-0.facebook.com")) {
                    this.f12160b.m8460a(m17863f(), uri);
                } else {
                    this.f12160b.m8463b(m17863f(), uri);
                }
            }
        }
    }
}
