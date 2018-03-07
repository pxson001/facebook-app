package com.facebook.http.common;

import com.facebook.http.interfaces.RequestPriority;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: num_rows */
public class HttpFutureWrapper<T> {
    private FbHttpRequest<T> f11894a;
    public ListenableFuture<T> f11895b;
    private FbHttpRequestProcessor f11896c;

    public HttpFutureWrapper(FbHttpRequest<T> fbHttpRequest, ListenableFuture<T> listenableFuture, FbHttpRequestProcessor fbHttpRequestProcessor) {
        this.f11894a = fbHttpRequest;
        this.f11895b = listenableFuture;
        this.f11896c = fbHttpRequestProcessor;
    }

    public final ListenableFuture<T> m17398a() {
        return this.f11895b;
    }

    public final void m17400b() {
        this.f11896c.m12272c(this.f11894a);
    }

    public final void m17399a(RequestPriority requestPriority) {
        this.f11896c.m12268a(this.f11894a, requestPriority);
    }
}
