package com.google.common.cache;

import com.google.common.cache.LocalCache.NullEntry;
import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.StrongEntry;
import javax.annotation.Nullable;

/* compiled from: campaign_title */
final class LocalCache$StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
    volatile long f7214a = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7215b = NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7216c = NullEntry.INSTANCE;
    volatile long f7217d = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7218e = NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7219f = NullEntry.INSTANCE;

    LocalCache$StrongAccessWriteEntry(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public final long getAccessTime() {
        return this.f7214a;
    }

    public final void setAccessTime(long j) {
        this.f7214a = j;
    }

    public final ReferenceEntry<K, V> getNextInAccessQueue() {
        return this.f7215b;
    }

    public final void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7215b = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
        return this.f7216c;
    }

    public final void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7216c = referenceEntry;
    }

    public final long getWriteTime() {
        return this.f7217d;
    }

    public final void setWriteTime(long j) {
        this.f7217d = j;
    }

    public final ReferenceEntry<K, V> getNextInWriteQueue() {
        return this.f7218e;
    }

    public final void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7218e = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
        return this.f7219f;
    }

    public final void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f7219f = referenceEntry;
    }
}
