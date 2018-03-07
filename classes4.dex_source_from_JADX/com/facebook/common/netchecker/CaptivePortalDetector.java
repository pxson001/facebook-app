package com.facebook.common.netchecker;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessor;
import java.io.IOException;
import java.net.URI;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HttpContext;

/* compiled from: mSystemControl */
public class CaptivePortalDetector {
    private static final RedirectHandler f8538c = new C04091();
    private static final ResponseHandler<NetCheckState> f8539d = new C04102();
    private final FbHttpRequestProcessor f8540a;
    private final GatekeeperStoreImpl f8541b;

    /* compiled from: mSystemControl */
    final class C04091 implements RedirectHandler {
        C04091() {
        }

        public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return false;
        }

        public final URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: mSystemControl */
    final class C04102 implements ResponseHandler<NetCheckState> {
        C04102() {
        }

        public final Object handleResponse(HttpResponse httpResponse) {
            return httpResponse.getStatusLine().getStatusCode() == 204 ? NetCheckState.NOT_CAPTIVE_PORTAL : NetCheckState.CAPTIVE_PORTAL;
        }
    }

    @Inject
    public CaptivePortalDetector(FbHttpRequestProcessor fbHttpRequestProcessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f8540a = fbHttpRequestProcessor;
        this.f8541b = gatekeeperStoreImpl;
    }

    final NetCheckState m8796a() {
        try {
            Builder a = FbHttpRequest.newBuilder().a(f8538c).a(f8539d);
            if (this.f8541b.a(176, false)) {
                a.a(new HttpGet("http://portal.fb.com/mobile/status.php")).a("CaptivePortalDetector");
            } else {
                a.a(new HttpGet("http://b-www.facebook.com/mobile/status.php"));
            }
            return (NetCheckState) this.f8540a.a(a.a());
        } catch (IOException e) {
            return NetCheckState.NOT_CAPTIVE_PORTAL;
        }
    }
}
