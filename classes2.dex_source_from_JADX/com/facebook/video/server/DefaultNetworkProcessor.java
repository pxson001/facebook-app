package com.facebook.video.server;

import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.RequestPriority;

/* compiled from: offlineMessageId */
public class DefaultNetworkProcessor {
    public final FbHttpRequestProcessor f11455a;

    public DefaultNetworkProcessor(FbHttpRequestProcessor fbHttpRequestProcessor) {
        this.f11455a = fbHttpRequestProcessor;
    }

    public final <T> T m16735b(FbHttpRequest<T> fbHttpRequest) {
        return this.f11455a.m12267a((FbHttpRequest) fbHttpRequest);
    }

    public final void m16734a(FbHttpRequest<?> fbHttpRequest, RequestPriority requestPriority) {
        this.f11455a.m12268a(fbHttpRequest, requestPriority);
    }

    public final boolean m16736c(FbHttpRequest<?> fbHttpRequest) {
        return this.f11455a.m12272c(fbHttpRequest);
    }
}
