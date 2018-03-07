package com.google.common.cache;

/* compiled from: campaign_title */
final class LocalCache$KeyIterator extends LocalCache$HashIterator<K> {
    final /* synthetic */ LocalCache f7198a;

    LocalCache$KeyIterator(LocalCache localCache) {
        this.f7198a = localCache;
        super(localCache);
    }

    public final K next() {
        return m13154a().getKey();
    }
}
