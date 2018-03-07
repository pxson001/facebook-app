package com.google.common.cache;

import com.google.j2objc.annotations.Weak;
import java.util.AbstractSet;
import java.util.concurrent.ConcurrentMap;

/* compiled from: campaign_title */
public abstract class LocalCache$AbstractCacheSet<T> extends AbstractSet<T> {
    @Weak
    final ConcurrentMap<?, ?> f7184a;
    final /* synthetic */ LocalCache f7185b;

    LocalCache$AbstractCacheSet(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
        this.f7185b = localCache;
        this.f7184a = concurrentMap;
    }

    public int size() {
        return this.f7184a.size();
    }

    public boolean isEmpty() {
        return this.f7184a.isEmpty();
    }

    public void clear() {
        this.f7184a.clear();
    }

    public Object[] toArray() {
        return LocalCache.b(this).toArray();
    }

    public <E> E[] toArray(E[] eArr) {
        return LocalCache.b(this).toArray(eArr);
    }
}
