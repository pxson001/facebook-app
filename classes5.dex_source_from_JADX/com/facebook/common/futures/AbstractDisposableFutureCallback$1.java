package com.facebook.common.futures;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: sponsored_label */
final class AbstractDisposableFutureCallback$1 extends AbstractDisposableFutureCallback<T> {
    final /* synthetic */ FutureCallback f2589a;

    AbstractDisposableFutureCallback$1(FutureCallback futureCallback) {
        this.f2589a = futureCallback;
    }

    protected final void m3694a(T t) {
        this.f2589a.onSuccess(t);
    }

    protected final void m3695a(Throwable th) {
        this.f2589a.onFailure(th);
    }
}
