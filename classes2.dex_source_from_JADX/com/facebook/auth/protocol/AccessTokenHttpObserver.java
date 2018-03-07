package com.facebook.auth.protocol;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: notifications_read */
public class AccessTokenHttpObserver extends AbstractFbHttpFlowObserver {
    private final LoggedInUserSessionManager f12092a;

    @Inject
    public AccessTokenHttpObserver(LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f12092a = loggedInUserSessionManager;
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2285a(httpResponse, httpContext);
        if (httpResponse.containsHeader("X-FB-Updated-Access-Token") && (m17725b() instanceof HttpUriRequest)) {
            HttpUriRequest httpUriRequest = (HttpUriRequest) m17725b();
            if (httpUriRequest.containsHeader("Authorization") && httpUriRequest.getURI().getHost().endsWith(".facebook.com") && httpUriRequest.getURI().getScheme().equals("https")) {
                String substring;
                String value = httpUriRequest.getFirstHeader("Authorization").getValue();
                if (value.startsWith("OAuth ")) {
                    substring = value.substring(6);
                } else {
                    substring = "";
                }
                value = substring;
                String value2 = httpResponse.getFirstHeader("X-FB-Updated-Access-Token").getValue();
                if (value2.length() > 0) {
                    this.f12092a.m2521a(value, value2);
                }
            }
        }
    }
}
