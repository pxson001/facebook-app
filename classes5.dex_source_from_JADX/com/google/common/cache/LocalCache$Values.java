package com.google.common.cache;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

/* compiled from: campaign_title */
final class LocalCache$Values extends AbstractCollection<V> {
    final /* synthetic */ LocalCache f7221a;
    private final ConcurrentMap<?, ?> f7222b;

    LocalCache$Values(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
        this.f7221a = localCache;
        this.f7222b = concurrentMap;
    }

    public final int size() {
        return this.f7222b.size();
    }

    public final boolean isEmpty() {
        return this.f7222b.isEmpty();
    }

    public final void clear() {
        this.f7222b.clear();
    }

    public final Iterator<V> iterator() {
        return new LocalCache$ValueIterator(this.f7221a);
    }

    public final boolean contains(Object obj) {
        return this.f7222b.containsValue(obj);
    }

    public final Object[] toArray() {
        return LocalCache.b(this).toArray();
    }

    public final <E> E[] toArray(E[] eArr) {
        return LocalCache.b(this).toArray(eArr);
    }
}
