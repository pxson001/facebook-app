package com.google.common.cache;

import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/* compiled from: campaign_title */
class LocalCache$SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
    final ReferenceEntry<K, V> f7210a;

    LocalCache$SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        super(v, referenceQueue);
        this.f7210a = referenceEntry;
    }

    public int mo872a() {
        return 1;
    }

    public final ReferenceEntry<K, V> m13164b() {
        return this.f7210a;
    }

    public final void m13163a(V v) {
    }

    public ValueReference<K, V> mo873a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new LocalCache$SoftValueReference(referenceQueue, v, referenceEntry);
    }

    public final boolean m13165c() {
        return false;
    }

    public final boolean m13166d() {
        return true;
    }

    public final V m13167e() {
        return get();
    }
}
