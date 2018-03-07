package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_state */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private final transient Entry<K, V>[] f322a;
    private final transient ImmutableMapEntry<K, V>[] f323b;
    private final transient int f324c;

    static <K, V> RegularImmutableMap<K, V> m650a(Entry<K, V>... entryArr) {
        return m649a(entryArr.length, entryArr);
    }

    static <K, V> RegularImmutableMap<K, V> m649a(int i, Entry<K, V>[] entryArr) {
        Entry[] entryArr2;
        Preconditions.checkPositionIndex(i, entryArr.length);
        if (i == entryArr.length) {
            entryArr2 = entryArr;
        } else {
            Object[] objArr = new ImmutableMapEntry[i];
        }
        int a = Hashing.m654a(i, 1.2d);
        ImmutableMapEntry[] immutableMapEntryArr = new ImmutableMapEntry[a];
        int i2 = a - 1;
        for (int i3 = 0; i3 < i; i3++) {
            Entry entry = entryArr[i3];
            Object key = entry.getKey();
            Object value = entry.getValue();
            CollectPreconditions.m616a(key, value);
            int a2 = Hashing.m653a(key.hashCode()) & i2;
            ImmutableMapEntry immutableMapEntry = immutableMapEntryArr[a2];
            if (immutableMapEntry == null) {
                Object obj = ((entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).mo51c()) ? 1 : null;
                entry = obj != null ? (ImmutableMapEntry) entry : new ImmutableMapEntry(key, value);
            } else {
                entry = new NonTerminalImmutableMapEntry(key, value, immutableMapEntry);
            }
            immutableMapEntryArr[a2] = entry;
            entryArr2[i3] = entry;
            m652a(key, entry, immutableMapEntry);
        }
        return new RegularImmutableMap(entryArr2, immutableMapEntryArr, i2);
    }

    private RegularImmutableMap(Entry<K, V>[] entryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr, int i) {
        this.f322a = entryArr;
        this.f323b = immutableMapEntryArr;
        this.f324c = i;
    }

    static void m652a(Object obj, Entry<?, ?> entry, @Nullable ImmutableMapEntry<?, ?> immutableMapEntry) {
        while (immutableMapEntry != null) {
            ImmutableMap.checkNoConflict(!obj.equals(immutableMapEntry.getKey()), "key", entry, immutableMapEntry);
            immutableMapEntry = immutableMapEntry.mo50a();
        }
    }

    public final V get(@Nullable Object obj) {
        return m651a(obj, this.f323b, this.f324c);
    }

    @Nullable
    static <V> V m651a(@Nullable Object obj, ImmutableMapEntry<?, V>[] immutableMapEntryArr, int i) {
        if (obj == null) {
            return null;
        }
        for (ImmutableEntry immutableEntry = immutableMapEntryArr[Hashing.m653a(obj.hashCode()) & i]; immutableEntry != null; immutableEntry = immutableEntry.mo50a()) {
            if (obj.equals(immutableEntry.getKey())) {
                return immutableEntry.getValue();
            }
        }
        return null;
    }

    public final int size() {
        return this.f322a.length;
    }

    final boolean isPartialView() {
        return false;
    }

    final ImmutableSet<Entry<K, V>> createEntrySet() {
        return new RegularEntrySet(this, this.f322a);
    }
}
