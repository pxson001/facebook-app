package com.facebook.http.common;

import com.facebook.http.interfaces.RequestPriority;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: recent_vpv_state */
public interface FbHttpRequestEngine {
    <T> ListenableFuture<T> mo1693a(FbHttpRequest<T> fbHttpRequest);

    void mo1694a();

    void mo1695a(FbHttpRequest<?> fbHttpRequest, RequestPriority requestPriority);

    void mo1696a(@Nullable String str, @Nullable String str2);

    RequestProcessorSnapshot mo1697b();

    boolean mo1698b(FbHttpRequest<?> fbHttpRequest);

    String mo1699c();

    String mo1700d();

    String mo1701e();
}
