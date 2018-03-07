package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import java.util.concurrent.Callable;

/* compiled from: TRANSPORT_FREIGHT */
class BufferedDiskCache$1 implements Callable<Boolean> {
    final /* synthetic */ CacheKey f13679a;
    final /* synthetic */ BufferedDiskCache f13680b;

    BufferedDiskCache$1(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
        this.f13680b = bufferedDiskCache;
        this.f13679a = cacheKey;
    }

    public Object call() {
        return Boolean.valueOf(BufferedDiskCache.d(this.f13680b, this.f13679a));
    }
}
