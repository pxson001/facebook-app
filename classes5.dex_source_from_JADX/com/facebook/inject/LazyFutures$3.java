package com.facebook.inject;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: delta_hash */
public final class LazyFutures$3 extends LazyFuture<T> {
    final /* synthetic */ Lazy f5133a;
    final /* synthetic */ AsyncFunction f5134b;
    final /* synthetic */ Executor f5135c;

    public LazyFutures$3(Lazy lazy, AsyncFunction asyncFunction, Executor executor) {
        this.f5133a = lazy;
        this.f5134b = asyncFunction;
        this.f5135c = executor;
    }

    protected final ListenableFuture<T> m10020a() {
        return Futures.b((ListenableFuture) this.f5133a.get(), this.f5134b, this.f5135c);
    }
}
