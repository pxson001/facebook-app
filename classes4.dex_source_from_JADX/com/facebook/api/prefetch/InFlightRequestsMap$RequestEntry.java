package com.facebook.api.prefetch;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;

/* compiled from: sdk */
class InFlightRequestsMap$RequestEntry {
    final Collection<String> f2951a;
    final ListenableFuture f2952b;

    public InFlightRequestsMap$RequestEntry(Collection<String> collection, ListenableFuture listenableFuture) {
        this.f2951a = collection;
        this.f2952b = listenableFuture;
    }
}
