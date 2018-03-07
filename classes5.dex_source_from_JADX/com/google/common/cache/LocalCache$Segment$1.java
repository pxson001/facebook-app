package com.google.common.cache;

import com.google.common.cache.LocalCache.LoadingValueReference;
import com.google.common.cache.LocalCache.Segment;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;

/* compiled from: campaign_title */
class LocalCache$Segment$1 implements Runnable {
    final /* synthetic */ Object f7205a;
    final /* synthetic */ int f7206b;
    final /* synthetic */ LoadingValueReference f7207c;
    final /* synthetic */ ListenableFuture f7208d;
    final /* synthetic */ Segment f7209e;

    LocalCache$Segment$1(Segment segment, Object obj, int i, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
        this.f7209e = segment;
        this.f7205a = obj;
        this.f7206b = i;
        this.f7207c = loadingValueReference;
        this.f7208d = listenableFuture;
    }

    public void run() {
        try {
            this.f7209e.a(this.f7205a, this.f7206b, this.f7207c, this.f7208d);
        } catch (Throwable th) {
            LocalCache.a.log(Level.WARNING, "Exception thrown during refresh", th);
            this.f7207c.a(th);
        }
    }
}
