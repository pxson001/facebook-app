package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.references.CloseableReference;

/* compiled from: or_IN */
public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {
    private final MemoryCache<K, V> f10908a;
    private final MemoryCacheTracker f10909b;

    public InstrumentedMemoryCache(MemoryCache<K, V> memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.f10908a = memoryCache;
        this.f10909b = memoryCacheTracker;
    }

    public final CloseableReference<V> mo2071a(K k) {
        CloseableReference<V> a = this.f10908a.mo2071a((Object) k);
        if (a == null) {
            this.f10909b.mo2075b();
        } else {
            this.f10909b.mo2074a();
        }
        return a;
    }

    public final CloseableReference<V> mo2072a(K k, CloseableReference<V> closeableReference) {
        this.f10909b.mo2076c();
        return this.f10908a.mo2072a(k, closeableReference);
    }

    public final int mo2070a(Predicate<K> predicate) {
        return this.f10908a.mo2070a((Predicate) predicate);
    }

    public final boolean mo2073b(Predicate<K> predicate) {
        return this.f10908a.mo2073b(predicate);
    }
}
