package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import javax.annotation.Nullable;

/* compiled from: bytes_downloaded */
final class ImmutableMultimap$Values<K, V> extends ImmutableCollection<V> {
    @Weak
    private final transient ImmutableMultimap<K, V> f7338a;

    ImmutableMultimap$Values(ImmutableMultimap<K, V> immutableMultimap) {
        this.f7338a = immutableMultimap;
    }

    public final boolean contains(@Nullable Object obj) {
        return this.f7338a.g(obj);
    }

    public final UnmodifiableIterator<V> iterator() {
        return this.f7338a.x();
    }

    @GwtIncompatible("not present in emulated superclass")
    final int copyIntoArray(Object[] objArr, int i) {
        UnmodifiableIterator it = this.f7338a.b.values().iterator();
        while (it.hasNext()) {
            i = ((ImmutableCollection) it.next()).copyIntoArray(objArr, i);
        }
        return i;
    }

    public final int size() {
        return this.f7338a.f();
    }

    final boolean isPartialView() {
        return true;
    }
}
