package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: buy_tickets_flow */
final class ImmutableSetMultimap$EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
    @Weak
    private final transient ImmutableSetMultimap<K, V> f7349a;

    ImmutableSetMultimap$EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        this.f7349a = immutableSetMultimap;
    }

    public final boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return this.f7349a.b(entry.getKey(), entry.getValue());
    }

    public final int size() {
        return this.f7349a.f();
    }

    public final UnmodifiableIterator<Entry<K, V>> iterator() {
        return this.f7349a.v();
    }

    final boolean isPartialView() {
        return false;
    }
}
