package com.google.common.cache;

import com.google.common.cache.LocalCache.NullEntry;
import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.WeakEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

/* compiled from: campaign_title */
final class LocalCache$WeakWriteEntry<K, V> extends WeakEntry<K, V> {
    volatile long f7229a = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7230b = NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7231c = NullEntry.INSTANCE;

    LocalCache$WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
    }

    public final long getWriteTime() {
        return this.f7229a;
    }

    public final void setWriteTime(long j) {
        this.f7229a = j;
    }

    public final ReferenceEntry<K, V> getNextInWriteQueue() {
        return this.f7230b;
    }

    public final void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7230b = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
        return this.f7231c;
    }

    public final void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7231c = referenceEntry;
    }
}
