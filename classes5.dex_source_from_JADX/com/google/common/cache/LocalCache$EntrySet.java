package com.google.common.cache;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

/* compiled from: campaign_title */
final class LocalCache$EntrySet extends LocalCache$AbstractCacheSet<Entry<K, V>> {
    final /* synthetic */ LocalCache f7197c;

    LocalCache$EntrySet(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
        this.f7197c = localCache;
        super(localCache, concurrentMap);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new LocalCache$EntryIterator(this.f7197c);
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        if (key == null) {
            return false;
        }
        key = this.f7197c.get(key);
        if (key == null || !this.f7197c.g.equivalent(entry.getValue(), key)) {
            return false;
        }
        return true;
    }

    public final boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        if (key == null || !this.f7197c.remove(key, entry.getValue())) {
            return false;
        }
        return true;
    }
}
