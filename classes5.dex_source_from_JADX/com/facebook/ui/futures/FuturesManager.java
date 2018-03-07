package com.facebook.ui.futures;

import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
/* compiled from: comments */
public class FuturesManager {
    private final Map<ListenableFuture<?>, FutureAndCallbackHolder<?>> f5476a = Maps.c();

    public static FuturesManager m10343a(InjectorLike injectorLike) {
        return new FuturesManager();
    }

    public final synchronized void m10344a() {
        Iterator it = this.f5476a.entrySet().iterator();
        while (it.hasNext()) {
            ((FutureAndCallbackHolder) ((Entry) it.next()).getValue()).a(true);
            it.remove();
        }
    }

    public final synchronized void m10345a(FutureAndCallbackHolder<?> futureAndCallbackHolder) {
        this.f5476a.put(futureAndCallbackHolder.a(), futureAndCallbackHolder);
    }

    public final synchronized void m10346a(ListenableFuture<?> listenableFuture) {
        if (listenableFuture != null) {
            this.f5476a.remove(listenableFuture);
        }
    }
}
