package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible("unnecessary")
/* compiled from: zero_token_request_reason */
class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    /* compiled from: zero_token_request_reason */
    class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> f326a;

        NonTerminalImmutableMapEntry(K k, V v, ImmutableMapEntry<K, V> immutableMapEntry) {
            super(k, v);
            this.f326a = immutableMapEntry;
        }

        @Nullable
        final ImmutableMapEntry<K, V> mo50a() {
            return this.f326a;
        }

        final boolean mo51c() {
            return false;
        }
    }

    static <K, V> ImmutableMapEntry<K, V>[] m611a(int i) {
        return new ImmutableMapEntry[i];
    }

    ImmutableMapEntry(K k, V v) {
        super(k, v);
        CollectPreconditions.m616a((Object) k, (Object) v);
    }

    @Nullable
    ImmutableMapEntry<K, V> mo50a() {
        return null;
    }

    @Nullable
    ImmutableMapEntry<K, V> m613b() {
        return null;
    }

    boolean mo51c() {
        return true;
    }
}
