package com.facebook.inject;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: method/user.register */
public abstract class LazyFuture<V> implements Lazy<ListenableFuture<V>> {
    private ListenableFuture<V> f13552a = null;

    protected abstract ListenableFuture<V> mo2649a();

    public Object get() {
        ListenableFuture listenableFuture;
        synchronized (this) {
            if (this.f13552a == null) {
                this.f13552a = mo2649a();
            }
            listenableFuture = this.f13552a;
        }
        return listenableFuture;
    }
}
