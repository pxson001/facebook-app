package com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: cache_ids */
abstract class ImmutableMap$IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
    abstract UnmodifiableIterator<Entry<K, V>> mo925a();

    ImmutableMap$IteratorBasedImmutableMap() {
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    ImmutableSet<Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet<K, V>() {
            final ImmutableMap<K, V> m13373a() {
                return ImmutableMap$IteratorBasedImmutableMap.this;
            }

            public UnmodifiableIterator<Entry<K, V>> iterator() {
                return ImmutableMap$IteratorBasedImmutableMap.this.mo925a();
            }
        };
    }
}
