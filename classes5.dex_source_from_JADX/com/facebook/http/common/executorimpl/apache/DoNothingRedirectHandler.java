package com.facebook.http.common.executorimpl.apache;

import android.annotation.SuppressLint;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

@SuppressLint({"DeprecatedInterface"})
/* compiled from: distributeWorkLocked */
class DoNothingRedirectHandler implements RedirectHandler {
    DoNothingRedirectHandler() {
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        return false;
    }

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
        throw new UnsupportedOperationException();
    }
}
