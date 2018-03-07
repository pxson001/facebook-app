package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Future;

/* compiled from: mqtt/connect_state */
public abstract class ForwardingListenableFuture$SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
    private final ListenableFuture<V> f7503a;

    protected final /* synthetic */ Future m7804a() {
        return m7805b();
    }

    protected final /* synthetic */ Object m7806e() {
        return m7805b();
    }

    protected ForwardingListenableFuture$SimpleForwardingListenableFuture(ListenableFuture<V> listenableFuture) {
        this.f7503a = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    protected final ListenableFuture<V> m7805b() {
        return this.f7503a;
    }
}
