package com.google.common.cache;

import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.ValueReference;
import java.lang.ref.ReferenceQueue;

/* compiled from: outputDisplayList */
class LocalCache$StrongValueReference<K, V> implements ValueReference<K, V> {
    final V f5754a;

    LocalCache$StrongValueReference(V v) {
        this.f5754a = v;
    }

    public V get() {
        return this.f5754a;
    }

    public int m6235a() {
        return 1;
    }

    public final ReferenceEntry<K, V> m6238b() {
        return null;
    }

    public final ValueReference<K, V> m6236a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return this;
    }

    public final boolean m6239c() {
        return false;
    }

    public final boolean m6240d() {
        return true;
    }

    public final V m6241e() {
        return get();
    }

    public final void m6237a(V v) {
    }
}
