package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: reaction_feed_type */
final class ImmutableMapKeySet<K, V> extends Indexed<K> {
    @Weak
    private final ImmutableMap<K, V> map;

    ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public final int size() {
        return this.map.size();
    }

    public final UnmodifiableIterator<K> iterator() {
        return this.map.keyIterator();
    }

    public final boolean contains(@Nullable Object obj) {
        return this.map.containsKey(obj);
    }

    final K mo1720a(int i) {
        return ((Entry) this.map.entrySet().asList().get(i)).getKey();
    }

    final boolean isPartialView() {
        return true;
    }

    @GwtIncompatible("serialization")
    final Object writeReplace() {
        return new KeySetSerializedForm(this.map);
    }
}
