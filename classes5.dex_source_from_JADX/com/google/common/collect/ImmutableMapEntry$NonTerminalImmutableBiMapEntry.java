package com.google.common.collect;

import com.google.common.collect.ImmutableMapEntry.NonTerminalImmutableMapEntry;
import javax.annotation.Nullable;

/* compiled from: cache is closed */
final class ImmutableMapEntry$NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {
    private final transient ImmutableMapEntry<K, V> f7327a;

    ImmutableMapEntry$NonTerminalImmutableBiMapEntry(K k, V v, ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> immutableMapEntry2) {
        super(k, v, immutableMapEntry);
        this.f7327a = immutableMapEntry2;
    }

    @Nullable
    final ImmutableMapEntry<K, V> m13375b() {
        return this.f7327a;
    }
}
