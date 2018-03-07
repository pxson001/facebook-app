package com.google.common.cache;

import com.google.common.cache.LocalCache.LocalManualCache;
import java.util.concurrent.Callable;

/* compiled from: campaign_title */
class LocalCache$LocalManualCache$1 extends CacheLoader<Object, V> {
    final /* synthetic */ Callable f7203a;
    final /* synthetic */ LocalManualCache f7204b;

    LocalCache$LocalManualCache$1(LocalManualCache localManualCache, Callable callable) {
        this.f7204b = localManualCache;
        this.f7203a = callable;
    }

    public final V m13160a(Object obj) {
        return this.f7203a.call();
    }
}
