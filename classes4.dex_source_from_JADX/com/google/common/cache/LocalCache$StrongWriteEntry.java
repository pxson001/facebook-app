package com.google.common.cache;

import com.google.common.cache.LocalCache.NullEntry;
import com.google.common.cache.LocalCache.ReferenceEntry;
import javax.annotation.Nullable;

/* compiled from: outputDisplayList */
final class LocalCache$StrongWriteEntry<K, V> extends LocalCache$StrongEntry<K, V> {
    volatile long f5747a = Long.MAX_VALUE;
    ReferenceEntry<K, V> f5748b = NullEntry.INSTANCE;
    ReferenceEntry<K, V> f5749c = NullEntry.INSTANCE;

    LocalCache$StrongWriteEntry(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public final long getWriteTime() {
        return this.f5747a;
    }

    public final void setWriteTime(long j) {
        this.f5747a = j;
    }

    public final ReferenceEntry<K, V> getNextInWriteQueue() {
        return this.f5748b;
    }

    public final void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f5748b = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
        return this.f5749c;
    }

    public final void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f5749c = referenceEntry;
    }
}
