package com.facebook.http.common;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import org.apache.http.client.HttpRequestRetryHandler;

/* compiled from: download_url */
public class HttpRequestRetryHandler_DefaultRetryHandlerMethodAutoProvider extends AbstractProvider<HttpRequestRetryHandler> {
    public Object get() {
        return FbHttpModule.d();
    }

    public static HttpRequestRetryHandler m9869a(InjectorLike injectorLike) {
        return FbHttpModule.d();
    }
}
