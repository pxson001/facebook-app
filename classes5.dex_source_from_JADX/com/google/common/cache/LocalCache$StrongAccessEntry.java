package com.google.common.cache;

import com.google.common.cache.LocalCache.NullEntry;
import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.StrongEntry;
import javax.annotation.Nullable;

/* compiled from: campaign_title */
final class LocalCache$StrongAccessEntry<K, V> extends StrongEntry<K, V> {
    volatile long f7211a = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7212b = NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7213c = NullEntry.INSTANCE;

    LocalCache$StrongAccessEntry(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public final long getAccessTime() {
        return this.f7211a;
    }

    public final void setAccessTime(long j) {
        this.f7211a = j;
    }

    public final ReferenceEntry<K, V> getNextInAccessQueue() {
        return this.f7212b;
    }

    public final void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7212b = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
        return this.f7213c;
    }

    public final void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7213c = referenceEntry;
    }
}
