package com.google.common.cache;

import com.google.common.cache.LocalCache.NullEntry;
import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.WeakEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

/* compiled from: campaign_title */
final class LocalCache$WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
    volatile long f7223a = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7224b = NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7225c = NullEntry.INSTANCE;
    volatile long f7226d = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7227e = NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7228f = NullEntry.INSTANCE;

    LocalCache$WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
    }

    public final long getAccessTime() {
        return this.f7223a;
    }

    public final void setAccessTime(long j) {
        this.f7223a = j;
    }

    public final ReferenceEntry<K, V> getNextInAccessQueue() {
        return this.f7224b;
    }

    public final void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7224b = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
        return this.f7225c;
    }

    public final void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7225c = referenceEntry;
    }

    public final long getWriteTime() {
        return this.f7226d;
    }

    public final void setWriteTime(long j) {
        this.f7226d = j;
    }

    public final ReferenceEntry<K, V> getNextInWriteQueue() {
        return this.f7227e;
    }

    public final void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7227e = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
        return this.f7228f;
    }

    public final void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7228f = referenceEntry;
    }
}
