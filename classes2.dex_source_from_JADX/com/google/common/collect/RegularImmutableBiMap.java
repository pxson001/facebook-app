package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapEntry.NonTerminalImmutableBiMapEntry;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: work_groups_tab */
public class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    public static final RegularImmutableBiMap<Object, Object> f695a = new RegularImmutableBiMap(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    private final transient ImmutableMapEntry<K, V>[] f696b;
    public final transient ImmutableMapEntry<K, V>[] f697c;
    public final transient Entry<K, V>[] f698d;
    public final transient int f699e;
    public final transient int f700f;
    private transient ImmutableBiMap<V, K> f701g;

    public final /* synthetic */ BiMap a_() {
        return mo73e();
    }

    public static <K, V> RegularImmutableBiMap<K, V> m1432a(int i, Entry<K, V>[] entryArr) {
        Entry[] entryArr2;
        Preconditions.checkPositionIndex(i, entryArr.length);
        int a = Hashing.m654a(i, 1.2d);
        int i2 = a - 1;
        ImmutableMapEntry[] a2 = ImmutableMapEntry.m611a(a);
        ImmutableMapEntry[] a3 = ImmutableMapEntry.m611a(a);
        if (i == entryArr.length) {
            entryArr2 = entryArr;
        } else {
            entryArr2 = ImmutableMapEntry.m611a(i);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            ImmutableMapEntry immutableMapEntry;
            Entry entry = entryArr[i4];
            Object key = entry.getKey();
            Object value = entry.getValue();
            CollectPreconditions.m616a(key, value);
            int hashCode = key.hashCode();
            int hashCode2 = value.hashCode();
            int a4 = Hashing.m653a(hashCode) & i2;
            int a5 = Hashing.m653a(hashCode2) & i2;
            ImmutableMapEntry immutableMapEntry2 = a2[a4];
            RegularImmutableMap.m652a(key, entry, immutableMapEntry2);
            ImmutableMapEntry immutableMapEntry3 = a3[a5];
            m1433a(value, entry, immutableMapEntry3);
            if (immutableMapEntry3 == null && immutableMapEntry2 == null) {
                Object obj = ((entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).mo51c()) ? 1 : null;
                immutableMapEntry = obj != null ? (ImmutableMapEntry) entry : new ImmutableMapEntry(key, value);
            } else {
                immutableMapEntry = new NonTerminalImmutableBiMapEntry(key, value, immutableMapEntry2, immutableMapEntry3);
            }
            a2[a4] = immutableMapEntry;
            a3[a5] = immutableMapEntry;
            entryArr2[i4] = immutableMapEntry;
            i3 += hashCode ^ hashCode2;
        }
        return new RegularImmutableBiMap(a2, a3, entryArr2, i2, i3);
    }

    private RegularImmutableBiMap(ImmutableMapEntry<K, V>[] immutableMapEntryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr2, Entry<K, V>[] entryArr, int i, int i2) {
        this.f696b = immutableMapEntryArr;
        this.f697c = immutableMapEntryArr2;
        this.f698d = entryArr;
        this.f699e = i;
        this.f700f = i2;
    }

    private static void m1433a(Object obj, Entry<?, ?> entry, @Nullable ImmutableMapEntry<?, ?> immutableMapEntry) {
        while (immutableMapEntry != null) {
            ImmutableMap.checkNoConflict(!obj.equals(immutableMapEntry.getValue()), "value", entry, immutableMapEntry);
            immutableMapEntry = immutableMapEntry.m613b();
        }
    }

    @Nullable
    public V get(@Nullable Object obj) {
        return this.f696b == null ? null : RegularImmutableMap.m651a(obj, this.f696b, this.f699e);
    }

    ImmutableSet<Entry<K, V>> createEntrySet() {
        return isEmpty() ? RegularImmutableSet.f688a : new RegularEntrySet(this, this.f698d);
    }

    boolean isHashCodeFast() {
        return true;
    }

    public int hashCode() {
        return this.f700f;
    }

    boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.f698d.length;
    }

    public final ImmutableBiMap<V, K> mo73e() {
        if (isEmpty()) {
            return f695a;
        }
        ImmutableBiMap<V, K> immutableBiMap = this.f701g;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        immutableBiMap = new Inverse(this);
        this.f701g = immutableBiMap;
        return immutableBiMap;
    }
}
