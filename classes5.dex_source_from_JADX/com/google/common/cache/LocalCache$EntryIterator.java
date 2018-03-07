package com.google.common.cache;

import java.util.Map.Entry;

/* compiled from: campaign_title */
final class LocalCache$EntryIterator extends LocalCache$HashIterator<Entry<K, V>> {
    final /* synthetic */ LocalCache f7196a;

    LocalCache$EntryIterator(LocalCache localCache) {
        this.f7196a = localCache;
        super(localCache);
    }

    public final Object next() {
        return m13154a();
    }
}
