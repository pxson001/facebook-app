package com.facebook.logging.cdn;

import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.HttpRequestFilter;
import java.net.URI;
import org.apache.http.impl.client.RequestWrapper;

/* compiled from: registerAllViewTypes() called from outside the UI thread */
public class CdnLoggerRequestInterceptor implements HttpRequestFilter {
    public final void mo1680a(RequestWrapper requestWrapper, FbHttpRequest fbHttpRequest) {
        String uri = requestWrapper.getURI().toString();
        String b = CdnLoggerHelper.m17687b(uri);
        if (b != null) {
            try {
                requestWrapper.setURI(new URI(CdnLoggerHelper.m17686a(uri)));
                if (b.equals("ak")) {
                    requestWrapper.addHeader("Pragma", "akamai-x-cache-on, akamai-x-cache-remote-on, akamai-x-get-client-ip");
                    return;
                }
                requestWrapper.addHeader("X-FB-Debug", "True");
                requestWrapper.addHeader("X-FB-Origin-Debug", "True");
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final int mo1679a() {
        return Integer.MAX_VALUE;
    }
}
