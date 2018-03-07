package com.facebook.http.common;

import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: dummy_host */
class FbHttpRequestDebugLogger$1 implements FutureCallback<T> {
    final /* synthetic */ FbHttpRequest f4923a;
    final /* synthetic */ FbHttpRequestDebugLogger f4924b;

    FbHttpRequestDebugLogger$1(FbHttpRequestDebugLogger fbHttpRequestDebugLogger, FbHttpRequest fbHttpRequest) {
        this.f4924b = fbHttpRequestDebugLogger;
        this.f4923a = fbHttpRequest;
    }

    public void onSuccess(@Nullable T t) {
        FbHttpRequestDebugLogger.a(this.f4924b, this.f4923a, null);
    }

    public void onFailure(Throwable th) {
        FbHttpRequestDebugLogger.a(this.f4924b, this.f4923a, th);
    }
}
