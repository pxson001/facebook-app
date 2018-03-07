package com.google.common.cache;

import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

/* compiled from: campaign_title */
final class LocalCache$KeySet extends LocalCache$AbstractCacheSet<K> {
    final /* synthetic */ LocalCache f7199c;

    LocalCache$KeySet(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
        this.f7199c = localCache;
        super(localCache, concurrentMap);
    }

    public final Iterator<K> iterator() {
        return new LocalCache$KeyIterator(this.f7199c);
    }

    public final boolean contains(Object obj) {
        return this.f7184a.containsKey(obj);
    }

    public final boolean remove(Object obj) {
        return this.f7184a.remove(obj) != null;
    }
}
