package com.facebook.common.futures;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: sponsored_data */
public class ChainableFutureCallback<V> implements FutureCallback<V> {
    private AbstractChainableFuture<V> f2590a;

    public ChainableFutureCallback(AbstractChainableFuture<V> abstractChainableFuture) {
        this.f2590a = abstractChainableFuture;
    }

    public void onSuccess(V v) {
        this.f2590a.a(v);
    }

    public void onFailure(Throwable th) {
        this.f2590a.a(th);
    }
}
