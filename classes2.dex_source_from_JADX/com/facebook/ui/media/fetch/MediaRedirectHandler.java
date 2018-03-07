package com.facebook.ui.media.fetch;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.facebook.analytics.webrequest.WebRequestCounters;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

@SuppressLint({"DeprecatedInterface"})
/* compiled from: measurement.service_client_enabled */
public class MediaRedirectHandler implements RedirectHandler {
    private static final Class<?> f14721a = MediaRedirectHandler.class;
    private Uri f14722b;
    private final WebRequestCounters f14723c;

    public MediaRedirectHandler(Uri uri, WebRequestCounters webRequestCounters) {
        this.f14722b = uri;
        this.f14723c = webRequestCounters;
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        boolean z = statusCode == 302 || statusCode == 301;
        return z;
    }

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
        Uri a = m21138a(httpResponse, this.f14722b);
        this.f14722b = a;
        String uri = a.toString();
        this.f14723c.m16002b(uri);
        return URI.create(uri);
    }

    private static Uri m21138a(HttpResponse httpResponse, Uri uri) {
        Header firstHeader = httpResponse.getFirstHeader("Location");
        if (firstHeader == null) {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no Location header");
        }
        Uri parse = Uri.parse(firstHeader.getValue());
        if (parse.isAbsolute()) {
            return parse;
        }
        return Uri.parse(URI.create(uri.toString()).resolve(URI.create(parse.toString())).toString());
    }
}
