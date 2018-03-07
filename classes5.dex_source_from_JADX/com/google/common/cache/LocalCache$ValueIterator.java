package com.google.common.cache;

/* compiled from: campaign_title */
final class LocalCache$ValueIterator extends LocalCache$HashIterator<V> {
    final /* synthetic */ LocalCache f7220a;

    LocalCache$ValueIterator(LocalCache localCache) {
        this.f7220a = localCache;
        super(localCache);
    }

    public final V next() {
        return m13154a().getValue();
    }
}
